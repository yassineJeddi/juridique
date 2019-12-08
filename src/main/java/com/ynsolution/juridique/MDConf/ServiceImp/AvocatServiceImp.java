/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDConf.ServiceImp;

import com.ynsolution.juridique.MDConf.IService.IAvocatService;
import com.ynsolution.juridique.MDConf.Idao.IAvocatDAO;
import com.ynsolution.juridique.MDConf.Entite.Avocat;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yassine
 */
@Service("avocatService")
public class AvocatServiceImp implements IAvocatService , Serializable{

    
    @Autowired
    private IAvocatDAO avocatDAOImp;

    public IAvocatDAO getAvocatDAOImp() {
        return avocatDAOImp;
    }

    public void setAvocatDAOImp(IAvocatDAO avocatDAOImp) {
        this.avocatDAOImp = avocatDAOImp;
    }

    
    @Override
    public void addAvocat(Avocat a) {
        avocatDAOImp.addAvocat(a);
    }

    @Override
    public void editAvocat(Avocat a) {
        avocatDAOImp.addAvocat(a);
    }

    @Override
    public void remouvAvocat(Avocat a) {
        avocatDAOImp.remouvAvocat(a);
    }

    @Override
    public Avocat avocatById(Integer id) {
        return avocatDAOImp.avocatById(id);
    }

    @Override
    public List<Avocat> allAvocat() {
        return avocatDAOImp.allAvocat();
    }

    @Override
    public List<Avocat> allAvocatActive() {
        return avocatDAOImp.allAvocatActive();
    }

    @Override
    public List<Avocat> allAvocatByCritere(Avocat a) {
         return avocatDAOImp.allAvocatByCritere(a);
    }
    
}
