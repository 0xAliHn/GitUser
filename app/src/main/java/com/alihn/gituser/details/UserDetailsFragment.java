package com.alihn.gituser.details;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alihn.gituser.BaseApplication;
import com.alihn.gituser.Constants;
import com.alihn.gituser.R;
import com.alihn.gituser.User;
import com.alihn.gituser.UserDetails;
import com.bumptech.glide.Glide;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class UserDetailsFragment extends Fragment implements UserDetailsView {
    @Inject
    UserDetailsPresenter userDetailsPresenter;

    @Nullable
    @BindView(R.id.user_avatar)
    ImageView avatar;
    @Nullable
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Nullable
    @BindView(R.id.user_name)
    TextView name;
    @Nullable
    @BindView(R.id.user_company)
    TextView company;
    @Nullable
    @BindView(R.id.user_location)
    TextView location;


    @Nullable
    @BindView(R.id.user_bio)
    TextView bio;
    @Nullable
    @BindView(R.id.user_followers)
    TextView followers;
    @Nullable
    @BindView(R.id.user_following)
    TextView following;


    @BindView(R.id.toolbar)
    @Nullable
    Toolbar toolbar;

    @Nullable
    private User user;
    private Unbinder unbinder;

    public UserDetailsFragment() {
        // Required empty public constructor
    }

    @NonNull
    public static UserDetailsFragment getInstance(@NonNull User user) {
        Bundle args = new Bundle();
        args.putParcelable(Constants.USER, user);
        UserDetailsFragment userDetailsFragment = new UserDetailsFragment();
        userDetailsFragment.setArguments(args);
        return userDetailsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        ((BaseApplication) getActivity().getApplication()).createDetailsComponent().inject(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_details, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        setToolbar();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            User user = (User) getArguments().get(Constants.USER);
            if (user != null) {
                this.user = user;
                userDetailsPresenter.setView(this);
                userDetailsPresenter.userDetails((user));
            }
        }
    }

    private void setToolbar() {
        collapsingToolbar.setContentScrimColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        collapsingToolbar.setTitle(getString(R.string.user_details));
        collapsingToolbar.setCollapsedTitleTextAppearance(R.style.CollapsedToolbar);
        collapsingToolbar.setExpandedTitleTextAppearance(R.style.ExpandedToolbar);
        collapsingToolbar.setTitleEnabled(true);

        if (toolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

            ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    @Override
    public void showDetails(@NonNull UserDetails userDetails) {
        Glide.with(Objects.requireNonNull(getContext())).load(userDetails.getAvatarUrl()).into(avatar);
        name.setText(userDetails.getLogin());
        company.setText(String.format("%s  %s", getString(R.string.user_company), userDetails.getCompany()));
        location.setText(String.format("%s  %s", getString(R.string.user_location), userDetails.getLocation()));
        bio.setText(String.format("%s  %s", getString(R.string.user_bio), String.valueOf(userDetails.getBio())));
        followers.setText(String.format("%s  %s", getString(R.string.user_followers), String.valueOf(userDetails.getFollowers())));
        following.setText(String.format("%s  %s", getString(R.string.user_following), String.valueOf(userDetails.getFollowing())));

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        userDetailsPresenter.destroy();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((BaseApplication) getActivity().getApplication()).releaseDetailsComponent();
    }
}
