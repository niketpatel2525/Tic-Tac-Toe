package com.google.android.gms.internal;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.x */
public final class C0470x implements SafeParcelable {
    public static final C0166y CREATOR;
    public final String ew;
    public final boolean ex;
    public final int height;
    public final int heightPixels;
    public final int versionCode;
    public final int width;
    public final int widthPixels;

    static {
        CREATOR = new C0166y();
    }

    public C0470x() {
        this(1, "interstitial_mb", 0, 0, true, 0, 0);
    }

    C0470x(int i, String str, int i2, int i3, boolean z, int i4, int i5) {
        this.versionCode = i;
        this.ew = str;
        this.height = i2;
        this.heightPixels = i3;
        this.ex = z;
        this.width = i4;
        this.widthPixels = i5;
    }

    public C0470x(Context context, AdSize adSize) {
        int i;
        int i2;
        int i3 = 1;
        this.versionCode = 1;
        this.ex = false;
        this.width = adSize.getWidth();
        this.height = adSize.getHeight();
        if (this.width == -1) {
            int i4 = 1;
        } else {
            boolean z = false;
        }
        if (this.height != -2) {
            i3 = 0;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (i4 != 0) {
            this.widthPixels = C0470x.m1526a(displayMetrics);
            i = (int) (((float) this.widthPixels) / displayMetrics.density);
        } else {
            i2 = this.width;
            this.widthPixels = cm.m286a(displayMetrics, this.width);
            i = i2;
        }
        i2 = i3 != 0 ? C0470x.m1528c(displayMetrics) : this.height;
        this.heightPixels = cm.m286a(displayMetrics, i2);
        if (i4 == 0 && i3 == 0) {
            this.ew = adSize.toString();
        } else {
            this.ew = i + "x" + i2 + "_as";
        }
    }

    public static int m1526a(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int m1527b(DisplayMetrics displayMetrics) {
        return (int) (((float) C0470x.m1528c(displayMetrics)) * displayMetrics.density);
    }

    private static int m1528c(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        return i <= 400 ? 32 : i <= 720 ? 50 : 90;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0166y.m700a(this, out, flags);
    }
}
