package com.desafio.docket.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Data
@Entity
@Table(name = "endereco")
public class Endereco  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 300)
    private String rua;

    @Column(length = 100)
    private String numero;

//    @ManyToOne
//    @JoinColumn(name = "cartorio_id", referencedColumnName = "id")
//    private Cartorio cartorio;

}
