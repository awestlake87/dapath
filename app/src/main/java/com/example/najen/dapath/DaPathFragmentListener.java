package com.example.najen.dapath;

import android.graphics.Rect;
import android.os.Handler;
import com.example.najen.dapath.gamemodes.ModeProfile;

public interface DaPathFragmentListener {
    void finishAndResetGame();

    int getCredits();

    void pauseGame();

    void popBackStack();

    void resumeGame();

    void setCredits(int i);

    void setGame(String str, ModeProfile modeProfile /*, Handler handler*/);

    void setMode(int i);

    void setPauseRect(Rect rect);

    void showLeaderboard(int i);

    void showStats(int i);

    void switchMode(int i);
}
