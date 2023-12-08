package uam.apanloo.biblioteca;

import java.util.Iterator;

public interface Lista <T extends Comparable<T>> extends Iterable<T>{
    void agregar(T e, int posicion);
    void agregar(T e);
    T eliminar();
    T eliminar(int posicion);
    T consultar();
    T consultar(int posicion);
    void actualizar(int posicion, T elemento);
    int tamanio();
    void limpiar();
    boolean esVacia();
    Iterator<T> iterator();
}
