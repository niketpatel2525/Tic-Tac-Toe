package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.C0071b;
import com.google.android.gms.dynamic.C0566c;
import com.google.android.gms.internal.C0468u;
import com.google.android.gms.internal.C0469v;
import com.google.android.gms.internal.C0470x;
import com.google.android.gms.internal.C0603t;
import com.google.android.gms.internal.C0604z;
import com.google.android.gms.internal.aa;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.cm;
import com.google.android.gms.internal.cn;

public final class AdView extends ViewGroup {
    private AdSize f11c;
    private final av dS;
    private AdListener dT;
    private ac dU;
    private String dV;
    private C0051a dW;

    public AdView(Context context) {
        super(context);
        this.dS = new av();
    }

    public AdView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AdView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.dS = new av();
        try {
            aa aaVar = new aa(context, attrs);
            this.f11c = aaVar.getAdSize();
            this.dV = aaVar.getAdUnitId();
            if (isInEditMode()) {
                cm.m289b(this, new C0470x(context, this.f11c), "Ads by Google");
            }
        } catch (IllegalArgumentException e) {
            cm.m287a(this, new C0470x(context, AdSize.BANNER), e.getMessage());
        }
    }

    private void m9c(String str) throws RemoteException {
        if (this.f11c == null || this.dV == null) {
            m10d(str);
        }
        Context context = getContext();
        this.dU = C0468u.m1522a(context, new C0470x(context, this.f11c), this.dV, this.dS);
        if (this.dT != null) {
            this.dU.m169a(new C0603t(this.dT));
        }
        if (this.dW != null) {
            this.dU.m170a(new C0604z(this.dW));
        }
        m11x();
    }

    private void m10d(String str) {
        if (this.dU == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set on AdView before " + str + " is called.");
        }
    }

    private void m11x() {
        try {
            C0071b z = this.dU.m172z();
            if (z != null) {
                addView((View) C0566c.m1772b(z));
            }
        } catch (Throwable e) {
            cn.m293b("Failed to get an ad frame.", e);
        }
    }

    public void destroy() {
        try {
            if (this.dU != null) {
                this.dU.destroy();
            }
        } catch (Throwable e) {
            cn.m293b("Failed to destroy AdView.", e);
        }
    }

    public AdListener getAdListener() {
        return this.dT;
    }

    public AdSize getAdSize() {
        return this.f11c;
    }

    public String getAdUnitId() {
        return this.dV;
    }

    public void loadAd(AdRequest adRequest) {
        try {
            if (this.dU == null) {
                m9c("loadAd");
            }
            if (this.dU.m171a(new C0469v(getContext(), adRequest))) {
                this.dS.m1785c(adRequest.m7v());
            }
        } catch (Throwable e) {
            cn.m293b("Failed to load ad.", e);
        }
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i = ((right - left) - measuredWidth) / 2;
            int i2 = ((bottom - top) - measuredHeight) / 2;
            childAt.layout(i, i2, measuredWidth + i, measuredHeight + i2);
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth;
        int i = 0;
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
            measuredWidth = childAt.getMeasuredWidth();
            i = childAt.getMeasuredHeight();
        } else if (this.f11c != null) {
            Context context = getContext();
            measuredWidth = this.f11c.getWidthInPixels(context);
            i = this.f11c.getHeightInPixels(context);
        } else {
            measuredWidth = 0;
        }
        setMeasuredDimension(resolveSize(Math.max(measuredWidth, getSuggestedMinimumWidth()), widthMeasureSpec), resolveSize(Math.max(i, getSuggestedMinimumHeight()), heightMeasureSpec));
    }

    public void pause() {
        try {
            if (this.dU != null) {
                this.dU.pause();
            }
        } catch (Throwable e) {
            cn.m293b("Failed to call pause.", e);
        }
    }

    public void resume() {
        try {
            if (this.dU != null) {
                this.dU.resume();
            }
        } catch (Throwable e) {
            cn.m293b("Failed to call resume.", e);
        }
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.dT = adListener;
            if (this.dU != null) {
                this.dU.m169a(adListener != null ? new C0603t(adListener) : null);
            }
        } catch (Throwable e) {
            cn.m293b("Failed to set the AdListener.", e);
        }
    }

    public void setAdSize(AdSize adSize) {
        if (this.f11c != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        this.f11c = adSize;
        requestLayout();
    }

    public void setAdUnitId(String adUnitId) {
        if (this.dV != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.dV = adUnitId;
    }
}
