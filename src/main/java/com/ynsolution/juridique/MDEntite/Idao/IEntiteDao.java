/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDEntite.Idao;

import com.ynsolution.juridique.MDEntite.entite.Entite;
import java.util.List;

/**
 *
 * @author yassine
 */
public interface IEntiteDao {
    
    public void addEntite(Entite e);
    public void editEntite(Entite e);
    public void remouveEntite(int id);
    public Entite getEntiteById(int id);
    public List<Entite> getAllEntie();
    
}
