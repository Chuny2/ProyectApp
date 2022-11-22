package com.example.projectapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.projectapp.Domain.GunDomain;
import com.example.projectapp.Helper.ManagementCart;
import com.example.projectapp.R;

public class ShowDetailActivity extends AppCompatActivity {
private TextView addToCartBtn;
private TextView titleTxt,feeTxt,descriptionTxt,numberOrderTxt,totalPriceTxt,starTxt, ammunitionTxt, caliberTxt;
private ImageView plusBtn,minusBtn,picFood;
private GunDomain object;
private int numberOrder=1;
private ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        managementCart=new ManagementCart(this);
        iniView();
        getBundle();

    }

    private void getBundle(){
        object = (GunDomain) getIntent().getSerializableExtra("object");

        int drawableResourcesId=this.getResources().getIdentifier(object.getPic(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourcesId)
                .into(picFood);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getFee());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));
        ammunitionTxt.setText(object.getAmmunition() + " bullets");
        starTxt.setText(object.getStar() + "");
        caliberTxt.setText(object.getCaliber() + " mm");
        totalPriceTxt.setText("$"+Math.round(numberOrder * object.getFee()));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder = numberOrder + 1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText("$"+Math.round(numberOrder * object.getFee()));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOrder > 1){
                    numberOrder = numberOrder -1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText("$"+Math.round(numberOrder * object.getFee()));
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(numberOrder);
                managementCart.insertFood(object);

                startActivity(new Intent(ShowDetailActivity.this,MainActivity.class));

            }
        });

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
        ammunitionTxt =findViewById(R.id.ammunitionTxt);
        caliberTxt =findViewById(R.id.caliberTxt);

    }

}