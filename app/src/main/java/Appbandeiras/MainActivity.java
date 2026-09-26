package com.example.appbandeiras;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtnome;
    private ToggleButton toginiciar;
    private ToggleButton togsair;

    // Componentes da aba de integrantes
    private TextView txtIntegrantes;
    private ScrollView txtListaIntegrantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Liga o Java ao arquivo activity_main.xml
        setContentView(R.layout.activity_main);

        // Encontra os componentes do XML pelos IDs
        edtnome = findViewById(R.id.edtnome);
        toginiciar = findViewById(R.id.toginiciar);
        togsair = findViewById(R.id.togsair);

        // Encontra os componentes da aba de integrantes
        txtIntegrantes = findViewById(R.id.txtIntegrantes);
        txtListaIntegrantes = findViewById(R.id.txtListaIntegrantes);

        // =====================================================
        // ABA INTEGRANTES
        // =====================================================

        txtIntegrantes.setOnClickListener(v -> {

            // Se a lista estiver escondida, mostra
            if (txtListaIntegrantes.getVisibility() == View.GONE) {

                txtListaIntegrantes.setVisibility(View.VISIBLE);

                // Muda a seta para cima
                txtIntegrantes.setText("INTEGRANTES ▲");

            } else {

                // Se estiver aparecendo, esconde
                txtListaIntegrantes.setVisibility(View.GONE);

                // Volta a seta para baixo
                txtIntegrantes.setText("INTEGRANTES ▼");
            }
        });

        // =====================================================
        // BOTÃO INICIAR COMEÇA DESABILITADO
        // =====================================================

        toginiciar.setEnabled(false);

        // =====================================================
        // VERIFICA O QUE ESTÁ SENDO DIGITADO NO NOME
        // =====================================================

        edtnome.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(
                    CharSequence s,
                    int start,
                    int count,
                    int after) {
            }

            @Override
            public void onTextChanged(
                    CharSequence s,
                    int start,
                    int before,
                    int count) {

                // Se não houver nome, o botão fica desabilitado
                if (s.toString().trim().isEmpty()) {

                    toginiciar.setEnabled(false);

                } else {

                    // Se houver nome, habilita o botão
                    toginiciar.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // =====================================================
        // BOTÃO INICIAR QUIZ
        // =====================================================

        toginiciar.setOnClickListener(v -> {

            // Pega o nome digitado
            String nome = edtnome.getText().toString().trim();

            // Não permite iniciar sem nome
            if (nome.isEmpty()) {
                return;
            }

            // Cria a passagem para a Pergunta 1
            Intent intent = new Intent(
                    MainActivity.this,
                    Pergunta1Activity.class
            );

            // Envia o nome para a Pergunta 1
            intent.putExtra("nome", nome);

            // Abre a Pergunta 1
            startActivity(intent);

            // Fecha a tela inicial
            finish();
        });

        // =====================================================
        // BOTÃO SAIR
        // =====================================================

        togsair.setOnClickListener(v -> {

            // Fecha o aplicativo
            finishAffinity();
        });
    }
}