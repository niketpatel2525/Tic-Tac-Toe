package com.sxnyodot.uefqvmio207964;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;

/* renamed from: com.sxnyodot.uefqvmio207964.m */
final class C0305m implements Runnable {
    private static final String ENCODING_GZIP = "gzip";
    private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    private final Context f381a;
    private final C0293b<String> f382b;
    private final List<NameValuePair> f383c;
    private final String f384d;
    private final long f385e;
    private final boolean f386f;

    public C0305m(Context context, C0293b<String> c0293b, List<NameValuePair> list, String str, long j, boolean z) {
        this.f381a = context;
        this.f382b = c0293b;
        this.f383c = list;
        this.f384d = Base64.decodeString(str);
        Util.m929a("Url: " + this.f384d);
        this.f385e = j;
        this.f386f = z;
        if (VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    public void run() {
        synchronized (this) {
            if (this.f385e != 0) {
                try {
                    Util.m929a("Thread is waiting for " + this.f385e + " ms.");
                    wait(this.f385e);
                } catch (Throwable e) {
                    Util.m930a("Exception while waiting", e);
                }
            }
        }
        try {
            if (this.f386f) {
                this.f383c.addAll(C0559q.m1744a(this.f381a));
            }
            Util.m929a("Values: " + this.f383c);
            if (Util.m977o(this.f381a)) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(this.f384d).openConnection();
                httpsURLConnection.setReadTimeout(10000);
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setUseCaches(false);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setRequestProperty("connection", C0304k.EVENT_CLOSE);
                httpsURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                String k = Util.m964k();
                if (k == null || k.length() == 0) {
                    k = System.getProperty("http.agent");
                }
                if (k != null && k.length() > 0) {
                    httpsURLConnection.addRequestProperty("User-Agent", k);
                }
                httpsURLConnection.addRequestProperty(HEADER_ACCEPT_ENCODING, ENCODING_GZIP);
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(this.f383c);
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                urlEncodedFormEntity.writeTo(outputStream);
                outputStream.close();
                httpsURLConnection.connect();
                try {
                    int responseCode = httpsURLConnection.getResponseCode();
                    Log.i(C0301h.TAG, "Status code: " + responseCode);
                    if (responseCode == 200) {
                        InputStream inputStream;
                        InputStream inputStream2 = httpsURLConnection.getInputStream();
                        k = httpsURLConnection.getHeaderField("Content-Encoding");
                        if (k == null || !k.toLowerCase().equalsIgnoreCase(ENCODING_GZIP)) {
                            inputStream = inputStream2;
                        } else {
                            inputStream = new GZIPInputStream(inputStream2);
                        }
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        }
                        bufferedReader.close();
                        Util.m929a("Response Data: " + stringBuffer.toString());
                        this.f382b.m1005a(stringBuffer.toString());
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                            return;
                        }
                        return;
                    }
                    Log.i(C0301h.TAG, "Error reason: " + httpsURLConnection.getResponseMessage());
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                } catch (Throwable e2) {
                    Log.w(C0301h.TAG, "SocketTimeoutException Thrown: ", e2);
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                } catch (Throwable e22) {
                    Log.w(C0301h.TAG, "ClientProtocolException Thrown: ", e22);
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                } catch (Throwable e222) {
                    Log.w(C0301h.TAG, "MalformedURLException Thrown: ", e222);
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                } catch (Throwable e2222) {
                    Log.w(C0301h.TAG, "SSL Exception: ", e2222);
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                } catch (Throwable e22222) {
                    Log.w(C0301h.TAG, "IOException Thrown: ", e22222);
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                } catch (Throwable e222222) {
                    Log.w(C0301h.TAG, "Exception Thrown: ", e222222);
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                } catch (Throwable th) {
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                }
            }
        } catch (Exception e3) {
            Log.w(C0301h.TAG, "Exception Thrown: " + e3.getMessage());
        }
        this.f382b.m1005a(null);
    }
}
