package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.de.C0579d;
import com.google.android.gms.internal.gh.C0460a;
import com.google.android.gms.internal.gi.C0462a;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.WalletConstants;

public class gj extends de<gh> {
    private final Activity fD;
    private final String it;
    private final int mTheme;
    private final int us;

    /* renamed from: com.google.android.gms.internal.gj.a */
    final class C0601a extends C0462a {
        private final int ky;
        final /* synthetic */ gj ut;

        public C0601a(gj gjVar, int i) {
            this.ut = gjVar;
            this.ky = i;
        }

        public void m1985a(int i, FullWallet fullWallet, Bundle bundle) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.ut.fD, this.ky);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            int i2;
            Intent intent;
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent = new Intent();
                intent.putExtra(WalletConstants.EXTRA_FULL_WALLET, fullWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent = new Intent();
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            try {
                this.ut.fD.createPendingResult(this.ky, intent, 1073741824).send(i2);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        public void m1986a(int i, MaskedWallet maskedWallet, Bundle bundle) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.ut.fD, this.ky);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            int i2;
            Intent intent;
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent = new Intent();
                intent.putExtra(WalletConstants.EXTRA_MASKED_WALLET, maskedWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent = new Intent();
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            try {
                this.ut.fD.createPendingResult(this.ky, intent, 1073741824).send(i2);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        public void m1987a(int i, boolean z, Bundle bundle) {
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_USER_PREAUTHORIZED, z);
            try {
                this.ut.fD.createPendingResult(this.ky, intent, 1073741824).send(-1);
            } catch (Throwable e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }
    }

    public gj(Activity activity, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i, String str, int i2) {
        super(activity, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.fD = activity;
        this.us = i;
        this.it = str;
        this.mTheme = i2;
    }

    private Bundle eb() {
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", this.us);
        bundle.putString("androidPackageName", this.fD.getPackageName());
        if (!TextUtils.isEmpty(this.it)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(this.it, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", this.mTheme);
        return bundle;
    }

    protected void m1989a(dj djVar, C0579d c0579d) throws RemoteException {
        djVar.m370a(c0579d, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    protected String ag() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    protected String ah() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    protected gh au(IBinder iBinder) {
        return C0460a.as(iBinder);
    }

    public void changeMaskedWallet(String googleTransactionId, String merchantTransactionId, int requestCode) {
        Bundle eb = eb();
        Object c0601a = new C0601a(this, requestCode);
        try {
            ((gh) bd()).m645a(googleTransactionId, merchantTransactionId, eb, c0601a);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", e);
            c0601a.m1986a(8, null, null);
        }
    }

    public void checkForPreAuthorization(int requestCode) {
        Bundle eb = eb();
        gi c0601a = new C0601a(this, requestCode);
        try {
            ((gh) bd()).m641a(eb, c0601a);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", e);
            c0601a.m1987a(8, false, null);
        }
    }

    public void loadFullWallet(FullWalletRequest request, int requestCode) {
        gi c0601a = new C0601a(this, requestCode);
        try {
            ((gh) bd()).m642a(request, eb(), c0601a);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", e);
            c0601a.m1985a(8, null, null);
        }
    }

    public void loadMaskedWallet(MaskedWalletRequest request, int requestCode) {
        Bundle eb = eb();
        gi c0601a = new C0601a(this, requestCode);
        try {
            ((gh) bd()).m643a(request, eb, c0601a);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", e);
            c0601a.m1986a(8, null, null);
        }
    }

    public void notifyTransactionStatus(NotifyTransactionStatusRequest request) {
        try {
            ((gh) bd()).m644a(request, eb());
        } catch (RemoteException e) {
        }
    }

    protected /* synthetic */ IInterface m1990p(IBinder iBinder) {
        return au(iBinder);
    }
}
