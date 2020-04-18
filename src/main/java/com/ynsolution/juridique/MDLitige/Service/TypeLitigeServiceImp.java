package com.ynsolution.juridique.MDLitige.Service;


import com.ynsolution.juridique.MDLitige.DAO.ITypeLitigeDao;
import com.ynsolution.juridique.MDLitige.Entite.TypeLitige;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("typeLitigeService")
public class TypeLitigeServiceImp implements Serializable,ITypeLitigeService {
   
    @Autowired
    private ITypeLitigeDao typeLitigeDaoImp;

    public ITypeLitigeDao getTypeLitigeDaoImp() {
        return typeLitigeDaoImp;
    }

    public void setTypeLitigeDaoImp(ITypeLitigeDao typeLitigeDaoImp) {
        this.typeLitigeDaoImp = typeLitigeDaoImp;
    }

    @Override
    public Long addTypeLitige(TypeLitige t) {
        return typeLitigeDaoImp.addTypeLitige(t);
    }

    @Override
    public void editTypeLitige(TypeLitige t) {
       typeLitigeDaoImp.editTypeLitige(t);
    }

    @Override
    public void remouveTypeLitige(TypeLitige t) {
        typeLitigeDaoImp.remouveTypeLitige(t);
    }

    @Override
    public List<TypeLitige> allTypeLitige() {
        return typeLitigeDaoImp.allTypeLitige();
    }

    @Override
    public TypeLitige allTypeLitigeById(Long id) {
       return typeLitigeDaoImp.allTypeLitigeById(id);
    }

   

}