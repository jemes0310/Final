package com.example.user.afinal.database;

/**
 * Created by user on 4/4/2018.
 */

public class Usuarios {
    String nnombre;
    String napellido;
    String ncorreo;
    String ntelefonoo;
    String nfecha;

    public String getNnombre() {
        return nnombre;
    }

    public void setNnombre(String nnombre) {
        this.nnombre = nnombre;
    }

    public String getNapellido() {
        return napellido;
    }

    public void setNapellido(String napellido) {
        this.napellido = napellido;
    }

    public String getNcorreo() {
        return ncorreo;
    }

    public void setNcorreo(String ncorreo) {
        this.ncorreo = ncorreo;
    }

    public String getNtelefonoo() {
        return ntelefonoo;
    }

    public void setNtelefonoo(String ntelefonoo) {
        this.ntelefonoo = ntelefonoo;
    }



    public String getNfecha() {
        return nfecha;
    }

    public void setNfecha(String nfecha) {
        this.nfecha = nfecha;
    }

    public Usuarios(String nnombre, String napellido, String ncorreo, String ntelefonoo,String nfecha) {

        this.nnombre = nnombre;
        this.napellido = napellido;
        this.ncorreo = ncorreo;
        this.ntelefonoo = ntelefonoo;
        this.nfecha = nfecha;
    }
}
