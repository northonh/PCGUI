package br.edu.ifspsaocarlos.sdm.pcgui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PrincipalActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    // ListView da tela principal que será populado com a lista de opções dos exemplos
    private ListView principalLV;

    // Array de Strings usado para preencher as opções da tela
    private String[] opcoesMenu;

    /* Constante usada para passar o tipo de programação concorrente selecionado pelo usuário como
       parâmetro para a próxima Activity */
    public static final String TIPO_PC = "TIPO_PC";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Preenchendo o Array de Strings com os valores do arquivo strings.xml
        opcoesMenu = getResources().getStringArray(R.array.opcoes_menu);

        /* Recuperando referência para o ListView do layout da tela principal, configurando Adapter
        e Listener*/
        principalLV = findViewById(R.id.lv_principal);
        principalLV.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcoesMenu));
        principalLV.setOnItemClickListener(this);

        // Colocando um subtítulo
        getSupportActionBar().setSubtitle("Escolha uma thread");
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:  // Acesso direto
                Intent acessoDiretoIntent = new Intent(this, AcessoDiretoActivity.class);
                startActivity(acessoDiretoIntent);
                break;
        }
    }
}
