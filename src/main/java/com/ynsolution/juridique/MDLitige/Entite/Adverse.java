/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDLitige.Entite;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author yassine
 */
@Entity
public class Adverse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //physique
    @Column(name = "NOM")
   private String nom;
    @Column(name = "PRENOM")
   private String prenom;
    @Column(name = "CIN")
   private String cin;
    @Column(name = "DATENAISSANCE")
    @Temporal(javax.persistence.TemporalType.DATE)
   private Date dateNaissance;
    //morale
    @Column(name = "LIBELE")
   private String libele;
    @Column(name = "PATENTE")
   private String patente;
    @Column(name = "ICE")
   private String ice;
   
    @Column(name = "TYPEADVERSE")
   private String typeAdverse; 
    @Column(name = "AVATAR")
   private String avatar;
    @Column(name = "GSM")
   private String gsm;
    @Column(name = "FIXE")
   private String fixe;
    @Column(name = "FAXE")
   private String faxe;
    @Column(name = "ADRESSE1")
   private String adresse1;
    @Column(name = "ADRESSE2")
   private String adresse2;
    @Column(name = "EMAIL")
   private String email;

    public Adverse() {
    }
    
    
    

    public Long getId() {
        return id;
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

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adverse)) {
            return false;
        }
        Adverse other = (Adverse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public String getTypeAdverse() {
        return typeAdverse;
    }

    public void setTypeAdverse(String typeAdverse) {
        this.typeAdverse = typeAdverse;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getFixe() {
        return fixe;
    }

    public void setFixe(String fixe) {
        this.fixe = fixe;
    }

    public String getFaxe() {
        return faxe;
    }

    public void setFaxe(String faxe) {
        this.faxe = faxe;
    }


    public String getAdresse1() {
        return adresse1;
    }

    public void setAdresse1(String adresse1) {
        this.adresse1 = adresse1;
    }

    public String getAdresse2() {
        return adresse2;
    }

    public void setAdresse2(String adresse2) {
        this.adresse2 = adresse2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     
    
}
