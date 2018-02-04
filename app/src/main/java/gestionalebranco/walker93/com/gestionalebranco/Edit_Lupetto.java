package gestionalebranco.walker93.com.gestionalebranco;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.ScrollView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Edit_Lupetto extends AppCompatActivity {

    int id_lupetto = 0;
    Lupetto lupetto;
    Anagrafica anagrafica;
    ScrollView lv;
    LinearLayout linearlayout;
    public boolean TextChanged =  false;
    private TextWatcher generalTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            TextChanged =true;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void afterTextChanged(Editable s) {}

    };
    MultiAutoCompleteTextView prove;


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
                if (nome.getText().length() == 0 || cognome.getText().length() == 0){
                    SnackbarWrapper snackbar = SnackbarWrapper
                            .make(getApplicationContext(), "Nome e Cognome sono obbligatori!", 3000);
                    snackbar.show();
                } else {
                    save_lupetto();
                    Intent intent = new Intent(view.getContext(), LupettoDetailActivity.class);
                    intent.putExtra("ID_Lupetto", id_lupetto);
                    startActivity(intent);
                    finish();
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nome = (EditText) findViewById(R.id.et_Nome);
        cognome = (EditText) findViewById(R.id.et_Cognome);
        indirizzo = (EditText) findViewById(R.id.et_Indirizzo);
        fisso = (EditText) findViewById(R.id.et_Fisso);
        madre = (EditText) findViewById(R.id.et_Madre);
        padre = (EditText) findViewById(R.id.et_Padre);
        email = (EditText) findViewById(R.id.et_email);
        data = (EditText) findViewById(R.id.et_data);
        luogo = (EditText) findViewById(R.id.et_luogo);
        prove = (MultiAutoCompleteTextView) findViewById(R.id.actv_Prove);

        List<String> Prove_gruppi = Prova.ProveToName(true);
        Prove_gruppi.add("Tutte 1° stella");
        Prove_gruppi.add("Tutte 2° stella");
        Prove_gruppi.add("Tutte promessa");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Prove_gruppi);
        prove.setAdapter(adapter);
        prove.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        prove.setOnItemClickListener(new AdapterView.OnItemClickListener(
        ) {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position);
                String testo = prove.getText().toString();
                testo = testo.substring(0, testo.length()-item.length() - 2);
                prove.setText(testo);
                Prova p = Prova.allProve.get(0);
                switch (item){
                    case "Tutte 1° stella":
                        for (Prova s : Prova.allProve) {
                            if (s.Pista.equals(Pista.C_Prima_stella)) {
                                p = s;
                                prove.append(p.Nome + ", ");
                            }
                        }
                        break;
                    case "Tutte 2° stella":
                        for (Prova s : Prova.allProve) {
                            if (s.Pista.equals(Pista.D_Seconda_stella)) {
                                p = s;
                                prove.append(p.Nome + ", ");
                            }
                        }
                        break;
                    case "Tutte promessa":
                        for (Prova s : Prova.allProve) {
                            if (s.Pista.equals(Pista.B_Promessa)) {
                                p = s;
                                prove.append(p.Nome + ", ");
                            }
                        }
                        break;
                    default:
                        for (Prova s : Prova.allProve) {
                            if (item.contains(s.Nome)) {
                                p = s;
                            }
                        }
                        prove.append(p.Nome + ", ");
                }
            }
        });
        fillData();

        nome.addTextChangedListener(generalTextWatcher);
        cognome.addTextChangedListener(generalTextWatcher);
        indirizzo.addTextChangedListener(generalTextWatcher);
        fisso.addTextChangedListener(generalTextWatcher);
        madre.addTextChangedListener(generalTextWatcher);
        padre.addTextChangedListener(generalTextWatcher);
        email.addTextChangedListener(generalTextWatcher);
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

            goBack();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void goBack(){
        if (TextChanged) {
            // è stato modificato chiedo se salvare
            if (!(nome.getText().toString() == "" |
                    cognome.getText().toString() == "" |
                    indirizzo.getText().toString() == "" |
                    fisso.getText().toString() == "" |
                    madre.getText().toString() == "" |
                    padre.getText().toString() == "" |
                    email.getText().toString() == "")){
                ShowSaveDialog();
            }else{
                Intent goup;
                if (id_lupetto==0) {
                    //CREAZIONE
                    goup = new Intent(getApplicationContext(), LupettoListActivity.class);
                }else{
                    //MODIFICA
                    goup = new Intent(getApplicationContext(), LupettoDetailActivity.class);
                }
                goup.putExtra("ID_Lupetto", id_lupetto);
                startActivity(goup);
                finish();
            }
        }else{
            //nessuna modifica
            Intent goup;
            if (id_lupetto==0) {
                //CREAZIONE
                goup = new Intent(getApplicationContext(), LupettoListActivity.class);
            }else{
                //MODIFICA
                goup = new Intent(getApplicationContext(), LupettoDetailActivity.class);
            }
            goup.putExtra("ID_Lupetto", id_lupetto);
            startActivity(goup);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        goBack();
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
        List<Specialità> specs = new ArrayList<>();
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
            ((EditText) findViewById(R.id.et_data)).setText(anagrafica.DataNascita);
            ((EditText) findViewById(R.id.et_luogo)).setText(anagrafica.Luogo_Nascita);
            specs = Specialità.stringToIDs(lupetto.Specialità);
            List<String> a = Prova.ProveToName(Prova.IDStringToProveList(lupetto.Prove));
            String p ="";
            for (String s :
                    a) {
                p = p + s + ", ";
            }
            prove.setText(p);

        }
        //POPOLAZIONE ListView
        CheckBox cb_spec;

        lv = (ScrollView) findViewById(R.id.sv_specialità);

        linearlayout = (LinearLayout) lv.getChildAt(0);
        for (Specialità spec : Specialità.allSpecialità) {
            cb_spec = new CheckBox(this);
            cb_spec.setText(spec.Nome);
            if (lupetto != null) {
                if (specs.contains(spec)) {
                    cb_spec.setChecked(true);
                }
            }
            linearlayout.addView(cb_spec);
        }
    }

    EditText nome;
    EditText cognome;
    EditText indirizzo;
    EditText fisso;
    EditText madre;
    EditText padre;
    EditText email;
    EditText data;
    EditText luogo;

    void save_lupetto(){
        //Salvo il lupetto

        CheckBox cda = (CheckBox) findViewById(R.id.cb_cda);
        Spinner sestiglia = (Spinner) findViewById(R.id.spinner_Sestiglia);
        Spinner pista = (Spinner) findViewById(R.id.spinner_Pista);
        List<Specialità> specs = new ArrayList<>();

        //Specialità
        CheckBox cb_spec;
        for (int i = 0; i < linearlayout.getChildCount(); i++) {
            cb_spec = (CheckBox) linearlayout.getChildAt(i);
            if (cb_spec.isChecked()) {
                specs.add(Specialità.allSpecialità.get(i));
            }
        }

        //Prove
        List<Prova> prove_da_aggiungere = Prova.verboseStringToList(prove.getText().toString());
        Collections.sort(prove_da_aggiungere, new Prova_compare());
        if (id_lupetto > 0) {
            Anagrafica anagrafica = Anagrafica.findById(Anagrafica.class, id_lupetto);
            anagrafica.Nome = nome.getText().toString();
            anagrafica.Cognome = cognome.getText().toString();
            anagrafica.Indirizzo = indirizzo.getText().toString();
            anagrafica.Email = email.getText().toString();
            anagrafica.Tel_fisso = fisso.getText().toString();
            anagrafica.Cell_Madre = madre.getText().toString();
            anagrafica.Cell_Padre = padre.getText().toString();
            anagrafica.DataNascita = data.getText().toString();
            anagrafica.Luogo_Nascita = luogo.getText().toString();
            anagrafica.save();

            Lupetto lupetto = Lupetto.findById(Lupetto.class, id_lupetto);
            lupetto.Nome = nome.getText().toString();
            lupetto.Cognome = cognome.getText().toString();
            lupetto.Sestiglia = Sestiglie.values()[sestiglia.getSelectedItemPosition()];
            lupetto.Pista = Pista.values()[pista.getSelectedItemPosition()];
            lupetto.Specialità = Specialità.idsToString(specs);
            lupetto.CdA = cda.isChecked();
            lupetto.Anagrafica = anagrafica;
            lupetto.Prove = Prova.ListProveToIDString(prove_da_aggiungere);
            Lupetto.Assenze = "";
            lupetto.save();
        } else {
            Anagrafica anagrafica = new Anagrafica(
                    nome.getText().toString(),
                    cognome.getText().toString(),
                    indirizzo.getText().toString(),
                    email.getText().toString(),
                    fisso.getText().toString(),
                    madre.getText().toString(),
                    padre.getText().toString(),
                    data.getText().toString(),
                    luogo.getText().toString());
            anagrafica.save();

            Lupetto lupetto = new Lupetto(
                    nome.getText().toString(),
                    cognome.getText().toString(),
                    Sestiglie.values()[sestiglia.getSelectedItemPosition()],
                    Pista.values()[pista.getSelectedItemPosition()],
                    Specialità.idsToString(specs),
                    cda.isChecked(),
                    anagrafica,
                    Prova.ListProveToIDString(prove_da_aggiungere),
                    "" //assenze
                    );
            lupetto.save();
            id_lupetto = lupetto.getId().intValue();
        }
    }

    void ShowSaveDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Salvataggio")
                .setMessage("Intendete salvare il lupetto?")
                .setPositiveButton("Salva", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (nome.getText().length() == 0 || cognome.getText().length() == 0){
                            SnackbarWrapper snackbar = SnackbarWrapper
                                    .make(getApplicationContext(), "Nome e Cognome sono obbligatori!", 3000);
                            snackbar.show();
                        } else {
                            save_lupetto();
                            Intent intent = new Intent(getApplicationContext(), LupettoDetailActivity.class);
                            intent.putExtra("ID_Lupetto", id_lupetto);

                            startActivity(intent);
                            finish();
                        }
                    }
                })
                .setNegativeButton("Non salvare", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent goup;
                        if (id_lupetto==0) {
                            //CREAZIONE
                            goup = new Intent(getApplicationContext(), LupettoListActivity.class);
                        }else{
                            //MODIFICA
                            goup = new Intent(getApplicationContext(), LupettoDetailActivity.class);
                        }
                        goup.putExtra("ID_Lupetto", id_lupetto);
                        startActivity(goup);
                        finish();
                    }
                })
                .setIcon(R.drawable.ic_alert_dialog)
                .show();
    }


}


