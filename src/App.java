import uam.apanloo.biblioteca.Biblioteca;
import uam.apanloo.biblioteca.Editorial;
import uam.apanloo.biblioteca.Libro;

public class App {
    public static void main(String[] args){
        Biblioteca b = new Biblioteca();
        Editorial e = new Editorial("CRC", null, null, null);
        Libro l = new Libro("The Universal Computer", "Martin Davis", "abcd1234", "Ingles", e, 1, 2, 2018);
        b.agregarLibro(l);
        for(Libro laux: b.buscarLibro("Martin Davis", "autor")){
            System.out.println(laux);
        }
    }
}
