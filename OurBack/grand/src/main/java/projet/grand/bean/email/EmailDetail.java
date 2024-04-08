package projet.grand.bean.email;

import jakarta.persistence.*;
import projet.grand.bean.commun.EtatEmail;
import projet.grand.bean.commun.User;

import java.time.LocalDateTime;
//les destinataire de email(lignes)
@Entity
public class EmailDetail {
    @Id
    private Long id;
    @OneToOne
    private Email email;
     @OneToOne
    private User user;

     @OneToOne
     private EtatEmail etatEmail ;
    private LocalDateTime dateLecture;
    private LocalDateTime dateReception;



    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateLecture() {
        return dateLecture;
    }

    public void setDateLecture(LocalDateTime dateLecture) {
        this.dateLecture = dateLecture;
    }

    public LocalDateTime getDateReception() {
        return dateReception;
    }

    public void setDateReception(LocalDateTime dateReception) {
        this.dateReception = dateReception;
    }

    public Long getId() {
        return id;
    }
}
