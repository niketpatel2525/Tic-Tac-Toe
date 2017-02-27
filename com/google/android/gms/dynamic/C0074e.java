package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.dm;

/* renamed from: com.google.android.gms.dynamic.e */
public abstract class C0074e<T> {
    private final String mi;
    private T mj;

    /* renamed from: com.google.android.gms.dynamic.e.a */
    public static class C0073a extends Exception {
        public C0073a(String str) {
            super(str);
        }

        public C0073a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected C0074e(String str) {
        this.mi = str;
    }

    protected abstract T m144d(IBinder iBinder);

    protected final T m145t(Context context) throws C0073a {
        if (this.mj == null) {
            dm.m392e(context);
            Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
            if (remoteContext == null) {
                throw new C0073a("Could not get remote context.");
            }
            try {
                this.mj = m144d((IBinder) remoteContext.getClassLoader().loadClass(this.mi).newInstance());
            } catch (ClassNotFoundException e) {
                throw new C0073a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C0073a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C0073a("Could not access creator.");
            }
        }
        return this.mj;
    }
}
