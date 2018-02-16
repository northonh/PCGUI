package br.edu.ifspsaocarlos.sdm.pcgui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class MessageHandlerActivity extends ProgramacaoConcorrenteActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Mudando o subtítulo da ActionBar
        getSupportActionBar().setSubtitle(getString(R.string.message_handler));
    }

    protected void carregaImagens() {
        // Instancia um objeto Handler para tratar mensagens
        CarregaImagensHandler carregaImagensHandler = new CarregaImagensHandler();

        // Instancia um objeto Mensagem para enviar uma açao de carregar imagens ao Handler
        Message carregaImagensMessage = new Message();
        carregaImagensMessage.what = CarregaImagensHandler.CARREGA_IMAGENS;

        // Envia a Mensagem ao Handler simulando um carregamento assincrono depois de 1 segundo
        carregaImagensHandler.sendMessageDelayed(carregaImagensMessage, 1000);
    }

    /* Classe privada que estende um Handler e por isso tem que implementar o metodo handleMessage.
       Ao receber uma Mensagem, confere o atributo what da Mensagem recebida e carrega as imagens.*/
    private class CarregaImagensHandler extends Handler{
        public static final int CARREGA_IMAGENS = 0;

        public void handleMessage(Message msg) {
            if (msg.what == CARREGA_IMAGENS) {
                // Carregando primeira imagem
                ImageView altaIV = findViewById(R.id.iv_alta);
                altaIV.setImageResource(R.drawable.android_verde);

                // Carregando primeira imagem
                ImageView baixaIV = findViewById(R.id.iv_baixa);
                baixaIV.setImageResource(R.drawable.android_preto);
            }
        }
    }
}
