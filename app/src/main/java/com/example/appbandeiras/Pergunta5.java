package com.example.appbandeiras;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class Pergunta5 extends AppCompatActivity {

    private RadioGroup radioGroup;
    private ToggleButton responder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Liga o Java ao XML da Pergunta 5
        setContentView(R.layout.activity_pergunta5);

        // Encontra os componentes pelo ID
        radioGroup = findViewById(R.id.radioGroup);
        responder = findViewById(R.id.toggleButton2);

        // O botão começa desabilitado
        responder.setEnabled(false);

        // Ao selecionar uma resposta, habilita o botão
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId != -1) {
                responder.setEnabled(true);
            }
        });

        // Ao clicar em RESPONDER
        responder.setOnClickListener(v -> {

            // Recupera o nome do usuário
            String nome = getIntent().getStringExtra("nome");

            // Recupera a pontuação acumulada
            int pontos = getIntent().getIntExtra("pontos", 0);

            // Descobre qual alternativa foi escolhida
            int respostaSelecionada = radioGroup.getCheckedRadioButtonId();

            // Resposta correta: Canadá
            if (respostaSelecionada == R.id.radioButton4) {
                pontos++;
            }

            // Vai para a Pergunta 6
            Intent intent = new Intent(
                    Pergunta5.this,
                    Pergunta6.class
            );

            // Envia o nome
            intent.putExtra("nome", nome);

            // Envia a pontuação atualizada
            intent.putExtra("pontos", pontos);

            // Abre a Pergunta 6
            startActivity(intent);

            // Fecha a Pergunta 5
            finish();
        });
    }
}