package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {

    class C04441 implements OnClickListener {
        final /* synthetic */ PreviewActivity agw;

        C04441(PreviewActivity previewActivity) {
            this.agw = previewActivity;
        }

        public void onClick(DialogInterface dialog, int which) {
        }
    }

    private void m1611d(String str, String str2, String str3) {
        AlertDialog create = new Builder(this).create();
        create.setTitle(str);
        create.setMessage(str2);
        create.setButton(-1, str3, new C04441(this));
        create.show();
    }

    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            bh.m1643B("Preview activity");
            Uri data = getIntent().getData();
            if (!TagManager.getInstance(this).m1616i(data)) {
                String str = "Cannot preview the app with the uri: " + data + ". Launching current version instead.";
                bh.m1645D(str);
                m1611d("Preview failure", str, "Continue");
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                bh.m1643B("Invoke the launch activity for package name: " + getPackageName());
                startActivity(launchIntentForPackage);
                return;
            }
            bh.m1643B("No launch activity found for package name: " + getPackageName());
        } catch (Exception e) {
            bh.m1642A("Calling preview threw an exception: " + e.getMessage());
        }
    }
}
