package lab7_valeriacabrera;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class adminCliente {

    private ArrayList<Cliente> listaCliente = new ArrayList(); //memoria ram
    private File archivo = null;//memoria rom

    public adminCliente(String path) {
        archivo = new File(path);
    }

    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "listaPersonas=" + listaCliente;
    }

    //extra mutador
    public void setCliente(Cliente p) {
        this.listaCliente.add(p);
    }

    public void cargarArchivo() {
        try {            
            listaCliente = new ArrayList();//limpiar el arraylist
            Cliente temp;
            if (archivo.exists()) {//para evitar exception
                  FileInputStream entrada = new FileInputStream(archivo); //apuntar al archivo
                ObjectInputStream objeto = new ObjectInputStream(entrada);//apuntando hacia el canal
                try {
                    //leyendo de objeto en objeto
                    while ((temp = (Cliente) objeto.readObject()) != null) {//iterar lo que esta en el buffer
                        listaCliente.add(temp);//se agrega cada objeto al arraylist
                    }
                } catch (EOFException e) {
                    //encontro el final del archivo
                }
                objeto.close();//cerrar el canal
                entrada.close();//cerrar el objeto
            } //fin if           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);//apuntando hacia el archivo
            bw = new ObjectOutputStream(fw);//apuntando hacia el canal
            //sobreescribir sobre el archivo
            for (Cliente t : listaCliente) {
                bw.writeObject(t);//escribiendo objetos
            }
            //cada nodo del arraylist se escribe
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }

}

