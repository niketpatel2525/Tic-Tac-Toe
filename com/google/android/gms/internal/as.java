package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.dynamic.C0566c;
import com.google.android.gms.internal.at.C0087a;

public final class as implements C0087a {
    private final aw dZ;
    private final Object eJ;
    private final C0469v em;
    private final String fd;
    private final long fe;
    private final ao ff;
    private final C0470x fg;
    private ax fh;
    private int fi;
    private final Context mContext;

    /* renamed from: com.google.android.gms.internal.as.1 */
    class C00861 implements Runnable {
        final /* synthetic */ ar fj;
        final /* synthetic */ as fk;

        C00861(as asVar, ar arVar) {
            this.fk = asVar;
            this.fj = arVar;
        }

        public void run() {
            synchronized (this.fk.eJ) {
                if (this.fk.fi != -2) {
                    return;
                }
                this.fk.fh = this.fk.m1146P();
                if (this.fk.fh == null) {
                    this.fk.m1157d(4);
                    return;
                }
                this.fj.m1782a(this.fk);
                this.fk.m1150a(this.fj);
            }
        }
    }

    public as(Context context, String str, aw awVar, ap apVar, ao aoVar, C0469v c0469v, C0470x c0470x) {
        this.eJ = new Object();
        this.fi = -2;
        this.mContext = context;
        this.fd = str;
        this.dZ = awVar;
        this.fe = apVar.eV != -1 ? apVar.eV : 10000;
        this.ff = aoVar;
        this.em = c0469v;
        this.fg = c0470x;
    }

    private ax m1146P() {
        cn.m297o("Instantiating mediation adapter: " + this.fd);
        try {
            return this.dZ.m187g(this.fd);
        } catch (Throwable e) {
            cn.m292a("Could not instantiate mediation adapter: " + this.fd, e);
            return null;
        }
    }

    private void m1149a(long j, long j2, long j3, long j4) {
        while (this.fi == -2) {
            m1153b(j, j2, j3, j4);
        }
    }

    private void m1150a(ar arVar) {
        try {
            if (this.fg.ex) {
                this.fh.m188a(C0566c.m1773g(this.mContext), this.em, this.ff.eS, arVar);
            } else {
                this.fh.m189a(C0566c.m1773g(this.mContext), this.fg, this.em, this.ff.eS, arVar);
            }
        } catch (Throwable e) {
            cn.m293b("Could not request ad from mediation adapter.", e);
            m1157d(5);
        }
    }

    private void m1153b(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        elapsedRealtime = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || elapsedRealtime <= 0) {
            cn.m297o("Timed out waiting for adapter.");
            this.fi = 3;
            return;
        }
        try {
            this.eJ.wait(Math.min(j5, elapsedRealtime));
        } catch (InterruptedException e) {
            this.fi = -1;
        }
    }

    public at m1156b(long j, long j2) {
        at atVar;
        synchronized (this.eJ) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ar arVar = new ar();
            cm.hO.post(new C00861(this, arVar));
            m1149a(elapsedRealtime, this.fe, j, j2);
            atVar = new at(this.ff, this.fh, this.fd, arVar, this.fi);
        }
        return atVar;
    }

    public void cancel() {
        synchronized (this.eJ) {
            try {
                if (this.fh != null) {
                    this.fh.destroy();
                }
            } catch (Throwable e) {
                cn.m293b("Could not destroy mediation adapter.", e);
            }
            this.fi = -1;
            this.eJ.notify();
        }
    }

    public void m1157d(int i) {
        synchronized (this.eJ) {
            this.fi = i;
            this.eJ.notify();
        }
    }
}
