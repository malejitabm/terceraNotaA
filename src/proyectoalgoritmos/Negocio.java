package proyectoalgoritmos;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import proyectoalgoritmos.api.ListaSimple;
import proyectoalgoritmos.api.Nodo;

/**
 *
 * @author Alejandra Bohorquez 1151109
 */
public class Negocio {

    private ListaSimple secuencia;//Vector de subsecuencias

    public Negocio() {
        this.secuencia = new ListaSimple();
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
        ListaSimple l1 = new ListaSimple(),
                l2 = new ListaSimple();
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
                l2 = new ListaSimple();
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

    private Nodo hallarSubs(Nodo cab) {
        return null;
    }

    public String hallarSubsecuenciaCero(String ruta) {

        this.procesarArchivo(ruta);
        //hallar secuencia suma cero
        Nodo inicio = this.secuencia.getCab();
        Nodo fin = this.secuencia.getCab();
        Nodo aux = this.secuencia.getCab();
        int suma =0;
       
        while (aux!= null) {
            suma += aux.getInfo();
            if(suma==0){
                break;
            }else{
                aux=aux.getSig();
                fin =aux;
            }
            
        }

        return "Secuencia entrante: " + "\n"
                + this.secuencia.toString()
                + "\n" + "Secuencia Suma Cero: "
                + "\n";
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
                ListaSimple sub = new ListaSimple();
                subs = s.split("/");
                for (int i = 0; i < subs.length; i++) {
                    this.secuencia.addFin(Integer.valueOf(subs[i]));
                }
            }
        }
        //this.secuencia.toString();
    }

}
