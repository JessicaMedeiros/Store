package io.github.jessicamedeiros.store.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {

    //função para tratar o caso do cliente pesquisar uma string com caractere não permitido, como espaço vazio " exemplo"

    public static String decodeParam(String s) {
        try {
            return URLDecoder.decode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static List<Integer> decodeIntList(String s) {
        String[] vet = s.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<vet.length; i++) {
            list.add(Integer.parseInt(vet[i]));
        }
        return list;
        //return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
    }


}
