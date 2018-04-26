package com.google.android.gms.plus.internal;

import android.content.Context;
import com.google.android.gms.common.Scopes;
import java.util.ArrayList;
import java.util.Arrays;

public class C0436i {
    private String[] abV;
    private String abW;
    private String abX;
    private String abY;
    private PlusCommonExtras aca;
    private final ArrayList<String> acb = new ArrayList();
    private String[] acc;
    private String yQ;

    public C0436i(Context context) {
        this.abX = context.getPackageName();
        this.abW = context.getPackageName();
        this.aca = new PlusCommonExtras();
        this.acb.add(Scopes.PLUS_LOGIN);
    }

    public C0436i bz(String str) {
        this.yQ = str;
        return this;
    }

    public C0436i m1582e(String... strArr) {
        this.acb.clear();
        this.acb.addAll(Arrays.asList(strArr));
        return this;
    }

    public C0436i m1583f(String... strArr) {
        this.acc = strArr;
        return this;
    }

    public C0436i ki() {
        this.acb.clear();
        return this;
    }

    public C0916h kj() {
        if (this.yQ == null) {
            this.yQ = "<<default account>>";
        }
        return new C0916h(this.yQ, (String[]) this.acb.toArray(new String[this.acb.size()]), this.acc, this.abV, this.abW, this.abX, this.abY, this.aca);
    }
}
