package com.dapath.dapatha;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

public class NoMultBarHUDFragment extends Fragment implements HUD, OnGlobalLayoutListener {
    DaPathFragmentListener listener;
    TextView pauseBar;
    TextView scoreBar;
    boolean setPauseRect;

    public void onAttach(Activity activity) {
        try {
            this.listener = (DaPathFragmentListener) activity;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        super.onAttach(activity);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C0099R.layout.fragment_hud_nomultbar, container, false);
        this.scoreBar = (TextView) view.findViewById(C0099R.id.tvScoreBar);
        this.pauseBar = (TextView) view.findViewById(C0099R.id.tvPauseBar);
        this.pauseBar.getViewTreeObserver().addOnGlobalLayoutListener(this);
        setPauseBar(2);
        this.setPauseRect = true;
        return view;
    }

    public void setScore(long score) {
        if (this.scoreBar != null) {
            this.scoreBar.setText(score);
        }
    }

    public void setMultiplier(int multiplier) {
    }

    public void setMultBarProgress(int progress) {
    }

    public void setAppBarProgress(int progress) {
    }

    public void startScoreBarFlash(int m) {
    }

    public void startApplierFlash(int m) {
    }

    public void setPauseBar(int m) {
        switch (m) {
            case 0:
                this.pauseBar.setText("Release Here to Pause");
                return;
            case 1:
                this.pauseBar.setText("Drag Up to Resume");
                return;
            case 2:
                this.pauseBar.setText("Touch Path to Start");
                return;
            default:
                return;
        }
    }

    public void onGlobalLayout() {
        if (this.setPauseRect) {
            this.listener.setPauseRect(new Rect(this.pauseBar.getLeft(), this.pauseBar.getTop(), this.pauseBar.getRight(), this.pauseBar.getBottom()));
            this.setPauseRect = false;
        }
    }
}
