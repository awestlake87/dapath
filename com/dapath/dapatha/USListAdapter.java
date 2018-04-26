package com.dapath.dapatha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class USListAdapter extends ArrayAdapter<USListItem> {
    Context context;
    ArrayList<USListItem> items;

    public USListAdapter(Context context, ArrayList<USListItem> items) {
        super(context, C0099R.layout.us_item, items);
        this.context = context;
        this.items = items;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(C0099R.layout.us_item, parent, false);
        ((TextView) row.findViewById(C0099R.id.ustvItemName)).setText(((USListItem) this.items.get(position)).modeName);
        ((TextView) row.findViewById(C0099R.id.ustvItemShortDesc)).setText(((USListItem) this.items.get(position)).shortDesc);
        if (((USListItem) this.items.get(position)).unlocked) {
            ((TextView) row.findViewById(C0099R.id.ustvItemCost)).setText("UNLOCKED");
        } else {
            ((TextView) row.findViewById(C0099R.id.ustvItemCost)).setText(((USListItem) this.items.get(position)).value + "cr");
        }
        return row;
    }
}
