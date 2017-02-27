package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0071b.C0354a;
import com.google.android.gms.dynamic.C0566c;

public final class bh implements SafeParcelable {
    public static final bg CREATOR;
    public final co eg;
    public final be fR;
    public final C0161q fS;
    public final bi fT;
    public final cq fU;
    public final ag fV;
    public final String fW;
    public final boolean fX;
    public final String fY;
    public final bl fZ;
    public final String fz;
    public final int ga;
    public final int orientation;
    public final int versionCode;

    static {
        CREATOR = new bg();
    }

    bh(int i, be beVar, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, co coVar) {
        this.versionCode = i;
        this.fR = beVar;
        this.fS = (C0161q) C0566c.m1772b(C0354a.m1114z(iBinder));
        this.fT = (bi) C0566c.m1772b(C0354a.m1114z(iBinder2));
        this.fU = (cq) C0566c.m1772b(C0354a.m1114z(iBinder3));
        this.fV = (ag) C0566c.m1772b(C0354a.m1114z(iBinder4));
        this.fW = str;
        this.fX = z;
        this.fY = str2;
        this.fZ = (bl) C0566c.m1772b(C0354a.m1114z(iBinder5));
        this.orientation = i2;
        this.ga = i3;
        this.fz = str3;
        this.eg = coVar;
    }

    public bh(be beVar, C0161q c0161q, bi biVar, bl blVar, co coVar) {
        this.versionCode = 1;
        this.fR = beVar;
        this.fS = c0161q;
        this.fT = biVar;
        this.fU = null;
        this.fV = null;
        this.fW = null;
        this.fX = false;
        this.fY = null;
        this.fZ = blVar;
        this.orientation = -1;
        this.ga = 4;
        this.fz = null;
        this.eg = coVar;
    }

    public bh(C0161q c0161q, bi biVar, ag agVar, bl blVar, cq cqVar, boolean z, int i, String str, co coVar) {
        this.versionCode = 1;
        this.fR = null;
        this.fS = c0161q;
        this.fT = biVar;
        this.fU = cqVar;
        this.fV = agVar;
        this.fW = null;
        this.fX = z;
        this.fY = null;
        this.fZ = blVar;
        this.orientation = i;
        this.ga = 3;
        this.fz = str;
        this.eg = coVar;
    }

    public bh(C0161q c0161q, bi biVar, ag agVar, bl blVar, cq cqVar, boolean z, int i, String str, String str2, co coVar) {
        this.versionCode = 1;
        this.fR = null;
        this.fS = c0161q;
        this.fT = biVar;
        this.fU = cqVar;
        this.fV = agVar;
        this.fW = str2;
        this.fX = z;
        this.fY = str;
        this.fZ = blVar;
        this.orientation = i;
        this.ga = 3;
        this.fz = null;
        this.eg = coVar;
    }

    public bh(C0161q c0161q, bi biVar, bl blVar, cq cqVar, int i, co coVar) {
        this.versionCode = 1;
        this.fR = null;
        this.fS = c0161q;
        this.fT = biVar;
        this.fU = cqVar;
        this.fV = null;
        this.fW = null;
        this.fX = false;
        this.fY = null;
        this.fZ = blVar;
        this.orientation = i;
        this.ga = 1;
        this.fz = null;
        this.eg = coVar;
    }

    public bh(C0161q c0161q, bi biVar, bl blVar, cq cqVar, boolean z, int i, co coVar) {
        this.versionCode = 1;
        this.fR = null;
        this.fS = c0161q;
        this.fT = biVar;
        this.fU = cqVar;
        this.fV = null;
        this.fW = null;
        this.fX = z;
        this.fY = null;
        this.fZ = blVar;
        this.orientation = i;
        this.ga = 2;
        this.fz = null;
        this.eg = coVar;
    }

    public static bh m1179a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(bh.class.getClassLoader());
            return (bh) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public static void m1180a(Intent intent, bh bhVar) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bhVar);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    IBinder m1181U() {
        return C0566c.m1773g(this.fS).asBinder();
    }

    IBinder m1182V() {
        return C0566c.m1773g(this.fT).asBinder();
    }

    IBinder m1183W() {
        return C0566c.m1773g(this.fU).asBinder();
    }

    IBinder m1184X() {
        return C0566c.m1773g(this.fV).asBinder();
    }

    IBinder m1185Y() {
        return C0566c.m1773g(this.fZ).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        bg.m203a(this, out, flags);
    }
}
