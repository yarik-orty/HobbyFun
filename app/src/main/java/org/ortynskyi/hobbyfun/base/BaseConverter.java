package org.ortynskyi.hobbyfun.base;

import android.support.annotation.NonNull;

public interface BaseConverter<T> {

    @NonNull
    T convert();
}