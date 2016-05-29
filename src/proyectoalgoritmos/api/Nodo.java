package proyectoalgoritmos.api;

/**
 *
 * @author Alejandra Bohorquez 1151109
 */
public class Nodo {

    private int info;
    private Nodo sig;

   public Nodo() {
        this.info = 0;
        this.sig = null;
    }

   public Nodo(int info,Nodo sig) {
        this.info = info;
        this.sig = sig;
    }

  public  int getInfo() {
        return this.info;
    }

  public  Nodo getSig() {
        return this.sig;
    }

  public  void setInfo(int nuevo) {
        this.info = nuevo;
    }

  public  void setSig(Nodo nuevo) {
        this.sig = nuevo;
    }


}
