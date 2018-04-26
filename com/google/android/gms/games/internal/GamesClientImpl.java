package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.C0603b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.C0609a;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.IGamesService.Stub;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.ExtendedGameBuffer;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.internal.gx;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.C0345b;
import com.google.android.gms.internal.hb.C0747d;
import com.google.android.gms.internal.hb.C1092e;
import com.google.android.gms.internal.hi;
import com.google.android.gms.internal.hm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class GamesClientImpl extends hb<IGamesService> implements ConnectionCallbacks, OnConnectionFailedListener {
    private final boolean NA;
    private final int NB;
    private final boolean NC;
    private final String ND;
    EventIncrementManager Np = new C06631(this);
    private final String Nq;
    private final Map<String, RealTimeSocket> Nr;
    private PlayerEntity Ns;
    private GameEntity Nt;
    private final PopupManager Nu;
    private boolean Nv = false;
    private boolean Nw = false;
    private int Nx;
    private final Binder Ny;
    private final long Nz;
    private final String yQ;

    class C06631 extends EventIncrementManager {
        final /* synthetic */ GamesClientImpl NE;

        C06631(GamesClientImpl gamesClientImpl) {
            this.NE = gamesClientImpl;
        }

        public EventIncrementCache hx() {
            return new GameClientEventIncrementCache(this.NE);
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache {
        final /* synthetic */ GamesClientImpl NE;

        public GameClientEventIncrementCache(GamesClientImpl gamesClientImpl) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl.getContext().getMainLooper(), 1000);
        }

        protected void mo1127o(String str, int i) {
            try {
                ((IGamesService) this.NE.ft()).mo1364l(str, i);
            } catch (RemoteException e) {
                GamesLog.m482j("GamesClientImpl", "service died");
            }
        }
    }

    private final class InvitationReceivedCallback extends C0345b<OnInvitationReceivedListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final Invitation NP;

        InvitationReceivedCallback(GamesClientImpl gamesClientImpl, OnInvitationReceivedListener listener, Invitation invitation) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.NP = invitation;
        }

        protected void m2164b(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.NP);
        }

        protected /* synthetic */ void mo1128d(Object obj) {
            m2164b((OnInvitationReceivedListener) obj);
        }

        protected void fu() {
        }
    }

    private final class InvitationRemovedCallback extends C0345b<OnInvitationReceivedListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final String NQ;

        InvitationRemovedCallback(GamesClientImpl gamesClientImpl, OnInvitationReceivedListener listener, String invitationId) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.NQ = invitationId;
        }

        protected void m2166b(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.NQ);
        }

        protected /* synthetic */ void mo1128d(Object obj) {
            m2166b((OnInvitationReceivedListener) obj);
        }

        protected void fu() {
        }
    }

    private final class LeftRoomCallback extends C0345b<RoomUpdateListener> {
        private final int CT;
        final /* synthetic */ GamesClientImpl NE;
        private final String NS;

        LeftRoomCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, int statusCode, String roomId) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.CT = statusCode;
            this.NS = roomId;
        }

        public void m2168a(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.CT, this.NS);
        }

        public /* synthetic */ void mo1128d(Object obj) {
            m2168a((RoomUpdateListener) obj);
        }

        protected void fu() {
        }
    }

    private final class MatchRemovedCallback extends C0345b<OnTurnBasedMatchUpdateReceivedListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final String Oi;

        MatchRemovedCallback(GamesClientImpl gamesClientImpl, OnTurnBasedMatchUpdateReceivedListener listener, String matchId) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Oi = matchId;
        }

        protected void m2170b(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.Oi);
        }

        protected /* synthetic */ void mo1128d(Object obj) {
            m2170b((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        protected void fu() {
        }
    }

    private final class MatchUpdateReceivedCallback extends C0345b<OnTurnBasedMatchUpdateReceivedListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final TurnBasedMatch Ok;

        MatchUpdateReceivedCallback(GamesClientImpl gamesClientImpl, OnTurnBasedMatchUpdateReceivedListener listener, TurnBasedMatch match) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Ok = match;
        }

        protected void m2172b(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.Ok);
        }

        protected /* synthetic */ void mo1128d(Object obj) {
            m2172b((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        protected void fu() {
        }
    }

    private final class MessageReceivedCallback extends C0345b<RealTimeMessageReceivedListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final RealTimeMessage Ol;

        MessageReceivedCallback(GamesClientImpl gamesClientImpl, RealTimeMessageReceivedListener listener, RealTimeMessage message) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Ol = message;
        }

        public void m2174a(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            if (realTimeMessageReceivedListener != null) {
                realTimeMessageReceivedListener.onRealTimeMessageReceived(this.Ol);
            }
        }

        public /* synthetic */ void mo1128d(Object obj) {
            m2174a((RealTimeMessageReceivedListener) obj);
        }

        protected void fu() {
        }
    }

    private final class P2PConnectedCallback extends C0345b<RoomStatusUpdateListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final String Oq;

        P2PConnectedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, String participantId) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Oq = participantId;
        }

        public void m2176a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PConnected(this.Oq);
            }
        }

        public /* synthetic */ void mo1128d(Object obj) {
            m2176a((RoomStatusUpdateListener) obj);
        }

        protected void fu() {
        }
    }

    private final class P2PDisconnectedCallback extends C0345b<RoomStatusUpdateListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final String Oq;

        P2PDisconnectedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, String participantId) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Oq = participantId;
        }

        public void m2178a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PDisconnected(this.Oq);
            }
        }

        public /* synthetic */ void mo1128d(Object obj) {
            m2178a((RoomStatusUpdateListener) obj);
        }

        protected void fu() {
        }
    }

    private final class QuestCompletedCallback extends C0345b<QuestUpdateListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final Quest NG;

        QuestCompletedCallback(GamesClientImpl gamesClientImpl, QuestUpdateListener listener, Quest quest) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.NG = quest;
        }

        protected void m2180b(QuestUpdateListener questUpdateListener) {
            questUpdateListener.onQuestCompleted(this.NG);
        }

        protected /* synthetic */ void mo1128d(Object obj) {
            m2180b((QuestUpdateListener) obj);
        }

        protected void fu() {
        }
    }

    private final class RealTimeMessageSentCallback extends C0345b<ReliableMessageSentCallback> {
        private final int CT;
        final /* synthetic */ GamesClientImpl NE;
        private final String Ow;
        private final int Ox;

        RealTimeMessageSentCallback(GamesClientImpl gamesClientImpl, ReliableMessageSentCallback listener, int statusCode, int token, String recipientParticipantId) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.CT = statusCode;
            this.Ox = token;
            this.Ow = recipientParticipantId;
        }

        public void m2182a(ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.CT, this.Ox, this.Ow);
            }
        }

        public /* synthetic */ void mo1128d(Object obj) {
            m2182a((ReliableMessageSentCallback) obj);
        }

        protected void fu() {
        }
    }

    private final class RequestReceivedCallback extends C0345b<OnRequestReceivedListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final GameRequest OA;

        RequestReceivedCallback(GamesClientImpl gamesClientImpl, OnRequestReceivedListener listener, GameRequest request) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.OA = request;
        }

        protected void m2184b(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.OA);
        }

        protected /* synthetic */ void mo1128d(Object obj) {
            m2184b((OnRequestReceivedListener) obj);
        }

        protected void fu() {
        }
    }

    private final class RequestRemovedCallback extends C0345b<OnRequestReceivedListener> {
        final /* synthetic */ GamesClientImpl NE;
        private final String OB;

        RequestRemovedCallback(GamesClientImpl gamesClientImpl, OnRequestReceivedListener listener, String requestId) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.OB = requestId;
        }

        protected void m2186b(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.OB);
        }

        protected /* synthetic */ void mo1128d(Object obj) {
            m2186b((OnRequestReceivedListener) obj);
        }

        protected void fu() {
        }
    }

    private abstract class AbstractRoomCallback extends C0747d<RoomUpdateListener> {
        final /* synthetic */ GamesClientImpl NE;

        AbstractRoomCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, DataHolder dataHolder) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        protected void m3327a(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            mo3141a(roomUpdateListener, this.NE.m3333Q(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void mo3141a(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    private abstract class AbstractRoomStatusCallback extends C0747d<RoomStatusUpdateListener> {
        final /* synthetic */ GamesClientImpl NE;

        AbstractRoomStatusCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        protected void m3330a(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            mo3140a(roomStatusUpdateListener, this.NE.m3333Q(dataHolder));
        }

        protected abstract void mo3140a(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    private static final class AcceptQuestResultImpl extends C0603b implements AcceptQuestResult {
        private final Quest NG;

        AcceptQuestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.NG = new QuestEntity((Quest) questBuffer.get(0));
                } else {
                    this.NG = null;
                }
                questBuffer.close();
            } catch (Throwable th) {
                questBuffer.close();
            }
        }

        public Quest getQuest() {
            return this.NG;
        }
    }

    private static final class CancelMatchResultImpl implements CancelMatchResult {
        private final String NH;
        private final Status yz;

        CancelMatchResultImpl(Status status, String externalMatchId) {
            this.yz = status;
            this.NH = externalMatchId;
        }

        public String getMatchId() {
            return this.NH;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static final class ClaimMilestoneResultImpl extends C0603b implements ClaimMilestoneResult {
        private final Quest NG;
        private final Milestone NI;

        ClaimMilestoneResultImpl(DataHolder dataHolder, String milestoneId) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.NG = new QuestEntity((Quest) questBuffer.get(0));
                    List iJ = this.NG.iJ();
                    int size = iJ.size();
                    for (int i = 0; i < size; i++) {
                        if (((Milestone) iJ.get(i)).getMilestoneId().equals(milestoneId)) {
                            this.NI = (Milestone) iJ.get(i);
                            return;
                        }
                    }
                    this.NI = null;
                } else {
                    this.NI = null;
                    this.NG = null;
                }
                questBuffer.close();
            } finally {
                questBuffer.close();
            }
        }

        public Milestone getMilestone() {
            return this.NI;
        }

        public Quest getQuest() {
            return this.NG;
        }
    }

    private static final class CommitSnapshotResultImpl extends C0603b implements CommitSnapshotResult {
        private final SnapshotMetadata NJ;

        CommitSnapshotResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.NJ = new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0));
                } else {
                    this.NJ = null;
                }
                snapshotMetadataBuffer.close();
            } catch (Throwable th) {
                snapshotMetadataBuffer.close();
            }
        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.NJ;
        }
    }

    private static final class ContactSettingLoadResultImpl extends C0603b implements ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class DeleteSnapshotResultImpl implements DeleteSnapshotResult {
        private final String NK;
        private final Status yz;

        DeleteSnapshotResultImpl(int statusCode, String snapshotId) {
            this.yz = new Status(statusCode);
            this.NK = snapshotId;
        }

        public String getSnapshotId() {
            return this.NK;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static final class GameMuteStatusChangeResultImpl implements GameMuteStatusChangeResult {
        private final String NL;
        private final boolean NM;
        private final Status yz;

        public GameMuteStatusChangeResultImpl(int statusCode, String externalGameId, boolean isMuted) {
            this.yz = new Status(statusCode);
            this.NL = externalGameId;
            this.NM = isMuted;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static final class GameMuteStatusLoadResultImpl implements GameMuteStatusLoadResult {
        private final String NL;
        private final boolean NM;
        private final Status yz;

        public GameMuteStatusLoadResultImpl(DataHolder dataHolder) {
            try {
                this.yz = new Status(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.NL = dataHolder.m2012c("external_game_id", 0, 0);
                    this.NM = dataHolder.m2013d("muted", 0, 0);
                } else {
                    this.NL = null;
                    this.NM = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static final class InboxCountResultImpl implements InboxCountResult {
        private final Bundle NN;
        private final Status yz;

        InboxCountResultImpl(Status status, Bundle inboxCounts) {
            this.yz = status;
            this.NN = inboxCounts;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static final class LeaderboardMetadataResultImpl extends C0603b implements LeaderboardMetadataResult {
        private final LeaderboardBuffer NR;

        LeaderboardMetadataResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.NR = new LeaderboardBuffer(dataHolder);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.NR;
        }
    }

    private static final class LoadAchievementsResultImpl extends C0603b implements LoadAchievementsResult {
        private final AchievementBuffer NT;

        LoadAchievementsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.NT = new AchievementBuffer(dataHolder);
        }

        public AchievementBuffer getAchievements() {
            return this.NT;
        }
    }

    private static final class LoadAclResultImpl extends C0603b implements LoadAclResult {
        LoadAclResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadEventResultImpl extends C0603b implements LoadEventsResult {
        private final EventBuffer NU;

        LoadEventResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.NU = new EventBuffer(dataHolder);
        }

        public EventBuffer getEvents() {
            return this.NU;
        }
    }

    private static final class LoadExtendedGamesResultImpl extends C0603b implements LoadExtendedGamesResult {
        private final ExtendedGameBuffer NV;

        LoadExtendedGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.NV = new ExtendedGameBuffer(dataHolder);
        }
    }

    private static final class LoadGameInstancesResultImpl extends C0603b implements LoadGameInstancesResult {
        private final GameInstanceBuffer NW;

        LoadGameInstancesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.NW = new GameInstanceBuffer(dataHolder);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends C0603b implements LoadGameSearchSuggestionsResult {
        LoadGameSearchSuggestionsResultImpl(DataHolder data) {
            super(data);
        }
    }

    private static final class LoadGamesResultImpl extends C0603b implements LoadGamesResult {
        private final GameBuffer NX;

        LoadGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.NX = new GameBuffer(dataHolder);
        }

        public GameBuffer getGames() {
            return this.NX;
        }
    }

    private static final class LoadInvitationsResultImpl extends C0603b implements LoadInvitationsResult {
        private final InvitationBuffer NY;

        LoadInvitationsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.NY = new InvitationBuffer(dataHolder);
        }

        public InvitationBuffer getInvitations() {
            return this.NY;
        }
    }

    private static final class LoadMatchesResultImpl implements LoadMatchesResult {
        private final LoadMatchesResponse NZ;
        private final Status yz;

        LoadMatchesResultImpl(Status status, Bundle matchData) {
            this.yz = status;
            this.NZ = new LoadMatchesResponse(matchData);
        }

        public LoadMatchesResponse getMatches() {
            return this.NZ;
        }

        public Status getStatus() {
            return this.yz;
        }

        public void release() {
            this.NZ.close();
        }
    }

    private static final class LoadOwnerCoverPhotoUrisResultImpl implements LoadOwnerCoverPhotoUrisResult {
        private final Bundle HM;
        private final Status yz;

        LoadOwnerCoverPhotoUrisResultImpl(int statusCode, Bundle bundle) {
            this.yz = new Status(statusCode);
            this.HM = bundle;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static final class LoadPlayerScoreResultImpl extends C0603b implements LoadPlayerScoreResult {
        private final LeaderboardScoreEntity Oa;

        LoadPlayerScoreResultImpl(DataHolder scoreHolder) {
            super(scoreHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(scoreHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.Oa = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.Oa = null;
                }
                leaderboardScoreBuffer.close();
            } catch (Throwable th) {
                leaderboardScoreBuffer.close();
            }
        }

        public LeaderboardScore getScore() {
            return this.Oa;
        }
    }

    private static final class LoadPlayersResultImpl extends C0603b implements LoadPlayersResult {
        private final PlayerBuffer Ob;

        LoadPlayersResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.Ob = new PlayerBuffer(dataHolder);
        }

        public PlayerBuffer getPlayers() {
            return this.Ob;
        }
    }

    private static final class LoadQuestsResultImpl extends C0603b implements LoadQuestsResult {
        private final DataHolder DG;

        LoadQuestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.DG = dataHolder;
        }

        public QuestBuffer getQuests() {
            return new QuestBuffer(this.DG);
        }
    }

    private static final class LoadRequestSummariesResultImpl extends C0603b implements LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadRequestsResultImpl implements LoadRequestsResult {
        private final Bundle Oc;
        private final Status yz;

        LoadRequestsResultImpl(Status status, Bundle requestData) {
            this.yz = status;
            this.Oc = requestData;
        }

        public GameRequestBuffer getRequests(int requestType) {
            String cm = RequestType.cm(requestType);
            return !this.Oc.containsKey(cm) ? null : new GameRequestBuffer((DataHolder) this.Oc.get(cm));
        }

        public Status getStatus() {
            return this.yz;
        }

        public void release() {
            for (String parcelable : this.Oc.keySet()) {
                DataHolder dataHolder = (DataHolder) this.Oc.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    private static final class LoadScoresResultImpl extends C0603b implements LoadScoresResult {
        private final LeaderboardEntity Od;
        private final LeaderboardScoreBuffer Oe;

        LoadScoresResultImpl(DataHolder leaderboard, DataHolder scores) {
            super(scores);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(leaderboard);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.Od = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.Od = null;
                }
                leaderboardBuffer.close();
                this.Oe = new LeaderboardScoreBuffer(scores);
            } catch (Throwable th) {
                leaderboardBuffer.close();
            }
        }

        public Leaderboard getLeaderboard() {
            return this.Od;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.Oe;
        }
    }

    private static final class LoadSnapshotsResultImpl extends C0603b implements LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }

        public SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.DG);
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl implements LoadXpForGameCategoriesResult {
        private final List<String> Of;
        private final Bundle Og;
        private final Status yz;

        LoadXpForGameCategoriesResultImpl(Status status, Bundle xpData) {
            this.yz = status;
            this.Of = xpData.getStringArrayList("game_category_list");
            this.Og = xpData;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static final class LoadXpStreamResultImpl extends C0603b implements LoadXpStreamResult {
        private final ExperienceEventBuffer Oh;

        LoadXpStreamResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.Oh = new ExperienceEventBuffer(dataHolder);
        }
    }

    private static final class OpenSnapshotResultImpl extends C0603b implements OpenSnapshotResult {
        private final Snapshot Om;
        private final String On;
        private final Snapshot Oo;
        private final Contents Op;

        OpenSnapshotResultImpl(DataHolder dataHolder, Contents currentContents) {
            this(dataHolder, null, currentContents, null, null);
        }

        OpenSnapshotResultImpl(DataHolder metadataHolder, String conflictId, Contents currentContents, Contents conflictContents, Contents resolutionContents) {
            boolean z = true;
            super(metadataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(metadataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.Om = null;
                    this.Oo = null;
                } else if (snapshotMetadataBuffer.getCount() == 1) {
                    if (metadataHolder.getStatusCode() == 4004) {
                        z = false;
                    }
                    gx.m1158A(z);
                    this.Om = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), currentContents);
                    this.Oo = null;
                } else {
                    this.Om = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), currentContents);
                    this.Oo = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), conflictContents);
                }
                snapshotMetadataBuffer.close();
                this.On = conflictId;
                this.Op = resolutionContents;
            } catch (Throwable th) {
                snapshotMetadataBuffer.close();
            }
        }

        public String getConflictId() {
            return this.On;
        }

        public Snapshot getConflictingSnapshot() {
            return this.Oo;
        }

        public Contents getResolutionContents() {
            return this.Op;
        }

        public Snapshot getSnapshot() {
            return this.Om;
        }
    }

    private static final class SendRequestResultImpl extends C0603b implements SendRequestResult {
        private final GameRequest OA;

        SendRequestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.OA = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                } else {
                    this.OA = null;
                }
                gameRequestBuffer.close();
            } catch (Throwable th) {
                gameRequestBuffer.close();
            }
        }
    }

    private static final class SubmitScoreResultImpl extends C0603b implements SubmitScoreResult {
        private final ScoreSubmissionData OM;

        public SubmitScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.OM = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public ScoreSubmissionData getScoreData() {
            return this.OM;
        }
    }

    private static abstract class TurnBasedMatchResult extends C0603b {
        final TurnBasedMatch Ok;

        TurnBasedMatchResult(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.Ok = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.Ok = null;
                }
                turnBasedMatchBuffer.close();
            } catch (Throwable th) {
                turnBasedMatchBuffer.close();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.Ok;
        }
    }

    private static final class UpdateAchievementResultImpl implements UpdateAchievementResult {
        private final String OT;
        private final Status yz;

        UpdateAchievementResultImpl(int statusCode, String achievementId) {
            this.yz = new Status(statusCode);
            this.OT = achievementId;
        }

        public String getAchievementId() {
            return this.OT;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static final class UpdateRequestsResultImpl extends C0603b implements UpdateRequestsResult {
        private final RequestUpdateOutcomes OU;

        UpdateRequestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.OU = RequestUpdateOutcomes.m738U(dataHolder);
        }

        public Set<String> getRequestIds() {
            return this.OU.getRequestIds();
        }

        public int getRequestOutcome(String requestId) {
            return this.OU.getRequestOutcome(requestId);
        }
    }

    private abstract class AbstractPeerStatusCallback extends AbstractRoomStatusCallback {
        final /* synthetic */ GamesClientImpl NE;
        private final ArrayList<String> NF = new ArrayList();

        AbstractPeerStatusCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
            for (Object add : participantIds) {
                this.NF.add(add);
            }
        }

        protected void mo3140a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            mo3151a(roomStatusUpdateListener, room, this.NF);
        }

        protected abstract void mo3151a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    private final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<UpdateAchievementResult> yR;

        AchievementUpdatedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<UpdateAchievementResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1165e(int i, String str) {
            this.yR.mo911a(new UpdateAchievementResultImpl(i, str));
        }
    }

    private final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadAchievementsResult> yR;

        AchievementsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<LoadAchievementsResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1155c(DataHolder dataHolder) {
            this.yR.mo911a(new LoadAchievementsResultImpl(dataHolder));
        }
    }

    private final class ConnectedToRoomCallback extends AbstractRoomStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        ConnectedToRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void mo3140a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    private final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<ContactSettingLoadResult> yR;

        ContactSettingsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<ContactSettingLoadResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void mo1133D(DataHolder dataHolder) {
            this.yR.mo911a(new ContactSettingLoadResultImpl(dataHolder));
        }
    }

    private final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<Status> yR;

        ContactSettingsUpdatedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<Status> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void ce(int i) {
            this.yR.mo911a(new Status(i));
        }
    }

    private final class DisconnectedFromRoomCallback extends AbstractRoomStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        DisconnectedFromRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void mo3140a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    private final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadEventsResult> yR;

        EventsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<LoadEventsResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1161d(DataHolder dataHolder) {
            this.yR.mo911a(new LoadEventResultImpl(dataHolder));
        }
    }

    private final class ExtendedGamesLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadExtendedGamesResult> yR;

        ExtendedGamesLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<LoadExtendedGamesResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void mo1176j(DataHolder dataHolder) {
            this.yR.mo911a(new LoadExtendedGamesResultImpl(dataHolder));
        }
    }

    private final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadGameInstancesResult> yR;

        GameInstancesLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<LoadGameInstancesResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void mo1177k(DataHolder dataHolder) {
            this.yR.mo911a(new LoadGameInstancesResultImpl(dataHolder));
        }
    }

    private final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<GameMuteStatusChangeResult> yR;

        GameMuteStatusChangedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<GameMuteStatusChangeResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void mo1146a(int i, String str, boolean z) {
            this.yR.mo911a(new GameMuteStatusChangeResultImpl(i, str, z));
        }
    }

    private final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<GameMuteStatusLoadResult> yR;

        GameMuteStatusLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<GameMuteStatusLoadResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void mo1131B(DataHolder dataHolder) {
            this.yR.mo911a(new GameMuteStatusLoadResultImpl(dataHolder));
        }
    }

    private final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadGameSearchSuggestionsResult> yR;

        GameSearchSuggestionsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<LoadGameSearchSuggestionsResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void mo1178l(DataHolder dataHolder) {
            this.yR.mo911a(new LoadGameSearchSuggestionsResultImpl(dataHolder));
        }
    }

    private final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadGamesResult> yR;

        GamesLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<LoadGamesResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void mo1175i(DataHolder dataHolder) {
            this.yR.mo911a(new LoadGamesResultImpl(dataHolder));
        }
    }

    private final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<InboxCountResult> yR;

        InboxCountsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<InboxCountResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void mo1168f(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.yR.mo911a(new InboxCountResultImpl(new Status(i), bundle));
        }
    }

    private static final class InitiateMatchResultImpl extends TurnBasedMatchResult implements InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final OnInvitationReceivedListener NO;

        InvitationReceivedBinderCallback(GamesClientImpl gamesClientImpl, OnInvitationReceivedListener listener) {
            this.NE = gamesClientImpl;
            this.NO = listener;
        }

        public void mo1180n(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                invitationBuffer.close();
                if (invitation != null) {
                    this.NE.m2664a(new InvitationReceivedCallback(this.NE, this.NO, invitation));
                }
            } catch (Throwable th) {
                invitationBuffer.close();
            }
        }

        public void onInvitationRemoved(String invitationId) {
            this.NE.m2664a(new InvitationRemovedCallback(this.NE, this.NO, invitationId));
        }
    }

    private final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadInvitationsResult> yR;

        InvitationsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<LoadInvitationsResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1179m(DataHolder dataHolder) {
            this.yR.mo911a(new LoadInvitationsResultImpl(dataHolder));
        }
    }

    private final class JoinedRoomCallback extends AbstractRoomCallback {
        final /* synthetic */ GamesClientImpl NE;

        public JoinedRoomCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, DataHolder dataHolder) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void mo3141a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    private final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadScoresResult> yR;

        LeaderboardScoresLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<LoadScoresResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1147a(DataHolder dataHolder, DataHolder dataHolder2) {
            this.yR.mo911a(new LoadScoresResultImpl(dataHolder, dataHolder2));
        }
    }

    private final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LeaderboardMetadataResult> yR;

        LeaderboardsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<LeaderboardMetadataResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1166e(DataHolder dataHolder) {
            this.yR.mo911a(new LeaderboardMetadataResultImpl(dataHolder));
        }
    }

    private static final class LeaveMatchResultImpl extends TurnBasedMatchResult implements LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadMatchResultImpl extends TurnBasedMatchResult implements LoadMatchResult {
        LoadMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final OnTurnBasedMatchUpdateReceivedListener Oj;

        MatchUpdateReceivedBinderCallback(GamesClientImpl gamesClientImpl, OnTurnBasedMatchUpdateReceivedListener listener) {
            this.NE = gamesClientImpl;
            this.Oj = listener;
        }

        public void onTurnBasedMatchRemoved(String matchId) {
            this.NE.m2664a(new MatchRemovedCallback(this.NE, this.Oj, matchId));
        }

        public void mo1193t(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                turnBasedMatchBuffer.close();
                if (turnBasedMatch != null) {
                    this.NE.m2664a(new MatchUpdateReceivedCallback(this.NE, this.Oj, turnBasedMatch));
                }
            } catch (Throwable th) {
                turnBasedMatchBuffer.close();
            }
        }
    }

    private final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadAclResult> yR;

        NotifyAclLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<LoadAclResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1132C(DataHolder dataHolder) {
            this.yR.mo911a(new LoadAclResultImpl(dataHolder));
        }
    }

    private final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<Status> yR;

        NotifyAclUpdatedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<Status> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void cd(int i) {
            this.yR.mo911a(new Status(i));
        }
    }

    private final class OwnerCoverPhotoUrisLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadOwnerCoverPhotoUrisResult> yR;

        OwnerCoverPhotoUrisLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<LoadOwnerCoverPhotoUrisResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void mo1159d(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.yR.mo911a(new LoadOwnerCoverPhotoUrisResultImpl(i, bundle));
        }
    }

    private final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadPlayerScoreResult> yR;

        PlayerLeaderboardScoreLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<LoadPlayerScoreResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1134E(DataHolder dataHolder) {
            this.yR.mo911a(new LoadPlayerScoreResultImpl(dataHolder));
        }
    }

    private final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadXpForGameCategoriesResult> yR;

        PlayerXpForGameCategoriesLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<LoadXpForGameCategoriesResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void mo1164e(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.yR.mo911a(new LoadXpForGameCategoriesResultImpl(new Status(i), bundle));
        }
    }

    final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadXpStreamResult> yR;

        PlayerXpStreamLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<LoadXpStreamResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void mo1145P(DataHolder dataHolder) {
            this.yR.mo911a(new LoadXpStreamResultImpl(dataHolder));
        }
    }

    private final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadPlayersResult> yR;

        PlayersLoadedBinderCallback(GamesClientImpl gamesClientImpl, C0152d<LoadPlayersResult> holder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) holder, (Object) "Holder must not be null");
        }

        public void mo1173g(DataHolder dataHolder) {
            this.yR.mo911a(new LoadPlayersResultImpl(dataHolder));
        }

        public void mo1174h(DataHolder dataHolder) {
            this.yR.mo911a(new LoadPlayersResultImpl(dataHolder));
        }
    }

    private final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<AcceptQuestResult> Or;

        public QuestAcceptedBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<AcceptQuestResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.Or = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1141L(DataHolder dataHolder) {
            this.Or.mo911a(new AcceptQuestResultImpl(dataHolder));
        }
    }

    private final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<ClaimMilestoneResult> Os;
        private final String Ot;

        public QuestMilestoneClaimBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<ClaimMilestoneResult> resultHolder, String milestoneId) {
            this.NE = gamesClientImpl;
            this.Os = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
            this.Ot = (String) hm.m1228b((Object) milestoneId, (Object) "MilestoneId must not be null");
        }

        public void mo1140K(DataHolder dataHolder) {
            this.Os.mo911a(new ClaimMilestoneResultImpl(dataHolder, this.Ot));
        }
    }

    private final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final QuestUpdateListener Ou;

        QuestUpdateBinderCallback(GamesClientImpl gamesClientImpl, QuestUpdateListener listener) {
            this.NE = gamesClientImpl;
            this.Ou = listener;
        }

        private Quest m3978R(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            Quest quest = null;
            try {
                if (questBuffer.getCount() > 0) {
                    quest = (Quest) ((Quest) questBuffer.get(0)).freeze();
                }
                questBuffer.close();
                return quest;
            } catch (Throwable th) {
                questBuffer.close();
            }
        }

        public void mo1142M(DataHolder dataHolder) {
            Quest R = m3978R(dataHolder);
            if (R != null) {
                this.NE.m2664a(new QuestCompletedCallback(this.NE, this.Ou, R));
            }
        }
    }

    private final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadQuestsResult> Ov;

        public QuestsLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<LoadQuestsResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.Ov = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1144O(DataHolder dataHolder) {
            this.Ov.mo911a(new LoadQuestsResultImpl(dataHolder));
        }
    }

    private final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        final ReliableMessageSentCallback Oy;

        public RealTimeReliableMessageBinderCallbacks(GamesClientImpl gamesClientImpl, ReliableMessageSentCallback messageSentCallbacks) {
            this.NE = gamesClientImpl;
            this.Oy = messageSentCallbacks;
        }

        public void mo1151b(int i, int i2, String str) {
            this.NE.m2664a(new RealTimeMessageSentCallback(this.NE, this.Oy, i, i2, str));
        }
    }

    private final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final OnRequestReceivedListener Oz;

        RequestReceivedBinderCallback(GamesClientImpl gamesClientImpl, OnRequestReceivedListener listener) {
            this.NE = gamesClientImpl;
            this.Oz = listener;
        }

        public void mo1181o(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                gameRequestBuffer.close();
                if (gameRequest != null) {
                    this.NE.m2664a(new RequestReceivedCallback(this.NE, this.Oz, gameRequest));
                }
            } catch (Throwable th) {
                gameRequestBuffer.close();
            }
        }

        public void onRequestRemoved(String requestId) {
            this.NE.m2664a(new RequestRemovedCallback(this.NE, this.Oz, requestId));
        }
    }

    private final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<SendRequestResult> OC;

        public RequestSentBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<SendRequestResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OC = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1136G(DataHolder dataHolder) {
            this.OC.mo911a(new SendRequestResultImpl(dataHolder));
        }
    }

    private final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadRequestSummariesResult> OD;

        public RequestSummariesLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<LoadRequestSummariesResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OD = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1137H(DataHolder dataHolder) {
            this.OD.mo911a(new LoadRequestSummariesResultImpl(dataHolder));
        }
    }

    private final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadRequestsResult> OE;

        public RequestsLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<LoadRequestsResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OE = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1154c(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.OE.mo911a(new LoadRequestsResultImpl(new Status(i), bundle));
        }
    }

    private final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<UpdateRequestsResult> OF;

        public RequestsUpdatedBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<UpdateRequestsResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OF = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1135F(DataHolder dataHolder) {
            this.OF.mo911a(new UpdateRequestsResultImpl(dataHolder));
        }
    }

    private final class RoomAutoMatchingCallback extends AbstractRoomStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        RoomAutoMatchingCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void mo3140a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    private final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final RoomUpdateListener OG;
        private final RoomStatusUpdateListener OH;
        private final RealTimeMessageReceivedListener OI;

        public RoomBinderCallbacks(GamesClientImpl gamesClientImpl, RoomUpdateListener roomCallbacks) {
            this.NE = gamesClientImpl;
            this.OG = (RoomUpdateListener) hm.m1228b((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.OH = null;
            this.OI = null;
        }

        public RoomBinderCallbacks(GamesClientImpl gamesClientImpl, RoomUpdateListener roomCallbacks, RoomStatusUpdateListener roomStatusCallbacks, RealTimeMessageReceivedListener realTimeMessageReceivedCallbacks) {
            this.NE = gamesClientImpl;
            this.OG = (RoomUpdateListener) hm.m1228b((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.OH = roomStatusCallbacks;
            this.OI = realTimeMessageReceivedCallbacks;
        }

        public void mo1130A(DataHolder dataHolder) {
            this.NE.m2664a(new DisconnectedFromRoomCallback(this.NE, this.OH, dataHolder));
        }

        public void mo1150a(DataHolder dataHolder, String[] strArr) {
            this.NE.m2664a(new PeerInvitedToRoomCallback(this.NE, this.OH, dataHolder, strArr));
        }

        public void mo1153b(DataHolder dataHolder, String[] strArr) {
            this.NE.m2664a(new PeerJoinedRoomCallback(this.NE, this.OH, dataHolder, strArr));
        }

        public void mo1156c(DataHolder dataHolder, String[] strArr) {
            this.NE.m2664a(new PeerLeftRoomCallback(this.NE, this.OH, dataHolder, strArr));
        }

        public void mo1162d(DataHolder dataHolder, String[] strArr) {
            this.NE.m2664a(new PeerDeclinedCallback(this.NE, this.OH, dataHolder, strArr));
        }

        public void mo1167e(DataHolder dataHolder, String[] strArr) {
            this.NE.m2664a(new PeerConnectedCallback(this.NE, this.OH, dataHolder, strArr));
        }

        public void mo1171f(DataHolder dataHolder, String[] strArr) {
            this.NE.m2664a(new PeerDisconnectedCallback(this.NE, this.OH, dataHolder, strArr));
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            this.NE.m2664a(new LeftRoomCallback(this.NE, this.OG, statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            this.NE.m2664a(new P2PConnectedCallback(this.NE, this.OH, participantId));
        }

        public void onP2PDisconnected(String participantId) {
            this.NE.m2664a(new P2PDisconnectedCallback(this.NE, this.OH, participantId));
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            this.NE.m2664a(new MessageReceivedCallback(this.NE, this.OI, message));
        }

        public void mo1194u(DataHolder dataHolder) {
            this.NE.m2664a(new RoomCreatedCallback(this.NE, this.OG, dataHolder));
        }

        public void mo1195v(DataHolder dataHolder) {
            this.NE.m2664a(new JoinedRoomCallback(this.NE, this.OG, dataHolder));
        }

        public void mo1196w(DataHolder dataHolder) {
            this.NE.m2664a(new RoomConnectingCallback(this.NE, this.OH, dataHolder));
        }

        public void mo1197x(DataHolder dataHolder) {
            this.NE.m2664a(new RoomAutoMatchingCallback(this.NE, this.OH, dataHolder));
        }

        public void mo1198y(DataHolder dataHolder) {
            this.NE.m2664a(new RoomConnectedCallback(this.NE, this.OG, dataHolder));
        }

        public void mo1199z(DataHolder dataHolder) {
            this.NE.m2664a(new ConnectedToRoomCallback(this.NE, this.OH, dataHolder));
        }
    }

    private final class RoomConnectedCallback extends AbstractRoomCallback {
        final /* synthetic */ GamesClientImpl NE;

        RoomConnectedCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, DataHolder dataHolder) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void mo3141a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    private final class RoomConnectingCallback extends AbstractRoomStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        RoomConnectingCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void mo3140a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    private final class RoomCreatedCallback extends AbstractRoomCallback {
        final /* synthetic */ GamesClientImpl NE;

        public RoomCreatedCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, DataHolder dataHolder) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void mo3141a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    private final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<Status> yR;

        public SignOutCompleteBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<Status> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void dT() {
            this.yR.mo911a(new Status(0));
        }
    }

    private final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<CommitSnapshotResult> OJ;

        public SnapshotCommittedBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<CommitSnapshotResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OJ = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1139J(DataHolder dataHolder) {
            this.OJ.mo911a(new CommitSnapshotResultImpl(dataHolder));
        }
    }

    final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<DeleteSnapshotResult> yR;

        public SnapshotDeletedBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<DeleteSnapshotResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1172g(int i, String str) {
            this.yR.mo911a(new DeleteSnapshotResultImpl(i, str));
        }
    }

    private final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<OpenSnapshotResult> OK;

        public SnapshotOpenedBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<OpenSnapshotResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OK = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1148a(DataHolder dataHolder, Contents contents) {
            this.OK.mo911a(new OpenSnapshotResultImpl(dataHolder, contents));
        }

        public void mo1149a(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            this.OK.mo911a(new OpenSnapshotResultImpl(dataHolder, str, contents, contents2, contents3));
        }
    }

    private final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadSnapshotsResult> OL;

        public SnapshotsLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<LoadSnapshotsResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OL = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1138I(DataHolder dataHolder) {
            this.OL.mo911a(new LoadSnapshotsResultImpl(dataHolder));
        }
    }

    private final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<SubmitScoreResult> yR;

        public SubmitScoreBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<SubmitScoreResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.yR = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1170f(DataHolder dataHolder) {
            this.yR.mo911a(new SubmitScoreResultImpl(dataHolder));
        }
    }

    private final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<CancelMatchResult> ON;

        public TurnBasedMatchCanceledBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<CancelMatchResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.ON = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1169f(int i, String str) {
            this.ON.mo911a(new CancelMatchResultImpl(new Status(i), str));
        }
    }

    private final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<InitiateMatchResult> OO;

        public TurnBasedMatchInitiatedBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<InitiateMatchResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OO = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1190q(DataHolder dataHolder) {
            this.OO.mo911a(new InitiateMatchResultImpl(dataHolder));
        }
    }

    private final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LeaveMatchResult> OP;

        public TurnBasedMatchLeftBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<LeaveMatchResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OP = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1192s(DataHolder dataHolder) {
            this.OP.mo911a(new LeaveMatchResultImpl(dataHolder));
        }
    }

    private final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadMatchResult> OQ;

        public TurnBasedMatchLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<LoadMatchResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OQ = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1189p(DataHolder dataHolder) {
            this.OQ.mo911a(new LoadMatchResultImpl(dataHolder));
        }
    }

    private final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<UpdateMatchResult> OR;

        public TurnBasedMatchUpdatedBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<UpdateMatchResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OR = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1191r(DataHolder dataHolder) {
            this.OR.mo911a(new UpdateMatchResultImpl(dataHolder));
        }
    }

    private final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl NE;
        private final C0152d<LoadMatchesResult> OS;

        public TurnBasedMatchesLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C0152d<LoadMatchesResult> resultHolder) {
            this.NE = gamesClientImpl;
            this.OS = (C0152d) hm.m1228b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void mo1152b(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.OS.mo911a(new LoadMatchesResultImpl(new Status(i), bundle));
        }
    }

    private static final class UpdateMatchResultImpl extends TurnBasedMatchResult implements UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private final class PeerConnectedCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        PeerConnectedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        protected void mo3151a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    private final class PeerDeclinedCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        PeerDeclinedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        protected void mo3151a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    private final class PeerDisconnectedCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        PeerDisconnectedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        protected void mo3151a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    private final class PeerInvitedToRoomCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        PeerInvitedToRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        protected void mo3151a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    private final class PeerJoinedRoomCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        PeerJoinedRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        protected void mo3151a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    private final class PeerLeftRoomCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl NE;

        PeerLeftRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.NE = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        protected void mo3151a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    public GamesClientImpl(Context context, Looper looper, String gamePackageName, String accountName, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener, String[] scopes, int gravity, View gamesContentView, boolean isHeadless, boolean showConnectingPopup, int connectingPopupGravity, boolean retryingSignIn, int sdkVariant, String forceResolveAccountKey) {
        super(context, looper, connectedListener, connectionFailedListener, scopes);
        this.Nq = gamePackageName;
        this.yQ = (String) hm.m1232f(accountName);
        this.Ny = new Binder();
        this.Nr = new HashMap();
        this.Nu = PopupManager.m726a(this, gravity);
        m3425f(gamesContentView);
        this.Nw = showConnectingPopup;
        this.Nx = connectingPopupGravity;
        this.Nz = (long) hashCode();
        this.NA = isHeadless;
        this.NC = retryingSignIn;
        this.NB = sdkVariant;
        this.ND = forceResolveAccountKey;
        registerConnectionCallbacks((ConnectionCallbacks) this);
        registerConnectionFailedListener((OnConnectionFailedListener) this);
    }

    private Room m3333Q(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        Room room = null;
        try {
            if (roomBuffer.getCount() > 0) {
                room = (Room) ((Room) roomBuffer.get(0)).freeze();
            }
            roomBuffer.close();
            return room;
        } catch (Throwable th) {
            roomBuffer.close();
        }
    }

    private RealTimeSocket aT(String str) {
        try {
            ParcelFileDescriptor bb = ((IGamesService) ft()).bb(str);
            RealTimeSocket libjingleNativeSocket;
            if (bb != null) {
                GamesLog.m481i("GamesClientImpl", "Created native libjingle socket.");
                libjingleNativeSocket = new LibjingleNativeSocket(bb);
                this.Nr.put(str, libjingleNativeSocket);
                return libjingleNativeSocket;
            }
            GamesLog.m481i("GamesClientImpl", "Unable to create native libjingle socket, resorting to old socket.");
            String aW = ((IGamesService) ft()).aW(str);
            if (aW == null) {
                return null;
            }
            LocalSocket localSocket = new LocalSocket();
            try {
                localSocket.connect(new LocalSocketAddress(aW));
                libjingleNativeSocket = new RealTimeSocketImpl(localSocket, str);
                this.Nr.put(str, libjingleNativeSocket);
                return libjingleNativeSocket;
            } catch (IOException e) {
                GamesLog.m483k("GamesClientImpl", "connect() call failed on socket: " + e.getMessage());
                return null;
            }
        } catch (RemoteException e2) {
            GamesLog.m483k("GamesClientImpl", "Unable to create socket. Service died.");
            return null;
        }
    }

    private void gY() {
        this.Ns = null;
    }

    private void hv() {
        for (RealTimeSocket close : this.Nr.values()) {
            try {
                close.close();
            } catch (Throwable e) {
                GamesLog.m480b("GamesClientImpl", "IOException:", e);
            }
        }
        this.Nr.clear();
    }

    public int m3335a(ReliableMessageSentCallback reliableMessageSentCallback, byte[] bArr, String str, String str2) {
        try {
            return ((IGamesService) ft()).mo1202a(new RealTimeReliableMessageBinderCallbacks(this, reliableMessageSentCallback), bArr, str, str2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int m3336a(byte[] bArr, String str, String[] strArr) {
        hm.m1228b((Object) strArr, (Object) "Participant IDs must not be null");
        try {
            return ((IGamesService) ft()).mo1267b(bArr, str, strArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return -1;
        }
    }

    public Intent m3337a(int i, int i2, boolean z) {
        try {
            return ((IGamesService) ft()).mo1203a(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent m3338a(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent a = ((IGamesService) ft()).mo1204a(i, bArr, i2, str);
            hm.m1228b((Object) bitmap, (Object) "Must provide a non null icon");
            a.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return a;
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent m3339a(Room room, int i) {
        try {
            return ((IGamesService) ft()).mo1207a((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent m3340a(String str, boolean z, boolean z2, int i) {
        try {
            return ((IGamesService) ft()).mo1208a(str, z, z2, i);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent m3341a(int[] iArr) {
        try {
            return ((IGamesService) ft()).mo1209a(iArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    protected void mo2551a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null) {
            this.Nv = bundle.getBoolean("show_welcome_popup");
        }
        super.mo2551a(i, iBinder, bundle);
    }

    public void m3343a(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((IGamesService) ft()).mo1212a(iBinder, bundle);
            } catch (RemoteException e) {
                GamesLog.m482j("GamesClientImpl", "service died");
            }
        }
    }

    public void m3344a(C0152d<LoadRequestsResult> c0152d, int i, int i2, int i3) {
        try {
            ((IGamesService) ft()).mo1216a(new RequestsLoadedBinderCallbacks(this, c0152d), i, i2, i3);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3345a(C0152d<LoadExtendedGamesResult> c0152d, int i, int i2, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).mo1217a(new ExtendedGamesLoadedBinderCallback(this, c0152d), i, i2, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3346a(C0152d<LoadPlayersResult> c0152d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).mo1219a(new PlayersLoadedBinderCallback(this, c0152d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3347a(C0152d<LoadMatchesResult> c0152d, int i, int[] iArr) {
        try {
            ((IGamesService) ft()).mo1220a(new TurnBasedMatchesLoadedBinderCallbacks(this, c0152d), i, iArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3348a(C0152d<LoadScoresResult> c0152d, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        try {
            ((IGamesService) ft()).mo1223a(new LeaderboardScoresLoadedBinderCallback(this, c0152d), leaderboardScoreBuffer.iA().iB(), i, i2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3349a(C0152d<InitiateMatchResult> c0152d, TurnBasedMatchConfig turnBasedMatchConfig) {
        try {
            ((IGamesService) ft()).mo1218a(new TurnBasedMatchInitiatedBinderCallbacks(this, c0152d), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.iH(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3350a(C0152d<CommitSnapshotResult> c0152d, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) {
        Contents contents = snapshot.getContents();
        hm.m1228b((Object) contents, (Object) "Must provide a previously opened Snapshot");
        C0609a iN = snapshotMetadataChange.iN();
        if (iN != null) {
            iN.m2019a(getContext().getCacheDir());
        }
        snapshot.iM();
        try {
            ((IGamesService) ft()).mo1237a(new SnapshotCommittedBinderCallbacks(this, c0152d), snapshot.getMetadata().getSnapshotId(), snapshotMetadataChange, contents);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3351a(C0152d<LoadPlayersResult> c0152d, String str) {
        try {
            ((IGamesService) ft()).mo1226a(new PlayersLoadedBinderCallback(this, c0152d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3352a(C0152d<UpdateAchievementResult> c0152d, String str, int i) {
        try {
            ((IGamesService) ft()).mo1229a(c0152d == null ? null : new AchievementUpdatedBinderCallback(this, c0152d), str, i, this.Nu.hN(), this.Nu.hM());
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3353a(C0152d<LoadScoresResult> c0152d, String str, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) ft()).mo1228a(new LeaderboardScoresLoadedBinderCallback(this, c0152d), str, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3354a(C0152d<LoadPlayersResult> c0152d, String str, int i, boolean z) {
        try {
            ((IGamesService) ft()).mo1230a(new PlayersLoadedBinderCallback(this, c0152d), str, i, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3355a(C0152d<LoadPlayersResult> c0152d, String str, int i, boolean z, boolean z2) {
        if (str.equals("played_with")) {
            try {
                ((IGamesService) ft()).mo1312d(new PlayersLoadedBinderCallback(this, c0152d), str, i, z, z2);
                return;
            } catch (RemoteException e) {
                GamesLog.m482j("GamesClientImpl", "service died");
                return;
            }
        }
        throw new IllegalArgumentException("Invalid player collection: " + str);
    }

    public void m3356a(C0152d<LoadExtendedGamesResult> c0152d, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        try {
            ((IGamesService) ft()).mo1232a(new ExtendedGamesLoadedBinderCallback(this, c0152d), str, i, z, z2, z3, z4);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3357a(C0152d<LoadMatchesResult> c0152d, String str, int i, int[] iArr) {
        try {
            ((IGamesService) ft()).mo1233a(new TurnBasedMatchesLoadedBinderCallbacks(this, c0152d), str, i, iArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3358a(C0152d<SubmitScoreResult> c0152d, String str, long j, String str2) {
        try {
            ((IGamesService) ft()).mo1235a(c0152d == null ? null : new SubmitScoreBinderCallbacks(this, c0152d), str, j, str2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3359a(C0152d<LeaveMatchResult> c0152d, String str, String str2) {
        try {
            ((IGamesService) ft()).mo1299c(new TurnBasedMatchLeftBinderCallbacks(this, c0152d), str, str2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3360a(C0152d<LoadPlayerScoreResult> c0152d, String str, String str2, int i, int i2) {
        try {
            ((IGamesService) ft()).mo1239a(new PlayerLeaderboardScoreLoadedBinderCallback(this, c0152d), str, str2, i, i2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3361a(C0152d<LoadRequestsResult> c0152d, String str, String str2, int i, int i2, int i3) {
        try {
            ((IGamesService) ft()).mo1240a(new RequestsLoadedBinderCallbacks(this, c0152d), str, str2, i, i2, i3);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3362a(C0152d<LoadScoresResult> c0152d, String str, String str2, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) ft()).mo1241a(new LeaderboardScoresLoadedBinderCallback(this, c0152d), str, str2, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3363a(C0152d<LoadPlayersResult> c0152d, String str, String str2, int i, boolean z, boolean z2) {
        if (str.equals("played_with") || str.equals("circled")) {
            try {
                ((IGamesService) ft()).mo1242a(new PlayersLoadedBinderCallback(this, c0152d), str, str2, i, z, z2);
                return;
            } catch (RemoteException e) {
                GamesLog.m482j("GamesClientImpl", "service died");
                return;
            }
        }
        throw new IllegalArgumentException("Invalid player collection: " + str);
    }

    public void m3364a(C0152d<OpenSnapshotResult> c0152d, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, Contents contents) {
        C0609a iN = snapshotMetadataChange.iN();
        if (iN != null) {
            iN.m2019a(getContext().getCacheDir());
        }
        try {
            ((IGamesService) ft()).mo1243a(new SnapshotOpenedBinderCallbacks(this, c0152d), str, str2, snapshotMetadataChange, contents);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3365a(C0152d<LeaderboardMetadataResult> c0152d, String str, String str2, boolean z) {
        try {
            ((IGamesService) ft()).mo1284b(new LeaderboardsLoadedBinderCallback(this, c0152d), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3366a(C0152d<LoadQuestsResult> c0152d, String str, String str2, boolean z, String[] strArr) {
        try {
            ((IGamesService) ft()).mo1247a(new QuestsLoadedBinderCallbacks(this, c0152d), str, str2, strArr, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3367a(C0152d<LoadQuestsResult> c0152d, String str, String str2, int[] iArr, int i, boolean z) {
        try {
            ((IGamesService) ft()).mo1245a(new QuestsLoadedBinderCallbacks(this, c0152d), str, str2, iArr, i, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3368a(C0152d<UpdateRequestsResult> c0152d, String str, String str2, String[] strArr) {
        try {
            ((IGamesService) ft()).mo1246a(new RequestsUpdatedBinderCallbacks(this, c0152d), str, str2, strArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3369a(C0152d<LeaderboardMetadataResult> c0152d, String str, boolean z) {
        try {
            ((IGamesService) ft()).mo1301c(new LeaderboardsLoadedBinderCallback(this, c0152d), str, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3370a(C0152d<UpdateMatchResult> c0152d, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
        try {
            ((IGamesService) ft()).mo1249a(new TurnBasedMatchUpdatedBinderCallbacks(this, c0152d), str, bArr, str2, participantResultArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3371a(C0152d<UpdateMatchResult> c0152d, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
        try {
            ((IGamesService) ft()).mo1250a(new TurnBasedMatchUpdatedBinderCallbacks(this, c0152d), str, bArr, participantResultArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3372a(C0152d<SendRequestResult> c0152d, String str, String[] strArr, int i, byte[] bArr, int i2) {
        try {
            ((IGamesService) ft()).mo1252a(new RequestSentBinderCallbacks(this, c0152d), str, strArr, i, bArr, i2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3373a(C0152d<LoadPlayersResult> c0152d, boolean z) {
        try {
            ((IGamesService) ft()).mo1302c(new PlayersLoadedBinderCallback(this, c0152d), z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3374a(C0152d<Status> c0152d, boolean z, Bundle bundle) {
        try {
            ((IGamesService) ft()).mo1254a(new ContactSettingsUpdatedBinderCallback(this, c0152d), z, bundle);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3375a(C0152d<LoadEventsResult> c0152d, boolean z, String... strArr) {
        try {
            this.Np.flush();
            ((IGamesService) ft()).mo1255a(new EventsLoadedBinderCallback(this, c0152d), z, strArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3376a(C0152d<LoadQuestsResult> c0152d, int[] iArr, int i, boolean z) {
        try {
            this.Np.flush();
            ((IGamesService) ft()).mo1257a(new QuestsLoadedBinderCallbacks(this, c0152d), iArr, i, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3377a(C0152d<LoadPlayersResult> c0152d, String[] strArr) {
        try {
            ((IGamesService) ft()).mo1303c(new PlayersLoadedBinderCallback(this, c0152d), strArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3378a(OnInvitationReceivedListener onInvitationReceivedListener) {
        try {
            ((IGamesService) ft()).mo1221a(new InvitationReceivedBinderCallback(this, onInvitationReceivedListener), this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3379a(RoomConfig roomConfig) {
        try {
            ((IGamesService) ft()).mo1224a(new RoomBinderCallbacks(this, roomConfig.getRoomUpdateListener(), roomConfig.getRoomStatusUpdateListener(), roomConfig.getMessageReceivedListener()), this.Ny, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), roomConfig.isSocketEnabled(), this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3380a(RoomUpdateListener roomUpdateListener, String str) {
        try {
            ((IGamesService) ft()).mo1296c(new RoomBinderCallbacks(this, roomUpdateListener), str);
            hv();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3381a(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
        try {
            ((IGamesService) ft()).mo1272b(new MatchUpdateReceivedBinderCallback(this, onTurnBasedMatchUpdateReceivedListener), this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3382a(QuestUpdateListener questUpdateListener) {
        try {
            ((IGamesService) ft()).mo1309d(new QuestUpdateBinderCallback(this, questUpdateListener), this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3383a(OnRequestReceivedListener onRequestReceivedListener) {
        try {
            ((IGamesService) ft()).mo1294c(new RequestReceivedBinderCallback(this, onRequestReceivedListener), this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3384a(Snapshot snapshot) {
        Contents contents = snapshot.getContents();
        hm.m1228b((Object) contents, (Object) "Must provide a previously opened Snapshot");
        snapshot.iM();
        try {
            ((IGamesService) ft()).mo1213a(contents);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    protected void mo2552a(hi hiVar, C1092e c1092e) throws RemoteException {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.NA);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.Nw);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.Nx);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.NC);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.NB);
        bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.ND);
        hiVar.mo1762a(c1092e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.yQ, fs(), this.Nq, this.Nu.hN(), locale, bundle);
    }

    public Intent aR(String str) {
        try {
            return ((IGamesService) ft()).aR(str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public void aS(String str) {
        try {
            ((IGamesService) ft()).ba(str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public Intent aU(String str) {
        try {
            return ((IGamesService) ft()).aU(str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    protected IGamesService ah(IBinder iBinder) {
        return Stub.aj(iBinder);
    }

    public Intent m3386b(int i, int i2, boolean z) {
        try {
            return ((IGamesService) ft()).mo1268b(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public void m3387b(C0152d<Status> c0152d) {
        try {
            this.Np.flush();
            ((IGamesService) ft()).mo1214a(new SignOutCompleteBinderCallbacks(this, c0152d));
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3388b(C0152d<LoadPlayersResult> c0152d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).mo1271b(new PlayersLoadedBinderCallback(this, c0152d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3389b(C0152d<UpdateAchievementResult> c0152d, String str) {
        if (c0152d == null) {
            IGamesCallbacks iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(this, c0152d);
        }
        try {
            ((IGamesService) ft()).mo1236a(iGamesCallbacks, str, this.Nu.hN(), this.Nu.hM());
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3390b(C0152d<UpdateAchievementResult> c0152d, String str, int i) {
        try {
            ((IGamesService) ft()).mo1277b(c0152d == null ? null : new AchievementUpdatedBinderCallback(this, c0152d), str, i, this.Nu.hN(), this.Nu.hM());
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3391b(C0152d<LoadScoresResult> c0152d, String str, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) ft()).mo1276b(new LeaderboardScoresLoadedBinderCallback(this, c0152d), str, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3392b(C0152d<LoadExtendedGamesResult> c0152d, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).mo1231a(new ExtendedGamesLoadedBinderCallback(this, c0152d), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3393b(C0152d<ClaimMilestoneResult> c0152d, String str, String str2) {
        try {
            this.Np.flush();
            ((IGamesService) ft()).mo1327f(new QuestMilestoneClaimBinderCallbacks(this, c0152d, str2), str, str2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3394b(C0152d<LoadScoresResult> c0152d, String str, String str2, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) ft()).mo1282b(new LeaderboardScoresLoadedBinderCallback(this, c0152d), str, str2, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3395b(C0152d<LoadAchievementsResult> c0152d, String str, String str2, boolean z) {
        try {
            ((IGamesService) ft()).mo1244a(new AchievementsLoadedBinderCallback(this, c0152d), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3396b(C0152d<OpenSnapshotResult> c0152d, String str, boolean z) {
        try {
            ((IGamesService) ft()).mo1321e(new SnapshotOpenedBinderCallbacks(this, c0152d), str, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3397b(C0152d<LeaderboardMetadataResult> c0152d, boolean z) {
        try {
            ((IGamesService) ft()).mo1286b(new LeaderboardsLoadedBinderCallback(this, c0152d), z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3398b(C0152d<LoadQuestsResult> c0152d, boolean z, String[] strArr) {
        try {
            ((IGamesService) ft()).mo1259a(new QuestsLoadedBinderCallbacks(this, c0152d), strArr, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3399b(C0152d<UpdateRequestsResult> c0152d, String[] strArr) {
        try {
            ((IGamesService) ft()).mo1258a(new RequestsUpdatedBinderCallbacks(this, c0152d), strArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3400b(RoomConfig roomConfig) {
        try {
            ((IGamesService) ft()).mo1225a(new RoomBinderCallbacks(this, roomConfig.getRoomUpdateListener(), roomConfig.getRoomStatusUpdateListener(), roomConfig.getMessageReceivedListener()), this.Ny, roomConfig.getInvitationId(), roomConfig.isSocketEnabled(), this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    protected void mo2653b(String... strArr) {
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
            hm.m1227a(!z, "Cannot have both %s and %s!", Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty");
            return;
        }
        hm.m1227a(z, "Games APIs requires %s to function.", Scopes.GAMES);
    }

    protected String bu() {
        return "com.google.android.gms.games.service.START";
    }

    protected String bv() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void m3402c(C0152d<LoadInvitationsResult> c0152d, int i) {
        try {
            ((IGamesService) ft()).mo1215a(new InvitationsLoadedBinderCallback(this, c0152d), i);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3403c(C0152d<LoadPlayersResult> c0152d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).mo1293c(new PlayersLoadedBinderCallback(this, c0152d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3404c(C0152d<UpdateAchievementResult> c0152d, String str) {
        if (c0152d == null) {
            IGamesCallbacks iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(this, c0152d);
        }
        try {
            ((IGamesService) ft()).mo1280b(iGamesCallbacks, str, this.Nu.hN(), this.Nu.hM());
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3405c(C0152d<LoadXpStreamResult> c0152d, String str, int i) {
        try {
            ((IGamesService) ft()).mo1275b(new PlayerXpStreamLoadedBinderCallback(this, c0152d), str, i);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3406c(C0152d<LoadExtendedGamesResult> c0152d, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).mo1319e(new ExtendedGamesLoadedBinderCallback(this, c0152d), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3407c(C0152d<InitiateMatchResult> c0152d, String str, String str2) {
        try {
            ((IGamesService) ft()).mo1313d(new TurnBasedMatchInitiatedBinderCallbacks(this, c0152d), str, str2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3408c(C0152d<LoadSnapshotsResult> c0152d, String str, String str2, boolean z) {
        try {
            ((IGamesService) ft()).mo1300c(new SnapshotsLoadedBinderCallbacks(this, c0152d), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3409c(C0152d<LeaderboardMetadataResult> c0152d, String str, boolean z) {
        try {
            ((IGamesService) ft()).mo1314d(new LeaderboardsLoadedBinderCallback(this, c0152d), str, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3410c(C0152d<LoadAchievementsResult> c0152d, boolean z) {
        try {
            ((IGamesService) ft()).mo1253a(new AchievementsLoadedBinderCallback(this, c0152d), z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3411c(C0152d<UpdateRequestsResult> c0152d, String[] strArr) {
        try {
            ((IGamesService) ft()).mo1287b(new RequestsUpdatedBinderCallbacks(this, c0152d), strArr);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void cg(int i) {
        this.Nu.setGravity(i);
    }

    public void ch(int i) {
        try {
            ((IGamesService) ft()).ch(i);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void connect() {
        gY();
        super.connect();
    }

    public int m3412d(byte[] bArr, String str) {
        try {
            return ((IGamesService) ft()).mo1267b(bArr, str, null);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return -1;
        }
    }

    public void m3413d(C0152d<LoadPlayersResult> c0152d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).mo1317e(new PlayersLoadedBinderCallback(this, c0152d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3414d(C0152d<InitiateMatchResult> c0152d, String str) {
        try {
            ((IGamesService) ft()).mo1363l(new TurnBasedMatchInitiatedBinderCallbacks(this, c0152d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3415d(C0152d<LoadXpStreamResult> c0152d, String str, int i) {
        try {
            ((IGamesService) ft()).mo1297c(new PlayerXpStreamLoadedBinderCallback(this, c0152d), str, i);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3416d(C0152d<LoadExtendedGamesResult> c0152d, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).mo1326f(new ExtendedGamesLoadedBinderCallback(this, c0152d), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3417d(C0152d<InitiateMatchResult> c0152d, String str, String str2) {
        try {
            ((IGamesService) ft()).mo1320e(new TurnBasedMatchInitiatedBinderCallbacks(this, c0152d), str, str2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3418d(C0152d<GameMuteStatusChangeResult> c0152d, String str, boolean z) {
        try {
            ((IGamesService) ft()).mo1248a(new GameMuteStatusChangedBinderCallback(this, c0152d), str, z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3419d(C0152d<LoadEventsResult> c0152d, boolean z) {
        try {
            this.Np.flush();
            ((IGamesService) ft()).mo1328f(new EventsLoadedBinderCallback(this, c0152d), z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void disconnect() {
        this.Nv = false;
        if (isConnected()) {
            try {
                IGamesService iGamesService = (IGamesService) ft();
                iGamesService.hw();
                this.Np.flush();
                iGamesService.mo1374q(this.Nz);
            } catch (RemoteException e) {
                GamesLog.m482j("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        hv();
        super.disconnect();
    }

    public void m3420e(C0152d<LoadPlayersResult> c0152d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).mo1308d(new PlayersLoadedBinderCallback(this, c0152d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3421e(C0152d<InitiateMatchResult> c0152d, String str) {
        try {
            ((IGamesService) ft()).mo1365m(new TurnBasedMatchInitiatedBinderCallbacks(this, c0152d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3422e(C0152d<LoadInvitationsResult> c0152d, String str, int i) {
        try {
            ((IGamesService) ft()).mo1278b(new InvitationsLoadedBinderCallback(this, c0152d), str, i, false);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3423e(C0152d<LoadExtendedGamesResult> c0152d, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).mo1298c(new ExtendedGamesLoadedBinderCallback(this, c0152d), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3424e(C0152d<LoadSnapshotsResult> c0152d, boolean z) {
        try {
            ((IGamesService) ft()).mo1315d(new SnapshotsLoadedBinderCallbacks(this, c0152d), z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public Bundle ef() {
        try {
            Bundle ef = ((IGamesService) ft()).ef();
            if (ef == null) {
                return ef;
            }
            ef.setClassLoader(GamesClientImpl.class.getClassLoader());
            return ef;
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public void m3425f(View view) {
        this.Nu.mo1446g(view);
    }

    public void m3426f(C0152d<LoadGamesResult> c0152d) {
        try {
            ((IGamesService) ft()).mo1307d(new GamesLoadedBinderCallback(this, c0152d));
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3427f(C0152d<LeaveMatchResult> c0152d, String str) {
        try {
            ((IGamesService) ft()).mo1371o(new TurnBasedMatchLeftBinderCallbacks(this, c0152d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3428f(C0152d<LoadRequestSummariesResult> c0152d, String str, int i) {
        try {
            ((IGamesService) ft()).mo1227a(new RequestSummariesLoadedBinderCallbacks(this, c0152d), str, i);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3429f(C0152d<LoadPlayersResult> c0152d, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).mo1279b(new PlayersLoadedBinderCallback(this, c0152d), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3430f(C0152d<ContactSettingLoadResult> c0152d, boolean z) {
        try {
            ((IGamesService) ft()).mo1322e(new ContactSettingsLoadedBinderCallback(this, c0152d), z);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3431g(C0152d<LoadOwnerCoverPhotoUrisResult> c0152d) {
        try {
            ((IGamesService) ft()).mo1360j(new OwnerCoverPhotoUrisLoadedBinderCallback(this, c0152d));
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3432g(C0152d<CancelMatchResult> c0152d, String str) {
        try {
            ((IGamesService) ft()).mo1368n(new TurnBasedMatchCanceledBinderCallbacks(this, c0152d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3433g(C0152d<LoadPlayersResult> c0152d, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) ft()).mo1283b(new PlayersLoadedBinderCallback(this, c0152d), str, null, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public String gZ() {
        try {
            return ((IGamesService) ft()).gZ();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public void m3434h(C0152d<LoadAclResult> c0152d) {
        try {
            ((IGamesService) ft()).mo1334h(new NotifyAclLoadedBinderCallback(this, c0152d));
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3435h(C0152d<LoadMatchResult> c0152d, String str) {
        try {
            ((IGamesService) ft()).mo1372p(new TurnBasedMatchLoadedBinderCallbacks(this, c0152d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public String ha() {
        try {
            return ((IGamesService) ft()).ha();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public Player hb() {
        cn();
        synchronized (this) {
            if (this.Ns == null) {
                PlayerBuffer playerBuffer;
                try {
                    playerBuffer = new PlayerBuffer(((IGamesService) ft()).hy());
                    if (playerBuffer.getCount() > 0) {
                        this.Ns = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.close();
                } catch (RemoteException e) {
                    GamesLog.m482j("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    playerBuffer.close();
                }
            }
        }
        return this.Ns;
    }

    public Game hc() {
        GameBuffer gameBuffer;
        cn();
        synchronized (this) {
            if (this.Nt == null) {
                try {
                    gameBuffer = new GameBuffer(((IGamesService) ft()).hA());
                    if (gameBuffer.getCount() > 0) {
                        this.Nt = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.close();
                } catch (RemoteException e) {
                    GamesLog.m482j("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    gameBuffer.close();
                }
            }
        }
        return this.Nt;
    }

    public Intent hd() {
        try {
            return ((IGamesService) ft()).hd();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent he() {
        try {
            return ((IGamesService) ft()).he();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent hf() {
        try {
            return ((IGamesService) ft()).hf();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent hg() {
        try {
            return ((IGamesService) ft()).hg();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public void hh() {
        try {
            ((IGamesService) ft()).mo1377r(this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void hi() {
        try {
            ((IGamesService) ft()).mo1379s(this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void hj() {
        try {
            ((IGamesService) ft()).mo1383u(this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void hk() {
        try {
            ((IGamesService) ft()).mo1381t(this.Nz);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public Intent hl() {
        try {
            return ((IGamesService) ft()).hl();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent hm() {
        try {
            return ((IGamesService) ft()).hm();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public int hn() {
        try {
            return ((IGamesService) ft()).hn();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return 4368;
        }
    }

    public String ho() {
        try {
            return ((IGamesService) ft()).ho();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public int hp() {
        try {
            return ((IGamesService) ft()).hp();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return -1;
        }
    }

    public Intent hq() {
        try {
            return ((IGamesService) ft()).hq();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return null;
        }
    }

    public int hr() {
        try {
            return ((IGamesService) ft()).hr();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int hs() {
        try {
            return ((IGamesService) ft()).hs();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int ht() {
        try {
            return ((IGamesService) ft()).ht();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int hu() {
        try {
            return ((IGamesService) ft()).hu();
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
            return -1;
        }
    }

    public void hw() {
        if (isConnected()) {
            try {
                ((IGamesService) ft()).hw();
            } catch (RemoteException e) {
                GamesLog.m482j("GamesClientImpl", "service died");
            }
        }
    }

    @Deprecated
    public void m3436i(C0152d<ContactSettingLoadResult> c0152d) {
        try {
            ((IGamesService) ft()).mo1322e(new ContactSettingsLoadedBinderCallback(this, c0152d), false);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3437i(C0152d<AcceptQuestResult> c0152d, String str) {
        try {
            this.Np.flush();
            ((IGamesService) ft()).mo1384u(new QuestAcceptedBinderCallbacks(this, c0152d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3438j(C0152d<InboxCountResult> c0152d) {
        try {
            ((IGamesService) ft()).mo1382t(new InboxCountsLoadedBinderCallback(this, c0152d), null);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3439j(C0152d<DeleteSnapshotResult> c0152d, String str) {
        try {
            ((IGamesService) ft()).mo1378r(new SnapshotDeletedBinderCallbacks(this, c0152d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3440k(C0152d<LoadExtendedGamesResult> c0152d, String str) {
        try {
            ((IGamesService) ft()).mo1318e(new ExtendedGamesLoadedBinderCallback(this, c0152d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public RealTimeSocket m3441l(String str, String str2) {
        if (str2 == null || !ParticipantUtils.bn(str2)) {
            throw new IllegalArgumentException("Bad participant ID");
        }
        RealTimeSocket realTimeSocket = (RealTimeSocket) this.Nr.get(str2);
        return (realTimeSocket == null || realTimeSocket.isClosed()) ? aT(str2) : realTimeSocket;
    }

    public void m3442l(C0152d<LoadGameInstancesResult> c0152d, String str) {
        try {
            ((IGamesService) ft()).mo1325f(new GameInstancesLoadedBinderCallback(this, c0152d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3443l(String str, int i) {
        this.Np.m731l(str, i);
    }

    public void m3444m(C0152d<LoadGameSearchSuggestionsResult> c0152d, String str) {
        try {
            ((IGamesService) ft()).mo1375q(new GameSearchSuggestionsLoadedBinderCallback(this, c0152d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3445m(String str, int i) {
        try {
            ((IGamesService) ft()).mo1366m(str, i);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3446n(C0152d<LoadXpForGameCategoriesResult> c0152d, String str) {
        try {
            ((IGamesService) ft()).mo1380s(new PlayerXpForGameCategoriesLoadedBinderCallback(this, c0152d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3447n(String str, int i) {
        try {
            ((IGamesService) ft()).mo1369n(str, i);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3448o(C0152d<LoadInvitationsResult> c0152d, String str) {
        try {
            ((IGamesService) ft()).mo1362k(new InvitationsLoadedBinderCallback(this, c0152d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void onConnected(Bundle connectionHint) {
        if (this.Nv) {
            this.Nu.hL();
            this.Nv = false;
        }
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.Nv = false;
    }

    public void onConnectionSuspended(int cause) {
    }

    public void m3449p(C0152d<Status> c0152d, String str) {
        try {
            ((IGamesService) ft()).mo1361j(new NotifyAclUpdatedBinderCallback(this, c0152d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    public void m3450q(C0152d<GameMuteStatusLoadResult> c0152d, String str) {
        try {
            ((IGamesService) ft()).mo1359i(new GameMuteStatusLoadedBinderCallback(this, c0152d), str);
        } catch (RemoteException e) {
            GamesLog.m482j("GamesClientImpl", "service died");
        }
    }

    protected /* synthetic */ IInterface mo2555x(IBinder iBinder) {
        return ah(iBinder);
    }
}
