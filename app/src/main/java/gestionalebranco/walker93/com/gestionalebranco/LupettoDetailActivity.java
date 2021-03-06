package gestionalebranco.walker93.com.gestionalebranco;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/**
 * An activity representing a single Lupetto detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link LupettoListActivity}.
 */
public class LupettoDetailActivity extends AppCompatActivity {

    int lupetto_id=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupetto_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        lupetto_id = getIntent().getIntExtra("ID_Lupetto", 0);
        Log.d("Activity Transition", "Transazione, Ricevuto ID_lupetto: " + lupetto_id);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), Edit_Lupetto.class);
                intent.putExtra("ID_Lupetto", lupetto_id);
                Log.d("Activity Transition", "Transazione, Inviato ID_lupetto: " + lupetto_id);
                startActivity(intent);
                finish();
            }
        });

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            lupetto_id = getIntent().getIntExtra("ID_Lupetto", 0);
            arguments.putInt("ID_Lupetto", lupetto_id);
            LupettoDetailFragment fragment = new LupettoDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.lupetto_detail_container, fragment)
                    .commit();
        }


        //Lupetto lupetto = Lupetto.findById(Lupetto.class, lupetto_id + 1);
        //Anagrafica anagrafica = lupetto.Anagrafica;


    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_detail_activity, menu);
        return true;
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
            startActivity(new Intent(this, LupettoListActivity.class));
            finish();
            return true;
        } else if (id == R.id.action_delete) {
            final Lupetto lupetto = Lupetto.findById(Lupetto.class, lupetto_id);
            final Anagrafica anagrafica = Anagrafica.findById(Anagrafica.class, lupetto_id);
            final CoordinatorLayout CL = (CoordinatorLayout) findViewById(R.id.CL);
            boolean l_deleted = lupetto.delete();
            boolean a_deleted = anagrafica.delete();
            if (l_deleted && a_deleted) {
                SnackbarWrapper snackbar = SnackbarWrapper
                        .make(getApplicationContext(), "Lupetto eliminato!", 3000)
                        .setAction("ANNULLA", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                anagrafica.save();
                                lupetto.save();
                                SnackbarWrapper snackbar1 = SnackbarWrapper.make(getApplicationContext(),
                                        "Lupetto ripristinato", 1000);
                                snackbar1.show();
                            }
                        });

                snackbar.show();

                Intent intent = new Intent(this, LupettoListActivity.class);
                startActivity(intent);
                finish();
            } else {
                Snackbar snackbar = Snackbar
                        .make(CL, "Impossibile eliminare lupetto", Snackbar.LENGTH_LONG);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, LupettoListActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
