package com.dapath.dapatha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class ModeListAdapter extends ArrayAdapter<ModeListItem> {
    Context context;
    ArrayList<ModeListItem> items;

    public ModeListAdapter(Context context, ArrayList<ModeListItem> items) {
        super(context, C0099R.layout.modeitem, items);
        this.context = context;
        this.items = items;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(C0099R.layout.modeitem, parent, false);
        ((TextView) row.findViewById(C0099R.id.mitvItemName)).setText(((ModeListItem) this.items.get(position)).modeName);
        ((TextView) row.findViewById(C0099R.id.mitvItemShortDesc)).setText(((ModeListItem) this.items.get(position)).shortDesc);
        ModeListItem i = (ModeListItem) this.items.get(position);
        i.stats = (Button) row.findViewById(C0099R.id.mibStats);
        i.stats.setOnClickListener(i);
        return row;
    }
}
