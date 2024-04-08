package projet.grand.service.facade;

import projet.grand.bean.commun.KeepNote;

import java.util.List;

public interface KeepNoteService {
    List<KeepNote> findByHeaderOrBody(String header, String body);

    List<KeepNote> findByEmailRef(String ref);

    int deleteByEmailRef(String ref);

    List<KeepNote> findByPersonneEmail(String email);

    int deleteByPersonneEmail(String email);
}
