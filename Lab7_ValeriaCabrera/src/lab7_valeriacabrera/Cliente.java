/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_valeriacabrera;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Cliente extends Persona{
    
    private ArrayList<Carros> carros = new ArrayList();

    public Cliente() {
        super();
    }

    public Cliente(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
    }

    public ArrayList<Carros> getCarros() {
        return carros;
    }

    public void setCarros(ArrayList<Carros> carros) {
        this.carros = carros;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
}
