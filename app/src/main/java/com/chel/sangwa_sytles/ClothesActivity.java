package com.chel.sangwa_sytles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClothesActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.clothesTextView) TextView mClothesTextView;
    @BindView(R.id.clothList) ListView mClothList;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        ButterKnife.bind(this);

        Intent cheHome = getIntent();
        String location = cheHome.getStringExtra("clothType");
        mClothesTextView.setText( "Here are all the cloth malls near: " + location);

        YelpApi client = YelpClient.getClient();

        Call<YelpBusinessesSearchResponse> call = client.getClothes(location, "clothes");

        call.enqueue(new Callback<YelpBusinessesSearchResponse>() {


            @Override
            public void onResponse(Call<YelpBusinessesSearchResponse> call, Response<YelpBusinessesSearchResponse> response) {

                hideProgressBar();

                if (response.isSuccessful()) {
                    List<Business> clothesList = response.body().getBusinesses();
                    String[] clothes = new String[clothesList.size()];
                    String[] categories = new String[clothesList.size()];

                    for (int i = 0; i < clothes.length; i++){
                        clothes[i] = clothesList.get(i).getName();
                    }

                    for (int i = 0; i < categories.length; i++) {
                        Category category = clothesList.get(i).getCategories().get(0);
                        categories[i] = category.getTitle();
                    }

                    ArrayAdapter adapter = new sangwa_stylesArrayAdapter(ClothesActivity.this, android.R.layout.simple_list_item_1, clothes, categories);
                    mClothList.setAdapter(adapter);
                    showClothes();

                }
                else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<YelpBusinessesSearchResponse> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
            }
        });

    }

    private void showFailureMessage() {
        mErrorTextView.setText("Oops!!! Something went wrong :) Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText(" Oops!!! Seems like Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showClothes() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

}

//
//    private String[] clothes = new String[] {"Blazers", "Tops 0r Tunics",
//            "RoadSter", "Pullovers", "Short Coats", "Keen-Length Coats",
//            "Evenning Dresses", "Carnival Dresses", "Short Skirt", "Twin Sets",
//            "Causal Trousers", "Dhotis", "Jeans",
//            "Formal Shirts", "Summer Wear"};
//
//    private String[] prices = new String[] {"15$", "5$", "4$",
//            "8$", "10$", "14$", "30$", "10$", "7$",
//            "25$", "8$", "9$", "8$", "20$", "9$"};

//    sangwa_stylesArrayAdapter cece = new sangwa_stylesArrayAdapter(this, android.R.layout.simple_list_item_1, clothes, prices);

//        mClothList.setAdapter(cece);
//                mClothList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//@Override
//public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
//        String clothes = ((TextView)view).getText().toString();
//        Toast.makeText(ClothesActivity.this, clothes, Toast.LENGTH_LONG).show();
//        }
//        });