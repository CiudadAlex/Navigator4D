package org.leviatanplatform.navigator4d.graphic;

import java.util.List;

public class CyclicIterator<T> {

    private Integer index;
    private List<T> listItems;

    public CyclicIterator(List<T> listItems) {
        this.listItems = listItems;
    }

    private  T nextItem() {
        index = index == null ? 0 : ( index + 1 ) % listItems.size();
        return listItems.get(index);
    }

    private T previousItem() {
        index = index == null || index == 0 ? listItems.size() - 1 : index - 1;
        return listItems.get(index);
    }

    public T newOne(boolean next) {
        return next ? nextItem() : previousItem();
    }
}
