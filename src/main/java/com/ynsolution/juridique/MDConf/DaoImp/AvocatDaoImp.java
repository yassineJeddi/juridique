/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDConf.DaoImp;

import com.ynsolution.juridique.MDConf.Idao.IAvocatDAO;
import com.ynsolution.juridique.MDConf.Entite.Avocat;
import com.ynsolution.juridique.utilitaire.MbHibernateDaoSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yassine
 */
@Repository("avocatDAOImp")
@Transactional(readOnly = false)
public class AvocatDaoImp extends MbHibernateDaoSupport implements IAvocatDAO, Serializable {
    

    @Override
    public void addAvocat(Avocat a) {
        
        Transaction tx = null;
        Session session = getSessionFactory().openSession();
        try {
            session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction(); 
            session.save(a);
            tx.commit();
            session.close();
        } catch (Exception exp) {
            tx.rollback();
            session.close(); 
            System.out.println("DAO ----> Erreur d'enregistrement avocat car "+exp.getMessage());
        }
    }

    @Override
    public void editAvocat(Avocat a) {
        //Transaction tx = null;
       // Session session = getSessionFactory().openSession();
        try {
            this.getHibernateTemplate().save(a);
           /* session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction(); 
            session.merge(a);
            tx.commit();
            session.close();*/
        } catch (Exception exp) {
           // tx.rollback();
           // session.close(); 
            System.out.println("DAO ----> Erreur de modification avocat car "+exp.getMessage());
        }
    }

    @Override
    public void remouvAvocat(Avocat a) {
        Transaction tx = null;
        Session session = getSessionFactory().openSession();
        try {
            session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction(); 
            session.delete(a);
            tx.commit();
            session.close();
        } catch (Exception exp) {
            tx.rollback();
            session.close(); 
            System.out.println("DAO ----> Erreur de suppression avocat car "+exp.getMessage());
        }
    }

    @Override
    public Avocat avocatById(Integer id) {
         return this.getHibernateTemplate().get(Avocat.class, id); 
    }

    @Override
    public List<Avocat> allAvocat() {
       List<Avocat> l = new ArrayList<Avocat>();
        try {
            l = this.getHibernateTemplate().loadAll(Avocat.class);
        } catch (Exception e) {
            System.out.println("Erreur de recuperation les aocat car  "+e.getMessage());
        }
        return l;
    }

    @Override
    public List<Avocat> allAvocatActive() {
         List<Avocat> l = new ArrayList<Avocat>();
        try { 
            List ml =  this.getHibernateTemplate().find("From Avocat a where a.active = true ");
            l =(List<Avocat>) ml;
        } catch (Exception e) {
            System.out.println("Erreur de recuperation les aocat car  "+e.getMessage());
        }
        return l;
    }

    @Override
    public List<Avocat> allAvocatByCritere(Avocat a) {
          List<Avocat> l = new ArrayList<Avocat>();
          String req = "From Avocat a where 1=1  ";
          if(a!=null){
              if(a.getNom() != null && !a.getNom().isEmpty()){
                  req = req +" AND a.nom like '%"+a.getNom()+"%' ";
              }
              if(a.getPrenom()!= null && !a.getPrenom().isEmpty()){
                  req = req +" AND a.prenom like '%"+a.getPrenom()+"%' ";
              }
              if( a.getCin()!= null && !a.getCin().isEmpty() ){
                  req = req +" AND a.cin like '%"+a.getCin()+"%' ";
              }
              if(a.getAdresse()!= null && !a.getAdresse().isEmpty()){
                  req = req +" AND a.adresse like '%"+a.getAdresse()+"%' ";
              }
              if(a.getAdresseBureau()!= null && !a.getAdresseBureau().isEmpty()){
                  req = req +" AND a.adresseBureau like '%"+a.getAdresseBureau()+"%' ";
              }
              if(a.getEmail()!= null && !a.getEmail().isEmpty()){
                  req = req +" AND a.email like '%"+a.getEmail()+"%' ";
              }
              if(a.getNumCompte()!= null && !a.getNumCompte().isEmpty()){
                  req = req +" AND a.numCompte like '%"+a.getNumCompte()+"%' ";
              }
          }
        try { 
            List ml =  this.getHibernateTemplate().find(req);
            l =(List<Avocat>) ml;
        } catch (Exception e) {
            System.out.println("Erreur de recuperation les avocats car  "+e.getMessage());
        }
        return l;
    }
    
}
