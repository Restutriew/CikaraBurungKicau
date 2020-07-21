package com.cikarastudio.cikaraburungkicau.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cikarastudio.cikaraburungkicau.Adapter.BurungAdapter;
import com.cikarastudio.cikaraburungkicau.Model.Burung;
import com.cikarastudio.cikaraburungkicau.R;

import java.util.ArrayList;

public class ListBurungActivity extends AppCompatActivity {

    private RecyclerView rvBurung;
    private ArrayList<Burung> list = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_burung);

        rvBurung = findViewById(R.id.rv_listBurung);
        rvBurung.setHasFixedSize(true);
        list.addAll(getListBurung());
        showRecyclerList();

    }

    private void showRecyclerList() {
        layoutManager = new LinearLayoutManager(this);
        rvBurung.setLayoutManager(layoutManager);
        BurungAdapter listBurungAdapter = new BurungAdapter(list);
        rvBurung.setAdapter(listBurungAdapter);

        listBurungAdapter.setOnItemClickCallback(new BurungAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Burung data) {
                Intent detailburung = new Intent(ListBurungActivity.this, DeskripsiActivity.class);
                detailburung.putExtra(DeskripsiActivity.EXTRA_MASSAGE, data);
                startActivity(detailburung);
            }
        });

    }

    private ArrayList<Burung> getListBurung() {
        String[] dataNamaBurung = getResources().getStringArray(R.array.data_namaBurung);
        String[] dataDeskripsiBurung = getResources().getStringArray(R.array.data_deskripsiBurung);
        TypedArray dataPhotoBurung = getResources().obtainTypedArray(R.array.data_photoBurung);
        TypedArray dataAudioBurung = getResources().obtainTypedArray(R.array.data_audioBurung);
        ArrayList<Burung> listBurung = new ArrayList<>();
        for (int i = 0; i < dataNamaBurung.length; i++) {
            Burung burung = new Burung();
            burung.setNamaBurung(dataNamaBurung[i]);
            burung.setDeskripsiBurung(dataDeskripsiBurung[i]);
            burung.setFotoBurung(dataPhotoBurung.getResourceId(i, -1));
            burung.setAudioBurung(dataAudioBurung.getResourceId(i, -1));
            listBurung.add(burung);
        }
        return listBurung;
    }
}