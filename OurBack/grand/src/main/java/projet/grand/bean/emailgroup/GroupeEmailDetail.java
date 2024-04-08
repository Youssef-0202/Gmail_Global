package projet.grand.bean.emailgroup;


import jakarta.persistence.*;
import projet.grand.bean.commun.User;

import java.time.LocalDateTime;
//tableaux d'association entre User et GroupEmail
//personnes
@Entity
public class GroupeEmailDetail {
    @Id
    private Long id;

    @OneToOne
    private User personne;

    private LocalDateTime dateAjoute;
    private LocalDateTime dateBlockage;

    @OneToOne
    private GroupeEmail groupeEmail;

    private boolean admin;

    public User getPersonne() {
        return personne;
    }

    public void setPersonne(User personne) {
        this.personne = personne;
    }

    public LocalDateTime getDateAjoute() {
        return dateAjoute;
    }

    public void setDateAjoute(LocalDateTime dateAjoute) {
        this.dateAjoute = dateAjoute;
    }

    public LocalDateTime getDateBlockage() {
        return dateBlockage;
    }

    public void setDateBlockage(LocalDateTime dateBlockage) {
        this.dateBlockage = dateBlockage;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
