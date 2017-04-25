package com.jzhu.io.toastlibrary;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

/**
 * Created by zhujian on 2017/4/17.
 */

public class FreeToast {

    public static Toast toastLong(Context context,
                                  CharSequence message) {
        return create(context, message, Toast.LENGTH_LONG, null, 0, 0, 0, 0, null, 0);
    }

    ;

    public static Toast toastShort(Context context,
                                   CharSequence message) {
        return create(context, message, Toast.LENGTH_SHORT, null, 0, 0, 0, 0, null, 0);
    }

    ;

    public static Toast toastWithIcon(Context context,
                                      CharSequence message,
                                      int duration,
                                      Drawable icon,
                                      int DrawableDirection
    ) {
        return create(context, message, duration, icon, DrawableDirection, 0, 0, 0, null, 0);
    }

    ;

    public static Toast toastWithOutIcon(Context context,
                                         CharSequence message,
                                         int duration,
                                         int textSize,
                                         int textColor,
                                         int tintColor,
                                         Typeface typeface) {
        return create(context, message, duration, null, 0, textSize, textColor, tintColor, typeface, 0);
    }

    ;

    public static Toast toastAllAttr(Context context,
                                     CharSequence message,
                                     int duration,
                                     Drawable icon,
                                     int drawableDirection,
                                     int textSize,
                                     int textColor,
                                     int tintColor,
                                     Typeface typeface, int animationsId) {
        return create(context, message, duration, icon, drawableDirection, textSize, textColor, tintColor, typeface, animationsId);
    }

    ;

    public static Toast create(Context context,
                               CharSequence message,
                               int duration,
                               Drawable icon,
                               int drawableDirection,
                               int textSize,
                               int textColor,
                               int tintColor,
                               Typeface typeface, int animationsId) {

        final Toast toast = new Toast(context);
        final View toastLayout = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.free_toast_simple_layout, null);
        final TextView toastTextView = (TextView) toastLayout.findViewById(R.id.toast_text);
        Drawable drawableFrame;

        if (0 != tintColor) {
            drawableFrame = FreeToastUtils.tint9PatchDrawableFrame(context, tintColor);
        }
        else {
            drawableFrame = FreeToastUtils.getDrawable(context, R.drawable.toast_frame);
        }
        FreeToastUtils.setBackground(toastLayout, drawableFrame);

        if (null != icon) {
            icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
            FreeToastUtils.bindDrawable(toastTextView, icon, drawableDirection);
        }

        if (!TextUtils.isEmpty(message)) {
            toastTextView.setText(message);
        }

        if (0 != textColor) {
            toastTextView.setTextColor(textColor);
        }

        if (0 != textSize) {
            toastTextView.setTextSize(textSize);
        }

        if (null != typeface) {
            toastTextView.setTypeface(typeface);
        }

        toast.setView(toastLayout);
        toast.setDuration(duration);

        if (0 != animationsId) {
            initAnimation(toast, animationsId);
        }

        return toast;
    }

    public static void initAnimation(Toast toast, int animationsId) {
        try {

            Object mTN;
            mTN = getField(toast, "mTN");
            if (mTN != null) {
                Object mParams = getField(mTN, "mParams");
                if (mParams != null
                    && mParams instanceof WindowManager.LayoutParams) {
                    WindowManager.LayoutParams params = (WindowManager.LayoutParams) mParams;
                    params.windowAnimations = animationsId;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射字段
     *
     * @param object    要反射的对象
     * @param fieldName 要反射的字段名称
     */
    private static Object getField(Object object, String fieldName)
            throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        if (field != null) {
            field.setAccessible(true);
            return field.get(object);
        }
        return null;
    }

}
