package org.ortynskyi.hobbyfun.views;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public abstract class EndlessOnScrollListener extends RecyclerView.OnScrollListener {

    // The minimum amount of items to have below your current scroll position before loading more.
    private static final int VISIBLE_THRESHOLD = 4;
    private static final int SINGLE_PAGE = 2;

    // True if we are still waiting for the last set of data to load.
    private boolean loading = true;
    private boolean lastPage = false;
    // The total number of items in the data set after the last load
    private int previousTotal = 0;
    private int currentPage = 1;
    private int customCurrentPage = -1;

    private final LinearLayoutManager linearLayoutManager;

    public EndlessOnScrollListener(LinearLayoutManager linearLayoutManager) {
        this.linearLayoutManager = linearLayoutManager;
    }

    public EndlessOnScrollListener(LinearLayoutManager linearLayoutManager, int currentPage) {
        this.linearLayoutManager = linearLayoutManager;
        this.customCurrentPage = currentPage;
        this.currentPage = currentPage;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int visibleItemCount = recyclerView.getChildCount();
        int totalItemCount = linearLayoutManager.getItemCount();
        int firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
        lastPage = true;
        if (loading && totalItemCount > previousTotal) {
            loading = false;
            lastPage = false;
            previousTotal = totalItemCount;
        }
        if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + VISIBLE_THRESHOLD)) {
            currentPage++;
            onLoadMore(currentPage);
            loading = true;
            lastPage = false;
        }
        if (currentPage == SINGLE_PAGE && loading && !lastPage) {
            lastPage = true;
        }
    }

    public void resetPage() {
        this.loading = true;
        this.lastPage = false;
        this.previousTotal = 0;
        this.currentPage = customCurrentPage != -1 ? customCurrentPage : 1;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public abstract void onLoadMore(int currentPage);
}