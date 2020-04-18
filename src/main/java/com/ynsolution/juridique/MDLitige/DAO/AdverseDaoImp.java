package com.ynsolution.juridique.MDLitige.DAO;


import com.ynsolution.juridique.MDLitige.Entite.Adverse;
import com.ynsolution.juridique.utilitaire.MbHibernateDaoSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("adverseDaoImp")
@Transactional
public class AdverseDaoImp extends MbHibernateDaoSupport implements IAdverseDao, Serializable{


    @Override
    public Long addAdverse(Adverse a) {
        Transaction tx = null;
        Session session = getSessionFactory().openSession();
        Long id ;
        id = 0L;
        try {
            session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction();
            id= (Long) session.save(a);
            tx.commit();
            session.close();
        } catch (Exception exp) {
            tx.rollback();
            session.close();
        } 
        return id;
    }

    @Override
    public void editAdverse(Adverse a) {
        Transaction tx = null;
        Session session = getSessionFactory().openSession();
        try {
            session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction();
            session.update(a);
            tx.commit();
            session.close();
        } catch (Exception exp) {
            System.out.println("exception : " + exp.getMessage());
            tx.rollback();
            session.close();
        } 
    }

    @Override
    public void remouveAdverse(Adverse a) {
        Transaction tx = null;
        Session session = getSessionFactory().openSession();
        try {
            session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction();
            session.delete(a);
            tx.commit();
            session.close();
        } catch (Exception exp) {
            System.out.println("exception : " + exp.getMessage());
            tx.rollback();
            session.close();
        } 
    }

    @Override
    public Adverse allAdverseById(Long id) {
         Adverse  a = new Adverse();
        try {
             a =  this.getHibernateTemplate().load(Adverse.class, id);
        } catch (Exception e) {
            System.out.println("Erreur de récupération  Adverse car "+e.getMessage());
        }
        return a;
    }

    @Override
    public List<Adverse> allAdverse() {
        List<Adverse>  l = new ArrayList<Adverse>();
        try {
               l = this.getHibernateTemplate().loadAll(Adverse.class);        } catch (Exception e) {
            System.out.println("Erreur de récupération liste des Adverse car "+e.getMessage());
        }
        return l;
    }

    
}
 