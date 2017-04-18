package com.jzhu.io.toastlibrary;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

public class FreeToastUtils {

    public final static int DRAWABLE_TOP = 1;

    public final static int DRAWABLE_LEFT = 2;

    public final static int DRAWABLE_BOTTOM = 3;

    public final static int DRAWABLE_RIGHT = 4;

    private FreeToastUtils() {
    }

    static Drawable tint9PatchDrawableFrame(Context context, int tintColor) {
        final NinePatchDrawable toastDrawable = (NinePatchDrawable) getDrawable(context, R.drawable.toast_frame);
        toastDrawable.setColorFilter(new PorterDuffColorFilter(tintColor, PorterDuff.Mode.SRC_IN));
        return toastDrawable;
    }

    static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            view.setBackground(drawable);
        else
            view.setBackgroundDrawable(drawable);
    }

    static Drawable getDrawable(Context context, int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            return context.getDrawable(id);
        else
            return context.getResources().getDrawable(id);
    }

    static void bindDrawable(TextView view, Drawable icon, int direction) {
        switch (direction) {
            case FreeToastUtils.DRAWABLE_TOP:
                view.setCompoundDrawables(null, icon, null, null);
                break;
            case FreeToastUtils.DRAWABLE_LEFT:
                view.setCompoundDrawables(icon, null, null, null);
                break;
            case FreeToastUtils.DRAWABLE_BOTTOM:
                view.setCompoundDrawables(null, null, null, icon);
                break;
            case FreeToastUtils.DRAWABLE_RIGHT:
                view.setCompoundDrawables(null, null, icon, null);
                break;
        }
    }
}
