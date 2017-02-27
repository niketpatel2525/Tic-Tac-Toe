package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.bs.C0575a;
import com.google.android.gms.internal.bs.C0576b;

public final class br {

    /* renamed from: com.google.android.gms.internal.br.a */
    public interface C0111a {
        void m222a(bw bwVar);
    }

    public static cg m223a(Context context, bu buVar, C0111a c0111a) {
        return buVar.eg.hS ? m224b(context, buVar, c0111a) : m225c(context, buVar, c0111a);
    }

    private static cg m224b(Context context, bu buVar, C0111a c0111a) {
        cn.m295m("Fetching ad response from local ad request service.");
        cg c0575a = new C0575a(context, buVar, c0111a);
        c0575a.start();
        return c0575a;
    }

    private static cg m225c(Context context, bu buVar, C0111a c0111a) {
        cn.m295m("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            return new C0576b(context, buVar, c0111a);
        }
        cn.m299q("Failed to connect to remote ad request service.");
        return null;
    }
}
