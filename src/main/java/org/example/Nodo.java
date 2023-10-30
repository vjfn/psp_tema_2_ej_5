package org.example;

import java.util.ArrayList;
import java.util.List;

public class Nodo extends Thread {
    private List<Integer> lista;

    public Nodo(List<Integer> lista) {
        this.lista = lista;
    }

    public void ordenar() {
        Thread thread = new Thread(this);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        if (lista.size() <= 1) {
            return;
        }
        int mitad = lista.size() / 2;

        List<Integer> mitadIzquierda = new ArrayList<>(lista.subList(0, mitad));
        List<Integer> mitadDerecha = new ArrayList<>(lista.subList(mitad, lista.size()));

        Nodo nodoIzquierdo = new Nodo(mitadIzquierda);
        Nodo nodoDerecho = new Nodo(mitadDerecha);

        nodoIzquierdo.ordenar();
        nodoDerecho.ordenar();

        mezclar(mitadIzquierda, mitadDerecha);
    }

    private void mezclar(List<Integer> lista1, List<Integer> lista2) {
        List<Integer> resultado = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) < lista2.get(j)) {
                resultado.add(lista1.get(i));
                i++;
            } else {
                resultado.add(lista2.get(j));
                j++;
            }
        }

        while (i < lista1.size()) {
            resultado.add(lista1.get(i));
            i++;
        }

        while (j < lista2.size()) {
            resultado.add(lista2.get(j));
            j++;
        }
        lista.clear();
        lista.addAll(resultado);
    }
}
