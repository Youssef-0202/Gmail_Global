package projet.grand.bean.emailgroup;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class EmailGroupePieceJoint {

    @Id
    private Long id;

    private String path;
    private Long taille;
    private String typecontenu;

    @ManyToOne
    private GroupeEmail groupeEmail;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getTaille() {
        return taille;
    }

    public void setTaille(Long taille) {
        this.taille = taille;
    }

    public String getTypecontenu() {
        return typecontenu;
    }

    public void setTypecontenu(String typecontenu) {
        this.typecontenu = typecontenu;
    }

    public GroupeEmail getGroupeEmail() {
        return groupeEmail;
    }

    public void setGroupeEmail(GroupeEmail groupeEmail) {
        this.groupeEmail = groupeEmail;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
