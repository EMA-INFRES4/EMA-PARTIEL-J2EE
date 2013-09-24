/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpj2ee.personne;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author xtalandier
 */
public class PersonneBean implements Serializable {
	private String nom;
	private String prenom;
	private String sexe;
	private String cp;
	private String[] transport;

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the sexe
	 */
	public String getSexe() {
		return sexe;
	}

	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	/**
	 * @return the transport
	 */
	public String[] getTransport() {
		// Crapy code !!!
		if(transport == null){
			return "Non communiqué".split(",");
		}
		return transport;
	}

	/**
	 * @param transport the transport to set
	 */
	public void setTransport(String[] transport) {
		this.transport = transport;
	}


}
