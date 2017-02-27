package com.sxnyodot.uefqvmio207964;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.VideoView;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.sxnyodot.uefqvmio207964.AdListener.AdType;
import com.sxnyodot.uefqvmio207964.C0326u.C0325a;
import com.sxnyodot.uefqvmio207964.XmlParser.Creative;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class VDActivity extends C0326u implements OnCompletionListener, OnErrorListener, OnPreparedListener, OnClickListener {
    static final String ACTION_PLAY = "play_video";
    private static final int ID_AD_INFO_TEXT_VIEW = 106;
    private static final int ID_AD_PROGRESS_TEXT = 111;
    private static final int ID_ICON_IMAGE_VIEW = 102;
    private static final int ID_MUTE_BUTTON = 112;
    private static final int ID_PLAY_BUTTON = 107;
    private static final int ID_SEEK_BAR = 109;
    private static final int ID_SKIP_BUTTON = 110;
    private static final int ID_VIDEO_PLAYER = 108;
    private boolean f537A;
    private Creative f538B;
    private Uri f539C;
    private ProgressBar f540D;
    private TextView f541E;
    private Button f542F;
    private ImageButton f543G;
    private ImageButton f544H;
    private boolean f545I;
    private int f546J;
    private boolean f547K;
    private int f548L;
    private int f549M;
    private int f550N;
    private int f551O;
    Handler f552a;
    OnTouchListener f553b;
    Runnable f554c;
    private final String f555w;
    private ProgressDialog f556x;
    private XmlParser f557y;
    private VideoView f558z;

    /* renamed from: com.sxnyodot.uefqvmio207964.VDActivity.1 */
    class C02841 implements OnTouchListener {
        final /* synthetic */ VDActivity f332a;

        C02841(VDActivity vDActivity) {
            this.f332a = vDActivity;
        }

        public boolean onTouch(View v, MotionEvent event) {
            try {
                if (v == this.f332a.f558z && event.getAction() == 0) {
                    String videoClickThrough = this.f332a.f538B.getVideoClickThrough();
                    if (!(videoClickThrough == null || videoClickThrough.equals(""))) {
                        this.f332a.m1663a(videoClickThrough);
                        this.f332a.f537A = false;
                        this.f332a.f558z.stopPlayback();
                        this.f332a.finish();
                        return true;
                    }
                }
            } catch (Throwable e) {
                e.printStackTrace();
                Log.e(C0304k.TAG, "Error occured while on video click", e);
                this.f332a.f537A = true;
                this.f332a.m1660a(this.f332a.u);
            }
            return false;
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.VDActivity.2 */
    class C02852 implements Runnable {
        final /* synthetic */ VDActivity f333a;

        C02852(VDActivity vDActivity) {
            this.f333a = vDActivity;
        }

        public void run() {
            this.f333a.m1656e(this.f333a.f545I);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.VDActivity.3 */
    class C02863 implements Runnable {
        final /* synthetic */ VDActivity f334a;

        C02863(VDActivity vDActivity) {
            this.f334a = vDActivity;
        }

        public void run() {
            VU.m999a(new File(Environment.getExternalStorageDirectory(), "ap_video"));
        }
    }

    private class VpaidLayout extends RelativeLayout implements C0304k {
        final /* synthetic */ VDActivity f534a;
        private final float f535b;
        private Context f536c;

        /* renamed from: com.sxnyodot.uefqvmio207964.VDActivity.VpaidLayout.1 */
        class C02881 implements Runnable {
            final /* synthetic */ VDActivity f336a;
            final /* synthetic */ ImageView f337b;
            final /* synthetic */ String f338c;
            final /* synthetic */ VpaidLayout f339d;

            /* renamed from: com.sxnyodot.uefqvmio207964.VDActivity.VpaidLayout.1.1 */
            class C02871 implements Runnable {
                final /* synthetic */ C02881 f335a;

                C02871(C02881 c02881) {
                    this.f335a = c02881;
                }

                public void run() {
                    this.f335a.f337b.setVisibility(8);
                }
            }

            C02881(VpaidLayout vpaidLayout, VDActivity vDActivity, ImageView imageView, String str) {
                this.f339d = vpaidLayout;
                this.f336a = vDActivity;
                this.f337b = imageView;
                this.f338c = str;
            }

            public void run() {
                this.f337b.setVisibility(0);
                Runnable c02871 = new C02871(this);
                if (this.f338c != null && this.f338c.contains(":")) {
                    try {
                        this.f339d.f534a.f552a.postDelayed(c02871, VU.m997a(this.f338c));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } catch (NullPointerException e2) {
                        e2.printStackTrace();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }

        /* renamed from: com.sxnyodot.uefqvmio207964.VDActivity.VpaidLayout.2 */
        class C05542 implements C0293b<Bitmap> {
            final /* synthetic */ ImageView f531a;
            final /* synthetic */ String f532b;
            final /* synthetic */ VpaidLayout f533c;

            /* renamed from: com.sxnyodot.uefqvmio207964.VDActivity.VpaidLayout.2.1 */
            class C02891 implements Runnable {
                final /* synthetic */ Bitmap f340a;
                final /* synthetic */ C05542 f341b;

                C02891(C05542 c05542, Bitmap bitmap) {
                    this.f341b = c05542;
                    this.f340a = bitmap;
                }

                public void run() {
                    this.f341b.f531a.setImageBitmap(this.f340a);
                }
            }

            C05542(VpaidLayout vpaidLayout, ImageView imageView, String str) {
                this.f533c = vpaidLayout;
                this.f531a = imageView;
                this.f532b = str;
            }

            public void m1647a(Bitmap bitmap) {
                if (bitmap != null && this.f533c.f534a.f552a != null) {
                    this.f533c.f534a.f552a.post(new C02891(this, bitmap));
                }
            }

            public void m1646a() {
                new C0303j(this.f532b, this).execute(new Void[0]);
            }
        }

        @SuppressLint({"InlinedApi"})
        public VpaidLayout(VDActivity vDActivity, Activity context) throws NullPointerException, Exception {
            String str;
            this.f534a = vDActivity;
            super(context);
            this.f536c = context;
            this.f535b = context.getResources().getDisplayMetrics().density;
            setLayoutParams(new LayoutParams(-1, -1));
            Creative creative = (Creative) vDActivity.f557y.m1683m().get(0);
            View imageView = new ImageView(context);
            imageView.setId(VDActivity.ID_ICON_IMAGE_VIEW);
            try {
                List icons = creative.getIcons();
                if (icons == null || icons.isEmpty()) {
                    Util.m929a("hashmap empty");
                }
                HashMap hashMap = (HashMap) icons.get(0);
                if (hashMap.isEmpty()) {
                    Util.m929a("hash map");
                }
                int intValue = ((Integer) hashMap.get(IM.WIDTH)).intValue();
                int intValue2 = ((Integer) hashMap.get(IM.HEIGHT)).intValue();
                System.out.println("width: " + intValue);
                String obj = hashMap.get(C0304k.X_POSITION).toString();
                String obj2 = hashMap.get(C0304k.Y_POSITION).toString();
                String obj3 = hashMap.containsKey(C0304k.OFFSET) ? null : hashMap.get(C0304k.OFFSET).toString();
                if (hashMap.containsKey(C0304k.DURATION)) {
                    str = null;
                } else {
                    str = hashMap.get(C0304k.DURATION).toString();
                }
                String obj4 = hashMap.get(C0304k.STATIC_RESOURCE).toString();
                System.out.println("icon url: " + obj4);
                m1649a(obj4, imageView);
                if (obj3 != null && obj3.contains(":")) {
                    vDActivity.f552a.postDelayed(new C02881(this, vDActivity, imageView, str), VU.m997a(obj3));
                }
                ViewGroup.LayoutParams layoutParams = new LayoutParams(intValue, intValue2);
                if (obj.equals("left")) {
                    layoutParams.addRule(9);
                } else if (obj.equals("right")) {
                    layoutParams.addRule(11);
                } else {
                    try {
                        layoutParams.leftMargin = (int) Util.m935b(Float.parseFloat(obj), context);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (obj2.equals("top")) {
                    layoutParams.addRule(10);
                } else if (obj2.equals("bottom")) {
                    layoutParams.addRule(12);
                } else {
                    try {
                        layoutParams.topMargin = (int) Util.m935b(Float.parseFloat(obj2), context);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                imageView.setLayoutParams(layoutParams);
            } catch (Exception e3) {
                Util.m929a("Icon not present");
            }
            StringBuilder stringBuilder = new StringBuilder();
            str = vDActivity.f557y.m1675e();
            if (!(str == null || str.equals(""))) {
                stringBuilder.append(vDActivity.f557y.m1675e() + " ");
            }
            if (!(vDActivity.f557y.m1677g() == null || vDActivity.f557y.m1677g().equals(""))) {
                stringBuilder.append(vDActivity.f557y.m1677g());
            }
            str = vDActivity.f557y.m1678h();
            if (!(str == null || str.equals(""))) {
                stringBuilder.append(" - by " + str);
            }
            View textView = new TextView(context);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
            layoutParams2.addRule(1, VDActivity.ID_ICON_IMAGE_VIEW);
            layoutParams2.addRule(10);
            layoutParams2.leftMargin = (int) (10.0f * this.f535b);
            textView.setLayoutParams(layoutParams2);
            textView.setId(VDActivity.ID_AD_INFO_TEXT_VIEW);
            textView.setSingleLine();
            textView.setTextAppearance(context, 16973892);
            textView.setText(stringBuilder.toString());
            View videoView = new VideoView(context);
            videoView.setId(VDActivity.ID_VIDEO_PLAYER);
            ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-2, -2);
            if (VERSION.SDK_INT > 17) {
                layoutParams3 = new LayoutParams(-1, -1);
            }
            layoutParams3.bottomMargin = (int) (this.f535b * 17.0f);
            layoutParams3.topMargin = (int) (this.f535b * 17.0f);
            layoutParams3.rightMargin = (int) (this.f535b * BitmapDescriptorFactory.HUE_ORANGE);
            layoutParams3.leftMargin = (int) (this.f535b * BitmapDescriptorFactory.HUE_ORANGE);
            layoutParams3.addRule(13, -1);
            videoView.setLayoutParams(layoutParams3);
            View button = new Button(context);
            button.setId(VDActivity.ID_SKIP_BUTTON);
            ViewGroup.LayoutParams layoutParams4 = new LayoutParams(-2, -2);
            layoutParams4.addRule(11);
            layoutParams4.addRule(12);
            layoutParams4.bottomMargin = (int) (35.0f * this.f535b);
            button.setLayoutParams(layoutParams4);
            button.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            button.setTextColor(-1);
            button.setTypeface(Typeface.MONOSPACE, 16973892);
            button.setClickable(false);
            button.setVisibility(8);
            View imageButton = new ImageButton(context);
            imageButton.setId(VDActivity.ID_PLAY_BUTTON);
            ViewGroup.LayoutParams layoutParams5 = new LayoutParams(-2, -2);
            layoutParams5.addRule(12);
            layoutParams5.addRule(9);
            imageButton.setLayoutParams(layoutParams5);
            imageButton.setBackgroundResource(17301539);
            View imageButton2 = new ImageButton(context);
            imageButton2.setId(VDActivity.ID_MUTE_BUTTON);
            ViewGroup.LayoutParams layoutParams6 = new LayoutParams(-2, -2);
            layoutParams6.addRule(12);
            layoutParams6.addRule(1, VDActivity.ID_PLAY_BUTTON);
            imageButton2.setLayoutParams(layoutParams6);
            imageButton2.setBackgroundResource(17301554);
            View progressBar = new ProgressBar(context, null, 16842872);
            ViewGroup.LayoutParams layoutParams7 = new LayoutParams(-1, (int) (10.0f * this.f535b));
            layoutParams7.addRule(12);
            layoutParams7.addRule(1, VDActivity.ID_MUTE_BUTTON);
            layoutParams7.setMargins(((int) this.f535b) * 5, 0, ((int) this.f535b) * 65, (int) (this.f535b * 7.0f));
            progressBar.setLayoutParams(layoutParams7);
            progressBar.setId(VDActivity.ID_SEEK_BAR);
            View textView2 = new TextView(context);
            ViewGroup.LayoutParams layoutParams8 = new LayoutParams(-2, -2);
            layoutParams8.addRule(11);
            layoutParams8.addRule(12);
            textView2.setLayoutParams(layoutParams8);
            textView2.setTextColor(-1);
            textView2.setTextAppearance(context, 16973894);
            textView2.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            textView2.setId(VDActivity.ID_AD_PROGRESS_TEXT);
            addView(videoView);
            addView(imageView);
            addView(textView);
            addView(imageButton);
            addView(imageButton2);
            addView(progressBar);
            addView(button);
            addView(textView2);
        }

        void m1649a(String str, ImageView imageView) throws NullPointerException {
            C0293b c05542 = new C05542(this, imageView, str);
            if (Util.m977o(this.f536c)) {
                c05542.m1004a();
            }
        }
    }

    public VDActivity() {
        this.f555w = C0304k.TAG;
        this.f537A = true;
        this.f545I = true;
        this.f546J = 0;
        this.f547K = false;
        this.f553b = new C02841(this);
        this.f554c = new C02852(this);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f552a = new Handler();
        MainActivity.m919a(true);
        this.d = new HashSet();
        C0326u.m1050a((Context) this);
        getWindow().setFormat(-3);
        getWindow().addFlags(TransportMediator.FLAG_KEY_MEDIA_NEXT);
        try {
            m1070c(new WebView(this).getSettings().getUserAgentString());
            Intent intent = getIntent();
            if (intent.getAction().equals(ACTION_PLAY)) {
                this.f539C = intent.getData();
                Util.m929a("VideoAdActivty: url: " + this.f539C);
                setRequestedOrientation(0);
                requestWindowFeature(1);
                getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
                this.f556x = ProgressDialog.show(this, null, "Loading....");
                this.f557y = C0561t.m1759b();
                m1061a(this.f557y);
                m1062a(C0325a.AdImpression);
                List m = this.f557y.m1683m();
                if (m != null && m.size() > 0) {
                    this.f538B = (Creative) m.get(0);
                    m1060a(this.f538B);
                    HashMap hashMap = (HashMap) this.f538B.getMediaFiles().get(0);
                    int intValue = ((Integer) hashMap.get(C0304k.MEDIA_FILE_BIT_RATE)).intValue();
                    int intValue2 = ((Integer) hashMap.get(IM.WIDTH)).intValue();
                    int intValue3 = ((Integer) hashMap.get(IM.HEIGHT)).intValue();
                    Object obj = hashMap.get(C0304k.MEDIA_FILE_API_FRAMEWORK);
                    if (obj == null || obj.equals("VPAID")) {
                        m1662a(intValue2, intValue3, C0304k.EVENT_FULL_SCREEN, intValue, this.f538B.getAdParams(), null);
                        return;
                    }
                    Log.e(C0304k.TAG, "Invalid apiFramwork: " + obj);
                    m1080g(this.v);
                    return;
                }
                if (this.f556x != null) {
                    this.f556x.dismiss();
                }
                finish();
                return;
            }
            finish();
        } catch (Throwable e) {
            e.printStackTrace();
            Log.e(C0304k.TAG, "Excetion occurred in video ad.", e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m1662a(int r4, int r5, java.lang.String r6, int r7, java.lang.String r8, java.lang.String r9) {
        /*
        r3 = this;
        r0 = "audio";
        r0 = r3.getSystemService(r0);	 Catch:{ Exception -> 0x00ac }
        r0 = (android.media.AudioManager) r0;	 Catch:{ Exception -> 0x00ac }
        r1 = 3;
        r2 = 0;
        r0.setStreamMute(r1, r2);	 Catch:{ Exception -> 0x00ac }
    L_0x000d:
        r0 = new com.sxnyodot.uefqvmio207964.VDActivity$VpaidLayout;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0.<init>(r3, r3);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r3.setContentView(r0);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r0 = r3.findViewById(r0);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = (android.widget.TextView) r0;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r3.f541E = r0;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = 109; // 0x6d float:1.53E-43 double:5.4E-322;
        r0 = r3.findViewById(r0);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = (android.widget.ProgressBar) r0;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r3.f540D = r0;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        r0 = r3.findViewById(r0);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = (android.widget.VideoView) r0;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r3.f558z = r0;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r0 = r3.findViewById(r0);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = (android.widget.Button) r0;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r3.f542F = r0;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = r3.f542F;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0.setOnClickListener(r3);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        r0 = r3.findViewById(r0);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = (android.widget.ImageButton) r0;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r3.f543G = r0;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = r3.f543G;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0.setOnClickListener(r3);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r0 = r3.findViewById(r0);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = (android.widget.ImageButton) r0;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r3.f544H = r0;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = r3.f544H;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0.setOnClickListener(r3);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = r3.f558z;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r1 = r3.f539C;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0.setVideoURI(r1);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = r3.f558z;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r1 = r3.f553b;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0.setOnTouchListener(r1);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = r3.f558z;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0.setOnPreparedListener(r3);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = r3.f558z;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0.setOnCompletionListener(r3);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = r3.f558z;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0.setOnErrorListener(r3);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = r3.f558z;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0.requestFocus();	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = r3.f558z;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r1 = 1;
        r0.setKeepScreenOn(r1);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = 3;
        r3.setVolumeControlStream(r0);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = r3.f558z;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0.start();	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r0 = com.sxnyodot.uefqvmio207964.C0326u.C0325a.AdLoaded;	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
        r3.m1062a(r0);	 Catch:{ Exception -> 0x0097, Throwable -> 0x00a3 }
    L_0x0096:
        return;
    L_0x0097:
        r0 = move-exception;
        r1 = "PrmVast";
        r2 = "Exception occurred while initializing video";
        android.util.Log.e(r1, r2, r0);
    L_0x009f:
        r3.finish();
        goto L_0x0096;
    L_0x00a3:
        r0 = move-exception;
        r1 = "PrmVast";
        r2 = "Error occurred while initializing video";
        android.util.Log.e(r1, r2, r0);
        goto L_0x009f;
    L_0x00ac:
        r0 = move-exception;
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sxnyodot.uefqvmio207964.VDActivity.a(int, int, java.lang.String, int, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m1663a(java.lang.String r6) {
        /*
        r5 = this;
        r0 = "PrmVast";
        r1 = "Video clicked>>";
        android.util.Log.i(r0, r1);
        r0 = "com.android.browser";
        r1 = "com.android.browser.BrowserActivity";
        r2 = new android.content.Intent;	 Catch:{ ActivityNotFoundException -> 0x0031, Exception -> 0x0060 }
        r3 = "android.intent.action.VIEW";
        r4 = android.net.Uri.parse(r6);	 Catch:{ ActivityNotFoundException -> 0x0031, Exception -> 0x0060 }
        r2.<init>(r3, r4);	 Catch:{ ActivityNotFoundException -> 0x0031, Exception -> 0x0060 }
        r3 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r2.setFlags(r3);	 Catch:{ ActivityNotFoundException -> 0x0031, Exception -> 0x0060 }
        r3 = 8388608; // 0x800000 float:1.17549435E-38 double:4.144523E-317;
        r2.addFlags(r3);	 Catch:{ ActivityNotFoundException -> 0x0031, Exception -> 0x0060 }
        r3 = "android.intent.category.LAUNCHER";
        r2.addCategory(r3);	 Catch:{ ActivityNotFoundException -> 0x0031, Exception -> 0x0060 }
        r2.setClassName(r0, r1);	 Catch:{ ActivityNotFoundException -> 0x0031, Exception -> 0x0060 }
        r5.startActivity(r2);	 Catch:{ ActivityNotFoundException -> 0x0031, Exception -> 0x0060 }
        r0 = com.sxnyodot.uefqvmio207964.C0326u.C0325a.AdClickThru;	 Catch:{ ActivityNotFoundException -> 0x0031, Exception -> 0x0060 }
        r5.m1062a(r0);	 Catch:{ ActivityNotFoundException -> 0x0031, Exception -> 0x0060 }
    L_0x0030:
        return;
    L_0x0031:
        r0 = move-exception;
        r0 = "PrmVast";
        r1 = "Browser not found.";
        android.util.Log.i(r0, r1);	 Catch:{ ActivityNotFoundException -> 0x0057, Exception -> 0x0060 }
        r0 = new android.content.Intent;	 Catch:{ ActivityNotFoundException -> 0x0057, Exception -> 0x0060 }
        r1 = "android.intent.action.VIEW";
        r2 = android.net.Uri.parse(r6);	 Catch:{ ActivityNotFoundException -> 0x0057, Exception -> 0x0060 }
        r0.<init>(r1, r2);	 Catch:{ ActivityNotFoundException -> 0x0057, Exception -> 0x0060 }
        r1 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.setFlags(r1);	 Catch:{ ActivityNotFoundException -> 0x0057, Exception -> 0x0060 }
        r1 = 8388608; // 0x800000 float:1.17549435E-38 double:4.144523E-317;
        r0.addFlags(r1);	 Catch:{ ActivityNotFoundException -> 0x0057, Exception -> 0x0060 }
        r5.startActivity(r0);	 Catch:{ ActivityNotFoundException -> 0x0057, Exception -> 0x0060 }
        r0 = com.sxnyodot.uefqvmio207964.C0326u.C0325a.AdClickThru;	 Catch:{ ActivityNotFoundException -> 0x0057, Exception -> 0x0060 }
        r5.m1062a(r0);	 Catch:{ ActivityNotFoundException -> 0x0057, Exception -> 0x0060 }
        goto L_0x0030;
    L_0x0057:
        r0 = move-exception;
        r1 = "PrmVast";
        r2 = "Error occured whlie redirecting video ad......: ";
        android.util.Log.e(r1, r2, r0);
        goto L_0x0030;
    L_0x0060:
        r0 = move-exception;
        r1 = "PrmVast";
        r2 = "Error whlie displaying url......: ";
        android.util.Log.e(r1, r2, r0);
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sxnyodot.uefqvmio207964.VDActivity.a(java.lang.String):void");
    }

    void m1661a(int i, int i2, String str) {
    }

    public void onPrepared(MediaPlayer mp) {
        try {
            if (this.f556x != null) {
                this.f556x.dismiss();
            }
            this.f543G.setBackgroundResource(17301539);
            if (this.f538B.isAdLinearSkipable()) {
                String skipOffSet = this.f538B.getSkipOffSet();
                if (skipOffSet == null || skipOffSet.equals("") || skipOffSet.equals("0:0:0") || skipOffSet.equals("%")) {
                    this.f537A = true;
                    m1660a(this.e);
                    Log.e(C0304k.TAG, "Invalid skip offset: " + skipOffSet);
                } else if (skipOffSet.contains(":")) {
                    this.f546J = (int) (VU.m997a(skipOffSet) / 1000);
                    this.f542F.setText("Skip in " + this.f546J + "s");
                } else if (skipOffSet.contains("%")) {
                    this.f546J = ((Integer.parseInt(skipOffSet.replace("%", "")) * this.f558z.getDuration()) / 100) / LocationStatusCodes.GEOFENCE_NOT_AVAILABLE;
                    this.f542F.setText("Skip in " + this.f546J + " sec");
                } else {
                    this.f537A = true;
                    m1660a(this.e);
                    Log.e(C0304k.TAG, "Invalid skip offset: " + skipOffSet);
                }
            }
            m1659a();
        } catch (IllegalStateException e) {
            finish();
            e.printStackTrace();
        } catch (Exception e2) {
            finish();
        }
    }

    void m1659a() {
        if (Prm.adListener != null) {
            Prm.adListener.onSmartWallAdShowing();
        }
        try {
            if (this.f538B.isAdLinearSkipable()) {
                this.f542F.setVisibility(0);
                this.f542F.setEnabled(false);
            }
            this.f551O = this.f558z.getDuration();
            this.f540D.setMax(this.f551O);
            m1075e(this.f551O);
            m1657h(this.f551O / LocationStatusCodes.GEOFENCE_NOT_AVAILABLE);
            this.f545I = true;
            this.f552a.post(this.f554c);
            m1062a(C0325a.AdVideoStart);
        } catch (Throwable e) {
            Log.e(C0304k.TAG, "Exception occurred in start ad", e);
            finish();
            this.f537A = true;
            m1660a(this.t);
        } catch (Throwable e2) {
            Log.e(C0304k.TAG, "Error occurred in start ad", e2);
            this.f537A = true;
            m1660a(this.t);
        }
    }

    private void m1656e(boolean z) {
        try {
            if (this.f558z != null && z) {
                int currentPosition = this.f558z.getCurrentPosition() / LocationStatusCodes.GEOFENCE_NOT_AVAILABLE;
                int duration = this.f558z.getDuration() / LocationStatusCodes.GEOFENCE_NOT_AVAILABLE;
                if (currentPosition < duration) {
                    if (this.f538B.isAdLinearSkipable() && currentPosition < this.f546J) {
                        this.f542F.setText("Skip in " + ((long) (this.f546J - currentPosition)) + "s");
                    }
                    duration -= currentPosition;
                    this.f541E.setText("Ad: " + VU.m998a((long) duration));
                    if (this.f538B.isAdLinearSkipable() && this.f546J == currentPosition) {
                        this.f542F.setEnabled(true);
                        this.f542F.setText("Skip Ad");
                        this.f542F.setClickable(true);
                    }
                    m1073d(duration);
                    this.f540D.setProgress(this.f558z.getCurrentPosition());
                    this.f552a.postDelayed(this.f554c, 1000);
                    if (this.f548L == currentPosition) {
                        m1062a(C0325a.AdVideoFirstQuartile);
                    } else if (this.f549M == currentPosition) {
                        m1062a(C0325a.AdVideoMidpoint);
                    } else if (this.f550N == currentPosition) {
                        m1062a(C0325a.AdVideoThirdQuartile);
                    }
                }
            }
        } catch (Throwable e) {
            Log.e(C0304k.TAG, "Exception occurred in updatePlayer", e);
        } catch (Throwable e2) {
            Log.e(C0304k.TAG, "Error occurred in updatePlayer", e2);
        }
    }

    private void m1657h(int i) {
        this.f548L = (i * 25) / 100;
        this.f549M = (i * 50) / 100;
        this.f550N = (i * 75) / 100;
    }

    void m1664b() {
        try {
            if (this.f558z != null && this.f558z.isPlaying()) {
                this.f558z.pause();
                this.f545I = false;
                this.f543G.setBackgroundResource(17301540);
                this.f552a.removeCallbacks(this.f554c);
                m1062a(C0325a.AdPaused);
            }
        } catch (Throwable e) {
            this.f537A = true;
            m1660a(this.u);
            Log.e(C0304k.TAG, "Error occurred in pausing", e);
        }
    }

    void m1665c() {
        try {
            if (this.f558z != null && !this.f558z.isPlaying()) {
                this.f558z.start();
                this.f545I = true;
                this.f543G.setBackgroundResource(17301539);
                this.f552a.post(this.f554c);
                m1062a(C0325a.AdPlaying);
            }
        } catch (Throwable e) {
            this.f537A = true;
            m1660a(this.v);
            Log.e(C0304k.TAG, "Error occurred in resume", e);
        }
    }

    public void onCompletion(MediaPlayer mp) {
        try {
            if (this.f558z != null) {
                this.f558z.stopPlayback();
            }
            mp.release();
        } catch (Throwable e) {
            Log.e(C0304k.TAG, "Error occurred in onCompletion", e);
        }
        this.f537A = false;
        m1660a(this.v);
        m1658p();
    }

    void m1660a(int i) {
        if (this.f537A) {
            Log.e(C0304k.TAG, "Stopping ad. An error is occurred.");
            m1080g(i);
        } else {
            Log.i(C0304k.TAG, "Sending impression data>>");
            m1062a(C0325a.AdVideoComplete);
        }
        finish();
    }

    void m1666d() {
        this.f537A = false;
        m1062a(C0325a.AdSkipped);
        try {
            this.f558z.stopPlayback();
        } catch (Exception e) {
        }
        finish();
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        Log.e(C0304k.TAG, "An error occurred while playing ad video. Error code: " + what);
        this.f537A = true;
        m1660a(this.t);
        if (Prm.adListener != null) {
            C0558p.sendAdError("An error occurred while playing video.");
        }
        return true;
    }

    private void m1658p() {
        try {
            new Thread(new C02863(this), "delete").start();
        } catch (Throwable e) {
            Log.e(C0304k.TAG, "Not able to delete video.", e);
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case ID_PLAY_BUTTON /*107*/:
                if (this.f545I) {
                    m1664b();
                } else {
                    m1665c();
                }
            case ID_SKIP_BUTTON /*110*/:
                m1666d();
            case ID_MUTE_BUTTON /*112*/:
                if (this.f547K) {
                    ((AudioManager) getSystemService("audio")).setStreamMute(3, false);
                    this.f547K = false;
                    m1078f(1);
                    this.f544H.setBackgroundResource(17301554);
                } else {
                    ((AudioManager) getSystemService("audio")).setStreamMute(3, true);
                    this.f547K = true;
                    m1078f(0);
                    this.f544H.setBackgroundResource(17301553);
                }
                m1062a(C0325a.AdVolumeChange);
            default:
        }
    }

    public void onBackPressed() {
    }

    protected void onPause() {
        super.onPause();
        try {
            if (this.f558z.getCurrentPosition() > 0) {
                m1062a(C0325a.AdUserClose);
            }
        } catch (Exception e) {
        }
        if (this.f556x != null) {
            this.f556x.dismiss();
        }
        this.f558z.stopPlayback();
        finish();
    }

    protected void onStop() {
        m1087n();
        super.onStop();
    }

    protected void onDestroy() {
        if (Prm.adListener != null) {
            Prm.adListener.onSmartWallAdClosed();
        }
        MainActivity.m919a(false);
        try {
            C0295d c0295d = new C0295d(this);
            c0295d.m1013d(AdType.video);
            if (c0295d.m1008a()) {
                c0295d.m1012c(AdType.smartwall);
                c0295d.m1007a(false);
            }
        } catch (Exception e) {
        }
        try {
            ((AudioManager) getSystemService("audio")).setStreamMute(3, false);
        } catch (Exception e2) {
        }
        super.onDestroy();
    }
}
