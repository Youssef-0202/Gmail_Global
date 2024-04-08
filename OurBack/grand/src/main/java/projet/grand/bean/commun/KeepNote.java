package projet.grand.bean.commun;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import projet.grand.bean.email.Email;

import java.time.LocalDateTime;

@Entity
public class KeepNote {
    @Id
    private Long id;


    private String body;
    private String header;
    @ManyToOne
    private User personne;

    @ManyToOne
    private Email email;
    private LocalDateTime dateKeepNote;







    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
