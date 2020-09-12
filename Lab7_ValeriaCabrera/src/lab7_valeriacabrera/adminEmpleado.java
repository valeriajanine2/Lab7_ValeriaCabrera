package lab7_valeriacabrera;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class adminEmpleado {

    private ArrayList<Empleado> listaEmpleado = new ArrayList(); //memoria ram
    private File archivo = null;//memoria rom

    public adminEmpleado(String path) {
        archivo = new File(path);
    }

    public ArrayList<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(ArrayList<Cliente> listaCliente) {
        this.listaEmpleado = listaEmpleado;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "listaPersonas=" + listaEmpleado;
    }

    //extra mutador
    public void setEmpleado(Empleado p) {
        this.listaEmpleado.add(p);
    }

    public void cargarArchivo() {
        try {            
            listaEmpleado = new ArrayList();//limpiar el arraylist
            Empleado temp;
            if (archivo.exists()) {//para evitar exception
                  FileInputStream entrada = new FileInputStream(archivo); //apuntar al archivo
                ObjectInputStream objeto = new ObjectInputStream(entrada);//apuntando hacia el canal
                try {
                    //leyendo de objeto en objeto
                    while ((temp = (Empleado) objeto.readObject()) != null) {//iterar lo que esta en el buffer
                        listaEmpleado.add(temp);//se agrega cada objeto al arraylist
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
            for (Empleado t : listaEmpleado) {
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

