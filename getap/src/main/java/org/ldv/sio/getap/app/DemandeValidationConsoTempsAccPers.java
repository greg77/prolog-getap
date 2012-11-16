package org.ldv.sio.getap.app;

import java.sql.Date;

/**
 * Demande de validation d'un temps d'accompagnement personnalisé
 * 
 * 
 */

public class DemandeValidationConsoTempsAccPers {
	// private static final int DATE_MODIFIEE = 1024;
	// private static final int DUREE_MODIFIEE = 2048;
	// private static final int AP_MODIFIEE = 4096;
	private static final int DVCTAP_CREE = 8192;
	private static final int DVCTAP_VALIDEE_PAR_ELEVE = 1;
	private static final int DVCTAP_REFUSEE_PAR_ELEVE_AFTER_MODIF_PROF = 2;
	private static final int DVCTAP_MODIFIEE_PAR_ELEVE = 4;
	private static final int DVCTAP_ANNULEE_PAR_ELEVE = 8;
	private static final int DVCTAP_VALIDEE_PAR_PROF = 32;
	private static final int DVCTAP_REFUSEE_PAR_PROF = 64;
	private static final int DVCTAP_DATE_MODIFIEE_PAR_PROF = 1024;
	private static final int DVCTAP_DUREE_MODIFIEE_PAR_PROF = 2048;
	private static final int AP_DE_LA_DVCTAP_MODIFIEE_PAR_PROF = 4096;

	/**
	 * Identifiant de la DCTAP
	 */
	private Long id;
	/**
	 * Année scolaire de la demande, par exemple "2011-2012"
	 */
	private String anneeScolaire;
	/**
	 * Date de réalisation de l'accompagnement
	 * 
	 */
	private java.sql.Date dateAction;
	/**
	 * Nombre de minutes d'accompagnement personnalisé à valider
	 */
	private Integer minutes;
	/**
	 * Professeur ayant assuré l'accompagnement personnalisé
	 */
	private User prof;
	/**
	 * Nature de l'accompagnement personnalisé associé à la demande
	 */
	private AccPersonalise accPers;
	/**
	 * Identifiant de l'élève ayant réalisé l'accompagnement personnalisé
	 */
	private User eleve;

	/**
	 * 
	 */
	private int etat;

	/**
	 * constructeur par défaut
	 */
	public DemandeValidationConsoTempsAccPers() {

	}

