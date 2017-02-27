package com.google.android.gms.appstate;

import com.google.android.gms.common.data.C0055b;
import com.google.android.gms.common.data.C0345d;

/* renamed from: com.google.android.gms.appstate.b */
public final class C0565b extends C0055b implements AppState {
    C0565b(C0345d c0345d, int i) {
        super(c0345d, i);
    }

    public AppState aE() {
        return new C0564a(this);
    }

    public boolean equals(Object obj) {
        return C0564a.m1770a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return aE();
    }

    public byte[] getConflictData() {
        return getByteArray("conflict_data");
    }

    public String getConflictVersion() {
        return getString("conflict_version");
    }

    public int getKey() {
        return getInteger("key");
    }

    public byte[] getLocalData() {
        return getByteArray("local_data");
    }

    public String getLocalVersion() {
        return getString("local_version");
    }

    public boolean hasConflict() {
        return !m42v("conflict_version");
    }

    public int hashCode() {
        return C0564a.m1769a(this);
    }

    public String toString() {
        return C0564a.m1771b(this);
    }
}
