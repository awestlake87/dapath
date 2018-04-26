package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class lz {
    private final int amW;
    private final byte[] buffer;
    private int position;

    public static class C0364a extends IOException {
        C0364a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private lz(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.position = i;
        this.amW = i + i2;
    }

    public static int m1375D(long j) {
        return m1377G(j);
    }

    public static int m1376E(long j) {
        return m1377G(m1378I(j));
    }

    public static int m1377G(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static long m1378I(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int m1379J(boolean z) {
        return 1;
    }

    public static int m1380b(int i, double d) {
        return eH(i) + m1390f(d);
    }

    public static int m1381b(int i, me meVar) {
        return eH(i) + m1386c(meVar);
    }

    public static int m1382b(int i, boolean z) {
        return eH(i) + m1379J(z);
    }

    public static int m1383b(int i, byte[] bArr) {
        return eH(i) + m1395s(bArr);
    }

    public static lz m1384b(byte[] bArr, int i, int i2) {
        return new lz(bArr, i, i2);
    }

    public static int m1385c(int i, float f) {
        return eH(i) + m1388e(f);
    }

    public static int m1386c(me meVar) {
        int oa = meVar.oa();
        return oa + eJ(oa);
    }

    public static int cz(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + eJ(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int m1387d(int i, long j) {
        return eH(i) + m1375D(j);
    }

    public static int m1388e(float f) {
        return 4;
    }

    public static int m1389e(int i, long j) {
        return eH(i) + m1376E(j);
    }

    public static int eE(int i) {
        return i >= 0 ? eJ(i) : 10;
    }

    public static int eF(int i) {
        return eJ(eL(i));
    }

    public static int eH(int i) {
        return eJ(mh.m1436u(i, 0));
    }

    public static int eJ(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int eL(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static int m1390f(double d) {
        return 8;
    }

    public static int m1391h(int i, String str) {
        return eH(i) + cz(str);
    }

    public static lz m1392q(byte[] bArr) {
        return m1384b(bArr, 0, bArr.length);
    }

    public static int m1393r(int i, int i2) {
        return eH(i) + eE(i2);
    }

    public static int m1394s(int i, int i2) {
        return eH(i) + eF(i2);
    }

    public static int m1395s(byte[] bArr) {
        return eJ(bArr.length) + bArr.length;
    }

    public void m1396B(long j) throws IOException {
        m1398F(j);
    }

    public void m1397C(long j) throws IOException {
        m1398F(m1378I(j));
    }

    public void m1398F(long j) throws IOException {
        while ((-128 & j) != 0) {
            eG((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        eG((int) j);
    }

    public void m1399H(long j) throws IOException {
        eG(((int) j) & MotionEventCompat.ACTION_MASK);
        eG(((int) (j >> 8)) & MotionEventCompat.ACTION_MASK);
        eG(((int) (j >> 16)) & MotionEventCompat.ACTION_MASK);
        eG(((int) (j >> 24)) & MotionEventCompat.ACTION_MASK);
        eG(((int) (j >> 32)) & MotionEventCompat.ACTION_MASK);
        eG(((int) (j >> 40)) & MotionEventCompat.ACTION_MASK);
        eG(((int) (j >> 48)) & MotionEventCompat.ACTION_MASK);
        eG(((int) (j >> 56)) & MotionEventCompat.ACTION_MASK);
    }

    public void m1400I(boolean z) throws IOException {
        eG(z ? 1 : 0);
    }

    public void m1401a(int i, double d) throws IOException {
        m1417t(i, 1);
        m1413e(d);
    }

    public void m1402a(int i, me meVar) throws IOException {
        m1417t(i, 2);
        m1409b(meVar);
    }

    public void m1403a(int i, boolean z) throws IOException {
        m1417t(i, 0);
        m1400I(z);
    }

    public void m1404a(int i, byte[] bArr) throws IOException {
        m1417t(i, 2);
        m1416r(bArr);
    }

    public void m1405b(byte b) throws IOException {
        if (this.position == this.amW) {
            throw new C0364a(this.position, this.amW);
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    public void m1406b(int i, float f) throws IOException {
        m1417t(i, 5);
        m1412d(f);
    }

    public void m1407b(int i, long j) throws IOException {
        m1417t(i, 0);
        m1396B(j);
    }

    public void m1408b(int i, String str) throws IOException {
        m1417t(i, 2);
        cy(str);
    }

    public void m1409b(me meVar) throws IOException {
        eI(meVar.nZ());
        meVar.mo1909a(this);
    }

    public void m1410c(int i, long j) throws IOException {
        m1417t(i, 0);
        m1397C(j);
    }

    public void m1411c(byte[] bArr, int i, int i2) throws IOException {
        if (this.amW - this.position >= i2) {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
            return;
        }
        throw new C0364a(this.position, this.amW);
    }

    public void cy(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        eI(bytes.length);
        m1418t(bytes);
    }

    public void m1412d(float f) throws IOException {
        eK(Float.floatToIntBits(f));
    }

    public void m1413e(double d) throws IOException {
        m1399H(Double.doubleToLongBits(d));
    }

    public void eC(int i) throws IOException {
        if (i >= 0) {
            eI(i);
        } else {
            m1398F((long) i);
        }
    }

    public void eD(int i) throws IOException {
        eI(eL(i));
    }

    public void eG(int i) throws IOException {
        m1405b((byte) i);
    }

    public void eI(int i) throws IOException {
        while ((i & -128) != 0) {
            eG((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        eG(i);
    }

    public void eK(int i) throws IOException {
        eG(i & MotionEventCompat.ACTION_MASK);
        eG((i >> 8) & MotionEventCompat.ACTION_MASK);
        eG((i >> 16) & MotionEventCompat.ACTION_MASK);
        eG((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    public int nQ() {
        return this.amW - this.position;
    }

    public void nR() {
        if (nQ() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void m1414p(int i, int i2) throws IOException {
        m1417t(i, 0);
        eC(i2);
    }

    public void m1415q(int i, int i2) throws IOException {
        m1417t(i, 0);
        eD(i2);
    }

    public void m1416r(byte[] bArr) throws IOException {
        eI(bArr.length);
        m1418t(bArr);
    }

    public void m1417t(int i, int i2) throws IOException {
        eI(mh.m1436u(i, i2));
    }

    public void m1418t(byte[] bArr) throws IOException {
        m1411c(bArr, 0, bArr.length);
    }
}
