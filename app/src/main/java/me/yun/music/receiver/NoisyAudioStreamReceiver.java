package me.yun.music.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import me.yun.music.service.AudioPlayer;

/**
 * 来电/耳机拔出时暂停播放
 */
public class NoisyAudioStreamReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        AudioPlayer.get().playPause();
    }
}
