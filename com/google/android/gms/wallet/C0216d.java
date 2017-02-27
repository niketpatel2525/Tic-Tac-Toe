package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.wallet.d */
public class C0216d implements Creator<FullWalletRequest> {
    static void m782a(FullWalletRequest fullWalletRequest, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, fullWalletRequest.getVersionCode());
        C0067b.m121a(parcel, 2, fullWalletRequest.tH, false);
        C0067b.m121a(parcel, 3, fullWalletRequest.tI, false);
        C0067b.m120a(parcel, 4, fullWalletRequest.tO, i, false);
        C0067b.m112C(parcel, k);
    }

    public FullWalletRequest m783Q(Parcel parcel) {
        Cart cart = null;
        int j = C0066a.m92j(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0066a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str2 = C0066a.m94l(parcel, i2);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0066a.m94l(parcel, i2);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    cart = (Cart) C0066a.m77a(parcel, i2, Cart.CREATOR);
                    break;
                default:
                    C0066a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new FullWalletRequest(i, str2, str, cart);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public FullWalletRequest[] av(int i) {
        return new FullWalletRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m783Q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return av(x0);
    }
}
