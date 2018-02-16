package br.edu.ifspsaocarlos.sdm.pcgui;

import android.os.Bundle;
import android.widget.ImageView;

public class AcessoDiretoActivity extends ProgramacaoConcorrenteActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Mudando o subtítulo da ActionBar
        getSupportActionBar().setSubtitle(getString(R.string.acesso_direto));
    }


    protected void carregaImagens() {
        CarregaImagensThread carregaImagensThread = new CarregaImagensThread();
        carregaImagensThread.start();
    }

    /* Classe privada que implementa uma Thread que sera usada para preencher as imagens. Como nao
    ha garantia de que as Views nao estarao sendo usadas por outra classe, e possivel que seja gerada
    uma Exceçao do tipo android.view.ViewRootImpl$CalledFromWrongThreadException: Only the original
    thread that created a view hierarchy can touch its views. */
    private class CarregaImagensThread extends Thread {
        public void run() {
            try {
                // Simulando um carregamento assíncrono depois de 1 segundo
                sleep(1000);

                // Carregando primeira imagem
                ImageView altaIV = findViewById(R.id.iv_alta);
                altaIV.setImageResource(R.drawable.android_verde);

                // Carregando primeira imagem
                ImageView baixaIV = findViewById(R.id.iv_baixa);
                baixaIV.setImageResource(R.drawable.android_preto);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
