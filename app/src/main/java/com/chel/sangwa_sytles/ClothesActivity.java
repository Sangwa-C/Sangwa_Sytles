package com.chel.sangwa_sytles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class ClothesActivity extends AppCompatActivity {
    @BindView(R.id.clothesTextView) TextView mClothesTextView;
    @BindView(R.id.clothList) ListView mClothList;



    private String[] clothes = new String[] {"Blazers", "Tops 0r Tunics",
            "RoadSter", "Pullovers", "Short Coats", "Keen-Length Coats",
            "Evenning Dresses", "Carnival Dresses", "Short Skirt", "Twin Sets",
            "Causal Trousers", "Dhotis", "Jeans",
            "Formal Shirts", "Summer Wear"};

    private String[] prices = new String[] {"15$", "5$", "4$",
            "8$", "10$", "14$", "30$", "10$", "7$",
            "25$", "8$", "9$", "8$", "20$", "9$"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);

        ButterKnife.bind(this);
        Intent cheHome = getIntent();
        String clothType = cheHome.getStringExtra("clothType");
        sangwa_stylesArrayAdapter cece = new sangwa_stylesArrayAdapter(this, android.R.layout.simple_list_item_1, clothes, prices);

        YelpApi client = YelpClient.getClient();

        Call<YelpBusinessesSearchResponse> call = client.getRestaurants(location, "restaurants");


        mClothList.setAdapter(cece);
        mClothList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String clothes = ((TextView)view).getText().toString();
                Toast.makeText(ClothesActivity.this, clothes, Toast.LENGTH_LONG).show();
            }
        });
        mClothesTextView.setText(clothType + " cloth");
    }


}