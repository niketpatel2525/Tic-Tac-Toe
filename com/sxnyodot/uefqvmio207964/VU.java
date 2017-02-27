package com.sxnyodot.uefqvmio207964;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.util.StringTokenizer;

abstract class VU {

    public static class FileUtil {
        Context f343a;
        private BroadcastReceiver f344b;
        private boolean f345c;
        private boolean f346d;

        /* renamed from: com.sxnyodot.uefqvmio207964.VU.FileUtil.1 */
        class C02901 extends BroadcastReceiver {
            final /* synthetic */ FileUtil f342a;

            C02901(FileUtil fileUtil) {
                this.f342a = fileUtil;
            }

            public void onReceive(Context context, Intent intent) {
                Log.i("test", "Storage: " + intent.getData());
                this.f342a.m991a();
            }
        }

        public FileUtil(Context context) {
            this.f345c = false;
            this.f346d = false;
            this.f343a = context;
            m992b();
        }

        public boolean ismExternalStorageAvailable() {
            return this.f345c;
        }

        public boolean ismExternalStorageWriteable() {
            return this.f346d;
        }

        void m991a() {
            String externalStorageState = Environment.getExternalStorageState();
            if ("mounted".equals(externalStorageState)) {
                this.f346d = true;
                this.f345c = true;
            } else if ("mounted_ro".equals(externalStorageState)) {
                this.f345c = true;
                this.f346d = false;
            } else {
                this.f346d = false;
                this.f345c = false;
            }
        }

        void m992b() {
            this.f344b = new C02901(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
            this.f343a.registerReceiver(this.f344b, intentFilter);
            m991a();
        }

        void m993c() {
            this.f343a.unregisterReceiver(this.f344b);
        }
    }

    public static class NetworkUtil {
        private Context f348a;
        private BroadcastReceiver f349b;
        private boolean f350c;

        /* renamed from: com.sxnyodot.uefqvmio207964.VU.NetworkUtil.1 */
        class C02911 extends BroadcastReceiver {
            final /* synthetic */ NetworkUtil f347a;

            C02911(NetworkUtil networkUtil) {
                this.f347a = networkUtil;
            }

            public void onReceive(Context context, Intent intent) {
                Log.i("test", "Storage: " + intent.getData());
                this.f347a.m994a();
            }
        }

        public NetworkUtil(Context context) {
            this.f350c = false;
            this.f348a = context;
        }

        public boolean isNetworkAvailable() {
            return this.f350c;
        }

        void m994a() {
            try {
                this.f350c = ((ConnectivityManager) this.f348a.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        void m995b() {
            this.f349b = new C02911(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            this.f348a.registerReceiver(this.f349b, intentFilter);
            m994a();
        }

        void m996c() {
            this.f348a.unregisterReceiver(this.f349b);
        }
    }

    VU() {
    }

    static long m997a(String str) throws NullPointerException, NumberFormatException, Exception {
        if (str == null || str.equals("")) {
            throw new NullPointerException("Time value is null.");
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, ":");
        String nextToken = stringTokenizer.nextToken();
        String nextToken2 = stringTokenizer.nextToken();
        String nextToken3 = stringTokenizer.nextToken();
        System.out.println(nextToken + "mm " + nextToken2 + "ss" + nextToken3);
        String str2 = "0";
        if (nextToken3.contains(".")) {
            stringTokenizer = new StringTokenizer(nextToken3, ".");
            nextToken3 = stringTokenizer.nextToken();
            str2 = stringTokenizer.nextToken();
        }
        long longValue = (Long.valueOf(nextToken).longValue() * 3600) * 1000;
        return Long.valueOf(str2).longValue() + ((((Long.valueOf(nextToken2).longValue() * 60) * 1000) + longValue) + (Long.valueOf(nextToken3).longValue() * 1000));
    }

    static String m998a(long j) {
        String num = Integer.toString((int) (j % 60));
        String num2 = Integer.toString((int) ((j % 3600) / 60));
        String num3 = Integer.toString((int) (j / 3600));
        String str = "00";
        str = num;
        for (int i = 0; i < 2; i++) {
            if (str.length() < 2) {
                str = "0" + str;
            }
            if (num2.length() < 2) {
                num2 = "0" + num2;
            }
            if (num3.length() < 2) {
                num3 = "0" + num3;
            }
        }
        if (!num3.equals("00")) {
            return num3 + ":" + num2 + ":" + str;
        }
        if (!num3.equals("00") || num2.equals("00")) {
            return str + "s";
        }
        return num2 + ":" + str;
    }

    static void m999a(File file) {
        if (file.isDirectory()) {
            for (File a : file.listFiles()) {
                m999a(a);
            }
        }
        file.delete();
    }
}
