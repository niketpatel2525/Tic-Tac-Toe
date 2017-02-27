package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import com.sxnyodot.uefqvmio207964.C0304k;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class bj extends FrameLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private final cq fG;
    private final MediaController gb;
    private final C0104a gc;
    private final VideoView gd;
    private long ge;
    private String gf;

    /* renamed from: com.google.android.gms.internal.bj.a */
    private static final class C0104a {
        private final Runnable el;
        private volatile boolean gg;

        /* renamed from: com.google.android.gms.internal.bj.a.1 */
        class C01031 implements Runnable {
            private final WeakReference<bj> gh;
            final /* synthetic */ bj gi;
            final /* synthetic */ C0104a gj;

            C01031(C0104a c0104a, bj bjVar) {
                this.gj = c0104a;
                this.gi = bjVar;
                this.gh = new WeakReference(this.gi);
            }

            public void run() {
                bj bjVar = (bj) this.gh.get();
                if (!this.gj.gg && bjVar != null) {
                    bjVar.aa();
                    this.gj.ab();
                }
            }
        }

        public C0104a(bj bjVar) {
            this.gg = false;
            this.el = new C01031(this, bjVar);
        }

        public void ab() {
            cm.hO.postDelayed(this.el, 250);
        }

        public void cancel() {
            this.gg = true;
            cm.hO.removeCallbacks(this.el);
        }
    }

    public bj(Context context, cq cqVar) {
        super(context);
        this.fG = cqVar;
        this.gd = new VideoView(context);
        addView(this.gd, new LayoutParams(-1, -1, 17));
        this.gb = new MediaController(context);
        this.gc = new C0104a(this);
        this.gc.ab();
        this.gd.setOnCompletionListener(this);
        this.gd.setOnPreparedListener(this);
        this.gd.setOnErrorListener(this);
    }

    private static void m209a(cq cqVar, String str) {
        m212a(cqVar, str, new HashMap(1));
    }

    public static void m210a(cq cqVar, String str, String str2) {
        Object obj = str2 == null ? 1 : null;
        Map hashMap = new HashMap(obj != null ? 2 : 3);
        hashMap.put("what", str);
        if (obj == null) {
            hashMap.put("extra", str2);
        }
        m212a(cqVar, IM.EVENT_ERROR, hashMap);
    }

    private static void m211a(cq cqVar, String str, String str2, String str3) {
        Map hashMap = new HashMap(2);
        hashMap.put(str2, str3);
        m212a(cqVar, str, hashMap);
    }

    private static void m212a(cq cqVar, String str, Map<String, String> map) {
        map.put(C0304k.EVENT, str);
        cqVar.m306a("onVideoEvent", (Map) map);
    }

    public void m213Z() {
        if (TextUtils.isEmpty(this.gf)) {
            m210a(this.fG, "no_src", null);
        } else {
            this.gd.setVideoPath(this.gf);
        }
    }

    public void aa() {
        long currentPosition = (long) this.gd.getCurrentPosition();
        if (this.ge != currentPosition) {
            m211a(this.fG, "timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
            this.ge = currentPosition;
        }
    }

    public void m214b(MotionEvent motionEvent) {
        this.gd.dispatchTouchEvent(motionEvent);
    }

    public void destroy() {
        this.gc.cancel();
        this.gd.stopPlayback();
    }

    public void m215f(boolean z) {
        if (z) {
            this.gd.setMediaController(this.gb);
            return;
        }
        this.gb.hide();
        this.gd.setMediaController(null);
    }

    public void m216i(String str) {
        this.gf = str;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        m209a(this.fG, "ended");
    }

    public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
        m210a(this.fG, String.valueOf(what), String.valueOf(extra));
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        m211a(this.fG, "canplaythrough", "duration", String.valueOf(((float) this.gd.getDuration()) / 1000.0f));
    }

    public void pause() {
        this.gd.pause();
    }

    public void play() {
        this.gd.start();
    }

    public void seekTo(int timeInMilliseconds) {
        this.gd.seekTo(timeInMilliseconds);
    }
}
