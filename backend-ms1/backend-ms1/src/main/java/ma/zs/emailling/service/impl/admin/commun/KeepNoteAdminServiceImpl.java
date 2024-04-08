package ma.zs.emailling.service.impl.admin.commun;


import ma.zs.emailling.bean.core.commun.KeepNote;
import ma.zs.emailling.dao.criteria.core.commun.KeepNoteCriteria;
import ma.zs.emailling.dao.facade.core.commun.KeepNoteDao;
import ma.zs.emailling.dao.specification.core.commun.KeepNoteSpecification;
import ma.zs.emailling.service.facade.admin.commun.KeepNoteAdminService;
import ma.zs.emailling.zynerator.service.AbstractServiceImpl;
import ma.zs.emailling.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.emailling.service.facade.admin.commun.UtilisateurAdminService ;
import ma.zs.emailling.bean.core.commun.Utilisateur ;

import java.util.List;
@Service
public class KeepNoteAdminServiceImpl extends AbstractServiceImpl<KeepNote, KeepNoteCriteria, KeepNoteDao> implements KeepNoteAdminService {






    public void findOrSaveAssociatedObject(KeepNote t){
        if( t != null) {
            t.setPersonne(utilisateurService.findOrSave(t.getPersonne()));
        }
    }

    public List<KeepNote> findByPersonneId(Long id){
        return dao.findByPersonneId(id);
    }
    public int deleteByPersonneId(Long id){
        return dao.deleteByPersonneId(id);
    }
    public long countByPersonneId(Long id){
        return dao.countByPersonneId(id);
    }






    public void configure() {
        super.configure(KeepNote.class, KeepNoteSpecification.class);
    }


    @Autowired
    private UtilisateurAdminService utilisateurService ;

    public KeepNoteAdminServiceImpl(KeepNoteDao dao) {
        super(dao);
    }

}
