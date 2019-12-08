/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDCtx.entite;

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
public class Contentieux implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name = "TYPECTX")
    private String typeCtx;
    
    @Column(name = "ENTITE")
    private String entite;
    
    @Column(name = "REFERENCEINTERNE")
    private String referenceInterne;
    
    @Column(name = "REFERENCETRIBUNAL")
    private String referenceTribunal;
    
    @Column(name = "PARTIEADVERSSE")
    private String partieAdverse;
    
    @Column(name = "MONTANTRISQUE")
    private String montantRisque;
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeCtx() {
        return typeCtx;
    }

    public void setTypeCtx(String typeCtx) {
        this.typeCtx = typeCtx;
    }

    public String getEntite() {
        return entite;
    }

    public void setEntite(String entite) {
        this.entite = entite;
    }

    public String getReferenceInterne() {
        return referenceInterne;
    }

    public void setReferenceInterne(String referenceInterne) {
        this.referenceInterne = referenceInterne;
    }

    public String getReferenceTribunal() {
        return referenceTribunal;
    }

    public void setReferenceTribunal(String referenceTribunal) {
        this.referenceTribunal = referenceTribunal;
    }

    public String getPartieAdverse() {
        return partieAdverse;
    }

    public void setPartieAdverse(String partieAdverse) {
        this.partieAdverse = partieAdverse;
    }

    public String getMontantRisque() {
        return montantRisque;
    }

    public void setMontantRisque(String montantRisque) {
        this.montantRisque = montantRisque;
    }

    
    
}
