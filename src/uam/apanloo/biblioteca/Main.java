package uam.apanloo.biblioteca;

public class Main {
    public static void main(String[] args){
        Lista<Integer> l = new ListaLigada<>();
        l.agregar(0);
        l.agregar(4);
        l.agregar(5,0);
        System.out.println(l.consultar());
        System.out.println(l.consultar(0));
        System.out.println(l.tamanio());
        System.out.println("Elementos de l:");
        for(Integer i : l){
            System.out.println(i);
        }

        l.agregar(7,3);
        l.eliminar(1);
        System.out.println(l.consultar(3));
        System.out.println(l.tamanio());
        System.out.println("Elementos de l:");
        for(Integer i : l){
            System.out.println(i);
        }

        ListaDesenrrollada<Integer> ul = new ListaDesenrrollada<>();
        for(int i = 0; i < 10; i++)
            ul.agregar(i);
        ul.eliminar(0);
        System.out.println("Elementos de ul:");
        for(Integer i : ul){
            System.out.println(i);
        }
        ListaDesenrrollada<Integer>.Node n = ul.first;
        while(n != null){
            System.out.println(n);
            n = n.next;
        }
        System.out.println(ul.consultar(0));
    }
}
