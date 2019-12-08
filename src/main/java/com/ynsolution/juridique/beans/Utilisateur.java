package com.ynsolution.juridique.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import org.alfresco.service.namespace.QName;

//import org.alfresco.service.namespace.QName;
@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -295620576271670655L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "NODEREF")
    private String nodeRef;

    @Column(name = "CIN")
    private String cin;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name="ISACTIVE")
    private boolean isActive;

    

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "UTILISATEUR_PERMISSION", joinColumns = {
        @JoinColumn(name = "UTILISATEUR_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PERMISSION_ID")})
    private List<Permission> permissions;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the cin
     */
    public String getCin() {
        return cin;
    }

    /**
     * @param cin the cin to set
     */
    public void setCin(String cin) {
        this.cin = cin;
    }

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

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    /**
     * @return the nodeRef
     */
    public String getNodeRef() {
        return nodeRef;
    }

    /**
     * @param nodeRef the nodeRef to set
     */
    public void setNodeRef(String nodeRef) {
        this.nodeRef = nodeRef;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
