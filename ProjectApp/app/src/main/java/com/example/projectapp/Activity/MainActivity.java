package com.example.projectapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projectapp.Adapter.CategoryAdapter;
import com.example.projectapp.Adapter.RecommendedAdapter;
import com.example.projectapp.Domain.CategoryDomain;
import com.example.projectapp.Domain.FoodDomain;
import com.example.projectapp.R;

import java.security.Policy;
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
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Desert Eagle", "deserteagle", "slices pepperoni, mozzarella cheese, fresh oregano, ground black pepper, pizza sauce", 13.0,5, 20, 1000));
        foodlist.add(new FoodDomain("Mauser L96", "franco", "beef, Gouda Cheese, Special Sauce, Lettuce, tomato", 15.20,4, 18, 1500));
        foodlist.add(new FoodDomain("HK 417D", "asalto", "olive oil, Vegetable oil, pitted Kalamata, cherry tomatoes, fresh oregano, basil", 11.0,3, 16, 800));

        adapter2 = new RecommendedAdapter(foodlist);
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