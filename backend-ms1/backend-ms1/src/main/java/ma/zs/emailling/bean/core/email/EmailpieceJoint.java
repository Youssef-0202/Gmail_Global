package ma.zs.emailling.bean.core.email;

import java.util.Objects;





import ma.zs.emailling.bean.core.email.Email;
import ma.zs.emailling.bean.core.commun.TypeContenu;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.emailling.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "emailpiece_joint")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="emailpiece_joint_seq",sequenceName="emailpiece_joint_seq",allocationSize=1, initialValue = 1)
public class EmailpieceJoint   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String path;
    @Column(length = 500)
    private String taille;

    private Email email ;
    private TypeContenu typeContenu ;


    public EmailpieceJoint(){
        super();
    }

    public EmailpieceJoint(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="emailpiece_joint_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email")
    public Email getEmail(){
        return this.email;
    }
    public void setEmail(Email email){
        this.email = email;
    }
    public String getPath(){
        return this.path;
    }
    public void setPath(String path){
        this.path = path;
    }
    public String getTaille(){
        return this.taille;
    }
    public void setTaille(String taille){
        this.taille = taille;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_contenu")
    public TypeContenu getTypeContenu(){
        return this.typeContenu;
    }
    public void setTypeContenu(TypeContenu typeContenu){
        this.typeContenu = typeContenu;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailpieceJoint emailpieceJoint = (EmailpieceJoint) o;
        return id != null && id.equals(emailpieceJoint.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

