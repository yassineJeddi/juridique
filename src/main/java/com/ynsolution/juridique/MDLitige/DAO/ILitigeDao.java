/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDLitige.DAO;

import com.ynsolution.juridique.MDLitige.Entite.Litige;
import java.util.List;

/**
 *
 * @author yassine
 */
public interface ILitigeDao {
    
    public Long addLitige(Litige l);
    public void editLitige(Litige l);
    public void remouveLitige(Litige l);
    public List<Litige> allLitige();
    public Litige litigeById(Long id);
    
}
