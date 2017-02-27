package com.google.android.gms.internal;

public abstract class cg {
    private final Runnable el;
    private volatile Thread hD;

    /* renamed from: com.google.android.gms.internal.cg.1 */
    class C01151 implements Runnable {
        final /* synthetic */ cg hE;

        C01151(cg cgVar) {
            this.hE = cgVar;
        }

        public final void run() {
            this.hE.hD = Thread.currentThread();
            this.hE.ac();
        }
    }

    public cg() {
        this.el = new C01151(this);
    }

    public abstract void ac();

    public final void cancel() {
        onStop();
        if (this.hD != null) {
            this.hD.interrupt();
        }
    }

    public abstract void onStop();

    public final void start() {
        ch.execute(this.el);
    }
}
