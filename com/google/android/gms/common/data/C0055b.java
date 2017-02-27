package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.dl;
import com.google.android.gms.internal.dm;

/* renamed from: com.google.android.gms.common.data.b */
public abstract class C0055b {
    protected final C0345d jf;
    protected final int ji;
    private final int jj;

    public C0055b(C0345d c0345d, int i) {
        this.jf = (C0345d) dm.m392e(c0345d);
        boolean z = i >= 0 && i < c0345d.getCount();
        dm.m393k(z);
        this.ji = i;
        this.jj = c0345d.m1102q(this.ji);
    }

    protected void m40a(String str, CharArrayBuffer charArrayBuffer) {
        this.jf.m1094a(str, this.ji, this.jj, charArrayBuffer);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0055b)) {
            return false;
        }
        C0055b c0055b = (C0055b) obj;
        return dl.equal(Integer.valueOf(c0055b.ji), Integer.valueOf(this.ji)) && dl.equal(Integer.valueOf(c0055b.jj), Integer.valueOf(this.jj)) && c0055b.jf == this.jf;
    }

    protected boolean getBoolean(String column) {
        return this.jf.m1098d(column, this.ji, this.jj);
    }

    protected byte[] getByteArray(String column) {
        return this.jf.m1099e(column, this.ji, this.jj);
    }

    protected int getInteger(String column) {
        return this.jf.m1095b(column, this.ji, this.jj);
    }

    protected long getLong(String column) {
        return this.jf.m1093a(column, this.ji, this.jj);
    }

    protected String getString(String column) {
        return this.jf.m1097c(column, this.ji, this.jj);
    }

    public int hashCode() {
        return dl.hashCode(Integer.valueOf(this.ji), Integer.valueOf(this.jj), this.jf);
    }

    public boolean isDataValid() {
        return !this.jf.isClosed();
    }

    protected Uri m41u(String str) {
        return this.jf.m1100f(str, this.ji, this.jj);
    }

    protected boolean m42v(String str) {
        return this.jf.m1101g(str, this.ji, this.jj);
    }
}
