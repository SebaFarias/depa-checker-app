package com.example.checkdepa.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.checkdepa.R;
import com.example.checkdepa.databinding.ItemLayoutBinding;
import com.example.checkdepa.model.Apartment;
import com.example.checkdepa.viewmodel.ApartmentViewModel;

import java.util.ArrayList;
import java.util.List;

public class ApartmentAdapter extends RecyclerView.Adapter<ApartmentAdapter.ApartmentViewHolder> {

    private List<Apartment> lista;
    private ApartmentViewModel model;
    private OnClickListener listener;

    public ApartmentAdapter( ApartmentViewModel model )
    {
        this.lista = new ArrayList<>();
        this.model = model;
    }
    public void setLista(List<Apartment> lista){
        this.lista = lista;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ApartmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ApartmentViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ApartmentAdapter.ApartmentViewHolder holder, int position) {
        holder.bindData(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public interface OnClickListener{        void onClick( Apartment a );    }

    public void setListener( OnClickListener listener ){        this.listener = listener;    }

    class ApartmentViewHolder extends RecyclerView.ViewHolder
    {
        ItemLayoutBinding b;
        OnClickListener listener;

        public ApartmentViewHolder(@NonNull View itemView, OnClickListener listener)
        {
            super(itemView);
            b = ItemLayoutBinding.bind(itemView);
            this.listener = listener;
        }
        public void bindData( Apartment apartment )
        {
            b.lblNombre.setText(apartment.getNombre());
            b.lblUnidad.setText(apartment.getUnidad());
            b.lblDireccion.setText(apartment.getDireccion());
            itemView.setOnClickListener( v -> {
                listener.onClick(apartment);
            });
        }
    }
}
