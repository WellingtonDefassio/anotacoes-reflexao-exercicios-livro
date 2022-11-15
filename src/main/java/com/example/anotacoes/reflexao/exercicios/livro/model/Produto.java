package com.example.anotacoes.reflexao.exercicios.livro.model;

import com.example.anotacoes.reflexao.exercicios.livro.anotations.Ignorar;
import com.example.anotacoes.reflexao.exercicios.livro.anotations.NomePropriedade;

public class Produto {

    String nome;
    String descricao;
    Double preco;
    String categoria;

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
    @Ignorar()
    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    @NomePropriedade("catigoria")
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Produto(String nome, String descricao, Double preco, String categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }
}
