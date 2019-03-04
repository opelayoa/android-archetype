package mx.com.pelayo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mx.com.pelayo.R;
import mx.com.pelayo.database.entities.Usuario;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {

    class UsuarioViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView email;

        private UsuarioViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
        }
    }

    private final LayoutInflater mInflater;
    private List<Usuario> usuarios; // Cached copy of words

    public UsuarioAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_usuario, parent, false);
        return new UsuarioViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        if (usuarios != null) {
            Usuario current = usuarios.get(position);
            holder.name.setText(current.getAlias());
            holder.email.setText(current.getEmail());
        } else {
            // Covers the case of data not being ready yet.
            holder.name.setText("No Name");
            holder.email.setText("No Email");
        }
    }

    @Override
    public int getItemCount() {
        if (usuarios != null)
            return usuarios.size();
        else return 0;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        notifyDataSetChanged();
    }
}
