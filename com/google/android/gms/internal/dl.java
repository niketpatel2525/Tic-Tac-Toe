package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dl {

    /* renamed from: com.google.android.gms.internal.dl.a */
    public static final class C0140a {
        private final List<String> lj;
        private final Object lk;

        private C0140a(Object obj) {
            this.lk = dm.m392e(obj);
            this.lj = new ArrayList();
        }

        public C0140a m386a(String str, Object obj) {
            this.lj.add(((String) dm.m392e(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.lk.getClass().getSimpleName()).append('{');
            int size = this.lj.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.lj.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static C0140a m387d(Object obj) {
        return new C0140a(null);
    }

    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }
}
