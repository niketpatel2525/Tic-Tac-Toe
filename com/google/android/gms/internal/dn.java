package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.C0074e;
import com.google.android.gms.dynamic.C0074e.C0073a;
import com.google.android.gms.dynamic.C0566c;
import com.google.android.gms.internal.dk.C0419a;

public final class dn extends C0074e<dk> {
    private static final dn ll;

    static {
        ll = new dn();
    }

    private dn() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View m1268d(Context context, int i, int i2) throws C0073a {
        return ll.m1269e(context, i, i2);
    }

    private View m1269e(Context context, int i, int i2) throws C0073a {
        try {
            return (View) C0566c.m1772b(((dk) m145t(context)).m385a(C0566c.m1773g(context), i, i2));
        } catch (Throwable e) {
            throw new C0073a("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    public /* synthetic */ Object m1270d(IBinder iBinder) {
        return m1271y(iBinder);
    }

    public dk m1271y(IBinder iBinder) {
        return C0419a.m1267x(iBinder);
    }
}
