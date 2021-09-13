/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import acceso.CarreraDAO;
import controlador.CarreraContolador;
import java.util.ArrayList;
import modelo.Carrera;
import vista.CarreraVista;

/**
 *
 * @author 
 */
public class Principal {
    public static void main(String[] args) {
        CarreraVista gui = new CarreraVista();
        gui.setTitle("Pilotos Formula Tapitas");
        gui.setEnabled(true);
        gui.setVisible(true);
        CarreraDAO carreraDao = new CarreraDAO();
        CarreraContolador carreraContolador = new CarreraContolador(gui,carreraDao);
        //Carrera nuevaCarrera = new Carrera(4, "Tocancipa", 15000, (float)5.4, true);
        //carreraDao.nuevaCarrera(nuevaCarrera);
        
       ArrayList<Carrera> listadoCarrera = carreraDao.getListCarrera(0);
       
       /*for(Carrera carrera : listadoCarrera){
           System.out.println(carrera.getId()+" "+carrera.getNombre()+" "+
                   carrera.getCapacidad()+" "+carrera.getExigencia()+" "+
                   carrera.isModalidad());
       }*/
       
    }
    
}
