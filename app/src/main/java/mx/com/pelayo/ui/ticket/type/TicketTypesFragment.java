package mx.com.pelayo.ui.ticket.type;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.com.pelayo.R;
import mx.com.pelayo.database.entities.custom.ItemGrid;
import mx.com.pelayo.ui.grid.OnItemClickListener;
import mx.com.pelayo.ui.ticket.type.adapter.TicketTypesAdapter;
import mx.com.pelayo.util.Tools;
import mx.com.pelayo.widget.SpacingItemDecoration;

public class TicketTypesFragment extends Fragment implements OnItemClickListener {

    private TicketTypesAdapter ticketTypesAdapter;

    public TicketTypesFragment() {
        // Required empty public constructor
    }

    public static TicketTypesFragment newInstance() {
        TicketTypesFragment fragment = new TicketTypesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ticketTypesAdapter = new TicketTypesAdapter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext().getApplicationContext(), calculateColumns());
        recyclerView.addItemDecoration(new SpacingItemDecoration(calculateColumns(), Tools.dpToPx(getContext(), 8), true));
        recyclerView.setAdapter(ticketTypesAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    private int calculateColumns() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int columnCount = (int) (dpWidth / 108);
        return columnCount;
    }

    @Override
    public void onClick(ItemGrid itemGrid) {
    }
}
