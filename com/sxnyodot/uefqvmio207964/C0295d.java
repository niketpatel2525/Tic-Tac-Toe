package com.sxnyodot.uefqvmio207964;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.sxnyodot.uefqvmio207964.AdListener.AdType;

/* renamed from: com.sxnyodot.uefqvmio207964.d */
class C0295d {
    private final String f372a;
    private SharedPreferences f373b;
    private Editor f374c;

    public C0295d(Context context) throws NullPointerException {
        this.f372a = "ad_cache";
        this.f373b = context.getSharedPreferences("ad_cache", 0);
    }

    boolean m1009a(AdType adType, String str) throws Exception {
        this.f374c = this.f373b.edit();
        this.f374c.putString("" + adType, str);
        return this.f374c.commit();
    }

    boolean m1010a(AdType adType, String str, String str2) throws Exception {
        this.f374c = this.f373b.edit();
        this.f374c.putString("" + adType, str);
        this.f374c.putString("video_url", str2);
        return this.f374c.commit();
    }

    String m1006a(AdType adType) throws NullPointerException {
        return this.f373b.getString(adType.toString(), null);
    }

    String[] m1011b(AdType adType) throws Exception {
        return new String[]{this.f373b.getString(adType.toString(), null), this.f373b.getString("video_url", null)};
    }

    void m1012c(AdType adType) throws Exception {
        this.f374c = this.f373b.edit();
        this.f374c.remove("" + adType);
        this.f374c.commit();
    }

    void m1013d(AdType adType) throws Exception {
        this.f374c = this.f373b.edit();
        this.f374c.remove(adType.toString());
        this.f374c.remove("video_url");
        this.f374c.commit();
    }

    void m1007a(boolean z) {
        this.f374c = this.f373b.edit();
        this.f374c.putBoolean("thisSmartWall", z);
        this.f374c.commit();
    }

    boolean m1008a() {
        return this.f373b.getBoolean("thisSmartWall", false);
    }

    boolean m1014e(AdType adType) {
        if (Prm.enableCaching) {
            String string = this.f373b.getString(adType.toString(), null);
            if (!(string == null || string.equals(""))) {
                return true;
            }
        }
        return false;
    }
}
