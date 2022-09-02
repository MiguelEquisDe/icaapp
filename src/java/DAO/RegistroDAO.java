/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexBD.conex;
import beens.RegistroBeens;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vargas
 */
public class RegistroDAO {

    conex con = new conex();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;
    int resultado;

    public int insertar(RegistroBeens r) {
        String SQL = "insert into registro(nombres,contacto,correo,rol)"
                + "values(?,?,?,?)";
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(SQL);

            ps.setString(1, r.getNombres());
            ps.setString(2, r.getContacto());
            ps.setString(3, r.getCorreo());
            ps.setString(4, r.getRol());

            ps.executeUpdate();

        } catch (SQLException e) {
        }
        return resultado;
    }

    public RegistroBeens validar(String usr) {
        RegistroBeens BeensI = new RegistroBeens();
        String SQL = "select * from registro where nombres=?";
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(SQL);
            ps.setString(1, usr);
            rs = ps.executeQuery();
            while (rs.next()) {
                BeensI.setId_registro(rs.getInt("id_registro"));
                BeensI.setNombres(rs.getString("nombres"));
                BeensI.setContacto(rs.getString("contacto"));
                BeensI.setCorreo(rs.getString("correo"));
                BeensI.setRol(rs.getString("rol"));
            }
        } catch (SQLException e) {
        }
        return BeensI;
    }

    public List getAll() {
        String SQL = "select * from registro";
        List<RegistroBeens> lista = new ArrayList<>();
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                RegistroBeens Beens = new RegistroBeens();
                Beens.setId_registro(rs.getInt("id_registro"));
                Beens.setNombres(rs.getString("nombres"));
                Beens.setContacto(rs.getString("contacto"));
                Beens.setCorreo(rs.getString("correo"));
                Beens.setRol(rs.getString("rol"));
                if (!Beens.getRol().equals("Administrador")) {
                    lista.add(Beens);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public RegistroBeens cargar(int id_registro) {
        RegistroBeens BeensCargar = new RegistroBeens();
        String SQL = " select * from registro where id_registro=" + id_registro;
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                BeensCargar.setNombres(rs.getString(2));
                BeensCargar.setContacto(rs.getString(3));
                BeensCargar.setCorreo(rs.getString(4));
                BeensCargar.setRol(rs.getString(5));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            Logger.getLogger(RegistroBeens.class.getName()).log(Level.SEVERE, null, ex);
        }
        return BeensCargar;
    }

    public boolean eliminar(int id_registro) {
        String SQL = "delete from registro where id_registro=" + id_registro;

        try {
            cnx = con.ConexBD();
            Statement st;
            st = cnx.createStatement();
            int estado = st.executeUpdate(SQL);
            if (estado > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int modificar(RegistroBeens Rm) {

        String SQL = "update registro set nombres=?, contacto=?, correo=?, rol=?" + "where id_registro=?";
        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(SQL);

            ps.setString(1, Rm.getNombres());
            ps.setString(2, Rm.getContacto());
            ps.setString(3, Rm.getCorreo());
            ps.setString(4, Rm.getRol());
            ps.setInt(5, Rm.getId_registro());

            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return resultado;
    }
}
