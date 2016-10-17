package gestionalebranco.walker93.com.gestionalebranco;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import java.util.List;

public class AddProveActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Lupetto> SV = Lupetto.listAll(Lupetto.class, "PISTA " + "DESC");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_prove);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_checkLupetti);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(SV);
        mRecyclerView.setAdapter(mAdapter);

        //Carica MAC

        MultiAutoCompleteTextView prove = (MultiAutoCompleteTextView) findViewById(R.id.MAC_Prove);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Prova.ProveToName());
        prove.setAdapter(adapter);
        prove.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: salva prove


            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        goBack();
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == android.R.id.home){
            goBack();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goBack(){
        Intent goup= new Intent(this, LupettoListActivity.class);
        goup.putExtra("ID_Lupetto", 0);
        startActivity(goup);
        finish();
    }

}


class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Lupetto> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        // each data item is just a string in this case
        public TextView mNomeView;
        public TextView mCognomeView;
        public TextView mSestigliaView;
        public CheckBox mProvaView;
        public Lupetto mItem;

        public ViewHolder(View v) {
            super(v);
            mView = v;
            mNomeView = (TextView) v.findViewById(R.id.idP);
            mCognomeView = (TextView) v.findViewById(R.id.contentP);
            mSestigliaView = (TextView) v.findViewById(R.id.sestigliaP);
            mProvaView = (CheckBox) v.findViewById(R.id.checkBoxP);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Lupetto> myDataset) {
        mDataset = myDataset;
        mValues = mDataset;
        mSi = new boolean[mValues.size()];
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.prove_content, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    private List<Lupetto> mValues;
    private boolean[] mSi;

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.mItem = mValues.get(position);
        holder.mNomeView.setText(mValues.get(position).Nome);
        holder.mCognomeView.setText(mValues.get(position).Cognome);
        holder.mSestigliaView.setText(mValues.get(position).Sestiglia.toString());
        holder.mProvaView.setOnCheckedChangeListener(null);
        holder.mProvaView.setChecked(mSi[position]);
        holder.mProvaView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mSi[position] = isChecked;
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}