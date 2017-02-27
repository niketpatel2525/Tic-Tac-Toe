package com.sxnyodot.uefqvmio207964;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/* renamed from: com.sxnyodot.uefqvmio207964.s */
class C0320s {
    private Context f427a;
    private Location f428b;
    private String f429c;

    /* renamed from: com.sxnyodot.uefqvmio207964.s.1 */
    class C03181 implements LocationListener {
        final /* synthetic */ LocationManager f423a;
        final /* synthetic */ C0320s f424b;

        C03181(C0320s c0320s, LocationManager locationManager) {
            this.f424b = c0320s;
            this.f423a = locationManager;
        }

        public void onLocationChanged(Location location) {
            Util.m928a(System.currentTimeMillis());
            this.f424b.f428b = location;
            this.f423a.removeUpdates(this);
        }

        public void onProviderDisabled(String provider) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.s.a */
    private class C0319a {
        protected static final String PREFS_DEVICE_ID = "device_id";
        protected static final String PREFS_FILE = "device_id.xml";
        protected UUID f425a;
        final /* synthetic */ C0320s f426b;

        public C0319a(C0320s c0320s, Context context) {
            this.f426b = c0320s;
            if (this.f425a == null) {
                synchronized (C0319a.class) {
                    if (this.f425a == null) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_FILE, 0);
                        String string = sharedPreferences.getString(PREFS_DEVICE_ID, null);
                        if (string != null) {
                            this.f425a = UUID.fromString(string);
                        } else {
                            string = Secure.getString(context.getContentResolver(), C0301h.ANDROID_ID);
                            try {
                                if ("9774d56d682e549c".equals(string)) {
                                    string = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                                    this.f425a = string != null ? UUID.nameUUIDFromBytes(string.getBytes("utf8")) : UUID.randomUUID();
                                } else {
                                    this.f425a = UUID.nameUUIDFromBytes(string.getBytes("utf8"));
                                }
                                sharedPreferences.edit().putString(PREFS_DEVICE_ID, this.f425a.toString()).commit();
                            } catch (Throwable e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        }

        public UUID m1043a() {
            return this.f425a;
        }
    }

    public C0320s(Context context) {
        this.f429c = "0";
        this.f427a = context;
    }

    String m1046a() {
        try {
            String deviceId = ((TelephonyManager) this.f427a.getSystemService("phone")).getDeviceId();
            if (deviceId == null || deviceId.equals("")) {
                Class cls = Class.forName("android.os.SystemProperties");
                deviceId = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.serialno"});
                Util.m968l("SERIAL");
                if (deviceId != null && !deviceId.equals("")) {
                    return deviceId;
                }
                if (this.f427a.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", Util.m947e(this.f427a)) == 0) {
                    WifiManager wifiManager = (WifiManager) this.f427a.getSystemService(C0301h.WIFI);
                    System.out.println("WIFI " + wifiManager.isWifiEnabled());
                    deviceId = wifiManager.getConnectionInfo().getMacAddress();
                    Util.m968l("WIFI_MAC");
                    return deviceId;
                }
                deviceId = new C0319a(this, this.f427a).m1043a().toString();
                Util.m968l("UUID");
                return deviceId;
            }
            Util.m968l("IMEI");
            return deviceId;
        } catch (Exception e) {
            e.printStackTrace();
            return C0301h.INVALID;
        }
    }

    boolean m1047b() {
        boolean z = false;
        try {
            String a = m1046a();
            if (a == null || a.equals("") || a.equals(C0301h.INVALID)) {
                Util.m929a("Can not get device unique id.");
                return z;
            }
            MessageDigest.getInstance("MD5").update(a.getBytes(), 0, a.length());
            Util.m942c(String.format("%032x", new Object[]{new BigInteger(1, r2.digest())}));
            z = m1045e();
            return z;
        } catch (NoSuchAlgorithmException e) {
            Log.e(C0301h.TAG, "Error occured while converting details to md5." + e.getMessage());
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.e(C0301h.TAG, "Error occured while converting details to md5.");
        }
    }

    private boolean m1045e() {
        try {
            String a = m1046a();
            if (a == null || a.equals("") || a.equals(C0301h.INVALID)) {
                Util.m929a("Can not get device unique id.");
                return false;
            }
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(a.getBytes(), 0, a.length());
            Util.m945d(new BigInteger(1, instance.digest()).toString(16));
            return true;
        } catch (NoSuchAlgorithmException e) {
            Log.e(C0301h.TAG, "Error occured while converting details to SHA-1." + e.getMessage());
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.e(C0301h.TAG, "Error occured while converting details to SHA-1.");
            return false;
        }
    }

    public String m1048c() {
        return this.f429c;
    }

    Location m1049d() {
        Util.m929a("fetching Location.");
        try {
            if (!Util.m967l().equals("0") || Util.m973n() + 900000 > System.currentTimeMillis()) {
                return null;
            }
            synchronized (this.f427a) {
                if (!Util.m967l().equals("0") || Util.m973n() + 900000 > System.currentTimeMillis()) {
                    Util.m929a("failed in last");
                    return null;
                }
                Object obj = this.f427a.getPackageManager().checkPermission("android.permission.ACCESS_COARSE_LOCATION", this.f427a.getPackageName()) == 0 ? 1 : null;
                Object obj2;
                if (this.f427a.getPackageManager().checkPermission("android.permission.ACCESS_FINE_LOCATION", this.f427a.getPackageName()) == 0) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj == null || r3 == null) {
                    Util.m929a("Location permission not found.");
                } else {
                    LocationManager locationManager = (LocationManager) this.f427a.getSystemService("location");
                    if (locationManager == null) {
                        Util.m929a("Location manager null");
                        return null;
                    }
                    String bestProvider;
                    Criteria criteria = new Criteria();
                    criteria.setCostAllowed(false);
                    if (obj != null) {
                        criteria.setAccuracy(2);
                        bestProvider = locationManager.getBestProvider(criteria, true);
                        this.f429c = "1";
                    } else {
                        bestProvider = null;
                    }
                    if (bestProvider == null && r3 != null) {
                        criteria.setAccuracy(1);
                        bestProvider = locationManager.getBestProvider(criteria, true);
                        this.f429c = "2";
                    }
                    if (bestProvider == null) {
                        Util.m929a("Provider null");
                        return null;
                    }
                    this.f428b = locationManager.getLastKnownLocation(bestProvider);
                    if (this.f428b != null) {
                        Util.m929a("Location found via get last known location.");
                        Location location = this.f428b;
                        return location;
                    }
                    Util.m928a(System.currentTimeMillis());
                    locationManager.requestLocationUpdates(bestProvider, 0, 0.0f, new C03181(this, locationManager), this.f427a.getMainLooper());
                }
                return this.f428b;
            }
        } catch (Exception e) {
            Log.w(C0301h.TAG, "Error occured while fetching location. " + e.getMessage());
        } catch (Throwable th) {
            Log.e(C0301h.TAG, "Error in location: " + th.getMessage());
        }
    }
}
