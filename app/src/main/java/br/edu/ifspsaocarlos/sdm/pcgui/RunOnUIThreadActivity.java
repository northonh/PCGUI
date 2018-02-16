package br.edu.ifspsaocarlos.sdm.pcgui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class RunOnUIThreadActivity extends ProgramacaoConcorrenteActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Mudando o subtítulo da ActionBar
        getSupportActionBar().setSubtitle(getString(R.string.metodo_activity));
    }

    protected void carregaImagens() {
        runOnUiThread(new Runnable() {
            public void run() {
                // Simulando um carregamento assíncrono depois de 1 segundo
                try {
                    Thread.sleep(1000);
                } catch (Exception ie) {
                    ie.printStackTrace();
                }

                // Carregando primeira imagem
                ImageView altaIV = findViewById(R.id.iv_alta);
                altaIV.setImageResource(R.drawable.android_verde);

                // Carregando primeira imagem
                ImageView baixaIV = findViewById(R.id.iv_baixa);
                baixaIV.setImageResource(R.drawable.android_preto);
            }
        });
    }
}
