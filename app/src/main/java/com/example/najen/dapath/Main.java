package com.example.najen.dapath;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import com.example.najen.dapath.gamemodes.Game;
import com.example.najen.dapath.gamemodes.ModeProfile;
//import com.dapath.gamemodes.OverallStats;
//import com.dapath.gamemodes.Stats;
import com.example.najen.dapath.pathgen.PathGenerator;
import java.lang.Thread.State;

public class Main extends Activity implements OnClickListener, DaPathFragmentListener {
    public static final int APPLIER_FLASH = 8;
    public static final int DA_FAIL = 2;
    public static final String DIALOG_ERROR = "dialog_error";
    public static final int[] GMCostProgression;
    public static final float[] GMCreditRate = new float[]{0.001f, 0.0013333333f, 0.002f, 0.0033333334f};
    public static final int MODE_DACLASSIC = 0;
    public static final int MODE_DAGETFAST = 1;
    public static final int MODE_GAMEMODEMENU = -2;
    public static final int MODE_LECRAYCRAY = 2;
    public static final int MODE_MAINMENU = -1;
    public static final int MODE_MOARFAIL = 3;
    public static final int MODE_NUM = 4;
    public static final int MODE_UNLOCKSTUFF = -3;
    public static final int[] PUPCostProgression = new int[]{100, 200, 300, 500, 750};
    public static final int PUP_DABOMB = 0;
    public static final int PUP_DAFATTENING = 2;
    public static final int PUP_DAFLIP = 3;
    public static final int PUP_DAMATHS = 4;
    public static final int PUP_DASUPASLOW = 1;
    public static final int REQUEST_RESOLVE_ERROR = 1001;
    public static final int SCORE_BAR_FLASH = 7;
    public static final int SETUP_MENU = 3;
    public static final int SET_APPLIER = 5;
    public static final int SET_MBAR = 4;
    public static final int SET_MULTIPLIER = 6;
    public static final int SET_PAUSE_BAR = 9;
    public static final int SET_SCORE = 1;
    public static int background = 0;
    public static Bitmap bmpDaBomb = null;
    public static Bitmap bmpDaFattening = null;
    public static Bitmap bmpDaFlip = null;
    public static Bitmap bmpDaMaths = null;
    public static Bitmap bmpDaSupaSlow = null;
    public static Bitmap bmpLensFlare = null;
    public static int darkforeground = 0;
    public static int foreground = 0;
    public static final String[] gmDescs = new String[]{"Collect Power-Ups as the path gets faster", "No Power-Ups, just get fast", "It's...so...crazy", "Do not not touch the path"};
    public static final String[] gmNames = new String[]{"Da Classic", "Da Get Fast", "Le Cray Cray", "MOAR FAIL"};
    public static final String[] gmTags = new String[]{"DC", "DGF", "LCC", "MF"};
    public static int gmUnlockNum = 0;
    public static final String[] gmUnlockables = new String[]{"11111", "00000", "11111", "01100"};
    public static final float iconRadius = 0.12f;
    public static final float lensFlareHeight = 0.6f;
    public static final float lensFlareWidth = 0.6f;
    public static final String[] pupDescs = new String[]{"Explodes for bonus points", "Temporarily slows down time", "Fattens the path", "Avoid the path", "Multiplier bonus"};
    public static final String[] pupNames = new String[]{"Da Bomb", "Da Supa Slow", "Da Fattening", "Da Flip", "Da Maths"};
    public static int[] pupUnlockNum;
    int credits;
    //DaFailFragment dafailFrag;
    Dialog dapause;
    //DaStatsFragment dastatsFrag;
    FragmentManager fragmentManager;
    FrameLayout gameFrame;
    //Stats[] gmStats;
    //USGameMode[] gms;
    Handler handler = new C00981();
    //HUD hudFrag;
    MainMenuFragment mainmenuFrag;
    int mode;
    //ModeMenuFragment modemenuFrag;
    //OverallStats ostats;
    boolean released;
    GameSurface surface;
    boolean testMode;
    GameThread thread;
    //UnlockStuffFragment unlockstuffFrag;

