package com.ynsolution.juridique.MDLitige.Service;



import com.ynsolution.juridique.MDLitige.DAO.IAdverseDao;
import com.ynsolution.juridique.MDLitige.Entite.Adverse;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adverseService")
public class AdverseServiceImp implements Serializable,IAdverseService {
   
    @Autowired
    private IAdverseDao adverseDaoImp;

    public IAdverseDao getAdverseDaoImp() {
        return adverseDaoImp;
    }

    public void setAdverseDaoImp(IAdverseDao adverseDaoImp) {
        this.adverseDaoImp = adverseDaoImp;
    }
     
     
     
    @Override
    public Long addAdverse(Adverse a) {
        return adverseDaoImp.addAdverse(a);
    }

    @Override
    public void editAdverse(Adverse a) {
       adverseDaoImp.editAdverse(a);
    }

    @Override
    public void remouveAdverse(Adverse a) {
        adverseDaoImp.remouveAdverse(a);
    }

    @Override
    public List<Adverse> allAdverse() {
        return adverseDaoImp.allAdverse();
    }

    @Override
    public Adverse allAdverseById(Long id) {
       return adverseDaoImp.allAdverseById(id);
    }

   
}