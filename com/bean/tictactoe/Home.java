package com.bean.tictactoe;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
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

public class Home extends Activity implements OnTouchListener, BannerAdListener {
    float f492H;
    float f493W;
    AdView adView;
    Bitmap back;
    Front front;
    Bitmap game;
    float gameHGap;
    float gameHeight;
    float gameV;
    float gameWidth;
    float gapV;
    Bitmap mgame;
    float mgameHGap;
    float mgameHeight;
    float mgameV;
    float mgameWidth;
    float sHeight;
    float sWidth;
    Bitmap splayer;
    float splayerHGap;
    float splayerV;
    float tHeight;
    float tWidth;
    MediaPlayer touch;
    Bitmap tplayer;
    float tplayerHGap;
    float tplayerV;
    Vibrator f494v;
    float f495x;
    float f496y;

    public class Front extends SurfaceView implements Runnable {
        boolean check;
        Typeface font;
        SurfaceHolder holder;
        boolean isRunning;
        Paint myPaint;
        Thread thread;

        public Front(Context context) {
            super(context);
            this.isRunning = false;
            this.check = true;
            this.thread = null;
            this.myPaint = new Paint();
            this.font = Typeface.createFromAsset(context.getAssets(), "SF Arch Rival.ttf");
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
                    setPaint(this.myPaint);
                    drawImage(canvas);
                    getEvent();
                    this.holder.unlockCanvasAndPost(canvas);
                }
            }
        }

        private void setPaint(Paint myPaint) {
            myPaint.setColor(-16711936);
            myPaint.setTextAlign(Align.CENTER);
            myPaint.setTextSize(Home.this.gapV);
            myPaint.setTypeface(this.font);
        }

        private void getEvent() {
            if (Home.this.f495x > Home.this.splayerHGap && Home.this.f496y > Home.this.splayerV && Home.this.f495x < Home.this.splayerHGap + Home.this.sWidth && Home.this.f496y < Home.this.splayerV + Home.this.sHeight) {
                Home.this.touch.start();
                Home.this.f494v.vibrate(50);
                Home home = Home.this;
                Home.this.f496y = 0.0f;
                home.f495x = 0.0f;
                try {
                    Home.this.startActivity(new Intent(Home.this.getApplicationContext(), Class.forName("com.bean.tictactoe.Level")));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if (Home.this.f495x > Home.this.tplayerHGap && Home.this.f496y > Home.this.tplayerV && Home.this.f495x < Home.this.tplayerHGap + Home.this.tWidth && Home.this.f496y < Home.this.tplayerV + Home.this.tHeight) {
                Home.this.touch.start();
                Home.this.f494v.vibrate(50);
                home = Home.this;
                Home.this.f496y = 0.0f;
                home.f495x = 0.0f;
                try {
                    Intent ourIntent = new Intent(Home.this.getApplicationContext(), Class.forName("com.bean.tictactoe.SinglePlayer"));
                    ourIntent.putExtra("myCase", "2");
                    Home.this.startActivity(ourIntent);
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            if (Home.this.f495x > Home.this.mgameHGap && Home.this.f496y > Home.this.mgameV && Home.this.f495x < Home.this.mgameHGap + Home.this.mgameWidth && Home.this.f496y < Home.this.mgameV + Home.this.mgameHeight) {
                Home.this.touch.start();
                Home.this.f494v.vibrate(50);
                home = Home.this;
                Home.this.f496y = 0.0f;
                home.f495x = 0.0f;
                try {
                    Home.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pub:Niket Patel")));
                } catch (ActivityNotFoundException e3) {
                    Home.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/developer?id=Niket%20Patel&hl=en")));
                }
            }
        }

        private void calculateArea(Canvas canvas) {
            Home.this.f493W = (float) canvas.getWidth();
            Home.this.f492H = (float) canvas.getHeight();
            Home.this.gameWidth = (float) Home.this.game.getWidth();
            Home.this.gameHeight = (float) Home.this.game.getHeight();
            Home.this.sWidth = (float) Home.this.splayer.getWidth();
            Home.this.sHeight = (float) Home.this.splayer.getHeight();
            Home.this.tWidth = (float) Home.this.tplayer.getWidth();
            Home.this.tHeight = (float) Home.this.tplayer.getHeight();
            Home.this.mgameWidth = (float) Home.this.mgame.getWidth();
            Home.this.mgameHeight = (float) Home.this.mgame.getHeight();
            Home.this.gapV = (Home.this.f492H - (((Home.this.gameHeight + Home.this.sHeight) + Home.this.tHeight) + Home.this.mgameHeight)) / 5.0f;
            Home.this.gameHGap = (Home.this.f493W - Home.this.gameWidth) / 2.0f;
            Home.this.splayerHGap = (Home.this.f493W - Home.this.sWidth) / 2.0f;
            Home.this.tplayerHGap = (Home.this.f493W - Home.this.tWidth) / 2.0f;
            Home.this.mgameHGap = (Home.this.f493W - Home.this.mgameWidth) / 2.0f;
            Home.this.gameV = 0.0f + Home.this.gapV;
            Home.this.splayerV = (Home.this.gameV + Home.this.gameHeight) + Home.this.gapV;
            Home.this.tplayerV = (Home.this.splayerV + Home.this.sHeight) + Home.this.gapV;
            Home.this.mgameV = (Home.this.tplayerV + Home.this.tHeight) + Home.this.gapV;
        }

        private void drawImage(Canvas canvas) {
            canvas.drawBitmap(Home.this.back, 0.0f, 0.0f, null);
            canvas.drawText("TIC TAC TOE", Home.this.f493W / 2.0f, Home.this.gapV, this.myPaint);
            canvas.drawBitmap(Home.this.game, Home.this.gameHGap, Home.this.gameV, null);
            canvas.drawBitmap(Home.this.splayer, Home.this.splayerHGap, Home.this.splayerV, null);
            canvas.drawBitmap(Home.this.tplayer, Home.this.tplayerHGap, Home.this.tplayerV, null);
            canvas.drawBitmap(Home.this.mgame, Home.this.mgameHGap, Home.this.mgameV, null);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        getWindow().addFlags(TransportMediator.FLAG_KEY_MEDIA_NEXT);
        this.f494v = (Vibrator) getSystemService("vibrator");
        this.front = new Front(this);
        this.adView = new AdView(this, AdView.BANNER_TYPE_IN_APP_AD, IM.PLACEMENT_TYPE_INTERSTITIAL, false, false, IM.ANIMATION_TYPE_LEFT_TO_RIGHT);
        this.adView.setAdListener(this);
        RelativeLayout ll = new RelativeLayout(this);
        LayoutParams lay = new LayoutParams(-2, -2);
        lay.addRule(12);
        ll.addView(this.front);
        ll.addView(this.adView, lay);
        this.front.setOnTouchListener(this);
        this.back = BitmapFactory.decodeResource(getResources(), C0047R.drawable.backg);
        this.game = BitmapFactory.decodeResource(getResources(), C0047R.drawable.game);
        this.splayer = BitmapFactory.decodeResource(getResources(), C0047R.drawable.splayer);
        this.tplayer = BitmapFactory.decodeResource(getResources(), C0047R.drawable.tplayer);
        this.mgame = BitmapFactory.decodeResource(getResources(), C0047R.drawable.mgame);
        this.touch = MediaPlayer.create(this, C0047R.raw.touch);
        this.f496y = 0.0f;
        this.f495x = 0.0f;
        setContentView(ll);
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    protected void onPause() {
        super.onPause();
        this.front.pause();
    }

    protected void onResume() {
        super.onResume();
        this.front.resume();
    }

    public boolean onTouch(View v, MotionEvent event) {
        this.f495x = event.getX();
        this.f496y = event.getY();
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
