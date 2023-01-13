package com.bolsadeideas.springboot.data.jpa.app.models.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity //Para las clases que están mapeadas a tablas en la base de datos
@Table(name = "clientes") //nombre de la tabla en la base de datos
public class Cliente implements Serializable { //Es recomendable aplicar Serializable a las clases entities para jpa o hibernate

    @Id //lave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private Long id;
    @NotEmpty
    @Size(min = 4)
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    @Email
    private String email;
    @NotNull
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE) //Indica el formato en que se va a guardar la fecha en la base de datos
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date createAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
