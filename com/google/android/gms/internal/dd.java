package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class dd implements SafeParcelable {
    private static ClassLoader kA;
    private static Integer kB;
    private static final Object kz;
    private boolean kC;

    static {
        kz = new Object();
        kA = null;
        kB = null;
    }

    public dd() {
        this.kC = false;
    }

    private static boolean m1227a(Class<?> cls) {
        boolean z = false;
        try {
            z = SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e2) {
        }
        return z;
    }

    protected static ClassLoader aV() {
        ClassLoader classLoader;
        synchronized (kz) {
            classLoader = kA;
        }
        return classLoader;
    }

    protected static Integer aW() {
        Integer num;
        synchronized (kz) {
            num = kB;
        }
        return num;
    }

    protected static boolean m1228y(String str) {
        ClassLoader aV = aV();
        if (aV == null) {
            return true;
        }
        try {
            return m1227a(aV.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean aX() {
        return this.kC;
    }
}
