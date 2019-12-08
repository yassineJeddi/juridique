/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDCtx.DaoImp;

import com.ynsolution.juridique.MDCtx.Idao.IContentieuxDao;
import com.ynsolution.juridique.MDCtx.entite.Contentieux;
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
@Repository("contentieuxDao")
@Transactional(readOnly = false)
public class ContentieuxDaoImp extends MbHibernateDaoSupport implements IContentieuxDao, Serializable{

    @Override
    public void addContentieux(Contentieux c) {
        Transaction tx = null;
        Session session = getSessionFactory().openSession();
        try {
            session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction(); 
            session.save(c);
            tx.commit();
            session.close();
        } catch (Exception exp) {
            tx.rollback();
            session.close(); 
            System.out.println("Erreur d'enregistrement du dossier Contentieux car "+exp.getMessage());
        }
    }

    @Override
    public void editContentieux(Contentieux c) {
        Transaction tx = null;
        Session session = getSessionFactory().openSession();
        try {
            session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction(); 
            session.merge(c);
            tx.commit();
            session.close();
        } catch (Exception exp) {
            tx.rollback();
            session.close(); 
            System.out.println("Erreur de modification du dossier Contentieux car "+exp.getMessage());
        }
    }

    @Override
    public void remouvContentieux(Contentieux c) {
        Transaction tx = null;
        Session session = getSessionFactory().openSession();
        try {
            session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction(); 
            session.delete(c);
            tx.commit();
            session.close();
        } catch (Exception exp) {
            tx.rollback();
            session.close(); 
            System.out.println("Erreur de suppression du dossier Contentieux car "+exp.getMessage());
        }
    }

    @Override
    public Contentieux contentieuxById(Integer id){
        return this.getHibernateTemplate().get(Contentieux.class, id); 
    }
    
    @Override
    public List<Contentieux> allContentieux() {
        List<Contentieux> l = new ArrayList<Contentieux>();
        try {
            l = this.getHibernateTemplate().loadAll(Contentieux.class);
        } catch (Exception e) {
            System.out.println("Erreur de recuperation les dossier Contentieux car  "+e.getMessage());
        }
        return l;
    }
    
}
