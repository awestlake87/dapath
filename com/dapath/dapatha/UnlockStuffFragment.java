package com.dapath.dapatha;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.dapath.gamemodes.ModeProfile;
import java.util.ArrayList;

public class UnlockStuffFragment extends Fragment implements OnClickListener, OnItemClickListener, OnGlobalLayoutListener {
    USListAdapter[] adapters;
    TransitionDrawable crBackground;
    TextView creditLabel;
    boolean gameRunning;
    ListView gamemodes;
    TransitionDrawable gmBackground;
    int[] gmCP;
    TextView gmLabel;
    int gmSelected = 0;
    int gmUN;
    int gmUnlocking;
    USGameMode[] gms;
    int itemSelected;
    DaPathFragmentListener listener;
    USListAdapter modeAdapter;
    Dialog ncDialog;
    int[] pupCP;
    int[] pupUN;
    TextView titleBar;
    TransitionDrawable uBackground;
    TextView udItemName;
    TextView udUnlock;
    Dialog unlockDialog;
    ListView unlockables;

    public UnlockStuffFragment(Context ctx, USGameMode[] gms, int gmun, int[] pupun, int[] gmcp, int[] pupcp) {
        this.gms = gms;
        this.gmUN = gmun;
        this.pupUN = pupun;
        this.gmCP = gmcp;
        this.pupCP = pupcp;
        this.adapters = new USListAdapter[gms.length];
        for (int gm = 0; gm < gms.length; gm++) {
            ArrayList<USListItem> unlockableItems = new ArrayList();
            for (int u = 0; u < gms[gm].unlocks.length; u++) {
                if (gms[gm].unlocks[u].isAvailable) {
                    unlockableItems.add(new USListItem(u, gms[gm].unlocks[u].name, gms[gm].unlocks[u].desc, gms[gm].unlocks[u].value, gms[gm].unlocks[u].isUnlocked));
                }
            }
            this.adapters[gm] = new USListAdapter(ctx, unlockableItems);
        }
        this.unlockDialog = new Dialog(ctx);
        this.unlockDialog.requestWindowFeature(1);
        this.unlockDialog.setContentView(C0099R.layout.unlock_dialog);
        this.unlockDialog.setCancelable(false);
        this.ncDialog = new Dialog(ctx);
        this.ncDialog.requestWindowFeature(1);
        this.ncDialog.setContentView(C0099R.layout.need_credits_dialog);
        this.ncDialog.setCancelable(false);
        this.udItemName = (TextView) this.unlockDialog.findViewById(C0099R.id.udtvItemName);
        this.udUnlock = (TextView) this.unlockDialog.findViewById(C0099R.id.udtvUnlock);
        ((Button) this.unlockDialog.findViewById(C0099R.id.udbYes)).setOnClickListener(this);
        ((Button) this.unlockDialog.findViewById(C0099R.id.udbNo)).setOnClickListener(this);
        ((Button) this.ncDialog.findViewById(C0099R.id.ncbPurchase)).setOnClickListener(this);
        ((Button) this.ncDialog.findViewById(C0099R.id.ncbReturn)).setOnClickListener(this);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C0099R.layout.fragment_unlock_stuff, container, false);
        this.titleBar = (TextView) view.findViewById(C0099R.id.ustvUnlockStuff);
        this.gameRunning = false;
        ((Button) view.findViewById(C0099R.id.usbReturn)).setOnClickListener(this);
        ArrayList<USListItem> modes = new ArrayList();
        for (int gm = 0; gm < this.gms.length; gm++) {
            modes.add(new USListItem(gm, this.gms[gm].mode.name, this.gms[gm].mode.desc, this.gms[gm].mode.value, this.gms[gm].mode.isUnlocked));
        }
        this.modeAdapter = new USListAdapter(getActivity(), modes);
        this.gamemodes = (ListView) view.findViewById(C0099R.id.uslvGameModes);
        this.gamemodes.setAdapter(this.modeAdapter);
        this.gamemodes.setOnItemClickListener(this);
        this.gamemodes.setChoiceMode(1);
        this.gamemodes.setItemChecked(this.gmSelected, true);
        this.gmBackground = (TransitionDrawable) this.gamemodes.getBackground();
        this.gmBackground.startTransition(1);
        this.unlockables = (ListView) view.findViewById(C0099R.id.uslvUnlockables);
        this.uBackground = (TransitionDrawable) this.unlockables.getBackground();
        this.uBackground.startTransition(1);
        this.unlockables.setOnItemClickListener(this);
        this.unlockables.setAdapter(this.adapters[this.gmSelected]);
        this.creditLabel = (TextView) view.findViewById(C0099R.id.tvCredits);
        this.crBackground = (TransitionDrawable) this.creditLabel.getBackground();
        this.crBackground.startTransition(1);
        this.gmLabel = (TextView) view.findViewById(C0099R.id.tvModeLabel);
        this.gmLabel.setText(new StringBuilder(String.valueOf(this.gms[this.gmSelected].mode.name)).append(" Unlockables").toString());
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
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
            case C0099R.id.usbReturn:
                this.listener.popBackStack();
                return;
            case C0099R.id.ncbReturn:
                this.ncDialog.dismiss();
                return;
            case C0099R.id.udbYes:
                int u;
                if (this.itemSelected != -1) {
                    unlockItem(this.gms[this.gmSelected].unlocks[((USListItem) this.adapters[this.gmSelected].items.get(this.itemSelected)).id]);
                    if (this.gms[this.gmSelected].unlocks[((USListItem) this.adapters[this.gmSelected].items.get(this.itemSelected)).id].isUnlocked) {
                        int[] iArr = this.pupUN;
                        int i = this.gmSelected;
                        iArr[i] = iArr[i] + 1;
                        int i2 = 0;
                        for (u = 0; u < this.gms[this.gmSelected].unlocks.length; u++) {
                            if (this.pupUN[this.gmSelected] < this.gms[this.gmSelected].unlocks.length) {
                                this.gms[this.gmSelected].unlocks[u].value = this.pupCP[this.pupUN[this.gmSelected]];
                            }
                            if (this.gms[this.gmSelected].unlocks[u].isAvailable) {
                                ((USListItem) this.adapters[this.gmSelected].items.get(i2)).value = this.gms[this.gmSelected].unlocks[u].value;
                                i2++;
                            }
                        }
                        ((USListItem) this.adapters[this.gmSelected].items.get(this.itemSelected)).unlocked = true;
                        this.unlockables.setAdapter(this.adapters[this.gmSelected]);
                        this.uBackground.resetTransition();
                        this.uBackground.startTransition(1000);
                    }
                } else {
                    unlockItem(this.gms[this.gmUnlocking].mode);
                    if (this.gms[this.gmUnlocking].mode.isUnlocked) {
                        this.gmUN++;
                        for (u = 0; u < this.gms.length; u++) {
                            if (this.gmUN < this.gms.length) {
                                this.gms[u].mode.value = this.gmCP[this.gmUN];
                            }
                            ((USListItem) this.modeAdapter.items.get(u)).value = this.gms[u].mode.value;
                        }
                        ((USListItem) this.modeAdapter.items.get(this.gmUnlocking)).unlocked = true;
                        this.gamemodes.setAdapter(this.modeAdapter);
                        this.gmBackground.resetTransition();
                        this.gmBackground.startTransition(1000);
                        this.gmSelected = this.gmUnlocking;
                        this.gamemodes.setItemChecked(this.gmSelected, true);
                        this.unlockables.setAdapter(this.adapters[this.gmSelected]);
                        this.gmLabel.setText(new StringBuilder(String.valueOf(this.gms[this.gmSelected].mode.name)).append(" Unlockables").toString());
                        this.uBackground.resetTransition();
                        this.uBackground.startTransition(1000);
                    }
                }
                this.unlockDialog.dismiss();
                return;
            case C0099R.id.udbNo:
                this.unlockDialog.dismiss();
                return;
            default:
                return;
        }
    }

    public void onGlobalLayout() {
        if (!this.gameRunning) {
            this.listener.setGame("", new ModeProfile(0, 0, (int) this.titleBar.getY(), getView().getWidth(), this.titleBar.getHeight()), null);
            this.creditLabel.setText(new StringBuilder(String.valueOf(this.listener.getCredits())).toString());
            this.gameRunning = true;
        }
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case C0099R.id.uslvGameModes:
                if (this.gms[position].mode.isUnlocked) {
                    this.unlockables.setAdapter(this.adapters[position]);
                    this.gmLabel.setText(new StringBuilder(String.valueOf(this.gms[position].mode.name)).append(" Unlockables").toString());
                    this.gmSelected = position;
                    this.uBackground.resetTransition();
                    this.uBackground.startTransition(1000);
                    return;
                }
                this.gmUnlocking = position;
                ((ListView) parent).setItemChecked(this.gmSelected, true);
                showDialog(this.gms[position].mode.name, this.gms[position].mode.value);
                this.itemSelected = -1;
                return;
            case C0099R.id.uslvUnlockables:
                if (!this.gms[this.gmSelected].unlocks[((USListItem) this.adapters[this.gmSelected].items.get(position)).id].isUnlocked) {
                    this.itemSelected = position;
                    showDialog(this.gms[this.gmSelected].unlocks[((USListItem) this.adapters[this.gmSelected].items.get(this.itemSelected)).id].name, this.gms[this.gmSelected].unlocks[((USListItem) this.adapters[this.gmSelected].items.get(this.itemSelected)).id].value);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void unlockItem(Unlockable u) {
        if (this.listener.getCredits() >= u.value) {
            u.isUnlocked = true;
            this.listener.setCredits(this.listener.getCredits() - u.value);
            this.creditLabel.setText(new StringBuilder(String.valueOf(this.listener.getCredits())).append("cr").toString());
            this.crBackground.resetTransition();
            this.crBackground.startTransition(1000);
            return;
        }
        this.ncDialog.show();
    }

    public void showDialog(String name, int value) {
        this.udItemName.setText(name);
        this.udUnlock.setText("Unlock for " + value + "cr?");
        this.unlockDialog.show();
    }
}
