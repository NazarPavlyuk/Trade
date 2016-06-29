package com.mybringback.thebasics.trade;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Query;

/**
 * Created by ALLO on 25.06.2016.
 */
public class Headline implements YahooService {

        String headline;

        int value;

        @Override
        public String toString() {
            return headline /*+ " (" + value + ")"*/;
        }

        @Override
        public Call<List<Headline>> symbolHeadlines(@Query("s") String headline) {
                return null;
        }
}
