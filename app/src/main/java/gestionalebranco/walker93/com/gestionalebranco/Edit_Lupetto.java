package gestionalebranco.walker93.com.gestionalebranco;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class Edit_Lupetto extends AppCompatActivity {

    int id_lupetto = 0;

    public int getId_lupetto() {
        return id_lupetto;
    }

    public void setId_lupetto(int id_lupetto) {
        this.id_lupetto = id_lupetto;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__lupetto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Salvo il lupetto
                EditText nome = (EditText) findViewById(R.id.et_Nome);
                EditText cognome = (EditText) findViewById(R.id.et_Cognome);
                EditText indirizzo = (EditText) findViewById(R.id.et_Indirizzo);
                EditText fisso = (EditText) findViewById(R.id.et_Fisso);
                EditText madre = (EditText) findViewById(R.id.et_Madre);
                EditText padre = (EditText) findViewById(R.id.et_Padre);
                EditText email = (EditText) findViewById(R.id.et_email);
                CheckBox cda = (CheckBox) findViewById(R.id.cb_cda);
                Spinner sestiglia = (Spinner) findViewById(R.id.spinner_Sestiglia);
                Spinner pista = (Spinner) findViewById(R.id.spinner_Pista);
                Anagrafica anagrafica = new Anagrafica(
                        nome.getText().toString(),
                        cognome.getText().toString(),
                        indirizzo.getText().toString(),
                        email.getText().toString(),
                        fisso.getText().toString(),
                        madre.getText().toString(),
                        padre.getText().toString());
                anagrafica.save();
                Lupetto lupetto = new Lupetto(
                        nome.getText().toString(),
                        cognome.getText().toString(),
                        Sestiglie.values()[sestiglia.getSelectedItemPosition()],
                        Pista.values()[pista.getSelectedItemPosition()],
                        cda.isChecked(),
                        anagrafica);
                lupetto.save();

                id_lupetto =;
                Intent intent = new Intent(view.getContext(), Edit_Lupetto.class);
                intent.putExtra("ID_Lupetto", id_lupetto);
                startActivity(intent);

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
