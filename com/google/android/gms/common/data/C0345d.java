package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.dm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.common.data.d */
public final class C0345d implements SafeParcelable {
    public static final C0057e CREATOR;
    private static final C0056a ju;
    private final int iC;
    private final int iM;
    private final String[] jm;
    Bundle jn;
    private final CursorWindow[] jo;
    private final Bundle jp;
    int[] jq;
    int jr;
    private Object js;
    private boolean jt;
    boolean mClosed;

    /* renamed from: com.google.android.gms.common.data.d.a */
    public static class C0056a {
        private final String[] jm;
        private final ArrayList<HashMap<String, Object>> jv;
        private final String jw;
        private final HashMap<Object, Integer> jx;
        private boolean jy;
        private String jz;

        private C0056a(String[] strArr, String str) {
            this.jm = (String[]) dm.m392e(strArr);
            this.jv = new ArrayList();
            this.jw = str;
            this.jx = new HashMap();
            this.jy = false;
            this.jz = null;
        }
    }

    /* renamed from: com.google.android.gms.common.data.d.1 */
    static class C03441 extends C0056a {
        C03441(String[] strArr, String str) {
            super(str, null);
        }
    }

    static {
        CREATOR = new C0057e();
        ju = new C03441(new String[0], null);
    }

    C0345d(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.mClosed = false;
        this.jt = true;
        this.iM = i;
        this.jm = strArr;
        this.jo = cursorWindowArr;
        this.iC = i2;
        this.jp = bundle;
    }

    private C0345d(C0056a c0056a, int i, Bundle bundle) {
        this(c0056a.jm, C0345d.m1090a(c0056a), i, bundle);
    }

    public C0345d(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.mClosed = false;
        this.jt = true;
        this.iM = 1;
        this.jm = (String[]) dm.m392e(strArr);
        this.jo = (CursorWindow[]) dm.m392e(cursorWindowArr);
        this.iC = i;
        this.jp = bundle;
        aJ();
    }

    public static C0345d m1089a(int i, Bundle bundle) {
        return new C0345d(ju, i, bundle);
    }

