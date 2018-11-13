package com.alihn.gituser.listing;


import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.alihn.gituser.BaseApplication;
import com.alihn.gituser.Constants;
import com.alihn.gituser.R;
import com.alihn.gituser.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class UserListingFragment extends Fragment implements UserListingView {
    @Inject
    UserListingPresenter usersPresenter;

    @Nullable
    @BindView(R.id.users_listing)
    RecyclerView usersListing;

    @Nullable
    private RecyclerView.Adapter adapter;
    @Nullable
    private List<User> items = new ArrayList<>(10);
    @Nullable
    private Callback callback;
    private Unbinder unbinder;

    public UserListingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (Callback) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        ((BaseApplication) getActivity().getApplication()).createListingComponent().inject(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_users, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        initLayoutReferences();
        usersListing.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
                    usersPresenter.nextPage();
                }
            }
        });
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        usersPresenter.setView(this);
        if (savedInstanceState != null) {
            items = savedInstanceState.getParcelableArrayList(Constants.USER);
            adapter.notifyDataSetChanged();
            usersListing.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    private void initLayoutReferences() {
        usersListing.setHasFixedSize(true);

        int columns;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            columns = 2;
        } else {
            columns = getResources().getInteger(R.integer.no_of_columns);
        }
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), columns);

        usersListing.setLayoutManager(layoutManager);
        adapter = new UserListingAdapter(items, this);
        usersListing.setAdapter(adapter);
    }

    @Override
    public void showUsers(@NonNull List<User> users) {
        this.items.clear();
        this.items.addAll(users);
        usersListing.setVisibility(View.VISIBLE);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loadingStarted() {
        Snackbar.make(usersListing, R.string.loading_users, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void loadingFailed(@NonNull String errorMessage) {
        Snackbar.make(usersListing, errorMessage, Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void onUserClicked(User user) {
        callback.onUserClicked(user);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        usersPresenter.destroy();
        unbinder.unbind();
    }

    @Override
    public void onDetach() {
        callback = null;
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((BaseApplication) getActivity().getApplication()).releaseListingComponent();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(Constants.USER, (ArrayList<? extends Parcelable>) items);
    }


    public interface Callback {
        void onUserClicked(User user);
    }


}
