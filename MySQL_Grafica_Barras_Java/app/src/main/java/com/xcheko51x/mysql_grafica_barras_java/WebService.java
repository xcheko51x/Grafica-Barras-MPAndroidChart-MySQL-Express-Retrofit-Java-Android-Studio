package com.xcheko51x.mysql_grafica_barras_java;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {

    @GET("/ventas")
    Call<VentasResponse> obtenerVentas();
}
