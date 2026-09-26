package com.example.appbandeiras;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class Pergunta4 extends AppCompatActivity {

    private RadioGroup radioGroup;
    private ToggleButton responder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Liga o Java ao XML da Pergunta 4
        setContentView(R.layout.activity_pergunta4);

        // Encontra os componentes pelo ID
        radioGroup = findViewById(R.id.radioGroup);
        responder = findViewById(R.id.toggleButton2);

        // O botão RESPONDER começa desabilitado
        responder.setEnabled(false);

        // Quando uma alternativa for selecionada,
        // habilita o botão RESPONDER
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId != -1) {
                responder.setEnabled(true);
            }
        });

        // Quando clicar em RESPONDER
        responder.setOnClickListener(v -> {

            // Recebe o nome que veio da tela inicial
            String nome = getIntent().getStringExtra("nome");

            // Recebe a pontuação acumulada das perguntas anteriores
            int pontos = getIntent().getIntExtra("pontos", 0);

            // Descobre qual alternativa foi escolhida
            int respostaSelecionada = radioGroup.getCheckedRadioButtonId();

            // Resposta correta: Bolívia
            if (respostaSelecionada == R.id.radioButton3) {
                pontos++;
            }

            // Vai para a Pergunta 5
            Intent intent = new Intent(
                    Pergunta4.this,
                    Pergunta5.class
            );

            // Envia o nome para a Pergunta 5
            intent.putExtra("nome", nome);

            // Envia a pontuação atualizada
            intent.putExtra("pontos", pontos);

            // Abre a Pergunta 5
            startActivity(intent);

            // Fecha a Pergunta 4
            finish();
        });
    }
}