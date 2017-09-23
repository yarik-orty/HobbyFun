package org.ortynskyi.hobbyfun.network.rx;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.functions.Func1;

public final class RxErrorCallAdapterFactory extends CallAdapter.Factory {

    private final RxJavaCallAdapterFactory original;

    private RxErrorCallAdapterFactory() {
        original = RxJavaCallAdapterFactory.create();
    }

    @NonNull
    public static CallAdapter.Factory create() {
        return new RxErrorCallAdapterFactory();
    }

    @SuppressWarnings("unchecked")
    @Override
    public CallAdapter<?, Observable<?>> get(@NonNull final Type returnType,
                                             @NonNull final Annotation[] annotations,
                                             @NonNull final Retrofit retrofit) {
        return new RxCallAdapterWrapper(retrofit,
                (CallAdapter<?, Observable<?>>) original.get(returnType, annotations, retrofit));
    }

    private static class RxCallAdapterWrapper implements CallAdapter<Observable<?>, Observable<?>> {

        private final CallAdapter<?, Observable<?>> wrapped;
        private final Retrofit retrofit;

        public RxCallAdapterWrapper(final Retrofit retrofit, final CallAdapter<?, Observable<?>> wrapped) {
            this.retrofit = retrofit;
            this.wrapped = wrapped;
        }

        @Override
        public Type responseType() {
            return wrapped.responseType();
        }

        @SuppressWarnings("unchecked")
        @Override
        public Observable<?> adapt(@NonNull final Call call) {
            return wrapped.adapt(call).onErrorResumeNext(new Func1<Throwable, Observable>() {
                @Override
                public Observable call(Throwable throwable) {
                    return Observable.error(asRetrofitException(throwable));

                }
            });
        }

        @NonNull
        private RetrofitException asRetrofitException(Throwable throwable) {
            // We had non-200 http error
            if (throwable instanceof HttpException) {
                HttpException httpException = (HttpException) throwable;
                Response response = httpException.response();
                return RetrofitException.httpError(response.raw().request().url().toString(), response, retrofit);
            }
            // A network error happened
            if (throwable instanceof IOException) {
                return RetrofitException.networkError((IOException) throwable);
            }
            // We don't know what happened. We need to simply convert to an unknown error
            return RetrofitException.unexpectedError(throwable);
        }
    }
}