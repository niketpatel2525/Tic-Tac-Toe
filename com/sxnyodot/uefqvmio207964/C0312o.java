package com.sxnyodot.uefqvmio207964;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.games.GamesClient;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

/* renamed from: com.sxnyodot.uefqvmio207964.o */
class C0312o {
    static final int BANNER_AD_BROWSER_ACTIVTY_NOT_FOUND = 109;
    static final int INVALID_APIKEY = 101;
    static final int REQUIRED_PERMISSIONS_NOT_FOUND = 100;
    static final int REQUIRED_VIDEO_AD_PERMISSIONS_NOT_FOUND = 110;
    static final int SMARTWALL_ACTIVITY_NOT_FOUND = 103;
    static final int SMARTWALL_BROWSER_ACTITY_NOT_FOUND = 104;
    static final int VIDEO_AD_ACTIVITY_NOT_FOUND = 102;
    private Context f415a;

    /* renamed from: com.sxnyodot.uefqvmio207964.o.1 */
    class C03111 implements Runnable {
        final /* synthetic */ int f413a;
        final /* synthetic */ C0312o f414b;

        C03111(C0312o c0312o, int i) {
            this.f414b = c0312o;
            this.f413a = i;
        }

        public void run() {
            int i = 0;
            try {
                PackageInfo packageInfo = this.f414b.f415a.getPackageManager().getPackageInfo(this.f414b.f415a.getPackageName(), 0);
                String str = "" + packageInfo.versionCode;
                List arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair("appVersion", str));
                arrayList.add(new BasicNameValuePair(C0301h.APP_ID, Util.m961j()));
                arrayList.add(new BasicNameValuePair("errorCode", "" + this.f413a));
                arrayList.add(new BasicNameValuePair(C0301h.PACKAGE_NAME, this.f414b.f415a.getPackageName()));
                arrayList.add(new BasicNameValuePair("appName", this.f414b.f415a.getPackageManager().getApplicationLabel(packageInfo.applicationInfo).toString()));
                Log.i(C0301h.TAG, "Error values: " + arrayList);
                HttpClient defaultHttpClient = new DefaultHttpClient();
                HttpUriRequest httpPost = new HttpPost(Base64.decodeString(C0301h.ERROR_URL));
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList));
                HttpParams basicHttpParams = new BasicHttpParams();
                httpPost.setParams(basicHttpParams);
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, GamesClient.STATUS_REAL_TIME_CONNECTION_FAILED);
                HttpConnectionParams.setSoTimeout(basicHttpParams, GamesClient.STATUS_REAL_TIME_CONNECTION_FAILED);
                HttpResponse execute = defaultHttpClient.execute(httpPost);
                if (execute != null) {
                    i = execute.getStatusLine().getStatusCode();
                }
                Log.i(C0301h.TAG, "Status code: " + i);
                if (i == 200) {
                    Log.i(C0301h.TAG, "Error sent: " + EntityUtils.toString(execute.getEntity()));
                    return;
                }
                Log.i(C0301h.TAG, "Status Code: " + i + ", Reason: " + execute.getStatusLine().getReasonPhrase());
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            } catch (ClientProtocolException e3) {
                e3.printStackTrace();
            } catch (IOException e4) {
                e4.printStackTrace();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public C0312o(Context context, int i) {
        if (context != null) {
            this.f415a = context;
            if (Util.m977o(context)) {
                m1040a(i);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1040a(int r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = com.sxnyodot.uefqvmio207964.Util.m961j();	 Catch:{ Exception -> 0x002e }
        if (r0 == 0) goto L_0x0013;
    L_0x0007:
        r0 = com.sxnyodot.uefqvmio207964.Util.m961j();	 Catch:{ Exception -> 0x002e }
        r1 = "0";
        r0 = r0.equals(r1);	 Catch:{ Exception -> 0x002e }
        if (r0 == 0) goto L_0x001c;
    L_0x0013:
        r0 = "PrmSDK";
        r1 = "Appid is invalid. Sending report aborted.";
        android.util.Log.i(r0, r1);	 Catch:{ Exception -> 0x002e }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
    L_0x001b:
        return;
    L_0x001c:
        r0 = new java.lang.Thread;	 Catch:{ Exception -> 0x002e }
        r1 = new com.sxnyodot.uefqvmio207964.o$1;	 Catch:{ Exception -> 0x002e }
        r1.<init>(r3, r4);	 Catch:{ Exception -> 0x002e }
        r0.<init>(r1);	 Catch:{ Exception -> 0x002e }
        r0.start();	 Catch:{ Exception -> 0x002e }
    L_0x0029:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x001b;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r0 = move-exception;
        r1 = "PrmSDK";
        r2 = "Sending integration error failed.";
        android.util.Log.e(r1, r2, r0);	 Catch:{ all -> 0x002b }
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sxnyodot.uefqvmio207964.o.a(int):void");
    }
}
