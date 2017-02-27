package com.google.android.gms.internal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.HashMap;
import java.util.Map;

public final class ah {
    public static final ai eA;
    public static final ai eB;
    public static final ai eC;
    public static final ai eD;
    public static final ai eE;
    public static final ai eF;
    public static final ai eG;
    public static final ai eH;
    public static final ai ez;

    /* renamed from: com.google.android.gms.internal.ah.1 */
    static class C03721 implements ai {
        C03721() {
        }

        public void m1133a(cq cqVar, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (str == null) {
                cn.m299q("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = cqVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), AccessibilityNodeInfoCompat.ACTION_CUT) != null));
            }
            cqVar.m306a("openableURLs", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.internal.ah.2 */
    static class C03732 implements ai {
        C03732() {
        }

        public void m1134a(cq cqVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                cn.m299q("URL missing from click GMSG.");
                return;
            }
            Uri a;
            Uri parse = Uri.parse(str);
            try {
                C0152h ax = cqVar.ax();
                if (ax != null && ax.m665a(parse)) {
                    a = ax.m663a(parse, cqVar.getContext());
                    new cl(cqVar.getContext(), cqVar.ay().hP, a.toString()).start();
                }
            } catch (C0153i e) {
                cn.m299q("Unable to append parameter to URL: " + str);
            }
            a = parse;
            new cl(cqVar.getContext(), cqVar.ay().hP, a.toString()).start();
        }
    }

    /* renamed from: com.google.android.gms.internal.ah.3 */
    static class C03743 implements ai {
        C03743() {
        }

        public void m1135a(cq cqVar, Map<String, String> map) {
            bf au = cqVar.au();
            if (au == null) {
                cn.m299q("A GMSG tried to close something that wasn't an overlay.");
            } else {
                au.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ah.4 */
    static class C03754 implements ai {
        C03754() {
        }

        public void m1136a(cq cqVar, Map<String, String> map) {
            bf au = cqVar.au();
            if (au == null) {
                cn.m299q("A GMSG tried to use a custom close button on something that wasn't an overlay.");
            } else {
                au.m1801d("1".equals(map.get("custom_close")));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ah.5 */
    static class C03765 implements ai {
        C03765() {
        }

        public void m1137a(cq cqVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                cn.m299q("URL missing from httpTrack GMSG.");
            } else {
                new cl(cqVar.getContext(), cqVar.ay().hP, str).start();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ah.6 */
    static class C03776 implements ai {
        C03776() {
        }

        public void m1138a(cq cqVar, Map<String, String> map) {
            cn.m297o("Received log message: " + ((String) map.get("string")));
        }
    }

    /* renamed from: com.google.android.gms.internal.ah.7 */
    static class C03787 implements ai {
        C03787() {
        }

        public void m1139a(cq cqVar, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                C0152h ax = cqVar.ax();
                if (ax != null) {
                    ax.m666g().m337a(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                cn.m299q("Could not parse touch parameters from gmsg.");
            }
        }
    }

    static {
        ez = new C03721();
        eA = new C03732();
        eB = new C03743();
        eC = new C03754();
        eD = new C03765();
        eE = new C03776();
        eF = new aj();
        eG = new C03787();
        eH = new ak();
    }
}
