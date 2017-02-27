package com.sxnyodot.uefqvmio207964;

import android.util.Log;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

class XmlParser implements C0304k {
    private String f559a;
    private String f560b;
    private String f561c;
    private String f562d;
    private String f563e;
    private String f564f;
    private String f565g;
    private List<HashMap<String, String>> f566h;
    private String f567i;
    private String f568j;
    private String f569k;
    private String f570l;
    private HashMap<String, String> f571m;
    private String f572n;
    private List<Creative> f573o;

    public class Creative {
        final /* synthetic */ XmlParser f351a;
        private boolean f352b;
        private String f353c;
        private String f354d;
        private String f355e;
        private String f356f;
        private String f357g;
        private List<HashMap<String, Object>> f358h;
        private HashMap<String, Set<String>> f359i;
        private String f360j;
        private String f361k;
        private List<HashMap<String, String>> f362l;
        private List<HashMap<String, String>> f363m;
        private List<HashMap<String, Object>> f364n;

        public Creative(XmlParser xmlParser, XmlPullParser parser) throws XmlPullParserException, Exception, Throwable {
            this.f351a = xmlParser;
            xmlParser.m1671a((CharSequence) "Parsing Creative data");
            parser.require(2, xmlParser.f559a, C0304k.CREATIVE);
            this.f354d = parser.getAttributeValue(xmlParser.f559a, C0304k.ID);
            this.f355e = parser.getAttributeValue(xmlParser.f559a, C0304k.SEQUENCE);
            this.f356f = parser.getAttributeValue(xmlParser.f559a, C0304k.AD_ID);
            while (parser.next() != 3) {
                if (parser.getEventType() == 2) {
                    String name = parser.getName();
                    xmlParser.m1671a("Creative Name: " + name);
                    if (parser.isEmptyElementTag()) {
                        xmlParser.m1671a("Empty tag in creative: " + name);
                        parser.nextTag();
                    } else if (parser.getName().equals(C0304k.LINEAR)) {
                        name = parser.getAttributeValue(xmlParser.f559a, C0304k.SKIP_OFF_SET);
                        if (name == null) {
                            this.f352b = false;
                            xmlParser.m1671a("AdSkipable: " + this.f352b);
                        } else {
                            this.f352b = true;
                            this.f353c = name;
                            xmlParser.m1671a("AdSkipable: " + this.f352b + ", Skip offset: " + this.f353c);
                        }
                    } else if (name.equals(C0304k.ICON)) {
                        if (this.f358h == null) {
                            this.f358h = new ArrayList();
                        }
                        HashMap hashMap = new HashMap();
                        int a = m1000a(parser.getAttributeValue(xmlParser.f559a, IM.WIDTH));
                        r5 = m1000a(parser.getAttributeValue(xmlParser.f559a, IM.HEIGHT));
                        String attributeValue = parser.getAttributeValue(xmlParser.f559a, C0304k.PROGRAM);
                        String attributeValue2 = parser.getAttributeValue(xmlParser.f559a, C0304k.X_POSITION);
                        String attributeValue3 = parser.getAttributeValue(xmlParser.f559a, C0304k.Y_POSITION);
                        String attributeValue4 = parser.getAttributeValue(xmlParser.f559a, C0304k.DURATION);
                        r10 = parser.getAttributeValue(xmlParser.f559a, C0304k.MEDIA_FILE_API_FRAMEWORK);
                        r11 = parser.getAttributeValue(xmlParser.f559a, C0304k.OFFSET);
                        xmlParser.m1671a("ICON: width: " + a + ", height: " + r5 + ", program: " + attributeValue + ", xPosition: " + attributeValue2 + ", duration:" + attributeValue4 + ", apiFramework:" + r10 + ", offset:" + r11);
                        hashMap.put(IM.WIDTH, Integer.valueOf(a));
                        hashMap.put(IM.HEIGHT, Integer.valueOf(r5));
                        hashMap.put(C0304k.PROGRAM, attributeValue);
                        hashMap.put(C0304k.X_POSITION, attributeValue2);
                        hashMap.put(C0304k.Y_POSITION, attributeValue3);
                        hashMap.put(C0304k.MEDIA_FILE_API_FRAMEWORK, r10);
                        hashMap.put(C0304k.DURATION, attributeValue4);
                        hashMap.put(C0304k.OFFSET, r11);
                        while (parser.next() != 3) {
                            if (parser.getEventType() == 2) {
                                r4 = parser.getName();
                                xmlParser.m1671a("Icon Name: " + name);
                                if (parser.isEmptyElementTag()) {
                                    xmlParser.m1671a("Empty tag in creative: " + name);
                                    parser.nextTag();
                                } else if (r4.equals(C0304k.STATIC_RESOURCE)) {
                                    r4 = parser.getAttributeValue(xmlParser.f559a, C0304k.CREATIVE_TYPE);
                                    String a2 = xmlParser.m1669a(parser);
                                    hashMap.put(C0304k.CREATIVE_TYPE, r4);
                                    hashMap.put(C0304k.STATIC_RESOURCE, a2);
                                    xmlParser.m1671a("Creative type:" + r4 + ", Static res: " + a2);
                                } else if (r4.equals(C0304k.ICON_CLICK_THROUGH)) {
                                    r4 = xmlParser.m1669a(parser);
                                    hashMap.put(C0304k.ICON_CLICK_THROUGH, r4);
                                    xmlParser.m1671a("Icon click through: " + r4);
                                    parser.nextTag();
                                } else if (r4.equals(C0304k.ICON_CLICK_TRACKING)) {
                                    r4 = xmlParser.m1669a(parser);
                                    hashMap.put(C0304k.ICON_CLICK_TRACKING, r4);
                                    xmlParser.m1671a("IconClickTracking: " + r4);
                                } else if (r4.equals(C0304k.ICON_VIEW_TRACKING)) {
                                    r4 = xmlParser.m1669a(parser);
                                    hashMap.put(C0304k.ICON_VIEW_TRACKING, r4);
                                    xmlParser.m1671a("IconViewTracking: " + r4);
                                }
                            }
                        }
                        this.f358h.add(hashMap);
                        parser.nextTag();
                    } else if (name.equals(C0304k.DURATION)) {
                        this.f357g = xmlParser.m1669a(parser);
                        xmlParser.m1671a("Duration: " + this.f357g);
                    } else if (name.equals(C0304k.TRACKING_EVENTS)) {
                        xmlParser.m1671a((CharSequence) "inside tracking event.");
                        while (parser.next() != 3) {
                            if (parser.getEventType() == 2) {
                                name = parser.getName();
                                if (parser.isEmptyElementTag()) {
                                    xmlParser.m1671a("Empty tag in tracking: " + name);
                                    parser.nextTag();
                                } else if (name.equals(C0304k.TRACKING)) {
                                    if (this.f359i == null) {
                                        this.f359i = new HashMap();
                                    }
                                    name = parser.getAttributeValue(xmlParser.f559a, C0304k.EVENT);
                                    r3 = xmlParser.m1669a(parser);
                                    xmlParser.m1671a("Tracking event: " + name + ", url: " + r3);
                                    if (this.f359i.containsKey(name)) {
                                        ((Set) this.f359i.get(name)).add(r3);
                                    } else {
                                        Set hashSet = new HashSet();
                                        hashSet.add(r3);
                                        this.f359i.put(name, hashSet);
                                    }
                                }
                            }
                        }
                    } else if (name.equals(C0304k.AD_PARAMETERS)) {
                        this.f360j = xmlParser.m1669a(parser);
                        xmlParser.m1671a("AdParameters: " + this.f360j);
                    } else if (name.equals(C0304k.VIDEO_CLICKS)) {
                        while (parser.next() != 3) {
                            if (parser.getEventType() == 2) {
                                name = parser.getName();
                                if (parser.isEmptyElementTag()) {
                                    xmlParser.m1671a("Empty tag in creative: " + name);
                                    parser.nextTag();
                                } else if (name.equals(C0304k.CLICK_THROUGH)) {
                                    this.f361k = xmlParser.m1669a(parser);
                                    xmlParser.m1671a("Video click through url: " + this.f361k);
                                } else if (name.equals(C0304k.CLICK_TRACKING)) {
                                    r2 = new HashMap();
                                    r3 = parser.getAttributeValue(xmlParser.f559a, C0304k.ID);
                                    r4 = xmlParser.m1669a(parser);
                                    r2.put(C0304k.ID, r3);
                                    r2.put(C0304k.CLICK_TRACKING, r4);
                                    if (this.f362l == null) {
                                        this.f362l = new ArrayList();
                                    }
                                    this.f362l.add(r2);
                                    xmlParser.m1671a("Video click tracking ID: " + r3 + ", url: " + r4);
                                } else if (name.equals(C0304k.CUSTOM_CLICK)) {
                                    r2 = new HashMap();
                                    r3 = parser.getAttributeValue(xmlParser.f559a, C0304k.ID);
                                    r4 = xmlParser.m1669a(parser);
                                    r2.put(C0304k.ID, r3);
                                    r2.put(C0304k.CUSTOM_CLICK, r4);
                                    if (this.f363m == null) {
                                        this.f363m = new ArrayList();
                                    }
                                    this.f363m.add(r2);
                                    xmlParser.m1671a("Video Custom click tracking ID: " + r3 + ", url: " + r4);
                                }
                            }
                        }
                    } else if (name.equals(C0304k.MEDIA_FILES)) {
                        while (parser.next() != 3) {
                            if (parser.getEventType() == 2) {
                                name = parser.getName();
                                if (parser.isEmptyElementTag()) {
                                    xmlParser.m1671a("Empty tag in media: " + name);
                                    parser.nextTag();
                                } else if (name.equals(C0304k.MEDIA_FILE)) {
                                    name = parser.getAttributeValue(xmlParser.f559a, C0304k.ID);
                                    r3 = parser.getAttributeValue(xmlParser.f559a, C0304k.MEDIA_FILE_DELIVERY);
                                    r4 = parser.getAttributeValue(xmlParser.f559a, C0304k.MEDIA_FILE_TYPE);
                                    r5 = m1000a(parser.getAttributeValue(xmlParser.f559a, C0304k.MEDIA_FILE_BIT_RATE));
                                    int a3 = m1000a(parser.getAttributeValue(xmlParser.f559a, IM.WIDTH));
                                    int a4 = m1000a(parser.getAttributeValue(xmlParser.f559a, IM.HEIGHT));
                                    boolean parseBoolean = Boolean.parseBoolean(parser.getAttributeValue(xmlParser.f559a, C0304k.MEDIA_FILE_SCALABLE));
                                    boolean parseBoolean2 = Boolean.parseBoolean(parser.getAttributeValue(xmlParser.f559a, C0304k.MEDIA_FILE_MAINTAIN_ASPECT_RATIO));
                                    r10 = parser.getAttributeValue(xmlParser.f559a, C0304k.MEDIA_FILE_API_FRAMEWORK);
                                    r11 = parser.getAttributeValue(xmlParser.f559a, C0304k.MEDIA_FILE_CODEC);
                                    int a5 = m1000a(parser.getAttributeValue(xmlParser.f559a, C0304k.MEDIA_FILE_MAX_BITRATE));
                                    int a6 = m1000a(parser.getAttributeValue(xmlParser.f559a, C0304k.MEDIA_FILE_MIN_BITRATE));
                                    String a7 = xmlParser.m1669a(parser);
                                    xmlParser.m1671a("Media id: " + name + ", delivery: " + r3 + ", type: " + r4 + ", bitrate: " + r5 + ", width: " + a3 + ", height: " + a4 + ", scalable: " + parseBoolean + ", aspect ratio: " + parseBoolean2 + ", apiFrameowrk: " + r10 + ", codec: " + r11 + ", maxBitrate: " + a5 + ", minBitrate: " + a6 + ", URI: " + a7);
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put(C0304k.ID, name);
                                    hashMap2.put(C0304k.MEDIA_FILE_DELIVERY, r3);
                                    hashMap2.put(C0304k.MEDIA_FILE_TYPE, r4);
                                    hashMap2.put(C0304k.MEDIA_FILE_BIT_RATE, Integer.valueOf(r5));
                                    hashMap2.put(IM.WIDTH, Integer.valueOf(a3));
                                    hashMap2.put(IM.HEIGHT, Integer.valueOf(a4));
                                    hashMap2.put(C0304k.MEDIA_FILE_SCALABLE, Boolean.valueOf(parseBoolean));
                                    hashMap2.put(C0304k.MEDIA_FILE_MAINTAIN_ASPECT_RATIO, Boolean.valueOf(parseBoolean2));
                                    hashMap2.put(C0304k.MEDIA_FILE_API_FRAMEWORK, r10);
                                    hashMap2.put(C0304k.MEDIA_FILE_CODEC, r11);
                                    hashMap2.put(C0304k.MEDIA_FILE_MAX_BITRATE, Integer.valueOf(a5));
                                    hashMap2.put(C0304k.MEDIA_FILE_MIN_BITRATE, Integer.valueOf(a6));
                                    hashMap2.put(C0304k.MEDIA_FILE, a7);
                                    if (this.f364n == null) {
                                        this.f364n = new ArrayList();
                                    }
                                    this.f364n.add(hashMap2);
                                }
                            }
                        }
                    }
                }
            }
        }

