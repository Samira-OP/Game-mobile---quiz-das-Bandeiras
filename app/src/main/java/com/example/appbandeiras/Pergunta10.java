package com.example.appbandeiras;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class Pergunta10 extends AppCompatActivity {

    private RadioGroup radioGroup;
    private ToggleButton responder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Liga o Java ao XML da Pergunta 10
        setContentView(R.layout.activity_pergunta10);

        // Encontra os componentes pelo ID
        radioGroup = findViewById(R.id.radioGroup);
        responder = findViewById(R.id.toggleButton2);

        // O botão RESPONDER começa desabilitado
        responder.setEnabled(false);

        // Habilita o botão quando uma alternativa for escolhida
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId != -1) {
                responder.setEnabled(true);
            }
        });

        // Quando clicar em RESPONDER
        responder.setOnClickListener(v -> {

            // Recupera o nome do usuário
            String nome = getIntent().getStringExtra("nome");

            // Recupera a pontuação acumulada das perguntas anteriores
            int pontos = getIntent().getIntExtra("pontos", 0);

            // Descobre qual alternativa foi escolhida
            int respostaSelecionada = radioGroup.getCheckedRadioButtonId();

            // Resposta correta: Gana
            // Gana está no radioButton
            if (respostaSelecionada == R.id.radioButton) {
                pontos++;
            }

            // Vai para o Ranking
            Intent intent = new Intent(
                    Pergunta10.this,
                    Final.class
            );

            // Envia o nome
            intent.putExtra("nome", nome);

            // Envia a pontuação final
            intent.putExtra("pontos", pontos);

            // Abre o Ranking
            startActivity(intent);

            // Fecha a Pergunta 10
            finish();
        });
    }
}