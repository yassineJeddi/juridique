/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDConf.Idao;

import com.ynsolution.juridique.MDConf.Entite.Avocat;
import java.util.List;

/**
 *
 * @author yassine
 */
public interface IAvocatDAO {
    
    public void addAvocat(Avocat a);
    public void editAvocat(Avocat a);
    public void remouvAvocat(Avocat a);
    public Avocat avocatById(Integer id);
    public List<Avocat> allAvocat();
    public List<Avocat> allAvocatActive();
    public List<Avocat> allAvocatByCritere(Avocat a);
    
}
