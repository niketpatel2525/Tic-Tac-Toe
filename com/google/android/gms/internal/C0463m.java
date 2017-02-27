package com.google.android.gms.internal;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.m */
class C0463m implements C0155k {
    private gl dD;
    private byte[] dE;
    private final int dF;

    public C0463m(int i) {
        this.dF = i;
        reset();
    }

    public void m1513b(int i, long j) throws IOException {
        this.dD.m653b(i, j);
    }

    public void m1514b(int i, String str) throws IOException {
        this.dD.m654b(i, str);
    }

    public byte[] m1515h() throws IOException {
        int ec = this.dD.ec();
        if (ec < 0) {
            throw new IOException();
        } else if (ec == 0) {
            return this.dE;
        } else {
            Object obj = new byte[(this.dE.length - ec)];
            System.arraycopy(this.dE, 0, obj, 0, obj.length);
            return obj;
        }
    }

    public void reset() {
        this.dE = new byte[this.dF];
        this.dD = gl.m651g(this.dE);
    }
}
