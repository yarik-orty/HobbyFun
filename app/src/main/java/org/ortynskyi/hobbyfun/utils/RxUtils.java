package org.ortynskyi.hobbyfun.utils;

import android.support.annotation.NonNull;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public final class RxUtils {

    private RxUtils() {}

    /**
     * Utility method used to compose default async schedulers
     * */
    public static <T> Observable.Transformer<T, T> composeSchedulers() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> T stream(@NonNull final Observable<T> observable) {
        return observable.toBlocking().first();
    }
}