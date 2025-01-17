package com.example.mvp.base;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 项目名称：Mvp
 * 作者：Yamy
 * 创建时间：2020/6/2   12:14
 **/
public abstract class BaseObserver implements Observer {
    private Disposable mDisposable;

    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
    }
    //加载数据
    @Override
    public void onNext(Object o) {
        onSuccess(o);
        disposable();
    }
    //成功
    protected abstract void onSuccess(Object o);
    //失败
    @Override
    public void onError(Throwable e) {
        onFail(e);
    }

    protected abstract void onFail(Throwable e);

    @Override
    public void onComplete() {
        disposable();
    }

    public void disposable() {
        if (mDisposable != null && mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }
}
