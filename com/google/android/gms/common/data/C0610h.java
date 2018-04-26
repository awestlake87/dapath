package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class C0610h<T> extends C0159c<T> {
    private T EW;

    public C0610h(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public T next() {
        if (hasNext()) {
            this.EB++;
            if (this.EB == 0) {
                this.EW = this.EA.get(0);
                if (!(this.EW instanceof C0160d)) {
                    throw new IllegalStateException("DataBuffer reference of type " + this.EW.getClass() + " is not movable");
                }
            }
            ((C0160d) this.EW).ac(this.EB);
            return this.EW;
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.EB);
    }
}
