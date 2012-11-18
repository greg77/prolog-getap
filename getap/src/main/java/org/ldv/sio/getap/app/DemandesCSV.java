package org.ldv.sio.getap.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ServiceDemandesCSV")
public class DemandesCSV {

	private DataSource ds;

	public DataSource getDs() {
		return ds;
	}

	@Autowired
	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	public void export(HttpServletResponse response,
			List<DemandeValidationConsoTempsAccPers> dctap) {

		try {
			PrintWriter writer = response.getWriter();
			writer.println("Année scolaire;Date;Temps;Etat;Professeur;Eleve;Type d'accompagnement");
			for (int i = 0; i < dctap.size(); i++) {
				if (dctap.get(i).isDvctapFinal()
						&& (dctap.get(i).isValidatedByEleve() || dctap.get(i)
								.isValidatedByProf())) {
					writer.append(dctap.get(i).getAnneeScolaire() + ";");
					writer.append(dctap.get(i).getDateAction() + ";");
					writer.append(dctap.get(i).getMinutes() + ";");
					writer.append("Validée;");
					writer.append(dctap.get(i).getProf().getNom() + " "
							+ dctap.get(i).getProf().getPrenom() + ";");
					writer.append(dctap.get(i).getEleve().getNom() + " "
							+ dctap.get(i).getEleve().getPrenom() + ";");
					writer.append(dctap.get(i).getAccPers().getNom());
					writer.println("");
				}
			}
			for (int i = 0; i < dctap.size(); i++) {
				if (dctap.get(i).isDvctapFinal()
						&& (dctap.get(i).isCancelledByEleve()
								|| dctap.get(i).isRefusedByProf() || dctap.get(
								i).isRefusedByEleve())) {
					writer.append(dctap.get(i).getAnneeScolaire() + ";");
					writer.append(dctap.get(i).getDateAction() + ";");
					writer.append(dctap.get(i).getMinutes() + ";");
					writer.append("Refusée;");
					writer.append(dctap.get(i).getProf().getNom() + " "
							+ dctap.get(i).getProf().getPrenom() + ";");
					writer.append(dctap.get(i).getEleve().getNom() + " "
							+ dctap.get(i).getEleve().getPrenom() + ";");
					writer.append(dctap.get(i).getAccPers().getNom());
					writer.println("");
				}
			}
			for (int i = 0; i < dctap.size(); i++) {
				if ((dctap.get(i).isCreatedOrUpdatedByEleve() || dctap.get(i)
						.isUpdatedByProf()) && !(dctap.get(i).isDvctapFinal())) {
					writer.append(dctap.get(i).getAnneeScolaire() + ";");
					writer.append(dctap.get(i).getDateAction() + ";");
					writer.append(dctap.get(i).getMinutes() + ";");
					writer.append("En cour;");
					writer.append(dctap.get(i).getProf().getNom() + " "
							+ dctap.get(i).getProf().getPrenom() + ";");
					writer.append(dctap.get(i).getEleve().getNom() + " "
							+ dctap.get(i).getEleve().getPrenom() + ";");
					writer.append(dctap.get(i).getAccPers().getNom());
					writer.println("");
				}
			}
			writer.flush();
			writer.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
}
