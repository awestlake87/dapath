package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class C0368o {
    private final C0365m jQ;
    private final SecureRandom kl;

    public class C0367a extends Exception {
        final /* synthetic */ C0368o km;

        public C0367a(C0368o c0368o) {
            this.km = c0368o;
        }

        public C0367a(C0368o c0368o, Throwable th) {
            this.km = c0368o;
            super(th);
        }
    }

    public C0368o(C0365m c0365m, SecureRandom secureRandom) {
        this.jQ = c0365m;
        this.kl = secureRandom;
    }

    static void m1440c(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    public byte[] m1441b(String str) throws C0367a {
        try {
            byte[] a = this.jQ.mo1693a(str, false);
            if (a.length != 32) {
                throw new C0367a(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            C0368o.m1440c(bArr);
            return bArr;
        } catch (Throwable e) {
            throw new C0367a(this, e);
        }
    }

    public byte[] m1442c(byte[] bArr, String str) throws C0367a {
        if (bArr.length != 16) {
            throw new C0367a(this);
        }
        try {
            byte[] a = this.jQ.mo1693a(str, false);
            if (a.length <= 16) {
                throw new C0367a(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            a = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(a);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(a);
        } catch (Throwable e) {
            throw new C0367a(this, e);
        } catch (Throwable e2) {
            throw new C0367a(this, e2);
        } catch (Throwable e22) {
            throw new C0367a(this, e22);
        } catch (Throwable e222) {
            throw new C0367a(this, e222);
        } catch (Throwable e2222) {
            throw new C0367a(this, e2222);
        } catch (Throwable e22222) {
            throw new C0367a(this, e22222);
        } catch (Throwable e222222) {
            throw new C0367a(this, e222222);
        }
    }
}
