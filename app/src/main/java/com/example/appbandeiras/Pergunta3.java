package com.example.appbandeiras;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class Pergunta3 extends AppCompatActivity {

    private RadioGroup radioGroup;
    private ToggleButton responder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Liga o Java ao XML da Pergunta 3
        setContentView(R.layout.activity_pergunta3);

        // Encontra os componentes pelo ID
        radioGroup = findViewById(R.id.radioGroup);
        responder = findViewById(R.id.toggleButton2);

        // O botão RESPONDER começa desabilitado
        responder.setEnabled(false);

        // Quando o usuário escolher uma alternativa,
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

            // Resposta correta: Panamá
            // Panamá está no radioButton4
            if (respostaSelecionada == R.id.radioButton4) {
                pontos++;
            }

            // Vai para a Pergunta 4
            Intent intent = new Intent(
                    Pergunta3.this,
                    Pergunta4.class
            );

            // Envia o nome
            intent.putExtra("nome", nome);

            // Envia a pontuação atualizada
            intent.putExtra("pontos", pontos);

            // Abre a Pergunta 4
            startActivity(intent);

            // Fecha a Pergunta 3
            finish();
        });
    }
}