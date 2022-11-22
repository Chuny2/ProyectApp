package com.example.projectapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.projectapp.Adapter.CategoryAdapter;
import com.example.projectapp.Adapter.RecommendedAdapter;
import com.example.projectapp.Domain.CategoryDomain;
import com.example.projectapp.Domain.GunDomain;
import com.example.projectapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);
        LinearLayout contactBtn=findViewById(R.id.contactBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartActivity.class));
            }
        });

        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ContactActivity.class));

            }
        });

    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<GunDomain> gunlist = new ArrayList<>();
        gunlist.add(new GunDomain("Desert Eagle", "deserteagle", "La Desert Eagle es una pistola semiautomática de grueso calibre accionada por los gases del disparo, diseñada por la firma estadounidense Magnum Research", 4499.49,5, 13, 7));
        gunlist.add(new GunDomain("Mauser L96", "franco", "Rifle de francotirador de resorte modelo L96 en su origen fue usada por las fuerzas alemanas a finales del siglo XIX", 2799.99,4, 6, 23));
        gunlist.add(new GunDomain("HK 417D", "asalto", "Es un fusil de combate diseñado y fabricado en Alemania, surgido de la experiencia de las fuerzas internacionales en la Guerra de Afganistán y la guerra de Irak", 1949.99,3, 6, 20));
        gunlist.add(new GunDomain("Granada de mano","granada", "Es un proyectil explosivo que se lanza con la mano o con un arma específica", 499.99,4,0,0));
        gunlist.add(new GunDomain("Cyma M870","escopeta","Marca: CYMA\n" +
                "\n" +
                "Modelo: M870 CM352\n" +
                "\n" +
                "Tipo: Muelle\n" +
                "\n" +
                "Color: Negro\n" +
                "\n" +
                "Material: Polimero ABS y Metal\n" +
                "\n" +
                "Hop Up: Fijo\n" +
                "\n" +
                "Mosfet: No",2999.99,5,12,8));

        adapter2 = new RecommendedAdapter(gunlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.view1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pistolas","pistola"));
        categoryList.add(new CategoryDomain("Sniper","francotirador"));
        categoryList.add(new CategoryDomain("Rifles","rifleAsalto"));
        categoryList.add(new CategoryDomain("Granadas","arrojadizos"));
        categoryList.add(new CategoryDomain("Munición","municiones"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}