/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDEntite.ServiceImp;

import com.ynsolution.juridique.MDEntite.IService.ITypeEntiteService;
import com.ynsolution.juridique.MDEntite.Idao.ITypeEntiteDao;
import com.ynsolution.juridique.MDEntite.entite.TypeEntite;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yassine
 */
@Service("typeEntiteService")
public class TypeEntiteServiceImp implements ITypeEntiteService , Serializable {

    @Autowired
    private ITypeEntiteDao typeEntiteDao;

    public ITypeEntiteDao getTypeEntiteDao() {
        return typeEntiteDao;
    }

    public void setTypeEntiteDao(ITypeEntiteDao typeEntiteDao) {
        this.typeEntiteDao = typeEntiteDao;
    }
    
    
    
    
    @Override
    public void addTypeEntite(TypeEntite t) {
        typeEntiteDao.addTypeEntite(t);
    }

    @Override
    public void editTypeEntite(TypeEntite t) {
        typeEntiteDao.editTypeEntite(t);
    }

    @Override
    public void delleteTypeEntite(TypeEntite t) {
        typeEntiteDao.delleteTypeEntite(t);
    }

    @Override
    public List<TypeEntite> allTypeEntite() {
        return typeEntiteDao.allTypeEntite();
    }
    
}
