package com.example.anotacoes.reflexao.exercicios.livro.reflexao;

import com.example.anotacoes.reflexao.exercicios.livro.anotations.Ignorar;
import com.example.anotacoes.reflexao.exercicios.livro.anotations.NomePropriedade;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class GeradorMapa {

    public static Map<String, Object> gerar(Object o) {
        Class<?> classe = o.getClass();
        Map<String, Object> mapa = new HashMap<>();

        for (Method m : classe.getMethods()) {
            try {
                if (isGetter(m)) {
                    String propriedade = null;
                    if (m.isAnnotationPresent(NomePropriedade.class)) {
                        propriedade = m.getAnnotation(NomePropriedade.class).value();
                    } else {
                        propriedade = deGetterParaPropriedade(m.getName());
                    }
                    Object invoke = m.invoke(o);
                    mapa.put(propriedade, invoke);
                }
            } catch (Exception e) {
                System.out.println("Erro no gerar");
            }
        }
        return mapa;
    }

    private static String deGetterParaPropriedade(String nomePropriedade) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(nomePropriedade.substring(3, 4).toLowerCase());
        stringBuffer.append(nomePropriedade.substring(4));
        return stringBuffer.toString();
    }

    private static boolean isGetter(Method m) {
        return m.getName().startsWith("get")
                && m.getReturnType() != void.class
                && m.getParameterTypes().length == 0 &&
                !m.isAnnotationPresent(Ignorar.class);

    }

}


