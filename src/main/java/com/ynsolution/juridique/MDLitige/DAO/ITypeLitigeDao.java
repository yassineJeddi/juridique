package com.ynsolution.juridique.MDLitige.DAO;


import com.ynsolution.juridique.MDLitige.Entite.TypeLitige;
import java.util.List;


public interface ITypeLitigeDao {
    
    public Long addTypeLitige(TypeLitige t);
    public void editTypeLitige(TypeLitige t);
    public void remouveTypeLitige(TypeLitige t);
    public List<TypeLitige> allTypeLitige();
    public TypeLitige allTypeLitigeById(Long id);
    
}