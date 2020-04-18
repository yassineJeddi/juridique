/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDLitige.Mb;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.ynsolution.juridique.MDLitige.Entite.TypeLitige;
import com.ynsolution.juridique.MDLitige.Service.ITypeLitigeService;
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
@ManagedBean
@ViewScoped
public class TypeLitigeMb {
    
    
    /*************
     * 
     * VARIABLES
     * 
     */
    
    @ManagedProperty(value = "#{typeLitigeService}")
    private ITypeLitigeService typeLitigeService;
    
      
    private TypeLitige typeLitige = new TypeLitige(); 
    private List<TypeLitige> typeLitiges = new ArrayList<TypeLitige>();
    
    
    /*************
     * 
     * FONCTION
     * 
     */
    @PostConstruct
    public void init() {
        WebApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
        typeLitigeService = ctx.getBean(ITypeLitigeService.class);
        
    }
    
    public void prepAddTypeLitige(){
        typeLitige = new TypeLitige();
    }
    
    public void viderTypeLitige(){
        typeLitiges = new  ArrayList<TypeLitige>();
    }
    public void addTypeLitige(){
        System.out.println("MB ::::::::::::> typeLitige 0: "+typeLitige.toString());
        try {
        System.out.println("MB ::::::::::::> typeLitige 1: "+typeLitige.toString());
                typeLitigeService.addTypeLitige(typeLitige);
        } catch (Exception e) {
            System.out.println("MB::::::::> Erreur d'enregistrement TypeLitige car "+e.getMessage());
        }
        typeLitige = new TypeLitige();
        try {
            typeLitiges = typeLitigeService.allTypeLitige();
        } catch (Exception e) {
            typeLitiges = new ArrayList<TypeLitige>();
            System.out.println("MB::::::::> Erreur de recuperer list de TypeLitige car "+e.getMessage());
        }
        
    }
    
    public void editTypeLitige(){
        typeLitigeService.editTypeLitige(typeLitige);
        typeLitige = new TypeLitige();
        typeLitiges = typeLitigeService.allTypeLitige();
    }
    
    public void remouveTypeLitige(){
        typeLitigeService.remouveTypeLitige(typeLitige);
        typeLitige = new TypeLitige();
        typeLitiges = typeLitigeService.allTypeLitige();
    }
    
    public void chargerTypeLitige(){
        typeLitige = new TypeLitige();
        try {
            typeLitiges = typeLitigeService.allTypeLitige();
        } catch (Exception e) {
            typeLitiges = new ArrayList<TypeLitige>();
            System.out.println("MB::::::::> Erreur de charger list des TypeLitige car "+e.getMessage());
        }
    }
    
    /*************
     * 
     * GETTERS AND SETTERS
     * 
     */

    public ITypeLitigeService getTypeLitigeService() {
        return typeLitigeService;
    }

    public void setTypeLitigeService(ITypeLitigeService typeLitigeService) {
        this.typeLitigeService = typeLitigeService;
    }

    public TypeLitige getTypeLitige() {
        return typeLitige;
    }

    public void setTypeLitige(TypeLitige typeLitige) {
        this.typeLitige = typeLitige;
    }

    public List<TypeLitige> getTypeLitiges() {
        return typeLitiges;
    }

    public void setTypeLitiges(List<TypeLitige> typeLitiges) {
        this.typeLitiges = typeLitiges;
    }

    
    

    
    
    
    
}
