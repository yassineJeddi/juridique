package com.ynsolution.juridique.MDEntite.MB;


import com.ynsolution.juridique.MDEntite.IService.IEntiteService;
import com.ynsolution.juridique.MDEntite.IService.ITypeEntiteService;
import com.ynsolution.juridique.MDEntite.entite.Entite;
import com.ynsolution.juridique.MDEntite.entite.TypeEntite;
import java.io.Serializable;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yassine
 */
@Component
@ManagedBean
@ViewScoped
public class EntiteMB implements Serializable{
    
    @ManagedProperty(value = "#{entiteServiceImp}")
    private IEntiteService entiteService;
    
    @ManagedProperty(value = "#{typeEntiteService}")
    private ITypeEntiteService typeEntiteService;
    
    
    public Entite entite;
    public TypeEntite typeEntite;
    
    public List<Entite> entites = new ArrayList<Entite>();
    public List<TypeEntite> typeEntites = new ArrayList<TypeEntite>();

    public TypeEntite getTypeEntite() {
        return typeEntite;
    }

    public void setTypeEntite(TypeEntite typeEntite) {
        this.typeEntite = typeEntite;
    }

    public List<TypeEntite> getTypeEntites() {
        return typeEntites;
    }

    public void setTypeEntites(List<TypeEntite> typeEntites) {
        this.typeEntites = typeEntites;
    }

    public ITypeEntiteService getTypeEntiteService() {
        return typeEntiteService;
    }

    public void setTypeEntiteService(ITypeEntiteService typeEntiteService) {
        this.typeEntiteService = typeEntiteService;
    }
    
    

    public IEntiteService getEntiteService() {
        return entiteService;
    }

    public void setEntiteService(IEntiteService entiteService) {
        this.entiteService = entiteService;
    }

    public Entite getEntite() {
        return entite;
    }

    public void setEntite(Entite entite) {
        this.entite = entite;
    }

    public List<Entite> getEntites() {
        return entites;
    }

    public void setEntites(List<Entite> entites) {
        this.entites = entites;
    }
    
    
    
    
    @PostConstruct
    public void init() {
        WebApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
        entiteService = ctx.getBean(IEntiteService.class);
        typeEntiteService = ctx.getBean(ITypeEntiteService.class);
        entites = entiteService.getAllEntie();
        typeEntites = typeEntiteService.allTypeEntite();
        typeEntite = new TypeEntite();
        entite=new Entite();
    }
    
    public void renitialiseEntie(){
        entite = new Entite();
        typeEntite = new TypeEntite();
    }
    
    public void addEntite(){
        entiteService.addEntite(entite);
        renitialiseEntie();
    }
    
    public void editEntite(){
        entiteService.editEntite(entite);
        renitialiseEntie();
    }
    
    public void remouveEntite(int id){
        entiteService.remouveEntite(id);
        renitialiseEntie();
    }
    
    public void chargerEntie(){
        entites = entiteService.getAllEntie();
    }
    
    
    
    
    
}
