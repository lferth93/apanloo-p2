package uam.apanloo.biblioteca;

import java.util.Iterator;

public interface Lista <T>{
    void agregar(T e, int posicion);
    void agregar(T e);
    T eliminar();
    T eliminar(int posicion);
    T consultar();
    T consultar(int posicion);
    int tamanio();
    void limpiar();
    boolean esVacia();
    Iterator<T> iterator();
}
