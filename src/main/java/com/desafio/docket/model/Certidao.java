package com.desafio.docket.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "certidao")
public class Certidao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 250)
    private String nome;

    @ManyToMany(mappedBy = "listaCertidoes")
    private Set<Cartorio> listaCartorios;
}
