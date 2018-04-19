package me.yun.music.executor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import me.yun.music.R;
import me.yun.music.activity.UserInfoActivity;
import me.yun.music.application.AppCache;
import me.yun.music.utils.FormatUtil;
import me.yun.music.utils.binding.Bind;
import me.yun.music.utils.binding.ViewBinder;

public class UserExecutor {
    private static final String TAG = "UserExecutor";
    private final Context mContext;
    @Bind(R.id.ll_user)
    private LinearLayout llUser;
    @Bind(R.id.iv_user)
    private ImageView ivUser;
    @Bind(R.id.tv_name)
    private TextView tvName;
    @Bind(R.id.tv_level)
    private TextView tvLevel;

    public UserExecutor(Activity activity, DrawerLayout drawer, Toolbar toolbar, View view) {
        mContext = activity.getApplicationContext();
        ViewBinder.bind(this, view);
        ivUser.setOnClickListener(v -> {
            mContext.startActivity(new Intent(mContext, UserInfoActivity.class));
            drawer.closeDrawers();
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(activity, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                execute();
            }
        };
        drawer.addDrawerListener(toggle);
    }

    public void execute() {
        int size = AppCache.get().getLocalMusicList().size();
        int level = 0;
        if (size >= 2000) {
            level = 6;
        } else if (size >= 1000) {
            level = 5;
        } else if (size >= 500) {
            level = 4;
        } else if (size >= 100) {
            level = 3;
        } else if (size >= 10) {
            level = 2;
        } else if (size >= 1) {
            level = 1;
        } else {
            level = 0;
        }
        tvLevel.setText(FormatUtil.userLevel(level));
    }
}
