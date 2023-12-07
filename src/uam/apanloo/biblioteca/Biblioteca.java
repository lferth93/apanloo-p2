package uam.apanloo.biblioteca;

import java.lang.reflect.Field;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarLibro'");
    }

    @Override
    public void actualizarLibro(Libro l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarLibro'");
    }

    @Override
    public int contarLibros() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contarLibros'");
    }

    @Override
    public int contarLibros(String buscar, String criterio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contarLibros'");
    }

    @Override
    public Libro[] ordenarLibro(String criterio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ordenarLibro'");
    }
}
