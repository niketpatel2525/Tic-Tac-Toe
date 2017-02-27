package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.C0468u;
import com.google.android.gms.internal.C0469v;
import com.google.android.gms.internal.C0470x;
import com.google.android.gms.internal.C0603t;
import com.google.android.gms.internal.C0604z;
import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.cn;

public final class InterstitialAd {
    private final av dS;
    private AdListener dT;
    private ac dU;
    private String dV;
    private C0051a dW;
    private final Context mContext;

    public InterstitialAd(Context context) {
        this.dS = new av();
        this.mContext = context;
    }

    private void m12c(String str) throws RemoteException {
        if (this.dV == null) {
            m13d(str);
        }
        this.dU = C0468u.m1522a(this.mContext, new C0470x(), this.dV, this.dS);
        if (this.dT != null) {
            this.dU.m169a(new C0603t(this.dT));
        }
        if (this.dW != null) {
            this.dU.m170a(new C0604z(this.dW));
        }
    }

    private void m13d(String str) {
        if (this.dU == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }

    public AdListener getAdListener() {
        return this.dT;
    }

    public String getAdUnitId() {
        return this.dV;
    }

    public boolean isLoaded() {
        boolean z = false;
        try {
            if (this.dU != null) {
                z = this.dU.isReady();
            }
        } catch (Throwable e) {
            cn.m293b("Failed to check if ad is ready.", e);
        }
        return z;
    }

    public void loadAd(AdRequest adRequest) {
        try {
            if (this.dU == null) {
                m12c("loadAd");
            }
            if (this.dU.m171a(new C0469v(this.mContext, adRequest))) {
                this.dS.m1785c(adRequest.m7v());
            }
        } catch (Throwable e) {
            cn.m293b("Failed to load ad.", e);
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

    public void setAdUnitId(String adUnitId) {
        if (this.dV != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.dV = adUnitId;
    }

    public void show() {
        try {
            m13d("show");
            this.dU.showInterstitial();
        } catch (Throwable e) {
            cn.m293b("Failed to show interstitial.", e);
        }
    }
}
