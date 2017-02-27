package com.sxnyodot.uefqvmio207964;

import android.os.Build.VERSION;
import android.util.Log;
import com.google.android.gms.games.GamesClient;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.sxnyodot.uefqvmio207964.r */
final class C0317r implements Runnable {
    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";
    private final String f419a;
    private final String[] f420b;
    private boolean f421c;
    private C0293b<String> f422d;

    public C0317r(String str, String str2, C0293b<String> c0293b) {
        this.f421c = false;
        this.f419a = str;
        this.f420b = new String[]{str2};
        this.f421c = true;
        this.f422d = c0293b;
        if (VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    public C0317r(String str, String... strArr) {
        this.f421c = false;
        this.f419a = str;
        this.f420b = strArr;
        this.f421c = false;
        if (VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    public synchronized void run() {
        try {
            if (this.f421c) {
                m1042a(this.f420b[0]);
            } else {
                m1041a();
            }
        } catch (Throwable e) {
            Log.e(C0301h.TAG, "Error in tracker: ", e);
        }
    }

    private void m1042a(String str) {
        HttpURLConnection httpURLConnection;
        String stringBuffer;
        String str2;
        Throwable th;
        Object obj;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setReadTimeout(15000);
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setRequestMethod(METHOD_POST);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestProperty("connection", C0304k.EVENT_CLOSE);
                    httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                    if (this.f419a.length() > 0) {
                        httpURLConnection.addRequestProperty("User-Agent", this.f419a);
                    }
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    Log.i(C0301h.TAG, "Status code: " + responseCode);
                    if (responseCode == 200) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                        StringBuffer stringBuffer2 = new StringBuffer();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer2.append(readLine);
                        }
                        bufferedReader.close();
                        stringBuffer = stringBuffer2.toString();
                    } else {
                        stringBuffer = "Error reason: " + httpURLConnection.getResponseMessage();
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            str2 = stringBuffer;
                            th = th2;
                            try {
                                Log.w("Exception: ", th);
                            } catch (Throwable th3) {
                                Log.e(C0301h.TAG, "Error occurred while firing trackers", th3);
                            }
                            if (this.f422d == null) {
                                this.f422d.m1005a(obj);
                                return;
                            }
                            return;
                        }
                    }
                    str2 = stringBuffer;
                    if (this.f422d == null) {
                        this.f422d.m1005a(obj);
                        return;
                    }
                    return;
                }
            } catch (Throwable e2) {
                th3 = e2;
                obj = null;
                Log.w("Exception: ", th3);
                if (this.f422d == null) {
                    this.f422d.m1005a(obj);
                    return;
                }
                return;
            } catch (Throwable th4) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
        if (this.f422d != null) {
            this.f422d.m1005a("url null");
        }
    }

    private void m1041a() {
        try {
            if (this.f420b == null || this.f420b.length == 0) {
                Log.w(C0301h.TAG, "Trackers null");
                return;
            }
            int i = 0;
            while (i < this.f420b.length) {
                HttpURLConnection httpURLConnection;
                try {
                    if (this.f420b[i] == null || this.f420b[i].length() == 0) {
                        Log.w(C0301h.TAG, "Param null");
                        i++;
                    } else {
                        Log.i(C0301h.TAG, "Beacon: " + this.f420b[i]);
                        httpURLConnection = (HttpURLConnection) new URL(this.f420b[i]).openConnection();
                        httpURLConnection.setReadTimeout(GamesClient.STATUS_REAL_TIME_CONNECTION_FAILED);
                        httpURLConnection.setConnectTimeout(GamesClient.STATUS_REAL_TIME_CONNECTION_FAILED);
                        httpURLConnection.setRequestMethod(METHOD_GET);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setRequestProperty("connection", C0304k.EVENT_CLOSE);
                        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                        if (this.f419a.length() > 0) {
                            httpURLConnection.addRequestProperty("User-Agent", this.f419a);
                        }
                        httpURLConnection.connect();
                        int responseCode = httpURLConnection.getResponseCode();
                        Log.i(C0301h.TAG, "Status code: " + responseCode);
                        if (responseCode == 200) {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                            StringBuffer stringBuffer = new StringBuffer();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                            }
                            bufferedReader.close();
                            Log.i(C0301h.TAG, "Beacon Data: " + stringBuffer.toString());
                        } else {
                            Log.i(C0301h.TAG, "Error reason: " + httpURLConnection.getResponseMessage());
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        i++;
                    }
                } catch (Throwable e) {
                    Log.w("Exception: ", e);
                } catch (Throwable th) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        } catch (Throwable e2) {
            Log.e(C0301h.TAG, "Error occurred while firing trackers", e2);
        }
    }
}
