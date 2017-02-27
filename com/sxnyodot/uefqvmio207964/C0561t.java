package com.sxnyodot.uefqvmio207964;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import com.google.android.gms.games.GamesClient;
import com.sxnyodot.uefqvmio207964.AdListener.AdType;
import com.sxnyodot.uefqvmio207964.XmlParser.Creative;
import com.sxnyodot.uefqvmio207964.XmlParser.InvalidVastXML;
import com.sxnyodot.uefqvmio207964.XmlParser.VastException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.sxnyodot.uefqvmio207964.t */
class C0561t implements C0293b<String> {
    private static final String TAG = "PrmVast";
    private static XmlParser f624a;
    private Context f625b;

    /* renamed from: com.sxnyodot.uefqvmio207964.t.1 */
    class C05601 implements C0293b<String> {
        String f619a;
        final /* synthetic */ String f620b;
        final /* synthetic */ boolean f621c;
        final /* synthetic */ String f622d;
        final /* synthetic */ C0561t f623e;

        /* renamed from: com.sxnyodot.uefqvmio207964.t.1.1 */
        class C03211 implements Runnable {
            final /* synthetic */ C05601 f430a;

            C03211(C05601 c05601) {
                this.f430a = c05601;
            }

            public void run() {
                try {
                    URLConnection openConnection = new URL(this.f430a.f622d).openConnection();
                    openConnection.setConnectTimeout(GamesClient.STATUS_REAL_TIME_CONNECTION_FAILED);
                    openConnection.setReadTimeout(GamesClient.STATUS_REAL_TIME_CONNECTION_FAILED);
                    openConnection.connect();
                    Log.i(C0561t.TAG, "Content-length: " + openConnection.getContentLength());
                    InputStream inputStream = openConnection.getInputStream();
                    File file = new File(this.f430a.f619a, "ad_video.mp4");
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.close();
                            this.f430a.m1755a(file.getAbsolutePath());
                            return;
                        }
                    }
                } catch (SocketTimeoutException e2) {
                    e2.printStackTrace();
                    this.f430a.m1755a(null);
                } catch (MalformedURLException e3) {
                    e3.printStackTrace();
                    this.f430a.m1755a(null);
                } catch (IOException e4) {
                    e4.printStackTrace();
                    this.f430a.m1755a(null);
                }
            }
        }

        C05601(C0561t c0561t, String str, boolean z, String str2) {
            this.f623e = c0561t;
            this.f620b = str;
            this.f621c = z;
            this.f622d = str2;
            this.f619a = "";
        }

        public void m1755a(String str) {
            Util.m929a("Video file: " + str);
            if (str != null) {
                try {
                    if (!str.equals("")) {
                        if (Prm.enableCaching) {
                            C0295d c0295d = new C0295d(this.f623e.f625b);
                            if (c0295d.m1010a(AdType.video, this.f620b, str)) {
                                if (this.f621c) {
                                    c0295d.m1009a(AdType.smartwall, this.f620b);
                                    C0558p.sendAdCached(AdType.smartwall);
                                    c0295d.m1007a(true);
                                    return;
                                }
                                C0558p.sendAdCached(AdType.video);
                                return;
                            } else if (Prm.adListener != null) {
                                C0558p.sendAdError("Video ad not cached.");
                                return;
                            } else {
                                return;
                            }
                        }
                        Intent intent = new Intent(this.f623e.f625b, VDActivity.class);
                        intent.setAction("play_video");
                        intent.setFlags(268435456);
                        intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                        intent.addFlags(536870912);
                        intent.setData(Uri.parse(str));
                        this.f623e.f625b.startActivity(intent);
                        C0559q.m1748d(this.f623e.f625b);
                        return;
                    }
                } catch (Throwable e) {
                    Log.e(C0561t.TAG, "Error occured while download video", e);
                    return;
                }
            }
            Log.e(C0561t.TAG, "Not able to download video");
        }

        public void m1753a() {
            try {
                File file = new File(Environment.getExternalStorageDirectory(), "ap_video");
                if (file.exists() && file.isDirectory()) {
                    VU.m999a(file);
                    file.mkdirs();
                    this.f619a = file.getAbsolutePath();
                } else if (file.mkdirs()) {
                    this.f619a = file.getAbsolutePath();
                }
                new Thread(new C03211(this), "dwn_video").start();
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
            }
        }
    }

    static XmlParser m1759b() {
        return f624a;
    }

    public C0561t(Context context) {
        this.f625b = context;
    }

    public void m1760a() {
        try {
            List arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("cache", Prm.cache));
            new Thread(new C0305m(this.f625b, this, arrayList, C0301h.VIDEO_AD_URL, 0, true), "vast").start();
        } catch (Throwable e) {
            Log.e(TAG, "Video ad", e);
        } catch (Throwable e2) {
            Log.e(TAG, "Error occurred while fetching Video ad", e2);
        }
    }

    public void m1762a(String str) {
        Log.i(TAG, "Video Ad: " + str);
        if (str == null || str.equals("")) {
            Log.w(TAG, "Video ad response is null");
        } else {
            m1764a(str, false);
        }
    }

    void m1764a(String str, boolean z) {
        try {
            C0559q.m1748d(this.f625b);
            f624a = new XmlParser(new StringReader(str));
            HashMap hashMap = (HashMap) ((Creative) f624a.m1683m().get(0)).getMediaFiles().get(0);
            String obj = hashMap.get(C0304k.MEDIA_FILE).toString();
            String obj2 = hashMap.get(C0304k.MEDIA_FILE_DELIVERY).toString();
            if (obj == null || obj.equals("")) {
                Log.e(TAG, "Ad url is invalid: " + obj);
            } else if (obj2 != null && obj2.equals("progressive")) {
                m1757a(str, obj, z);
            } else if (Prm.enableCaching) {
                C0295d c0295d = new C0295d(this.f625b);
                if (!c0295d.m1010a(AdType.video, str, obj)) {
                    return;
                }
                if (z) {
                    c0295d.m1009a(AdType.smartwall, str);
                    C0558p.sendAdCached(AdType.smartwall);
                    c0295d.m1007a(true);
                    return;
                }
                C0558p.sendAdCached(AdType.video);
            } else {
                Log.e(TAG, "deleviery type streaming " + obj);
                Intent intent = new Intent(this.f625b, VDActivity.class);
                intent.setAction("play_video");
                intent.setFlags(268435456);
                intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                intent.addFlags(536870912);
                intent.setData(Uri.parse(obj));
                this.f625b.startActivity(intent);
                C0559q.m1748d(this.f625b);
            }
        } catch (VastException e) {
            Log.e(TAG, e.getMessage());
            Prm.validateStatusCode(e.getCode(), e.getMessage());
        } catch (InvalidVastXML e2) {
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void m1757a(String str, String str2, boolean z) {
        try {
            String externalStorageState = Environment.getExternalStorageState();
            boolean z2 = externalStorageState.equals("mounted") && !externalStorageState.equals("mounted_ro");
            if (Boolean.valueOf(z2).booleanValue()) {
                C0293b c05601 = new C05601(this, str, z, str2);
                if (Util.m977o(this.f625b)) {
                    c05601.m1004a();
                    return;
                }
                return;
            }
            String str3 = "SD Card  is not available for caching video. SD Card storage state: " + externalStorageState;
            Log.e(TAG, str3);
            C0558p.sendAdError(str3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean m1758a(Context context) {
        boolean z = true;
        try {
            if (!(context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
                String str = "Required permission WRITE_EXTERNAL_STORAGE not found in Manifest. Please add.";
                Log.e(C0301h.TAG, str);
                C0558p.sendIntegrationError(str);
                z = false;
            }
            if (z) {
                return z;
            }
            C0312o c0312o = new C0312o(context, 110);
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    void m1763a(String str, String str2) {
        try {
            f624a = new XmlParser(new StringReader(str));
            Log.i(TAG, "Showing ad from caching; " + str2);
            Intent intent = new Intent(this.f625b, VDActivity.class);
            intent.setAction("play_video");
            intent.setFlags(268435456);
            intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
            intent.addFlags(536870912);
            intent.setData(Uri.parse(str2));
            this.f625b.startActivity(intent);
            C0559q.m1748d(this.f625b);
        } catch (Throwable th) {
            Log.e(TAG, "Error occurred while showing video from cache", th);
        }
    }
}
