package com.example.mymovie.Listeners;

import com.example.mymovie.models.SearchApiResponse;

public interface OnSerachApiListener {

    void onResponse(SearchApiResponse response);
    void onError(String message);
}
