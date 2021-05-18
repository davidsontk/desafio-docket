package com.desafio.docket.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "cartorio")
public class Cartorio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 300)
    private String nome;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
            name = "cartorio_certidao",
            joinColumns = @JoinColumn(name = "cartorio_id"),
            inverseJoinColumns = @JoinColumn(name = "certidao_id"))
    private Set<Certidao> listaCertidoes;

}
