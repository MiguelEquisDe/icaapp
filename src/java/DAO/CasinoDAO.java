/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConexBD.conex;
import beens.BeensCasinos;
import beens.RegistroBeens;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MIGUEL ANGEL
 */
public class CasinoDAO {

    conex con = new conex();
    Connection cnx;
    PreparedStatement ps;
    ResultSet rs;
    int resultado;

    public int insertar(BeensCasinos r) {
        String SQL = "insert into casinos(nombres,descripcion,img)" + "values(?,?,?)";

        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(SQL);

            ps.setString(1, r.getNombres());
            ps.setString(2, r.getDescripcion());
            ps.setBlob(3, r.getImg());

            ps.executeUpdate();

        } catch (SQLException e) {
        }
        return resultado;
    }

    public List getAll() {
        String SQL = "select * from casinos";
        List<BeensCasinos> lista = new ArrayList<>();

        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                BeensCasinos Beens = new BeensCasinos();
                Beens.setId_casino(rs.getInt("id_casino"));
                Beens.setNombres(rs.getString("nombres"));
                Beens.setDescripcion(rs.getString("descripcion"));
                Beens.setImg(rs.getBinaryStream("img"));
                Beens.setFinalizado(rs.getInt("finalizado"));
                Beens.setSolucion(rs.getString("solucion"));
                Beens.setImgP(rs.getBinaryStream("imgP"));
                lista.add(Beens);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CasinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List get_0() {
        String SQL = "select * from casinos";
        List<BeensCasinos> lista_0 = new ArrayList<>();

        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                BeensCasinos Beens = new BeensCasinos();
                Beens.setId_casino(rs.getInt("id_casino"));
                Beens.setNombres(rs.getString("nombres"));
                Beens.setDescripcion(rs.getString("descripcion"));
                Beens.setImg(rs.getBinaryStream("img"));
                Beens.setFinalizado(rs.getInt("finalizado"));
                Beens.setSolucion(rs.getString("solucion"));
                Beens.setImgP(rs.getBinaryStream("imgP"));

                if (Beens.getFinalizado() == 0) {
                    lista_0.add(Beens);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CasinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_0;
    }

    public List get_1() {
        String SQL = "select * from casinos";
        List<BeensCasinos> lista_1 = new ArrayList<>();

        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                BeensCasinos Beens = new BeensCasinos();
                Beens.setId_casino(rs.getInt("id_casino"));
                Beens.setNombres(rs.getString("nombres"));
                Beens.setDescripcion(rs.getString("descripcion"));
                Beens.setImg(rs.getBinaryStream("img"));
                Beens.setFinalizado(rs.getInt("finalizado"));
                Beens.setSolucion(rs.getString("solucion"));
                Beens.setImgP(rs.getBinaryStream("imgP"));

                if (Beens.getFinalizado() == 1) {
                    lista_1.add(Beens);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CasinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_1;
    }

    public BeensCasinos cargar(int id_casino) {
        BeensCasinos BeensCargar = new BeensCasinos();
        String SQL = " select * from casinos where id_casino=" + id_casino;

        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                BeensCargar.setNombres(rs.getString(2));
                BeensCargar.setDescripcion(rs.getString(3));
                BeensCargar.setImg(rs.getBinaryStream(4));
                BeensCargar.setFinalizado(rs.getInt(5));
                BeensCargar.setSolucion(rs.getString(6));
                BeensCargar.setImgP(rs.getBinaryStream(7));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            Logger.getLogger(BeensCasinos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return BeensCargar;
    }

    public boolean eliminar(int id_casino) {
        String SQL = "delete from casinos where id_casino=" + id_casino;

        try {
            cnx = con.ConexBD();
            Statement st;
            st = cnx.createStatement();
            int estado = st.executeUpdate(SQL);

            if (estado > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CasinoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int modificar(BeensCasinos Rm) {
        String SQL = "update casinos set nombres=?, descripcion=?, img=?" + "where id_casino=?";

        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(SQL);

            ps.setString(1, Rm.getNombres());
            ps.setString(2, Rm.getDescripcion());
            ps.setBinaryStream(3, Rm.getImg());
            ps.setInt(4, Rm.getId_casino());

            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return resultado;
    }

    public int modificar0(BeensCasinos Rm) {
        String SQL = "update casinos set nombres=?, descripcion=?, finalizado=?, solucion=?" + "where id_casino=?";

        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(SQL);

            ps.setString(1, Rm.getNombres());
            ps.setString(2, Rm.getDescripcion());
            ps.setInt(3, Rm.getFinalizado());
            ps.setString(4, Rm.getSolucion());
            ps.setInt(5, Rm.getId_casino());

            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return resultado;
    }

    public int modificarFinalizar(BeensCasinos Rm) {
        String SQL = "update casinos set finalizado=?, solucion=?, imgP=?" + "where id_casino=?";

        try {
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(SQL);

            ps.setInt(1, Rm.getFinalizado());
            ps.setString(2, Rm.getSolucion());
            ps.setBinaryStream(3, Rm.getImgP());
            ps.setInt(4, Rm.getId_casino());

            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return resultado;
    }

    public void listarImg(int id_casino, HttpServletResponse response) {
        String sql = "select * from casinos where id_casino=" + id_casino;
        InputStream inputStream = null;
        OutputStream outputStream;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;

        try {
            outputStream = response.getOutputStream();
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                inputStream = rs.getAsciiStream("img");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i;

            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }
        } catch (IOException | SQLException ex) {

        }
    }

    public void listarImgP(int id_casino, HttpServletResponse response) {
        String sql = "select * from casinos where id_casino=" + id_casino;
        InputStream inputStream = null;
        OutputStream outputStream;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;

        try {
            outputStream = response.getOutputStream();
            cnx = con.ConexBD();
            ps = cnx.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                inputStream = rs.getAsciiStream("imgP");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i;

            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }
        } catch (IOException | SQLException ex) {

        }
    }
}
