package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.s */
public final class C0164s {
    private final Runnable el;
    private C0469v em;
    private boolean en;

    /* renamed from: com.google.android.gms.internal.s.1 */
    class C01631 implements Runnable {
        private final WeakReference<C0602r> eo;
        final /* synthetic */ C0602r ep;
        final /* synthetic */ C0164s eq;

        C01631(C0164s c0164s, C0602r c0602r) {
            this.eq = c0164s;
            this.ep = c0602r;
            this.eo = new WeakReference(this.ep);
        }

        public void run() {
            this.eq.en = false;
            C0602r c0602r = (C0602r) this.eo.get();
            if (c0602r != null) {
                c0602r.m2016b(this.eq.em);
            }
        }
    }

    public C0164s(C0602r c0602r) {
        this.en = false;
        this.el = new C01631(this, c0602r);
    }

    public void m695a(C0469v c0469v, long j) {
        if (this.en) {
            cn.m299q("An ad refresh is already scheduled.");
            return;
        }
        cn.m297o("Scheduling ad refresh " + j + " milliseconds from now.");
        this.em = c0469v;
        this.en = true;
        cm.hO.postDelayed(this.el, j);
    }

    public void cancel() {
        cm.hO.removeCallbacks(this.el);
    }

    public void m696d(C0469v c0469v) {
        m695a(c0469v, 60000);
    }
}
