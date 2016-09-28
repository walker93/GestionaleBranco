package gestionalebranco.walker93.com.gestionalebranco;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;


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

    private Lupetto lupetto;
    private Anagrafica anagrafica;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public LupettoDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {

            lupetto = Lupetto.findById(Lupetto.class, getArguments().getInt(ARG_ITEM_ID)+1);
            anagrafica = lupetto.Anagrafica;
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(lupetto.Nome + " " + lupetto.Cognome);
            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.lupetto_detail, container, false);
        //View detail = inflater.inflate(R.layout.activity_lupetto_detail, null, false);
        //POPOLAZIONE ACTIVITY
        // Show the dummy content as text in a TextView.
        if (lupetto != null) {
            //((TextView) rootView.findViewById(R.id.lupetto_detail)).setText(lupetto.Cognome);

            ((TextView) rootView.findViewById(R.id.txt_email)).setText(anagrafica.Email);
            ((TextView) rootView.findViewById(R.id.txt_indirizzo)).setText(anagrafica.Indirizzo);
            ((TextView) rootView.findViewById(R.id.txt_pista)).setText(lupetto.Pista.name());
            ((TextView) rootView.findViewById(R.id.txt_sestiglia)).setText(lupetto.Sestiglia.name());
            ((CheckBox) rootView.findViewById(R.id.cb_cda)).setEnabled(lupetto.CdA);
            ((TextView) rootView.findViewById(R.id.txt_fisso)).setText(anagrafica.Tel_fisso);
            ((TextView) rootView.findViewById(R.id.txt_madre)).setText(anagrafica.Cell_Madre);
            ((TextView) rootView.findViewById(R.id.txt_padre)).setText(anagrafica.Cell_Padre);
        }

        return rootView;
    }
}
