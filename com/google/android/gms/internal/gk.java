package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

public class gk {
    private final byte[] uu;
    private int uv;
    private int uw;

    public gk(byte[] bArr) {
        int i;
        this.uu = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
        for (i = 0; i < AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY; i++) {
            this.uu[i] = (byte) i;
        }
        i = 0;
        for (int i2 = 0; i2 < AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY; i2++) {
            i = ((i + this.uu[i2]) + bArr[i2 % bArr.length]) & MotionEventCompat.ACTION_MASK;
            byte b = this.uu[i2];
            this.uu[i2] = this.uu[i];
            this.uu[i] = b;
        }
        this.uv = 0;
        this.uw = 0;
    }

    public void m649f(byte[] bArr) {
        int i = this.uv;
        int i2 = this.uw;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & MotionEventCompat.ACTION_MASK;
            i2 = (i2 + this.uu[i]) & MotionEventCompat.ACTION_MASK;
            byte b = this.uu[i];
            this.uu[i] = this.uu[i2];
            this.uu[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.uu[(this.uu[i] + this.uu[i2]) & MotionEventCompat.ACTION_MASK]);
        }
        this.uv = i;
        this.uw = i2;
    }
}