        public boolean isAdLinearSkipable() {
            return this.f352b;
        }

        public String getSkipOffSet() {
            return this.f353c;
        }

        public String getId() {
            return this.f354d;
        }

        public String getSequence() {
            return this.f355e;
        }

        public String getCreativeAdId() {
            return this.f356f;
        }

        public String getDuration() {
            return this.f357g;
        }

        public List<HashMap<String, Object>> getIcons() {
            return this.f358h;
        }

        public HashMap<String, Set<String>> getTrackingEventMap() {
            return this.f359i;
        }

        public String getAdParams() {
            return this.f360j;
        }

        public String getVideoClickThrough() {
            return this.f361k;
        }

        public List<HashMap<String, String>> getVideoClickTracking() {
            return this.f362l;
        }

        public List<HashMap<String, String>> getVideoCustomClickTracking() {
            return this.f363m;
        }

        public List<HashMap<String, Object>> getMediaFiles() {
            return this.f364n;
        }

        private int m1000a(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return 0;
            } catch (Exception e2) {
                return 0;
            }
        }
    }

    public static class InvalidVastXML extends IOException {
        private static final long serialVersionUID = 1;

        public InvalidVastXML(String message) {
            super(message);
        }
    }

    public static class VastException extends IOException {
        private static final long serialVersionUID = 1;
        private int f365a;

        public VastException(String message, String code) {
            super(message);
            try {
                this.f365a = Integer.parseInt(code);
            } catch (NumberFormatException e) {
            }
        }

        public int getCode() {
            return this.f365a;
        }
    }

    void m1671a(CharSequence charSequence) {
    }

    public XmlParser(Reader reader) throws VastException, InvalidVastXML, XmlPullParserException, Exception, Throwable {
        this.f559a = null;
        Log.i(C0304k.TAG, "Parsing vast Xml>>>>>>>..");
        this.f573o = new ArrayList();
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        XmlPullParser newPullParser = newInstance.newPullParser();
        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        newPullParser.setInput(reader);
        newPullParser.nextTag();
        newPullParser.require(2, this.f559a, C0304k.VAST);
        this.f561c = newPullParser.getAttributeValue(this.f559a, C0304k.VERSION);
        Log.i(C0304k.TAG, "Vast version: " + this.f561c);
        newPullParser.nextTag();
        String name = newPullParser.getName();
        if (name.equals(C0304k.ERROR)) {
            name = newPullParser.getAttributeValue(this.f559a, "status");
            String a = m1669a(newPullParser);
            m1671a("Status: " + name + " Error: " + a);
            throw new VastException(a, name);
        } else if (name.equals(C0304k.AD)) {
            m1671a((CharSequence) "Inside ad tag");
            this.f560b = newPullParser.getAttributeValue(this.f559a, C0304k.ID);
            while (newPullParser.next() != 3) {
                if (newPullParser.getEventType() == 2) {
                    name = newPullParser.getName();
                    if (newPullParser.isEmptyElementTag()) {
                        m1671a("Empty Tag: " + name);
                        newPullParser.nextTag();
                    } else if (name.equals(C0304k.ERROR)) {
                        this.f570l = m1669a(newPullParser);
                        m1671a("Ad Error: " + this.f570l);
                    } else if (name.equals(C0304k.AD_SYSTEM)) {
                        this.f563e = newPullParser.getAttributeValue(this.f559a, C0304k.VERSION);
                        this.f562d = m1669a(newPullParser);
                        m1671a("AdSytem version: " + this.f563e + ", name: " + this.f562d);
                    } else if (name.equals(C0304k.AD_TITLE)) {
                        this.f564f = m1669a(newPullParser);
                        m1671a("Ad title: " + this.f564f);
                    } else if (name.equals(C0304k.DESCRIPTION)) {
                        this.f567i = m1669a(newPullParser);
                        m1671a("Desc :" + this.f567i);
                    } else if (name.equals(C0304k.ADVERTISER)) {
                        this.f568j = m1669a(newPullParser);
                        m1671a("Advertise name: " + this.f568j);
                    } else if (name.equals(C0304k.SURVEY)) {
                        this.f569k = m1669a(newPullParser);
                        m1671a("Survey URI: " + this.f569k);
                    } else if (name.equals(C0304k.PRICING)) {
                        this.f571m = new HashMap();
                        name = newPullParser.getAttributeValue(this.f559a, C0304k.PRICING_MODEL);
                        r2 = newPullParser.getAttributeValue(this.f559a, C0304k.PRICING_CURRENCY);
                        r3 = m1669a(newPullParser);
                        this.f571m.put(C0304k.PRICING_MODEL, name);
                        this.f571m.put(C0304k.PRICING_CURRENCY, r2);
                        this.f571m.put(C0304k.PRICING, r3);
                        m1671a("model: " + name + ", cur: " + r2 + ", price: " + r3);
                    } else if (name.equals(C0304k.IMPRESSION)) {
                        if (this.f566h == null) {
                            this.f566h = new ArrayList();
                        }
                        HashMap hashMap = new HashMap();
                        r2 = newPullParser.getAttributeValue(this.f559a, C0304k.ID);
                        r3 = m1669a(newPullParser);
                        hashMap.put(C0304k.ID, r2);
                        hashMap.put(C0304k.IMPRESSION, r3);
                        this.f566h.add(hashMap);
                        m1671a("Impression Id: " + r2 + ", uri: " + r3);
                    } else if (name.equals(C0304k.CREATIVE)) {
                        this.f573o.add(new Creative(this, newPullParser));
                    }
                }
            }
        } else {
            throw new InvalidVastXML("Invalid vast XMl");
        }
    }

    private String m1669a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String nextText;
        synchronized (xmlPullParser) {
            nextText = xmlPullParser.nextText();
            if (xmlPullParser.getEventType() != 3) {
                xmlPullParser.nextTag();
            }
        }
        return nextText;
    }

    public String m1670a() {
        return this.f561c;
    }

    public String m1672b() {
        return this.f562d;
    }

    public String m1673c() {
        return this.f563e;
    }

    public String m1674d() {
        return this.f565g;
    }

    public String m1675e() {
        return this.f564f;
    }

    public List<HashMap<String, String>> m1676f() {
        return this.f566h;
    }

    public String m1677g() {
        return this.f567i;
    }

    public String m1678h() {
        return this.f568j;
    }

    public String m1679i() {
        return this.f569k;
    }

    public String m1680j() {
        return this.f570l;
    }

    public HashMap<String, String> m1681k() {
        return this.f571m;
    }

    public String m1682l() {
        return this.f572n;
    }

    public List<Creative> m1683m() {
        return this.f573o;
    }

    public String m1684n() {
        return this.f560b;
    }

    public String m1685o() {
        return this.f569k;
    }
}
