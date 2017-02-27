package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public final class bw implements SafeParcelable {
    public static final bx CREATOR;
    public final List<String> eW;
    public final List<String> eX;
    public final int errorCode;
    public final String fW;
    public final long fa;
    public final String gG;
    public final long gH;
    public final boolean gI;
    public final long gJ;
    public final List<String> gK;
    public final int orientation;
    public final int versionCode;

    static {
        CREATOR = new bx();
    }

    public bw(int i) {
        this(1, null, null, null, i, null, -1, false, -1, null, -1, -1);
    }

    bw(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3) {
        this.versionCode = i;
        this.fW = str;
        this.gG = str2;
        this.eW = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.eX = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.gH = j;
        this.gI = z;
        this.gJ = j2;
        this.gK = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.fa = j3;
        this.orientation = i3;
    }

    public bw(String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i) {
        this(1, str, str2, list, -2, list2, j, z, j2, list3, j3, i);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        bx.m229a(this, out, flags);
    }
}
