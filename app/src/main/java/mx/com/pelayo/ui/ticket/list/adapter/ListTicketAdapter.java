package mx.com.pelayo.ui.ticket.list.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mx.com.pelayo.R;
import mx.com.pelayo.api.entities.TicketSummary;
import mx.com.pelayo.ui.ticket.list.listener.OnItemTicketListener;

public class ListTicketAdapter extends RecyclerView.Adapter<ListTicketAdapter.ViewHolder> {

    OnItemTicketListener onItemClickListener;
    private List<TicketSummary> tickets;

    public ListTicketAdapter(OnItemTicketListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_ticket, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        TicketSummary ticketSummary = tickets.get(position);
        viewHolder.ticketId.setText(String.valueOf(ticketSummary.getId()));
        viewHolder.legend.setText(ticketSummary.getLeyenda());
    }

    public void setTickets(List<TicketSummary> tickets) {
        this.tickets = tickets;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (tickets != null)
            return tickets.size();
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView ticketId;
        TextView legend;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ticketId = itemView.findViewById(R.id.ticketId);
            legend = itemView.findViewById(R.id.legend);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                onItemClickListener.onClick(tickets.get(getAdapterPosition()));
            }
        }
    }
}
