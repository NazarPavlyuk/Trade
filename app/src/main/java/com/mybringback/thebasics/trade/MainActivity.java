package com.mybringback.thebasics.trade;

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

public class MainActivity extends AppCompatActivity {

    Button button,signOut;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        signOut = (Button) findViewById(R.id.signOut);
        final TextView textView = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YahooService service = YahooService.retrofit.create(YahooService.class);
                final Call<List<Headline>> call =
                        service.symbolHeadlines("huh");

                call.enqueue(new Callback<List<Headline>>() {
                    @Override
                    public void onResponse(Call<List<Headline>> call, Response<List<Headline>> response) {
                        Log.e("onResponse", String.valueOf(response.raw()));
                    }

                    @Override
                    public void onFailure(Call<List<Headline>> call, Throwable t) {
                        textView.setText("Something went wrong: " + t.getMessage());
                    }
                });
            }
        });

        signOut.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                FirebaseAuth out = new FirebaseAuth() {
                    }
                };
            }
        });
    }
}




