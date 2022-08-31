/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beens;

import java.io.InputStream;

/**
 *
 * @author MIGUEL ANGEL
 */
public class BeensCasinos {

    private int id_casino, finalizado;
    private String nombres, descripcion, solucion;
    private InputStream img, imgP;

    public BeensCasinos() {
    }

    public BeensCasinos(int id_casino, String nombres, String descripcion, InputStream img, int finalizado, String solucion, InputStream imgP) {
        this.id_casino = id_casino;
        this.nombres = nombres;
        this.descripcion = descripcion;
        this.img = img;
        this.finalizado = finalizado;
        this.solucion = solucion;
        this.imgP = imgP;
    }

    public int getId_casino() {
        return id_casino;
    }

    public void setId_casino(int id_casino) {
        this.id_casino = id_casino;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public InputStream getImg() {
        return img;
    }

    public void setImg(InputStream img) {
        this.img = img;
    }

    public int getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(int finalizado) {
        this.finalizado = finalizado;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public InputStream getImgP() {
        return imgP;
    }

    public void setImgP(InputStream imgP) {
        this.imgP = imgP;
    }

}