	/**
	 * Constructeur permettant de créer une demande complète.
	 * 
	 * @param id
	 *            peut être null (création)
	 * @param anneeScolaire
	 * @param date
	 * @param minutes
	 * @param prof
	 * @param accPers
	 * @param eleve
	 * @param etat
	 */
	public DemandeValidationConsoTempsAccPers(Long id, String anneeScolaire,
			Date date, Integer minutes, User prof, AccPersonalise accPers,
			User eleve, int etat) {
		super();
		this.id = id;
		this.anneeScolaire = anneeScolaire;
		this.dateAction = date;
		this.minutes = minutes;
		this.prof = prof;
		this.accPers = accPers;
		this.eleve = eleve;
		this.etat = etat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	public java.sql.Date getDateAction() {
		return dateAction;
	}

	public void setDateAction(java.sql.Date date) {
		this.dateAction = date;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	public User getProf() {
		return prof;
	}

	public void setProf(User prof) {
		this.prof = prof;
	}

	public AccPersonalise getAccPers() {
		return accPers;
	}

	public void setAccPers(AccPersonalise accPers) {
		this.accPers = accPers;
	}

	public User getEleve() {
		return eleve;
	}

	public void setEleve(User eleve) {
		this.eleve = eleve;
	}

	public int getEtat() {
		return etat;
	}

	/**
	 * Permet de modifier l'état de la demande
	 * 
	 * @param etat
	 *            prend ses valeur dans :
	 *            <ul>
	 *            <li>0 - demande créée par l'élève</li>
	 *            <li>1 - demande acceptée par l'élève aprés modification du
	 *            professeur</li>
	 *            <li>2 - demande rejetée par l'élève aprés modification du
	 *            professeur</li>
	 *            <li>4 - demande modifiée par l'élève</li>
	 *            <li>8 - demande annulée par l'élève</li>
	 *            <li>32 - demande validée par le professeur</li>
	 *            <li>64 - demande refusée par le professeur</li>
	 *            <li>1024 - demande où la date a été modifiée par le professeur
	 *            </li>
	 *            <li>2048 - demande où la durée a été modifiée par le
	 *            professeur</li>
	 *            <li>4096 - demande où l'accompagnement personnalisé a été
	 *            modifiée par le professeur</li>
	 *            </ul>
	 */
	public void setEtat(int etat) {
		this.etat = etat;
	}

	// public boolean isDateModifiee() {
	// return (this.etat & DATE_MODIFIEE) != 0;
	// }
	//
	// public boolean isDureeModifiee() {
	// return (this.etat & DUREE_MODIFIEE) != 0;
	// }
	//
	// public boolean isApModifiee() {
	// return (this.etat & AP_MODIFIEE) != 0;
	// }
	//
	// public void setDtapInitial() {
	// this.etat = 0;
	// }
	//
	// public void setDctapConfirme() {
	// this.etat = 1;
	// }
	//
	// public void setDctapRejete() {
	// this.etat = 2;
	// }
	//
	// public void setDctapModifEleve() {
	// this.etat = 4;
	// }
	//
	// public void setDctapAnnule() {
	// this.etat = 8;
	// }
	//
	// public void setDctapValide() {
	// this.etat = 32;
	// }
	//
	// public void setDctapRefuse() {
	// this.etat = 64;
	// }
	//
	// public void setDctapDateModif() {
	// this.etat = this.getEtat() + 1024;
	// }
	//
	// public void setDctapDureeModif() {
	// this.etat = this.getEtat() + 2048;
	// }
	//
	// public void setDctapAccModif() {
	// this.etat = this.getEtat() + 4096;
	// }
	//
	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result
	// + ((anneeScolaire == null) ? 0 : anneeScolaire.hashCode());
	// result = prime * result
	// + ((dateAction == null) ? 0 : dateAction.hashCode());
	// result = prime * result + ((eleve == null) ? 0 : eleve.hashCode());
	// return result;
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// DemandeValidationConsoTempsAccPers other =
	// (DemandeValidationConsoTempsAccPers) obj;
	// if (anneeScolaire == null) {
	// if (other.anneeScolaire != null)
	// return false;
	// } else if (!anneeScolaire.equals(other.anneeScolaire))
	// return false;
	// if (dateAction == null) {
	// if (other.dateAction != null)
	// return false;
	// } else if (!dateAction.equals(other.dateAction))
	// return false;
	// if (eleve == null) {
	// if (eleve != null)
	// return false;
	// } else if (!eleve.equals(other.eleve))
	// return false;
	// return true;
	// }

	@Override
	public String toString() {
		return "DemandeConsoTempsAccPers [id=" + id + ", anneeScolaire="
				+ anneeScolaire + ", dateAction=" + dateAction + ", minutes="
				+ minutes + ", prof=" + prof + ", accPers=" + accPers
				+ ", eleve=" + eleve + ", etat=" + etat + "]";
	}

	/**
	 * Annule la DVCTAP par l'eleve
	 * 
	 * @throws DVCTAPException
	 *             si dctap non crée, dctap en etat final, ou si elle a deja ete
	 *             mise a jour par un professeur
	 * 
	 */

	public void setCancelledByEleve() {
		if (this.isCreatedOrUpdatedByEleve() && !(this.isDvctapFinal())
				&& !(this.isUpdatedByProf())) {

			this.etat = this.etat | DVCTAP_ANNULEE_PAR_ELEVE;

		} else {
			throw new DVCTAPException("annulation par eleve: non effectuée ;");
		}
	}

	/**
	 * Refuse la DVCTAP par le prof
	 * 
	 * @throws DVCTAPException
	 *             si dvctap non crée, dvctap en etat final, ou si elle a deja
	 *             ete mise a jour par un professeur
	 * 
	 */

	public void setRefusedByProf() {
		if (this.isCreatedOrUpdatedByEleve() && !(this.isDvctapFinal())
				&& !(this.isUpdatedByProf())) {
			this.etat = this.etat | DVCTAP_REFUSEE_PAR_PROF;
		} else {
			throw new DVCTAPException("refusée par prof: non effectuée ;");
		}
	}

	/**
	 * 
	 */
	public void setCreatedByEleve() {

		// this.etat = this.etat | DVCTAP_CREE;
		this.etat |= DVCTAP_CREE;

	}

	/**
	 * MAJ DVCTAP par l'eleve
	 * 
	 * @throws DVCTAPException
	 *             si dctap non crée, dctap en etat final, ou si elle a deja ete
	 *             mise a jour par un professeur
	 * 
	 */

	public void setUpdateByEleve() {

		if (this.isCreatedOrUpdatedByEleve() && !(this.isDvctapFinal())
				&& !(this.isUpdatedByProf())) {
			System.out.println("plop");
			this.etat = this.etat | DVCTAP_MODIFIEE_PAR_ELEVE;
		} else {
			throw new DVCTAPException("modification par eleve: non effectuée ;");
		}
	}

	/**
	 * Refusée par l'eleve
	 * 
	 * @throws DVCTAPException
	 *             si dctap non crée, dctap en etat final,et si elle a deja ete
	 *             mise a jour par un professeur
	 * 
	 */

	public void setRefusedByEleve() {
		if ((this.isCreatedOrUpdatedByEleve() && this.isUpdatedByProf())
				&& !(this.isDvctapFinal())) {
			this.etat = this.etat | DVCTAP_REFUSEE_PAR_ELEVE_AFTER_MODIF_PROF;
		} else {
			throw new DVCTAPException("refusée par eleve: non effectuée ;");
		}
	}

	/**
	 * validée DVCTAP par l'eleve
	 * 
	 * @throws DVCTAPException
	 *             si dctap non crée, dctap en etat final, ou si elle a deja ete
	 *             mise a jour par un professeur
	 * 
	 */

	public void setValidatedByEleve() {
		if ((this.isCreatedOrUpdatedByEleve() && this.isUpdatedByProf())
				&& !(this.isDvctapFinal())) {
			this.etat = this.etat | DVCTAP_VALIDEE_PAR_ELEVE;
		} else {
			throw new DVCTAPException("validée par eleve: non effectuée ;");
		}
	}

	/**
	 * MAJdate DVCTAP par prof
	 * 
	 * @throws DVCTAPException
	 *             si dctap non crée, dctap en etat final, ou si elle a deja ete
	 *             mise a jour par un professeur
	 * 
	 */

	public void setDateUpdatedByProf() {
		if ((this.isCreatedOrUpdatedByEleve() || this.isUpdatedByProf())
				&& !(this.isDvctapFinal())) {
			this.etat = this.etat | DVCTAP_DATE_MODIFIEE_PAR_PROF;
		} else {
			throw new DVCTAPException("date modifiée par prof: non effectuée ;");
		}
	}

	/**
	 * MAJduree DVCTAP par prof
	 * 
	 * @throws DVCTAPException
	 *             si dctap non crée, dctap en etat final, ou si elle a deja ete
	 *             mise a jour par un professeur
	 * 
	 */

	public void setDureeUpdatedByProf() {
		if ((this.isCreatedOrUpdatedByEleve() || this.isUpdatedByProf())
				&& !(this.isDvctapFinal())) {
			this.etat = this.etat | DVCTAP_DUREE_MODIFIEE_PAR_PROF;
		} else {
			throw new DVCTAPException(
					"durée modifiée par prof: non effectuée ;");
		}
	}

	/**
	 * MAJ AP DVCTAP par prof
	 * 
	 * @throws DVCTAPException
	 *             si dctap non crée, dctap en etat final, ou si elle a deja ete
	 *             mise a jour par un professeur
	 * 
	 */

	public void setAPUpdatedByProf() {
		if ((this.isCreatedOrUpdatedByEleve() || this.isUpdatedByProf())
				&& !(this.isDvctapFinal())) {
			this.etat = this.etat | AP_DE_LA_DVCTAP_MODIFIEE_PAR_PROF;
		} else {
			throw new DVCTAPException("AP modifiée par prof: non effectuée ;");
		}
	}

	/**
	 * Valide DVCTAP par prof
	 * 
	 * @throws DVCTAPException
	 *             si dctap non crée, dctap en etat final, ou si elle a deja ete
	 *             mise a jour par un professeur
	 * 
	 */

	public void setValidatedByProf() {
		if ((this.isCreatedOrUpdatedByEleve() && !(this.isUpdatedByProf()) && !(this
				.isDvctapFinal()))) {
			this.etat = this.etat | DVCTAP_VALIDEE_PAR_PROF;
		} else {
			throw new DVCTAPException("validée par prof: non effectuée ;");
		}
	}

	/**
	 * teste si etat a été en etat initial
	 * 
	 * @return booleen qui si etat a été en etatinitial
	 */

	public boolean isEtatInitial() {

		Boolean bool = (this.etat & DVCTAP_CREE) == DVCTAP_CREE;
		// System.out.println("ei? : " + bool);

		return bool;
	}

	/**
	 * teste si etat a été en maj par l'eleve
	 * 
	 * @return booleen qui si etat a été maj par l'eleve
	 */
	public boolean isUpdateByEleve() {
		Boolean bool = (this.etat & DVCTAP_MODIFIEE_PAR_ELEVE) == DVCTAP_MODIFIEE_PAR_ELEVE;

		return bool;
	}

	/**
	 * teste si etat a été en annulé par l'eleve
	 * 
	 * @return booleen qui si etat a été annulé par l'eleve
	 */
	public boolean isCancelledByEleve() {
		Boolean bool = (this.etat & DVCTAP_ANNULEE_PAR_ELEVE) == DVCTAP_ANNULEE_PAR_ELEVE;

		return bool;
	}

	/**
	 * teste si etat a été en maj par l'eleve
	 * 
	 * @return booleen qui si etat a été maj par l'eleve
	 */

	public boolean isRefusedByProf() {
		Boolean bool = (this.etat & DVCTAP_REFUSEE_PAR_PROF) == DVCTAP_REFUSEE_PAR_PROF;

		return bool;
	}

	/**
	 * teste si etat a été validé par prof
	 * 
	 * @return booleen qui retourne si etat a étévalidé par prof
	 */

	public boolean isValidatedByProf() {
		Boolean bool = (this.etat & DVCTAP_VALIDEE_PAR_PROF) == DVCTAP_VALIDEE_PAR_PROF;

		return bool;
	}

	/**
	 * teste si date a été modifiée par prof
	 * 
	 * @return booleen qui retourne si date a été modifiée par prof
	 */
	public boolean isDateUpdatedByProf() {
		Boolean bool = (this.etat & DVCTAP_DATE_MODIFIEE_PAR_PROF) == DVCTAP_DATE_MODIFIEE_PAR_PROF;

		return bool;
	}

	/**
	 * teste si duree a été modifiée par prof
	 * 
	 * @return booleen qui retourne si duree a été modifiée par prof
	 */

	public boolean isDureeUpdatedByProf() {
		Boolean bool = (this.etat & DVCTAP_DUREE_MODIFIEE_PAR_PROF) == DVCTAP_DUREE_MODIFIEE_PAR_PROF;

		return bool;
	}

	/**
	 * teste si AP a été modifiée par prof
	 * 
	 * @return booleen qui retourne si AP a été modifiée par prof
	 */

	public boolean isAPUpdatedByProf() {
		Boolean bool = (this.etat & AP_DE_LA_DVCTAP_MODIFIEE_PAR_PROF) == AP_DE_LA_DVCTAP_MODIFIEE_PAR_PROF;

		return bool;
	}

	/**
	 * teste si etat a été en refusé par l'eleve
	 * 
	 * @return booleen qui si etat a été refusé par l'eleve
	 */
	public boolean isRefusedByEleve() {
		Boolean bool = (this.etat & DVCTAP_REFUSEE_PAR_ELEVE_AFTER_MODIF_PROF) == DVCTAP_REFUSEE_PAR_ELEVE_AFTER_MODIF_PROF;

		return bool;
	}

	/**
	 * teste si etat a été en validé par l'eleve
	 * 
	 * @return booleen qui si etat a été validé par l'eleve
	 */
	public boolean isValidatedByEleve() {
		Boolean bool = (this.etat & DVCTAP_VALIDEE_PAR_ELEVE) == DVCTAP_VALIDEE_PAR_ELEVE;

		return bool;
	}

	/**
	 * teste si état a été modifiée par prof (durée, date, AP)
	 * 
	 * @return booleen qui retourne si état a été modifiée par prof (durée, AP,
	 *         date)
	 */
	public boolean isUpdatedByProf() {

		Boolean bool = (this.isDateUpdatedByProf()
				|| this.isDureeUpdatedByProf() || this.isAPUpdatedByProf());

		// System.out.println("updated par prof:"+bool);
		return bool;
	}

	/**
	 * teste si etat a été en crée ou maj par l'eleve
	 * 
	 * @return booleen qui si etat a été crée ou maj par l'eleve
	 */
	public boolean isCreatedOrUpdatedByEleve() {
		// System.out.println("crée: "+this.isEtatInitial()+" majeleve:"+this.isUpdateByEleve());
		Boolean bool = (this.isEtatInitial() || this.isUpdateByEleve());
		return bool;
	}

	/**
	 * teste si etat est final,c'est a dire qu'il ne peut plus supporter de
	 * modifications il teste si il a été annulé par l'eleve,refusé par
	 * l'eleve,refusé par le prof,validé par l'eleve, ou validé par le prof
	 * 
	 * @return booleen qui retourne si etat est final
	 */
	public boolean isDvctapFinal() {
		Boolean bool = (this.isCancelledByEleve() || this.isRefusedByProf()
				|| this.isValidatedByEleve() || this.isValidatedByProf() || this
				.isRefusedByEleve());
		System.out.println("final:" + bool);
		return bool;
	}

}
