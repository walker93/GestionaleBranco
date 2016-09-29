package gestionalebranco.walker93.com.gestionalebranco;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class Edit_Lupetto extends AppCompatActivity {

    int id_lupetto = 0;
    Lupetto lupetto;
    Anagrafica anagrafica;

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

                if (id_lupetto > 0) {
                    Anagrafica anagrafica = Anagrafica.findById(Anagrafica.class, id_lupetto);
                    anagrafica.Nome = nome.getText().toString();
                    anagrafica.Cognome = cognome.getText().toString();
                    anagrafica.Indirizzo = indirizzo.getText().toString();
                    anagrafica.Email = email.getText().toString();
                    anagrafica.Tel_fisso = fisso.getText().toString();
                    anagrafica.Cell_Madre = madre.getText().toString();
                    anagrafica.Cell_Padre = padre.getText().toString();
                anagrafica.save();

                    Lupetto lupetto = Lupetto.findById(Lupetto.class, id_lupetto);
                    lupetto.Nome = nome.getText().toString();
                    lupetto.Cognome = cognome.getText().toString();
                    lupetto.Sestiglia = Sestiglie.values()[sestiglia.getSelectedItemPosition()];
                    lupetto.Pista = Pista.values()[pista.getSelectedItemPosition()];

                    lupetto.CdA = cda.isChecked();

                    lupetto.Anagrafica = anagrafica;
                lupetto.save();
                } else {
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

                    id_lupetto = lupetto.getId().intValue();


                }

                Intent intent = new Intent(view.getContext(), LupettoDetailActivity.class);
                intent.putExtra("ID_Lupetto", id_lupetto);
                startActivity(intent);

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fillData();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            Intent up = new Intent(this, LupettoListActivity.class);
            up.putExtra("ID_Lupetto", id_lupetto);
            navigateUpTo(up);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void fillData() {
        id_lupetto = getIntent().getIntExtra("ID_Lupetto", 0);
        lupetto = Lupetto.findById(Lupetto.class, id_lupetto);
        anagrafica = Anagrafica.findById(Anagrafica.class, id_lupetto);

        Spinner spinner_Sestiglia = (Spinner) findViewById(R.id.spinner_Sestiglia);
        spinner_Sestiglia.setAdapter(new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, Sestiglie.values()));
        Spinner spinner_Pista = (Spinner) findViewById(R.id.spinner_Pista);
        spinner_Pista.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, Pista.values()));

        if (lupetto != null) {
            //((TextView) rootView.findViewById(R.id.lupetto_detail)).setText(lupetto.Cognome);
            ((EditText) findViewById(R.id.et_Nome)).setText(anagrafica.Nome);
            ((EditText) findViewById(R.id.et_Cognome)).setText(anagrafica.Cognome);
            ((EditText) findViewById(R.id.et_email)).setText(anagrafica.Email);
            ((EditText) findViewById(R.id.et_Indirizzo)).setText(anagrafica.Indirizzo);
            spinner_Pista.setSelection(lupetto.Pista.ordinal());
            spinner_Sestiglia.setSelection(lupetto.Sestiglia.ordinal());
            ((CheckBox) findViewById(R.id.cb_cda)).setChecked(lupetto.CdA);
            ((EditText) findViewById(R.id.et_Fisso)).setText(anagrafica.Tel_fisso);
            ((EditText) findViewById(R.id.et_Madre)).setText(anagrafica.Cell_Madre);
            ((EditText) findViewById(R.id.et_Padre)).setText(anagrafica.Cell_Padre);
        }
    }
}
