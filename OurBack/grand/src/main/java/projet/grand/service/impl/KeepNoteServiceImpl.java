package projet.grand.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.grand.bean.commun.KeepNote;
import projet.grand.dao.commun.KeepNoteDao;
import projet.grand.service.facade.KeepNoteService;

import java.util.List;

@Service
public class KeepNoteServiceImpl implements KeepNoteService {




    @Override
    public List<KeepNote> findByHeaderOrBody(String header, String body) {
        return keepNoteDao.findByHeaderOrBody(header, body);
    }

    @Override
    public List<KeepNote> findByEmailRef(String ref) {
        return keepNoteDao.findByEmailRef(ref);
    }

    @Override
    public int deleteByEmailRef(String ref) {
        return keepNoteDao.deleteByEmailRef(ref);
    }
    @Override
    public List<KeepNote> findByPersonneEmail(String email) {
        return keepNoteDao.findByPersonneEmail(email);
    }

    @Override
    public int deleteByPersonneEmail(String email) {
        return keepNoteDao.deleteByPersonneEmail(email);
    }

    @Autowired
    private KeepNoteDao keepNoteDao;
}
