package com.example.appbandeiras;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class Pergunta1Activity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private ToggleButton responder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Liga esta Activity ao XML da Pergunta 1
        setContentView(R.layout.activity_pergunta1);

        // Encontra os componentes do XML
        radioGroup = findViewById(R.id.radioGroup);
        responder = findViewById(R.id.toggleButton2);

        // O botão RESPONDER começa desabilitado
        responder.setEnabled(false);

        // Quando o usuário selecionar uma resposta,
        // o botão RESPONDER fica habilitado
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId != -1) {
                responder.setEnabled(true);
            }
        });

        // Quando o usuário clicar em RESPONDER
        responder.setOnClickListener(v -> {

            // Recupera o nome que veio da tela inicial
            String nome = getIntent().getStringExtra("nome");

            // Começa com 0 pontos
            int pontos = 0;

            // Descobre qual resposta foi escolhida
            int respostaSelecionada = radioGroup.getCheckedRadioButtonId();

            // Verifica se a resposta está correta
            // Portugal é a alternativa radioButton4
            if (respostaSelecionada == R.id.radioButton4) {
                pontos++;
            }

            // Cria a passagem para a Pergunta 2
            Intent intent = new Intent(
                    Pergunta1Activity.this,
                    Pergunta2Activity.class
            );

            // Envia o nome para a Pergunta 2
            intent.putExtra("nome", nome);

            // Envia a pontuação para a Pergunta 2
            intent.putExtra("pontos", pontos);

            // Abre a Pergunta 2
            startActivity(intent);

            // Fecha a Pergunta 1
            finish();
        });
    }
}