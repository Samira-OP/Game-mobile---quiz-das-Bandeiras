package com.example.appbandeiras;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class Pergunta8 extends AppCompatActivity {

    private RadioGroup radioGroup;
    private ToggleButton responder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Liga o Java ao XML da Pergunta 8
        setContentView(R.layout.activity_pergunta8);

        // Encontra os componentes pelo ID
        radioGroup = findViewById(R.id.radioGroup);
        responder = findViewById(R.id.toggleButton2);

        // O botão começa desabilitado
        responder.setEnabled(false);

        // Quando escolher uma resposta,
        // habilita o botão RESPONDER
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId != -1) {
                responder.setEnabled(true);
            }
        });

        // Quando clicar em RESPONDER
        responder.setOnClickListener(v -> {

            // Recupera o nome do usuário
            String nome = getIntent().getStringExtra("nome");

            // Recupera os pontos acumulados
            int pontos = getIntent().getIntExtra("pontos", 0);

            // Descobre qual resposta foi escolhida
            int respostaSelecionada = radioGroup.getCheckedRadioButtonId();

            // Resposta correta: Palestina
            if (respostaSelecionada == R.id.radioButton4) {
                pontos++;
            }

            // Vai para a Pergunta 9
            Intent intent = new Intent(
                    Pergunta8.this,
                    Pergunta9.class
            );

            // Envia o nome
            intent.putExtra("nome", nome);

            // Envia a pontuação atualizada
            intent.putExtra("pontos", pontos);

            // Abre a Pergunta 9
            startActivity(intent);

            // Fecha a Pergunta 8
            finish();
        });
    }
}