package com.aston_cdnt17.amovies.Listeners;

import com.aston_cdnt17.amovies.models.SearchApiResponse;

public interface OnSerachApiListener {

    void onResponse(SearchApiResponse response);
    void onError(String message);
}
