package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.g */
public class C0634g extends C0588f {

    /* renamed from: com.google.android.gms.internal.g.a */
    class C0150a {
        private String dt;
        private boolean du;
        final /* synthetic */ C0634g dv;

        public C0150a(C0634g c0634g, String str, boolean z) {
            this.dv = c0634g;
            this.dt = str;
            this.du = z;
        }

        public String getId() {
            return this.dt;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.du;
        }
    }

    private C0634g(Context context, C0154j c0154j, C0155k c0155k) {
        super(context, c0154j, c0155k);
    }

    public static C0634g m2122a(String str, Context context) {
        C0154j c0363a = new C0363a();
        C0588f.m1902a(str, context, c0363a);
        return new C0634g(context, c0363a, new C0463m(239));
    }

    protected void m2123b(Context context) {
        long j = 1;
        super.m1910b(context);
        try {
            C0150a f = m2124f(context);
            try {
                if (!f.isLimitAdTrackingEnabled()) {
                    j = 0;
                }
                m1300a(28, j);
                String id = f.getId();
                if (id != null) {
                    m1301a(30, id);
                }
            } catch (IOException e) {
            }
        } catch (GooglePlayServicesNotAvailableException e2) {
        } catch (IOException e3) {
            m1300a(28, 1);
        }
    }

    C0150a m2124f(Context context) throws IOException, GooglePlayServicesNotAvailableException {
        int i = 0;
        try {
            String str;
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            String id = advertisingIdInfo.getId();
            if (id == null || !id.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")) {
                str = id;
            } else {
                byte[] bArr = new byte[16];
                int i2 = 0;
                while (i < id.length()) {
                    if (i == 8 || i == 13 || i == 18 || i == 23) {
                        i++;
                    }
                    bArr[i2] = (byte) ((Character.digit(id.charAt(i), 16) << 4) + Character.digit(id.charAt(i + 1), 16));
                    i2++;
                    i += 2;
                }
                str = this.di.m667a(bArr, true);
            }
            return new C0150a(this, str, advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }
}
