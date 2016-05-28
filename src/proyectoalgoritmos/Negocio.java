package proyectoalgoritmos;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import proyectoalgoritmos.api.ListaSimple;
import proyectoalgoritmos.api.Nodo;

/**
 *
 * @author Alejandra Bohorquez 1151109
 */
public class Negocio {

    private ListaSimple secuencia;//Vector de subsecuencias
    private ListaSimple subsMayor;//Subsecuencia mas larga
    private ListaSimple sumZero;//Subsecuencia de suma cero

    public Negocio() {
        this.secuencia = new ListaSimple();
        this.subsMayor = new ListaSimple();
        this.sumZero = new ListaSimple();
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
        Nodo nodo= this.secuencia.getCab();
         LinkedList<Integer> l1 = new LinkedList<Integer>(), 
                            l2 = new LinkedList<Integer>();
        int aux = 0;
        while (n > 0) {
            n--;
            int temp = nodo.getInfo();
            nodo = nodo.getSig();
            if (temp > aux) {
                l2.add(temp);
                aux = temp;
            } else {
                aux = temp;
                if (l2.size() > l1.size()) {
                    l1 = l2;
                }
                l2 = new LinkedList<Integer>();
                l2.add(temp);
            }
            
        }
        for (Integer integer : l1) {
            this.subsMayor.addFin(integer);
        }
  
        return "Secuencia entrante: "+"\n"+
                this.secuencia.toString()+
                "\n"+"Secuencia Mayor: "+
                "\n"+this.subsMayor.toString();
    }

    public String hallarSubsecuenciaLargaRecursiva(String ruta) {

        this.procesarArchivo(ruta);
        //hallar la mas larga
        // recursivo

        return "Secuencia entrante: "+"\n"+
                this.secuencia.toString()+
                "\n"+"Secuencia Mayor: "+
                "\n"+this.subsMayor.toString();
    }

    private Nodo hallarSubs(Nodo cab) {
        return null;
    }

    public String hallarSubsecuenciaCero(String ruta) {

        this.procesarArchivo(ruta);
        //hallar secuencia 
        return "Secuencia entrante: "+"\n"+
                this.secuencia.toString()+
                "\n"+"Secuencia Suma Cero: "+
                "\n"+this.sumZero.toString();
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
