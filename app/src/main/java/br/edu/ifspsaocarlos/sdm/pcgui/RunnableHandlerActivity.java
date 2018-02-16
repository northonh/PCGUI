package br.edu.ifspsaocarlos.sdm.pcgui;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class RunnableHandlerActivity extends ProgramacaoConcorrenteActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Mudando o subtítulo da ActionBar
        getSupportActionBar().setSubtitle(getString(R.string.runnable_handler));
    }

    protected void carregaImagens() {
        /* Instancia um objeto Handler para tratar mensagens. Neste caso um Handler simples ja que o
        codigo que sera executado no Handler sera passado como um objeto de uma classe que implementa
        Runnable */
        Handler carregaImagensHandler = new Handler();

        // Envia a Runnable ao Handler simulando um carregamento assincrono depois de 1 segundo
        carregaImagensHandler.postDelayed(new Runnable() {
            public void run() {
                // Carregando primeira imagem
                ImageView altaIV = findViewById(R.id.iv_alta);
                altaIV.setImageResource(R.drawable.android_verde);

                // Carregando primeira imagem
                ImageView baixaIV = findViewById(R.id.iv_baixa);
                baixaIV.setImageResource(R.drawable.android_preto);
            }
        }, 1000);
    }
}