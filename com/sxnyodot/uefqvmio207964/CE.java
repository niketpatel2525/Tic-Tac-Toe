package com.sxnyodot.uefqvmio207964;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.google.android.gms.plus.PlusShare;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class CE {
    static final String EVENT_RECURRENCE = "rrule";
    static final String EVENT_REMINDER = "reminder";
    static final String EVENT_TRANSPARENCY = "transparency";
    final String f193a;
    final String f194b;
    final String f195c;
    final String f196d;
    final String f197e;
    final String f198f;
    final String f199g;
    final String f200h;
    final String f201i;
    final String f202j;

    public static class Recurrence {
        String[] f173a;
        final String f174b;
        final String f175c;
        final String f176d;
        final String f177e;
        final String f178f;
        final String f179g;
        final String f180h;
        final String f181i;
        final String f182j;
        String f183k;
        short f184l;
        String f185m;
        String[] f186n;
        short[] f187o;
        short[] f188p;
        short[] f189q;
        short[] f190r;
        short[] f191s;
        final JSONObject f192t;

        public Recurrence(String jsonString) throws NullPointerException, JSONException {
            int i = 0;
            this.f173a = new String[]{"SU", "MO", "TU", "WE", "TH", "FR", "SA"};
            this.f174b = "frequency";
            this.f175c = "interval";
            this.f176d = "expires";
            this.f177e = "exceptionDates";
            this.f178f = "daysInWeek";
            this.f179g = "daysInMonth";
            this.f180h = "daysInYear";
            this.f181i = "weeksInMonth";
            this.f182j = "monthsInYear";
            this.f192t = new JSONObject(jsonString);
            this.f183k = this.f192t.isNull("frequency") ? "" : this.f192t.getString("frequency");
            this.f184l = this.f192t.isNull("interval") ? (short) 0 : Short.parseShort(this.f192t.getString("interval"));
            this.f185m = this.f192t.isNull("expires") ? "" : this.f192t.getString("expires");
            JSONArray jSONArray = this.f192t.isNull("exceptionDates") ? null : this.f192t.getJSONArray("exceptionDates");
            if (jSONArray != null) {
                this.f186n = new String[jSONArray.length()];
                while (i < this.f186n.length) {
                    this.f186n[i] = jSONArray.getString(i);
                    i++;
                }
            }
            this.f187o = m884a("daysInWeek");
            this.f188p = m884a("daysInMonth");
            this.f189q = m884a("daysInYear");
            this.f190r = m884a("weeksInMonth");
            this.f191s = m884a("monthsInYear");
        }

        final short[] m884a(String str) throws NullPointerException, JSONException {
            JSONArray jSONArray = this.f192t.isNull(str) ? null : this.f192t.getJSONArray(str);
            if (jSONArray == null) {
                return null;
            }
            short[] sArr = new short[jSONArray.length()];
            for (int i = 0; i < sArr.length; i++) {
                sArr[i] = (short) jSONArray.getInt(i);
            }
            return sArr;
        }

        public String getDate(short[] any) {
            String str = "";
            for (int i = 0; i < any.length; i++) {
                if (i == 0) {
                    str = "" + this.f173a[any[i]];
                } else {
                    str = str + "," + this.f173a[any[i]];
                }
            }
            return str;
        }

        public String getDate(String[] any) throws Exception {
            String str = "";
            for (int i = 0; i < any.length; i++) {
                if (i == 0) {
                    Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(any[i]);
                    System.out.println("dt: " + parse);
                    str = "" + new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'").format(parse);
                } else {
                    Date parse2 = new SimpleDateFormat("yyyy-MM-dd").parse(any[i]);
                    System.out.println("dt: " + parse2);
                    str = str + "," + new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'").format(parse2);
                }
            }
            return str;
        }

        public String getDate(String any) throws Exception {
            String str = "";
            Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(any);
            System.out.println("dt: " + parse);
            return new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'").format(parse);
        }

        String m883a() throws Exception {
            if (this.f186n != null) {
                return getDate(this.f186n);
            }
            return "";
        }

        public String getRrule() {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                if (!(this.f183k == null || this.f183k.equals(""))) {
                    stringBuilder.append("FREQ=" + this.f183k + ";");
                }
                if (this.f184l != (short) 0) {
                    stringBuilder.append("INTERVAL=" + this.f184l + ";");
                }
                if (!(this.f185m == null || this.f185m.equals(""))) {
                    stringBuilder.append("UNTIL=" + getDate(this.f185m) + ";");
                }
                if (this.f187o != null) {
                    stringBuilder.append("BYDAY=" + getDate(this.f187o) + ";");
                }
                if (this.f188p != null) {
                    stringBuilder.append("BYMONTHDAY=" + this.f188p + ";");
                }
                if (this.f189q != null) {
                    stringBuilder.append("BYYEARDAY=" + this.f189q + ";");
                }
                if (this.f190r != null) {
                    stringBuilder.append("BYWEEKNO=" + this.f190r + ";");
                }
                if (this.f191s != null) {
                    stringBuilder.append("BYMONTH=" + this.f191s + ";");
                }
                Util.m929a("Rrule: " + stringBuilder.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return stringBuilder.toString();
        }
    }

    CE() {
        this.f193a = C0304k.ID;
        this.f194b = "summary";
        this.f195c = "location";
        this.f196d = PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION;
        this.f197e = C0304k.EVENT_START;
        this.f198f = "end";
        this.f199g = "status";
        this.f200h = EVENT_TRANSPARENCY;
        this.f201i = "recurrence";
        this.f202j = EVENT_REMINDER;
    }

    @TargetApi(14)
    public static void m886a(Activity activity, String str) throws ActivityNotFoundException, Exception {
        String str2;
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.isNull(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION) ? "" : jSONObject.getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
        String string2 = jSONObject.isNull(C0304k.ID) ? "" : jSONObject.getString(C0304k.ID);
        String string3 = jSONObject.isNull("summary") ? "" : jSONObject.getString("summary");
        String string4 = jSONObject.isNull("location") ? "" : jSONObject.getString("location");
        String string5 = jSONObject.isNull(C0304k.EVENT_START) ? "" : jSONObject.getString(C0304k.EVENT_START);
        String string6 = jSONObject.isNull("end") ? "" : jSONObject.getString("end");
        String string7 = jSONObject.isNull("status") ? "" : jSONObject.getString("status");
        String string8 = jSONObject.isNull(EVENT_TRANSPARENCY) ? "" : jSONObject.getString(EVENT_TRANSPARENCY);
        String string9 = jSONObject.isNull(EVENT_REMINDER) ? "" : jSONObject.getString(EVENT_REMINDER);
        if (jSONObject.isNull("recurrence")) {
            str2 = "";
        } else {
            str2 = jSONObject.getString("recurrence");
        }
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setAction("android.intent.action.EDIT");
        intent.putExtra("calendar_id", string2);
        intent.putExtra("eventLocation", string4);
        intent.putExtra("beginTime", m885a(string5));
        intent.putExtra("endTime", m885a(string6));
        intent.putExtra("eventStatus", string7);
        intent.putExtra(EVENT_TRANSPARENCY, string8);
        if (!(str2 == null || str2.equals(""))) {
            try {
                Recurrence recurrence = new Recurrence(str2);
                intent.putExtra(EVENT_RECURRENCE, recurrence.getRrule());
                intent.putExtra("exdate", recurrence.m883a());
            } catch (Throwable e) {
                Util.m930a("Error in recurrence", e);
            }
        }
        if (string9 != null) {
            try {
                if (!string9.equals("")) {
                    intent.putExtra("event_id", string2);
                    if (string9.startsWith("-")) {
                        intent.putExtra("minutes", string9);
                    } else {
                        intent.putExtra("minutes", m885a(string9));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, string3);
        intent.putExtra(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, string);
        activity.startActivityForResult(intent, 7);
    }

    static long m885a(String str) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date parse = simpleDateFormat.parse(str);
        System.out.println(parse);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat();
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        return DateFormat.getInstance().parse(simpleDateFormat2.format(parse)).getTime();
    }
}
