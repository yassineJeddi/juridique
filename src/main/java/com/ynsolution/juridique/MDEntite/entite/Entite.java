/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDEntite.entite;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author yassine
 */
@Entity
public class Entite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name = "NOM")
    private String nom;
    
    @Column(name = "TELE")
    private String tele;
    
    @Column(name = "FAXE")
    private String faxe;
    
    @Column(name = "ADRESSE")
    private String adresse;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "NUM_IDENTITE")
    private String numIdentite;
    
    @Column(name = "ICE")
    private String ice;
    
    @ManyToOne
    private TypeEntite typeEntite;

    public TypeEntite getTypeEntite() {
        return typeEntite;
    }

    public void setTypeEntite(TypeEntite typeEntite) {
        this.typeEntite = typeEntite;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumIdentite() {
        return numIdentite;
    }

    public void setNumIdentite(String numIdentite) {
        this.numIdentite = numIdentite;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaxe() {
        return faxe;
    }

    public void setFaxe(String faxe) {
        this.faxe = faxe;
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
        if (!(object instanceof Entite)) {
            return false;
        }
        Entite other = (Entite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entite{" + "id=" + id + ", nom=" + nom + ", tele=" + tele + ", adresse=" + adresse + ", numIdentite=" + numIdentite + ", ice=" + ice + '}';
    }

   
    
}
