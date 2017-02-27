package com.google.android.gms.plus;

import android.app.PendingIntent;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.android.gms.internal.dm;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.fj.C0455a;
import com.google.android.gms.internal.fm;

public final class PlusOneButtonWithPopup extends ViewGroup {
    private String hN;
    private String it;
    private int mSize;
    private View re;
    private int rf;
    private OnClickListener rk;

    public PlusOneButtonWithPopup(Context context) {
        this(context, null);
    }

    public PlusOneButtonWithPopup(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSize = PlusOneButton.getSize(context, attrs);
        this.rf = PlusOneButton.getAnnotation(context, attrs);
        this.re = new PlusOneDummyView(context, this.mSize);
        addView(this.re);
    }

    private int m773c(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        switch (mode) {
            case ExploreByTouchHelper.INVALID_ID /*-2147483648*/:
            case 1073741824:
                return MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i) - i2, mode);
            default:
                return i;
        }
    }

    private void cS() {
        if (this.re != null) {
            removeView(this.re);
        }
        this.re = fm.m610a(getContext(), this.mSize, this.rf, this.hN, this.it);
        if (this.rk != null) {
            setOnClickListener(this.rk);
        }
        addView(this.re);
    }

    private fj cT() throws RemoteException {
        fj ap = C0455a.ap((IBinder) this.re.getTag());
        if (ap != null) {
            return ap;
        }
        if (Log.isLoggable("PlusOneButtonWithPopup", 5)) {
            Log.w("PlusOneButtonWithPopup", "Failed to get PlusOneDelegate");
        }
        throw new RemoteException();
    }

    public void cancelClick() {
        if (this.re != null) {
            try {
                cT().cancelClick();
            } catch (RemoteException e) {
            }
        }
    }

    public PendingIntent getResolution() {
        if (this.re != null) {
            try {
                return cT().getResolution();
            } catch (RemoteException e) {
            }
        }
        return null;
    }

    public void initialize(String url, String accountName) {
        dm.m388a((Object) url, (Object) "Url must not be null");
        this.hN = url;
        this.it = accountName;
        cS();
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.re.layout(getPaddingLeft(), getPaddingTop(), (right - left) - getPaddingRight(), (bottom - top) - getPaddingBottom());
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        this.re.measure(m773c(widthMeasureSpec, paddingLeft), m773c(heightMeasureSpec, paddingTop));
        setMeasuredDimension(paddingLeft + this.re.getMeasuredWidth(), paddingTop + this.re.getMeasuredHeight());
    }

    public void reinitialize() {
        if (this.re != null) {
            try {
                cT().reinitialize();
            } catch (RemoteException e) {
            }
        }
    }

    public void setAnnotation(int annotation) {
        this.rf = annotation;
        cS();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.rk = onClickListener;
        this.re.setOnClickListener(onClickListener);
    }

    public void setSize(int size) {
        this.mSize = size;
        cS();
    }
}
