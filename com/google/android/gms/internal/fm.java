package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0566c;
import com.google.android.gms.internal.fi.C0453a;
import com.google.android.gms.plus.PlusOneDummyView;

public final class fm {
    private static Context pW;
    private static fi rx;

    /* renamed from: com.google.android.gms.internal.fm.a */
    public static class C0148a extends Exception {
        public C0148a(String str) {
            super(str);
        }
    }

    public static View m609a(Context context, int i, int i2, String str, int i3) {
        if (str != null) {
            return (View) C0566c.m1772b(m611x(context).m595a(C0566c.m1773g(context), i, i2, str, i3));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }

    public static View m610a(Context context, int i, int i2, String str, String str2) {
        if (str != null) {
            return (View) C0566c.m1772b(m611x(context).m596a(C0566c.m1773g(context), i, i2, str, str2));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }

    private static fi m611x(Context context) throws C0148a {
        dm.m392e(context);
        if (rx == null) {
            if (pW == null) {
                pW = GooglePlayServicesUtil.getRemoteContext(context);
                if (pW == null) {
                    throw new C0148a("Could not get remote context.");
                }
            }
            try {
                rx = C0453a.ao((IBinder) pW.getClassLoader().loadClass("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl").newInstance());
            } catch (ClassNotFoundException e) {
                throw new C0148a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C0148a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C0148a("Could not access creator.");
            }
        }
        return rx;
    }
}
