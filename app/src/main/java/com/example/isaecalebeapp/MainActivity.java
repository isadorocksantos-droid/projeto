package com.example.isaecalebeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.jspecify.annotations.NonNull;

public class MainActivity extends AppCompatActivity {

    private TextView txtMensagem;
    private button btnMostrar, btnocultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ajuste de bordas
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> onApplyWindowInsets(v, insets)
        );

        // Referências dos componentes
        Button btnMostrar = findViewById(R.id.btnMostrar);
        Button btnOcultar = findViewById(R.id.btnOcultar);
        txtMensagem = findViewById(R.id.txtMensagem);

        // Botão Mostrar
        btnMostrar.setOnClickListener(view -> {
            txtMensagem.setVisibility(View.VISIBLE);
        });

        // Botão Ocultar
        btnOcultar.setOnClickListener(view -> {
            txtMensagem.setVisibility(View.GONE);
        });
    }

    private WindowInsetsCompat onApplyWindowInsets(@NonNull View v, @NonNull WindowInsetsCompat insets) {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    }
}