package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

abstract class C0119k<T extends C0117j> {
    Context mContext;
    C0118a<T> tM;

    public interface C0118a<U extends C0117j> {
        void mo844a(String str, int i);

        void mo845c(String str, String str2);

        void mo846c(String str, boolean z);

        U cB();

        void mo848d(String str, String str2);
    }

    public C0119k(Context context, C0118a<T> c0118a) {
        this.mContext = context;
        this.tM = c0118a;
    }

    private T m67a(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase();
                    String trim;
                    if (toLowerCase.equals("screenname")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            this.tM.mo845c(toLowerCase, trim);
                        }
                    } else if (toLowerCase.equals("string")) {
                        r0 = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(r0) || trim == null)) {
                            this.tM.mo848d(r0, trim);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            try {
                                this.tM.mo846c(toLowerCase, Boolean.parseBoolean(trim));
                            } catch (NumberFormatException e) {
                                aa.m37A("Error parsing bool configuration value: " + trim);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        r0 = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(r0) || TextUtils.isEmpty(trim))) {
                            try {
                                this.tM.mo844a(r0, Integer.parseInt(trim));
                            } catch (NumberFormatException e2) {
                                aa.m37A("Error parsing int configuration value: " + trim);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            aa.m37A("Error parsing tracker configuration file: " + e3);
        } catch (IOException e4) {
            aa.m37A("Error parsing tracker configuration file: " + e4);
        }
        return this.tM.cB();
    }

    public T m68r(int i) {
        try {
            return m67a(this.mContext.getResources().getXml(i));
        } catch (NotFoundException e) {
            aa.m40D("inflate() called with unknown resourceId: " + e);
            return null;
        }
    }
}
