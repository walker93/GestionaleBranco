package gestionalebranco.walker93.com.gestionalebranco;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class ProvaDettaglio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prova_dettaglio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Prova prova = Prova.allProve.get(getIntent().getIntExtra("ID_Prova", 0));
        id_lupetto = getIntent().getIntExtra("ID_Lupetto", 0);
        if (prova != null) {
            ((TextView) findViewById(R.id.tv_nomeProva)).setText(prova.Nome);
            ((TextView) findViewById(R.id.tv_descProva)).setText(prova.Descrizione);
            ((TextView) findViewById(R.id.tv_pistaProva)).setText(prova.Pista.toString());
            ((TextView) findViewById(R.id.NumProva)).setText((String.valueOf(prova.numProva)));
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    int id_lupetto;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, LupettoDetailActivity.class);
        i.putExtra("ID_Lupetto", id_lupetto);
        startActivity(i);
        finish();
        //super.onBackPressed();
    }
}
