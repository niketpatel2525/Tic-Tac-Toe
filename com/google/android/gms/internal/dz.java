package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.dw.C0421a;
import java.util.ArrayList;
import java.util.HashMap;

public class dz implements SafeParcelable {
    public static final ea CREATOR;
    private final int iM;
    private final HashMap<String, HashMap<String, C0421a<?, ?>>> lJ;
    private final ArrayList<C0422a> lK;
    private final String lL;

    /* renamed from: com.google.android.gms.internal.dz.a */
    public static class C0422a implements SafeParcelable {
        public static final eb CREATOR;
        final String className;
        final ArrayList<C0423b> lM;
        final int versionCode;

        static {
            CREATOR = new eb();
        }

        C0422a(int i, String str, ArrayList<C0423b> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.lM = arrayList;
        }

        C0422a(String str, HashMap<String, C0421a<?, ?>> hashMap) {
            this.versionCode = 1;
            this.className = str;
            this.lM = C0422a.m1288a(hashMap);
        }

        private static ArrayList<C0423b> m1288a(HashMap<String, C0421a<?, ?>> hashMap) {
            if (hashMap == null) {
                return null;
            }
            ArrayList<C0423b> arrayList = new ArrayList();
            for (String str : hashMap.keySet()) {
                arrayList.add(new C0423b(str, (C0421a) hashMap.get(str)));
            }
            return arrayList;
        }

        HashMap<String, C0421a<?, ?>> bG() {
            HashMap<String, C0421a<?, ?>> hashMap = new HashMap();
            int size = this.lM.size();
            for (int i = 0; i < size; i++) {
                C0423b c0423b = (C0423b) this.lM.get(i);
                hashMap.put(c0423b.lN, c0423b.lO);
            }
            return hashMap;
        }

        public int describeContents() {
            eb ebVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            eb ebVar = CREATOR;
            eb.m432a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.dz.b */
    public static class C0423b implements SafeParcelable {
        public static final dy CREATOR;
        final String lN;
        final C0421a<?, ?> lO;
        final int versionCode;

        static {
            CREATOR = new dy();
        }

        C0423b(int i, String str, C0421a<?, ?> c0421a) {
            this.versionCode = i;
            this.lN = str;
            this.lO = c0421a;
        }

        C0423b(String str, C0421a<?, ?> c0421a) {
            this.versionCode = 1;
            this.lN = str;
            this.lO = c0421a;
        }

        public int describeContents() {
            dy dyVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            dy dyVar = CREATOR;
            dy.m426a(this, out, flags);
        }
    }

    static {
        CREATOR = new ea();
    }

    dz(int i, ArrayList<C0422a> arrayList, String str) {
        this.iM = i;
        this.lK = null;
        this.lJ = m1289b((ArrayList) arrayList);
        this.lL = (String) dm.m392e(str);
        bC();
    }

    public dz(Class<? extends dw> cls) {
        this.iM = 1;
        this.lK = null;
        this.lJ = new HashMap();
        this.lL = cls.getCanonicalName();
    }

    private static HashMap<String, HashMap<String, C0421a<?, ?>>> m1289b(ArrayList<C0422a> arrayList) {
        HashMap<String, HashMap<String, C0421a<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C0422a c0422a = (C0422a) arrayList.get(i);
            hashMap.put(c0422a.className, c0422a.bG());
        }
        return hashMap;
    }

    public HashMap<String, C0421a<?, ?>> m1290H(String str) {
        return (HashMap) this.lJ.get(str);
    }

    public void m1291a(Class<? extends dw> cls, HashMap<String, C0421a<?, ?>> hashMap) {
        this.lJ.put(cls.getCanonicalName(), hashMap);
    }

    public boolean m1292b(Class<? extends dw> cls) {
        return this.lJ.containsKey(cls.getCanonicalName());
    }

    public void bC() {
        for (String str : this.lJ.keySet()) {
            HashMap hashMap = (HashMap) this.lJ.get(str);
            for (String str2 : hashMap.keySet()) {
                ((C0421a) hashMap.get(str2)).m1286a(this);
            }
        }
    }

    public void bD() {
        for (String str : this.lJ.keySet()) {
            HashMap hashMap = (HashMap) this.lJ.get(str);
            HashMap hashMap2 = new HashMap();
            for (String str2 : hashMap.keySet()) {
                hashMap2.put(str2, ((C0421a) hashMap.get(str2)).bs());
            }
            this.lJ.put(str, hashMap2);
        }
    }

    ArrayList<C0422a> bE() {
        ArrayList<C0422a> arrayList = new ArrayList();
        for (String str : this.lJ.keySet()) {
            arrayList.add(new C0422a(str, (HashMap) this.lJ.get(str)));
        }
        return arrayList;
    }

    public String bF() {
        return this.lL;
    }

    public int describeContents() {
        ea eaVar = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.iM;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.lJ.keySet()) {
            stringBuilder.append(str).append(":\n");
            HashMap hashMap = (HashMap) this.lJ.get(str);
            for (String str2 : hashMap.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(hashMap.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        ea eaVar = CREATOR;
        ea.m429a(this, out, flags);
    }
}
