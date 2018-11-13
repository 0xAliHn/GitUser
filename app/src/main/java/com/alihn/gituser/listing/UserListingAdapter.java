package com.alihn.gituser.listing;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alihn.gituser.GlideApp;
import com.alihn.gituser.R;
import com.alihn.gituser.User;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserListingAdapter extends RecyclerView.Adapter<UserListingAdapter.ViewHolder> {
    private List<User> users;
    private Context context;
    private UserListingView view;

    public UserListingAdapter(List<User> users, UserListingView usersView) {
        this.users = users;
        view = usersView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View rootView = LayoutInflater.from(context).inflate(R.layout.user_grid_item, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(holder);
        Log.e("TAG", "Size= " + users.size());
        Log.e("TAG", users.get(position).getLogin());
        holder.user = users.get(position);
        holder.name.setText(holder.user.getLogin());

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .priority(Priority.HIGH);

        GlideApp.with(context)
                .asBitmap()
                .load(holder.user.getAvatarUrl())
                .apply(options)
                .into(new BitmapImageViewTarget(holder.avater) {
                    @Override
                    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
                        super.onResourceReady(bitmap, transition);
                        Palette.from(bitmap).generate(palette -> setBackgroundColor(palette, holder));
                    }
                });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    private void setBackgroundColor(Palette palette, ViewHolder holder) {
        holder.titleBackground.setBackgroundColor(palette.getVibrantColor(context
                .getResources().getColor(R.color.black_translucent_60)));
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public User user;
        @Nullable
        @BindView(R.id.user_avatar)
        ImageView avater;
        @Nullable
        @BindView(R.id.title_background)
        View titleBackground;
        @Nullable
        @BindView(R.id.user_name)
        TextView name;

        public ViewHolder(@NonNull View root) {
            super(root);
            ButterKnife.bind(this, root);
        }

        @Override
        public void onClick(View view) {
            UserListingAdapter.this.view.onUserClicked(user);
        }
    }
}
