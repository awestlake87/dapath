package com.dapath.dapatha;

public class USListItem {
    int id;
    String modeName;
    String shortDesc;
    boolean unlocked;
    int value;

    public USListItem(int id, String modeName, String shortDesc, int value, boolean unlocked) {
        this.modeName = modeName;
        this.shortDesc = shortDesc;
        this.value = value;
        this.id = id;
        this.unlocked = unlocked;
    }
}
