package com.google.android.gms.internal;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.e */
public abstract class C0424e implements C0133d {
    protected MotionEvent dg;
    protected DisplayMetrics dh;
    protected C0154j di;
    private C0155k dj;

    protected C0424e(Context context, C0154j c0154j, C0155k c0155k) {
        this.di = c0154j;
        this.dj = c0155k;
        try {
            this.dh = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.dh = new DisplayMetrics();
            this.dh.density = 1.0f;
        }
    }

    private String m1293a(Context context, String str, boolean z) {
        try {
            byte[] c;
            synchronized (this) {
                m1294b();
                if (z) {
                    m1305c(context);
                } else {
                    m1304b(context);
                }
                c = m1295c();
            }
            return c.length == 0 ? Integer.toString(5) : m1298a(c, str);
        } catch (NoSuchAlgorithmException e) {
            return Integer.toString(7);
        } catch (UnsupportedEncodingException e2) {
            return Integer.toString(7);
        } catch (IOException e3) {
            return Integer.toString(3);
        }
    }

    private void m1294b() {
        this.dj.reset();
    }

    private byte[] m1295c() throws IOException {
        return this.dj.m671h();
    }

    public String m1296a(Context context) {
        return m1293a(context, null, false);
    }

    public String m1297a(Context context, String str) {
        return m1293a(context, str, true);
    }

    String m1298a(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        byte[] bArr2;
        if (bArr.length > 239) {
            m1294b();
            m1300a(20, 1);
            bArr = m1295c();
        }
        if (bArr.length < 239) {
            bArr2 = new byte[(239 - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).array();
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(bArr2);
        bArr2 = ByteBuffer.allocate(AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY).put(instance.digest()).put(bArr2).array();
        byte[] bArr3 = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY];
        new C0090b().m192a(bArr2, bArr3);
        if (str != null && str.length() > 0) {
            m1303a(str, bArr3);
        }
        return this.di.m667a(bArr3, true);
    }

    public void m1299a(int i, int i2, int i3) {
        if (this.dg != null) {
            this.dg.recycle();
        }
        this.dg = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.dh.density, ((float) i2) * this.dh.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    protected void m1300a(int i, long j) throws IOException {
        this.dj.m669b(i, j);
    }

    protected void m1301a(int i, String str) throws IOException {
        this.dj.m670b(i, str);
    }

    public void m1302a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.dg != null) {
                this.dg.recycle();
            }
            this.dg = MotionEvent.obtain(motionEvent);
        }
    }

    void m1303a(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new gk(str.getBytes("UTF-8")).m649f(bArr);
    }

    protected abstract void m1304b(Context context);

    protected abstract void m1305c(Context context);
}
