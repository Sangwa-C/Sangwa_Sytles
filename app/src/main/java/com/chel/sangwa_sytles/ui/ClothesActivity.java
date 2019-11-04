package com.chel.sangwa_sytles.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.chel.sangwa_sytles.R;
import com.chel.sangwa_sytles.MallAdapters.sangwa_stylesArrayAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClothesActivity extends AppCompatActivity {
    @BindView(R.id.clothesTextView) TextView mClothesTextView;
    @BindView(R.id.clothList) ListView mClothList;


    private String[] clothes = new String[] {"Blazers", "Tops 0r Tunics",
            "RoadSter", "Pullovers", "Short Coats", "Keen-Length Coats",
            "Evening Dresses", "Carnival Dresses", "Short Skirt", "Twin Sets",
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

        mClothList.setAdapter(cece);
        mClothList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                String clothes = ((TextView)view).getText().toString();
                Toast.makeText(ClothesActivity.this, clothes, Toast.LENGTH_LONG).show();
            }
        });
        mClothesTextView.setText("For this search "  + " ' "  + clothType   + " ' " + " we have: ");
<<<<<<< HEAD:app/src/main/java/com/chel/sangwa_sytles/ui/ClothesActivity.java
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
=======
>>>>>>> 0a5cba2586dbc1ae01e53a2d97fafd3f5cd605c1:app/src/main/java/com/chel/sangwa_sytles/ClothesActivity.java
    }


}