    private static CursorWindow[] m1090a(C0056a c0056a) {
        int i = 0;
        if (c0056a.jm.length == 0) {
            return new CursorWindow[0];
        }
        ArrayList c = c0056a.jv;
        int size = c.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(c0056a.jm.length);
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            int i4;
            int i5;
            CursorWindow cursorWindow2;
            if (cursorWindow.allocRow()) {
                i4 = i3;
            } else {
                Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i2 + ")");
                cursorWindow = new CursorWindow(false);
                cursorWindow.setNumColumns(c0056a.jm.length);
                arrayList.add(cursorWindow);
                if (cursorWindow.allocRow()) {
                    i4 = 0;
                } else {
                    Log.e("DataHolder", "Unable to allocate row to hold data.");
                    arrayList.remove(cursorWindow);
                    return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                }
            }
            Map map = (Map) c.get(i2);
            boolean z = true;
            for (int i6 = 0; i6 < c0056a.jm.length && z; i6++) {
                String str = c0056a.jm[i6];
                Object obj = map.get(str);
                if (obj == null) {
                    z = cursorWindow.putNull(i4, i6);
                } else if (obj instanceof String) {
                    z = cursorWindow.putString((String) obj, i4, i6);
                } else if (obj instanceof Long) {
                    z = cursorWindow.putLong(((Long) obj).longValue(), i4, i6);
                } else if (obj instanceof Integer) {
                    z = cursorWindow.putLong((long) ((Integer) obj).intValue(), i4, i6);
                } else if (obj instanceof Boolean) {
                    z = cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i4, i6);
                } else if (obj instanceof byte[]) {
                    z = cursorWindow.putBlob((byte[]) obj, i4, i6);
                } else {
                    throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                }
            }
            if (z) {
                i5 = i4 + 1;
                i3 = i2;
                cursorWindow2 = cursorWindow;
            } else {
                try {
                    Log.d("DataHolder", "Couldn't populate window data for row " + i2 + " - allocating new window.");
                    cursorWindow.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setNumColumns(c0056a.jm.length);
                    arrayList.add(cursorWindow3);
                    i3 = i2 - 1;
                    cursorWindow2 = cursorWindow3;
                    i5 = 0;
                } catch (RuntimeException e) {
                    RuntimeException runtimeException = e;
                    i2 = arrayList.size();
                    while (i < i2) {
                        ((CursorWindow) arrayList.get(i)).close();
                        i++;
                    }
                    throw runtimeException;
                }
            }
            cursorWindow = cursorWindow2;
            i2 = i3 + 1;
            i3 = i5;
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    private void m1091b(String str, int i) {
        if (this.jn == null || !this.jn.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.jr) {
            throw new CursorIndexOutOfBoundsException(i, this.jr);
        }
    }

    public static C0345d m1092r(int i) {
        return C0345d.m1089a(i, null);
    }

    public long m1093a(String str, int i, int i2) {
        m1091b(str, i);
        return this.jo[i2].getLong(i - this.jq[i2], this.jn.getInt(str));
    }

    public void m1094a(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        m1091b(str, i);
        this.jo[i2].copyStringToBuffer(i - this.jq[i2], this.jn.getInt(str), charArrayBuffer);
    }

    public void aJ() {
        int i;
        int i2 = 0;
        this.jn = new Bundle();
        for (i = 0; i < this.jm.length; i++) {
            this.jn.putInt(this.jm[i], i);
        }
        this.jq = new int[this.jo.length];
        i = 0;
        while (i2 < this.jo.length) {
            this.jq[i2] = i;
            i += this.jo[i2].getNumRows();
            i2++;
        }
        this.jr = i;
    }

    String[] aK() {
        return this.jm;
    }

    CursorWindow[] aL() {
        return this.jo;
    }

    public Bundle aM() {
        return this.jp;
    }

    public int m1095b(String str, int i, int i2) {
        m1091b(str, i);
        return this.jo[i2].getInt(i - this.jq[i2], this.jn.getInt(str));
    }

    public void m1096b(Object obj) {
        this.js = obj;
    }

    public String m1097c(String str, int i, int i2) {
        m1091b(str, i);
        return this.jo[i2].getString(i - this.jq[i2], this.jn.getInt(str));
    }

    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.jo) {
                    close.close();
                }
            }
        }
    }

    public boolean m1098d(String str, int i, int i2) {
        m1091b(str, i);
        return Long.valueOf(this.jo[i2].getLong(i - this.jq[i2], this.jn.getInt(str))).longValue() == 1;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] m1099e(String str, int i, int i2) {
        m1091b(str, i);
        return this.jo[i2].getBlob(i - this.jq[i2], this.jn.getInt(str));
    }

    public Uri m1100f(String str, int i, int i2) {
        String c = m1097c(str, i, i2);
        return c == null ? null : Uri.parse(c);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.jt && this.jo.length > 0 && !isClosed()) {
                Log.e("DataHolder", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call close() on all DataBuffer extending objects when you are done with them. (" + (this.js == null ? "internal object: " + toString() : this.js.toString()) + ")");
                close();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public boolean m1101g(String str, int i, int i2) {
        m1091b(str, i);
        return this.jo[i2].isNull(i - this.jq[i2], this.jn.getInt(str));
    }

    public int getCount() {
        return this.jr;
    }

    public int getStatusCode() {
        return this.iC;
    }

    int getVersionCode() {
        return this.iM;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public int m1102q(int i) {
        int i2 = 0;
        boolean z = i >= 0 && i < this.jr;
        dm.m393k(z);
        while (i2 < this.jq.length) {
            if (i < this.jq[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == this.jq.length ? i2 - 1 : i2;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0057e.m45a(this, dest, flags);
    }
}
