package com.mybringback.thebasics.trade;

import android.content.Intent;
import android.net.Uri;
import android.renderscript.Long4;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button button,signOut;
    TextView textView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        signOut = (Button) findViewById(R.id.signOut);
        mAuth = Login.Singleton.instance();
        final TextView textView = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://www.quandl.com/api/v3/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                DataService service = retrofit.create(DataService.class);
                final Call<Main> call =
                        service.rowsOrder("10","desc");

                call.enqueue(new Callback <Main>() {
                    @Override
                    public void onResponse(Call <Main> call, Response<Main> response) {
                        Log.e("onResponse", String.valueOf(response.raw()));
                        textView.setText(response.body().getDataset().toString());
                    }

                    @Override
                    public void onFailure(Call<Main> call, Throwable t) {
                        Log.e("onFail", t.getMessage());
                        textView.setText("Something went wrong: " + t.getMessage());
                    }
                });
            }
        });

        signOut.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(MainActivity.this, Login.class));
                }
            });
        }
    }





