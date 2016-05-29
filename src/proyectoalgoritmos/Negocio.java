package proyectoalgoritmos;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import proyectoalgoritmos.api.Lista;
import proyectoalgoritmos.api.Nodo;

/**
 *
 * @author Alejandra Bohorquez 1151109
 */
public class Negocio {

    private Lista secuencia;//Vector de subsecuencias

    public Negocio() {
        this.secuencia = new Lista();
    }

    /**
     * Metodo que encuentra la subsecuencia ascendente mas larga
     *
     * @param ruta direccion del archivo
     * @return la subsecuencia mas larga
     */
    public String hallarSubsecuenciaLargaIterativa(String ruta) {

        this.procesarArchivo(ruta);
        int n = this.secuencia.getSize();
        Nodo nodo = this.secuencia.getCab();
        Lista l1 = new Lista();
        Lista l2 = new Lista();
        int aux = 0;
        while (n > 0) {
            n--;
            int temp = nodo.getInfo();
            nodo = nodo.getSig();
            if (temp > aux) {
                l2.addFin(temp);
                aux = temp;
            } else {
                aux = temp;
                if (l2.getSize() > l1.getSize()) {
                    l1 = l2;
                }
                l2 = new Lista();
                l2.addFin(temp);
            }
        }
        return "Secuencia entrante: " + "\n"
                + this.secuencia.toString()
                + "\n" + "Secuencia Mayor: "
                + "\n" + l1.toString();
    }

    public String hallarSubsecuenciaLargaRecursiva(String ruta) {

        this.procesarArchivo(ruta);
        //hallar la mas larga
        // recursivo

        return "Secuencia entrante: " + "\n"
                + this.secuencia.toString()
                + "\n" + "Secuencia Mayor: "
                + "\n";
    }

    public String hallarSubsecuenciaCero(String ruta) {

        this.procesarArchivo(ruta);
        //hallar secuencia suma cero

        ArrayList<Lista> temp = this.hallarSecuenciaConsecutivo();

        Nodo inicio = this.secuencia.getCab();
        boolean encontro = false;
        Nodo fin = null;
        Nodo aux = null;
        int suma = 0;

        while (inicio != null && !encontro) {
            aux = inicio;
            
            while (aux.getSig() != null) {
               
                if (aux.getInfo() + 1 == aux.getSig().getInfo()) {
                    suma += aux.getInfo();
                    if (suma == 0) {
                        fin = aux;
                        encontro = true;
                        break;
                    }
                }
                aux = aux.getSig();
            }
            if (encontro) {
                break;
            }
            suma = 0;
            inicio = inicio.getSig();
        }
        System.out.println(inicio.getInfo() + "--" + fin.getInfo());
        return "Secuencia entrante: " + "\n"
                + this.secuencia.toString()
                + "\n" + "Secuencia Suma Cero: "
                + "\n";
    }

    private ArrayList hallarSecuenciaConsecutivo() {

        ArrayList<Lista> temp = new ArrayList<>();
        Nodo aux = this.secuencia.getCab();
        int mayor = aux.getInfo();

        while (aux.getSig() != null) {

        }

        return temp;
    }

    private ArrayList<String> leerArchivo(String nombreArchivo) {
        ArrayList<String> lineas = null;

        try {
            // Abre el archivo
            FileInputStream fstream = new FileInputStream(nombreArchivo);
            lineas = new ArrayList<String>();

            // Obtiene el DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            // Lee linea por linea
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                lineas.add(strLine);
            }

            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            return null;
        }

        return lineas;
    }

    private void procesarArchivo(String nombreArchivo) {
        String[] subs = null;
        ArrayList<String> lineas = leerArchivo(nombreArchivo);
        if (lineas != null) {
            for (String s : lineas) {
                Lista sub = new Lista();
                subs = s.split("/");
                for (int i = 0; i < subs.length; i++) {
                    this.secuencia.addFin(Integer.valueOf(subs[i]));
                }
            }
        }
        //this.secuencia.toString();
    }

}
