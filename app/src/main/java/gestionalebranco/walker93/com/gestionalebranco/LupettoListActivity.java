package gestionalebranco.walker93.com.gestionalebranco;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
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

    List<Lupetto> lupetti = Lupetto.listAll(Lupetto.class);
    SimpleItemRecyclerViewAdapter SV = new SimpleItemRecyclerViewAdapter(lupetti);
    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupetto_list);

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

        }
        return super.onOptionsItemSelected(item);
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
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private  List<Lupetto> mValues= Lupetto.listAll(Lupetto.class, "PISTA " + "DESC");

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
}
