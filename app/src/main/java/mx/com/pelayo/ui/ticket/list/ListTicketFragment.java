package mx.com.pelayo.ui.ticket.list;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import mx.com.pelayo.App;
import mx.com.pelayo.R;
import mx.com.pelayo.api.entities.TicketSummary;
import mx.com.pelayo.database.entities.custom.ItemGrid;
import mx.com.pelayo.ui.ticket.detail.TicketDetailFragment;
import mx.com.pelayo.ui.ticket.list.adapter.ListTicketAdapter;
import mx.com.pelayo.ui.ticket.list.listener.OnItemTicketListener;
import mx.com.pelayo.ui.util.DialogFactory;
import mx.com.pelayo.util.Tools;
import mx.com.pelayo.viewmodel.ListTicketViewModel;

public class ListTicketFragment extends Fragment implements OnItemTicketListener {

    private static final String TICKET_STATE_ID_PARAM = "ticket_state_id";
    @Inject
    ListTicketViewModel listTicketViewModel;
    private Integer ticketStateId;
    private ListTicketAdapter listTicketAdapter;

    private Dialog progressDialog;
    private Dialog errorDialog;

    public ListTicketFragment() {
    }

    public static ListTicketFragment newInstance(Integer ticketStateId) {
        ListTicketFragment fragment = new ListTicketFragment();
        Bundle args = new Bundle();
        args.putInt(TICKET_STATE_ID_PARAM, ticketStateId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getActivity().getApplicationContext()).getApplicationComponent().inject(this);
        if (getArguments() != null) {
            this.ticketStateId = getArguments().getInt(TICKET_STATE_ID_PARAM);
        }
        progressDialog = DialogFactory.getProgressDialog(this.getContext(), "Espere...");
        progressDialog.show();
        listTicketAdapter = new ListTicketAdapter(this);
        listTicketViewModel.getTicketsSummary(ticketStateId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(data -> {
                            progressDialog.dismiss();
                            listTicketAdapter.setTickets(data);
                        }
                        , throwable -> {
                            DialogFactory.DialogListener dialogListener = dialog -> ListTicketFragment.this.getActivity().onBackPressed();
                            errorDialog = DialogFactory.getErrorDialog(this.getContext(), Tools.parseError(throwable), dialogListener);
                            errorDialog.show();
                        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_ticket, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(listTicketAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        return view;
    }

    @Override
    public void onClick(TicketSummary ticketSummary) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                .replace(R.id.content_frame, TicketDetailFragment.newInstance(ticketSummary.getId()))
                .addToBackStack(null)
                .commit();
    }
}
