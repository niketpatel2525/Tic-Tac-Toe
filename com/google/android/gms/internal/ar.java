package com.google.android.gms.internal;

import com.google.android.gms.internal.at.C0087a;
import com.google.android.gms.internal.ay.C0384a;

public final class ar extends C0384a {
    private final Object eJ;
    private C0087a fb;
    private aq fc;

    public ar() {
        this.eJ = new Object();
    }

    public void m1781a(aq aqVar) {
        synchronized (this.eJ) {
            this.fc = aqVar;
        }
    }

    public void m1782a(C0087a c0087a) {
        synchronized (this.eJ) {
            this.fb = c0087a;
        }
    }

    public void onAdClosed() {
        synchronized (this.eJ) {
            if (this.fc != null) {
                this.fc.m180E();
            }
        }
    }

    public void onAdFailedToLoad(int error) {
        synchronized (this.eJ) {
            if (this.fb != null) {
                this.fb.m184d(error == 3 ? 1 : 2);
                this.fb = null;
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.eJ) {
            if (this.fc != null) {
                this.fc.m181F();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.eJ) {
            if (this.fb != null) {
                this.fb.m184d(0);
                this.fb = null;
                return;
            }
            if (this.fc != null) {
                this.fc.m183H();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.eJ) {
            if (this.fc != null) {
                this.fc.m182G();
            }
        }
    }

    public void m1783y() {
        synchronized (this.eJ) {
            if (this.fc != null) {
                this.fc.m179D();
            }
        }
    }
}
