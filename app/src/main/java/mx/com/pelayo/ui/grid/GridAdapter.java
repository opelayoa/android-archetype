package mx.com.pelayo.ui.grid;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import mx.com.pelayo.R;
import mx.com.pelayo.database.entities.custom.ItemGrid;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {


    List<ItemGrid> itemGrid;
    OnItemClickListener onItemClickListener;

    public GridAdapter(OnItemClickListener onItemClickListener) {
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
        holder.icon.setText(Html.fromHtml(itemGrid.getIcon()));
    }

    @Override
    public int getItemCount() {
        if (itemGrid != null)
            return itemGrid.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView descripcion;
        public Button icon;


        public ViewHolder(@NonNull View view) {
            super(view);
            descripcion = view.findViewById(R.id.descripcion);
            icon = view.findViewById(R.id.icon);
            icon.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onItemClickListener != null) {
                onItemClickListener.onClick(itemGrid.get(getAdapterPosition()));
            }
        }
    }

    public void setItemGrid(List<ItemGrid> itemGrid) {
        this.itemGrid = itemGrid;
        notifyDataSetChanged();
    }
}