    class C00981 extends Handler {
        C00981() {
        }

        public void handleMessage(Message msg) {
            switch (msg.arg1) {
                case 1:
                    //Main.this.hudFrag.setScore(msg.getData().getLong("SCORE"));
                    return;
                case 2:
//                    Bundle data = msg.getData();
//                    boolean highscore = false;
//                    int creditbonus = 0;
//                    if (!Main.this.testMode) {
//                        OverallStats overallStats = Main.this.ostats;
//                        overallStats.Fails += data.getInt("FAILS");
//                        overallStats = Main.this.ostats;
//                        overallStats.PowerUpsCollected += data.getInt("PUC");
//                        overallStats = Main.this.ostats;
//                        overallStats.BombsDetonated += data.getInt("BD");
//                        overallStats = Main.this.ostats;
//                        overallStats.Fattenings += data.getInt("FATS");
//                        overallStats = Main.this.ostats;
//                        overallStats.Flips += data.getInt("FLIPS");
//                        overallStats = Main.this.ostats;
//                        overallStats.MathsCollected += data.getInt("MATHS");
//                        overallStats = Main.this.ostats;
//                        overallStats.SupaSlows += data.getInt("SS");
//                        Main.this.gmStats[Main.this.mode].GameModeName = data.getString("NAME");
//                        if (Main.this.gmStats[Main.this.mode].HighScore < data.getLong("SCORE")) {
//                            Main.this.gmStats[Main.this.mode].HighScore = data.getLong("SCORE");
//                            highscore = true;
//                        } else {
//                            highscore = false;
//                        }
//                        if (Main.this.gmStats[Main.this.mode].HighestMult < data.getInt("HM")) {
//                            Main.this.gmStats[Main.this.mode].HighestMult = data.getInt("HM");
//                        }
//                        creditbonus = (int) (((float) data.getLong("SCORE")) * Main.GMCreditRate[Main.this.mode]);
//                        Main main = Main.this;
//                        main.credits += creditbonus;
//                        if (Main.this.isSignedIn()) {
//                            switch (Main.this.mode) {
//                                case 0:
//                                    Games.Leaderboards.submitScore(Main.this.getApiClient(), Main.this.getString(C0099R.string.daclassic_ldr), Main.this.gmStats[Main.this.mode].HighScore);
//                                    break;
//                                case 1:
//                                    Games.Leaderboards.submitScore(Main.this.getApiClient(), Main.this.getString(C0099R.string.dagetfast_ldr), Main.this.gmStats[Main.this.mode].HighScore);
//                                    break;
//                                case 2:
//                                    Games.Leaderboards.submitScore(Main.this.getApiClient(), Main.this.getString(C0099R.string.lecraycray_ldr), Main.this.gmStats[Main.this.mode].HighScore);
//                                    break;
//                                case 3:
//                                    Games.Leaderboards.submitScore(Main.this.getApiClient(), Main.this.getString(C0099R.string.moarfail_ldr), Main.this.gmStats[Main.this.mode].HighScore);
//                                    break;
//                            }
//                        }
//                    }
//                    FragmentTransaction ft = Main.this.fragmentManager.beginTransaction();
//                    Main.this.dafailFrag = new DaFailFragment(Main.this.mode, data.getLong("SCORE"), highscore, creditbonus);
//                    ft.add(Main.this.gameFrame.getId(), Main.this.dafailFrag);
//                    ft.addToBackStack(null);
//                    ft.commit();
                    return;
                case 3:
//                    Main.this.mode = 519325;
//                    Main.this.switchMode(-1);
//                    int iconDim = (int) (0.24f * ((float) Main.this.surface.getWidth()));
//                    Main.bmpDaBomb = Main.decodeSampledBitmapFromResource(Main.this.getResources(), C0099R.drawable.dabomb_pup, iconDim, iconDim);
//                    Main.bmpDaFattening = Main.decodeSampledBitmapFromResource(Main.this.getResources(), C0099R.drawable.dafattening_pup, iconDim, iconDim);
//                    Main.bmpDaFlip = Main.decodeSampledBitmapFromResource(Main.this.getResources(), C0099R.drawable.daflip_pup, iconDim, iconDim);
//                    Main.bmpDaSupaSlow = Main.decodeSampledBitmapFromResource(Main.this.getResources(), C0099R.drawable.dasupaslow_pup, iconDim, iconDim);
//                    Main.bmpDaMaths = Main.decodeSampledBitmapFromResource(Main.this.getResources(), C0099R.drawable.damaths_pup, iconDim, iconDim);
//                    Main.bmpLensFlare = Main.decodeSampledBitmapFromResource(Main.this.getResources(), C0099R.drawable.lens_flare, (int) (((float) Main.this.surface.getWidth()) * 0.6f), (int) (((float) Main.this.surface.getWidth()) * 0.6f));
                    return;
                case 4:
                    //Main.this.hudFrag.setMultBarProgress(msg.arg2 + 100);
                    return;
                case 5:
                    //Main.this.hudFrag.setAppBarProgress(msg.arg2);
                    return;
                case 6:
                    //Main.this.hudFrag.setMultiplier(msg.arg2);
                    return;
                case 7:
                    //Main.this.hudFrag.startScoreBarFlash(msg.arg2);
                    return;
                case 8:
                    //Main.this.hudFrag.startApplierFlash(msg.arg2);
                    return;
                case 9:
                    //Main.this.hudFrag.setPauseBar(msg.arg2);
                    return;
                default:
                    return;
            }
        }
    }

