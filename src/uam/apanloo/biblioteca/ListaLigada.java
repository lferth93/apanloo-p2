package uam.apanloo.biblioteca;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaLigada <T> implements Lista<T> {

    private Nodo primero;
    private Nodo ultimo;
    private int tamanio;

    @Override
    public void agregar(T e, int posicion) {
        while (tamanio <= posicion) {
            agregar(null);
        }
        Nodo n = primero;
        for (int i = 0; i < posicion; i++) {
            n = n.siguiente; 
        }
        n.elemento = e;
    }

    @Override
    public void agregar(T e) {
        Nodo nuevo = new Nodo();
        nuevo.elemento = e;
        if(primero == null){
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = ultimo.siguiente;
        }
        tamanio++;
    }

    @Override
    public T eliminar() {
        if (tamanio == 0)
            return null;

        Nodo n = ultimo; 
        ultimo = ultimo.anterior;
        tamanio --;
        return n.elemento;
    }

    @Override
    public T eliminar(int posicion) {
        if (posicion < tamanio){
            Nodo n = primero;
            for (int i = 1; i < tamanio; i++) {
                n = n.siguiente;
            }
            if(n.siguiente != null)
                n.siguiente.anterior = n.anterior;
            if(n.anterior != null)
                n.anterior.siguiente = n.siguiente;
            tamanio--;
            return n.elemento;
        }
        return null;
    }

    @Override
    public T consultar() {
        if(ultimo != null){
            return ultimo.elemento;
        }
        return null;
    }

    @Override
    public T consultar(int posicion) {
        if (tamanio > posicion){
            Nodo n = primero;
            for (int i = 0; i < posicion; i++)
                n = n.siguiente; 

            return n.elemento;
        }
    return null;
    }

    @Override
    public int tamanio() {
        return tamanio;
    }

    @Override
    public void limpiar() {
        primero = null;
        ultimo = null;
        tamanio = 0;
    }

    @Override
    public boolean esVacia() {
        return tamanio == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Nodo n = primero;
            @Override
            public boolean hasNext(){
                return (n != null);
            }

            @Override
            public T next() {
                if (n == null)
                    throw new  NoSuchElementException();
                T element = n.elemento;
                n = n.siguiente;
                return element;
            }
        };
    }

    private class Nodo{
        T elemento;
        Nodo siguiente;
        Nodo anterior;
    }
}
