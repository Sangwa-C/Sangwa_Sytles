package com.chel.sangwa_sytles.userInterface;

import     androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.chel.sangwa_sytles.R;
import com.chel.sangwa_sytles.models.Business;
import com.chel.sangwa_sytles.models.MallsListAdapter;
import com.chel.sangwa_sytles.models.YelpBusinessesSearchResponse;
import com.chel.sangwa_sytles.networks.YelpApi;
import com.chel.sangwa_sytles.networks.YelpClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MallsActivity extends AppCompatActivity {
    private static final String TAG = MallsActivity.class.getSimpleName();


    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    private MallsListAdapter mMallAdapter;
    public List<Business> clothes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malls);
        ButterKnife.bind(this);

        Intent cheHome = getIntent();
        String mallLocation = cheHome.getStringExtra("mallLocation");
        YelpApi client = YelpClient.getClient();

        Call<YelpBusinessesSearchResponse> call = client.getMalls(mallLocation, "clothes");

        call.enqueue(new Callback<YelpBusinessesSearchResponse>() {

            @Override
            public void onResponse(Call<YelpBusinessesSearchResponse> call, Response<YelpBusinessesSearchResponse> response) {
                hideProgressBar();

                if (response.isSuccessful()) {
                    clothes = response.body().getBusinesses();
                    mMallAdapter = new MallsListAdapter(MallsActivity.this, clothes);
                    mRecyclerView.setAdapter(mMallAdapter);
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
