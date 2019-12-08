/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDConf.Entite;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author yassine
 */
@Entity
public class Avocat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;
    @Column(name = "CIN")
    private String cin;
    @Column(name = "TEL")
    private String telephone;
    @Column(name = "TELFIX")
    private String telephoneFix;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ADRESSEBUREAU")
    private String adresseBureau;
    @Column(name = "ADRESSE")
    private String adresse;
    @Column(name = "NUMCOMPTE")
    private String numCompte;
    
    @Column(name = "AVATAR")
    private String avatar;
    @Column(name = "ACTIVE")
    private Boolean active;
    
    
/**GETERS & SETTERS**/
    @Id
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresseBureau() {
        return adresseBureau;
    }

    public void setAdresseBureau(String adresseBureau) {
        this.adresseBureau = adresseBureau;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephoneFix() {
        return telephoneFix;
    }

    public void setTelephoneFix(String telephoneFix) {
        this.telephoneFix = telephoneFix;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avocat)) {
            return false;
        }
        Avocat other = (Avocat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Avocat{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", telephone=" + telephone + ", telephoneFix=" + telephoneFix + ", fax=" + fax + ", email=" + email + ", adresseBureau=" + adresseBureau + ", adresse=" + adresse + ", numCompte=" + numCompte + ", avatar=" + avatar + ", active=" + active + '}';
    }

    

    
    
}
