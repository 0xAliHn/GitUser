package com.alihn.gituser.listing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.alihn.gituser.Constants;
import com.alihn.gituser.R;
import com.alihn.gituser.User;
import com.alihn.gituser.details.UserDetailsActivity;

public class UserListingActivity extends AppCompatActivity implements UserListingFragment.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.git_user);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public void onUserClicked(User user) {
        startUserDetailsActivity(user);
    }

    private void startUserDetailsActivity(User user) {
        Intent intent = new Intent(this, UserDetailsActivity.class);
        Bundle extras = new Bundle();
        extras.putParcelable(Constants.USER, user);
        intent.putExtras(extras);
        startActivity(intent);
    }

}
