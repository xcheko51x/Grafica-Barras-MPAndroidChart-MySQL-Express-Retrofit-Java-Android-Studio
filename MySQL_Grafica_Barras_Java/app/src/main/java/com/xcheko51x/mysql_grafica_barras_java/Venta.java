package com.xcheko51x.mysql_grafica_barras_java;

public class Venta {

    private String mes;
    private float ventas;

    public Venta(String mes, float ventas) {
        this.mes = mes;
        this.ventas = ventas;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public float getVentas() {
        return ventas;
    }

    public void setVentas(float ventas) {
        this.ventas = ventas;
    }
}
