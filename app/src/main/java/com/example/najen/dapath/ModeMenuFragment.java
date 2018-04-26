package com.example.najen.dapath;

//import android.app.Activity;
//import android.app.Fragment;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.ViewTreeObserver.OnGlobalLayoutListener;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.Button;
//import android.widget.ListView;
//import android.widget.TextView;
//import com.dapath.gamemodes.ModeProfile;
//import java.util.ArrayList;
//
//public class ModeMenuFragment extends Fragment implements OnClickListener, OnItemClickListener, OnGlobalLayoutListener {
//    ModeListAdapter adapter;
//    boolean gameRunning;
//    USGameMode[] gms;
//    DaPathFragmentListener listener;
//    TextView titleBar;
//
//    public ModeMenuFragment(USGameMode[] gms) {
//        this.gms = gms;
//    }
//
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(C0099R.layout.fragment_modemenu, container, false);
//        this.titleBar = (TextView) view.findViewById(C0099R.id.tvGameModes);
//        ArrayList<ModeListItem> modes = new ArrayList();
//        for (int gm = 0; gm < this.gms.length; gm++) {
//            if (this.gms[gm].mode.isUnlocked) {
//                modes.add(new ModeListItem(this.listener, gm, this.gms[gm].mode.name, this.gms[gm].mode.desc));
//            }
//        }
//        this.adapter = new ModeListAdapter(getActivity(), modes);
//        ((Button) view.findViewById(C0099R.id.bReturn)).setOnClickListener(this);
//        ((ListView) view.findViewById(C0099R.id.lvGameModes)).setAdapter(this.adapter);
//        ((ListView) view.findViewById(C0099R.id.lvGameModes)).setOnItemClickListener(this);
//        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
//        this.gameRunning = false;
//        this.listener.setMode(-2);
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
//    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//        this.listener.switchMode(((ModeListItem) this.adapter.items.get(position)).mode);
//    }
//
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case C0099R.id.bReturn:
//                this.listener.popBackStack();
//                return;
//            default:
//                return;
//        }
//    }
//
//    public void onGlobalLayout() {
//        if (!this.gameRunning) {
//            this.listener.setGame("", new ModeProfile(0, 0, (int) this.titleBar.getY(), getView().getWidth(), this.titleBar.getHeight()), null);
//            this.gameRunning = true;
//        }
//    }
//}
