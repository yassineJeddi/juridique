/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDLitige.Service;

import com.ynsolution.juridique.MDLitige.DAO.ILitigeDao;
import com.ynsolution.juridique.MDLitige.Entite.Litige;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yassine
 */
@Service("litigeService")
public class LitigeServiceImp implements Serializable,ILitigeService {
   
    @Autowired
    private ILitigeDao litigeDaoImp;

    public ILitigeDao getLitigeDaoImp() {
        return litigeDaoImp;
    }

    public void setLitigeDaoImp(ILitigeDao litigeDaoImp) {
        this.litigeDaoImp = litigeDaoImp;
    }
     
    
    @Override
    public Long addLitige(Litige l) {
        return litigeDaoImp.addLitige(l);
    }

    @Override
    public void editLitige(Litige l) {
       litigeDaoImp.editLitige(l);
    }

    @Override
    public void remouveLitige(Litige l) {
        litigeDaoImp.remouveLitige(l);
    }

    @Override
    public List<Litige> allLitige() {
        return litigeDaoImp.allLitige();
    }

    @Override
    public Litige litigeById(Long id) {
       return litigeDaoImp.litigeById(id);
    }



}
