package br.edu.ifspsaocarlos.sdm.pcgui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract  class ProgramacaoConcorrenteActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programacao_concorrente);

        // Alterando o texto do título da ActionBar
        getSupportActionBar().setTitle(R.string.programacao_concorrente);

        // Todas as classes filhas vão executar o método para carregar as imagens do layout
        carregaImagens();
    }

    /* Método abstrato que deverá ser implementado pelas classes filhas carregando as imagens com
       metodologias de programação concorrente diferentes. */
    protected  abstract void carregaImagens();
}
