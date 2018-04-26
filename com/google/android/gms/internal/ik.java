package com.google.android.gms.internal;

import android.database.CharArrayBuffer;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class ik {
    public static byte[] m1274a(InputStream inputStream, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[10000];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        if (z) {
            inputStream.close();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void m1275b(String str, CharArrayBuffer charArrayBuffer) {
        if (charArrayBuffer.data == null || charArrayBuffer.data.length < str.length()) {
            charArrayBuffer.data = str.toCharArray();
        } else {
            str.getChars(0, str.length(), charArrayBuffer.data, 0);
        }
        charArrayBuffer.sizeCopied = str.length();
    }
}
