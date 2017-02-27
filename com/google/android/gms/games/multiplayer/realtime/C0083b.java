package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.multiplayer.realtime.b */
public class C0083b implements Creator<RoomEntity> {
    static void m162a(RoomEntity roomEntity, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m121a(parcel, 1, roomEntity.getRoomId(), false);
        C0067b.m131c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, roomEntity.getVersionCode());
        C0067b.m121a(parcel, 2, roomEntity.getCreatorId(), false);
        C0067b.m116a(parcel, 3, roomEntity.getCreationTimestamp());
        C0067b.m131c(parcel, 4, roomEntity.getStatus());
        C0067b.m121a(parcel, 5, roomEntity.getDescription(), false);
        C0067b.m131c(parcel, 6, roomEntity.getVariant());
        C0067b.m117a(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        C0067b.m130b(parcel, 8, roomEntity.getParticipants(), false);
        C0067b.m131c(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        C0067b.m112C(parcel, k);
    }

    public RoomEntity[] m163V(int i) {
        return new RoomEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m164y(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m163V(x0);
    }

    public RoomEntity m164y(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int j = C0066a.m92j(parcel);
        long j2 = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        while (parcel.dataPosition() < j) {
            int i5 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i5)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    str3 = C0066a.m94l(parcel, i5);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str2 = C0066a.m94l(parcel, i5);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j2 = C0066a.m87g(parcel, i5);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i3 = C0066a.m86f(parcel, i5);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str = C0066a.m94l(parcel, i5);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    i2 = C0066a.m86f(parcel, i5);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    bundle = C0066a.m96n(parcel, i5);
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    arrayList = C0066a.m82c(parcel, i5, ParticipantEntity.CREATOR);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    i = C0066a.m86f(parcel, i5);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i4 = C0066a.m86f(parcel, i5);
                    break;
                default:
                    C0066a.m80b(parcel, i5);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new RoomEntity(i4, str3, str2, j2, i3, str, i2, bundle, arrayList, i);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }
}
