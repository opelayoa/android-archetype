package mx.com.pelayo.ui.grid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import mx.com.pelayo.App;
import mx.com.pelayo.R;
import mx.com.pelayo.database.entities.custom.ItemGrid;
import mx.com.pelayo.database.entities.custom.UserInformation;
import mx.com.pelayo.ui.MainActivity;
import mx.com.pelayo.ui.ticket.add.AddTicketFragment;
import mx.com.pelayo.ui.ticket.list.ListTicketFragment;
import mx.com.pelayo.util.Tools;
import mx.com.pelayo.viewmodel.GridViewModel;
import mx.com.pelayo.viewmodel.SecurityViewModel;
import mx.com.pelayo.widget.SpacingItemDecoration;

public class GridFragment extends Fragment implements OnItemClickListener {

    public static final String GRID_TYPE = "grid_type";
    public static final String TYPE_TYPE = "type";
    public static final String TYPE_ID = "typeId";

    public static final String SYMPTOM_TYPE = "symptom";
    public static final String SYMPTOM_ID = "symptomId";
    public static final String DIAGNOSTIC_TYPE = "diagnostic";
    public static final String TICKET_STATES_TYPE = "ticket_states";

    @Inject
    public SecurityViewModel securityViewModel;
    @Inject
    public GridViewModel gridViewModel;
    private String gridType;
    private Integer typeId;
    private Integer symptomId;
    private RecyclerView recyclerView;
    private GridAdapter gridAdapter;

    public GridFragment() {
    }

    public static GridFragment newInstance(String gridType, Integer typeId, Integer symptomId) {
        GridFragment fragment = new GridFragment();
        Bundle args = new Bundle();
        args.putString(GRID_TYPE, gridType);
        if (typeId != null) {
            args.putInt(TYPE_ID, typeId);
        }
        if (symptomId != null) {
            args.putInt(SYMPTOM_ID, symptomId);
        }
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getActivity().getApplicationContext()).getApplicationComponent().inject(this);
        if (getArguments() != null) {
            gridType = getArguments().getString(GRID_TYPE);
            typeId = getArguments().getInt(TYPE_ID);
            symptomId = getArguments().getInt(SYMPTOM_ID);
        }
        gridAdapter = new GridAdapter(this);
        gridViewModel.getUserInformation().observe(this, this::loadItems);

    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).hideBanner();
    }

    private void loadItems(UserInformation userInformation) {
        if (gridType.equalsIgnoreCase(TYPE_TYPE)) {
            gridViewModel.getTypes().observe(this, data -> gridAdapter.setItemGrid(data));
            gridViewModel.setProfileFilter(userInformation.getPerfilId());
        } else if (gridType.equalsIgnoreCase(SYMPTOM_TYPE)) {
            gridViewModel.getSymptoms().observe(this, data -> gridAdapter.setItemGrid(data));
            gridViewModel.setSymptomFilter(new GridViewModel.SymptomFilter(typeId, userInformation.getPerfilId()));
        } else if (gridType.equalsIgnoreCase(DIAGNOSTIC_TYPE)) {
            gridViewModel.getDiagnostics().observe(this, data -> gridAdapter.setItemGrid(data));
            gridViewModel.setDiagnosticFilter(new GridViewModel.DiagnosticFilter(symptomId, userInformation.getPerfilId()));
        } else if (gridType.equalsIgnoreCase(TICKET_STATES_TYPE)) {
            gridViewModel.getTicketStates().observe(this, data -> gridAdapter.setItemGrid(data));
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext().getApplicationContext(), calculateColumns());
        recyclerView.addItemDecoration(new SpacingItemDecoration(calculateColumns(), Tools.dpToPx(getContext(), 8), true));
        recyclerView.setAdapter(gridAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(ItemGrid itemGrid) {
        if (gridType.equalsIgnoreCase(TYPE_TYPE)) {
            goTo(SYMPTOM_TYPE, itemGrid.getId(), null);
        } else if (gridType.equalsIgnoreCase(SYMPTOM_TYPE)) {
            goTo(DIAGNOSTIC_TYPE, typeId, itemGrid.getId());
        } else if (gridType.equalsIgnoreCase(DIAGNOSTIC_TYPE)) {
            goToAdd(typeId, symptomId, itemGrid.getId());
        } else if (gridType.equalsIgnoreCase(TICKET_STATES_TYPE)) {
            goToTicketList(itemGrid.getId());
        }
    }

    private void goTo(String type, Integer typeId, Integer symptomId) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                .replace(R.id.content_frame, GridFragment.newInstance(type, typeId, symptomId))
                .addToBackStack(null)
                .commit();
    }

    private void goToAdd(Integer typeId, Integer symptomId, Integer diagnosticId) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                .replace(R.id.content_frame, AddTicketFragment.newInstance(typeId, symptomId, diagnosticId))
                .addToBackStack(null)
                .commit();
    }

    private void goToTicketList(Integer ticketStateId) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                .replace(R.id.content_frame, ListTicketFragment.newInstance(ticketStateId))
                .addToBackStack(null)
                .commit();
    }

    private int calculateColumns() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int columnCount = (int) (dpWidth / 108);
        return columnCount;
    }
}
