package mx.com.pelayo.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.com.pelayo.R;
import mx.com.pelayo.ui.MainActivity;
import mx.com.pelayo.ui.grid.GridFragment;

public class HomeFragment extends Fragment {

    private CardView toAdd;
    private CardView toList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        toAdd = view.findViewById(R.id.toAddTicket);
        toAdd.setOnClickListener(v -> goToAdd(v));
        toList = view.findViewById(R.id.toListTicket);
        toList.setOnClickListener(v -> goToTicketStates(v));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).showBanner();
    }

    private void goToAdd(View view) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, GridFragment.newInstance(GridFragment.TYPE_TYPE, null, null), "type")
                .addToBackStack("type")
                .commit();
    }

    private void goToTicketStates(View view) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, GridFragment.newInstance(GridFragment.TICKET_STATES_TYPE, null, null), "ticket_type")
                .addToBackStack("ticket_type")
                .commit();
    }
}
