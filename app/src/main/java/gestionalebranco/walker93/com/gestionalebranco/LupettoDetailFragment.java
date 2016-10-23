package gestionalebranco.walker93.com.gestionalebranco;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;


/**
 * A fragment representing a single Lupetto detail screen.
 * This fragment is either contained in a {@link LupettoListActivity}
 * in two-pane mode (on tablets) or a {@link LupettoDetailActivity}
 * on handsets.
 */
public class LupettoDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    View rootView;
    private Lupetto lupetto;
    private Anagrafica anagrafica;
    private int lupetto_id;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public LupettoDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey("ID_Lupetto")) {
            Activity activity = this.getActivity();
            lupetto_id = getArguments().getInt("ID_Lupetto", 0);
            if (lupetto_id == 0) {
                lupetto_id = activity.getIntent().getIntExtra("ID_Lupetto", 0);
            }
            lupetto = Lupetto.findById(Lupetto.class, lupetto_id);
            anagrafica = Anagrafica.findById(Anagrafica.class, lupetto_id);

            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(lupetto.Nome + " " + lupetto.Cognome);
            }

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        List<Specialità> specs;
        List<Prova> provs;
        if (lupetto != null) {
            //((TextView) rootView.findViewById(R.id.lupetto_detail)).setText(lupetto.Cognome);

            ((TextView) rootView.findViewById(R.id.txt_email)).setText(anagrafica.Email);
            ((TextView) rootView.findViewById(R.id.txt_indirizzo)).setText(anagrafica.Indirizzo);
            ((TextView) rootView.findViewById(R.id.txt_pista)).setText(lupetto.Pista.toString());
            ((TextView) rootView.findViewById(R.id.txt_sestiglia)).setText(lupetto.Sestiglia.toString());
            ((CheckedTextView) rootView.findViewById(R.id.ctb_cda)).setChecked(lupetto.CdA);
            ((TextView) rootView.findViewById(R.id.txt_fisso)).setText(anagrafica.Tel_fisso);
            ((TextView) rootView.findViewById(R.id.txt_madre)).setText(anagrafica.Cell_Madre);
            ((TextView) rootView.findViewById(R.id.txt_padre)).setText(anagrafica.Cell_Padre);
            ((TextView) rootView.findViewById(R.id.tv_data)).setText(anagrafica.DataNascita);
            ((TextView) rootView.findViewById(R.id.tv_luogo)).setText(anagrafica.Luogo_Nascita);
            specs = Specialità.stringToIDs(lupetto.Specialità);
            provs = Prova.IDStringToProveList(lupetto.Prove);

            //POPOLAZIONE ListView Spec
            TextView tv_spec;
            ScrollView lv = (ScrollView) rootView.findViewById(R.id.lv_Specialità);
            LinearLayout linearLayout = (LinearLayout) lv.getChildAt(0);
            for (Specialità spec : specs) {
                tv_spec = new TextView(getContext());
                tv_spec.setText(spec.Nome);
                tv_spec.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                linearLayout.addView(tv_spec);
            }
            TypedValue typedValue = new TypedValue();
            getActivity().getTheme().resolveAttribute(R.attr.selectableItemBackgroundBorderless, typedValue, true);
            lv = (ScrollView) rootView.findViewById(R.id.lv_Prove);
            linearLayout = (LinearLayout) lv.getChildAt(0);
            for (Prova p : provs){
                final int index = Prova.allProve.indexOf(p);
                tv_spec = new TextView(getContext());
                tv_spec.setText(p.Nome + p.Pista);
                tv_spec.setSingleLine(true);
                tv_spec.setTag(index);
                tv_spec.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                tv_spec.setClickable(true);
                tv_spec.setBackgroundResource(typedValue.resourceId);
                tv_spec.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   Intent i = new Intent(getActivity().getApplicationContext(), ProvaDettaglio.class);
                                                   i.putExtra("ID_Prova", (int) v.getTag());
                                                   i.putExtra("ID_Lupetto", lupetto_id);
                                                    startActivity(i);
                                                   //getActivity().finish();
                                               }
                                           }

                );
                linearLayout.addView(tv_spec);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.lupetto_detail, container, false);
        //View detail = inflater.inflate(R.layout.activity_lupetto_detail, null, false);
        //POPOLAZIONE ACTIVITY
        // Show the dummy content as text in a TextView.


        return rootView;
    }
}
