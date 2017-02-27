package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.internal.dw.C0421a;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ec extends dw implements SafeParcelable {
    public static final ed CREATOR;
    private final int iM;
    private final dz lH;
    private final Parcel lP;
    private final int lQ;
    private int lR;
    private int lS;
    private final String mClassName;

    static {
        CREATOR = new ed();
    }

    ec(int i, Parcel parcel, dz dzVar) {
        this.iM = i;
        this.lP = (Parcel) dm.m392e(parcel);
        this.lQ = 2;
        this.lH = dzVar;
        if (this.lH == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.lH.bF();
        }
        this.lR = 2;
    }

    private ec(SafeParcelable safeParcelable, dz dzVar, String str) {
        this.iM = 1;
        this.lP = Parcel.obtain();
        safeParcelable.writeToParcel(this.lP, 0);
        this.lQ = 1;
        this.lH = (dz) dm.m392e(dzVar);
        this.mClassName = (String) dm.m392e(str);
        this.lR = 2;
    }

    public static <T extends dw & SafeParcelable> ec m1306a(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new ec((SafeParcelable) t, m1312b((dw) t), canonicalName);
    }

    private static void m1307a(dz dzVar, dw dwVar) {
        Class cls = dwVar.getClass();
        if (!dzVar.m1292b(cls)) {
            HashMap bp = dwVar.bp();
            dzVar.m1291a(cls, dwVar.bp());
            for (String str : bp.keySet()) {
                C0421a c0421a = (C0421a) bp.get(str);
                Class bx = c0421a.bx();
                if (bx != null) {
                    try {
                        m1307a(dzVar, (dw) bx.newInstance());
                    } catch (Throwable e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + c0421a.bx().getCanonicalName(), e);
                    } catch (Throwable e2) {
                        throw new IllegalStateException("Could not access object of type " + c0421a.bx().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    private void m1308a(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case DetectedActivity.IN_VEHICLE /*0*/:
            case DetectedActivity.ON_BICYCLE /*1*/:
            case DetectedActivity.ON_FOOT /*2*/:
            case DetectedActivity.STILL /*3*/:
            case DetectedActivity.UNKNOWN /*4*/:
            case DetectedActivity.TILTING /*5*/:
            case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                stringBuilder.append(obj);
            case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                stringBuilder.append("\"").append(ei.m449I(obj.toString())).append("\"");
            case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                stringBuilder.append("\"").append(ef.m445b((byte[]) obj)).append("\"");
            case ConnectionResult.SERVICE_INVALID /*9*/:
                stringBuilder.append("\"").append(ef.m446c((byte[]) obj));
                stringBuilder.append("\"");
            case ConnectionResult.DEVELOPER_ERROR /*10*/:
                ej.m450a(stringBuilder, (HashMap) obj);
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void m1309a(StringBuilder stringBuilder, C0421a<?, ?> c0421a, Parcel parcel, int i) {
        switch (c0421a.bo()) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                m1316b(stringBuilder, (C0421a) c0421a, m420a(c0421a, Integer.valueOf(C0066a.m86f(parcel, i))));
            case DetectedActivity.ON_BICYCLE /*1*/:
                m1316b(stringBuilder, (C0421a) c0421a, m420a(c0421a, C0066a.m88h(parcel, i)));
            case DetectedActivity.ON_FOOT /*2*/:
                m1316b(stringBuilder, (C0421a) c0421a, m420a(c0421a, Long.valueOf(C0066a.m87g(parcel, i))));
            case DetectedActivity.STILL /*3*/:
                m1316b(stringBuilder, (C0421a) c0421a, m420a(c0421a, Float.valueOf(C0066a.m89i(parcel, i))));
            case DetectedActivity.UNKNOWN /*4*/:
                m1316b(stringBuilder, (C0421a) c0421a, m420a(c0421a, Double.valueOf(C0066a.m91j(parcel, i))));
            case DetectedActivity.TILTING /*5*/:
                m1316b(stringBuilder, (C0421a) c0421a, m420a(c0421a, C0066a.m93k(parcel, i)));
            case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                m1316b(stringBuilder, (C0421a) c0421a, m420a(c0421a, Boolean.valueOf(C0066a.m83c(parcel, i))));
            case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                m1316b(stringBuilder, (C0421a) c0421a, m420a(c0421a, C0066a.m94l(parcel, i)));
            case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
            case ConnectionResult.SERVICE_INVALID /*9*/:
                m1316b(stringBuilder, (C0421a) c0421a, m420a(c0421a, C0066a.m97o(parcel, i)));
            case ConnectionResult.DEVELOPER_ERROR /*10*/:
                m1316b(stringBuilder, (C0421a) c0421a, m420a(c0421a, m1313b(C0066a.m96n(parcel, i))));
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + c0421a.bo());
        }
    }

    private void m1310a(StringBuilder stringBuilder, String str, C0421a<?, ?> c0421a, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (c0421a.bz()) {
            m1309a(stringBuilder, c0421a, parcel, i);
        } else {
            m1315b(stringBuilder, c0421a, parcel, i);
        }
    }

    private void m1311a(StringBuilder stringBuilder, HashMap<String, C0421a<?, ?>> hashMap, Parcel parcel) {
        HashMap b = m1314b((HashMap) hashMap);
        stringBuilder.append('{');
        int j = C0066a.m92j(parcel);
        Object obj = null;
        while (parcel.dataPosition() < j) {
            int i = C0066a.m90i(parcel);
            Entry entry = (Entry) b.get(Integer.valueOf(C0066a.m107y(i)));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                m1310a(stringBuilder, (String) entry.getKey(), (C0421a) entry.getValue(), parcel, i);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != j) {
            throw new C0065a("Overread allowed size end=" + j, parcel);
        }
        stringBuilder.append('}');
    }

    private static dz m1312b(dw dwVar) {
        dz dzVar = new dz(dwVar.getClass());
        m1307a(dzVar, dwVar);
        dzVar.bD();
        dzVar.bC();
        return dzVar;
    }

    public static HashMap<String, String> m1313b(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    private static HashMap<Integer, Entry<String, C0421a<?, ?>>> m1314b(HashMap<String, C0421a<?, ?>> hashMap) {
        HashMap<Integer, Entry<String, C0421a<?, ?>>> hashMap2 = new HashMap();
        for (Entry entry : hashMap.entrySet()) {
            hashMap2.put(Integer.valueOf(((C0421a) entry.getValue()).bw()), entry);
        }
        return hashMap2;
    }

    private void m1315b(StringBuilder stringBuilder, C0421a<?, ?> c0421a, Parcel parcel, int i) {
        if (c0421a.bu()) {
            stringBuilder.append("[");
            switch (c0421a.bo()) {
                case DetectedActivity.IN_VEHICLE /*0*/:
                    ee.m440a(stringBuilder, C0066a.m99q(parcel, i));
                    break;
                case DetectedActivity.ON_BICYCLE /*1*/:
                    ee.m442a(stringBuilder, C0066a.m101s(parcel, i));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    ee.m441a(stringBuilder, C0066a.m100r(parcel, i));
                    break;
                case DetectedActivity.STILL /*3*/:
                    ee.m439a(stringBuilder, C0066a.m102t(parcel, i));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    ee.m438a(stringBuilder, C0066a.m103u(parcel, i));
                    break;
                case DetectedActivity.TILTING /*5*/:
                    ee.m442a(stringBuilder, C0066a.m104v(parcel, i));
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    ee.m444a(stringBuilder, C0066a.m98p(parcel, i));
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    ee.m443a(stringBuilder, C0066a.m105w(parcel, i));
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                case ConnectionResult.SERVICE_INVALID /*9*/:
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    Parcel[] z = C0066a.m109z(parcel, i);
                    int length = z.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        z[i2].setDataPosition(0);
                        m1311a(stringBuilder, c0421a.bB(), z[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (c0421a.bo()) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                stringBuilder.append(C0066a.m86f(parcel, i));
            case DetectedActivity.ON_BICYCLE /*1*/:
                stringBuilder.append(C0066a.m88h(parcel, i));
            case DetectedActivity.ON_FOOT /*2*/:
                stringBuilder.append(C0066a.m87g(parcel, i));
            case DetectedActivity.STILL /*3*/:
                stringBuilder.append(C0066a.m89i(parcel, i));
            case DetectedActivity.UNKNOWN /*4*/:
                stringBuilder.append(C0066a.m91j(parcel, i));
            case DetectedActivity.TILTING /*5*/:
                stringBuilder.append(C0066a.m93k(parcel, i));
            case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                stringBuilder.append(C0066a.m83c(parcel, i));
            case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                stringBuilder.append("\"").append(ei.m449I(C0066a.m94l(parcel, i))).append("\"");
            case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                stringBuilder.append("\"").append(ef.m445b(C0066a.m97o(parcel, i))).append("\"");
            case ConnectionResult.SERVICE_INVALID /*9*/:
                stringBuilder.append("\"").append(ef.m446c(C0066a.m97o(parcel, i)));
                stringBuilder.append("\"");
            case ConnectionResult.DEVELOPER_ERROR /*10*/:
                Bundle n = C0066a.m96n(parcel, i);
                Set<String> keySet = n.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(ei.m449I(n.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                Parcel y = C0066a.m108y(parcel, i);
                y.setDataPosition(0);
                m1311a(stringBuilder, c0421a.bB(), y);
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void m1316b(StringBuilder stringBuilder, C0421a<?, ?> c0421a, Object obj) {
        if (c0421a.bt()) {
            m1317b(stringBuilder, (C0421a) c0421a, (ArrayList) obj);
        } else {
            m1308a(stringBuilder, c0421a.bn(), obj);
        }
    }

    private void m1317b(StringBuilder stringBuilder, C0421a<?, ?> c0421a, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            m1308a(stringBuilder, c0421a.bn(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    protected Object m1318D(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected boolean m1319E(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Parcel bH() {
        switch (this.lR) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                this.lS = C0067b.m133k(this.lP);
                C0067b.m112C(this.lP, this.lS);
                this.lR = 2;
                break;
            case DetectedActivity.ON_BICYCLE /*1*/:
                C0067b.m112C(this.lP, this.lS);
                this.lR = 2;
                break;
        }
        return this.lP;
    }

    dz bI() {
        switch (this.lQ) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                return null;
            case DetectedActivity.ON_BICYCLE /*1*/:
                return this.lH;
            case DetectedActivity.ON_FOOT /*2*/:
                return this.lH;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.lQ);
        }
    }

    public HashMap<String, C0421a<?, ?>> bp() {
        return this.lH == null ? null : this.lH.m1290H(this.mClassName);
    }

    public int describeContents() {
        ed edVar = CREATOR;
        return 0;
    }

    public int getVersionCode() {
        return this.iM;
    }

    public String toString() {
        dm.m388a(this.lH, (Object) "Cannot convert to JSON on client side.");
        Parcel bH = bH();
        bH.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        m1311a(stringBuilder, this.lH.m1290H(this.mClassName), bH);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        ed edVar = CREATOR;
        ed.m435a(this, out, flags);
    }
}