    static {
        int[] iArr = new int[4];
        iArr[1] = 500;
        iArr[2] = 750;
        iArr[3] = 1000;
        GMCostProgression = iArr;
    }

    public Main() {
        //super(1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        PathGenerator.init();
//        loadStats();
//        this.testMode = false;
        this.fragmentManager = getFragmentManager();
        this.mainmenuFrag = new MainMenuFragment(/*this.handler*/);
//        loadUnlockStuff();
//        this.unlockstuffFrag = new UnlockStuffFragment(this, this.gms, gmUnlockNum, pupUnlockNum, GMCostProgression, PUPCostProgression);
//        this.modemenuFrag = new ModeMenuFragment(this.gms);
//        this.dafailFrag = new DaFailFragment(0, 0, false, 0);
//        this.adFrag = new AdFragment();
//        this.dapause = new Dialog(this);
//        this.dapause.requestWindowFeature(1);
//        this.dapause.setContentView(C0099R.layout.dapause);
//        this.dapause.setCancelable(false);
        this.surface = new GameSurface(this, this.handler);
        this.thread = new GameThread(this.surface, this.surface.getSurfaceHolder(), this.handler);
        this.thread.setRunning(true);

        foreground = getResources().getColor(R.color.foreground);
        background = getResources().getColor(R.color.background);
        darkforeground = getResources().getColor(R.color.selected);
        this.gameFrame = (FrameLayout) ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.game_frame, null);
//        ((Button) this.dapause.findViewById(C0099R.id.dpbMenu)).setOnClickListener(this);
//        ((Button) this.dapause.findViewById(C0099R.id.dpbReset)).setOnClickListener(this);
//        ((Button) this.dapause.findViewById(C0099R.id.dpbResume)).setOnClickListener(this);
        this.gameFrame.addView(this.surface);
        this.fragmentManager.beginTransaction().commit();
        setContentView(this.gameFrame);
        super.onCreate(savedInstanceState);
//        beginUserInitiatedSignIn();

