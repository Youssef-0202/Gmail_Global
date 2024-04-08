package projet.grand.bean.commun;


import jakarta.persistence.*;
import projet.grand.bean.email.Email;

@Entity
public class EtatEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String etatLecture;
    private String priorite;

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @OneToOne
    private Email email;

    public String getEtatLecture() {
        return etatLecture;
    }

    public void setEtatLecture(String etatLecture) {
        this.etatLecture = etatLecture;
    }

    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }

    public boolean isEmailSuprimer() {
        return emailSuprimer;
    }

    public void setEmailSuprimer(boolean emailSuprimer) {
        this.emailSuprimer = emailSuprimer;
    }

    private boolean emailSuprimer;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
