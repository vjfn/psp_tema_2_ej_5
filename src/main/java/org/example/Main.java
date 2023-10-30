package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> lista = new ArrayList<>();
        lista.add(8);
        lista.add(7);
        lista.add(6);
        lista.add(5);
        lista.add(2);
        lista.add(4);

        Nodo raiz = new Nodo(lista);
        raiz.ordenar();
        System.out.println(lista);
    }
}