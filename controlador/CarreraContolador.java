/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import acceso.CarreraDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Carrera;
import vista.CarreraVista;

/**
 *
 * @author
 */
public class CarreraContolador {

    private CarreraVista vista;
    private CarreraDAO modelo;

    public CarreraContolador(CarreraVista vista, CarreraDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        this.vista.addListenerBtnCrear(new CarreraListener());
        this.vista.addListenerBtnModificar(new CarreraListener());
        this.vista.addListenerBtnGrabar(new CarreraListener());
        this.vista.addListenerBtnCancelar(new CarreraListener());
        this.vista.addListenerBtnActualizar(new CarreraListener());
        this.vista.addListenerBtnEliminar(new CarreraListener());
        this.vista.addListenerBtnSalir(new CarreraListener());
        
        ArrayList<Carrera> listadoCarrera;
        listadoCarrera = this.modelo.getListCarrera(0); 
        this.vista.cargarCarrea(listadoCarrera);

    }
    class CarreraListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getActionCommand().equalsIgnoreCase("crear")){
                vista.Crear(false);
            }else if(e.getActionCommand().equalsIgnoreCase("cancelar")){
                vista.activarControles(false);
            }else if(e.getActionCommand().equalsIgnoreCase("modificar")){
                vista.Modificar(false);
            }else if(e.getActionCommand().equalsIgnoreCase("salir")){
                vista.salir();
            }else if(e.getActionCommand().equalsIgnoreCase("grabar")){
                registrar();
            }else if(e.getActionCommand().equalsIgnoreCase("eliminar")){
                borrar();
            }else if(e.getActionCommand().equalsIgnoreCase("actualizar")){
                actualizar();
            }
        } 
        // Método para registrar un nuevo carrera en la BD
        private void registrar(){
            if(vista.txtId.getText().equals("")){
            //if(vista.getId()== 0){
                vista.gestionMensajes("Ingrese los datos de la nueva carrera",
                        "Aviso", JOptionPane.ERROR_MESSAGE);
            }else{
                Carrera carrera = new Carrera();
                carrera.setId(vista.getId());
                carrera.setNombre(vista.getNombre());
                carrera.setCapacidad(vista.getCapacidad());
                carrera.setExigencia(vista.getExigencia());
                carrera.setModalidad(vista.getModalidad());
                
                int tamaño;
                tamaño = modelo.getListCarrera(carrera.getId()).size();
                if(tamaño == 0){
                    int resultado = 0;
                    resultado = modelo.nuevaCarrera(carrera);
                    if(resultado == 1){
                        vista.gestionMensajes("Registro creado con exito",
                                "Aviso",JOptionPane.INFORMATION_MESSAGE);                        
                        ArrayList<Carrera> listadoCarrera;
                        listadoCarrera = modelo.getListCarrera(0);
                        vista.cargarCarrea(listadoCarrera);
                        vista.activarControles(false);
                    }else{
                        vista.gestionMensajes("su registro no fue almacenado",
                                "Alerta",JOptionPane.ERROR);
                    }
                }else{
                    vista.gestionMensajes("El registro ya existe",
                            "Advertencia",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        // Método borrar un carrera de la BD
        private void borrar(){

            if(vista.txtId.getText().equals("")){
                vista.gestionMensajes("Cargue los registros y seleccione "
                        + "de la lista el registro a eliminar",
                        "Aviso",JOptionPane.ERROR_MESSAGE);
            }else{
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "¿Desea Eleminar al carrera: " +
                        vista.getNombre()+ " ?", "Advertencia",
                        JOptionPane.YES_NO_OPTION);
                
                if(respuesta == JOptionPane.YES_NO_OPTION){
                    if(modelo.eliminarCarrera(vista.getId()) == 1){
                        JOptionPane.showMessageDialog(null,
                                "Su registro fue eliminado",
                                "Aviso",
                                JOptionPane.INFORMATION_MESSAGE);
                        vista.limpiarTabla();
                        ArrayList<Carrera> listadoCarrera;
                        listadoCarrera = modelo.getListCarrera(0);
                        vista.cargarCarrea(listadoCarrera);
                    }else{
                        JOptionPane.showMessageDialog(null,"NO fue posible "
                                + "borrar su registro", "Alerta",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        // Método para actulizar un carrera en la BD
        private void actualizar(){
            // creacion de un objeto Carrera
            Carrera carrera = new Carrera();
            carrera.setId(vista.getId());
            carrera.setNombre(vista.getNombre());
            carrera.setCapacidad(vista.getCapacidad());
            carrera.setExigencia(vista.getExigencia());
            carrera.setModalidad(vista.getModalidad());
           if(modelo.actualizarCarrera(carrera) == 1){
                vista.gestionMensajes("Registro Actualizado con exito",
                        "Anuncio", JOptionPane.INFORMATION_MESSAGE);
                vista.activarControles(false);
                ArrayList<Carrera> listadoCarrera;
                listadoCarrera = modelo.getListCarrera(0);
                vista.cargarCarrea(listadoCarrera);
            }
        } 
    } 

}
