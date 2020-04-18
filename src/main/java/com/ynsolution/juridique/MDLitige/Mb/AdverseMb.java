package com.ynsolution.juridique.MDLitige.Mb;


import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.ynsolution.juridique.MDLitige.Entite.Adverse;
import com.ynsolution.juridique.MDLitige.Service.IAdverseService;
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

@Component
@ManagedBean
@ViewScoped
public class AdverseMb {
    
    
    /*************
     * 
     * VARIABLES
     * 
     */
    

    @ManagedProperty(value = "#{adverseService}")
    private IAdverseService adverseService;
    
    
    private Adverse adverse = new Adverse(); 
    private List<Adverse> adverses = new ArrayList<Adverse>();
    
    
    /*************
     * 
     * FONCTION
     * 
     */
    @PostConstruct
    public void init() {
        WebApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
        adverseService = ctx.getBean(IAdverseService.class);
        
    }
    
    public void prepAddAdverse(){
        adverse = new Adverse();
    }
    
    public void changeTypeAdverse(){
        if(adverse!=null){
            if("Physique".equals(adverse.getTypeAdverse())){
                adverse = new Adverse();
                adverse.setTypeAdverse("Physique");
            }
            else if("Morale".equals(adverse.getTypeAdverse())){
                adverse = new Adverse();
                adverse.setTypeAdverse("Morale");
            }
        }
    }
    
    public void addAdverse(){
        try {
                adverseService.addAdverse(adverse);
        } catch (Exception e) {
            System.out.println("MB::::::::> Erreur d'enregistrement Adverse car "+e.getMessage());
        }
        adverse = new Adverse();
        try {
            adverses = adverseService.allAdverse();
        } catch (Exception e) {
            adverses = new ArrayList<Adverse>();
            System.out.println("MB::::::::> Erreur de recuperer list de Adverse car "+e.getMessage());
        }
        
    }
    
    public void editAdverse(){
        adverseService.editAdverse(adverse);
        adverse = new Adverse();
        adverses = adverseService.allAdverse();
    }
    
    public void remouveAdverse(){
        adverseService.remouveAdverse(adverse);
        adverse = new Adverse();
        adverses = adverseService.allAdverse();
    }
    
    public void chargerAdverse(){
        adverse = new Adverse();
        try {
            adverses = adverseService.allAdverse();
        } catch (Exception e) {
            adverses = new ArrayList<Adverse>();
            System.out.println("MB::::::::> Erreur de charger list des Adverse car "+e.getMessage());
        }
    }
    public void viderAdverse(){
        adverse = new Adverse();
        adverses = new ArrayList<Adverse>();
    }
    
    /*************
     * 
     * GETTERS AND SETTERS
     * 
     */

    public IAdverseService getAdverseService() {
        return adverseService;
    }

    public void setAdverseService(IAdverseService adverseService) {
        this.adverseService = adverseService;
    }

    public Adverse getAdverse() {
        return adverse;
    }

    public void setAdverse(Adverse adverse) {
        this.adverse = adverse;
    }

    public List<Adverse> getAdverses() {
        return adverses;
    }

    public void setAdverses(List<Adverse> adverses) {
        this.adverses = adverses;
    }

    
    

}