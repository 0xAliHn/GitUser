package com.alihn.gituser.details;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.alihn.gituser.Constants;
import com.alihn.gituser.R;
import com.alihn.gituser.User;

public class UserDetailsActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        if (savedInstanceState == null)
        {
            Bundle extras = getIntent().getExtras();
            if (extras != null && extras.containsKey(Constants.USER))
            {
                User user = extras.getParcelable(Constants.USER);
                if (user != null)
                {
                    UserDetailsFragment userDetailsFragment = UserDetailsFragment.getInstance(user);
                    getSupportFragmentManager().beginTransaction().add(R.id.user_details_container, userDetailsFragment).commit();
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}
