package com.xcheko51x.mysql_grafica_barras_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.xcheko51x.mysql_grafica_barras_java.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    Retrofit retrofit = new RetrofitClient().getRetrofit();
    WebService webService = retrofit.create(WebService.class);

    List<Venta> listaVentas = new ArrayList<>();
    List<BarEntry> entradas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        obtenerVentas();
    }

    public void obtenerVentas() {
        Call<VentasResponse> response = webService.obtenerVentas();
        response.enqueue(new Callback<VentasResponse>() {
            @Override
            public void onResponse(Call<VentasResponse> call, Response<VentasResponse> response) {
                listaVentas = response.body().listaVentas;
                graficar();
            }

            @Override
            public void onFailure(Call<VentasResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "ERROR CONSULTAR TODOS", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void graficar() {
        for (int i = 0 ; i < listaVentas.size() ; i++) {
            entradas.add(
                    new BarEntry(i, listaVentas.get(i).getVentas())
            );
        }

        BarDataSet datos = new BarDataSet(entradas, "GRAFICA DE VENTAS");
        BarData data = new BarData(datos);

        datos.setColors(ColorTemplate.COLORFUL_COLORS);

        data.setBarWidth(0.9f);

        binding.graficaBarras.setData(data);
        binding.graficaBarras.setFitBars(true);
        binding.graficaBarras.invalidate();
    }
}