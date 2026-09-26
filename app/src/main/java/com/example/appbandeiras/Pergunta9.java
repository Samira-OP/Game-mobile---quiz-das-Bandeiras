package com.example.appbandeiras;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class Pergunta9 extends AppCompatActivity {

    private RadioGroup radioGroup;
    private ToggleButton responder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Liga o Java ao XML da Pergunta 9
        setContentView(R.layout.activity_pergunta9);

        // Encontra os componentes pelo ID
        radioGroup = findViewById(R.id.radioGroup);
        responder = findViewById(R.id.toggleButton2);

        // O botão começa desabilitado
        responder.setEnabled(false);

        // Habilita o botão depois que escolher uma alternativa
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

            // Descobre qual alternativa foi escolhida
            int respostaSelecionada = radioGroup.getCheckedRadioButtonId();

            // Resposta correta: Síria
            if (respostaSelecionada == R.id.radioButton2) {
                pontos++;
            }

            // Vai para a Pergunta 10
            Intent intent = new Intent(
                    Pergunta9.this,
                    Pergunta10.class
            );

            // Envia o nome
            intent.putExtra("nome", nome);

            // Envia a pontuação atualizada
            intent.putExtra("pontos", pontos);

            // Abre a Pergunta 10
            startActivity(intent);

            // Fecha a Pergunta 9
            finish();
        });
    }
}