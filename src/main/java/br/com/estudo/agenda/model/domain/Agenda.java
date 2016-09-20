package br.com.estudo.agenda.model.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AGENDA")
public class Agenda implements Serializable {

    private static final long serialVersionUID = 8213054913532655960L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String lastName;
    @Column(length = 20, nullable = false)
    private String phone;
    @Column(length = 250, nullable = false)
    private String email;

    public Agenda() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agenda)) return false;

        Agenda agenda = (Agenda) o;

        return getId().equals(agenda.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
