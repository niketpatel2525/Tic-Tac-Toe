package com.sxnyodot.uefqvmio207964;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.plus.PlusShare;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

abstract class JP implements C0301h {
    private static final String ERROR_KEY = "error";
    private static final String STATUS_KEY = "status";
    private static final String URL_KEY = "url";

    public static final class ParseBannerAd {
        private String f214a;
        private String f215b;
        private String f216c;
        private String f217d;
        private String f218e;
        private String f219f;
        private String f220g;
        private String f221h;
        private String f222i;
        private String f223j;
        private String f224k;
        private String f225l;
        private boolean f226m;
        private String f227n;
        private boolean f228o;
        private boolean f229p;
        private boolean f230q;
        private boolean f231r;
        private int f232s;
        private String f233t;
        private String f234u;
        private int f235v;
        private int f236w;
        private HashMap<String, String> f237x;
        private final String f238y;

        public ParseBannerAd() {
            this.f238y = "imp_url";
        }

        boolean m897a(Context context, JSONObject jSONObject, String str) throws JSONException, Exception {
            String str2;
            Util.m929a("Parsing banner json");
            String str3 = C0301h.INVALID;
            this.f226m = jSONObject.isNull(JP.ERROR_KEY) ? false : jSONObject.getBoolean(JP.ERROR_KEY);
            int i = jSONObject.isNull(JP.STATUS_KEY) ? 0 : jSONObject.getInt(JP.STATUS_KEY);
            String string = jSONObject.isNull(C0301h.TYPE_MESSAGE) ? str3 : jSONObject.getString(C0301h.TYPE_MESSAGE);
            if (jSONObject.isNull("adtype")) {
                str2 = str3;
            } else {
                str2 = jSONObject.getString("adtype");
            }
            this.f219f = str2;
            this.f218e = jSONObject.getString("banner_type");
            if (i != 200 || !string.equalsIgnoreCase("Success")) {
                return false;
            }
            String string2 = jSONObject.isNull("data") ? "nodata" : jSONObject.getString("data");
            if (string2.equals("nodata")) {
                Log.i(C0301h.TAG, "No data is not found in JSON.");
                return false;
            }
            JSONObject jSONObject2 = new JSONObject(string2);
            this.f214a = jSONObject2.isNull(JP.URL_KEY) ? str3 : jSONObject2.getString(JP.URL_KEY);
            if (!jSONObject2.isNull(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE)) {
                str3 = jSONObject2.getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
            }
            this.f217d = str3;
            this.f215b = jSONObject2.isNull("adimage") ? "" : jSONObject2.getString("adimage");
            this.f220g = jSONObject2.isNull("creativeid") ? "" : jSONObject2.getString("creativeid");
            this.f221h = jSONObject2.isNull("campaignid") ? "" : jSONObject2.getString("campaignid");
            this.f224k = jSONObject2.isNull("sms") ? "" : jSONObject2.getString("sms");
            this.f225l = jSONObject2.isNull("number") ? "" : jSONObject2.getString("number");
            this.f223j = jSONObject2.isNull("banner_bg") ? "#000000" : jSONObject2.getString("banner_bg");
            this.f222i = jSONObject2.isNull("text_color") ? "#FFFFFF" : jSONObject2.getString("text_color");
            this.f235v = jSONObject2.isNull(IM.WIDTH) ? 320 : jSONObject2.getInt(IM.WIDTH);
            if (jSONObject2.isNull(IM.HEIGHT)) {
                i = 50;
            } else {
                i = jSONObject2.getInt(IM.HEIGHT);
            }
            this.f236w = i;
            if (str.endsWith("text")) {
                if (this.f222i.equals("")) {
                    this.f222i = "#FFFFFF";
                    this.f223j = "#000000";
                    Log.w(IM.TAG, "Text color missing");
                }
                if (this.f223j.equals("")) {
                    this.f222i = "#FFFFFF";
                    this.f223j = "#000000";
                    Log.w(IM.TAG, "Banner bg missing");
                }
            }
            this.f216c = jSONObject2.isNull("text") ? "" : jSONObject2.getString("text");
            this.f227n = jSONObject2.isNull("api_url") ? "" : jSONObject2.getString("api_url");
            this.f237x = new HashMap();
            this.f237x.put("imp_url13", m895a(this.f227n, "13"));
            this.f237x.put("imp_url14", m895a(this.f227n, "14"));
            this.f237x.put("imp_url89", m895a(this.f227n, IM.MRAID_EVENT_ERROR));
            Util.m929a("Urls: " + this.f237x);
            this.f234u = jSONObject2.isNull("beacon") ? "" : jSONObject2.getString("beacon");
            switch (jSONObject2.isNull("istag") ? 0 : jSONObject2.getInt("istag")) {
                case DetectedActivity.IN_VEHICLE /*0*/:
                    this.f228o = false;
                    this.f229p = false;
                    this.f231r = false;
                    this.f230q = false;
                    break;
                case DetectedActivity.ON_BICYCLE /*1*/:
                    this.f228o = false;
                    this.f229p = true;
                    this.f231r = false;
                    this.f230q = false;
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    this.f228o = true;
                    this.f229p = false;
                    this.f231r = false;
                    this.f230q = false;
                    break;
                case DetectedActivity.STILL /*3*/:
                    this.f228o = false;
                    this.f229p = false;
                    this.f231r = true;
                    this.f230q = false;
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    this.f228o = false;
                    this.f229p = false;
                    this.f231r = false;
                    this.f230q = true;
                    break;
                default:
                    this.f228o = false;
                    this.f229p = false;
                    this.f231r = false;
                    this.f230q = false;
                    break;
            }
            this.f233t = jSONObject2.isNull("tag") ? "" : jSONObject2.getString("tag");
            if (jSONObject.isNull("refreshtime")) {
                i = 45;
            } else {
                i = jSONObject.getInt("refreshtime");
            }
            this.f232s = i;
            return true;
        }

