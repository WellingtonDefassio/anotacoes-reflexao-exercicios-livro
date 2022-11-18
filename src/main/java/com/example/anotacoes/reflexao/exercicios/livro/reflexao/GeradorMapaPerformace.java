package com.example.anotacoes.reflexao.exercicios.livro.reflexao;

import com.example.anotacoes.reflexao.exercicios.livro.anotations.Ignorar;
import com.example.anotacoes.reflexao.exercicios.livro.anotations.NomePropriedade;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class GeradorMapaPerformace {

    Class<?> classe;
    Map<String, Method> propriedades = new HashMap<>();

    public GeradorMapaPerformace(Class<?> classe) {
        this.classe = classe;
        for (Method m : classe.getMethods()) {
            if (isGetter(m)) {
                String propriedade = null;
                if (m.isAnnotationPresent(NomePropriedade.class)) {
                    propriedade = m.getAnnotation(NomePropriedade.class).value();
                } else {
                    propriedade = deGetterParaPropriedade(m.getName());
                }
                propriedades.put(propriedade, m);
            }
        }
    }

    public Map<String, Object> gerarMapa(Object o) {
        if(!classe.isInstance(o)){
            throw new RuntimeException("O objeto não é da classe " + classe.getName());
        }
        Map<String, Object> mapa = new HashMap<>();
        for (String propriedade : propriedades.keySet()) {
            try {
                Method m = propriedades.get(propriedade);
                Object valor = m.invoke(o);
                mapa.put(propriedade, valor);
            } catch (Exception e) {
                throw new RuntimeException("Problema ao gerar mapa");
            }

        }
        return mapa;
    }

    private String deGetterParaPropriedade(String nomePropriedade) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(nomePropriedade.substring(3, 4).toLowerCase());
        stringBuffer.append(nomePropriedade.substring(4));
        return stringBuffer.toString();
    }

    private boolean isGetter(Method m) {
        return m.getName().startsWith("get")
                && m.getReturnType() != void.class
                && m.getParameterTypes().length == 0 &&
                !m.isAnnotationPresent(Ignorar.class);

    }

}


