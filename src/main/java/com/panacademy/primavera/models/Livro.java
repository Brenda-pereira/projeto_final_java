package com.panacademy.primavera.models;

import javax.persistence.*;

@Entity
@Table (name="livros")
public class Livro {
    @Id
    private String isbn;
    @Column (nullable = false)
    private String nome;
    @Column (length = 140)
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "id_autor_fk")
    private Autor autor;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}

