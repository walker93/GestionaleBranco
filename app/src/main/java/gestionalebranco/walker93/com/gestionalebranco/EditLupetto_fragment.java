package gestionalebranco.walker93.com.gestionalebranco;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EditLupetto_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EditLupetto_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditLupetto_fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final int LUPETTO_ID = 0;
    public int mLupetto_ID;
    Lupetto lupetto;
    Anagrafica anagrafica;
    private OnFragmentInteractionListener mListener;

    public EditLupetto_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param ID_Lupetto Parameter 1.
     *                   * @return A new instance of fragment EditLupetto_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditLupetto_fragment newInstance(int ID_Lupetto) {
        EditLupetto_fragment fragment = new EditLupetto_fragment();
        Bundle args = new Bundle();
        args.putInt("LUPETTO_ID", ID_Lupetto);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mLupetto_ID = getArguments().getInt("LUPETTO_ID", 0);
            if (mLupetto_ID > 0) {
                lupetto = Lupetto.findById(Lupetto.class, mLupetto_ID);
                anagrafica = lupetto.Anagrafica;

            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_edit_lupetto_layout, container, false);
        Spinner spinner_Sestiglia = (Spinner) rootView.findViewById(R.id.spinner_Sestiglia);
        spinner_Sestiglia.setAdapter(new ArrayAdapter<>(this.getContext(),
                R.layout.support_simple_spinner_dropdown_item, Sestiglie.values()));
        Spinner spinner_Pista = (Spinner) rootView.findViewById(R.id.spinner_Pista);
        spinner_Pista.setAdapter(new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item, Pista.values()));

        if (lupetto != null) {
            //((TextView) rootView.findViewById(R.id.lupetto_detail)).setText(lupetto.Cognome);

            ((EditText) rootView.findViewById(R.id.et_email)).setText(anagrafica.Email);
            ((EditText) rootView.findViewById(R.id.et_Indirizzo)).setText(anagrafica.Indirizzo);
            spinner_Pista.setSelection(lupetto.Pista.ordinal());
            spinner_Sestiglia.setSelection(lupetto.Sestiglia.ordinal());
            ((CheckBox) rootView.findViewById(R.id.cb_cda)).setEnabled(lupetto.CdA);
            ((EditText) rootView.findViewById(R.id.et_Fisso)).setText(anagrafica.Tel_fisso);
            ((EditText) rootView.findViewById(R.id.et_Madre)).setText(anagrafica.Cell_Madre);
            ((EditText) rootView.findViewById(R.id.et_Padre)).setText(anagrafica.Cell_Padre);
        }

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
