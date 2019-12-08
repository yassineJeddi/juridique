/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDEntite.DaoImp;

import com.ynsolution.juridique.MDEntite.entite.Entite;
import com.ynsolution.juridique.utilitaire.MbHibernateDaoSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List; 
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ynsolution.juridique.MDEntite.Idao.IEntiteDao;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author yassine
 */
@Repository("entiteDao")
@Transactional(readOnly = false)
public class EntiteDaoImp extends MbHibernateDaoSupport implements IEntiteDao, Serializable {


    @Override
    public void addEntite(Entite e) {
        //System.out.println(":::::::::::::> entite : "+e.toString());
       //this.getHibernateTemplate().persist(e);
        Transaction tx = null;
        Session session = getSessionFactory().openSession();
        try {
            session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction(); 
            session.save(e);
            tx.commit();
            session.close();
        } catch (Exception exp) {
            tx.rollback();
            session.close(); 
        }
    }

    @Override
    public void editEntite(Entite e) {
        this.getHibernateTemplate().update(e);
    }

    @Override
    public void remouveEntite(int id) {
        this.getHibernateTemplate().delete(id);
    }

    @Override
    public Entite getEntiteById(int id) {
      return this.getHibernateTemplate().get(Entite.class, id); 
    }

    @Override
    public List<Entite> getAllEntie() {
        List<Entite> entites = new ArrayList<Entite>();
        try {
            entites = this.getHibernateTemplate().loadAll(Entite.class);
        } catch (DataAccessException e) {
            System.out.println("Erreur de recuperation les entite car  "+e.getMessage());
        }
        return entites;
    }

}
