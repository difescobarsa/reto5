/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import acceso.CarreraDAO;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Carrera;

/**
 *
 * @author
 */
public class CarreraVista extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public CarreraVista() {
        initComponents();
    }
    // Método que limpia el JTable
    public void limpiarTabla(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtCarrera.getModel();
        for(int i=modelo.getRowCount()-1; i>=0 ; i--){
            modelo.removeRow(i);
        }
    }
    
    public void limpiarCampos(){
        txtId.setText("");
        txtNombre.setText("");
        txtCapacidad.setText("");
        txtExigencia.setText("");
        txtModalidad.setText("");
    }
    // Recupera el dato del Id de la carrea
    public int getId(){
        return Integer.parseInt(txtId.getText().trim());
    }
    // Recupera el dato del nombre de la carrera
    public String getNombre(){
        return txtNombre.getText();
    }
    // Recupera el dato de la capacidad de asistentes
    public int getCapacidad(){
        return Integer.parseInt(txtCapacidad.getText());
    }
    // Recupera el dato del nivel de exigencia
    public float getExigencia(){
        return Float.parseFloat(txtExigencia.getText());
    }
    // Recupera si es true o false si se puede correr bajo techo
    public boolean getModalidad(){
        return Boolean.parseBoolean(txtModalidad.getText());
    }

     // Métodos que agregan el ActionListener a cada control o botón utilizado     
    public void addListenerBtnCrear(ActionListener listenPrograma){
        btnCrear.addActionListener(listenPrograma);       
    }
    public void addListenerBtnModificar(ActionListener listenPrograma){
        btnModificar.addActionListener(listenPrograma);        
    }
    public void addListenerBtnEliminar(ActionListener listenPrograma){
        btnEliminar.addActionListener(listenPrograma);        
    }
    public void addListenerBtnCancelar(ActionListener listenPrograma){
        btnCancelar.addActionListener(listenPrograma);        
    }
    public void addListenerBtnGrabar(ActionListener listenPrograma){
        btnGrabar.addActionListener(listenPrograma);        
    }
    public void addListenerBtnActualizar(ActionListener listenPrograma){
        btnActualizar.addActionListener(listenPrograma);        
    }
    public void addListenerBtnSalir(ActionListener listenPrograma){
        btnSalir.addActionListener(listenPrograma);        
    } 
    public void gestionMensajes(String mensaje, String titulo, int icono){
         JOptionPane.showMessageDialog(this,mensaje, titulo, icono);
    }
        // limpia la pantalla y la deja en su estado incial
        public void activarControles(boolean estado){
        txtId.setText("");
        txtNombre.setText("");
        txtCapacidad.setText("");
        txtExigencia.setText("");
        txtModalidad.setText("");
        txtId.setEnabled(estado);
        txtNombre.setEnabled(estado);
        txtCapacidad.setEnabled(estado);
        txtExigencia.setEnabled(estado);
        txtModalidad.setEnabled(estado);
        txtModalidad.setEnabled(estado);
        jtCarrera.setEnabled(!estado);
        btnCrear.setEnabled(!estado);
        btnModificar.setEnabled(!estado);
        btnEliminar.setEnabled(!estado);
        btnCancelar.setEnabled(estado);
        btnSalir.setEnabled(!estado);
        btnGrabar.setEnabled(estado);
        btnActualizar.setEnabled(estado);
        
    } 
    // actualiza el jtable despues de acciones como crear, moficar o eliminar
    public void cargarCarrea(ArrayList<Carrera> listadoCarrera){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtCarrera.getModel();        
        limpiarTabla();
        for(int i= 0; i < listadoCarrera.size(); i++){
              modelo.addRow(new Object[]{
                listadoCarrera.get(i).getId(),
                listadoCarrera.get(i).getNombre(),
                listadoCarrera.get(i).getCapacidad(),
                listadoCarrera.get(i).getExigencia(),
                listadoCarrera.get(i).isModalidad()
              });
        }
    }
    // prepara la vista para crear un nuevo carrera
    public void Crear(boolean estado){              
        txtId.setEnabled(!estado);
        txtNombre.setEnabled(!estado);
        txtCapacidad.setEnabled(!estado);
        txtExigencia.setEnabled(!estado);
        txtModalidad.setEnabled(!estado);
        txtId.setText("");
        txtNombre.setText("");
        txtCapacidad.setText("");
        txtExigencia.setText("");
        txtModalidad.setText("");
        jtCarrera.setEnabled(estado);
        btnCrear.setEnabled(estado);
        btnModificar.setEnabled(estado);
        btnEliminar.setEnabled(estado);
        btnCancelar.setEnabled(!estado);
        btnSalir.setEnabled(estado);
        btnGrabar.setEnabled(!estado);
        btnActualizar.setEnabled(estado);
        txtId.requestFocusInWindow();
    }
    // prepra la vista para modificar un carrera
    public void Modificar(boolean estado){
        if(btnModificar.getText().equals("Modificar")){
            if(jtCarrera.getSelectedRow() == -1){
               if(jtCarrera.getRowCount() == 0){
                   JOptionPane.showMessageDialog(this,"seleccione la carrera"
                           + "que desea modificar");
               }
               else{
                   JOptionPane.showMessageDialog(this,"Seleccione una carrera "
                           + "de la tabla");
               }
            }else{
                txtId.setEnabled(estado);
                txtNombre.setEnabled(!estado);
                txtCapacidad.setEnabled(!estado);
                txtExigencia.setEnabled(!estado);
                txtModalidad.setEnabled(!estado);
                btnCrear.setEnabled(estado);
                btnModificar.setEnabled(estado);
                btnEliminar.setEnabled(estado);
                btnCancelar.setEnabled(!estado);
                btnActualizar.setEnabled(!estado);
                btnSalir.setEnabled(estado);
                txtNombre.requestFocusInWindow();
            }
        }
    }    
    // sale del programa
    public void salir(){
        System.exit(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCarrera = new javax.swing.JTable();
        lblId = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCapacidad = new javax.swing.JLabel();
        lblExigencia = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCapacidad = new javax.swing.JTextField();
        txtExigencia = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        lblIdModalidad = new javax.swing.JLabel();
        txtModalidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtCarrera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Piloto", "Nombre", "Millas", "Combustible", "Id Escuderia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtCarrera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCarreraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCarrera);

        lblId.setText("Id Carrea");

        lblNombre.setText("Nonbre Carrera");

        lblCapacidad.setText("Capacidad");

        lblExigencia.setText("Nivel Exigencia");

        txtId.setEnabled(false);

        txtNombre.setEnabled(false);

        txtCapacidad.setEnabled(false);

        txtExigencia.setEnabled(false);

        btnCrear.setText("Crear");

        btnModificar.setText("Modificar");

        btnEliminar.setText("Eliminar");

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);

        btnSalir.setText("Salir");

        btnGrabar.setText("Grabar");
        btnGrabar.setEnabled(false);

        btnActualizar.setText("Actualizar");
        btnActualizar.setEnabled(false);

        lblIdModalidad.setText("Bajo Techo");

        txtModalidad.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Proyecto Reto 5 Ciclo 2 Grupo P11");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Integrantes:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Juliio Andrés Montana Mendoza");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Diego Fernando Escobar Sarmiento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnActualizar)
                                .addGap(33, 33, 33)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblExigencia)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblId)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIdModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNombre)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCapacidad)
                                .addGap(18, 18, 18)
                                .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCapacidad)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExigencia)
                    .addComponent(txtExigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdModalidad)
                    .addComponent(txtModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrear)
                            .addComponent(btnGrabar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnModificar)
                                    .addComponent(btnActualizar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(btnCancelar)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar)
                            .addComponent(btnSalir))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

