/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDCtx.Idao;

import com.ynsolution.juridique.MDCtx.entite.Contentieux;
import java.util.List;

/**
 *
 * @author yassine
 */
public interface IContentieuxDao {
    
    public void addContentieux(Contentieux c);
    public void editContentieux(Contentieux c);
    public void remouvContentieux(Contentieux c);
    public Contentieux contentieuxById(Integer id); 
    public List<Contentieux> allContentieux();
    
    
}
