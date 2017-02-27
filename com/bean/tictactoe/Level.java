package com.bean.tictactoe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.sxnyodot.uefqvmio207964.AdListener.BannerAdListener;
import com.sxnyodot.uefqvmio207964.AdView;

public class Level extends Activity implements OnTouchListener, BannerAdListener {
    float f497H;
    float f498W;
    AdView adView;
    Bitmap back;
    float gapV;
    Bitmap hard;
    float hardHGap;
    float hardHeight;
    float hardVGap;
    float hardWidth;
    SubLevel level;
    Bitmap normal;
    float normalHGap;
    float normalHeight;
    float normalVGap;
    float normalWidth;
    MediaPlayer touch;
    Vibrator f499v;
    float f500x;
    float f501y;

    public class SubLevel extends SurfaceView implements Runnable {
        boolean check;
        SurfaceHolder holder;
        boolean isRunning;
        Thread thread;

        public SubLevel(Context context) {
            super(context);
            this.isRunning = false;
            this.check = true;
            this.thread = null;
            this.holder = getHolder();
        }

        public void pause() {
            this.isRunning = false;
            try {
                this.thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.thread = null;
        }

        public void resume() {
            this.isRunning = true;
            this.thread = new Thread(this);
            this.thread.start();
        }

        public void run() {
            while (this.isRunning) {
                if (this.holder.getSurface().isValid()) {
                    Canvas canvas = this.holder.lockCanvas();
                    calculateArea(canvas);
                    drawImage(canvas);
                    getEvent();
                    this.holder.unlockCanvasAndPost(canvas);
                }
            }
        }

        private void getEvent() {
            if (Level.this.f500x > Level.this.normalHGap && Level.this.f501y > Level.this.normalVGap && Level.this.f500x < Level.this.normalHGap + Level.this.normalWidth && Level.this.f501y < Level.this.normalVGap + Level.this.normalHeight) {
                Level.this.touch.start();
                Level.this.f499v.vibrate(50);
                Level level = Level.this;
                Level.this.f501y = 0.0f;
                level.f500x = 0.0f;
                try {
                    Intent ourIntent = new Intent(Level.this.getApplicationContext(), Class.forName("com.bean.tictactoe.SinglePlayer"));
                    ourIntent.putExtra("myCase", "0");
                    Level.this.startActivity(ourIntent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if (Level.this.f500x > Level.this.hardHGap && Level.this.f501y > Level.this.hardVGap && Level.this.f500x < Level.this.hardHGap + Level.this.hardWidth && Level.this.f501y < Level.this.hardVGap + Level.this.hardHeight) {
                Level.this.touch.start();
                Level.this.f499v.vibrate(50);
                level = Level.this;
                Level.this.f501y = 0.0f;
                level.f500x = 0.0f;
                try {
                    ourIntent = new Intent(Level.this.getApplicationContext(), Class.forName("com.bean.tictactoe.SinglePlayer"));
                    ourIntent.putExtra("myCase", "1");
                    Level.this.startActivity(ourIntent);
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
        }

        private void drawImage(Canvas canvas) {
            canvas.drawBitmap(Level.this.back, 0.0f, 0.0f, null);
            canvas.drawBitmap(Level.this.normal, Level.this.normalHGap, Level.this.normalVGap, null);
            canvas.drawBitmap(Level.this.hard, Level.this.hardHGap, Level.this.hardVGap, null);
        }

        private void calculateArea(Canvas canvas) {
            Level.this.f498W = (float) canvas.getWidth();
            Level.this.f497H = (float) canvas.getHeight();
            Level.this.hardWidth = (float) Level.this.hard.getWidth();
            Level.this.hardHeight = (float) Level.this.hard.getHeight();
            Level.this.normalWidth = (float) Level.this.normal.getWidth();
            Level.this.normalHeight = (float) Level.this.normal.getHeight();
            Level.this.gapV = (Level.this.f497H - (Level.this.hardHeight + Level.this.normalHeight)) / 3.0f;
            Level.this.normalVGap = 0.0f + Level.this.gapV;
            Level.this.hardVGap = (Level.this.normalVGap + Level.this.normalHeight) + Level.this.gapV;
            Level.this.normalHGap = (Level.this.f498W - Level.this.normalWidth) / 2.0f;
            Level.this.hardHGap = (Level.this.f498W - Level.this.hardWidth) / 2.0f;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        getWindow().addFlags(TransportMediator.FLAG_KEY_MEDIA_NEXT);
        this.f499v = (Vibrator) getSystemService("vibrator");
        this.level = new SubLevel(this);
        this.adView = new AdView(this, AdView.BANNER_TYPE_IN_APP_AD, IM.PLACEMENT_TYPE_INTERSTITIAL, false, false, IM.ANIMATION_TYPE_LEFT_TO_RIGHT);
        this.adView.setAdListener(this);
        RelativeLayout ll = new RelativeLayout(this);
        LayoutParams lay = new LayoutParams(-2, -2);
        lay.addRule(12);
        ll.addView(this.level);
        ll.addView(this.adView, lay);
        this.level.setOnTouchListener(this);
        this.back = BitmapFactory.decodeResource(getResources(), C0047R.drawable.backg);
        this.normal = BitmapFactory.decodeResource(getResources(), C0047R.drawable.normal);
        this.hard = BitmapFactory.decodeResource(getResources(), C0047R.drawable.hard);
        this.touch = MediaPlayer.create(this, C0047R.raw.touch);
        this.f501y = 0.0f;
        this.f500x = 0.0f;
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

    protected void onPause() {
        super.onPause();
        this.level.pause();
    }

    protected void onResume() {
        super.onResume();
        this.level.resume();
    }

    public boolean onTouch(View v, MotionEvent event) {
        this.f500x = event.getX();
        this.f501y = event.getY();
        return false;
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
