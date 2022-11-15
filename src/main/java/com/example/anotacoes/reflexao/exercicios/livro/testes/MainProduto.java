package com.example.anotacoes.reflexao.exercicios.livro.testes;

import com.example.anotacoes.reflexao.exercicios.livro.model.Produto;
import com.example.anotacoes.reflexao.exercicios.livro.reflexao.GeradorMapa;

import java.util.Map;

public class MainProduto {
    public static void main(String[] args) {

        Produto produto = new Produto("monitor", "29p'", 1700.00, "eletronicos");

        Map<String, Object> popsProduto = GeradorMapa.gerar(produto);

        popsProduto.forEach((p, q)-> System.out.println(p + " " + q));


    }
}
