package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.games.OnGamesLoadedListener;
import com.google.android.gms.games.OnPlayersLoadedListener;
import com.google.android.gms.games.OnSignOutCompleteListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.OnAchievementUpdatedListener;
import com.google.android.gms.games.achievement.OnAchievementsLoadedListener;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.OnLeaderboardMetadataLoadedListener;
import com.google.android.gms.games.leaderboard.OnLeaderboardScoresLoadedListener;
import com.google.android.gms.games.leaderboard.OnScoreSubmittedListener;
import com.google.android.gms.games.leaderboard.SubmitScoreResult;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.OnInvitationsLoadedListener;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.C0573a;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeReliableMessageSentListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.internal.de.C0135b;
import com.google.android.gms.internal.de.C0412c;
import com.google.android.gms.internal.de.C0579d;
import com.google.android.gms.internal.er.C0435a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class em extends de<er> {
    private final String it;
    private final String mF;
    private final Map<String, et> mG;
    private PlayerEntity mH;
    private GameEntity mI;
    private final es mJ;
    private boolean mK;
    private final Binder mL;
    private final long mM;
    private final boolean mN;

    final class ag extends C0135b<RealTimeReliableMessageSentListener> {
        private final int iC;
        final /* synthetic */ em mP;
        private final String nf;
        private final int ng;

        ag(em emVar, RealTimeReliableMessageSentListener realTimeReliableMessageSentListener, int i, int i2, String str) {
            this.mP = emVar;
            super(emVar, realTimeReliableMessageSentListener);
            this.iC = i;
            this.ng = i2;
            this.nf = str;
        }

        public void m1320a(RealTimeReliableMessageSentListener realTimeReliableMessageSentListener) {
            if (realTimeReliableMessageSentListener != null) {
                realTimeReliableMessageSentListener.onRealTimeMessageSent(this.iC, this.ng, this.nf);
            }
        }

        protected void aF() {
        }
    }

    final class ao extends C0135b<OnSignOutCompleteListener> {
        final /* synthetic */ em mP;

        public ao(em emVar, OnSignOutCompleteListener onSignOutCompleteListener) {
            this.mP = emVar;
            super(emVar, onSignOutCompleteListener);
        }

        public void m1322a(OnSignOutCompleteListener onSignOutCompleteListener) {
            onSignOutCompleteListener.onSignOutComplete();
        }

        protected void aF() {
        }
    }

    final class aq extends C0135b<OnScoreSubmittedListener> {
        final /* synthetic */ em mP;
        private final SubmitScoreResult nn;

        public aq(em emVar, OnScoreSubmittedListener onScoreSubmittedListener, SubmitScoreResult submitScoreResult) {
            this.mP = emVar;
            super(emVar, onScoreSubmittedListener);
            this.nn = submitScoreResult;
        }

        public void m1324a(OnScoreSubmittedListener onScoreSubmittedListener) {
            onScoreSubmittedListener.onScoreSubmitted(this.nn.getStatusCode(), this.nn);
        }

        protected void aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.em.e */
    final class C0425e extends C0135b<OnAchievementUpdatedListener> {
        private final int iC;
        final /* synthetic */ em mP;
        private final String mR;

        C0425e(em emVar, OnAchievementUpdatedListener onAchievementUpdatedListener, int i, String str) {
            this.mP = emVar;
            super(emVar, onAchievementUpdatedListener);
            this.iC = i;
            this.mR = str;
        }

        protected void m1326a(OnAchievementUpdatedListener onAchievementUpdatedListener) {
            onAchievementUpdatedListener.onAchievementUpdated(this.iC, this.mR);
        }

        protected void aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.em.m */
    final class C0426m extends C0135b<OnInvitationReceivedListener> {
        final /* synthetic */ em mP;
        private final Invitation mV;

        C0426m(em emVar, OnInvitationReceivedListener onInvitationReceivedListener, Invitation invitation) {
            this.mP = emVar;
            super(emVar, onInvitationReceivedListener);
            this.mV = invitation;
        }

        protected void m1328a(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.mV);
        }

        protected void aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.em.r */
    final class C0427r extends C0135b<OnLeaderboardScoresLoadedListener> {
        final /* synthetic */ em mP;
        private final C0345d mY;
        private final C0345d mZ;

        C0427r(em emVar, OnLeaderboardScoresLoadedListener onLeaderboardScoresLoadedListener, C0345d c0345d, C0345d c0345d2) {
            this.mP = emVar;
            super(emVar, onLeaderboardScoresLoadedListener);
            this.mY = c0345d;
            this.mZ = c0345d2;
        }

        protected void m1330a(OnLeaderboardScoresLoadedListener onLeaderboardScoresLoadedListener) {
            C0345d c0345d = null;
            C0345d c0345d2 = this.mY;
            C0345d c0345d3 = this.mZ;
            if (onLeaderboardScoresLoadedListener != null) {
                try {
                    onLeaderboardScoresLoadedListener.onLeaderboardScoresLoaded(c0345d3.getStatusCode(), new LeaderboardBuffer(c0345d2), new LeaderboardScoreBuffer(c0345d3));
                    c0345d3 = null;
                } catch (Throwable th) {
                    if (c0345d2 != null) {
                        c0345d2.close();
                    }
                    if (c0345d3 != null) {
                        c0345d3.close();
                    }
                }
            } else {
                c0345d = c0345d3;
                c0345d3 = c0345d2;
            }
            if (c0345d3 != null) {
                c0345d3.close();
            }
            if (c0345d != null) {
                c0345d.close();
            }
        }

        protected void aF() {
            if (this.mY != null) {
                this.mY.close();
            }
            if (this.mZ != null) {
                this.mZ.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.em.u */
    final class C0428u extends C0135b<RoomUpdateListener> {
        private final int iC;
        final /* synthetic */ em mP;
        private final String nb;

        C0428u(em emVar, RoomUpdateListener roomUpdateListener, int i, String str) {
            this.mP = emVar;
            super(emVar, roomUpdateListener);
            this.iC = i;
            this.nb = str;
        }

        public void m1332a(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.iC, this.nb);
        }

        protected void aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.em.v */
    final class C0429v extends C0135b<RealTimeMessageReceivedListener> {
        final /* synthetic */ em mP;
        private final RealTimeMessage nc;

        C0429v(em emVar, RealTimeMessageReceivedListener realTimeMessageReceivedListener, RealTimeMessage realTimeMessage) {
            this.mP = emVar;
            super(emVar, realTimeMessageReceivedListener);
            this.nc = realTimeMessage;
        }

        public void m1334a(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            ep.m454b("GamesClient", "Deliver Message received callback");
            if (realTimeMessageReceivedListener != null) {
                realTimeMessageReceivedListener.onRealTimeMessageReceived(this.nc);
            }
        }

        protected void aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.em.w */
    final class C0430w extends C0135b<RoomStatusUpdateListener> {
        final /* synthetic */ em mP;
        private final String nd;

        C0430w(em emVar, RoomStatusUpdateListener roomStatusUpdateListener, String str) {
            this.mP = emVar;
            super(emVar, roomStatusUpdateListener);
            this.nd = str;
        }

        public void m1336a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PConnected(this.nd);
            }
        }

        protected void aF() {
        }
    }

    /* renamed from: com.google.android.gms.internal.em.x */
    final class C0431x extends C0135b<RoomStatusUpdateListener> {
        final /* synthetic */ em mP;
        private final String nd;

        C0431x(em emVar, RoomStatusUpdateListener roomStatusUpdateListener, String str) {
            this.mP = emVar;
            super(emVar, roomStatusUpdateListener);
            this.nd = str;
        }

        public void m1338a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PDisconnected(this.nd);
            }
        }

        protected void aF() {
        }
    }

    final class af extends C0412c<OnPlayersLoadedListener> {
        final /* synthetic */ em mP;

        af(em emVar, OnPlayersLoadedListener onPlayersLoadedListener, C0345d c0345d) {
            this.mP = emVar;
            super(emVar, onPlayersLoadedListener, c0345d);
        }

        protected void m1859a(OnPlayersLoadedListener onPlayersLoadedListener, C0345d c0345d) {
            onPlayersLoadedListener.onPlayersLoaded(c0345d.getStatusCode(), new PlayerBuffer(c0345d));
        }
    }

    /* renamed from: com.google.android.gms.internal.em.b */
    abstract class C0580b extends C0412c<RoomUpdateListener> {
        final /* synthetic */ em mP;

        C0580b(em emVar, RoomUpdateListener roomUpdateListener, C0345d c0345d) {
            this.mP = emVar;
            super(emVar, roomUpdateListener, c0345d);
        }

        protected void m1861a(RoomUpdateListener roomUpdateListener, C0345d c0345d) {
            m1862a(roomUpdateListener, this.mP.m1877x(c0345d), c0345d.getStatusCode());
        }

        protected abstract void m1862a(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    /* renamed from: com.google.android.gms.internal.em.c */
    abstract class C0581c extends C0412c<RoomStatusUpdateListener> {
        final /* synthetic */ em mP;

        C0581c(em emVar, RoomStatusUpdateListener roomStatusUpdateListener, C0345d c0345d) {
            this.mP = emVar;
            super(emVar, roomStatusUpdateListener, c0345d);
        }

        protected void m1864a(RoomStatusUpdateListener roomStatusUpdateListener, C0345d c0345d) {
            m1865a(roomStatusUpdateListener, this.mP.m1877x(c0345d));
        }

        protected abstract void m1865a(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    /* renamed from: com.google.android.gms.internal.em.g */
    final class C0582g extends C0412c<OnAchievementsLoadedListener> {
        final /* synthetic */ em mP;

        C0582g(em emVar, OnAchievementsLoadedListener onAchievementsLoadedListener, C0345d c0345d) {
            this.mP = emVar;
            super(emVar, onAchievementsLoadedListener, c0345d);
        }

        protected void m1867a(OnAchievementsLoadedListener onAchievementsLoadedListener, C0345d c0345d) {
            onAchievementsLoadedListener.onAchievementsLoaded(c0345d.getStatusCode(), new AchievementBuffer(c0345d));
        }
    }

    /* renamed from: com.google.android.gms.internal.em.k */
    final class C0583k extends C0412c<OnGamesLoadedListener> {
        final /* synthetic */ em mP;

        C0583k(em emVar, OnGamesLoadedListener onGamesLoadedListener, C0345d c0345d) {
            this.mP = emVar;
            super(emVar, onGamesLoadedListener, c0345d);
        }

        protected void m1869a(OnGamesLoadedListener onGamesLoadedListener, C0345d c0345d) {
            onGamesLoadedListener.onGamesLoaded(c0345d.getStatusCode(), new GameBuffer(c0345d));
        }
    }

    /* renamed from: com.google.android.gms.internal.em.o */
    final class C0584o extends C0412c<OnInvitationsLoadedListener> {
        final /* synthetic */ em mP;

        C0584o(em emVar, OnInvitationsLoadedListener onInvitationsLoadedListener, C0345d c0345d) {
            this.mP = emVar;
            super(emVar, onInvitationsLoadedListener, c0345d);
        }

        protected void m1871a(OnInvitationsLoadedListener onInvitationsLoadedListener, C0345d c0345d) {
            onInvitationsLoadedListener.onInvitationsLoaded(c0345d.getStatusCode(), new InvitationBuffer(c0345d));
        }
    }

    /* renamed from: com.google.android.gms.internal.em.t */
    final class C0585t extends C0412c<OnLeaderboardMetadataLoadedListener> {
        final /* synthetic */ em mP;

        C0585t(em emVar, OnLeaderboardMetadataLoadedListener onLeaderboardMetadataLoadedListener, C0345d c0345d) {
            this.mP = emVar;
            super(emVar, onLeaderboardMetadataLoadedListener, c0345d);
        }

        protected void m1873a(OnLeaderboardMetadataLoadedListener onLeaderboardMetadataLoadedListener, C0345d c0345d) {
            onLeaderboardMetadataLoadedListener.onLeaderboardMetadataLoaded(c0345d.getStatusCode(), new LeaderboardBuffer(c0345d));
        }
    }

    /* renamed from: com.google.android.gms.internal.em.a */
    abstract class C0620a extends C0581c {
        private final ArrayList<String> mO;
        final /* synthetic */ em mP;

        C0620a(em emVar, RoomStatusUpdateListener roomStatusUpdateListener, C0345d c0345d, String[] strArr) {
            this.mP = emVar;
            super(emVar, roomStatusUpdateListener, c0345d);
            this.mO = new ArrayList();
            for (Object add : strArr) {
                this.mO.add(add);
            }
        }

        protected void m2088a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            m2089a(roomStatusUpdateListener, room, this.mO);
        }

        protected abstract void m2089a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    final class ae extends el {
        final /* synthetic */ em mP;
        private final OnPlayersLoadedListener ne;

        ae(em emVar, OnPlayersLoadedListener onPlayersLoadedListener) {
            this.mP = emVar;
            this.ne = (OnPlayersLoadedListener) dm.m388a((Object) onPlayersLoadedListener, (Object) "Listener must not be null");
        }

        public void m2090e(C0345d c0345d) {
            this.mP.m1243a(new af(this.mP, this.ne, c0345d));
        }
    }

    final class ah extends el {
        final /* synthetic */ em mP;
        final RealTimeReliableMessageSentListener nh;

        public ah(em emVar, RealTimeReliableMessageSentListener realTimeReliableMessageSentListener) {
            this.mP = emVar;
            this.nh = realTimeReliableMessageSentListener;
        }

        public void m2091a(int i, int i2, String str) {
            this.mP.m1243a(new ag(this.mP, this.nh, i, i2, str));
        }
    }

    final class ai extends C0581c {
        final /* synthetic */ em mP;

        ai(em emVar, RoomStatusUpdateListener roomStatusUpdateListener, C0345d c0345d) {
            this.mP = emVar;
            super(emVar, roomStatusUpdateListener, c0345d);
        }

        public void m2092a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    final class aj extends el {
        final /* synthetic */ em mP;
        private final RoomUpdateListener ni;
        private final RoomStatusUpdateListener nj;
        private final RealTimeMessageReceivedListener nk;

        public aj(em emVar, RoomUpdateListener roomUpdateListener) {
            this.mP = emVar;
            this.ni = (RoomUpdateListener) dm.m388a((Object) roomUpdateListener, (Object) "Callbacks must not be null");
            this.nj = null;
            this.nk = null;
        }

        public aj(em emVar, RoomUpdateListener roomUpdateListener, RoomStatusUpdateListener roomStatusUpdateListener, RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            this.mP = emVar;
            this.ni = (RoomUpdateListener) dm.m388a((Object) roomUpdateListener, (Object) "Callbacks must not be null");
            this.nj = roomStatusUpdateListener;
            this.nk = realTimeMessageReceivedListener;
        }

        public void m2093a(C0345d c0345d, String[] strArr) {
            this.mP.m1243a(new ab(this.mP, this.nj, c0345d, strArr));
        }

        public void m2094b(C0345d c0345d, String[] strArr) {
            this.mP.m1243a(new ac(this.mP, this.nj, c0345d, strArr));
        }

        public void m2095c(C0345d c0345d, String[] strArr) {
            this.mP.m1243a(new ad(this.mP, this.nj, c0345d, strArr));
        }

        public void m2096d(C0345d c0345d, String[] strArr) {
            this.mP.m1243a(new C0636z(this.mP, this.nj, c0345d, strArr));
        }

        public void m2097e(C0345d c0345d, String[] strArr) {
            this.mP.m1243a(new C0635y(this.mP, this.nj, c0345d, strArr));
        }

        public void m2098f(C0345d c0345d, String[] strArr) {
            this.mP.m1243a(new aa(this.mP, this.nj, c0345d, strArr));
        }

        public void m2099n(C0345d c0345d) {
            this.mP.m1243a(new am(this.mP, this.ni, c0345d));
        }

        public void m2100o(C0345d c0345d) {
            this.mP.m1243a(new C0628p(this.mP, this.ni, c0345d));
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            this.mP.m1243a(new C0428u(this.mP, this.ni, statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            this.mP.m1243a(new C0430w(this.mP, this.nj, participantId));
        }

        public void onP2PDisconnected(String participantId) {
            this.mP.m1243a(new C0431x(this.mP, this.nj, participantId));
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            ep.m454b("GamesClient", "RoomBinderCallbacks: onRealTimeMessageReceived");
            this.mP.m1243a(new C0429v(this.mP, this.nk, message));
        }

        public void m2101p(C0345d c0345d) {
            this.mP.m1243a(new al(this.mP, this.nj, c0345d));
        }

        public void m2102q(C0345d c0345d) {
            this.mP.m1243a(new ai(this.mP, this.nj, c0345d));
        }

        public void m2103r(C0345d c0345d) {
            this.mP.m1243a(new ak(this.mP, this.ni, c0345d));
        }

        public void m2104s(C0345d c0345d) {
            this.mP.m1243a(new C0623h(this.mP, this.nj, c0345d));
        }

        public void m2105t(C0345d c0345d) {
            this.mP.m1243a(new C0624i(this.mP, this.nj, c0345d));
        }
    }

    final class ak extends C0580b {
        final /* synthetic */ em mP;

        ak(em emVar, RoomUpdateListener roomUpdateListener, C0345d c0345d) {
            this.mP = emVar;
            super(emVar, roomUpdateListener, c0345d);
        }

        public void m2106a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    final class al extends C0581c {
        final /* synthetic */ em mP;

        al(em emVar, RoomStatusUpdateListener roomStatusUpdateListener, C0345d c0345d) {
            this.mP = emVar;
            super(emVar, roomStatusUpdateListener, c0345d);
        }

        public void m2107a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    final class am extends C0580b {
        final /* synthetic */ em mP;

        public am(em emVar, RoomUpdateListener roomUpdateListener, C0345d c0345d) {
            this.mP = emVar;
            super(emVar, roomUpdateListener, c0345d);
        }

        public void m2108a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    final class an extends el {
        final /* synthetic */ em mP;
        private final OnSignOutCompleteListener nl;

        public an(em emVar, OnSignOutCompleteListener onSignOutCompleteListener) {
            this.mP = emVar;
            this.nl = (OnSignOutCompleteListener) dm.m388a((Object) onSignOutCompleteListener, (Object) "Listener must not be null");
        }

        public void onSignOutComplete() {
            this.mP.m1243a(new ao(this.mP, this.nl));
        }
    }

    final class ap extends el {
        final /* synthetic */ em mP;
        private final OnScoreSubmittedListener nm;

        public ap(em emVar, OnScoreSubmittedListener onScoreSubmittedListener) {
            this.mP = emVar;
            this.nm = (OnScoreSubmittedListener) dm.m388a((Object) onScoreSubmittedListener, (Object) "Listener must not be null");
        }

        public void m2109d(C0345d c0345d) {
            this.mP.m1243a(new aq(this.mP, this.nm, new SubmitScoreResult(c0345d)));
        }
    }

    /* renamed from: com.google.android.gms.internal.em.d */
    final class C0621d extends el {
        final /* synthetic */ em mP;
        private final OnAchievementUpdatedListener mQ;

        C0621d(em emVar, OnAchievementUpdatedListener onAchievementUpdatedListener) {
            this.mP = emVar;
            this.mQ = (OnAchievementUpdatedListener) dm.m388a((Object) onAchievementUpdatedListener, (Object) "Listener must not be null");
        }

        public void onAchievementUpdated(int statusCode, String achievementId) {
            this.mP.m1243a(new C0425e(this.mP, this.mQ, statusCode, achievementId));
        }
    }

    /* renamed from: com.google.android.gms.internal.em.f */
    final class C0622f extends el {
        final /* synthetic */ em mP;
        private final OnAchievementsLoadedListener mS;

        C0622f(em emVar, OnAchievementsLoadedListener onAchievementsLoadedListener) {
            this.mP = emVar;
            this.mS = (OnAchievementsLoadedListener) dm.m388a((Object) onAchievementsLoadedListener, (Object) "Listener must not be null");
        }

        public void m2110b(C0345d c0345d) {
            this.mP.m1243a(new C0582g(this.mP, this.mS, c0345d));
        }
    }

    /* renamed from: com.google.android.gms.internal.em.h */
    final class C0623h extends C0581c {
        final /* synthetic */ em mP;

        C0623h(em emVar, RoomStatusUpdateListener roomStatusUpdateListener, C0345d c0345d) {
            this.mP = emVar;
            super(emVar, roomStatusUpdateListener, c0345d);
        }

        public void m2111a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    /* renamed from: com.google.android.gms.internal.em.i */
    final class C0624i extends C0581c {
        final /* synthetic */ em mP;

        C0624i(em emVar, RoomStatusUpdateListener roomStatusUpdateListener, C0345d c0345d) {
            this.mP = emVar;
            super(emVar, roomStatusUpdateListener, c0345d);
        }

        public void m2112a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    /* renamed from: com.google.android.gms.internal.em.j */
    final class C0625j extends el {
        final /* synthetic */ em mP;
        private final OnGamesLoadedListener mT;

        C0625j(em emVar, OnGamesLoadedListener onGamesLoadedListener) {
            this.mP = emVar;
            this.mT = (OnGamesLoadedListener) dm.m388a((Object) onGamesLoadedListener, (Object) "Listener must not be null");
        }

        public void m2113g(C0345d c0345d) {
            this.mP.m1243a(new C0583k(this.mP, this.mT, c0345d));
        }
    }

    /* renamed from: com.google.android.gms.internal.em.l */
    final class C0626l extends el {
        final /* synthetic */ em mP;
        private final OnInvitationReceivedListener mU;

        C0626l(em emVar, OnInvitationReceivedListener onInvitationReceivedListener) {
            this.mP = emVar;
            this.mU = onInvitationReceivedListener;
        }

        public void m2114k(C0345d c0345d) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(c0345d);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                invitationBuffer.close();
                if (invitation != null) {
                    this.mP.m1243a(new C0426m(this.mP, this.mU, invitation));
                }
            } catch (Throwable th) {
                invitationBuffer.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.em.n */
    final class C0627n extends el {
        final /* synthetic */ em mP;
        private final OnInvitationsLoadedListener mW;

        C0627n(em emVar, OnInvitationsLoadedListener onInvitationsLoadedListener) {
            this.mP = emVar;
            this.mW = onInvitationsLoadedListener;
        }

        public void m2115j(C0345d c0345d) {
            this.mP.m1243a(new C0584o(this.mP, this.mW, c0345d));
        }
    }

    /* renamed from: com.google.android.gms.internal.em.p */
    final class C0628p extends C0580b {
        final /* synthetic */ em mP;

        public C0628p(em emVar, RoomUpdateListener roomUpdateListener, C0345d c0345d) {
            this.mP = emVar;
            super(emVar, roomUpdateListener, c0345d);
        }

        public void m2116a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    /* renamed from: com.google.android.gms.internal.em.q */
    final class C0629q extends el {
        final /* synthetic */ em mP;
        private final OnLeaderboardScoresLoadedListener mX;

        C0629q(em emVar, OnLeaderboardScoresLoadedListener onLeaderboardScoresLoadedListener) {
            this.mP = emVar;
            this.mX = (OnLeaderboardScoresLoadedListener) dm.m388a((Object) onLeaderboardScoresLoadedListener, (Object) "Listener must not be null");
        }

        public void m2117a(C0345d c0345d, C0345d c0345d2) {
            this.mP.m1243a(new C0427r(this.mP, this.mX, c0345d, c0345d2));
        }
    }

    /* renamed from: com.google.android.gms.internal.em.s */
    final class C0630s extends el {
        final /* synthetic */ em mP;
        private final OnLeaderboardMetadataLoadedListener na;

        C0630s(em emVar, OnLeaderboardMetadataLoadedListener onLeaderboardMetadataLoadedListener) {
            this.mP = emVar;
            this.na = (OnLeaderboardMetadataLoadedListener) dm.m388a((Object) onLeaderboardMetadataLoadedListener, (Object) "Listener must not be null");
        }

        public void m2118c(C0345d c0345d) {
            this.mP.m1243a(new C0585t(this.mP, this.na, c0345d));
        }
    }

    final class aa extends C0620a {
        final /* synthetic */ em mP;

        aa(em emVar, RoomStatusUpdateListener roomStatusUpdateListener, C0345d c0345d, String[] strArr) {
            this.mP = emVar;
            super(emVar, roomStatusUpdateListener, c0345d, strArr);
        }

        protected void m2125a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    final class ab extends C0620a {
        final /* synthetic */ em mP;

        ab(em emVar, RoomStatusUpdateListener roomStatusUpdateListener, C0345d c0345d, String[] strArr) {
            this.mP = emVar;
            super(emVar, roomStatusUpdateListener, c0345d, strArr);
        }

        protected void m2126a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    final class ac extends C0620a {
        final /* synthetic */ em mP;

        ac(em emVar, RoomStatusUpdateListener roomStatusUpdateListener, C0345d c0345d, String[] strArr) {
            this.mP = emVar;
            super(emVar, roomStatusUpdateListener, c0345d, strArr);
        }

        protected void m2127a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    final class ad extends C0620a {
        final /* synthetic */ em mP;

        ad(em emVar, RoomStatusUpdateListener roomStatusUpdateListener, C0345d c0345d, String[] strArr) {
            this.mP = emVar;
            super(emVar, roomStatusUpdateListener, c0345d, strArr);
        }

        protected void m2128a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    /* renamed from: com.google.android.gms.internal.em.y */
    final class C0635y extends C0620a {
        final /* synthetic */ em mP;

        C0635y(em emVar, RoomStatusUpdateListener roomStatusUpdateListener, C0345d c0345d, String[] strArr) {
            this.mP = emVar;
            super(emVar, roomStatusUpdateListener, c0345d, strArr);
        }

        protected void m2129a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    /* renamed from: com.google.android.gms.internal.em.z */
    final class C0636z extends C0620a {
        final /* synthetic */ em mP;

        C0636z(em emVar, RoomStatusUpdateListener roomStatusUpdateListener, C0345d c0345d, String[] strArr) {
            this.mP = emVar;
            super(emVar, roomStatusUpdateListener, c0345d, strArr);
        }

        protected void m2130a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    public em(Context context, String str, String str2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String[] strArr, int i, View view, boolean z) {
        super(context, connectionCallbacks, onConnectionFailedListener, strArr);
        this.mK = false;
        this.mF = str;
        this.it = (String) dm.m392e(str2);
        this.mL = new Binder();
        this.mG = new HashMap();
        this.mJ = es.m568a(this, i);
        setViewForPopups(view);
        this.mM = (long) hashCode();
        this.mN = z;
    }

    private et m1875K(String str) {
        try {
            String M = ((er) bd()).m495M(str);
            if (M == null) {
                return null;
            }
            ep.m457e("GamesClient", "Creating a socket to bind to:" + M);
            LocalSocket localSocket = new LocalSocket();
            try {
                localSocket.connect(new LocalSocketAddress(M));
                et etVar = new et(localSocket, str);
                this.mG.put(str, etVar);
                return etVar;
            } catch (IOException e) {
                ep.m456d("GamesClient", "connect() call failed on socket: " + e.getMessage());
                return null;
            }
        } catch (RemoteException e2) {
            ep.m456d("GamesClient", "Unable to create socket. Service died.");
            return null;
        }
    }

    private void bR() {
        this.mH = null;
    }

    private void bS() {
        for (et close : this.mG.values()) {
            try {
                close.close();
            } catch (Throwable e) {
                ep.m453a("GamesClient", "IOException:", e);
            }
        }
        this.mG.clear();
    }

    private Room m1877x(C0345d c0345d) {
        C0573a c0573a = new C0573a(c0345d);
        Room room = null;
        try {
            if (c0573a.getCount() > 0) {
                room = (Room) ((Room) c0573a.get(0)).freeze();
            }
            c0573a.close();
            return room;
        } catch (Throwable th) {
            c0573a.close();
        }
    }

    protected er m1878A(IBinder iBinder) {
        return C0435a.m1451C(iBinder);
    }

    public int m1879a(byte[] bArr, String str, String[] strArr) {
        dm.m388a((Object) strArr, (Object) "Participant IDs must not be null");
        try {
            return ((er) bd()).m523b(bArr, str, strArr);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
            return -1;
        }
    }

    protected void m1880a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null) {
            this.mK = bundle.getBoolean("show_welcome_popup");
        }
        super.m1241a(i, iBinder, bundle);
    }

    public void m1881a(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((er) bd()).m500a(iBinder, bundle);
            } catch (RemoteException e) {
                ep.m455c("GamesClient", "service died");
            }
        }
    }

    protected void m1882a(ConnectionResult connectionResult) {
        super.m1242a(connectionResult);
        this.mK = false;
    }

    public void m1883a(OnPlayersLoadedListener onPlayersLoadedListener, int i, boolean z, boolean z2) {
        try {
            ((er) bd()).m503a(new ae(this, onPlayersLoadedListener), i, z, z2);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void m1884a(OnAchievementUpdatedListener onAchievementUpdatedListener, String str) {
        if (onAchievementUpdatedListener == null) {
            eq eqVar = null;
        } else {
            Object c0621d = new C0621d(this, onAchievementUpdatedListener);
        }
        try {
            ((er) bd()).m515a(eqVar, str, this.mJ.bZ(), this.mJ.bY());
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void m1885a(OnAchievementUpdatedListener onAchievementUpdatedListener, String str, int i) {
        try {
            ((er) bd()).m510a(onAchievementUpdatedListener == null ? null : new C0621d(this, onAchievementUpdatedListener), str, i, this.mJ.bZ(), this.mJ.bY());
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void m1886a(OnScoreSubmittedListener onScoreSubmittedListener, String str, long j, String str2) {
        try {
            ((er) bd()).m514a(onScoreSubmittedListener == null ? null : new ap(this, onScoreSubmittedListener), str, j, str2);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    protected void m1887a(dj djVar, C0579d c0579d) throws RemoteException {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.mN);
        djVar.m375a(c0579d, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.it, aY(), this.mF, this.mJ.bZ(), locale, bundle);
    }

    protected void m1888a(String... strArr) {
        int i = 0;
        boolean z = false;
        for (String str : strArr) {
            if (str.equals(Scopes.GAMES)) {
                z = true;
            } else if (str.equals("https://www.googleapis.com/auth/games.firstparty")) {
                i = 1;
            }
        }
        if (i != 0) {
            dm.m389a(!z, String.format("Cannot have both %s and %s!", new Object[]{Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty"}));
            return;
        }
        dm.m389a(z, String.format("GamesClient requires %s to function.", new Object[]{Scopes.GAMES}));
    }

    protected void aZ() {
        super.aZ();
        if (this.mK) {
            this.mJ.bX();
            this.mK = false;
        }
    }

    protected String ag() {
        return "com.google.android.gms.games.service.START";
    }

    protected String ah() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void m1889b(OnAchievementUpdatedListener onAchievementUpdatedListener, String str) {
        if (onAchievementUpdatedListener == null) {
            eq eqVar = null;
        } else {
            Object c0621d = new C0621d(this, onAchievementUpdatedListener);
        }
        try {
            ((er) bd()).m530b(eqVar, str, this.mJ.bZ(), this.mJ.bY());
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void m1890b(OnAchievementUpdatedListener onAchievementUpdatedListener, String str, int i) {
        try {
            ((er) bd()).m528b(onAchievementUpdatedListener == null ? null : new C0621d(this, onAchievementUpdatedListener), str, i, this.mJ.bZ(), this.mJ.bY());
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void bT() {
        if (isConnected()) {
            try {
                ((er) bd()).bT();
            } catch (RemoteException e) {
                ep.m455c("GamesClient", "service died");
            }
        }
    }

    protected Bundle ba() {
        try {
            Bundle ba = ((er) bd()).ba();
            if (ba == null) {
                return ba;
            }
            ba.setClassLoader(em.class.getClassLoader());
            return ba;
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
            return null;
        }
    }

    public void clearNotifications(int notificationTypes) {
        try {
            ((er) bd()).clearNotifications(notificationTypes);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void connect() {
        bR();
        super.connect();
    }

    public void createRoom(RoomConfig config) {
        try {
            ((er) bd()).m506a(new aj(this, config.getRoomUpdateListener(), config.getRoomStatusUpdateListener(), config.getMessageReceivedListener()), this.mL, config.getVariant(), config.getInvitedPlayerIds(), config.getAutoMatchCriteria(), config.isSocketEnabled(), this.mM);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void disconnect() {
        this.mK = false;
        if (isConnected()) {
            try {
                er erVar = (er) bd();
                erVar.bT();
                erVar.m554g(this.mM);
                erVar.m550f(this.mM);
            } catch (RemoteException e) {
                ep.m455c("GamesClient", "Failed to notify client disconnect.");
            }
        }
        bS();
        super.disconnect();
    }

    public Intent getAchievementsIntent() {
        bc();
        Intent intent = new Intent("com.google.android.gms.games.VIEW_ACHIEVEMENTS");
        intent.addFlags(67108864);
        return eo.m452c(intent);
    }

    public Intent getAllLeaderboardsIntent() {
        bc();
        Intent intent = new Intent("com.google.android.gms.games.VIEW_LEADERBOARDS");
        intent.putExtra("com.google.android.gms.games.GAME_PACKAGE_NAME", this.mF);
        intent.addFlags(67108864);
        return eo.m452c(intent);
    }

    public String getAppId() {
        try {
            return ((er) bd()).getAppId();
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
            return null;
        }
    }

    public String getCurrentAccountName() {
        try {
            return ((er) bd()).getCurrentAccountName();
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
            return null;
        }
    }

    public Game getCurrentGame() {
        bc();
        synchronized (this) {
            if (this.mI == null) {
                GameBuffer gameBuffer;
                try {
                    gameBuffer = new GameBuffer(((er) bd()).bW());
                    if (gameBuffer.getCount() > 0) {
                        this.mI = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.close();
                } catch (RemoteException e) {
                    ep.m455c("GamesClient", "service died");
                } catch (Throwable th) {
                    gameBuffer.close();
                }
            }
        }
        return this.mI;
    }

    public Player getCurrentPlayer() {
        bc();
        synchronized (this) {
            if (this.mH == null) {
                PlayerBuffer playerBuffer;
                try {
                    playerBuffer = new PlayerBuffer(((er) bd()).bU());
                    if (playerBuffer.getCount() > 0) {
                        this.mH = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.close();
                } catch (RemoteException e) {
                    ep.m455c("GamesClient", "service died");
                } catch (Throwable th) {
                    playerBuffer.close();
                }
            }
        }
        return this.mH;
    }

    public String getCurrentPlayerId() {
        try {
            return ((er) bd()).getCurrentPlayerId();
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
            return null;
        }
    }

    public Intent getInvitationInboxIntent() {
        bc();
        Intent intent = new Intent("com.google.android.gms.games.SHOW_INVITATIONS");
        intent.putExtra("com.google.android.gms.games.GAME_PACKAGE_NAME", this.mF);
        return eo.m452c(intent);
    }

    public Intent getLeaderboardIntent(String leaderboardId) {
        bc();
        Intent intent = new Intent("com.google.android.gms.games.VIEW_LEADERBOARD_SCORES");
        intent.putExtra("com.google.android.gms.games.LEADERBOARD_ID", leaderboardId);
        intent.addFlags(67108864);
        return eo.m452c(intent);
    }

    public RealTimeSocket getRealTimeSocketForParticipant(String roomId, String participantId) {
        if (participantId == null || !ParticipantUtils.m153Q(participantId)) {
            throw new IllegalArgumentException("Bad participant ID");
        }
        et etVar = (et) this.mG.get(participantId);
        return (etVar == null || etVar.isClosed()) ? m1875K(participantId) : etVar;
    }

    public Intent getRealTimeWaitingRoomIntent(Room room, int minParticipantsToStart) {
        bc();
        Intent intent = new Intent("com.google.android.gms.games.SHOW_REAL_TIME_WAITING_ROOM");
        dm.m388a((Object) room, (Object) "Room parameter must not be null");
        intent.putExtra(GamesClient.EXTRA_ROOM, (Parcelable) room.freeze());
        dm.m389a(minParticipantsToStart >= 0, (Object) "minParticipantsToStart must be >= 0");
        intent.putExtra("com.google.android.gms.games.MIN_PARTICIPANTS_TO_START", minParticipantsToStart);
        return eo.m452c(intent);
    }

    public Intent getSelectPlayersIntent(int minPlayers, int maxPlayers) {
        bc();
        Intent intent = new Intent("com.google.android.gms.games.SELECT_PLAYERS");
        intent.putExtra("com.google.android.gms.games.MIN_SELECTIONS", minPlayers);
        intent.putExtra("com.google.android.gms.games.MAX_SELECTIONS", maxPlayers);
        return eo.m452c(intent);
    }

    public Intent getSettingsIntent() {
        bc();
        Intent intent = new Intent("com.google.android.gms.games.SHOW_SETTINGS");
        intent.putExtra("com.google.android.gms.games.GAME_PACKAGE_NAME", this.mF);
        intent.addFlags(67108864);
        return eo.m452c(intent);
    }

    public void m1891i(String str, int i) {
        try {
            ((er) bd()).m561i(str, i);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void m1892j(String str, int i) {
        try {
            ((er) bd()).m563j(str, i);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void joinRoom(RoomConfig config) {
        try {
            ((er) bd()).m507a(new aj(this, config.getRoomUpdateListener(), config.getRoomStatusUpdateListener(), config.getMessageReceivedListener()), this.mL, config.getInvitationId(), config.isSocketEnabled(), this.mM);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void leaveRoom(RoomUpdateListener listener, String roomId) {
        try {
            ((er) bd()).m549e(new aj(this, listener), roomId);
            bS();
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void loadAchievements(OnAchievementsLoadedListener listener, boolean forceReload) {
        try {
            ((er) bd()).m535b(new C0622f(this, listener), forceReload);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void loadGame(OnGamesLoadedListener listener) {
        try {
            ((er) bd()).m542d(new C0625j(this, listener));
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void loadInvitations(OnInvitationsLoadedListener listener) {
        try {
            ((er) bd()).m547e(new C0627n(this, listener));
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void loadLeaderboardMetadata(OnLeaderboardMetadataLoadedListener listener, String leaderboardId, boolean forceReload) {
        try {
            ((er) bd()).m540c(new C0630s(this, listener), leaderboardId, forceReload);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void loadLeaderboardMetadata(OnLeaderboardMetadataLoadedListener listener, boolean forceReload) {
        try {
            ((er) bd()).m541c(new C0630s(this, listener), forceReload);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void loadMoreScores(OnLeaderboardScoresLoadedListener listener, LeaderboardScoreBuffer buffer, int maxResults, int pageDirection) {
        try {
            ((er) bd()).m505a(new C0629q(this, listener), buffer.cb().cc(), maxResults, pageDirection);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void loadPlayer(OnPlayersLoadedListener listener, String playerId) {
        try {
            ((er) bd()).m538c(new ae(this, listener), playerId);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void loadPlayerCenteredScores(OnLeaderboardScoresLoadedListener listener, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        try {
            ((er) bd()).m527b(new C0629q(this, listener), leaderboardId, span, leaderboardCollection, maxResults, forceReload);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void loadTopScores(OnLeaderboardScoresLoadedListener listener, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        try {
            ((er) bd()).m509a(new C0629q(this, listener), leaderboardId, span, leaderboardCollection, maxResults, forceReload);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    protected /* synthetic */ IInterface m1893p(IBinder iBinder) {
        return m1878A(iBinder);
    }

    public void registerInvitationListener(OnInvitationReceivedListener listener) {
        try {
            ((er) bd()).m504a(new C0626l(this, listener), this.mM);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public int sendReliableRealTimeMessage(RealTimeReliableMessageSentListener listener, byte[] messageData, String roomId, String recipientParticipantId) {
        try {
            return ((er) bd()).m499a(new ah(this, listener), messageData, roomId, recipientParticipantId);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
            return -1;
        }
    }

    public int sendUnreliableRealTimeMessageToAll(byte[] messageData, String roomId) {
        try {
            return ((er) bd()).m523b(messageData, roomId, null);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
            return -1;
        }
    }

    public void setGravityForPopups(int gravity) {
        this.mJ.setGravity(gravity);
    }

    public void setUseNewPlayerNotificationsFirstParty(boolean newPlayerStyle) {
        try {
            ((er) bd()).setUseNewPlayerNotificationsFirstParty(newPlayerStyle);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void setViewForPopups(View gamesContentView) {
        this.mJ.m570e(gamesContentView);
    }

    public void signOut(OnSignOutCompleteListener listener) {
        if (listener == null) {
            eq eqVar = null;
        } else {
            Object anVar = new an(this, listener);
        }
        try {
            ((er) bd()).m501a(eqVar);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }

    public void unregisterInvitationListener() {
        try {
            ((er) bd()).m554g(this.mM);
        } catch (RemoteException e) {
            ep.m455c("GamesClient", "service died");
        }
    }
}
