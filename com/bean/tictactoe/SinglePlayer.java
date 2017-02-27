package com.bean.tictactoe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;
import com.sxnyodot.uefqvmio207964.AdListener.BannerAdListener;
import com.sxnyodot.uefqvmio207964.AdView;
import java.util.Random;

public class SinglePlayer extends Activity implements OnTouchListener, BannerAdListener {
    float f502H;
    float f503W;
    AdView adView;
    int[][] array;
    Bitmap back;
    Background1 background;
    Bitmap box1;
    Bitmap box2;
    Bitmap box3;
    float boxHeight;
    float boxWidth;
    int chance;
    float clineH1;
    float clineH2;
    float clineH3;
    float clineP1;
    float clineS1;
    float clineV1;
    float clineV2;
    float clineV3;
    float gapH;
    float gapV;
    float h1;
    float h2;
    float h3;
    float lineH1;
    float lineH2;
    float lineV1;
    float lineV2;
    int myCase;
    Vibrator f504v;
    float w1;
    float w2;
    float w3;
    float f505x;
    float f506y;

    public class Background1 extends SurfaceView implements Runnable {
        boolean check;
        Typeface font;
        SurfaceHolder holder;
        boolean isRunning;
        Thread thread;

        public Background1(Context context) {
            super(context);
            this.isRunning = false;
            this.check = true;
            this.thread = null;
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
                    canvas.drawRGB(192, 192, 192);
                    Paint myPaint = new Paint();
                    Paint linePaint = new Paint();
                    setPaint(myPaint, linePaint);
                    calculateArea(canvas);
                    canvas.drawBitmap(SinglePlayer.this.back, 0.0f, 0.0f, null);
                    drawGameArea(canvas, linePaint);
                    preDraw(canvas);
                    postDraw(canvas);
                    if (SinglePlayer.this.chance % 2 != 0) {
                        player1(canvas);
                    } else if (SinglePlayer.this.myCase == 0) {
                        CPUlogic();
                    } else if (SinglePlayer.this.myCase == 1) {
                        CPULogicHard();
                    } else if (SinglePlayer.this.myCase == 2) {
                        player2(canvas);
                    }
                    if (SinglePlayer.this.myCase == 0 || SinglePlayer.this.myCase == 1) {
                        checkWinner(canvas, myPaint);
                    } else if (SinglePlayer.this.myCase == 2) {
                        checkWinner2(canvas, myPaint);
                    }
                    this.check = true;
                    this.holder.unlockCanvasAndPost(canvas);
                }
            }
        }

        private void setPaint(Paint myPaint, Paint linePaint) {
            myPaint.setColor(SupportMenu.CATEGORY_MASK);
            myPaint.setTextAlign(Align.CENTER);
            myPaint.setTextSize(62.0f);
            myPaint.setTypeface(this.font);
            myPaint.setStrokeWidth(20.0f);
            linePaint.setStrokeWidth(20.0f);
            linePaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        }

        private void calculateArea(Canvas canvas) {
            SinglePlayer.this.boxWidth = (float) SinglePlayer.this.box1.getWidth();
            SinglePlayer.this.boxHeight = (float) SinglePlayer.this.box1.getHeight();
            SinglePlayer.this.f503W = (float) canvas.getWidth();
            SinglePlayer.this.f502H = (float) canvas.getHeight();
            SinglePlayer.this.gapH = (SinglePlayer.this.f503W - (SinglePlayer.this.boxWidth * 3.0f)) / 4.0f;
            SinglePlayer.this.gapV = SinglePlayer.this.gapH;
            SinglePlayer.this.h1 = ((SinglePlayer.this.f502H / 2.0f) - (1.0f * SinglePlayer.this.boxHeight)) - SinglePlayer.this.gapV;
            SinglePlayer.this.h2 = (SinglePlayer.this.h1 + SinglePlayer.this.boxHeight) + SinglePlayer.this.gapV;
            SinglePlayer.this.h3 = (SinglePlayer.this.h2 + SinglePlayer.this.boxHeight) + SinglePlayer.this.gapV;
            SinglePlayer.this.w1 = SinglePlayer.this.gapH;
            SinglePlayer.this.w2 = (SinglePlayer.this.w1 + SinglePlayer.this.boxWidth) + SinglePlayer.this.gapH;
            SinglePlayer.this.w3 = (SinglePlayer.this.w2 + SinglePlayer.this.boxWidth) + SinglePlayer.this.gapH;
            SinglePlayer.this.lineH1 = ((SinglePlayer.this.w2 + SinglePlayer.this.w1) + SinglePlayer.this.boxWidth) / 2.0f;
            SinglePlayer.this.lineH2 = ((SinglePlayer.this.w3 + SinglePlayer.this.w2) + SinglePlayer.this.boxWidth) / 2.0f;
            SinglePlayer.this.lineV1 = ((SinglePlayer.this.h2 + SinglePlayer.this.h1) + SinglePlayer.this.boxHeight) / 2.0f;
            SinglePlayer.this.lineV2 = ((SinglePlayer.this.h3 + SinglePlayer.this.h2) + SinglePlayer.this.boxHeight) / 2.0f;
            SinglePlayer.this.clineH1 = SinglePlayer.this.gapH + (SinglePlayer.this.boxWidth / 2.0f);
            SinglePlayer.this.clineH2 = SinglePlayer.this.w2 + (SinglePlayer.this.boxWidth / 2.0f);
            SinglePlayer.this.clineH3 = SinglePlayer.this.w3 + (SinglePlayer.this.boxWidth / 2.0f);
            SinglePlayer.this.clineV1 = SinglePlayer.this.h1 + (SinglePlayer.this.boxHeight / 2.0f);
            SinglePlayer.this.clineV2 = SinglePlayer.this.h2 + (SinglePlayer.this.boxHeight / 2.0f);
            SinglePlayer.this.clineV3 = SinglePlayer.this.h3 + (SinglePlayer.this.boxHeight / 2.0f);
        }

        private void drawGameArea(Canvas canvas, Paint linePaint) {
            canvas.drawLine(SinglePlayer.this.lineH1, SinglePlayer.this.h1, SinglePlayer.this.lineH1, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, linePaint);
            canvas.drawLine(SinglePlayer.this.lineH2, SinglePlayer.this.h1, SinglePlayer.this.lineH2, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, linePaint);
            canvas.drawLine(SinglePlayer.this.gapH, SinglePlayer.this.lineV1, SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.lineV1, linePaint);
            canvas.drawLine(SinglePlayer.this.gapH, SinglePlayer.this.lineV2, SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.lineV2, linePaint);
        }

        private void drawGame() {
            try {
                Thread.sleep(2000);
                this.isRunning = false;
                Intent ourIntent = new Intent(SinglePlayer.this.getApplicationContext(), Class.forName("com.bean.tictactoe.Result"));
                ourIntent.putExtra("winner", "3");
                SinglePlayer.this.startActivity(ourIntent);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        }

        private void winCPU() {
            try {
                Thread.sleep(2000);
                this.isRunning = false;
                Intent ourIntent = new Intent(SinglePlayer.this.getApplicationContext(), Class.forName("com.bean.tictactoe.Result"));
                ourIntent.putExtra("winner", "0");
                SinglePlayer.this.startActivity(ourIntent);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        }

        private void winPlayer11() {
            try {
                Thread.sleep(2000);
                this.isRunning = false;
                Intent ourIntent = new Intent(SinglePlayer.this.getApplicationContext(), Class.forName("com.bean.tictactoe.Result"));
                ourIntent.putExtra("winner", "11");
                SinglePlayer.this.startActivity(ourIntent);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        }

        private void winPlayer1() {
            try {
                Thread.sleep(2000);
                this.isRunning = false;
                Intent ourIntent = new Intent(SinglePlayer.this.getApplicationContext(), Class.forName("com.bean.tictactoe.Result"));
                ourIntent.putExtra("winner", "1");
                SinglePlayer.this.startActivity(ourIntent);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        }

        private void winPlayer2() {
            try {
                Thread.sleep(2000);
                this.isRunning = false;
                Intent ourIntent = new Intent(SinglePlayer.this.getApplicationContext(), Class.forName("com.bean.tictactoe.Result"));
                ourIntent.putExtra("winner", "2");
                SinglePlayer.this.startActivity(ourIntent);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        }

        private void CPULogicHard() {
            SinglePlayer singlePlayer;
            int i = 0;
            while (i < 3) {
                if (SinglePlayer.this.array[i][0] == 0 && SinglePlayer.this.array[i][1] == 2 && SinglePlayer.this.array[i][2] == 2) {
                    SinglePlayer.this.array[i][0] = 2;
                    singlePlayer = SinglePlayer.this;
                    singlePlayer.chance++;
                    return;
                } else if (SinglePlayer.this.array[i][0] == 2 && SinglePlayer.this.array[i][1] == 0 && SinglePlayer.this.array[i][2] == 2) {
                    SinglePlayer.this.array[i][1] = 2;
                    singlePlayer = SinglePlayer.this;
                    singlePlayer.chance++;
                    return;
                } else if (SinglePlayer.this.array[i][0] == 2 && SinglePlayer.this.array[i][1] == 2 && SinglePlayer.this.array[i][2] == 0) {
                    SinglePlayer.this.array[i][2] = 2;
                    singlePlayer = SinglePlayer.this;
                    singlePlayer.chance++;
                    return;
                } else if (SinglePlayer.this.array[0][i] == 0 && SinglePlayer.this.array[1][i] == 2 && SinglePlayer.this.array[2][i] == 2) {
                    SinglePlayer.this.array[0][i] = 2;
                    singlePlayer = SinglePlayer.this;
                    singlePlayer.chance++;
                    return;
                } else if (SinglePlayer.this.array[0][i] == 2 && SinglePlayer.this.array[1][i] == 0 && SinglePlayer.this.array[2][i] == 2) {
                    SinglePlayer.this.array[1][i] = 2;
                    singlePlayer = SinglePlayer.this;
                    singlePlayer.chance++;
                    return;
                } else if (SinglePlayer.this.array[0][i] == 2 && SinglePlayer.this.array[1][i] == 2 && SinglePlayer.this.array[2][i] == 0) {
                    SinglePlayer.this.array[2][i] = 2;
                    singlePlayer = SinglePlayer.this;
                    singlePlayer.chance++;
                    return;
                } else {
                    i++;
                }
            }
            if (SinglePlayer.this.array[0][0] == 0 && SinglePlayer.this.array[1][1] == 2 && SinglePlayer.this.array[2][2] == 2) {
                SinglePlayer.this.array[0][0] = 2;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            } else if (SinglePlayer.this.array[0][0] == 2 && SinglePlayer.this.array[1][1] == 0 && SinglePlayer.this.array[2][2] == 2) {
                SinglePlayer.this.array[1][1] = 2;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            } else if (SinglePlayer.this.array[0][0] == 2 && SinglePlayer.this.array[1][1] == 2 && SinglePlayer.this.array[2][2] == 0) {
                SinglePlayer.this.array[2][2] = 2;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            } else if (SinglePlayer.this.array[0][2] == 0 && SinglePlayer.this.array[1][1] == 2 && SinglePlayer.this.array[2][0] == 2) {
                SinglePlayer.this.array[0][2] = 2;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            } else if (SinglePlayer.this.array[0][2] == 2 && SinglePlayer.this.array[1][1] == 0 && SinglePlayer.this.array[2][0] == 2) {
                SinglePlayer.this.array[1][1] = 2;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            } else if (SinglePlayer.this.array[0][2] == 2 && SinglePlayer.this.array[1][1] == 2 && SinglePlayer.this.array[2][0] == 0) {
                SinglePlayer.this.array[2][2] = 2;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            } else {
                i = 0;
                while (i < 3) {
                    if (SinglePlayer.this.array[i][0] == 0 && SinglePlayer.this.array[i][1] == 1 && SinglePlayer.this.array[i][2] == 1) {
                        SinglePlayer.this.array[i][0] = 2;
                        singlePlayer = SinglePlayer.this;
                        singlePlayer.chance++;
                        return;
                    } else if (SinglePlayer.this.array[i][0] == 1 && SinglePlayer.this.array[i][1] == 0 && SinglePlayer.this.array[i][2] == 1) {
                        SinglePlayer.this.array[i][1] = 2;
                        singlePlayer = SinglePlayer.this;
                        singlePlayer.chance++;
                        return;
                    } else if (SinglePlayer.this.array[i][0] == 1 && SinglePlayer.this.array[i][1] == 1 && SinglePlayer.this.array[i][2] == 0) {
                        SinglePlayer.this.array[i][2] = 2;
                        singlePlayer = SinglePlayer.this;
                        singlePlayer.chance++;
                        return;
                    } else if (SinglePlayer.this.array[0][i] == 0 && SinglePlayer.this.array[1][i] == 1 && SinglePlayer.this.array[2][i] == 1) {
                        SinglePlayer.this.array[0][i] = 2;
                        singlePlayer = SinglePlayer.this;
                        singlePlayer.chance++;
                        return;
                    } else if (SinglePlayer.this.array[0][i] == 1 && SinglePlayer.this.array[1][i] == 0 && SinglePlayer.this.array[2][i] == 1) {
                        SinglePlayer.this.array[1][i] = 2;
                        singlePlayer = SinglePlayer.this;
                        singlePlayer.chance++;
                        return;
                    } else if (SinglePlayer.this.array[0][i] == 1 && SinglePlayer.this.array[1][i] == 1 && SinglePlayer.this.array[2][i] == 0) {
                        SinglePlayer.this.array[2][i] = 2;
                        singlePlayer = SinglePlayer.this;
                        singlePlayer.chance++;
                        return;
                    } else {
                        i++;
                    }
                }
                if (SinglePlayer.this.array[0][0] == 1 && SinglePlayer.this.array[1][1] == 2 && SinglePlayer.this.array[2][2] == 1) {
                    if (SinglePlayer.this.array[0][1] == 0) {
                        SinglePlayer.this.array[0][1] = 2;
                    } else if (SinglePlayer.this.array[1][0] == 0) {
                        SinglePlayer.this.array[1][0] = 2;
                    } else if (SinglePlayer.this.array[1][2] == 0) {
                        SinglePlayer.this.array[1][2] = 2;
                    } else if (SinglePlayer.this.array[1][2] == 0) {
                        SinglePlayer.this.array[1][2] = 2;
                    }
                    singlePlayer = SinglePlayer.this;
                    singlePlayer.chance++;
                } else if (SinglePlayer.this.array[0][2] == 1 && SinglePlayer.this.array[1][1] == 2 && SinglePlayer.this.array[2][0] == 1) {
                    if (SinglePlayer.this.array[0][1] == 0) {
                        SinglePlayer.this.array[0][1] = 2;
                    } else if (SinglePlayer.this.array[1][0] == 0) {
                        SinglePlayer.this.array[1][0] = 2;
                    } else if (SinglePlayer.this.array[1][2] == 0) {
                        SinglePlayer.this.array[1][2] = 2;
                    } else if (SinglePlayer.this.array[1][2] == 0) {
                        SinglePlayer.this.array[1][2] = 2;
                    }
                    singlePlayer = SinglePlayer.this;
                    singlePlayer.chance++;
                } else if (SinglePlayer.this.array[0][0] == 0 && SinglePlayer.this.array[1][1] == 1 && SinglePlayer.this.array[2][2] == 1) {
                    SinglePlayer.this.array[0][0] = 2;
                    singlePlayer = SinglePlayer.this;
                    singlePlayer.chance++;
                } else if (SinglePlayer.this.array[0][0] == 1 && SinglePlayer.this.array[1][1] == 0 && SinglePlayer.this.array[2][2] == 1) {
                    SinglePlayer.this.array[1][1] = 2;
                    singlePlayer = SinglePlayer.this;
                    singlePlayer.chance++;
                } else if (SinglePlayer.this.array[0][0] == 1 && SinglePlayer.this.array[1][1] == 1 && SinglePlayer.this.array[2][2] == 0) {
                    SinglePlayer.this.array[2][2] = 2;
                    singlePlayer = SinglePlayer.this;
                    singlePlayer.chance++;
                } else if (SinglePlayer.this.array[0][2] == 0 && SinglePlayer.this.array[1][1] == 1 && SinglePlayer.this.array[2][0] == 1) {
                    SinglePlayer.this.array[0][2] = 2;
                    singlePlayer = SinglePlayer.this;
                    singlePlayer.chance++;
                } else if (SinglePlayer.this.array[0][2] == 1 && SinglePlayer.this.array[1][1] == 0 && SinglePlayer.this.array[2][0] == 1) {
                    SinglePlayer.this.array[1][1] = 2;
                    singlePlayer = SinglePlayer.this;
                    singlePlayer.chance++;
                } else if (SinglePlayer.this.array[0][2] == 1 && SinglePlayer.this.array[1][1] == 1 && SinglePlayer.this.array[2][0] == 0) {
                    SinglePlayer.this.array[2][0] = 2;
                    singlePlayer = SinglePlayer.this;
                    singlePlayer.chance++;
                } else if ((SinglePlayer.this.array[0][0] == 1 || SinglePlayer.this.array[0][2] == 1 || SinglePlayer.this.array[2][0] == 1 || SinglePlayer.this.array[2][2] == 1) && SinglePlayer.this.array[1][1] == 0) {
                    SinglePlayer.this.array[1][1] = 2;
                    singlePlayer = SinglePlayer.this;
                    singlePlayer.chance++;
                } else {
                    int k = 0;
                    boolean selected = false;
                    int POS = new Random().nextInt(9);
                    do {
                        switch (POS) {
                            case DetectedActivity.IN_VEHICLE /*0*/:
                                if (SinglePlayer.this.array[0][0] != 0) {
                                    POS = (POS + 1) % 9;
                                    k++;
                                    break;
                                }
                                SinglePlayer.this.array[0][0] = 2;
                                singlePlayer = SinglePlayer.this;
                                singlePlayer.chance++;
                                selected = true;
                                break;
                            case DetectedActivity.ON_BICYCLE /*1*/:
                                if (SinglePlayer.this.array[0][1] != 0) {
                                    POS = (POS + 1) % 9;
                                    k++;
                                    break;
                                }
                                SinglePlayer.this.array[0][1] = 2;
                                singlePlayer = SinglePlayer.this;
                                singlePlayer.chance++;
                                selected = true;
                                break;
                            case DetectedActivity.ON_FOOT /*2*/:
                                if (SinglePlayer.this.array[0][2] != 0) {
                                    POS = (POS + 1) % 9;
                                    k++;
                                    break;
                                }
                                SinglePlayer.this.array[0][2] = 2;
                                singlePlayer = SinglePlayer.this;
                                singlePlayer.chance++;
                                selected = true;
                                break;
                            case DetectedActivity.STILL /*3*/:
                                if (SinglePlayer.this.array[1][0] != 0) {
                                    POS = (POS + 1) % 9;
                                    k++;
                                    break;
                                }
                                SinglePlayer.this.array[1][0] = 2;
                                singlePlayer = SinglePlayer.this;
                                singlePlayer.chance++;
                                selected = true;
                                break;
                            case DetectedActivity.UNKNOWN /*4*/:
                                if (SinglePlayer.this.array[1][1] != 0) {
                                    POS = (POS + 1) % 9;
                                    k++;
                                    break;
                                }
                                SinglePlayer.this.array[1][1] = 2;
                                singlePlayer = SinglePlayer.this;
                                singlePlayer.chance++;
                                selected = true;
                                break;
                            case DetectedActivity.TILTING /*5*/:
                                if (SinglePlayer.this.array[1][2] != 0) {
                                    POS = (POS + 1) % 9;
                                    k++;
                                    break;
                                }
                                SinglePlayer.this.array[1][2] = 2;
                                singlePlayer = SinglePlayer.this;
                                singlePlayer.chance++;
                                selected = true;
                                break;
                            case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                                if (SinglePlayer.this.array[2][0] != 0) {
                                    POS = (POS + 1) % 9;
                                    k++;
                                    break;
                                }
                                SinglePlayer.this.array[2][0] = 2;
                                singlePlayer = SinglePlayer.this;
                                singlePlayer.chance++;
                                selected = true;
                                break;
                            case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                                if (SinglePlayer.this.array[2][1] != 0) {
                                    POS = (POS + 1) % 9;
                                    k++;
                                    break;
                                }
                                SinglePlayer.this.array[2][1] = 2;
                                singlePlayer = SinglePlayer.this;
                                singlePlayer.chance++;
                                selected = true;
                                break;
                            case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                                if (SinglePlayer.this.array[2][2] != 0) {
                                    POS = (POS + 1) % 9;
                                    k++;
                                    break;
                                }
                                SinglePlayer.this.array[2][2] = 2;
                                singlePlayer = SinglePlayer.this;
                                singlePlayer.chance++;
                                selected = true;
                                break;
                        }
                        if (selected) {
                            return;
                        }
                    } while (k <= 9);
                }
            }
        }

        private void CPUlogic() {
            int k = 0;
            boolean selected = false;
            int POS = new Random().nextInt(9);
            do {
                SinglePlayer singlePlayer;
                switch (POS) {
                    case DetectedActivity.IN_VEHICLE /*0*/:
                        if (SinglePlayer.this.array[0][0] != 0) {
                            POS = (POS + 1) % 9;
                            k++;
                            break;
                        }
                        SinglePlayer.this.array[0][0] = 2;
                        singlePlayer = SinglePlayer.this;
                        singlePlayer.chance++;
                        selected = true;
                        break;
                    case DetectedActivity.ON_BICYCLE /*1*/:
                        if (SinglePlayer.this.array[0][1] != 0) {
                            POS = (POS + 1) % 9;
                            k++;
                            break;
                        }
                        SinglePlayer.this.array[0][1] = 2;
                        singlePlayer = SinglePlayer.this;
                        singlePlayer.chance++;
                        selected = true;
                        break;
                    case DetectedActivity.ON_FOOT /*2*/:
                        if (SinglePlayer.this.array[0][2] != 0) {
                            POS = (POS + 1) % 9;
                            k++;
                            break;
                        }
                        SinglePlayer.this.array[0][2] = 2;
                        singlePlayer = SinglePlayer.this;
                        singlePlayer.chance++;
                        selected = true;
                        break;
                    case DetectedActivity.STILL /*3*/:
                        if (SinglePlayer.this.array[1][0] != 0) {
                            POS = (POS + 1) % 9;
                            k++;
                            break;
                        }
                        SinglePlayer.this.array[1][0] = 2;
                        singlePlayer = SinglePlayer.this;
                        singlePlayer.chance++;
                        selected = true;
                        break;
                    case DetectedActivity.UNKNOWN /*4*/:
                        if (SinglePlayer.this.array[1][1] != 0) {
                            POS = (POS + 1) % 9;
                            k++;
                            break;
                        }
                        SinglePlayer.this.array[1][1] = 2;
                        singlePlayer = SinglePlayer.this;
                        singlePlayer.chance++;
                        selected = true;
                        break;
                    case DetectedActivity.TILTING /*5*/:
                        if (SinglePlayer.this.array[1][2] != 0) {
                            POS = (POS + 1) % 9;
                            k++;
                            break;
                        }
                        SinglePlayer.this.array[1][2] = 2;
                        singlePlayer = SinglePlayer.this;
                        singlePlayer.chance++;
                        selected = true;
                        break;
                    case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                        if (SinglePlayer.this.array[2][0] != 0) {
                            POS = (POS + 1) % 9;
                            k++;
                            break;
                        }
                        SinglePlayer.this.array[2][0] = 2;
                        singlePlayer = SinglePlayer.this;
                        singlePlayer.chance++;
                        selected = true;
                        break;
                    case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                        if (SinglePlayer.this.array[2][1] != 0) {
                            POS = (POS + 1) % 9;
                            k++;
                            break;
                        }
                        SinglePlayer.this.array[2][1] = 2;
                        singlePlayer = SinglePlayer.this;
                        singlePlayer.chance++;
                        selected = true;
                        break;
                    case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                        if (SinglePlayer.this.array[2][2] != 0) {
                            POS = (POS + 1) % 9;
                            k++;
                            break;
                        }
                        SinglePlayer.this.array[2][2] = 2;
                        singlePlayer = SinglePlayer.this;
                        singlePlayer.chance++;
                        selected = true;
                        break;
                }
                if (selected) {
                    return;
                }
            } while (k <= 9);
        }

        private void player1(Canvas canvas) {
            if (SinglePlayer.this.f505x > SinglePlayer.this.w1 && SinglePlayer.this.f506y > SinglePlayer.this.h1 && SinglePlayer.this.f505x < SinglePlayer.this.lineH1 && SinglePlayer.this.f506y < SinglePlayer.this.lineV1 && SinglePlayer.this.array[0][0] == 0) {
                SinglePlayer.this.f504v.vibrate(50);
                canvas.drawBitmap(SinglePlayer.this.box2, SinglePlayer.this.w1, SinglePlayer.this.h1, null);
                SinglePlayer.this.array[0][0] = 1;
                SinglePlayer singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            }
            if (SinglePlayer.this.f505x > SinglePlayer.this.w2 && SinglePlayer.this.f506y > SinglePlayer.this.h1 && SinglePlayer.this.f505x < SinglePlayer.this.lineH2 && SinglePlayer.this.f506y < SinglePlayer.this.lineV1 && SinglePlayer.this.array[0][1] == 0) {
                SinglePlayer.this.f504v.vibrate(50);
                canvas.drawBitmap(SinglePlayer.this.box2, SinglePlayer.this.w2, SinglePlayer.this.h1, null);
                SinglePlayer.this.array[0][1] = 1;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            }
            if (SinglePlayer.this.f505x > SinglePlayer.this.w3 && SinglePlayer.this.f506y > SinglePlayer.this.h1 && SinglePlayer.this.f506y < SinglePlayer.this.lineV1 && SinglePlayer.this.array[0][2] == 0) {
                SinglePlayer.this.f504v.vibrate(50);
                canvas.drawBitmap(SinglePlayer.this.box2, SinglePlayer.this.w3, SinglePlayer.this.h1, null);
                SinglePlayer.this.array[0][2] = 1;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            }
            if (SinglePlayer.this.f505x > SinglePlayer.this.w1 && SinglePlayer.this.f506y > SinglePlayer.this.h2 && SinglePlayer.this.f505x < SinglePlayer.this.lineH1 && SinglePlayer.this.f506y < SinglePlayer.this.lineV2 && SinglePlayer.this.array[1][0] == 0) {
                SinglePlayer.this.f504v.vibrate(50);
                canvas.drawBitmap(SinglePlayer.this.box2, SinglePlayer.this.w1, SinglePlayer.this.h2, null);
                SinglePlayer.this.array[1][0] = 1;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            }
            if (SinglePlayer.this.f505x > SinglePlayer.this.w2 && SinglePlayer.this.f506y > SinglePlayer.this.h2 && SinglePlayer.this.f505x < SinglePlayer.this.lineH2 && SinglePlayer.this.f506y < SinglePlayer.this.lineV2 && SinglePlayer.this.array[1][1] == 0) {
                SinglePlayer.this.f504v.vibrate(50);
                canvas.drawBitmap(SinglePlayer.this.box2, SinglePlayer.this.w2, SinglePlayer.this.h2, null);
                SinglePlayer.this.array[1][1] = 1;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            }
            if (SinglePlayer.this.f505x > SinglePlayer.this.w3 && SinglePlayer.this.f506y > SinglePlayer.this.h2 && SinglePlayer.this.f506y < SinglePlayer.this.lineV2 && SinglePlayer.this.array[1][2] == 0) {
                SinglePlayer.this.f504v.vibrate(50);
                canvas.drawBitmap(SinglePlayer.this.box2, SinglePlayer.this.w3, SinglePlayer.this.h2, null);
                SinglePlayer.this.array[1][2] = 1;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            }
            if (SinglePlayer.this.f505x > SinglePlayer.this.w1 && SinglePlayer.this.f506y > SinglePlayer.this.h3 && SinglePlayer.this.f505x < SinglePlayer.this.lineH1 && SinglePlayer.this.array[2][0] == 0) {
                SinglePlayer.this.f504v.vibrate(50);
                canvas.drawBitmap(SinglePlayer.this.box2, SinglePlayer.this.w1, SinglePlayer.this.h3, null);
                SinglePlayer.this.array[2][0] = 1;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            }
            if (SinglePlayer.this.f505x > SinglePlayer.this.w2 && SinglePlayer.this.f506y > SinglePlayer.this.h3 && SinglePlayer.this.f505x < SinglePlayer.this.lineH2 && SinglePlayer.this.array[2][1] == 0) {
                SinglePlayer.this.f504v.vibrate(50);
                canvas.drawBitmap(SinglePlayer.this.box2, SinglePlayer.this.w2, SinglePlayer.this.h3, null);
                SinglePlayer.this.array[2][1] = 1;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            }
            if (SinglePlayer.this.f505x > SinglePlayer.this.w3 && SinglePlayer.this.f506y > SinglePlayer.this.h3 && SinglePlayer.this.array[2][2] == 0) {
                SinglePlayer.this.f504v.vibrate(50);
                canvas.drawBitmap(SinglePlayer.this.box2, SinglePlayer.this.w3, SinglePlayer.this.h3, null);
                SinglePlayer.this.array[2][2] = 1;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            }
        }

        private void player2(Canvas canvas) {
            if (SinglePlayer.this.f505x > SinglePlayer.this.w1 && SinglePlayer.this.f506y > SinglePlayer.this.h1 && SinglePlayer.this.f505x < SinglePlayer.this.lineH1 && SinglePlayer.this.f506y < SinglePlayer.this.lineV1 && SinglePlayer.this.array[0][0] == 0) {
                SinglePlayer.this.f504v.vibrate(50);
                canvas.drawBitmap(SinglePlayer.this.box3, SinglePlayer.this.w1, SinglePlayer.this.h1, null);
                SinglePlayer.this.array[0][0] = 2;
                SinglePlayer singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            }
            if (SinglePlayer.this.f505x > SinglePlayer.this.w2 && SinglePlayer.this.f506y > SinglePlayer.this.h1 && SinglePlayer.this.f505x < SinglePlayer.this.lineH2 && SinglePlayer.this.f506y < SinglePlayer.this.lineV1 && SinglePlayer.this.array[0][1] == 0) {
                SinglePlayer.this.f504v.vibrate(50);
                canvas.drawBitmap(SinglePlayer.this.box3, SinglePlayer.this.w2, SinglePlayer.this.h1, null);
                SinglePlayer.this.array[0][1] = 2;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            }
            if (SinglePlayer.this.f505x > SinglePlayer.this.w3 && SinglePlayer.this.f506y > SinglePlayer.this.h1 && SinglePlayer.this.f506y < SinglePlayer.this.lineV1 && SinglePlayer.this.array[0][2] == 0) {
                SinglePlayer.this.f504v.vibrate(50);
                canvas.drawBitmap(SinglePlayer.this.box3, SinglePlayer.this.w3, SinglePlayer.this.h1, null);
                SinglePlayer.this.array[0][2] = 2;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            }
            if (SinglePlayer.this.f505x > SinglePlayer.this.w1 && SinglePlayer.this.f506y > SinglePlayer.this.h2 && SinglePlayer.this.f505x < SinglePlayer.this.lineH1 && SinglePlayer.this.f506y < SinglePlayer.this.lineV2 && SinglePlayer.this.array[1][0] == 0) {
                SinglePlayer.this.f504v.vibrate(50);
                canvas.drawBitmap(SinglePlayer.this.box3, SinglePlayer.this.w1, SinglePlayer.this.h2, null);
                SinglePlayer.this.array[1][0] = 2;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            }
            if (SinglePlayer.this.f505x > SinglePlayer.this.w2 && SinglePlayer.this.f506y > SinglePlayer.this.h2 && SinglePlayer.this.f505x < SinglePlayer.this.lineH2 && SinglePlayer.this.f506y < SinglePlayer.this.lineV2 && SinglePlayer.this.array[1][1] == 0) {
                SinglePlayer.this.f504v.vibrate(50);
                canvas.drawBitmap(SinglePlayer.this.box3, SinglePlayer.this.w2, SinglePlayer.this.h2, null);
                SinglePlayer.this.array[1][1] = 2;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            }
            if (SinglePlayer.this.f505x > SinglePlayer.this.w3 && SinglePlayer.this.f506y > SinglePlayer.this.h2 && SinglePlayer.this.f506y < SinglePlayer.this.lineV2 && SinglePlayer.this.array[1][2] == 0) {
                SinglePlayer.this.f504v.vibrate(50);
                canvas.drawBitmap(SinglePlayer.this.box3, SinglePlayer.this.w3, SinglePlayer.this.h2, null);
                SinglePlayer.this.array[1][2] = 2;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            }
            if (SinglePlayer.this.f505x > SinglePlayer.this.w1 && SinglePlayer.this.f506y > SinglePlayer.this.h3 && SinglePlayer.this.f505x < SinglePlayer.this.lineH1 && SinglePlayer.this.array[2][0] == 0) {
                SinglePlayer.this.f504v.vibrate(50);
                canvas.drawBitmap(SinglePlayer.this.box3, SinglePlayer.this.w1, SinglePlayer.this.h3, null);
                SinglePlayer.this.array[2][0] = 2;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            }
            if (SinglePlayer.this.f505x > SinglePlayer.this.w2 && SinglePlayer.this.f506y > SinglePlayer.this.h3 && SinglePlayer.this.f505x < SinglePlayer.this.lineH2 && SinglePlayer.this.array[2][1] == 0) {
                SinglePlayer.this.f504v.vibrate(50);
                canvas.drawBitmap(SinglePlayer.this.box3, SinglePlayer.this.w2, SinglePlayer.this.h3, null);
                SinglePlayer.this.array[2][1] = 2;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            }
            if (SinglePlayer.this.f505x > SinglePlayer.this.w3 && SinglePlayer.this.f506y > SinglePlayer.this.h3 && SinglePlayer.this.array[2][2] == 0) {
                SinglePlayer.this.f504v.vibrate(50);
                canvas.drawBitmap(SinglePlayer.this.box3, SinglePlayer.this.w3, SinglePlayer.this.h3, null);
                SinglePlayer.this.array[2][2] = 2;
                singlePlayer = SinglePlayer.this;
                singlePlayer.chance++;
            }
        }

        private void checkWinner(Canvas canvas, Paint myPaint) {
            int count = 0;
            for (int l = 0; l < 3; l++) {
                for (int m = 0; m < 3; m++) {
                    if (SinglePlayer.this.array[l][m] != 0) {
                        count++;
                    }
                }
            }
            if (count == 9) {
                drawGame();
            }
            while (this.check) {
                if (SinglePlayer.this.array[0][0] == 1 && SinglePlayer.this.array[1][0] == 1 && SinglePlayer.this.array[2][0] == 1) {
                    canvas.drawText("Player 1 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.clineH1, SinglePlayer.this.h1, SinglePlayer.this.clineH1, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winPlayer11();
                    return;
                } else if (SinglePlayer.this.array[0][1] == 1 && SinglePlayer.this.array[1][1] == 1 && SinglePlayer.this.array[2][1] == 1) {
                    canvas.drawText("Player 1 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.clineH2, SinglePlayer.this.h1, SinglePlayer.this.clineH2, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winPlayer11();
                    return;
                } else if (SinglePlayer.this.array[0][2] == 1 && SinglePlayer.this.array[1][2] == 1 && SinglePlayer.this.array[2][2] == 1) {
                    canvas.drawText("Player 1 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.clineH3, SinglePlayer.this.h1, SinglePlayer.this.clineH3, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winPlayer11();
                    return;
                } else if (SinglePlayer.this.array[0][0] == 2 && SinglePlayer.this.array[1][0] == 2 && SinglePlayer.this.array[2][0] == 2) {
                    canvas.drawText("CPU Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.clineH1, SinglePlayer.this.h1, SinglePlayer.this.clineH1, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winCPU();
                    return;
                } else if (SinglePlayer.this.array[0][1] == 2 && SinglePlayer.this.array[1][1] == 2 && SinglePlayer.this.array[2][1] == 2) {
                    canvas.drawText("CPU Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.clineH2, SinglePlayer.this.h1, SinglePlayer.this.clineH2, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winCPU();
                    return;
                } else if (SinglePlayer.this.array[0][2] == 2 && SinglePlayer.this.array[1][2] == 2 && SinglePlayer.this.array[2][2] == 2) {
                    canvas.drawText("CPU Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.clineH3, SinglePlayer.this.h1, SinglePlayer.this.clineH3, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winCPU();
                    return;
                } else if (SinglePlayer.this.array[0][0] == 1 && SinglePlayer.this.array[0][1] == 1 && SinglePlayer.this.array[0][2] == 1) {
                    canvas.drawText("Player 1 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.gapH, SinglePlayer.this.clineV1, SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.clineV1, myPaint);
                    winPlayer11();
                    return;
                } else if (SinglePlayer.this.array[1][0] == 1 && SinglePlayer.this.array[1][1] == 1 && SinglePlayer.this.array[1][2] == 1) {
                    canvas.drawText("Player 1 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.gapH, SinglePlayer.this.clineV2, SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.clineV2, myPaint);
                    winPlayer11();
                    return;
                } else if (SinglePlayer.this.array[2][0] == 1 && SinglePlayer.this.array[2][1] == 1 && SinglePlayer.this.array[2][2] == 1) {
                    canvas.drawText("Player 1 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.gapH, SinglePlayer.this.clineV3, SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.clineV3, myPaint);
                    winPlayer11();
                    return;
                } else if (SinglePlayer.this.array[0][0] == 2 && SinglePlayer.this.array[0][1] == 2 && SinglePlayer.this.array[0][2] == 2) {
                    canvas.drawText("CPU Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.gapH, SinglePlayer.this.clineV1, SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.clineV1, myPaint);
                    winCPU();
                    return;
                } else if (SinglePlayer.this.array[1][0] == 2 && SinglePlayer.this.array[1][1] == 2 && SinglePlayer.this.array[1][2] == 2) {
                    canvas.drawText("CPU Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.gapH, SinglePlayer.this.clineV2, SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.clineV2, myPaint);
                    winCPU();
                    return;
                } else if (SinglePlayer.this.array[2][0] == 2 && SinglePlayer.this.array[2][1] == 2 && SinglePlayer.this.array[2][2] == 2) {
                    canvas.drawText("CPU Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.gapH, SinglePlayer.this.clineV3, SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.clineV3, myPaint);
                    winCPU();
                    return;
                } else if (SinglePlayer.this.array[0][0] == 1 && SinglePlayer.this.array[1][1] == 1 && SinglePlayer.this.array[2][2] == 1) {
                    canvas.drawText("Player 1 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.gapH, SinglePlayer.this.h1, SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winPlayer11();
                    return;
                } else if (SinglePlayer.this.array[0][2] == 1 && SinglePlayer.this.array[1][1] == 1 && SinglePlayer.this.array[2][0] == 1) {
                    canvas.drawText("Player 1 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.h1, SinglePlayer.this.gapH, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winPlayer11();
                    return;
                } else if (SinglePlayer.this.array[0][0] == 2 && SinglePlayer.this.array[1][1] == 2 && SinglePlayer.this.array[2][2] == 2) {
                    canvas.drawText("CPU Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.gapH, SinglePlayer.this.h1, SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winCPU();
                    return;
                } else if (SinglePlayer.this.array[0][2] == 2 && SinglePlayer.this.array[1][1] == 2 && SinglePlayer.this.array[2][0] == 2) {
                    canvas.drawText("CPU Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.h1, SinglePlayer.this.gapH, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winCPU();
                    return;
                } else {
                    this.check = false;
                }
            }
        }

        private void checkWinner2(Canvas canvas, Paint myPaint) {
            int count = 0;
            for (int l = 0; l < 3; l++) {
                for (int m = 0; m < 3; m++) {
                    if (SinglePlayer.this.array[l][m] != 0) {
                        count++;
                    }
                }
            }
            if (count == 9) {
                drawGame();
            }
            while (this.check) {
                if (SinglePlayer.this.array[0][0] == 1 && SinglePlayer.this.array[1][0] == 1 && SinglePlayer.this.array[2][0] == 1) {
                    canvas.drawText("Player 1 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.clineH1, SinglePlayer.this.h1, SinglePlayer.this.clineH1, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winPlayer1();
                    return;
                } else if (SinglePlayer.this.array[0][1] == 1 && SinglePlayer.this.array[1][1] == 1 && SinglePlayer.this.array[2][1] == 1) {
                    canvas.drawText("Player 1 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.clineH2, SinglePlayer.this.h1, SinglePlayer.this.clineH2, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winPlayer1();
                    return;
                } else if (SinglePlayer.this.array[0][2] == 1 && SinglePlayer.this.array[1][2] == 1 && SinglePlayer.this.array[2][2] == 1) {
                    canvas.drawText("Player 1 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.clineH3, SinglePlayer.this.h1, SinglePlayer.this.clineH3, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winPlayer1();
                    return;
                } else if (SinglePlayer.this.array[0][0] == 2 && SinglePlayer.this.array[1][0] == 2 && SinglePlayer.this.array[2][0] == 2) {
                    canvas.drawText("Player 2 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.clineH1, SinglePlayer.this.h1, SinglePlayer.this.clineH1, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winPlayer2();
                    return;
                } else if (SinglePlayer.this.array[0][1] == 2 && SinglePlayer.this.array[1][1] == 2 && SinglePlayer.this.array[2][1] == 2) {
                    canvas.drawText("Player 2 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.clineH2, SinglePlayer.this.h1, SinglePlayer.this.clineH2, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winPlayer2();
                    return;
                } else if (SinglePlayer.this.array[0][2] == 2 && SinglePlayer.this.array[1][2] == 2 && SinglePlayer.this.array[2][2] == 2) {
                    canvas.drawText("Player 2 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.clineH3, SinglePlayer.this.h1, SinglePlayer.this.clineH3, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winPlayer2();
                    return;
                } else if (SinglePlayer.this.array[0][0] == 1 && SinglePlayer.this.array[0][1] == 1 && SinglePlayer.this.array[0][2] == 1) {
                    canvas.drawText("Player 1 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.gapH, SinglePlayer.this.clineV1, SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.clineV1, myPaint);
                    winPlayer1();
                    return;
                } else if (SinglePlayer.this.array[1][0] == 1 && SinglePlayer.this.array[1][1] == 1 && SinglePlayer.this.array[1][2] == 1) {
                    canvas.drawText("Player 1 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.gapH, SinglePlayer.this.clineV2, SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.clineV2, myPaint);
                    winPlayer1();
                    return;
                } else if (SinglePlayer.this.array[2][0] == 1 && SinglePlayer.this.array[2][1] == 1 && SinglePlayer.this.array[2][2] == 1) {
                    canvas.drawText("Player 1 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.gapH, SinglePlayer.this.clineV3, SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.clineV3, myPaint);
                    winPlayer1();
                    return;
                } else if (SinglePlayer.this.array[0][0] == 2 && SinglePlayer.this.array[0][1] == 2 && SinglePlayer.this.array[0][2] == 2) {
                    canvas.drawText("Player 2 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.gapH, SinglePlayer.this.clineV1, SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.clineV1, myPaint);
                    winPlayer2();
                    return;
                } else if (SinglePlayer.this.array[1][0] == 2 && SinglePlayer.this.array[1][1] == 2 && SinglePlayer.this.array[1][2] == 2) {
                    canvas.drawText("Player 2 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.gapH, SinglePlayer.this.clineV2, SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.clineV2, myPaint);
                    winPlayer2();
                    return;
                } else if (SinglePlayer.this.array[2][0] == 2 && SinglePlayer.this.array[2][1] == 2 && SinglePlayer.this.array[2][2] == 2) {
                    canvas.drawText("Player 2 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.gapH, SinglePlayer.this.clineV3, SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.clineV3, myPaint);
                    winPlayer2();
                    return;
                } else if (SinglePlayer.this.array[0][0] == 1 && SinglePlayer.this.array[1][1] == 1 && SinglePlayer.this.array[2][2] == 1) {
                    canvas.drawText("Player 1 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.gapH, SinglePlayer.this.h1, SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winPlayer1();
                    return;
                } else if (SinglePlayer.this.array[0][2] == 1 && SinglePlayer.this.array[1][1] == 1 && SinglePlayer.this.array[2][0] == 1) {
                    canvas.drawText("Player 1 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.h1, SinglePlayer.this.gapH, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winPlayer1();
                    return;
                } else if (SinglePlayer.this.array[0][0] == 2 && SinglePlayer.this.array[1][1] == 2 && SinglePlayer.this.array[2][2] == 2) {
                    canvas.drawText("Player 2 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.gapH, SinglePlayer.this.h1, SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winPlayer2();
                    return;
                } else if (SinglePlayer.this.array[0][2] == 2 && SinglePlayer.this.array[1][1] == 2 && SinglePlayer.this.array[2][0] == 2) {
                    canvas.drawText("Player 2 Win", (float) (canvas.getWidth() / 2), SinglePlayer.this.h1 - 70.0f, myPaint);
                    canvas.drawLine(SinglePlayer.this.boxWidth + SinglePlayer.this.w3, SinglePlayer.this.h1, SinglePlayer.this.gapH, SinglePlayer.this.boxHeight + SinglePlayer.this.h3, myPaint);
                    winPlayer2();
                    return;
                } else {
                    this.check = false;
                }
            }
        }

        private void postDraw(Canvas canvas) {
            if (SinglePlayer.this.array[0][0] == 1) {
                canvas.drawBitmap(SinglePlayer.this.box2, SinglePlayer.this.w1, SinglePlayer.this.h1, null);
            }
            if (SinglePlayer.this.array[0][1] == 1) {
                canvas.drawBitmap(SinglePlayer.this.box2, SinglePlayer.this.w2, SinglePlayer.this.h1, null);
            }
            if (SinglePlayer.this.array[0][2] == 1) {
                canvas.drawBitmap(SinglePlayer.this.box2, SinglePlayer.this.w3, SinglePlayer.this.h1, null);
            }
            if (SinglePlayer.this.array[1][0] == 1) {
                canvas.drawBitmap(SinglePlayer.this.box2, SinglePlayer.this.w1, SinglePlayer.this.h2, null);
            }
            if (SinglePlayer.this.array[1][1] == 1) {
                canvas.drawBitmap(SinglePlayer.this.box2, SinglePlayer.this.w2, SinglePlayer.this.h2, null);
            }
            if (SinglePlayer.this.array[1][2] == 1) {
                canvas.drawBitmap(SinglePlayer.this.box2, SinglePlayer.this.w3, SinglePlayer.this.h2, null);
            }
            if (SinglePlayer.this.array[2][0] == 1) {
                canvas.drawBitmap(SinglePlayer.this.box2, SinglePlayer.this.w1, SinglePlayer.this.h3, null);
            }
            if (SinglePlayer.this.array[2][1] == 1) {
                canvas.drawBitmap(SinglePlayer.this.box2, SinglePlayer.this.w2, SinglePlayer.this.h3, null);
            }
            if (SinglePlayer.this.array[2][2] == 1) {
                canvas.drawBitmap(SinglePlayer.this.box2, SinglePlayer.this.w3, SinglePlayer.this.h3, null);
            }
            if (SinglePlayer.this.array[0][0] == 2) {
                canvas.drawBitmap(SinglePlayer.this.box3, SinglePlayer.this.w1, SinglePlayer.this.h1, null);
            }
            if (SinglePlayer.this.array[0][1] == 2) {
                canvas.drawBitmap(SinglePlayer.this.box3, SinglePlayer.this.w2, SinglePlayer.this.h1, null);
            }
            if (SinglePlayer.this.array[0][2] == 2) {
                canvas.drawBitmap(SinglePlayer.this.box3, SinglePlayer.this.w3, SinglePlayer.this.h1, null);
            }
            if (SinglePlayer.this.array[1][0] == 2) {
                canvas.drawBitmap(SinglePlayer.this.box3, SinglePlayer.this.w1, SinglePlayer.this.h2, null);
            }
            if (SinglePlayer.this.array[1][1] == 2) {
                canvas.drawBitmap(SinglePlayer.this.box3, SinglePlayer.this.w2, SinglePlayer.this.h2, null);
            }
            if (SinglePlayer.this.array[1][2] == 2) {
                canvas.drawBitmap(SinglePlayer.this.box3, SinglePlayer.this.w3, SinglePlayer.this.h2, null);
            }
            if (SinglePlayer.this.array[2][0] == 2) {
                canvas.drawBitmap(SinglePlayer.this.box3, SinglePlayer.this.w1, SinglePlayer.this.h3, null);
            }
            if (SinglePlayer.this.array[2][1] == 2) {
                canvas.drawBitmap(SinglePlayer.this.box3, SinglePlayer.this.w2, SinglePlayer.this.h3, null);
            }
            if (SinglePlayer.this.array[2][2] == 2) {
                canvas.drawBitmap(SinglePlayer.this.box3, SinglePlayer.this.w3, SinglePlayer.this.h3, null);
            }
        }

        private void preDraw(Canvas canvas) {
            if (SinglePlayer.this.array[0][0] == 0) {
                canvas.drawBitmap(SinglePlayer.this.box1, SinglePlayer.this.w1, SinglePlayer.this.h1, null);
            }
            if (SinglePlayer.this.array[0][1] == 0) {
                canvas.drawBitmap(SinglePlayer.this.box1, SinglePlayer.this.w2, SinglePlayer.this.h1, null);
            }
            if (SinglePlayer.this.array[0][2] == 0) {
                canvas.drawBitmap(SinglePlayer.this.box1, SinglePlayer.this.w3, SinglePlayer.this.h1, null);
            }
            if (SinglePlayer.this.array[1][0] == 0) {
                canvas.drawBitmap(SinglePlayer.this.box1, SinglePlayer.this.w1, SinglePlayer.this.h2, null);
            }
            if (SinglePlayer.this.array[1][1] == 0) {
                canvas.drawBitmap(SinglePlayer.this.box1, SinglePlayer.this.w2, SinglePlayer.this.h2, null);
            }
            if (SinglePlayer.this.array[1][2] == 0) {
                canvas.drawBitmap(SinglePlayer.this.box1, SinglePlayer.this.w3, SinglePlayer.this.h2, null);
            }
            if (SinglePlayer.this.array[2][0] == 0) {
                canvas.drawBitmap(SinglePlayer.this.box1, SinglePlayer.this.w1, SinglePlayer.this.h3, null);
            }
            if (SinglePlayer.this.array[2][1] == 0) {
                canvas.drawBitmap(SinglePlayer.this.box1, SinglePlayer.this.w2, SinglePlayer.this.h3, null);
            }
            if (SinglePlayer.this.array[2][2] == 0) {
                canvas.drawBitmap(SinglePlayer.this.box1, SinglePlayer.this.w3, SinglePlayer.this.h3, null);
            }
        }
    }

    public SinglePlayer() {
        this.array = new int[][]{new int[3], new int[3], new int[3]};
        this.chance = 1;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        getWindow().addFlags(TransportMediator.FLAG_KEY_MEDIA_NEXT);
        this.f504v = (Vibrator) getSystemService("vibrator");
        this.myCase = Integer.parseInt(getIntent().getExtras().getString("myCase"));
        this.background = new Background1(this);
        AdView adView = new AdView(this, AdView.BANNER_TYPE_IN_APP_AD, IM.PLACEMENT_TYPE_INTERSTITIAL, false, false, IM.ANIMATION_TYPE_LEFT_TO_RIGHT);
        adView.setAdListener(this);
        RelativeLayout ll = new RelativeLayout(this);
        LayoutParams lay = new LayoutParams(-2, -2);
        lay.addRule(12);
        ll.addView(this.background);
        ll.addView(adView, lay);
        this.background.setOnTouchListener(this);
        this.back = BitmapFactory.decodeResource(getResources(), C0047R.drawable.backg);
        this.box1 = BitmapFactory.decodeResource(getResources(), C0047R.drawable.box);
        this.box2 = BitmapFactory.decodeResource(getResources(), C0047R.drawable.cross);
        this.box3 = BitmapFactory.decodeResource(getResources(), C0047R.drawable.zero);
        this.f506y = 0.0f;
        this.f505x = 0.0f;
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
        this.background.pause();
    }

    protected void onResume() {
        super.onResume();
        this.background.resume();
    }

    public boolean onTouch(View v, MotionEvent event) {
        this.f505x = event.getX();
        this.f506y = event.getY();
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
