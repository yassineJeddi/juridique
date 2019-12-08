/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ynsolution.juridique.MDEntite.Idao;

import com.ynsolution.juridique.MDEntite.entite.TypeEntite;
import java.util.List;

/**
 *
 * @author yassine
 */
public interface ITypeEntiteDao {
    
    public void addTypeEntite(TypeEntite t);
    public void editTypeEntite(TypeEntite t);
    public void delleteTypeEntite(TypeEntite t);
    public List<TypeEntite> allTypeEntite();
    
}
