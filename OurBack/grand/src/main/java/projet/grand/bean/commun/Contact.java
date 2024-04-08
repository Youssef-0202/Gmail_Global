package projet.grand.bean.commun;


import jakarta.persistence.*;

@Entity
public class Contact {
    @Id
    private Long id;
    private String name;

    @ManyToOne
    private User personneSource;
    @ManyToOne
    private User personneDestination;

    public User getPersonneSource() {
        return personneSource;
    }

    public void setPersonneSource(User personneSource) {
        this.personneSource = personneSource;
    }

    public User getPersonneDestination() {
        return personneDestination;
    }

    public void setPersonneDestination(User personneDestination) {
        this.personneDestination = personneDestination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
