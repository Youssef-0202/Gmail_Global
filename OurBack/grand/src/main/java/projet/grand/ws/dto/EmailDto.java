package projet.grand.ws.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.ManyToOne;
import projet.grand.bean.commun.Category;
import projet.grand.bean.commun.User;

import java.time.LocalDateTime;

public class EmailDto {
    private Long id;
    private String ref;
    private User personneSource;
    @JsonFormat(pattern = "dd-mm-yyyy-hh:mm:ss")
    private LocalDateTime dateEnvoi;
    private Category category;
    private String corps;
    private String header;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public User getPersonneSource() {
        return personneSource;
    }

    public void setPersonneSource(User personneSource) {
        this.personneSource = personneSource;
    }

    public LocalDateTime getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(LocalDateTime dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }


}
