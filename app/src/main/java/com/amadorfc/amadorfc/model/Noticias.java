package com.amadorfc.amadorfc.model;

/**
 * Created by lucas.viveiros on 18/03/2017.
 */

public class Noticias {

    private String noticia;
    private String hora;

    public Noticias(String noticia, String hora) {
        super();
        this.setNoticia(noticia);
        this.setHora(hora);
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
