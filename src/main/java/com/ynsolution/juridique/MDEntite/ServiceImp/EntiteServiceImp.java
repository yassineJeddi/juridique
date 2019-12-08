/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDEntite.ServiceImp;

import com.ynsolution.juridique.MDEntite.IService.IEntiteService;
import com.ynsolution.juridique.MDEntite.entite.Entite;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ynsolution.juridique.MDEntite.Idao.IEntiteDao;
import java.io.Serializable;

/**
 *
 * @author yassine
 */


@Service("entiteService")
public class EntiteServiceImp implements IEntiteService, Serializable  {


    @Autowired
    private IEntiteDao  entiteDao;

    public IEntiteDao getEntiteDao() {
        return entiteDao;
    }

    public void setEntiteDao(IEntiteDao entiteDao) {
        this.entiteDao = entiteDao;
    }

    @Override
    public void addEntite(Entite e) {
        entiteDao.addEntite(e);
    }

    @Override
    public void editEntite(Entite e) {
        entiteDao.editEntite(e);
    }

    @Override
    public void remouveEntite(int id) {
        entiteDao.remouveEntite(id);
    }

    @Override
    public Entite getEntiteById(int id) {
        return entiteDao.getEntiteById(id);
    }

    @Override
    public List<Entite> getAllEntie() {
        return entiteDao.getAllEntie();
    }
    
}
