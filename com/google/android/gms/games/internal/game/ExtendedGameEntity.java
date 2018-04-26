package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.hk;
import java.util.ArrayList;

public final class ExtendedGameEntity extends GamesDowngradeableSafeParcel implements ExtendedGame {
    public static final ExtendedGameEntityCreator CREATOR = new ExtendedGameEntityCreatorCompat();
    private final long RA;
    private final String RB;
    private final ArrayList<GameBadgeEntity> RC;
    private final SnapshotMetadataEntity RD;
    private final GameEntity Rt;
    private final int Ru;
    private final boolean Rv;
    private final int Rw;
    private final long Rx;
    private final long Ry;
    private final String Rz;
    private final int xM;

    static final class ExtendedGameEntityCreatorCompat extends ExtendedGameEntityCreator {
        ExtendedGameEntityCreatorCompat() {
        }

        public ExtendedGameEntity bg(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.m3452c(ha.fq()) || ha.aA(ExtendedGameEntity.class.getCanonicalName())) {
                return super.bg(parcel);
            }
            GameEntity gameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            boolean z = parcel.readInt() == 1;
            int readInt2 = parcel.readInt();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            String readString = parcel.readString();
            long readLong3 = parcel.readLong();
            String readString2 = parcel.readString();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(GameBadgeEntity.CREATOR.bh(parcel));
            }
            return new ExtendedGameEntity(2, gameEntity, readInt, z, readInt2, readLong, readLong2, readString, readLong3, readString2, arrayList, null);
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return bg(x0);
        }
    }

    ExtendedGameEntity(int versionCode, GameEntity game, int availability, boolean owned, int achievementUnlockedCount, long lastPlayedServerTimestamp, long priceMicros, String formattedPrice, long fullPriceMicros, String formattedFullPrice, ArrayList<GameBadgeEntity> badges, SnapshotMetadataEntity snapshot) {
        this.xM = versionCode;
        this.Rt = game;
        this.Ru = availability;
        this.Rv = owned;
        this.Rw = achievementUnlockedCount;
        this.Rx = lastPlayedServerTimestamp;
        this.Ry = priceMicros;
        this.Rz = formattedPrice;
        this.RA = fullPriceMicros;
        this.RB = formattedFullPrice;
        this.RC = badges;
        this.RD = snapshot;
    }

    public ExtendedGameEntity(ExtendedGame extendedGame) {
        SnapshotMetadataEntity snapshotMetadataEntity = null;
        this.xM = 2;
        Game game = extendedGame.getGame();
        this.Rt = game == null ? null : new GameEntity(game);
        this.Ru = extendedGame.hR();
        this.Rv = extendedGame.hS();
        this.Rw = extendedGame.hT();
        this.Rx = extendedGame.hU();
        this.Ry = extendedGame.hV();
        this.Rz = extendedGame.hW();
        this.RA = extendedGame.hX();
        this.RB = extendedGame.hY();
        SnapshotMetadata hZ = extendedGame.hZ();
        if (hZ != null) {
            snapshotMetadataEntity = new SnapshotMetadataEntity(hZ);
        }
        this.RD = snapshotMetadataEntity;
        ArrayList hQ = extendedGame.hQ();
        int size = hQ.size();
        this.RC = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.RC.add((GameBadgeEntity) ((GameBadge) hQ.get(i)).freeze());
        }
    }

    static int m4018a(ExtendedGame extendedGame) {
        return hk.hashCode(extendedGame.getGame(), Integer.valueOf(extendedGame.hR()), Boolean.valueOf(extendedGame.hS()), Integer.valueOf(extendedGame.hT()), Long.valueOf(extendedGame.hU()), Long.valueOf(extendedGame.hV()), extendedGame.hW(), Long.valueOf(extendedGame.hX()), extendedGame.hY());
    }

    static boolean m4019a(ExtendedGame extendedGame, Object obj) {
        if (!(obj instanceof ExtendedGame)) {
            return false;
        }
        if (extendedGame == obj) {
            return true;
        }
        ExtendedGame extendedGame2 = (ExtendedGame) obj;
        return hk.equal(extendedGame2.getGame(), extendedGame.getGame()) && hk.equal(Integer.valueOf(extendedGame2.hR()), Integer.valueOf(extendedGame.hR())) && hk.equal(Boolean.valueOf(extendedGame2.hS()), Boolean.valueOf(extendedGame.hS())) && hk.equal(Integer.valueOf(extendedGame2.hT()), Integer.valueOf(extendedGame.hT())) && hk.equal(Long.valueOf(extendedGame2.hU()), Long.valueOf(extendedGame.hU())) && hk.equal(Long.valueOf(extendedGame2.hV()), Long.valueOf(extendedGame.hV())) && hk.equal(extendedGame2.hW(), extendedGame.hW()) && hk.equal(Long.valueOf(extendedGame2.hX()), Long.valueOf(extendedGame.hX())) && hk.equal(extendedGame2.hY(), extendedGame.hY());
    }

    static String m4020b(ExtendedGame extendedGame) {
        return hk.m1221e(extendedGame).m1220a("Game", extendedGame.getGame()).m1220a("Availability", Integer.valueOf(extendedGame.hR())).m1220a("Owned", Boolean.valueOf(extendedGame.hS())).m1220a("AchievementUnlockedCount", Integer.valueOf(extendedGame.hT())).m1220a("LastPlayedServerTimestamp", Long.valueOf(extendedGame.hU())).m1220a("PriceMicros", Long.valueOf(extendedGame.hV())).m1220a("FormattedPrice", extendedGame.hW()).m1220a("FullPriceMicros", Long.valueOf(extendedGame.hX())).m1220a("FormattedFullPrice", extendedGame.hY()).m1220a("Snapshot", extendedGame.hZ()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m4019a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return ib();
    }

    public /* synthetic */ Game getGame() {
        return ia();
    }

    public int getVersionCode() {
        return this.xM;
    }

    public ArrayList<GameBadge> hQ() {
        return new ArrayList(this.RC);
    }

    public int hR() {
        return this.Ru;
    }

    public boolean hS() {
        return this.Rv;
    }

    public int hT() {
        return this.Rw;
    }

    public long hU() {
        return this.Rx;
    }

    public long hV() {
        return this.Ry;
    }

    public String hW() {
        return this.Rz;
    }

    public long hX() {
        return this.RA;
    }

    public String hY() {
        return this.RB;
    }

    public SnapshotMetadata hZ() {
        return this.RD;
    }

    public int hashCode() {
        return m4018a(this);
    }

    public GameEntity ia() {
        return this.Rt;
    }

    public ExtendedGame ib() {
        return this;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m4020b((ExtendedGame) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i = 0;
        if (fr()) {
            this.Rt.writeToParcel(dest, flags);
            dest.writeInt(this.Ru);
            dest.writeInt(this.Rv ? 1 : 0);
            dest.writeInt(this.Rw);
            dest.writeLong(this.Rx);
            dest.writeLong(this.Ry);
            dest.writeString(this.Rz);
            dest.writeLong(this.RA);
            dest.writeString(this.RB);
            int size = this.RC.size();
            dest.writeInt(size);
            while (i < size) {
                ((GameBadgeEntity) this.RC.get(i)).writeToParcel(dest, flags);
                i++;
            }
            return;
        }
        ExtendedGameEntityCreator.m732a(this, dest, flags);
    }
}
