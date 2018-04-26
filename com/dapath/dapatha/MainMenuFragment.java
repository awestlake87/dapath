package com.dapath.dapatha;

import android.app.Activity;
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
import com.dapath.gamemodes.ModeProfile;

public class MainMenuFragment extends Fragment implements OnClickListener, OnGlobalLayoutListener {
    boolean gameRunning;
    Handler handler;
    DaPathFragmentListener listener;
    TextView titleBar;

    public MainMenuFragment(Handler handler) {
        this.handler = handler;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C0099R.layout.fragment_mainmenu, container, false);
        this.titleBar = (TextView) view.findViewById(C0099R.id.tvTitleBar);
        ((Button) view.findViewById(C0099R.id.bDaClassic)).setOnClickListener(this);
        ((Button) view.findViewById(C0099R.id.bGameModes)).setOnClickListener(this);
        ((Button) view.findViewById(C0099R.id.bFeedback)).setOnClickListener(this);
        ((Button) view.findViewById(C0099R.id.bDaQuit)).setOnClickListener(this);
        ((Button) view.findViewById(C0099R.id.bUnlockStuff)).setOnClickListener(this);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.gameRunning = false;
        this.listener.setMode(-1);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void onAttach(Activity activity) {
        try {
            this.listener = (DaPathFragmentListener) activity;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        super.onAttach(activity);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0099R.id.bDaClassic:
                this.listener.switchMode(0);
                return;
            case C0099R.id.bGameModes:
                this.listener.switchMode(-2);
                return;
            case C0099R.id.bFeedback:
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"folodapath@gmail.com"});
                intent.putExtra("android.intent.extra.SUBJECT", "Da Path Feedback");
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Choose Email Client"));
                return;
            case C0099R.id.bUnlockStuff:
                this.listener.switchMode(-3);
                return;
            case C0099R.id.bDaQuit:
                getActivity().finish();
                return;
            default:
                return;
        }
    }

    public void onGlobalLayout() {
        if (!this.gameRunning) {
            this.listener.setGame("", new ModeProfile(0, 0, (int) this.titleBar.getY(), getView().getWidth(), this.titleBar.getHeight()), this.handler);
            this.gameRunning = true;
        }
    }
}
