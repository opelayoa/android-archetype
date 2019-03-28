package mx.com.pelayo.ui.ticket.type.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import mx.com.pelayo.R;
import mx.com.pelayo.database.entities.custom.ItemGrid;
import mx.com.pelayo.ui.grid.OnItemClickListener;

public class TicketTypesAdapter extends RecyclerView.Adapter<TicketTypesAdapter.ViewHolder> {

    List<ItemGrid> itemGrid;
    OnItemClickListener onItemClickListener;

    public TicketTypesAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_grid, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemGrid itemGrid = this.itemGrid.get(position);
        holder.descripcion.setText(itemGrid.getDescripcion());
        holder.icon.setText(itemGrid.getIcon());
    }

    @Override
    public int getItemCount() {
        if (itemGrid != null)
            return itemGrid.size();
        return 0;
    }

    public void setItemGrid(List<ItemGrid> itemGrid) {
        this.itemGrid = itemGrid;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView descripcion;
        public Button icon;

        public ViewHolder(@NonNull View view) {
            super(view);
            descripcion = view.findViewById(R.id.descripcion);
            icon = view.findViewById(R.id.icon);
            icon.setClickable(false);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onItemClickListener != null) {
                onItemClickListener.onClick(itemGrid.get(getAdapterPosition()));
            }
        }
    }
}