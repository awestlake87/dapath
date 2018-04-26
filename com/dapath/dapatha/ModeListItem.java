package com.dapath.dapatha;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ModeListItem implements OnClickListener {
    DaPathFragmentListener listener;
    int mode;
    String modeName;
    String shortDesc;
    Button stats;

    public ModeListItem(DaPathFragmentListener listener, int mode, String modeName, String shortDesc) {
        this.modeName = modeName;
        this.mode = mode;
        this.shortDesc = shortDesc;
        this.listener = listener;
    }

    public void onClick(View v) {
        this.listener.showStats(this.mode);
    }
}
