package org.ortynskyi.hobbyfun.base;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.ortynskyi.hobbyfun.HobbyFunApplication;
import org.ortynskyi.hobbyfun.R;
import org.ortynskyi.hobbyfun.base.mvp.BaseView;
import org.ortynskyi.hobbyfun.network.RetrofitException;
import org.ortynskyi.hobbyfun.utils.NetworkUtils;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity implements BaseView {


    @Override
    public void showProgress(final boolean visible) {
        // no-op
    }

    @Override
    public void networkError() {
        final boolean isNetworkConnected = NetworkUtils.isNetworkConnected(this);
        showToast(isNetworkConnected ? R.string.error_server_unavailable : R.string.error_internet_connection);
    }

    @Override
    public void httpError(@NonNull final RetrofitException e) {
        // no-op
    }

    @Override
    public void showToast(@NonNull final String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToast(final int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }


    @NonNull
    public HobbyFunApplication getApp() {
        return (HobbyFunApplication) getApplication();
    }

    public void setToolbarTitle(@NonNull final String title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    public void setToolbarTitle(final int title) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    public void replaceFragment(final Fragment fragment, final boolean addToBackStack) {
        final String fragmentName = fragment.getClass().getName();
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final boolean fragmentPopped = fragmentManager.popBackStackImmediate(fragmentName, 0);
        if (!fragmentPopped && fragmentManager.findFragmentByTag(fragmentName) == null) {
            FragmentTransaction transaction = fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment, fragmentName);
            if (addToBackStack) {
                transaction.addToBackStack(fragmentName);
            }
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            transaction.commit();
        }
    }
}
