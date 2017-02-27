package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.bp.C0106a;
import com.google.android.gms.internal.br.C0111a;
import com.google.android.gms.internal.bu.C0112a;
import com.google.android.gms.internal.cr.C0121a;
import com.google.android.gms.location.DetectedActivity;
import org.json.JSONException;

public final class bq extends cg implements C0111a, C0121a {
    private final aw dZ;
    private final Object eJ;
    private ap eK;
    private final cq fG;
    private final C0106a gm;
    private final C0112a gn;
    private final C0152h go;
    private cg gp;
    private bw gq;
    private boolean gr;
    private an gs;
    private at gt;
    private final Context mContext;

    /* renamed from: com.google.android.gms.internal.bq.1 */
    class C01071 implements Runnable {
        final /* synthetic */ bq gu;

        C01071(bq bqVar) {
            this.gu = bqVar;
        }

        public void run() {
            this.gu.onStop();
        }
    }

    /* renamed from: com.google.android.gms.internal.bq.2 */
    class C01082 implements Runnable {
        final /* synthetic */ bq gu;
        final /* synthetic */ ce gv;

        C01082(bq bqVar, ce ceVar) {
            this.gu = bqVar;
            this.gv = ceVar;
        }

        public void run() {
            synchronized (this.gu.eJ) {
                this.gu.gm.m220a(this.gv);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bq.3 */
    class C01093 implements Runnable {
        final /* synthetic */ bq gu;

        C01093(bq bqVar) {
            this.gu = bqVar;
        }

        public void run() {
            synchronized (this.gu.eJ) {
                if (this.gu.gq.errorCode != -2) {
                    return;
                }
                this.gu.fG.aw().m314a(this.gu);
                if (this.gu.gq.errorCode == -3) {
                    cn.m298p("Loading URL in WebView: " + this.gu.gq.fW);
                    this.gu.fG.loadUrl(this.gu.gq.fW);
                } else {
                    cn.m298p("Loading HTML in WebView.");
                    this.gu.fG.loadDataWithBaseURL(ci.m274j(this.gu.gq.fW), this.gu.gq.gG, "text/html", "UTF-8", null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bq.a */
    private static final class C0110a extends Exception {
        private final int gw;

        public C0110a(String str, int i) {
            super(str);
            this.gw = i;
        }

        public int getErrorCode() {
            return this.gw;
        }
    }

    public bq(Context context, C0112a c0112a, C0152h c0152h, cq cqVar, aw awVar, C0106a c0106a) {
        this.eJ = new Object();
        this.gr = false;
        this.dZ = awVar;
        this.gm = c0106a;
        this.fG = cqVar;
        this.mContext = context;
        this.gn = c0112a;
        this.go = c0152h;
    }

    private void m1195a(bu buVar, long j) throws C0110a {
        this.gs = new an(this.mContext, buVar, this.dZ, this.eK);
        this.gt = this.gs.m178a(j, 60000);
        switch (this.gt.fl) {
            case DetectedActivity.IN_VEHICLE /*0*/:
            case DetectedActivity.ON_BICYCLE /*1*/:
                throw new C0110a("No fill from any mediation ad networks.", 3);
            default:
                throw new C0110a("Unexpected mediation result: " + this.gt.fl, 0);
        }
    }

    private void ad() throws C0110a {
        if (this.gq.errorCode != -3) {
            if (TextUtils.isEmpty(this.gq.gG)) {
                throw new C0110a("No fill from ad server.", 3);
            } else if (this.gq.gI) {
                try {
                    this.eK = new ap(this.gq.gG);
                } catch (JSONException e) {
                    throw new C0110a("Could not parse mediation config: " + this.gq.gG, 0);
                }
            }
        }
    }

    private void m1197b(long j) throws C0110a {
        cm.hO.post(new C01093(this));
        m1201d(j);
    }

    private void m1199c(long j) throws C0110a {
        while (m1202e(j)) {
            if (this.gq != null) {
                this.gp = null;
                if (this.gq.errorCode != -2 && this.gq.errorCode != -3) {
                    throw new C0110a("There was a problem getting an ad response. ErrorCode: " + this.gq.errorCode, this.gq.errorCode);
                }
                return;
            }
        }
        throw new C0110a("Timed out waiting for ad response.", 2);
    }

    private void m1201d(long j) throws C0110a {
        while (m1202e(j)) {
            if (this.gr) {
                return;
            }
        }
        throw new C0110a("Timed out waiting for WebView to finish loading.", 2);
    }

    private boolean m1202e(long j) throws C0110a {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.eJ.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new C0110a("Ad request cancelled.", -1);
        }
    }

    public void m1203a(bw bwVar) {
        synchronized (this.eJ) {
            cn.m295m("Received ad response.");
            this.gq = bwVar;
            this.eJ.notify();
        }
    }

    public void m1204a(cq cqVar) {
        synchronized (this.eJ) {
            cn.m295m("WebView finished loading.");
            this.gr = true;
            this.eJ.notify();
        }
    }

    public void ac() {
        synchronized (this.eJ) {
            cn.m295m("AdLoaderBackgroundTask started.");
            bu buVar = new bu(this.gn, this.go.m666g().m335a(this.mContext));
            int i = -2;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.gp = br.m223a(this.mContext, buVar, this);
                if (this.gp == null) {
                    throw new C0110a("Could not start the ad request service.", 0);
                }
                m1199c(elapsedRealtime);
                ad();
                if (this.gq.gI) {
                    m1195a(buVar, elapsedRealtime);
                } else {
                    m1197b(elapsedRealtime);
                }
                cm.hO.post(new C01082(this, new ce(buVar.gB, this.fG, this.gq.eW, i, this.gq.eX, this.gq.gK, this.gq.orientation, this.gq.fa, buVar.gE, this.gq.gI, this.gt != null ? this.gt.fm : null, this.gt != null ? this.gt.fn : null, this.gt != null ? this.gt.fo : null, this.eK, this.gt != null ? this.gt.fp : null, this.gq.gJ, this.gq.gH)));
            } catch (C0110a e) {
                i = e.getErrorCode();
                if (i == 3 || i == -1) {
                    cn.m297o(e.getMessage());
                } else {
                    cn.m299q(e.getMessage());
                }
                this.gq = new bw(i);
                cm.hO.post(new C01071(this));
            }
        }
    }

    public void onStop() {
        synchronized (this.eJ) {
            if (this.gp != null) {
                this.gp.cancel();
            }
            this.fG.stopLoading();
            ci.m264a(this.fG);
            if (this.gs != null) {
                this.gs.cancel();
            }
        }
    }
}
