import java.util.ArrayList;
import java.util.List;
public class MiListaDoble implements ListInterface {
    private DoubleNode cabeza;
    private DoubleNode cola;
    public MiListaDoble() {
        cabeza = null;
        cola = null;
    }
    @Override
    public boolean isEmpty() {
        return  cabeza == null;
    }
    @Override
    public int getSize() {
        int contador = 0;
        DoubleNode iterador = cabeza;
        while (iterador != null) {
            contador++;
            iterador = iterador.siguiente;
        }
        return contador;
    }
    @Override
    public void clear(){
        cabeza = null;
        cola = null;
    }
    @Override
    public Object getHead() {
        if (cabeza != null) {
            return cabeza.dato;
        }else {
            return null;
        }
    }
    @Override
    public Object getTail() {
        if (cola != null) {
            return cola.dato;
        } else {
            return null;
        }
    }
    @Override
    public Object get(DoubleNode node) {
        DoubleNode iterador = cabeza;
        while (iterador != null) {
            if (iterador == node) {
                return iterador.dato;
            }
            iterador = iterador.siguiente;
        }
        return null;
    }
    @Override
    public DoubleNode search(Object object) {
        DoubleNode iterador = cabeza;
        while (iterador != null) {
            if (iterador.dato.equals(object)) {
                return iterador;
            }
            iterador = iterador.siguiente;
        }
        return null;
    }
    @Override
    public boolean add(Object object) {
        DoubleNode nuevo = new DoubleNode(object);
    if(cabeza == null){
        cabeza = nuevo;
        cola = nuevo;
    }else {
        cola.siguiente = nuevo;
        nuevo.anterior = cola;
        cola = nuevo;
        }
    return true;
    }
    @Override
    public boolean insert(DoubleNode node, Object object) {
        DoubleNode nuevo = new DoubleNode(object);
        if(node == null){
            return false;
        }
        if(node == cola) {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
            return true;
        } else {
            nuevo.siguiente = node.siguiente;
            nuevo.anterior = node;
            node.siguiente.anterior = nuevo;
            node.siguiente = nuevo;
            return true;
        }
    }
    @Override
    public boolean insert(Object objectRef, Object object) {
        DoubleNode iterador = cabeza;
        DoubleNode nuevo = new DoubleNode(object);
        if (objectRef == null){
            return false;
        }
        while (iterador != null){
            if (iterador.dato.equals(objectRef)) {
                if (iterador == cola) {
                    cola.siguiente = nuevo;
                    nuevo.anterior = cola;
                    cola = nuevo;
                    return true;
                }else {
                    nuevo.siguiente = iterador.siguiente;
                    nuevo.anterior = iterador;
                    iterador.siguiente.anterior = nuevo;
                    iterador.siguiente = nuevo;
                    return true;
                }
            }
            iterador = iterador.siguiente;
        }
        return false;
    }
    @Override
    public boolean insertHead(Object object){
        DoubleNode nuevo = new DoubleNode(object);
        if(cabeza == null){
            cabeza = nuevo;
            cola = nuevo;
            return true;
        }else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
            return true;
        }
    }
    @Override
    public boolean insertTail(Object object){
        DoubleNode nuevo = new DoubleNode(object);
        if(cabeza == null){
            cabeza = nuevo;
            cola = nuevo;
            return true;
        }else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
            return true;
        }
    }
    @Override
    public boolean set(DoubleNode node, Object object){
        if(cabeza == null || node == null){
            return false;
        }else {
            node.dato = object;
            return true;
        }
    }
    @Override
    public boolean remove(DoubleNode node){
        if (node == null){
            return false;
        }
        if (node == cola) {
            if (cola.anterior != null) {
                cola = cola.anterior;
                cola.siguiente = null;
            }else{
                cola = null;
                cabeza = null;
            }
            return true;
        }
        if (node == cabeza){
            if(cabeza.siguiente != null){
                cabeza = cabeza.siguiente;
                cabeza.anterior = null;
            }else {
                cabeza = null;
                cola = null;
            }
            return true;
        }
        node.anterior.siguiente = node.siguiente;
        node.siguiente.anterior = node.anterior;
        return true;
    }
    @Override
    public boolean contains(Object object){
        DoubleNode iterador = cabeza;
        while (iterador != null){
            if (iterador.dato.equals(object)){
                return true;
            }
            iterador = iterador.siguiente;
        }
        return false;
    }
    @Override
    public Object[] toArray(){
        int size = 0;
        DoubleNode iterador = cabeza;
        while (iterador != null){
            size++;
            iterador = iterador.siguiente;
        }
        Object[] array = new Object[size];
        iterador = cabeza;
        int i = 0;
        while (iterador != null){
            array[i++] = iterador.dato;
            iterador = iterador.siguiente;
        }
        return array;
    }
    @Override
    public Object[] toArray(Object[] object){
        int i = 0;
        DoubleNode iterador = cabeza;
        while (iterador != null && i < object.length){
            object[i++] = iterador.dato;
            iterador = iterador.siguiente;
        }
        return object;
    }
    @Override
    public MiListaDoble subList(DoubleNode from, DoubleNode to){
        MiListaDoble nueva = new MiListaDoble();
        DoubleNode iterador = from;
        while (iterador != null){
            nueva.add(iterador.dato);
            if(iterador == to){
                break;
            }
            iterador = iterador.siguiente;
        }
        return nueva;
    }
    @Override
    public MiListaDoble sortList(){
        if(cabeza == null){
            return this;
        }
        boolean swapped ;
        do {
            swapped = false;
            DoubleNode iterador =cabeza;
            while (iterador.siguiente != null){
                if(((Comparable)iterador.dato).compareTo(iterador.siguiente.dato)>0){
                    Object temp = iterador.dato;
                    iterador.dato = iterador.siguiente.dato;
                    iterador.siguiente.dato = temp;
                    swapped = true;
                }
                iterador =iterador.siguiente;
            }
        }while(swapped);
        return this;
    }
}