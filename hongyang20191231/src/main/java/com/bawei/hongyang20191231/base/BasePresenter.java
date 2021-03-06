package com.bawei.hongyang20191231.base;

import java.lang.ref.WeakReference;

/**
 * Created by Android Studio.
 * User: HONGYANG
 */

public abstract class BasePresenter<M extends IBaseModel, V extends IBaseView> {

    public M model;
    public WeakReference<V> weakReference;

    public BasePresenter() {
        model = initModel();
    }

    protected abstract M initModel();

    public void attach(V v) {
        weakReference = new WeakReference<>(v);
    }

    public void detach() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    public V getView() {
        return weakReference.get();
    }
}
