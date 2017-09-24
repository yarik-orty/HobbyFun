package org.ortynskyi.hobbyfun.base;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import org.ortynskyi.hobbyfun.base.mvp.BaseView;
import org.ortynskyi.hobbyfun.network.rx.RetrofitException;

public class BaseFragment extends Fragment implements BaseView {

    @Override
    public void showProgress(final boolean visible) {
        // no-op
    }

    @Override
    public void networkError() {
        getBaseActivity().networkError();
    }

    @Override
    public void httpError(@NonNull final RetrofitException e) {
        // no-op
    }

    @Override
    public void showToast(@NonNull final String message) {
        getBaseActivity().showToast(message);
    }

    @Override
    public void showToast(final int resId) {
        getBaseActivity().showToast(resId);
    }

    @NonNull
    public BaseActivity getBaseActivity() {
        if (getActivity() instanceof BaseActivity) {
            return (BaseActivity) getActivity();
        } else {
            throw new IllegalStateException("BaseFragment's parent should be BaseActivity");
        }
    }
}
