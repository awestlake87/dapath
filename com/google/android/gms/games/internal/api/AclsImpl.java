package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;

public final class AclsImpl implements Acls {

    private static abstract class LoadNotifyAclImpl extends BaseGamesApiMethodImpl<LoadAclResult> {
        private LoadNotifyAclImpl() {
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4167z(status);
        }

        public LoadAclResult m4167z(Status status) {
            return AclsImpl.m2432x(status);
        }
    }

    private static abstract class UpdateNotifyAclImpl extends BaseGamesApiMethodImpl<Status> {
        private UpdateNotifyAclImpl() {
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4169d(status);
        }

        public Status m4169d(Status status) {
            return status;
        }
    }

    class C13222 extends LoadNotifyAclImpl {
        protected void m4430a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3434h(this);
        }
    }

    class C13233 extends UpdateNotifyAclImpl {
        final /* synthetic */ String Pm;

        protected void m4432a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3449p(this, this.Pm);
        }
    }

    private static LoadAclResult m2432x(final Status status) {
        return new LoadAclResult() {
            public Status getStatus() {
                return status;
            }

            public void release() {
            }
        };
    }
}
