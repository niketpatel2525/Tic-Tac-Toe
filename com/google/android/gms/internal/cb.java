package com.google.android.gms.internal;

import com.google.android.gms.plus.PlusShare;
import com.sxnyodot.uefqvmio207964.C0304k;
import java.util.Map;

public final class cb {
    private final Object eJ;
    private cq fG;
    private String gT;
    public final ai gU;
    public final ai gV;
    private int gw;

    /* renamed from: com.google.android.gms.internal.cb.1 */
    class C04041 implements ai {
        final /* synthetic */ cb gW;

        C04041(cb cbVar) {
            this.gW = cbVar;
        }

        public void m1208a(cq cqVar, Map<String, String> map) {
            synchronized (this.gW.eJ) {
                String str = (String) map.get("errors");
                cn.m299q("Invalid " + ((String) map.get(C0304k.MEDIA_FILE_TYPE)) + " request error: " + str);
                this.gW.gw = 1;
                this.gW.eJ.notify();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.cb.2 */
    class C04052 implements ai {
        final /* synthetic */ cb gW;

        C04052(cb cbVar) {
            this.gW = cbVar;
        }

        public void m1209a(cq cqVar, Map<String, String> map) {
            synchronized (this.gW.eJ) {
                String str = (String) map.get(PlusShare.KEY_CALL_TO_ACTION_URL);
                if (str == null) {
                    cn.m299q("URL missing in loadAdUrl GMSG.");
                    return;
                }
                this.gW.gT = str;
                this.gW.eJ.notify();
            }
        }
    }

    public cb() {
        this.eJ = new Object();
        this.gw = -2;
        this.gU = new C04041(this);
        this.gV = new C04052(this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String aj() {
        /*
        r3 = this;
        r1 = r3.eJ;
        monitor-enter(r1);
    L_0x0003:
        r0 = r3.gT;	 Catch:{ all -> 0x001f }
        if (r0 != 0) goto L_0x001b;
    L_0x0007:
        r0 = r3.gw;	 Catch:{ all -> 0x001f }
        r2 = -2;
        if (r0 != r2) goto L_0x001b;
    L_0x000c:
        r0 = r3.eJ;	 Catch:{ InterruptedException -> 0x0012 }
        r0.wait();	 Catch:{ InterruptedException -> 0x0012 }
        goto L_0x0003;
    L_0x0012:
        r0 = move-exception;
        r0 = "Ad request service was interrupted.";
        com.google.android.gms.internal.cn.m299q(r0);	 Catch:{ all -> 0x001f }
        r0 = 0;
        monitor-exit(r1);	 Catch:{ all -> 0x001f }
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = r3.gT;	 Catch:{ all -> 0x001f }
        monitor-exit(r1);	 Catch:{ all -> 0x001f }
        goto L_0x001a;
    L_0x001f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001f }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cb.aj():java.lang.String");
    }

    public void m241b(cq cqVar) {
        synchronized (this.eJ) {
            this.fG = cqVar;
        }
    }

    public int getErrorCode() {
        int i;
        synchronized (this.eJ) {
            i = this.gw;
        }
        return i;
    }
}
