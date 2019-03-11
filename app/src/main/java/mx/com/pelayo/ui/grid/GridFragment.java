package mx.com.pelayo.ui.grid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import mx.com.pelayo.App;
import mx.com.pelayo.R;
import mx.com.pelayo.database.entities.composed.UsuarioActualComposed;
import mx.com.pelayo.database.entities.custom.ItemGrid;
import mx.com.pelayo.ui.MainActivity;
import mx.com.pelayo.util.Tools;
import mx.com.pelayo.viewmodel.GridViewModel;
import mx.com.pelayo.viewmodel.SecurityViewModel;
import mx.com.pelayo.widget.SpacingItemDecoration;


public class GridFragment extends Fragment implements OnItemClickListener {

    private static final String GRID_TYPE = "grid_type";
    private static final String TYPE_TYPE = "type";
    private static final String TYPE_ID = "typeId";

    private static final String SYMPTOM_TYPE = "symptom";
    private static final String SYMPTOM_ID = "symptomId";

    private static final String DIAGNOSTIC_TYPE = "diagnostic";

    private String gridType;
    private Integer typeId;
    private Integer symptomId;
    private RecyclerView recyclerView;
    private GridAdapter gridAdapter;

    @Inject
    public SecurityViewModel securityViewModel;
    @Inject
    public GridViewModel gridViewModel;


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
        securityViewModel.getUsuarioActual().observe(this, usuarioActualComposed -> loadItems(usuarioActualComposed));

    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).hideBanner();
    }

    private void loadItems(UsuarioActualComposed usuarioActualComposed) {
        if (gridType.equalsIgnoreCase(TYPE_TYPE)) {
            gridViewModel.getAllTiposGrid(usuarioActualComposed.usuarioActual.getPerfilId())
                    .observe(this, gridItems -> {
                        gridAdapter.setItemGrid(gridItems);
                    });
        } else if (gridType.equalsIgnoreCase(SYMPTOM_TYPE)) {
            gridViewModel.getAllSintomasGrid(typeId, usuarioActualComposed.usuarioActual.getPerfilId())
                    .observe(this, gridItems -> {
                        gridAdapter.setItemGrid(gridItems);
                    });
        } else if (gridType.equalsIgnoreCase(DIAGNOSTIC_TYPE)) {
            gridViewModel.getAllDiagnosticosGrid(symptomId, usuarioActualComposed.usuarioActual.getPerfilId())
                    .observe(this, gridItems -> {
                        gridAdapter.setItemGrid(gridItems);
                    });
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);


        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext().getApplicationContext(), 3);
        recyclerView.addItemDecoration(new SpacingItemDecoration(3, Tools.dpToPx(getContext(), 8), true));
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
        }
    }

    private void goTo(String type, Integer typeId, Integer symptomId) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, GridFragment.newInstance(type, typeId, symptomId))
                .addToBackStack(null)
                .commit();
    }
}
