package org.ldv.sio.getap.web;

import org.ldv.sio.getap.app.Classe;
import org.ldv.sio.getap.app.FormAjoutUser;
import org.ldv.sio.getap.app.FormAjoutUsers;
import org.ldv.sio.getap.app.FormEditUser;
import org.ldv.sio.getap.app.JDBC;
import org.ldv.sio.getap.app.User;
import org.ldv.sio.getap.app.UserSearchCriteria;
import org.ldv.sio.getap.app.service.IFManagerGeTAP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Web controller for hotel related actions.
 */
@Controller
@RequestMapping("/admin/*")
public class AdminController {

	@Autowired
	@Qualifier("DBServiceMangager")
	private IFManagerGeTAP manager;

	@Autowired
	private JDBC jdbc;

	public void setManagerEleve(IFManagerGeTAP serviceManager) {
		this.manager = serviceManager;
	}

	public void setJdbc(JDBC jdbc) {
		this.jdbc = jdbc;
	}

	/**
	 * Default action, displays the use case page.
	 * 
	 * 
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public void index() {

	}

	@RequestMapping(value = "ajoutUser", method = RequestMethod.GET)
	public String ajoutUser(FormAjoutUser formAjout, Model model) {

		model.addAttribute("lesClasses", manager.getAllClasse());
		model.addAttribute("lesRoles", manager.getAllRole());

		return "admin/ajoutUser";
	}

	@RequestMapping(value = "doajout", method = RequestMethod.POST)
	public String doajoutUser(FormAjoutUser formAjout,
			BindingResult bindResult, Model model) {
		System.out.println("TEST :" + formAjout.getId());
		System.out.println("TEST classe ID et Nom :" + formAjout.classe());
		System.out.println("TEST role :" + formAjout.getRoleNom());
		System.out.println("TEST :" + model);

		if (bindResult.hasErrors())
			return "admin/ajoutUser";
		else {
			Classe classe = manager.getClasseById(formAjout.getClasseId());
			System.out.println(classe);

			if (formAjout.getRoleNom().equals("prof-intervenant")
					|| formAjout.getRoleNom().equals("admin"))
				classe = null;

			User user = new User(null, formAjout.getPrenom(),
					formAjout.getNom(), classe, formAjout.getRoleNom());

			manager.addUser(user);

			return "redirect:/app/admin/index";
		}
	}

	@RequestMapping(value = "searchUser", method = RequestMethod.GET)
	public void searchUser(UserSearchCriteria userSearchCriteria) {

	}

	/**
	 * @param userSearchCriteria
	 * @param bindResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "dosearchUser", method = RequestMethod.GET)
	public String search(UserSearchCriteria userSearchCriteria,
			BindingResult bindResult, Model model) {

		if (userSearchCriteria.getQuery() == null
				|| "".equals(userSearchCriteria.getQuery())) {
			bindResult.rejectValue("query", "required",
					"Please enter valid search criteria");
		}
		if (bindResult.hasErrors()) {
			return "admin/searchUser";
		} else {
			model.addAttribute("users", manager.search(userSearchCriteria));
			return "admin/dosearchUser";
		}
	}

	@RequestMapping(value = "editUser", method = RequestMethod.GET)
	public String editUserById(@RequestParam("id") String id,
			FormEditUser formUser, Model model) {

		System.out.println("TEST id recu :" + formUser.getId());

		User currentUser = manager.getUserById(Long.valueOf(id));
		System.out.println(currentUser);

		formUser.setId(currentUser.getId());
		System.out.println("TEST id : " + currentUser.getId());
		formUser.setNom(currentUser.getNom());
		System.out.println("TEST nom : " + currentUser.getNom());
		formUser.setPrenom(currentUser.getPrenom());
		System.out.println("TEST prenom : " + currentUser.getPrenom());
		System.out.println("TEST role : " + currentUser.getRole());
		formUser.setRole(currentUser.getRole());

		if (!currentUser.getRole().equals("prof-intervenant")
				|| !currentUser.getRole().equals("admin")) {
			formUser.setClasseId(currentUser.getClasse().getId());
		}

		model.addAttribute("lesClasses", manager.getAllClasse());
		model.addAttribute("lesRoles", manager.getAllRole());

		return "admin/editUser";
	}

	@RequestMapping(value = "doEditUser", method = RequestMethod.POST)
	public String doeditUserById(FormEditUser formUser,
			BindingResult bindResult, Model model) {
		System.out.println("TEST :" + formUser.getId());
		System.out.println("TEST :" + model);
		System.out.println("TEST role :" + formUser.getRole());

		if (bindResult.hasErrors()) {
			return "admin/editUser";
		} else {

			User userForUpdate = manager.getUserById(Long.valueOf(formUser
					.getId()));

			userForUpdate.setNom(formUser.getNom());
			userForUpdate.setPrenom(formUser.getPrenom());
			userForUpdate.setRole(formUser.getRole());

			if (!formUser.getRole().equals("prof-intervenant")
					|| !formUser.getRole().equals("admin")) {
				userForUpdate.setClasse(manager.getClasseById(formUser
						.getClasseId()));
			}

			manager.updateUser(userForUpdate);

			return "redirect:/app/admin/searchUser";
		}
	}

	@RequestMapping(value = "delUser/{id}", method = RequestMethod.GET)
	public String deleteUserById(@PathVariable String id, Model model) {
		User user = manager.getUserById(Long.valueOf(id));

		if (!user.getId().equals(null)) {
			manager.deleteUser(user);
			return "redirect:/app/admin/searchUser";
		} else {
			return "redirect:/app/admin/index";
		}

	}

	@RequestMapping(value = "ajoutUsers", method = RequestMethod.GET)
	public String ajoutUsers(FormAjoutUsers file, Model model) {

		return "admin/ajoutUsers";
	}

	@RequestMapping(value = "doajouts", method = RequestMethod.POST)
	public String doajouts(FormAjoutUsers file, BindingResult bindResult,
			Model model) {
		System.out.println("TEST :" + model);

		if (bindResult.hasErrors())
			return "admin/ajoutUsers";
		else {
			// String[] fichiers = file.getNom().split("\\");
			String fichier = file.getNom();
			System.out.println("TEST nom : " + fichier);
			jdbc.feedBDD(fichier);
			return "redirect:/app/admin/index";
		}
	}
}
