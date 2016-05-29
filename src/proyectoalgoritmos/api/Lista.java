package proyectoalgoritmos.api;

/**
 *
 * @author Alejandra Bohorquez 
 * LISTA SIMPLE
 */
public class Lista {

    private Nodo cab;
    private int size;
    public Lista() {
        this.cab = null;
    }

    public Lista(Nodo cab) {
        this.cab = cab;
        this.size++;
    }

    public void addInicio(int x) {
        this.cab = new Nodo(x,this.cab);

    }

    public void addFin(int x) {
        if (this.cab == null) {
            this.addInicio(x);
        } else {
            Nodo aux = this.cab;
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            aux.setSig(new Nodo(x,null));
        }
        this.size++;
    }

    public boolean esVacia() {
        return (this.cab == null);
    }

    public String toString() {
        if (this.esVacia()) {
            return ("Lista Vacia");
        }
        String r = "";
        for (Nodo x = this.cab; x != null; x = x.getSig()) {
            r += x.getInfo() + "/";

        }
        return (r+"null");
    }

    public Nodo getCab() {
        return cab;
    }

    public void setCab(Nodo cab) {
        this.cab = cab;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    
    
}
