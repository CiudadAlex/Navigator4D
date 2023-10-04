package org.leviatanplatform.navigator4d.graphic;

public class ObjectWrapper<T> {

    private T obj;

    public ObjectWrapper(T obj) {
        this.obj = obj;
    }

    public T get() {
        return obj;
    }

    public void set(T obj) {
        this.obj = obj;
    }
}
