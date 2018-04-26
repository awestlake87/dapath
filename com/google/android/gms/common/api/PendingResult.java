package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;

public interface PendingResult<R extends Result> {

    public interface C0150a {
        void mo907n(Status status);
    }

    void mo910a(C0150a c0150a);

    R await();

    R await(long j, TimeUnit timeUnit);

    void cancel();

    boolean isCanceled();

    void setResultCallback(ResultCallback<R> resultCallback);

    void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit);
}
