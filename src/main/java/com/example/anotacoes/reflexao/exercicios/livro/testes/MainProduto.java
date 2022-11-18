package com.example.anotacoes.reflexao.exercicios.livro.testes;

import com.example.anotacoes.reflexao.exercicios.livro.model.Produto;
import com.example.anotacoes.reflexao.exercicios.livro.reflexao.GeradorMapa;
import com.example.anotacoes.reflexao.exercicios.livro.reflexao.GeradorMapaPerformace;

import java.util.Map;

public class MainProduto {
    public static void main(String[] args) {

        Produto produto = new Produto("monitor", "29p'", 1700.00, "eletronicos");
        GeradorMapaPerformace geradorMapaPerformace = new GeradorMapaPerformace(Produto.class);

        Map<String, Object> stringObjectMap = geradorMapaPerformace.gerarMapa(produto);

        Map<String, Object> popsProduto = GeradorMapa.gerar(produto);

        popsProduto.forEach((p, q)-> System.out.println(p + " " + q));

        stringObjectMap.forEach((p, q)-> System.out.println(p + " " + q));


    }
}
