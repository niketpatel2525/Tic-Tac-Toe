package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.bu.C0112a;

public final class bp {

    /* renamed from: com.google.android.gms.internal.bp.a */
    public interface C0106a {
        void m220a(ce ceVar);
    }

    public static cg m221a(Context context, C0112a c0112a, C0152h c0152h, cq cqVar, aw awVar, C0106a c0106a) {
        cg bqVar = new bq(context, c0112a, c0152h, cqVar, awVar, c0106a);
        bqVar.start();
        return bqVar;
    }
}
