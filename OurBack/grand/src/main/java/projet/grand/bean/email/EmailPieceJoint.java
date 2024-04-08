package projet.grand.bean.email;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class EmailPieceJoint {


    @Id
    private Long id;

    @ManyToOne
     private Email email;
     private String path;
     private BigDecimal taille;
     private String typeContenu;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
