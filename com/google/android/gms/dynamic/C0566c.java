package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.C0071b.C0354a;
import java.lang.reflect.Field;

/* renamed from: com.google.android.gms.dynamic.c */
public final class C0566c<T> extends C0354a {
    private final T mh;

    private C0566c(T t) {
        this.mh = t;
    }

    public static <T> T m1772b(C0071b c0071b) {
        if (c0071b instanceof C0566c) {
            return ((C0566c) c0071b).mh;
        }
        IBinder asBinder = c0071b.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e22);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }

    public static <T> C0071b m1773g(T t) {
        return new C0566c(t);
    }
}
