package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.common.data.c */
public class C0343c<T extends SafeParcelable> extends DataBuffer<T> {
    private static final String[] jk;
    private final Creator<T> jl;

    static {
        jk = new String[]{"data"};
    }

    public C0343c(C0345d c0345d, Creator<T> creator) {
        super(c0345d);
        this.jl = creator;
    }

    public /* synthetic */ Object get(int x0) {
        return m1088p(x0);
    }

    public T m1088p(int i) {
        byte[] e = this.jf.m1099e("data", i, 0);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(e, 0, e.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.jl.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }
}
