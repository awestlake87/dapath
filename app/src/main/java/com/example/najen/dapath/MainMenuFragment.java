package com.example.najen.dapath;

import android.app.Activity;
import android.content.Context;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.TextView;
import com.example.najen.dapath.gamemodes.ModeProfile;

public class MainMenuFragment extends Fragment implements OnClickListener, OnGlobalLayoutListener {
    boolean gameRunning;
    //Handler handler;
    DaPathFragmentListener listener;
    TextView titleBar;

    public MainMenuFragment(/*Handler handler*/) {
        //this.handler = handler;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mainmenu, container, false);
        this.titleBar = (TextView) view.findViewById(R.id.tvTitleBar);
        ((Button) view.findViewById(R.id.bDaClassic)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.bGameModes)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.bFeedback)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.bDaQuit)).setOnClickListener(this);
        ((Button) view.findViewById(R.id.bUnlockStuff)).setOnClickListener(this);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.gameRunning = false;
        this.listener.setMode(-1);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            this.listener = (DaPathFragmentListener) getActivity();
            System.out.println(this.listener);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bDaClassic:
                this.listener.switchMode(0);
                return;
            case R.id.bGameModes:
                this.listener.switchMode(-2);
                return;
            case R.id.bFeedback:
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"folodapath@gmail.com"});
                intent.putExtra("android.intent.extra.SUBJECT", "Da Path Feedback");
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Choose Email Client"));
                return;
            case R.id.bUnlockStuff:
                this.listener.switchMode(-3);
                return;
            case R.id.bDaQuit:
                getActivity().finish();
                return;
            default:
                return;
        }
    }

    public void onGlobalLayout() {
        if (!this.gameRunning) {
            this.listener.setGame("", new ModeProfile(0, 0, (int) this.titleBar.getY(), getView().getWidth(), this.titleBar.getHeight())/*, this.handler*/);
            this.gameRunning = true;
        }
    }
}
