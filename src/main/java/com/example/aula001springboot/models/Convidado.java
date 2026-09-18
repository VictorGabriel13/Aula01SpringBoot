package com.example.aula001springboot.models;

import jakarta.persistence.*;

@Entity
public class Convidado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String rg;

    @ManyToOne
    private Events evento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Events getEvento() {
        return evento;
    }

    public void setEvento(Events evento) {
        this.evento = evento;
    }
}
