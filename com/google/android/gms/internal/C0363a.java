package com.google.android.gms.internal;

import android.util.Base64;

/* renamed from: com.google.android.gms.internal.a */
class C0363a implements C0154j {
    C0363a() {
    }

    public String m1120a(byte[] bArr, boolean z) {
        return Base64.encodeToString(bArr, z ? 11 : 2);
    }

    public byte[] m1121a(String str, boolean z) throws IllegalArgumentException {
        return Base64.decode(str, z ? 11 : 2);
    }
}
