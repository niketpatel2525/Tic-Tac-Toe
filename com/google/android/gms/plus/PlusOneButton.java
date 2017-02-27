package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.internal.dm;
import com.google.android.gms.internal.dp;
import com.google.android.gms.internal.fm;

public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    private String hN;
    private int mSize;
    private View re;
    private int rf;
    private int rg;
    private OnPlusOneClickListener rh;

    public interface OnPlusOneClickListener {
        void onPlusOneClick(Intent intent);
    }

    protected class DefaultOnPlusOneClickListener implements OnClickListener, OnPlusOneClickListener {
        private final OnPlusOneClickListener ri;
        final /* synthetic */ PlusOneButton rj;

        public DefaultOnPlusOneClickListener(PlusOneButton plusOneButton, OnPlusOneClickListener proxy) {
            this.rj = plusOneButton;
            this.ri = proxy;
        }

        public void onClick(View view) {
            Intent intent = (Intent) this.rj.re.getTag();
            if (this.ri != null) {
                this.ri.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        public void onPlusOneClick(Intent intent) {
            Context context = this.rj.getContext();
            if ((context instanceof Activity) && intent != null) {
                ((Activity) context).startActivityForResult(intent, this.rj.rg);
            }
        }
    }

    public PlusOneButton(Context context) {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSize = getSize(context, attrs);
        this.rf = getAnnotation(context, attrs);
        this.rg = DEFAULT_ACTIVITY_REQUEST_CODE;
        m772p(getContext());
        if (!isInEditMode()) {
        }
    }

    protected static int getAnnotation(Context context, AttributeSet attrs) {
        String a = dp.m402a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attrs, true, false, "PlusOneButton");
        if ("INLINE".equalsIgnoreCase(a)) {
            return SIZE_TALL;
        }
        return !"NONE".equalsIgnoreCase(a) ? SIZE_MEDIUM : SIZE_SMALL;
    }

    protected static int getSize(Context context, AttributeSet attrs) {
        String a = dp.m402a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attrs, true, false, "PlusOneButton");
        if ("SMALL".equalsIgnoreCase(a)) {
            return SIZE_SMALL;
        }
        if ("MEDIUM".equalsIgnoreCase(a)) {
            return SIZE_MEDIUM;
        }
        return "TALL".equalsIgnoreCase(a) ? SIZE_TALL : SIZE_STANDARD;
    }

    private void m772p(Context context) {
        if (this.re != null) {
            removeView(this.re);
        }
        this.re = fm.m609a(context, this.mSize, this.rf, this.hN, this.rg);
        setOnPlusOneClickListener(this.rh);
        addView(this.re);
    }

    public void initialize(String url, int activityRequestCode) {
        dm.m389a(getContext() instanceof Activity, (Object) "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(PlusClient, String, OnPlusOneClickListener).");
        this.hN = url;
        this.rg = activityRequestCode;
        m772p(getContext());
    }

    public void initialize(String url, OnPlusOneClickListener plusOneClickListener) {
        this.hN = url;
        this.rg = SIZE_SMALL;
        m772p(getContext());
        setOnPlusOneClickListener(plusOneClickListener);
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.re.layout(SIZE_SMALL, SIZE_SMALL, right - left, bottom - top);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View view = this.re;
        measureChild(view, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setAnnotation(int annotation) {
        this.rf = annotation;
        m772p(getContext());
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener listener) {
        this.rh = listener;
        this.re.setOnClickListener(new DefaultOnPlusOneClickListener(this, listener));
    }

    public void setSize(int size) {
        this.mSize = size;
        m772p(getContext());
    }
}
