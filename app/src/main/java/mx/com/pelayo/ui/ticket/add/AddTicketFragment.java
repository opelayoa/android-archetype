package mx.com.pelayo.ui.ticket.add;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import javax.inject.Inject;

import mx.com.pelayo.App;
import mx.com.pelayo.R;
import mx.com.pelayo.database.entities.custom.ItemAutocomplete;
import mx.com.pelayo.repository.TicketAddRepository;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddTicketFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddTicketFragment extends Fragment {

    @Inject
    TicketAddRepository ticketAddRepository;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TYPE_PARAM = "type_id";
    private static final String SYMPTOM_PARAM = "symptom";
    private static final String DIAGNOSTIC_PARAM = "symptom";

    private AutoCompleteTextView applicant;
    private AutoCompleteTextView region;

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
     * @param typeId       Parameter 1.
     * @param symptomId    Parameter 2.
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
        ((App) getActivity().getApplicationContext()).getApplicationComponent().inject(this);


        if (getArguments() != null) {
            typeId = getArguments().getInt(TYPE_PARAM);
            symptomId = getArguments().getInt(SYMPTOM_PARAM);
            diagnosticId = getArguments().getInt(DIAGNOSTIC_PARAM);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_ticket, container, false);

        configApplicants(view);
        configRegions(view);

        return view;
    }

    private void configApplicants(View view) {
        applicant = view.findViewById(R.id.applicant);
        ArrayAdapter<ItemAutocomplete> applicantAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line);


        ticketAddRepository.getAllUsuarios().observe(this, usuarios -> {
            applicantAdapter.clear();
            applicantAdapter.addAll(usuarios);
            applicantAdapter.notifyDataSetChanged();

        });

        applicant.setAdapter(applicantAdapter);

        applicant.setOnItemClickListener((parent, view1, position, id) -> {
            ItemAutocomplete data = (ItemAutocomplete) parent.getItemAtPosition(position);
            Toast.makeText(AddTicketFragment.this.getContext(), data.toString(), Toast.LENGTH_SHORT).show();
        });
    }

    private void configRegions(View view) {
        region = view.findViewById(R.id.region);
        ArrayAdapter<ItemAutocomplete> regionAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line);

        ticketAddRepository.getAllRegions().observe(this, regions -> {
            regionAdapter.clear();
            regionAdapter.addAll(regions);
            regionAdapter.notifyDataSetChanged();
        });


        region.setAdapter(regionAdapter);

        region.setOnItemClickListener((parent, view1, position, id) -> {
            ItemAutocomplete data = (ItemAutocomplete) parent.getItemAtPosition(position);
            Toast.makeText(AddTicketFragment.this.getContext(), data.toString(), Toast.LENGTH_SHORT).show();
        });
    }

}
