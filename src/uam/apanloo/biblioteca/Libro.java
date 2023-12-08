package uam.apanloo.biblioteca;

public class Libro implements Comparable<Libro>{
    String titulo;
    String autor;
    String isbn;
    String idioma;
    Editorial editorial;
    Fecha fechaPublicacion;

    public Libro(String titulo, String autor, String isbn, String idioma, Editorial editorial, int dia, int mes, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.idioma = idioma;
        this.editorial = editorial;
        this.fechaPublicacion = new Fecha(dia, mes, anio);
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public Editorial getEditorial() {
        return editorial;
    }
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    public String getFechaPublicacion() {
        return fechaPublicacion.toString();
    }
    public void setFechaPublicacion(int dia,int mes, int anio) {
        fechaPublicacion.setAnio(anio);
        fechaPublicacion.setMes(mes);
        fechaPublicacion.setDia(dia);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Titulo: "+titulo+"\n");
        sb.append("Autor: "+autor+"\n");
        sb.append("Fecha de publicacion: "+fechaPublicacion+"\n");
        return sb.toString();
    }
    @Override
    public int compareTo(Libro o) {
        return titulo.compareTo(o.titulo);
    }
}
