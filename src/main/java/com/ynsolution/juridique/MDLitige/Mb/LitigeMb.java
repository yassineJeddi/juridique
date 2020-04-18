/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDLitige.Mb;

import com.ynsolution.juridique.MDLitige.Entite.Litige;
import com.ynsolution.juridique.MDLitige.Service.ILitigeService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
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
public class LitigeMb {
    
 private final static Logger logger = Logger.getLogger(LitigeMb.class);
    
    /*************
     * 
     * VARIABLES
     * 
     */
    

    @ManagedProperty(value = "#{litigeService}")
    private ILitigeService litigeService;
    
    
    private Litige litige = new Litige(); 
    private List<Litige> litiges = new ArrayList<Litige>();
    
    
    /*************
     * 
     * FONCTION
     * 
     */
    @PostConstruct
    public void init() {
        WebApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
        litigeService = ctx.getBean(ILitigeService.class);
        
    }
    
    public void prepAddLitige(){
        litige = new Litige();
    }
    public void addLitige(){
        try {
                litigeService.addLitige(litige);
        } catch (Exception e) {
            logger.error("MB::::::::> Erreur d'enregistrement Litige car "+e.getMessage());
        }
        litige = new Litige();
        try {
            litiges = litigeService.allLitige();
        } catch (Exception e) {
            litiges = new ArrayList<Litige>();
            logger.error("MB::::::::> Erreur de recuperer list de Litige car "+e.getMessage());
        }
        
    }
    
    public void editLitige(){
        litigeService.editLitige(litige);
        litige = new Litige();
        litiges = litigeService.allLitige();
    }
    
    public void remouveLitige(){
        litigeService.remouveLitige(litige);
        litige = new Litige();
        litiges = litigeService.allLitige();
    }
    
    public void chargerLitige(){
        litige = new Litige();
        try {
            litiges = litigeService.allLitige();
        } catch (Exception e) {
            litiges = new ArrayList<Litige>();
            logger.error("MB::::::::> Erreur de charger list des Litige car "+e.getMessage());
        }
    }
    public void viderLitige(){
        litige = new Litige();
        litiges = new ArrayList<Litige>();
    }    
    /*************
     * 
     * GETTERS AND SETTERS
     * 
     */

    public ILitigeService getLitigeService() {
        return litigeService;
    }

    public void setLitigeService(ILitigeService litigeService) {
        this.litigeService = litigeService;
    }

    public Litige getLitige() {
        return litige;
    }

    public void setLitige(Litige litige) {
        this.litige = litige;
    }

    public List<Litige> getLitiges() {
        return litiges;
    }

    public void setLitiges(List<Litige> litiges) {
        this.litiges = litiges;
    }

}
