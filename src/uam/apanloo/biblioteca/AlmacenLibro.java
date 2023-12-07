package uam.apanloo.biblioteca;

public interface AlmacenLibro {
    public void agregarLibro(Libro l);
    Lista<Libro> buscarLibro(String buscado, String criterio);
    Libro eliminarLibro(String isbn);
    void actualizarLibro(Libro l);
    int contarLibros();
    int contarLibros(String buscar,String criterio);
    Libro[] ordenarLibro(String criterio);
}
