package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class bu implements SafeParcelable {
    public static final bv CREATOR;
    public final String adUnitId;
    public final ApplicationInfo applicationInfo;
    public final C0470x ed;
    public final co eg;
    public final Bundle gA;
    public final C0469v gB;
    public final PackageInfo gC;
    public final String gD;
    public final String gE;
    public final String gF;
    public final int versionCode;

    /* renamed from: com.google.android.gms.internal.bu.a */
    public static final class C0112a {
        public final String adUnitId;
        public final ApplicationInfo applicationInfo;
        public final C0470x ed;
        public final co eg;
        public final Bundle gA;
        public final C0469v gB;
        public final PackageInfo gC;
        public final String gE;
        public final String gF;

        public C0112a(Bundle bundle, C0469v c0469v, C0470x c0470x, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, co coVar) {
            this.gA = bundle;
            this.gB = c0469v;
            this.ed = c0470x;
            this.adUnitId = str;
            this.applicationInfo = applicationInfo;
            this.gC = packageInfo;
            this.gE = str2;
            this.gF = str3;
            this.eg = coVar;
        }
    }

    static {
        CREATOR = new bv();
    }

    bu(int i, Bundle bundle, C0469v c0469v, C0470x c0470x, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, co coVar) {
        this.versionCode = i;
        this.gA = bundle;
        this.gB = c0469v;
        this.ed = c0470x;
        this.adUnitId = str;
        this.applicationInfo = applicationInfo;
        this.gC = packageInfo;
        this.gD = str2;
        this.gE = str3;
        this.gF = str4;
        this.eg = coVar;
    }

    public bu(Bundle bundle, C0469v c0469v, C0470x c0470x, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, co coVar) {
        this(1, bundle, c0469v, c0470x, str, applicationInfo, packageInfo, str2, str3, str4, coVar);
    }

    public bu(C0112a c0112a, String str) {
        this(c0112a.gA, c0112a.gB, c0112a.ed, c0112a.adUnitId, c0112a.applicationInfo, c0112a.gC, str, c0112a.gE, c0112a.gF, c0112a.eg);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        bv.m226a(this, out, flags);
    }
}
