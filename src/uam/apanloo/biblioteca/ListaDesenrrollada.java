package uam.apanloo.biblioteca;

import java.util.Arrays;
import java.util.Iterator;

public class ListaDesenrrollada<T> implements Lista<T>{
    int size;
    Node first;
    Node last;
    int nodeCap = 7;

    @Override
    public void agregar(T e, int posicion) {
        
    }

    @Override
    public void agregar(T e) {
        if (first == null){
            first = new Node(nodeCap);
            last = first;
        }

        if (last.size  == last.cap){
            Node nuevo = new Node(nodeCap);
            last.size = (last.cap+1)/2;
            System.arraycopy(last.elements, last.size, nuevo.elements, 0, last.elements.length-last.size);
            nuevo.size = nuevo.cap/2;
            last.next = nuevo;
            last = nuevo;
        }

        last.elements[last.size] = e;
        last.size++;
        size++;
    }

    @Override
    public T eliminar() {
        if (last == null){
            return null;
        }
        last.size--;
        T element = last.elements[last.size];
        if(last.size == 0){
            last = last.prev;
        }
        size--; 
        return element;
    }

    @Override
    public T eliminar(int posicion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public T consultar() {
        if(last == null){
            return null;
        }
        return last.elements[last.size-1];
    }

    @Override
    public T consultar(int posicion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultar'");
    }

    @Override
    public void actualizar(int posicion, Object elemento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public int tamanio() {
        return size;
    }

    @Override
    public void limpiar() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean esVacia() {
        return size == 0;
    }

    private void addNode(){
        if (first == null){
            first = new Node(nodeCap);
            last = first;
        }else{
            Node nuevo = new Node(nodeCap);
            last.next = nuevo;
            last = nuevo;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node n = first;
            int index = 0;

            @Override
            public boolean hasNext() {
                return n != null && index < n.size;
            }

            @Override
            public T next() {
                if(!hasNext()){
                    return null;
                }

                T e = n.elements[index];
                index++;
                if (index >= n.size){
                    index = 0;
                    n = n.next;
                }
                return e;
            }
            
        };
    }
    
    private class Node {
        T[] elements;
        int size;
        int cap;
        Node next;
        Node prev;

        Node (int cap){
            @SuppressWarnings("unchecked") 
            T[] array = (T[]) new Object[cap];
            elements = array;
            this.cap = cap;
        }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("{size:"+size+",");
            sb.append(Arrays.toString(elements)+"}");
            return sb.toString();
        }
    }
}
