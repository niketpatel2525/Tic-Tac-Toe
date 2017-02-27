package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.internal.de.C0135b;
import com.google.android.gms.internal.de.C0412c;
import com.google.android.gms.internal.de.C0579d;
import com.google.android.gms.internal.fk.C0457a;
import com.google.android.gms.plus.PlusClient.OnAccessRevokedListener;
import com.google.android.gms.plus.PlusClient.OnMomentsLoadedListener;
import com.google.android.gms.plus.PlusClient.OnPeopleLoadedListener;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class fl extends de<fk> implements GooglePlayServicesClient {
    private Person ro;
    private fn rp;

    /* renamed from: com.google.android.gms.internal.fl.f */
    final class C0458f extends C0135b<OnAccessRevokedListener> {
        final /* synthetic */ fl rr;
        private final ConnectionResult rs;

        public C0458f(fl flVar, OnAccessRevokedListener onAccessRevokedListener, ConnectionResult connectionResult) {
            this.rr = flVar;
            super(flVar, onAccessRevokedListener);
            this.rs = connectionResult;
        }

        protected void m1503a(OnAccessRevokedListener onAccessRevokedListener) {
            this.rr.disconnect();
            if (onAccessRevokedListener != null) {
                onAccessRevokedListener.onAccessRevoked(this.rs);
            }
        }

        protected void aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fl.b */
    final class C0590b extends C0412c<OnMomentsLoadedListener> {
        final /* synthetic */ fl rr;
        private final ConnectionResult rs;
        private final String rt;
        private final String ru;

        public C0590b(fl flVar, OnMomentsLoadedListener onMomentsLoadedListener, ConnectionResult connectionResult, C0345d c0345d, String str, String str2) {
            this.rr = flVar;
            super(flVar, onMomentsLoadedListener, c0345d);
            this.rs = connectionResult;
            this.rt = str;
            this.ru = str2;
        }

        protected void m1925a(OnMomentsLoadedListener onMomentsLoadedListener, C0345d c0345d) {
            onMomentsLoadedListener.onMomentsLoaded(this.rs, c0345d != null ? new MomentBuffer(c0345d) : null, this.rt, this.ru);
        }
    }

    /* renamed from: com.google.android.gms.internal.fl.d */
    final class C0591d extends C0412c<OnPeopleLoadedListener> {
        final /* synthetic */ fl rr;
        private final ConnectionResult rs;
        private final String rt;

        public C0591d(fl flVar, OnPeopleLoadedListener onPeopleLoadedListener, ConnectionResult connectionResult, C0345d c0345d, String str) {
            this.rr = flVar;
            super(flVar, onPeopleLoadedListener, c0345d);
            this.rs = connectionResult;
            this.rt = str;
        }

        protected void m1927a(OnPeopleLoadedListener onPeopleLoadedListener, C0345d c0345d) {
            onPeopleLoadedListener.onPeopleLoaded(this.rs, c0345d != null ? new PersonBuffer(c0345d) : null, this.rt);
        }
    }

    /* renamed from: com.google.android.gms.internal.fl.a */
    final class C0631a extends fg {
        private final OnMomentsLoadedListener rq;
        final /* synthetic */ fl rr;

        public C0631a(fl flVar, OnMomentsLoadedListener onMomentsLoadedListener) {
            this.rr = flVar;
            this.rq = onMomentsLoadedListener;
        }

        public void m2119a(C0345d c0345d, String str, String str2) {
            C0345d c0345d2;
            ConnectionResult connectionResult = new ConnectionResult(c0345d.getStatusCode(), c0345d.aM() != null ? (PendingIntent) c0345d.aM().getParcelable("pendingIntent") : null);
            if (connectionResult.isSuccess() || c0345d == null) {
                c0345d2 = c0345d;
            } else {
                if (!c0345d.isClosed()) {
                    c0345d.close();
                }
                c0345d2 = null;
            }
            this.rr.m1243a(new C0590b(this.rr, this.rq, connectionResult, c0345d2, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.internal.fl.c */
    final class C0632c extends fg {
        final /* synthetic */ fl rr;
        private final OnPeopleLoadedListener rv;

        public C0632c(fl flVar, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.rr = flVar;
            this.rv = onPeopleLoadedListener;
        }

        public void m2120a(C0345d c0345d, String str) {
            C0345d c0345d2;
            ConnectionResult connectionResult = new ConnectionResult(c0345d.getStatusCode(), c0345d.aM() != null ? (PendingIntent) c0345d.aM().getParcelable("pendingIntent") : null);
            if (connectionResult.isSuccess() || c0345d == null) {
                c0345d2 = c0345d;
            } else {
                if (!c0345d.isClosed()) {
                    c0345d.close();
                }
                c0345d2 = null;
            }
            this.rr.m1243a(new C0591d(this.rr, this.rv, connectionResult, c0345d2, str));
        }
    }

    /* renamed from: com.google.android.gms.internal.fl.e */
    final class C0633e extends fg {
        final /* synthetic */ fl rr;
        private final OnAccessRevokedListener rw;

        public C0633e(fl flVar, OnAccessRevokedListener onAccessRevokedListener) {
            this.rr = flVar;
            this.rw = onAccessRevokedListener;
        }

        public void m2121b(int i, Bundle bundle) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("pendingIntent");
            }
            this.rr.m1243a(new C0458f(this.rr, this.rw, new ConnectionResult(i, pendingIntent)));
        }
    }

    public fl(Context context, fn fnVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, connectionCallbacks, onConnectionFailedListener, fnVar.cZ());
        this.rp = fnVar;
    }

    public boolean m1929Y(String str) {
        return Arrays.asList(aY()).contains(str);
    }

    protected void m1930a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.ro = fv.m1980e(bundle.getByteArray("loaded_person"));
        }
        super.m1241a(i, iBinder, bundle);
    }

    protected void m1931a(dj djVar, C0579d c0579d) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("client_id", this.rp.df());
        bundle.putStringArray(GoogleAuthUtil.KEY_REQUEST_VISIBLE_ACTIVITIES, this.rp.da());
        djVar.m374a(c0579d, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, this.rp.dd(), this.rp.dc(), aY(), this.rp.getAccountName(), bundle);
    }

    public void m1932a(OnPeopleLoadedListener onPeopleLoadedListener, Collection<String> collection) {
        bc();
        fh c0632c = new C0632c(this, onPeopleLoadedListener);
        try {
            ((fk) bd()).m604a(c0632c, new ArrayList(collection));
        } catch (RemoteException e) {
            c0632c.m2120a(C0345d.m1092r(8), null);
        }
    }

    public void m1933a(OnPeopleLoadedListener onPeopleLoadedListener, String[] strArr) {
        m1932a(onPeopleLoadedListener, Arrays.asList(strArr));
    }

    protected String ag() {
        return "com.google.android.gms.plus.service.START";
    }

    protected String ah() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    protected fk ar(IBinder iBinder) {
        return C0457a.aq(iBinder);
    }

    public void clearDefaultAccount() {
        bc();
        try {
            this.ro = null;
            ((fk) bd()).clearDefaultAccount();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public String getAccountName() {
        bc();
        try {
            return ((fk) bd()).getAccountName();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public Person getCurrentPerson() {
        bc();
        return this.ro;
    }

    public void loadMoments(OnMomentsLoadedListener listener) {
        loadMoments(listener, 20, null, null, null, "me");
    }

    public void loadMoments(OnMomentsLoadedListener listener, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        bc();
        Object c0631a = listener != null ? new C0631a(this, listener) : null;
        try {
            ((fk) bd()).m600a(c0631a, maxResults, pageToken, targetUrl, type, userId);
        } catch (RemoteException e) {
            c0631a.m2119a(C0345d.m1092r(8), null, null);
        }
    }

    public void loadVisiblePeople(OnPeopleLoadedListener listener, int orderBy, String pageToken) {
        bc();
        Object c0632c = new C0632c(this, listener);
        try {
            ((fk) bd()).m599a(c0632c, 1, orderBy, -1, pageToken);
        } catch (RemoteException e) {
            c0632c.m2120a(C0345d.m1092r(8), null);
        }
    }

    public void loadVisiblePeople(OnPeopleLoadedListener listener, String pageToken) {
        loadVisiblePeople(listener, 0, pageToken);
    }

    protected /* synthetic */ IInterface m1934p(IBinder iBinder) {
        return ar(iBinder);
    }

    public void removeMoment(String momentId) {
        bc();
        try {
            ((fk) bd()).removeMoment(momentId);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void revokeAccessAndDisconnect(OnAccessRevokedListener listener) {
        bc();
        clearDefaultAccount();
        Object c0633e = new C0633e(this, listener);
        try {
            ((fk) bd()).m605b(c0633e);
        } catch (RemoteException e) {
            c0633e.m2121b(8, null);
        }
    }

    public void writeMoment(Moment moment) {
        bc();
        try {
            ((fk) bd()).m597a(ec.m1306a((fs) moment));
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
