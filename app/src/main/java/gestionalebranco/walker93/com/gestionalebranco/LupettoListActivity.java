package gestionalebranco.walker93.com.gestionalebranco;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aditya.filebrowser.Constants;
import com.aditya.filebrowser.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;




/**
 * An activity representing a list of Lupetti. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link LupettoDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class LupettoListActivity extends AppCompatActivity {

    List<Lupetto> lupetti = new ArrayList<>();

    SimpleItemRecyclerViewAdapter SV;
    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupetto_list);
        if (Lupetto.count(Lupetto.class)>0) {
            lupetti = Lupetto.listAll(Lupetto.class, "SESTIGLIA, PISTA " + "DESC");
        }
        SV = new SimpleItemRecyclerViewAdapter(lupetti);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //List<Specialità> spec = new ArrayList<Specialità>();
                Intent intent = new Intent(view.getContext(), Edit_Lupetto.class);
                intent.putExtra("ID_Lupetto", 0);
                Log.d("Activity Transition", "Transazione, Inviato ID_lupetto: " + 0);
                startActivity(intent);
                finish();

            }
        });

        View recyclerView = findViewById(R.id.lupetto_list);
        assert recyclerView != null;

        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.lupetto_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list_lupetti, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.ac_prove_button) {
            //Start activity prove add
            Intent i = new Intent(this, AddProveActivity.class);
            startActivity(i);
            finish();
        } else if (id == R.id.ac_export_button) {
            try {
                if (ContextCompat.checkSelfPermission(LupettoListActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(LupettoListActivity.this,
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                10);

                } else {
                        boolean saving = saveCSV(Lupetto.LupettiToCSV(Lupetto.listAll(Lupetto.class)));
                        if (saving) {
                            SnackbarWrapper snackbar = SnackbarWrapper
                                    .make(getApplicationContext(), "File salvato in: /GestionaleBranco/Lupetti.csv", 3000);
                            snackbar.show();
                        } else {
                            SnackbarWrapper snackbar = SnackbarWrapper
                                    .make(getApplicationContext(), "Impossibile salvare il file.", 3000);
                            snackbar.show();
                        }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (id == R.id.ac_import_button) {
            try {
                if (ContextCompat.checkSelfPermission(LupettoListActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(LupettoListActivity.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            20);

                } else {
                    Intent i2 = new Intent(getApplicationContext(), FileChooser.class);
                    i2.putExtra(Constants.SELECTION_MODE, Constants.SELECTION_MODES.SINGLE_SELECTION.ordinal());
                    i2.putExtra(Constants.INITIAL_DIRECTORY,
                            new File(Environment.getExternalStorageDirectory().getAbsolutePath(),
                                    "GestionaleBranco").getAbsolutePath());
                    i2.putExtra(Constants.ALLOWED_FILE_EXTENSIONS, "csv");
                    startActivityForResult(i2,30);


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 10: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    boolean saving = saveCSV(Lupetto.LupettiToCSV(Lupetto.listAll(Lupetto.class)));
                    if (saving) {
                        SnackbarWrapper snackbar = SnackbarWrapper
                                .make(getApplicationContext(), "File salvato in: /GestionaleBranco/Lupetti.csv", 3000);
                        snackbar.show();
                    } else {
                        SnackbarWrapper snackbar = SnackbarWrapper
                                .make(getApplicationContext(), "Impossibile salvare il file.", 3000);
                        snackbar.show();
                    }
                } else {
                    //Permesso rifiutato
                }
                return;
            }case 20: {
                Intent i2 = new Intent(getApplicationContext(), FileChooser.class);
                i2.putExtra(Constants.SELECTION_MODE, Constants.SELECTION_MODES.SINGLE_SELECTION.ordinal());
                i2.putExtra(Constants.INITIAL_DIRECTORY,
                        new File(Environment.getExternalStorageDirectory().getAbsolutePath(),
                                "GestionaleBranco").getAbsolutePath());
                i2.putExtra(Constants.ALLOWED_FILE_EXTENSIONS, "csv");
                startActivityForResult(i2,30);
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        SV.notifyItemRangeChanged(0, SV.getItemCount());

        super.onNewIntent(intent);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(SV);
        recyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private  List<Lupetto> mValues;

        public SimpleItemRecyclerViewAdapter(List<Lupetto> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.lupetto_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            //mValues = Lupetto.listAll(Lupetto.class, "PISTA " + "DESC");

            holder.mItem = mValues.get(position);
            holder.mIdView.setText(mValues.get(position).Nome);
            holder.mContentView.setText(mValues.get(position).Cognome);
            holder.mSestigliaView.setText(mValues.get(position).Sestiglia.toString());
            //TypedValue typedValue = new TypedValue();
            //getTheme().resolveAttribute(R.attr.selectableItemBackgroundBorderless, typedValue, true);
            //holder.mView.setBackgroundResource(typedValue.resourceId);

            //holder.mView.setBackgroundResource(typedValue.resourceId);

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putInt("ID_Lupetto", holder.mItem.getId().intValue());
                        LupettoDetailFragment fragment = new LupettoDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.lupetto_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, LupettoDetailActivity.class);
                        intent.putExtra("ID_Lupetto", holder.mItem.getId().intValue());

                        context.startActivity(intent);
                        finish();
                    }
                }
            });
        }


        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mIdView;
            public final TextView mContentView;
            public final TextView mSestigliaView;
            public Lupetto mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.id);
                mContentView = (TextView) view.findViewById(R.id.content);
                mSestigliaView = (TextView) view.findViewById(R.id.sestiglia);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }


    private boolean readCSV(String path){
        try {
            InputStream inputStream = new FileInputStream(path);
            if (inputStream != null) {
                InputStreamReader streamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(streamReader);
                String line;
                //ArrayList<Lupetto> new_lupetti = new ArrayList<>();
                //ArrayList<Anagrafica> new_anagrafica = new ArrayList<>();
                Anagrafica.deleteAll(Anagrafica.class);
                Lupetto.deleteAll(Lupetto.class);
                while (( line = bufferedReader.readLine()) != null) {
                    String[] fields = line.split(";",-1);
                    if (!fields[0].equals("Nome")) {
                        Anagrafica anag = Anagrafica.read(fields[6].trim());
                        Anagrafica.save(anag);
                        Lupetto lupetto = new Lupetto(
                                fields[0].trim(),
                                fields[1].trim(),
                                Sestiglie.valueOf(fields[2].trim()),
                                Pista.valueOf(fields[3].trim()),
                                Specialità.idsToString(Specialità.verboseStringToList(fields[4].trim())),
                                Boolean.parseBoolean(fields[5].trim()),
                                anag,
                                Prova.ListProveToIDString(Prova.verboseStringToList(fields[7].trim())),
                                fields[8].trim()
                        );
                        Lupetto.save(lupetto);
                        //new_anagrafica.add(anag);
                        //new_lupetti.add(lupetto);
                    }
                }
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lupetto_list);
                List<Lupetto> lupetti = Lupetto.listAll(Lupetto.class, "SESTIGLIA, PISTA " + "DESC");
                SimpleItemRecyclerViewAdapter adapter = new SimpleItemRecyclerViewAdapter(lupetti);
                recyclerView.setAdapter(adapter);
                recyclerView.invalidate();
                
            }
            inputStream.close(); //close the file
            return true;
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean saveCSV(String text){
        try {
            File dest = Environment.getExternalStorageDirectory();

            String backupDBPath = dest.toString() + "/GestionaleBranco/Lupetti.csv";
            File backupDB = new File(backupDBPath);
            if (Lupetto.count(Lupetto.class)>0) {
                backupDB.getParentFile().mkdirs();
                backupDB.createNewFile();
                FileOutputStream dst = new FileOutputStream(backupDB);
                dst.write(text.getBytes());
                dst.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 30 && data!=null) {
            if (resultCode == RESULT_OK) {

                try {
                    Uri file = data.getData();
                    boolean reading;
                    reading = readCSV(getPath(getApplicationContext(), file));
                    if (reading) {
                        SV.notifyItemRangeChanged(0, (int) Lupetto.count(Lupetto.class));
                        SV.notifyDataSetChanged();
                        SnackbarWrapper snackbar = SnackbarWrapper
                                .make(getApplicationContext(), "Lupetti importati", 3000);
                        snackbar.show();
                    } else {
                        SnackbarWrapper snackbar = SnackbarWrapper
                                .make(getApplicationContext(), "Impossibile importare il file.", 3000);
                        snackbar.show();
                    }
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Nullable
    public static String getPath(Context context, Uri uri) throws URISyntaxException {
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            String[] projection = { "_data" };
            Cursor cursor = null;

            try {
                cursor = context.getContentResolver().query(uri, projection, null, null, null);
                int column_index = cursor.getColumnIndexOrThrow("_data");
                if (cursor.moveToFirst()) {
                    return cursor.getString(column_index);
                }
            } catch (Exception e) {
                // Eat it
            }
        }
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }
}
