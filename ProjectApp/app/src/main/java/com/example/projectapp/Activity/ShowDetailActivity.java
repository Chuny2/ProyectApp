package com.example.projectapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectapp.Domain.FoodDomain;
import com.example.projectapp.Helper.ManagementCart;
import com.example.projectapp.R;

public class ShowDetailActivity extends AppCompatActivity {
private TextView addToCartBtn;
private TextView titleTxt,feeTxt,descriptionTxt,numberOrderTxt,totalPriceTxt,starTxt,caloryTxt,timeTxt;
private ImageView plusBtn,minusBtn,picFood;
private FoodDomain object;
private int numberOrder=1;
private ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        managementCart=new ManagementCart(this);
        iniView();

    }

    private void iniView() {
        addToCartBtn=findViewById(R.id.addToCartBtn);
        titleTxt=findViewById(R.id.titleTxt);
        feeTxt=findViewById(R.id.priceTxt);
        descriptionTxt=findViewById(R.id.descripcionTxt);
        numberOrderTxt=findViewById(R.id.numberItemTxt);
        plusBtn=findViewById(R.id.plusCardBtn);
        minusBtn=findViewById(R.id.minusCardBtn);
        picFood=findViewById(R.id.foodPic);
        totalPriceTxt=findViewById(R.id.totalPriceTxt);
        starTxt=findViewById(R.id.starTxt);
        caloryTxt=findViewById(R.id.caloriesTxt);
        timeTxt=findViewById(R.id.timeTxt);
    }

}