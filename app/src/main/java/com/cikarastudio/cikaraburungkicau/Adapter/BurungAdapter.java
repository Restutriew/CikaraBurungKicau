package com.cikarastudio.cikaraburungkicau.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cikarastudio.cikaraburungkicau.Model.Burung;
import com.cikarastudio.cikaraburungkicau.R;

import java.util.ArrayList;

public class BurungAdapter extends RecyclerView.Adapter<BurungAdapter.ListViewHolder>  {

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Burung data);
    }


    private ArrayList<Burung> listBurung;

    public BurungAdapter(ArrayList<Burung> listBurung) {
        this.listBurung = listBurung;
    }

    @NonNull
    @Override
    public BurungAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_burung, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BurungAdapter.ListViewHolder holder, int position) {
        final Burung burung = listBurung.get(position);
        holder.img_list.setImageResource(burung.getFotoBurung());
        holder.tv_judul.setText(burung.getNamaBurung());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listBurung.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBurung.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView img_list;
        TextView tv_judul;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            img_list = itemView.findViewById(R.id.img_listBurung);
            tv_judul = itemView.findViewById(R.id.tv_listNamaBurung);

        }
    }
}
