package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.wallet.h */
public class C0220h implements Creator<MaskedWalletRequest> {
    static void m790a(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, maskedWalletRequest.getVersionCode());
        C0067b.m121a(parcel, 2, maskedWalletRequest.tI, false);
        C0067b.m124a(parcel, 3, maskedWalletRequest.ub);
        C0067b.m124a(parcel, 4, maskedWalletRequest.uc);
        C0067b.m124a(parcel, 5, maskedWalletRequest.ud);
        C0067b.m121a(parcel, 6, maskedWalletRequest.ue, false);
        C0067b.m121a(parcel, 7, maskedWalletRequest.tE, false);
        C0067b.m121a(parcel, 8, maskedWalletRequest.uf, false);
        C0067b.m120a(parcel, 9, maskedWalletRequest.tO, i, false);
        C0067b.m124a(parcel, 10, maskedWalletRequest.ug);
        C0067b.m124a(parcel, 11, maskedWalletRequest.uh);
        C0067b.m112C(parcel, k);
    }

    public MaskedWalletRequest m791U(Parcel parcel) {
        Cart cart = null;
        boolean z = false;
        int j = C0066a.m92j(parcel);
        boolean z2 = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        String str4 = null;
        int i = 0;
        while (parcel.dataPosition() < j) {
            int i2 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0066a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str4 = C0066a.m94l(parcel, i2);
                    break;
                case DetectedActivity.STILL /*3*/:
                    z5 = C0066a.m83c(parcel, i2);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    z4 = C0066a.m83c(parcel, i2);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    z3 = C0066a.m83c(parcel, i2);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    str3 = C0066a.m94l(parcel, i2);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    str2 = C0066a.m94l(parcel, i2);
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    str = C0066a.m94l(parcel, i2);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    cart = (Cart) C0066a.m77a(parcel, i2, Cart.CREATOR);
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    z2 = C0066a.m83c(parcel, i2);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    z = C0066a.m83c(parcel, i2);
                    break;
                default:
                    C0066a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new MaskedWalletRequest(i, str4, z5, z4, z3, str3, str2, str, cart, z2, z);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public MaskedWalletRequest[] az(int i) {
        return new MaskedWalletRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m791U(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return az(x0);
    }
}
