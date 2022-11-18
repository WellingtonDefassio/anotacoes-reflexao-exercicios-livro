package com.example.anotacoes.reflexao.exercicios.livro.reflexao;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FornecedorImplatacoes {

    private Map<Class<?>, Class<?>> implementacoes = new HashMap<>();

    public FornecedorImplatacoes(String nomeArquivo) throws Exception {
        Properties p = new Properties();
        p.load(new FileInputStream(nomeArquivo));
        for (Object x : p.keySet()) {
                Class<?> interfType = Class.forName(x.toString());
                Class<?> implType = Class.forName(p.get(x).toString());
                implementacoes.put(interfType, implType);
        }

    }

    public Class<?> getImplementacao(Class<?> x) {
        return implementacoes.get(x);
    }
}
