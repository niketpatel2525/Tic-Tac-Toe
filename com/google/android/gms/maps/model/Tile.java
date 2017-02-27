package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0186r;

public final class Tile implements SafeParcelable {
    public static final TileCreator CREATOR;
    public final byte[] data;
    public final int height;
    private final int iM;
    public final int width;

    static {
        CREATOR = new TileCreator();
    }

    Tile(int versionCode, int width, int height, byte[] data) {
        this.iM = versionCode;
        this.width = width;
        this.height = height;
        this.data = data;
    }

    public Tile(int width, int height, byte[] data) {
        this(1, width, height, data);
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.iM;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0186r.cK()) {
            C0195i.m753a(this, out, flags);
        } else {
            TileCreator.m742a(this, out, flags);
        }
    }
}
