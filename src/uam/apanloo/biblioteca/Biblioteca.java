package uam.apanloo.biblioteca;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Biblioteca implements AlmacenLibro{
    Lista<Libro> libros;

    public Biblioteca(){
        libros = new ListaLigada<>();
    }

    @Override
    public void agregarLibro(Libro l) {
        libros.agregar(l);
    }

    @Override
    public Lista<Libro> buscarLibro(String buscado, String criterio) {
        Lista<Libro> aux = new ListaLigada<>();
        try {
            Field f = Libro.class.getDeclaredField(criterio);
            f.setAccessible(true);
            for(Libro l: libros){
                if(f.get(l).toString().equals(buscado))
                    aux.agregar(l);
            }
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return aux;
    }

    @Override
    public Libro eliminarLibro(String isbn) {
        int i=0;
        for(Libro l : libros){
            if(l.getIsbn().equals(isbn))
                break;
        }
        if(i < libros.tamanio())
            return libros.eliminar(i);
        return null;
    }

    @Override
    public void actualizarLibro(Libro l) {
        int i=0;
        for(Libro laux : libros){
            if(l.getIsbn().equals(laux.getIsbn()))
                break;
        }
        if(i < libros.tamanio())
            libros.actualizar(i, l);
    }

    @Override
    public int contarLibros() {
        return libros.tamanio();
    }

    @Override
    public int contarLibros(String buscar, String criterio) {
        return buscarLibro(buscar, criterio).tamanio();
    }

    @Override
    public Libro[] ordenarLibro(String criterio) {
        Libro[] array = new Libro[libros.tamanio()];
        int i = 0;
        for(Libro l: libros){
            array[i] = l;
        }
        try {
            Field f = Libro.class.getDeclaredField(criterio);
            f.setAccessible(true);
            Arrays.sort(array,new Comparator<Libro>() {
                @Override
                public int compare(Libro o1, Libro o2) {
                    return f.get(o1).toString().compareTo(criterio);
                }
            });
        } catch (NoSuchFieldException | SecurityException | IllegalAccessException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return array;
    }
}
