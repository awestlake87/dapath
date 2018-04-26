package com.example.najen.dapath;
//
//import android.app.Activity;
//import android.app.Fragment;
//import android.graphics.drawable.TransitionDrawable;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.ImageButton;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//
//public class MultBarHUDFragment extends Fragment implements HUD, OnClickListener {
//    ProgressBar appBar;
//    TransitionDrawable applierFlash;
//    DaPathFragmentListener listener;
//    ProgressBar multBar;
//    TextView multiplier;
//    TextView scoreBar;
//    TransitionDrawable scorebarFlash;
//
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(C0099R.layout.fragment_hud_multbar, container, false);
//        this.multBar = (ProgressBar) view.findViewById(C0099R.id.pbdcMultBar);
//        this.appBar = (ProgressBar) view.findViewById(C0099R.id.pbdcApplier);
//        this.applierFlash = (TransitionDrawable) view.findViewById(C0099R.id.pbdcApplierBack).getBackground();
//        this.multiplier = (TextView) view.findViewById(C0099R.id.tvMultiplier);
//        this.scoreBar = (TextView) view.findViewById(C0099R.id.tvScoreBar);
//        this.scorebarFlash = (TransitionDrawable) this.scoreBar.getBackground();
//        this.scorebarFlash.startTransition(1);
//        this.applierFlash.startTransition(1);
//        ((ImageButton) view.findViewById(C0099R.id.bPause)).setOnClickListener(this);
//        ((ImageButton) view.findViewById(C0099R.id.bReset)).setOnClickListener(this);
//        return view;
//    }
//
//    public void onAttach(Activity activity) {
//        try {
//            this.listener = (DaPathFragmentListener) activity;
//        } catch (ClassCastException e) {
//            e.printStackTrace();
//        }
//        super.onAttach(activity);
//    }
//
//    public void setScore(long score) {
//        if (this.scoreBar != null) {
//            this.scoreBar.setText(score);
//        }
//    }
//
//    public void setMultiplier(int multiplier) {
//        if (this.multiplier != null) {
//            int mult = multiplier / 5;
//            this.multiplier.setText("x" + mult + (mult * 5 == multiplier ? ".0" : "." + ((multiplier - (mult * 5)) * 2)));
//        }
//    }
//
//    public void setMultBarProgress(int progress) {
//        if (this.multBar != null) {
//            this.multBar.setProgress(progress);
//        }
//    }
//
//    public void setAppBarProgress(int progress) {
//        if (this.appBar != null) {
//            this.appBar.setProgress(180 - progress);
//            this.appBar.setRotation((float) (progress + 270));
//        }
//    }
//
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case C0099R.id.bReset:
//                this.listener.finishAndResetGame();
//                return;
//            case C0099R.id.bPause:
//                this.listener.pauseGame();
//                return;
//            default:
//                return;
//        }
//    }
//
//    public void startScoreBarFlash(int m) {
//        this.scorebarFlash.resetTransition();
//        this.scorebarFlash.startTransition(m);
//    }
//
//    public void startApplierFlash(int m) {
//        this.applierFlash.resetTransition();
//        this.applierFlash.startTransition(m);
//    }
//
//    public void setPauseBar(int m) {
//    }
//}
