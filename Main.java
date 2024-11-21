import java.util.LinkedList;
import java.util.Queue;

class Nodo {
    String dato;
    Nodo izquierda, derecha;

    public Nodo(String dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }
}

class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    // Método para agregar un nodo al árbol binario
    public void agregar(String dato) {
        raiz = agregarRecursivo(raiz, dato);
    }

    private Nodo agregarRecursivo(Nodo nodo, String dato) {
        if (nodo == null) {
            return new Nodo(dato);
        }

        if (dato.compareTo(nodo.dato) < 0) {  // Usar compareTo para cadenas
            nodo.izquierda = agregarRecursivo(nodo.izquierda, dato);
        } else if (dato.compareTo(nodo.dato) > 0) {
            nodo.derecha = agregarRecursivo(nodo.derecha, dato);
        }

        return nodo;
    }

    // Recorrido preorden
    public void preorden() {
        System.out.print("Recorrido en preorden: \n");
        preordenRecursivo(raiz);
        System.out.println();
    }

    private void preordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            preordenRecursivo(nodo.izquierda);
            preordenRecursivo(nodo.derecha);
        }
    }

    // Recorrido inorden
    public void inorden() {
        System.out.print("Recorrido en inorden: \n");
        inordenRecursivo(raiz);
        System.out.println();
    }

    private void inordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.izquierda);
            System.out.print(nodo.dato + " ");
            inordenRecursivo(nodo.derecha);
        }
    }

    // Recorrido postorden
    public void postorden() {
        System.out.print("Recorrido en postorden: \n");
        postordenRecursivo(raiz);
        System.out.println();
    }

    private void postordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            postordenRecursivo(nodo.izquierda);
            postordenRecursivo(nodo.derecha);
            System.out.print(nodo.dato + " ");
        }
    }

    // Recorrido por amplitud (BFS)
    public void recorridoPorAmplitud() {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        System.out.print("Recorrido por amplitud: \n");

        Queue<Nodo> cola = new LinkedList<>();
        cola.offer(raiz);

        while (!cola.isEmpty()) {
            Nodo nodoActual = cola.poll();
            System.out.print(nodoActual.dato + " ");

            if (nodoActual.izquierda != null) {
                cola.offer(nodoActual.izquierda);
            }

            if (nodoActual.derecha != null) {
                cola.offer(nodoActual.derecha);
            }
        }

        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.agregar("55");
        arbol.agregar("53");
        arbol.agregar("59");
        arbol.agregar("48");
        arbol.agregar("54");
        arbol.agregar("56");
        arbol.agregar("63");
        arbol.agregar("51");
        arbol.agregar("57");
        arbol.agregar("61");
        arbol.agregar("70");

        arbol.recorridoPorAmplitud();
        System.out.println("");
        arbol.preorden();
        System.out.println("");
        arbol.inorden(); 
        System.out.println("");
        arbol.postorden();
        
    }
}
