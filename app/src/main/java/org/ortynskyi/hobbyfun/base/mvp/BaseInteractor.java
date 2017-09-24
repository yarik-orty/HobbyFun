package org.ortynskyi.hobbyfun.base.mvp;

import android.support.annotation.NonNull;

import org.ortynskyi.hobbyfun.network.RestApi;

public interface BaseInteractor {

    @NonNull
    RestApi getRestApi();

    @NonNull
    String getAccessToken();
}
