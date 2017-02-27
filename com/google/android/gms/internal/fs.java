package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.internal.dw.C0421a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import com.sxnyodot.uefqvmio207964.C0304k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class fs extends dw implements SafeParcelable, Moment {
    public static final ft CREATOR;
    private static final HashMap<String, C0421a<?, ?>> rH;
    private final int iM;
    private final Set<Integer> rI;
    private String sD;
    private fq sG;
    private fq sH;
    private String sm;
    private String sx;

    static {
        CREATOR = new ft();
        rH = new HashMap();
        rH.put(C0304k.ID, C0421a.m1284g(C0304k.ID, 2));
        rH.put("result", C0421a.m1278a("result", 4, fq.class));
        rH.put("startDate", C0421a.m1284g("startDate", 5));
        rH.put("target", C0421a.m1278a("target", 6, fq.class));
        rH.put(C0304k.MEDIA_FILE_TYPE, C0421a.m1284g(C0304k.MEDIA_FILE_TYPE, 7));
    }

    public fs() {
        this.iM = 1;
        this.rI = new HashSet();
    }

    fs(Set<Integer> set, int i, String str, fq fqVar, String str2, fq fqVar2, String str3) {
        this.rI = set;
        this.iM = i;
        this.sm = str;
        this.sG = fqVar;
        this.sx = str2;
        this.sH = fqVar2;
        this.sD = str3;
    }

    public fs(Set<Integer> set, String str, fq fqVar, String str2, fq fqVar2, String str3) {
        this.rI = set;
        this.iM = 1;
        this.sm = str;
        this.sG = fqVar;
        this.sx = str2;
        this.sH = fqVar2;
        this.sD = str3;
    }

    protected Object m1940D(String str) {
        return null;
    }

    protected boolean m1941E(String str) {
        return false;
    }

    protected boolean m1942a(C0421a c0421a) {
        return this.rI.contains(Integer.valueOf(c0421a.bw()));
    }

    protected Object m1943b(C0421a c0421a) {
        switch (c0421a.bw()) {
            case DetectedActivity.ON_FOOT /*2*/:
                return this.sm;
            case DetectedActivity.UNKNOWN /*4*/:
                return this.sG;
            case DetectedActivity.TILTING /*5*/:
                return this.sx;
            case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                return this.sH;
            case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                return this.sD;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c0421a.bw());
        }
    }

    public HashMap<String, C0421a<?, ?>> bp() {
        return rH;
    }

    fq dA() {
        return this.sH;
    }

    public fs dB() {
        return this;
    }

    public int describeContents() {
        ft ftVar = CREATOR;
        return 0;
    }

    Set<Integer> di() {
        return this.rI;
    }

    fq dz() {
        return this.sG;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof fs)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        fs fsVar = (fs) obj;
        for (C0421a c0421a : rH.values()) {
            if (m1942a(c0421a)) {
                if (!fsVar.m1942a(c0421a)) {
                    return false;
                }
                if (!m1943b(c0421a).equals(fsVar.m1943b(c0421a))) {
                    return false;
                }
            } else if (fsVar.m1942a(c0421a)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return dB();
    }

    public String getId() {
        return this.sm;
    }

    public ItemScope getResult() {
        return this.sG;
    }

    public String getStartDate() {
        return this.sx;
    }

    public ItemScope getTarget() {
        return this.sH;
    }

    public String getType() {
        return this.sD;
    }

    int getVersionCode() {
        return this.iM;
    }

    public boolean hasId() {
        return this.rI.contains(Integer.valueOf(2));
    }

    public boolean hasResult() {
        return this.rI.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate() {
        return this.rI.contains(Integer.valueOf(5));
    }

    public boolean hasTarget() {
        return this.rI.contains(Integer.valueOf(6));
    }

    public boolean hasType() {
        return this.rI.contains(Integer.valueOf(7));
    }

    public int hashCode() {
        int i = 0;
        for (C0421a c0421a : rH.values()) {
            int hashCode;
            if (m1942a(c0421a)) {
                hashCode = m1943b(c0421a).hashCode() + (i + c0421a.bw());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel out, int flags) {
        ft ftVar = CREATOR;
        ft.m619a(this, out, flags);
    }
}
