package mx.com.pelayo.ui.ticket.add;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.com.pelayo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddTicketFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddTicketFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TYPE_PARAM = "type_id";
    private static final String SYMPTOM_PARAM = "symptom";
    private static final String DIAGNOSTIC_PARAM = "symptom";

    private int typeId;
    private int symptomId;
    private int diagnosticId;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddTicketFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param typeId Parameter 1.
     * @param symptomId Parameter 2.
     * @param diagnosticId Parameter 2.
     * @return A new instance of fragment AddTicketFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddTicketFragment newInstance(Integer typeId, Integer symptomId, Integer diagnosticId) {
        AddTicketFragment fragment = new AddTicketFragment();
        Bundle args = new Bundle();
        args.putInt(TYPE_PARAM, typeId);
        args.putInt(SYMPTOM_PARAM, symptomId);
        args.putInt(DIAGNOSTIC_PARAM, diagnosticId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            typeId = getArguments().getInt(TYPE_PARAM);
            symptomId = getArguments().getInt(SYMPTOM_PARAM);
            diagnosticId = getArguments().getInt(DIAGNOSTIC_PARAM);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_ticket, container, false);
    }

}
