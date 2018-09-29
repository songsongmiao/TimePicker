package com.zu.demo;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class ScreenDialog extends Dialog {
    public ScreenDialog(@NonNull Context context) {
        super(context);
    }

    public ScreenDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected ScreenDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }






}
