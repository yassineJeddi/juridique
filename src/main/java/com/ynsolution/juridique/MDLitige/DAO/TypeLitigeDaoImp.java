package com.ynsolution.juridique.MDLitige.DAO;


import com.ynsolution.juridique.MDLitige.Entite.TypeLitige;
import com.ynsolution.juridique.utilitaire.MbHibernateDaoSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("typeLitigeDaoImp")
@Transactional
public class TypeLitigeDaoImp extends MbHibernateDaoSupport implements ITypeLitigeDao , Serializable{


    @Override
    public Long addTypeLitige(TypeLitige t) {
        Transaction tx = null;
        Session session = getSessionFactory().openSession();
        Long id ;
        id = 0L;
        try {
            session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction();
            id= (Long) session.save(t);
            tx.commit();
            session.close();
        } catch (Exception exp) {
            tx.rollback();
            session.close();
        } 
        return id;
    }

    @Override
    public void editTypeLitige(TypeLitige t) {
        Transaction tx = null;
        Session session = getSessionFactory().openSession();
        try {
            session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction();
            session.update(t);
            tx.commit();
            session.close();
        } catch (Exception exp) {
            System.out.println("exception : " + exp.getMessage());
            tx.rollback();
            session.close();
        } 
    }

    @Override
    public void remouveTypeLitige(TypeLitige t) {
        Transaction tx = null;
        Session session = getSessionFactory().openSession();
        try {
            session.setFlushMode(FlushMode.AUTO);
            tx = session.beginTransaction();
            session.delete(t);
            tx.commit();
            session.close();
        } catch (Exception exp) {
            System.out.println("exception : " + exp.getMessage());
            tx.rollback();
            session.close();
        } 
    }

    @Override
    public TypeLitige allTypeLitigeById(Long id) {
         TypeLitige  t = new TypeLitige();
        try {
             t =  this.getHibernateTemplate().load(TypeLitige.class, id);
        } catch (Exception e) {
            System.out.println("Erreur de récupération  TypeLitige car "+e.getMessage());
        }
        return t;
    }

    @Override
    public List<TypeLitige> allTypeLitige() {
        List<TypeLitige>  l = new ArrayList<TypeLitige>();
        try {
            l = this.getHibernateTemplate().loadAll(TypeLitige.class);
        } catch (Exception e) {
            System.out.println("Erreur de récupération liste des TypeLitige car "+e.getMessage());
        }
        return l;
    }

    
}
 