/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDLitige.DAO;

import com.ynsolution.juridique.MDLitige.Entite.Litige;
import com.ynsolution.juridique.utilitaire.MbHibernateDaoSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author yassine
 */
@Repository("litigeDaoImp")
@Transactional
public class LitigeDaoImp extends MbHibernateDaoSupport implements ILitigeDao, Serializable {


 private final static Logger logger = Logger.getLogger(LitigeDaoImp.class);
    @Override
    public Long addLitige(Litige l) {
        Transaction tx = null;
        Session session = getSessionFactory().openSession();
        Long id ;
        id = 0L;
        try {
            session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction();
            id= (Long) session.save(l);
            tx.commit();
            session.close();
        } catch (Exception exp) {
            logger.error("exception d'eenregistrement : " + exp.getMessage());
            tx.rollback();
            session.close();
        } 
        return id;
    }

    @Override
    public void editLitige(Litige l) {
        Transaction tx = null;
        Session session = getSessionFactory().openSession();
        try {
            session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction();
            session.update(l);
            tx.commit();
            session.close();
        } catch (Exception exp) {
            logger.error("exception de modification : " + exp.getMessage());
            tx.rollback();
            session.close();
        } 
    }

    @Override
    public void remouveLitige(Litige l) {
        Transaction tx = null;
        Session session = getSessionFactory().openSession();
        try {
            session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction();
            session.delete(l);
            tx.commit();
            session.close();
        } catch (Exception exp) {
            logger.error("exception de suppression : " + exp.getMessage());
            tx.rollback();
            session.close();
        } 
    }

    @Override
    public Litige litigeById(Long id) {
         Litige  l = new Litige();
        try {
             l =  this.getHibernateTemplate().load(Litige.class, id);
        } catch (Exception e) {
            logger.error("Erreur de récupération  Litige car "+e.getMessage());
        }
        return l;
    }

    @Override
    public List<Litige> allLitige() {
        List<Litige>  l = new ArrayList<Litige>();
        try {
               l = this.getHibernateTemplate().loadAll(Litige.class);        
        } catch (Exception e) {
            logger.error("Erreur de récupération liste des Litige car "+e.getMessage());
        }
        return l;
    }


}