        switchMode(MODE_MAINMENU);
    }

    public void loadUnlockStuff() {
//        int gm;
//        SharedPreferences pref = getSharedPreferences("com.dapath.dapatha.unlock_stuff", 0);
//        this.gms = new USGameMode[4];
//        this.credits = pref.getInt("CREDITS", 0);
//        this.credits += 5000;
//        gmUnlockNum = 0;
//        pupUnlockNum = new int[4];
//        for (gm = 0; gm < 4; gm++) {
//            boolean z;
//            this.gms[gm] = new USGameMode();
//            this.gms[gm].mode = new Unlockable();
//            this.gms[gm].mode.name = gmNames[gm];
//            this.gms[gm].mode.desc = gmDescs[gm];
//            Unlockable unlockable = this.gms[gm].mode;
//            String stringBuilder = new StringBuilder(String.valueOf(gmTags[gm])).append("U").toString();
//            if (gm == 0) {
//                z = true;
//            } else {
//                z = false;
//            }
//            unlockable.isUnlocked = pref.getBoolean(stringBuilder, z);
//            if (this.gms[gm].mode.isUnlocked) {
//                gmUnlockNum++;
//            }
//            this.gms[gm].unlocks = new Unlockable[5];
//            for (int u = 0; u < this.gms[gm].unlocks.length; u++) {
//                char i = gmUnlockables[gm].charAt(u);
//                this.gms[gm].unlocks[u] = new Unlockable();
//                switch (i) {
//                    case '0':
//                        this.gms[gm].unlocks[u].isAvailable = false;
//                        break;
//                    case '1':
//                        this.gms[gm].unlocks[u].isAvailable = true;
//                        this.gms[gm].unlocks[u].name = pupNames[u];
//                        this.gms[gm].unlocks[u].desc = pupDescs[u];
//                        this.gms[gm].unlocks[u].isUnlocked = pref.getBoolean(new StringBuilder(String.valueOf(gmTags[gm])).append(u).append("U").toString(), false);
//                        if (!this.gms[gm].unlocks[u].isUnlocked) {
//                            break;
//                        }
//                        int[] iArr = pupUnlockNum;
//                        iArr[gm] = iArr[gm] + 1;
//                        break;
//                    default:
//                        break;
//                }
//            }
//            for (Unlockable unlockable2 : this.gms[gm].unlocks) {
//                if (pupUnlockNum[gm] < 5) {
//                    unlockable2.value = PUPCostProgression[pupUnlockNum[gm]];
//                }
//            }
//        }
//        for (gm = 0; gm < 4; gm++) {
//            if (gmUnlockNum < 4) {
//                this.gms[gm].mode.value = GMCostProgression[gmUnlockNum];
//            }
//        }
    }

    public void saveUnlockStuff() {
//        Editor editor = getSharedPreferences("com.dapath.dapatha.unlock_stuff", 0).edit();
//        editor.putInt("CREDITS", this.credits);
//        for (int gm = 0; gm < 4; gm++) {
//            editor.putBoolean(new StringBuilder(String.valueOf(gmTags[gm])).append("U").toString(), this.gms[gm].mode.isUnlocked);
//            for (int u = 0; u < this.gms[gm].unlocks.length; u++) {
//                editor.putBoolean(new StringBuilder(String.valueOf(gmTags[gm])).append(u).append("U").toString(), this.gms[gm].unlocks[u].isUnlocked);
//            }
//        }
//        editor.commit();
    }

    public void clearUnlockStuff() {
//        this.credits = 0;
//        gmUnlockNum = 0;
//        pupUnlockNum = new int[4];
//        for (int gm = 0; gm < 4; gm++) {
//            boolean z;
//            Unlockable unlockable = this.gms[gm].mode;
//            if (gm == 0) {
//                z = true;
//            } else {
//                z = false;
//            }
//            unlockable.isUnlocked = z;
//            this.gms[gm].mode.value = GMCostProgression[gmUnlockNum];
//            for (int u = 0; u < this.gms[gm].unlocks.length; u++) {
//                this.gms[gm].unlocks[u].isUnlocked = false;
//                this.gms[gm].unlocks[u].value = PUPCostProgression[pupUnlockNum[gm]];
//            }
//        }
    }

    public void switchMode(int newMode) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        switch (this.mode) {
            case MODE_UNLOCKSTUFF /*-3*/:
                //ft.remove(this.unlockstuffFrag);
                break;
            case -2:
                //ft.remove(this.modemenuFrag);
                break;
            case -1:
                ft.remove(this.mainmenuFrag);
                break;
            case 0:
            case 1:
            case 2:
            case 3:
                //ft.remove((Fragment) this.hudFrag);
                break;
        }
        ModeProfile modeProfile;
        switch (newMode) {
            case MODE_UNLOCKSTUFF /*-3*/:
                //ft.add(this.gameFrame.getId(), this.unlockstuffFrag);
                ft.addToBackStack(null);
                break;
            case -2:
                //ft.add(this.gameFrame.getId(), this.modemenuFrag);
                ft.addToBackStack(null);
                break;
            case -1:
                ft.add(this.gameFrame.getId(), this.mainmenuFrag);
                if (this.mode != 519325) {
                    ft.addToBackStack(null);
                    break;
                }
                break;
            case 0:
                //this.hudFrag = new MultBarHUDFragment();
                ft.addToBackStack(null);
//                ft.add(this.gameFrame.getId(), (Fragment) this.hudFrag);
//                ModeProfile mp = new ModeProfile(1, 0, 0, this.surface.getWidth(), this.surface.getHeight());
//                mp.DaBombUnlocked = this.gms[0].unlocks[0].isUnlocked;
//                mp.DaSupaSlowUnlocked = this.gms[0].unlocks[1].isUnlocked;
//                mp.DaFatteningUnlocked = this.gms[0].unlocks[2].isUnlocked;
//                mp.DaMathsUnlocked = this.gms[0].unlocks[4].isUnlocked;
//                mp.DaFlipUnlocked = this.gms[0].unlocks[3].isUnlocked;
//                this.surface.game = new Game(gmNames[0], mp, this.handler);
                break;
            case 1:
//                this.hudFrag = new MultBarHUDFragment();
                ft.addToBackStack(null);
//                ft.add(this.gameFrame.getId(), (Fragment) this.hudFrag);
//                modeProfile = new ModeProfile(2, 0, 0, this.surface.getWidth(), this.surface.getHeight());
//                this.surface.game = new Game(gmNames[1], modeProfile, this.handler);
                break;
            case 2:
//                this.hudFrag = new MultBarHUDFragment();
                ft.addToBackStack(null);
//                ft.add(this.gameFrame.getId(), (Fragment) this.hudFrag);
//                modeProfile = new ModeProfile(3, 0, 0, this.surface.getWidth(), this.surface.getHeight());
//                modeProfile.DaBombUnlocked = this.gms[2].unlocks[0].isUnlocked;
//                modeProfile.DaSupaSlowUnlocked = this.gms[2].unlocks[1].isUnlocked;
//                modeProfile.DaFatteningUnlocked = this.gms[2].unlocks[2].isUnlocked;
//                modeProfile.DaMathsUnlocked = this.gms[2].unlocks[4].isUnlocked;
//                modeProfile.DaFlipUnlocked = this.gms[2].unlocks[3].isUnlocked;
//                this.surface.game = new Game(gmNames[2], modeProfile, this.handler);
                break;
            case 3:
//                this.hudFrag = new NoMultBarHUDFragment();
                ft.addToBackStack(null);
//                ft.add(this.gameFrame.getId(), (Fragment) this.hudFrag);
//                modeProfile = new ModeProfile(4, 0, 0, this.surface.getWidth(), this.surface.getHeight());
//                modeProfile.DaBombUnlocked = this.gms[3].unlocks[0].isUnlocked;
//                modeProfile.DaSupaSlowUnlocked = this.gms[3].unlocks[1].isUnlocked;
//                modeProfile.DaFatteningUnlocked = this.gms[3].unlocks[2].isUnlocked;
//                modeProfile.DaMathsUnlocked = this.gms[3].unlocks[4].isUnlocked;
//                modeProfile.DaFlipUnlocked = this.gms[3].unlocks[3].isUnlocked;
//                this.surface.game = new Game(gmNames[3], modeProfile, this.handler);
                break;
        }
        ft.commit();
        this.mode = newMode;
    }

    public void popBackStack() {
        if (this.fragmentManager.getBackStackEntryCount() != 0) {
            this.fragmentManager.popBackStack();
        }
    }

    public void onBackPressed() {
        if (this.fragmentManager.getBackStackEntryCount() != 0) {
            this.fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    public void loadStats() {
//        SharedPreferences pref = getSharedPreferences("com.dapath.dapath.overall_stats", 0);
//        this.gmStats = new Stats[4];
//        this.ostats = new OverallStats();
//        if (pref != null) {
//            this.ostats.Fails = pref.getInt("FAILS", 0);
//            this.ostats.PowerUpsCollected = pref.getInt("PUC", 0);
//            this.ostats.BombsDetonated = pref.getInt("BD", 0);
//            this.ostats.Flips = pref.getInt("FLIPS", 0);
//            this.ostats.Fattenings = pref.getInt("FATS", 0);
//            this.ostats.SupaSlows = pref.getInt("SS", 0);
//            this.ostats.MathsCollected = pref.getInt("MATHS", 0);
//        }
//        for (int gm = 0; gm < 4; gm++) {
//            pref = getSharedPreferences("com.dapath.dapath.gm" + gm + "_stats", 0);
//            if (pref != null) {
//                this.gmStats[gm] = new Stats();
//                this.gmStats[gm].GameModeName = pref.getString("NAME", gmNames[gm]);
//                this.gmStats[gm].HighScore = pref.getLong("SCORE", 0);
//                this.gmStats[gm].HighestMult = pref.getInt("HM", 0);
//            }
//        }
    }

    public void saveStats() {
//        Editor editor = getSharedPreferences("com.dapath.dapath.overall_stats", 0).edit();
//        editor.putInt("FAILS", this.ostats.Fails);
//        editor.putInt("PUC", this.ostats.PowerUpsCollected);
//        editor.putInt("BD", this.ostats.BombsDetonated);
//        editor.putInt("FLIPS", this.ostats.Flips);
//        editor.putInt("FATS", this.ostats.Fattenings);
//        editor.putInt("SS", this.ostats.SupaSlows);
//        editor.putInt("MATHS", this.ostats.MathsCollected);
//        editor.commit();
//        for (int gm = 0; gm < 4; gm++) {
//            editor = getSharedPreferences("com.dapath.dapath.gm" + gm + "_stats", 0).edit();
//            editor.putString("NAME", this.gmStats[gm].GameModeName);
//            editor.putLong("SCORE", this.gmStats[gm].HighScore);
//            editor.putInt("HM", this.gmStats[gm].HighestMult);
//            editor.commit();
//        }
    }

    public void clearStats() {
//        Editor editor = getSharedPreferences("com.dapath.dapath.overall_stats", 0).edit();
//        editor.putInt("FAILS", 0);
//        editor.putInt("PUC", 0);
//        editor.putInt("BD", 0);
//        editor.putInt("FLIPS", 0);
//        editor.putInt("FATS", 0);
//        editor.putInt("SS", 0);
//        editor.putInt("MATHS", 0);
//        editor.commit();
//        for (int gm = 0; gm < 4; gm++) {
//            editor = getSharedPreferences("com.dapath.dapath.gm" + gm + "_stats", 0).edit();
//            editor.putString("NAME", "");
//            editor.putLong("SCORE", 0);
//            editor.putInt("HM", 0);
//            editor.commit();
//        }
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case C0099R.id.dpbMenu:
//                this.dapause.dismiss();
//                popBackStack();
//                return;
//            case C0099R.id.dpbReset:
//                this.surface.game.finishAndReset();
//                this.surface.game.pause();
//                return;
//            case C0099R.id.dpbResume:
//                this.surface.game.resume();
//                this.dapause.dismiss();
//                return;
//            case C0099R.id.dfbMenu:
//                popBackStack();
//                return;
//            default:
//                return;
//        }
    }

    @Override
    protected void onResume() {
//        if (this.thread.getState() == State.TERMINATED) {
//            this.thread = new GameThread(this.surface, this.surface.getSurfaceHolder(), this.handler);
//            this.thread.setRunning(true);
//            this.thread.start();
//        } else if (this.thread.getState() == State.NEW) {
//            this.thread.setRunning(true);
//            this.thread.start();
//        }
//        if (this.mode >= 0 && this.surface.game != null) {
//            if (this.dafailFrag == null) {
//                this.surface.game.pause();
//                this.dapause.show();
//            } else if (!this.dafailFrag.isVisible()) {
//                this.surface.game.pause();
//                this.dapause.show();
//            }
//        }
        super.onResume();
    }

    @Override
    protected void onPause() {
//        if (this.mode >= 0 && this.surface.game != null) {
//            this.surface.game.pause();
//        }
//        this.thread.setRunning(false);
//        boolean retry = true;
//        while (retry) {
//            try {
//                this.thread.join();
//                retry = false;
//            } catch (InterruptedException e) {
//            }
//        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
//        saveStats();
//        saveUnlockStuff();
//        signOut();
//        this.thread.setRunning(false);
//        boolean retry = true;
//        while (retry) {
//            try {
//                this.thread.join();
//                retry = false;
//            } catch (InterruptedException e) {
//            }
//        }
        super.onDestroy();
    }

    public void onSignInFailed() {
    }

    public void onSignInSucceeded() {
    }

    @Override
    public void setGame(String name, ModeProfile profile/*, Handler handler*/) {
        this.surface.game = new Game(name, profile, this.handler);
    }

    public void pauseGame() {
//        this.surface.game.pause();
//        if (!this.dapause.isShowing()) {
//            this.dapause.show();
//        }
    }

    public void finishAndResetGame() {
//        this.surface.game.finishAndReset();
    }

    public void showStats(int gamemode) {
//        this.dastatsFrag = new DaStatsFragment(gamemode, this.gmStats[gamemode], this.ostats);
//        this.dastatsFrag.show(this.fragmentManager, "dastats");
    }

    public void showLeaderboard(int gamemode) {
//        if (isSignedIn()) {
//            switch (gamemode) {
//                case 0:
//                    startActivityForResult(Games.Leaderboards.getLeaderboardIntent(getApiClient(), getString(C0099R.string.daclassic_ldr)), 1);
//                    return;
//                case 1:
//                    startActivityForResult(Games.Leaderboards.getLeaderboardIntent(getApiClient(), getString(C0099R.string.dagetfast_ldr)), 1);
//                    return;
//                case 2:
//                    startActivityForResult(Games.Leaderboards.getLeaderboardIntent(getApiClient(), getString(C0099R.string.lecraycray_ldr)), 1);
//                    return;
//                case 3:
//                    startActivityForResult(Games.Leaderboards.getLeaderboardIntent(getApiClient(), getString(C0099R.string.moarfail_ldr)), 1);
//                    return;
//                default:
//                    return;
//            }
//        }
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            int halfHeight = height / 2;
            int halfWidth = width / 2;
            while (halfHeight / inSampleSize > reqHeight && halfWidth / inSampleSize > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void resumeGame() {
//        this.surface.game.resume();
    }

    public void setPauseRect(Rect r) {
//        this.surface.game.setPauseRect(r);
    }

    public int getCredits() {
        return this.credits;
    }

    public void setCredits(int c) {
        this.credits = c;
    }
}