        private String m895a(String str, String str2) {
            if (str.contains("%event%")) {
                return str.replace("%event%", str2);
            }
            return str;
        }

        public String getEventUrl(String key) {
            if (this.f237x != null) {
                return (String) this.f237x.get("imp_url" + key);
            }
            return null;
        }

        public void removeEventUrl(String key) {
            if (this.f237x != null) {
                this.f237x.remove("imp_url" + key);
            }
        }

        boolean m896a() {
            return this.f231r;
        }

        boolean m898b() {
            return this.f230q;
        }

        String m899c() {
            return this.f214a;
        }

        public String getAdimage() {
            return this.f215b;
        }

        String m900d() {
            return this.f216c;
        }

        String m901e() {
            return this.f217d;
        }

        String m902f() {
            return this.f218e;
        }

        String m903g() {
            return this.f219f;
        }

        String m904h() {
            return this.f220g;
        }

        String m905i() {
            return this.f221h;
        }

        String m906j() {
            return this.f222i;
        }

        String m907k() {
            return this.f223j;
        }

        String m908l() {
            return this.f224k;
        }

        String m909m() {
            return this.f225l;
        }

        boolean m910n() {
            return this.f226m;
        }

        public String getApi_url() {
            return this.f227n;
        }

        public boolean isJsAd() {
            return this.f228o;
        }

        public int getRefreshTime() {
            return this.f232s;
        }

        public boolean isHtmlAd() {
            return this.f229p;
        }

        public String getTag() {
            return this.f233t;
        }

        public String getBeaconUrl() {
            return this.f234u;
        }

        public int getWidth() {
            return this.f235v;
        }

        public int getHeight() {
            return this.f236w;
        }
    }

    public static final class ParseMraidJson {
        private String f239a;
        private boolean f240b;
        private String f241c;
        private String f242d;
        private String f243e;
        private boolean f244f;
        private String f245g;
        private int f246h;
        private boolean f247i;
        private boolean f248j;
        private String f249k;
        private int f250l;
        private int f251m;

        public ParseMraidJson(Context context, JSONObject jsonObject) throws JSONException, Exception {
            int i = jsonObject.getInt(JP.STATUS_KEY);
            String string = jsonObject.getString(C0301h.TYPE_MESSAGE);
            this.f244f = jsonObject.isNull(JP.ERROR_KEY) ? false : jsonObject.getBoolean(JP.ERROR_KEY);
            this.f246h = jsonObject.isNull("refreshtime") ? 45 : jsonObject.getInt("refreshtime");
            if (i == 200 && string.equalsIgnoreCase("Success")) {
                String str;
                JSONObject jSONObject = new JSONObject(jsonObject.getString("data"));
                this.f243e = jSONObject.isNull("guid") ? "" : jSONObject.getString("guid");
                this.f239a = jSONObject.isNull(JP.URL_KEY) ? "" : jSONObject.getString(JP.URL_KEY);
                this.f250l = jSONObject.isNull(IM.WIDTH) ? 320 : jSONObject.getInt(IM.WIDTH);
                this.f251m = jSONObject.isNull(IM.HEIGHT) ? 50 : jSONObject.getInt(IM.HEIGHT);
                this.f245g = jSONObject.isNull("impurl") ? "" : jSONObject.getString("impurl");
                switch (jSONObject.isNull("istag") ? 0 : jSONObject.getInt("istag")) {
                    case DetectedActivity.IN_VEHICLE /*0*/:
                        this.f247i = false;
                        this.f248j = false;
                        this.f240b = false;
                        break;
                    case DetectedActivity.ON_BICYCLE /*1*/:
                        this.f247i = false;
                        this.f248j = true;
                        this.f240b = false;
                        break;
                    case DetectedActivity.ON_FOOT /*2*/:
                        this.f247i = true;
                        this.f248j = false;
                        this.f240b = false;
                        break;
                    case DetectedActivity.STILL /*3*/:
                        this.f247i = false;
                        this.f248j = false;
                        this.f240b = true;
                        break;
                    case DetectedActivity.UNKNOWN /*4*/:
                        this.f247i = false;
                        this.f248j = false;
                        this.f240b = true;
                        break;
                    default:
                        this.f247i = false;
                        this.f248j = false;
                        this.f240b = false;
                        break;
                }
                if (jSONObject.isNull("tag")) {
                    str = "";
                } else {
                    str = jSONObject.getString("tag");
                }
                this.f249k = str;
                return;
            }
            throw new IOException(string);
        }

        public int getHeight() {
            return this.f251m;
        }

        public int getWidth() {
            return this.f250l;
        }

        public String getTag() {
            return this.f249k;
        }

        public boolean isHtmlAd() {
            return this.f248j;
        }

        public boolean isJsAd() {
            return this.f247i;
        }

        public String getAd_url() {
            return this.f239a;
        }

        public boolean isInlineScript() {
            return this.f240b;
        }

        public String getCampId() {
            return this.f241c;
        }

        public String getCreativeId() {
            return this.f242d;
        }

        public String getGuid() {
            return this.f243e;
        }

        public boolean isErrorReporting() {
            return this.f244f;
        }

        public String getImpression_url() {
            return this.f245g;
        }

        public int getRefreshTime() {
            return this.f246h;
        }
    }

    JP() {
    }
}
