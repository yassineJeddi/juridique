/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDCtx.ServiceImp;

import com.ynsolution.juridique.MDCtx.IService.IContentieuxService;
import com.ynsolution.juridique.MDCtx.Idao.IContentieuxDao;
import com.ynsolution.juridique.MDCtx.entite.Contentieux;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yassine
 */
@Service("contentieuxService")
public class ContentieuxServiceImp implements IContentieuxService, Serializable    {

    
    @Autowired
    private IContentieuxDao contentieuxDao;

    public IContentieuxDao getContentieuxDao() {
        return contentieuxDao;
    }

    public void setContentieuxDao(IContentieuxDao contentieuxDao) {
        this.contentieuxDao = contentieuxDao;
    }
    
    
    
    
    @Override
    public void addContentieux(Contentieux c) {
        contentieuxDao.addContentieux(c);
    }

    @Override
    public void editContentieux(Contentieux c) {
        contentieuxDao.editContentieux(c);
    }

    @Override
    public void remouvContentieux(Contentieux c) {
        contentieuxDao.remouvContentieux(c);
    }

    @Override
    public Contentieux contentieuxById(Integer id) {
        return contentieuxDao.contentieuxById(id);
    }

    @Override
    public List<Contentieux> allContentieux() {
        return contentieuxDao.allContentieux();
    }
    
}
