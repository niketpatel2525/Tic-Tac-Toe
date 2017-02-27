package com.google.android.gms.internal;

import android.content.Context;

public final class an {
    private final aw dZ;
    private final bu eI;
    private final Object eJ;
    private final ap eK;
    private boolean eL;
    private as eM;
    private final Context mContext;

    /* renamed from: com.google.android.gms.internal.an.1 */
    class C00851 implements Runnable {
        final /* synthetic */ at eN;
        final /* synthetic */ an eO;

        C00851(an anVar, at atVar) {
            this.eO = anVar;
            this.eN = atVar;
        }

        public void run() {
            try {
                this.eN.fn.destroy();
            } catch (Throwable e) {
                cn.m293b("Could not destroy mediation adapter.", e);
            }
        }
    }

    public an(Context context, bu buVar, aw awVar, ap apVar) {
        this.eJ = new Object();
        this.eL = false;
        this.mContext = context;
        this.eI = buVar;
        this.dZ = awVar;
        this.eK = apVar;
    }

    public at m178a(long j, long j2) {
        cn.m295m("Starting mediation.");
        for (ao aoVar : this.eK.eU) {
            cn.m297o("Trying mediation network: " + aoVar.eP);
            for (String str : aoVar.eQ) {
                synchronized (this.eJ) {
                    if (this.eL) {
                        at atVar = new at(-1);
                        return atVar;
                    }
                    this.eM = new as(this.mContext, str, this.dZ, this.eK, aoVar, this.eI.gB, this.eI.ed);
                    atVar = this.eM.m1156b(j, j2);
                    if (atVar.fl == 0) {
                        cn.m295m("Adapter succeeded.");
                        return atVar;
                    } else if (atVar.fn != null) {
                        cm.hO.post(new C00851(this, atVar));
                    }
                }
            }
        }
        return new at(1);
    }

    public void cancel() {
        synchronized (this.eJ) {
            this.eL = true;
            if (this.eM != null) {
                this.eM.cancel();
            }
        }
    }
}