// metodo para capturar datos del jtable y pasarlo a los campos de texto
    private void jtCarreraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCarreraMouseClicked
        // TODO add your handling code here:
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtCarrera.getModel();
                    
        if(jtCarrera.getSelectedRow()==-1){
            if(jtCarrera.getRowCount()==0){
                JOptionPane.showMessageDialog(this,"Tabla sin registros");
            }
            else{
                JOptionPane.showMessageDialog(this,"Seleccione un registro de "
                        + "la tabla");
            }
        }else {                     
            txtId.setText(modelo.getValueAt(
                    jtCarrera.getSelectedRow(), 0).toString());            
            txtNombre.setText(modelo.getValueAt(
                    jtCarrera.getSelectedRow(), 1).toString());
            txtCapacidad.setText(modelo.getValueAt(
                    jtCarrera.getSelectedRow(), 2).toString());
            txtExigencia.setText(modelo.getValueAt(
                    jtCarrera.getSelectedRow(), 3).toString());
            txtModalidad.setText(modelo.getValueAt(
                    jtCarrera.getSelectedRow(), 4).toString());
        }
        
    }//GEN-LAST:event_jtCarreraMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CarreraVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarreraVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarreraVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarreraVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarreraVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnCrear;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGrabar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtCarrera;
    public javax.swing.JLabel lblCapacidad;
    public javax.swing.JLabel lblExigencia;
    public javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdModalidad;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JTextField txtCapacidad;
    public javax.swing.JTextField txtExigencia;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtModalidad;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
