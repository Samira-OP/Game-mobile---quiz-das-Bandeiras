package com.example.appbandeiras;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class Final extends AppCompatActivity {

    private TextView txtNomeUsuario;
    private TextView txtPontuacao;

    private ToggleButton togResponderNovamente;
    private ToggleButton togTelaPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Liga o Java ao XML da tela final
        setContentView(R.layout.activity_final);

        // Encontra os componentes do XML
        txtNomeUsuario = findViewById(R.id.txtNomeUsuario);
        txtPontuacao = findViewById(R.id.txtPontuacao);

        togResponderNovamente =
                findViewById(R.id.togResponderNovamente);

        togTelaPrincipal =
                findViewById(R.id.togTelaPrincipal);

        // =====================================================
        // RECEBE OS DADOS DA PERGUNTA 10
        // =====================================================

        // Recebe o nome do jogador
        String nome = getIntent().getStringExtra("nome");

        // Recebe a pontuação final
        int pontos = getIntent().getIntExtra("pontos", 0);

        // Se não receber um nome, usa "Jogador"
        if (nome == null || nome.trim().isEmpty()) {
            nome = "Jogador";
        }

        // Remove espaços desnecessários
        nome = nome.trim();

        // =====================================================
        // MOSTRA OS DADOS NA TELA
        // =====================================================

        // Mostra o nome
        txtNomeUsuario.setText(nome);

        // Mostra a quantidade de acertos
        txtPontuacao.setText(String.valueOf(pontos));

        // Guarda o nome para o botão
        final String nomeAtual = nome;

        // =====================================================
        // BOTÃO RESPONDER NOVAMENTE
        // =====================================================

        togResponderNovamente.setOnClickListener(v -> {

            Intent intent = new Intent(
                    Final.this,
                    Pergunta1Activity.class
            );

            // Envia novamente o nome para a Pergunta 1
            intent.putExtra("nome", nomeAtual);

            // Abre a Pergunta 1
            startActivity(intent);

            // Fecha a tela final
            finish();
        });

        // =====================================================
        // BOTÃO TELA PRINCIPAL
        // =====================================================

        togTelaPrincipal.setOnClickListener(v -> {

            Intent intent = new Intent(
                    Final.this,
                    com.example.appbandeiras.MainActivity.class
            );

            // Abre a tela inicial
            startActivity(intent);

            // Fecha a tela final
            finish();
        });
    }
}