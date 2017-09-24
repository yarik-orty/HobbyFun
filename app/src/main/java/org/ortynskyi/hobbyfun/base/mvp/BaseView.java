package org.ortynskyi.hobbyfun.base.mvp;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import org.ortynskyi.hobbyfun.network.rx.RetrofitException;

public interface BaseView {

    /**
     * This is base method used to show/hide progress during some background task
     * */
    void showProgress(final boolean visible);

    /**
     * This is base method used to notify user about some network error
     * */
    void networkError();

    /**
     * This is base method used to notify user about some http request error
     * */
    void httpError(@NonNull final RetrofitException e);

    /**
     * This is base method used to show Toast message to user
     * */
    void showToast(@NonNull final String message);

    /**
     * Overload for {@link #showToast(String)}
     * @see #showToast(String)
     * */
    void showToast(@StringRes final int resId);
}
