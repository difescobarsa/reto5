/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Carrera;
import servicios.Conexion;

/**
 *
 * @author
 */
public class CarreraDAO {
    
    /**
     * 
     * @param id_carrera
     * @return un ArrayList con los datos genrados de la consulta a la BD
     */
    public ArrayList<Carrera> getListCarrera(int id_carrera) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Carrera> listadoCarrera = new ArrayList();
        try {
            con = Conexion.getConnection();
            String sql = "";
            if (id_carrera == 0) {
                sql = "SELECT * FROM carrera ";
            } else {
                sql = "SELECT * FROM carrera WHERE id_carrera = ?";
            }
            ps = con.prepareStatement(sql);
            if (id_carrera != 0) {
                ps.setInt(1, id_carrera);
            }
            rs = ps.executeQuery();
            Carrera carrera = null;
            while (rs.next()) {
                carrera = new Carrera();
                carrera.setId(rs.getInt("id_carrera"));
                carrera.setNombre(rs.getString("nom_carrera"));
                carrera.setCapacidad(rs.getInt("capacidad"));
                carrera.setExigencia(rs.getFloat("nivel_exigencia"));
                carrera.setModalidad(rs.getBoolean("bajo_techo"));
                listadoCarrera.add(carrera);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
            }
        }
        return listadoCarrera;
    }
    // Método con sentencia para la creacion de un nuevo carrera
    public int nuevaCarrera (Carrera carrera) {
        Connection con = null;
        PreparedStatement ps = null;
        int resultado = 0;
        try {
            con = Conexion.getConnection();
            String sql = "";
            sql = "INSERT INTO carrera VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, carrera.getId());
            ps.setString(2, carrera.getNombre());
            ps.setInt(3, carrera.getCapacidad());
            ps.setFloat(4, carrera.getExigencia());
            ps.setBoolean(5 , carrera.isModalidad());
            resultado = ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
            }
        }
        return resultado;
    }
    // Método con sentencia para eliminar un carrera
    public int eliminarCarrera (int id_carrera) {
        Connection con = null;
        PreparedStatement ps = null;
        int resultado = 0;
        try {
            con = Conexion.getConnection();
            String sql = "";
            sql = "DELETE FROM carrera WHERE id_carrera = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_carrera);
            resultado = ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
            }
        }
        return resultado;
    }
        // Método con sentencia para actualizar el registro de un carrera
        public int actualizarCarrera (Carrera carrera) {
        Connection con = null;
        PreparedStatement ps = null;
        int resultado = 0;
        try {
            con = Conexion.getConnection();
            String sql = "";
            sql = "UPDATE carrera set nom_carrera = ?,capacidad = ?, "
                    + "nivel_exigencia = ?, bajo_techo = ? WHERE id_carrera = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, carrera.getNombre());
            ps.setInt(2, carrera.getCapacidad());
            ps.setFloat(3, carrera.getExigencia());
            ps.setBoolean(4, carrera.isModalidad());
            ps.setInt(5, carrera.getId());
            resultado = ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
            }
        }
        return resultado;
    }
    
}
