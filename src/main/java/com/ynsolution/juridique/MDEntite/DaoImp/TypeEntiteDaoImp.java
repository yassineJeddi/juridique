/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDEntite.DaoImp;

import com.ynsolution.juridique.MDEntite.Idao.ITypeEntiteDao;
import com.ynsolution.juridique.MDEntite.entite.TypeEntite;
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
@Repository("typeEntiteDao")
@Transactional(readOnly = false)
public class TypeEntiteDaoImp extends MbHibernateDaoSupport implements ITypeEntiteDao, Serializable  {

    @Override
    public void addTypeEntite(TypeEntite t) {
        Transaction tx = null;
        Session session = getSessionFactory().openSession();
        try {
            session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction(); 
            session.save(t);
            tx.commit();
            session.close();
        } catch (Exception exp) {
            tx.rollback();
            session.close(); 
        }
    }

    @Override
    public void editTypeEntite(TypeEntite t) {
        Transaction tx = null;
        Session session = getSessionFactory().openSession();
        try {
            session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction(); 
            session.update(t);
            tx.commit();
            session.close();
        } catch (Exception exp) {
            tx.rollback();
            session.close(); 
        }
    }

    @Override
    public void delleteTypeEntite(TypeEntite t) {
        Transaction tx = null;
        Session session = getSessionFactory().openSession();
        try {
            session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction(); 
            session.delete(t);
            tx.commit();
            session.close();
        } catch (Exception exp) {
            tx.rollback();
            session.close(); 
        }
    }

    @Override
    public List<TypeEntite> allTypeEntite() {
        List<TypeEntite> l = new ArrayList<TypeEntite>();
        try {
            l = this.getHibernateTemplate().loadAll(TypeEntite.class);
        } catch (Exception e) {
            System.out.println("Erreur de recuperation Liste des type entite car "+e.getMessage());
        }
        return l;
    }
    
}
