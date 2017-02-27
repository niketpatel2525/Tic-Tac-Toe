package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import android.support.v4.util.TimeUtils;
import android.support.v4.widget.ViewDragHelper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.internal.fv.C0592a;
import com.google.android.gms.internal.fv.C0595b;
import com.google.android.gms.internal.fv.C0596c;
import com.google.android.gms.internal.fv.C0597d;
import com.google.android.gms.internal.fv.C0598f;
import com.google.android.gms.internal.fv.C0599g;
import com.google.android.gms.internal.fv.C0600h;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class fw implements Creator<fv> {
    static void m621a(fv fvVar, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        Set di = fvVar.di();
        if (di.contains(Integer.valueOf(1))) {
            C0067b.m131c(parcel, 1, fvVar.getVersionCode());
        }
        if (di.contains(Integer.valueOf(2))) {
            C0067b.m121a(parcel, 2, fvVar.getAboutMe(), true);
        }
        if (di.contains(Integer.valueOf(3))) {
            C0067b.m120a(parcel, 3, fvVar.dD(), i, true);
        }
        if (di.contains(Integer.valueOf(4))) {
            C0067b.m121a(parcel, 4, fvVar.getBirthday(), true);
        }
        if (di.contains(Integer.valueOf(5))) {
            C0067b.m121a(parcel, 5, fvVar.getBraggingRights(), true);
        }
        if (di.contains(Integer.valueOf(6))) {
            C0067b.m131c(parcel, 6, fvVar.getCircledByCount());
        }
        if (di.contains(Integer.valueOf(7))) {
            C0067b.m120a(parcel, 7, fvVar.dE(), i, true);
        }
        if (di.contains(Integer.valueOf(8))) {
            C0067b.m121a(parcel, 8, fvVar.getCurrentLocation(), true);
        }
        if (di.contains(Integer.valueOf(9))) {
            C0067b.m121a(parcel, 9, fvVar.getDisplayName(), true);
        }
        if (di.contains(Integer.valueOf(12))) {
            C0067b.m131c(parcel, 12, fvVar.getGender());
        }
        if (di.contains(Integer.valueOf(14))) {
            C0067b.m121a(parcel, 14, fvVar.getId(), true);
        }
        if (di.contains(Integer.valueOf(15))) {
            C0067b.m120a(parcel, 15, fvVar.dF(), i, true);
        }
        if (di.contains(Integer.valueOf(16))) {
            C0067b.m124a(parcel, 16, fvVar.isPlusUser());
        }
        if (di.contains(Integer.valueOf(19))) {
            C0067b.m120a(parcel, 19, fvVar.dG(), i, true);
        }
        if (di.contains(Integer.valueOf(18))) {
            C0067b.m121a(parcel, 18, fvVar.getLanguage(), true);
        }
        if (di.contains(Integer.valueOf(21))) {
            C0067b.m131c(parcel, 21, fvVar.getObjectType());
        }
        if (di.contains(Integer.valueOf(20))) {
            C0067b.m121a(parcel, 20, fvVar.getNickname(), true);
        }
        if (di.contains(Integer.valueOf(23))) {
            C0067b.m130b(parcel, 23, fvVar.dI(), true);
        }
        if (di.contains(Integer.valueOf(22))) {
            C0067b.m130b(parcel, 22, fvVar.dH(), true);
        }
        if (di.contains(Integer.valueOf(25))) {
            C0067b.m131c(parcel, 25, fvVar.getRelationshipStatus());
        }
        if (di.contains(Integer.valueOf(24))) {
            C0067b.m131c(parcel, 24, fvVar.getPlusOneCount());
        }
        if (di.contains(Integer.valueOf(27))) {
            C0067b.m121a(parcel, 27, fvVar.getUrl(), true);
        }
        if (di.contains(Integer.valueOf(26))) {
            C0067b.m121a(parcel, 26, fvVar.getTagline(), true);
        }
        if (di.contains(Integer.valueOf(29))) {
            C0067b.m124a(parcel, 29, fvVar.isVerified());
        }
        if (di.contains(Integer.valueOf(28))) {
            C0067b.m130b(parcel, 28, fvVar.dJ(), true);
        }
        C0067b.m112C(parcel, k);
    }

    public fv m622D(Parcel parcel) {
        int j = C0066a.m92j(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        C0592a c0592a = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        C0595b c0595b = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        C0596c c0596c = null;
        boolean z = false;
        String str7 = null;
        C0597d c0597d = null;
        String str8 = null;
        int i4 = 0;
        List list = null;
        List list2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        List list3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < j) {
            int i7 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i7)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0066a.m86f(parcel, i7);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0066a.m94l(parcel, i7);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.STILL /*3*/:
                    C0592a c0592a2 = (C0592a) C0066a.m77a(parcel, i7, C0592a.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c0592a = c0592a2;
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str2 = C0066a.m94l(parcel, i7);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str3 = C0066a.m94l(parcel, i7);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    i2 = C0066a.m86f(parcel, i7);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    C0595b c0595b2 = (C0595b) C0066a.m77a(parcel, i7, C0595b.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    c0595b = c0595b2;
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    str4 = C0066a.m94l(parcel, i7);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    str5 = C0066a.m94l(parcel, i7);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case ConnectionResult.DATE_INVALID /*12*/:
                    i3 = C0066a.m86f(parcel, i7);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 14:
                    str6 = C0066a.m94l(parcel, i7);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case ViewDragHelper.EDGE_ALL /*15*/:
                    C0596c c0596c2 = (C0596c) C0066a.m77a(parcel, i7, C0596c.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    c0596c = c0596c2;
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PAUSE /*16*/:
                    z = C0066a.m83c(parcel, i7);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 18:
                    str7 = C0066a.m94l(parcel, i7);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    C0597d c0597d2 = (C0597d) C0066a.m77a(parcel, i7, C0597d.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    c0597d = c0597d2;
                    break;
                case 20:
                    str8 = C0066a.m94l(parcel, i7);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    i4 = C0066a.m86f(parcel, i7);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    list = C0066a.m82c(parcel, i7, C0598f.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    list2 = C0066a.m82c(parcel, i7, C0599g.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    i5 = C0066a.m86f(parcel, i7);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    i6 = C0066a.m86f(parcel, i7);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case 26:
                    str9 = C0066a.m94l(parcel, i7);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str10 = C0066a.m94l(parcel, i7);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    list3 = C0066a.m82c(parcel, i7, C0600h.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    z2 = C0066a.m83c(parcel, i7);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    C0066a.m80b(parcel, i7);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new fv(hashSet, i, str, c0592a, str2, str3, i2, c0595b, str4, str5, i3, str6, c0596c, z, str7, c0597d, str8, i4, list, list2, i5, i6, str9, str10, list3, z2);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public fv[] ai(int i) {
        return new fv[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m622D(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ai(x0);
    }
}
