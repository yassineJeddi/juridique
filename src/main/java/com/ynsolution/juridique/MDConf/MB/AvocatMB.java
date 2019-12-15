/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDConf.MB;

import com.ynsolution.juridique.MDConf.IService.IAvocatService;
import com.ynsolution.juridique.MDConf.Entite.Avocat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

/**
 *
 * @author yassine
 */

@Component
@ManagedBean (name = "avocatMB")
@ViewScoped
public class AvocatMB {
    
    
    @ManagedProperty(value = "#{avocatService}")
    private IAvocatService avocatService;
    
    
    private Avocat avocat;
    private List<Avocat> avocats;

    public IAvocatService getAvocatService() {
        return avocatService;
    }

    public void setAvocatService(IAvocatService avocatService) {
        this.avocatService = avocatService;
    }

    public Avocat getAvocat() {
        return avocat;
    }

    public void setAvocat(Avocat avocat) {
        this.avocat = avocat;
    }

    public List<Avocat> getAvocats() {
        return avocats;
    }

    public void setAvocats(List<Avocat> avocats) {
        this.avocats = avocats;
    }
    
    
    
    
    @PostConstruct
    public void init() {
        WebApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
        avocatService = ctx.getBean(IAvocatService.class);
        viderParam();
    }
    
    public void addAvocat(){
        try {
            avocatService.addAvocat(avocat);
            viderParam();
        } catch (Exception e) {
            System.out.println("MB ====> Erreur d'enregistrement De l'avocat car "+e.getMessage());
        }
    }
    public void editAvocat(){
        try {
        avocatService.editAvocat(avocat);
        } catch (Exception e) {
            viderParam();
            System.out.println("MB ====> Erreur de modifier avocats car "+e.getMessage());
        }
    }
    public void remouveAvocat(){
        try {
        avocatService.remouvAvocat(avocat);
        } catch (Exception e) {
            viderParam();
            System.out.println("MB ====> Erreur de supprimer avocats car "+e.getMessage());
        }
    }
    public void desactiverAvocat(){
        try {
        avocat.setActive(Boolean.FALSE);
        avocatService.editAvocat(avocat);
        } catch (Exception e) {
            viderParam();
            System.out.println("MB ====> Erreur de desactive avocats car "+e.getMessage());
        }
    }
    
    public void chargerAllAvocat(){
        try {
        avocats=avocatService.allAvocat();
        } catch (Exception e) {
            viderParam();
            System.out.println("MB chargerAllAvocat ====> Erreur de chargement des avocats car "+e.getMessage());
        }
    }
    
    public void chargerAllAvocatActive(){
        try {
        avocats=avocatService.allAvocatActive();
        } catch (Exception e) {
            viderParam();
            System.out.println("MB chargerAllAvocatActive ====> Erreur de chargement des avocats car "+e.getMessage());
        }
    }
    
    public void chargerAllAvocatParam(){
        try {
        avocats=avocatService.allAvocatByCritere(avocat);
        } catch (Exception e) {
            viderParam();
            System.out.println("MB chargerAllAvocatParam ====> Erreur de chargement des avocats car "+e.getMessage());
        }
    }
    
    public void viderParam(){
        avocat = new Avocat();
        avocats = new ArrayList<Avocat>();
    }
    
    public void chargerAvocat(Avocat a){
        avocat=a;
    }
    
    
    
    
    
    
}
