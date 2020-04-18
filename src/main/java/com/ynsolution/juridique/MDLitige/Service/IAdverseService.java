package com.ynsolution.juridique.MDLitige.Service;


import com.ynsolution.juridique.MDLitige.Entite.Adverse;
import java.util.List;


public interface IAdverseService {
    
    public Long addAdverse(Adverse a);
    public void editAdverse(Adverse a);
    public void remouveAdverse(Adverse a);
    public List<Adverse> allAdverse();
    public Adverse allAdverseById(Long id);
    
}