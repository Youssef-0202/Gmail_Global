package projet.grand.bean.emailgroup;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import projet.grand.bean.emailgroup.GroupeEmail;

import java.time.LocalDateTime;
//destination (groups)
@Entity
public class EmailDetailGroup {
    @Id
    private Long id;

    @OneToOne

    private GroupeEmail destination;

    private LocalDateTime dateReception;
    private LocalDateTime dateLecture;

    public void setId(Long id) {
        this.id = id;
    }

    public GroupeEmail getDestination() {
        return destination;
    }

    public void setDestination(GroupeEmail destination) {
        this.destination = destination;
    }

    public LocalDateTime getDateReception() {
        return dateReception;
    }

    public void setDateReception(LocalDateTime dateReception) {
        this.dateReception = dateReception;
    }

    public LocalDateTime getDateLecture() {
        return dateLecture;
    }

    public void setDateLecture(LocalDateTime dateLecture) {
        this.dateLecture = dateLecture;
    }

    public Long getId() {
        return id;
    }
}
