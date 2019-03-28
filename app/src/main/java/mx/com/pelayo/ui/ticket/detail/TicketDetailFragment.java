package mx.com.pelayo.ui.ticket.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import mx.com.pelayo.R;
import mx.com.pelayo.util.Tools;

public class TicketDetailFragment extends Fragment {

    private static final String TICKET_ID_PARAM = "ticketId";

    private ImageView barcode;
    private TextView ticket;

    private Integer ticketId;

    public TicketDetailFragment() {
        // Required empty public constructor
    }

    public static TicketDetailFragment newInstance(Integer ticketId) {
        TicketDetailFragment fragment = new TicketDetailFragment();
        Bundle args = new Bundle();
        args.putInt(TICKET_ID_PARAM, ticketId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ticketId = getArguments().getInt(TICKET_ID_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ticket_detail, container, false);
        barcode = view.findViewById(R.id.barcode);
        barcode.setImageBitmap(Tools.convertToBarcode("" + ticketId));
        ticket = view.findViewById(R.id.ticketId);
        ticket.setText(Tools.addSpacesBetween("" + ticketId, 10));
        return view;
    }

}
