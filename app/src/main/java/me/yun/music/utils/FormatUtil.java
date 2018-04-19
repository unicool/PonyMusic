package me.yun.music.utils;

import android.text.Html;
import android.text.Spanned;

import java.util.Locale;

public class FormatUtil {

    public static Spanned userLevel(int level) {
        return Html.fromHtml(String.format(Locale.getDefault(), "VIP\t<strong><font color='%s'><big><big>%d</big></big></font></strong><small> 级</small>", "#ecb241", level));
    }
}
