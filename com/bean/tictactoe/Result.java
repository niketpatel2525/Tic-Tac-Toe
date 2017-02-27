package com.bean.tictactoe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.sxnyodot.uefqvmio207964.AdListener.BannerAdListener;
import com.sxnyodot.uefqvmio207964.AdView;

public class Result extends Activity implements BannerAdListener {
    AdView adView;
    Bitmap back;
    FinalResult fr;
    Bitmap win;
    int winner;

    /* renamed from: com.bean.tictactoe.Result.1 */
    class C00481 extends Thread {
        C00481() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r5 = this;
            super.run();
            r2 = 9000; // 0x2328 float:1.2612E-41 double:4.4466E-320;
            com.bean.tictactoe.Result.C00481.sleep(r2);	 Catch:{ Exception -> 0x001f }
            r1 = new android.content.Intent;	 Catch:{ ClassNotFoundException -> 0x005c }
            r2 = com.bean.tictactoe.Result.this;	 Catch:{ ClassNotFoundException -> 0x005c }
            r2 = r2.getApplicationContext();	 Catch:{ ClassNotFoundException -> 0x005c }
            r3 = "com.bean.tictactoe.Home";
            r3 = java.lang.Class.forName(r3);	 Catch:{ ClassNotFoundException -> 0x005c }
            r1.<init>(r2, r3);	 Catch:{ ClassNotFoundException -> 0x005c }
            r2 = com.bean.tictactoe.Result.this;	 Catch:{ ClassNotFoundException -> 0x005c }
            r2.startActivity(r1);	 Catch:{ ClassNotFoundException -> 0x005c }
        L_0x001e:
            return;
        L_0x001f:
            r0 = move-exception;
            r0.printStackTrace();	 Catch:{ all -> 0x003f }
            r1 = new android.content.Intent;	 Catch:{ ClassNotFoundException -> 0x003a }
            r2 = com.bean.tictactoe.Result.this;	 Catch:{ ClassNotFoundException -> 0x003a }
            r2 = r2.getApplicationContext();	 Catch:{ ClassNotFoundException -> 0x003a }
            r3 = "com.bean.tictactoe.Home";
            r3 = java.lang.Class.forName(r3);	 Catch:{ ClassNotFoundException -> 0x003a }
            r1.<init>(r2, r3);	 Catch:{ ClassNotFoundException -> 0x003a }
            r2 = com.bean.tictactoe.Result.this;	 Catch:{ ClassNotFoundException -> 0x003a }
            r2.startActivity(r1);	 Catch:{ ClassNotFoundException -> 0x003a }
            goto L_0x001e;
        L_0x003a:
            r0 = move-exception;
            r0.printStackTrace();
            goto L_0x001e;
        L_0x003f:
            r2 = move-exception;
            r1 = new android.content.Intent;	 Catch:{ ClassNotFoundException -> 0x0057 }
            r3 = com.bean.tictactoe.Result.this;	 Catch:{ ClassNotFoundException -> 0x0057 }
            r3 = r3.getApplicationContext();	 Catch:{ ClassNotFoundException -> 0x0057 }
            r4 = "com.bean.tictactoe.Home";
            r4 = java.lang.Class.forName(r4);	 Catch:{ ClassNotFoundException -> 0x0057 }
            r1.<init>(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0057 }
            r3 = com.bean.tictactoe.Result.this;	 Catch:{ ClassNotFoundException -> 0x0057 }
            r3.startActivity(r1);	 Catch:{ ClassNotFoundException -> 0x0057 }
        L_0x0056:
            throw r2;
        L_0x0057:
            r0 = move-exception;
            r0.printStackTrace();
            goto L_0x0056;
        L_0x005c:
            r0 = move-exception;
            r0.printStackTrace();
            goto L_0x001e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bean.tictactoe.Result.1.run():void");
        }
    }

    public class FinalResult extends View {
        public FinalResult(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawBitmap(Result.this.back, 0.0f, 0.0f, null);
            canvas.drawBitmap(Result.this.win, (((float) canvas.getWidth()) - ((float) Result.this.win.getWidth())) / 2.0f, (((float) canvas.getHeight()) - ((float) Result.this.win.getHeight())) / 2.0f, null);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        getWindow().addFlags(TransportMediator.FLAG_KEY_MEDIA_NEXT);
        this.fr = new FinalResult(this);
        AdView adView = new AdView(this, AdView.BANNER_TYPE_IN_APP_AD, IM.PLACEMENT_TYPE_INTERSTITIAL, false, false, IM.ANIMATION_TYPE_LEFT_TO_RIGHT);
        adView.setAdListener(this);
        RelativeLayout ll = new RelativeLayout(this);
        LayoutParams lay = new LayoutParams(-2, -2);
        lay.addRule(12);
        ll.addView(this.fr);
        ll.addView(adView, lay);
        this.winner = Integer.parseInt(getIntent().getExtras().getString("winner"));
        this.back = BitmapFactory.decodeResource(getResources(), C0047R.drawable.back);
        if (this.winner == 0) {
            this.win = BitmapFactory.decodeResource(getResources(), C0047R.drawable.loss);
        } else if (this.winner == 1) {
            this.win = BitmapFactory.decodeResource(getResources(), C0047R.drawable.playerone);
        } else if (this.winner == 2) {
            this.win = BitmapFactory.decodeResource(getResources(), C0047R.drawable.playertwo);
        } else if (this.winner == 3) {
            this.win = BitmapFactory.decodeResource(getResources(), C0047R.drawable.draw);
        } else if (this.winner == 11) {
            this.win = BitmapFactory.decodeResource(getResources(), C0047R.drawable.youwin);
        }
        new C00481().start();
        setContentView(ll);
    }

    public void onBackPressed() {
        super.onBackPressed();
        try {
            startActivity(new Intent(getApplicationContext(), Class.forName("com.bean.tictactoe.Home")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void noAdAvailableListener() {
    }

    public void onAdClickListener() {
    }

    public void onAdExpandedListner() {
    }

    public void onAdLoadedListener() {
    }

    public void onAdLoadingListener() {
    }

    public void onCloseListener() {
    }

    public void onErrorListener(String arg0) {
    }
}
