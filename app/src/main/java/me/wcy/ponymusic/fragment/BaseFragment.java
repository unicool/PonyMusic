package me.wcy.ponymusic.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;
import me.wcy.ponymusic.activity.MusicActivity;
import me.wcy.ponymusic.service.PlayService;

/**
 * 基类
 * Created by wcy on 2015/11/26.
 */
public abstract class BaseFragment extends Fragment {
    private PlayService mPlayService;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        init();
        setListener();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mPlayService = ((MusicActivity) activity).getPlayService();
    }

    protected PlayService getPlayService() {
        return mPlayService;
    }

    protected abstract void init();

    protected abstract void setListener();
}