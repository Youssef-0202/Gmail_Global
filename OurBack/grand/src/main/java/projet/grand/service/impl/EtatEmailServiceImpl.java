package projet.grand.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.grand.bean.commun.EtatEmail;
import projet.grand.dao.commun.EtatEmailDao;
import projet.grand.service.facade.EtatEmailService;

@Service
public class EtatEmailServiceImpl implements EtatEmailService {
    @Autowired
    private EtatEmailDao etatEmailDao;
    @Override
    public int deleteByEmailRef(String ref) {
        return etatEmailDao.deleteByEmailRef(ref);
    }
    @Override
    public EtatEmail findByEmailRef(String ref) {
        return etatEmailDao.findByEmailRef(ref);
    }
}
