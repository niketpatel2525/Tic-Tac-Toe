package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.wallet.j */
public class C0222j implements Creator<OfferWalletObject> {
    static void m794a(OfferWalletObject offerWalletObject, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, offerWalletObject.getVersionCode());
        C0067b.m121a(parcel, 2, offerWalletObject.tU, false);
        C0067b.m121a(parcel, 3, offerWalletObject.ul, false);
        C0067b.m112C(parcel, k);
    }

    public OfferWalletObject m795W(Parcel parcel) {
        String str = null;
        int j = C0066a.m92j(parcel);
        int i = 0;
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
                default:
                    C0066a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new OfferWalletObject(i, str2, str);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public OfferWalletObject[] aB(int i) {
        return new OfferWalletObject[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m795W(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aB(x0);
    }
}
