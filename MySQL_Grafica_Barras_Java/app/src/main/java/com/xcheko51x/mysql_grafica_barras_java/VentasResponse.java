package com.xcheko51x.mysql_grafica_barras_java;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VentasResponse {

    @SerializedName("listaVentas")
    ArrayList<Venta> listaVentas;
}
