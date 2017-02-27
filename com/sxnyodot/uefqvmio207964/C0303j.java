package com.sxnyodot.uefqvmio207964;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.sxnyodot.uefqvmio207964.j */
final class C0303j extends AsyncTask<Void, Void, Void> {
    Bitmap f378a;
    final String f379b;
    final C0293b<Bitmap> f380c;

    protected /* synthetic */ Object doInBackground(Object[] x0) {
        return m1018a((Void[]) x0);
    }

    protected /* synthetic */ void onPostExecute(Object x0) {
        m1019a((Void) x0);
    }

    public C0303j(String str, C0293b<Bitmap> c0293b) {
        this.f378a = null;
        this.f379b = str;
        this.f380c = c0293b;
        Util.m929a("Image URL: " + str);
    }

    protected Void m1018a(Void... voidArr) {
        HttpURLConnection httpURLConnection;
        Exception exception;
        Throwable th;
        HttpURLConnection httpURLConnection2 = null;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(this.f379b).openConnection();
            try {
                httpURLConnection3.setRequestMethod("GET");
                httpURLConnection3.setConnectTimeout(20000);
                httpURLConnection3.setReadTimeout(20000);
                httpURLConnection3.setUseCaches(false);
                httpURLConnection3.setDefaultUseCaches(false);
                httpURLConnection3.connect();
                int responseCode = httpURLConnection3.getResponseCode();
                if (responseCode == 200) {
                    this.f378a = BitmapFactory.decodeStream(httpURLConnection3.getInputStream());
                } else {
                    Log.w(C0301h.TAG, "Http code: " + responseCode + "message: " + httpURLConnection3.getResponseMessage());
                }
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
            } catch (Exception e) {
                Exception exception2 = e;
                httpURLConnection = httpURLConnection3;
                exception = exception2;
                try {
                    exception.printStackTrace();
                    Log.e(C0301h.TAG, "Network Error, please try again later");
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                httpURLConnection2 = httpURLConnection3;
                th = th3;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e2) {
            exception = e2;
            httpURLConnection = null;
            exception.printStackTrace();
            Log.e(C0301h.TAG, "Network Error, please try again later");
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
        return null;
    }

    protected void m1019a(Void voidR) {
        if (this.f380c != null) {
            this.f380c.m1005a(this.f378a);
        }
    }
}
