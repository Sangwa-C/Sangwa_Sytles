package com.chel.sangwa_sytles.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chel.sangwa_sytles.MallAdapters.MallsListAdapter;
import com.chel.sangwa_sytles.R;
import com.chel.sangwa_sytles.YelpBusinessesSearchResponse;
import com.chel.sangwa_sytles.models.Business;
import com.chel.sangwa_sytles.network.YelpApi;
import com.chel.sangwa_sytles.network.YelpClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MallsActivity extends AppCompatActivity {
    private static final String TAG = MallsActivity.class.getSimpleName();

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.listView) ListView mListView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    private MallsListAdapter mAdapter;

    public List<Business> malls;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malls);
        ButterKnife.bind(this);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String clothes = ((TextView)view).getText().toString();
                Toast.makeText(MallsActivity.this, clothes, Toast.LENGTH_LONG).show();
            }
        });

        Intent cheHome = getIntent();

        String mallLocation = cheHome.getStringExtra("kigali");
        Toast.makeText(this, "" +mallLocation, Toast.LENGTH_SHORT).show();

        YelpApi client = YelpClient.getClient();

        Call<YelpBusinessesSearchResponse> call = client.getMalls(mallLocation, "clothes");

        call.enqueue(new Callback<YelpBusinessesSearchResponse>() {

            @Override
            public void onResponse(Call<YelpBusinessesSearchResponse> call, Response<YelpBusinessesSearchResponse> response) {
                Toast.makeText(MallsActivity.this, ""+ call, Toast.LENGTH_SHORT).show();
                hideProgressBar();

                if (response.isSuccessful()) {
                    malls = response.body().getBusinesses();
                    mAdapter = new MallsListAdapter(MallsActivity.this, malls);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(MallsActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);


                    showRestaurants();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<YelpBusinessesSearchResponse> call, Throwable t) {

            }
        });
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showRestaurants() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}
