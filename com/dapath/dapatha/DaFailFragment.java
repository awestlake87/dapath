package com.dapath.dapatha;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DaFailFragment extends Fragment implements OnClickListener {
    TextView creditBar;
    int creditbonus;
    String desc;
    Button failagain;
    boolean highscore;
    Button leaderboard;
    DaPathFragmentListener listener;
    Button menu;
    int mode;
    long score;
    TextView scoreBar;
    TextView scoreDesc;
    Button stats;

    public DaFailFragment(int mode, long score, boolean highscore, int creditbonus) {
        this.mode = mode;
        this.score = score;
        this.desc = highscore ? "NEW HIGH SCORE!" : "FINAL SCORE";
        this.highscore = highscore;
        this.creditbonus = creditbonus;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C0099R.layout.fragment_dafail, container, false);
        this.failagain = (Button) view.findViewById(C0099R.id.dfbFailAgain);
        this.failagain.setOnClickListener(this);
        this.menu = (Button) view.findViewById(C0099R.id.dfbMenu);
        this.menu.setOnClickListener(this);
        this.stats = (Button) view.findViewById(C0099R.id.dfbStats);
        this.stats.setOnClickListener(this);
        this.leaderboard = (Button) view.findViewById(C0099R.id.dfbLeaderboard);
        this.leaderboard.setOnClickListener(this);
        this.scoreBar = (TextView) view.findViewById(C0099R.id.dftvScoreBar);
        this.scoreBar.setText(this.score);
        this.scoreDesc = (TextView) view.findViewById(C0099R.id.dftvScoreDesc);
        this.scoreDesc.setText(this.desc);
        if (this.highscore) {
            this.scoreDesc.setTextSize(20.0f);
        } else {
            this.scoreDesc.setTextSize(12.0f);
        }
        this.creditBar = (TextView) view.findViewById(C0099R.id.dftvCredits);
        this.creditBar.setText("+" + this.creditbonus + "cr");
        return view;
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
            case C0099R.id.dfbLeaderboard:
                this.listener.showLeaderboard(this.mode);
                return;
            case C0099R.id.dfbStats:
                this.listener.showStats(this.mode);
                return;
            case C0099R.id.dfbMenu:
                this.listener.popBackStack();
                this.listener.popBackStack();
                return;
            case C0099R.id.dfbFailAgain:
                this.listener.popBackStack();
                this.listener.finishAndResetGame();
                this.listener.resumeGame();
                return;
            default:
                return;
        }
    }

    public void enableButtons() {
    }
}
