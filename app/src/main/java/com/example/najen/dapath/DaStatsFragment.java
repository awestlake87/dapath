package com.example.najen.dapath;
//
//import android.app.Activity;
//import android.app.Dialog;
//import android.app.DialogFragment;
//import android.os.Bundle;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ListView;
//import com.dapath.gamemodes.OverallStats;
//import com.dapath.gamemodes.Stats;
//
//public class DaStatsFragment extends DialogFragment implements OnClickListener {
//    DaPathFragmentListener listener;
//    int mode;
//    OverallStats ostats;
//    Stats stats;
//
//    public DaStatsFragment(int mode, Stats stats, OverallStats ostats) {
//        this.mode = mode;
//        this.stats = stats;
//        this.ostats = ostats;
//    }
//
//    public ArrayAdapter createAdapter() {
//        int hm = this.stats.HighestMult / 5;
//        return new ArrayAdapter(getActivity(), C0099R.layout.statitem, new String[]{new StringBuilder(String.valueOf(this.stats.GameModeName)).append(" Statistics").toString(), " -High Score: " + this.stats.HighScore, " -Highest Multiplier: " + hm + "." + ((this.stats.HighestMult - (hm * 5)) * 2), "Overall Statistics", " -Fails: " + this.ostats.Fails, " -Power Ups Collected: " + this.ostats.PowerUpsCollected, " -Bombs Detonated: " + this.ostats.BombsDetonated, " -Flips: " + this.ostats.Flips, " -Fattenings: " + this.ostats.Fattenings, " -Supa Slows: " + this.ostats.SupaSlows, " -Maths Collected: " + this.ostats.MathsCollected});
//    }
//
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        Dialog d = new Dialog(getActivity());
//        d.requestWindowFeature(1);
//        d.setContentView(C0099R.layout.dastats);
//        d.setCancelable(false);
//        ((Button) d.findViewById(C0099R.id.dsbLeaderboard)).setOnClickListener(this);
//        ((Button) d.findViewById(C0099R.id.bGoBack)).setOnClickListener(this);
//        ((ListView) d.findViewById(C0099R.id.lvStats)).setAdapter(createAdapter());
//        return d;
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
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case C0099R.id.dsbLeaderboard:
//                this.listener.showLeaderboard(this.mode);
//                return;
//            case C0099R.id.bGoBack:
//                getDialog().dismiss();
//                return;
//            default:
//                return;
//        }
//    }
//}
