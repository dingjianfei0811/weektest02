package com.bawei.dingjianfei20200106.model;

import com.bawei.dingjianfei20200106.Icmetart.ICallBack;
import com.bawei.dingjianfei20200106.model.bean.Bean;
import com.bawei.dingjianfei20200106.model.bean.BeanRight;
import com.bawei.dingjianfei20200106.netutil.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：丁建飞
 * 时间：2020/1/6  9:19
 * 类名：com.bawei.dingjianfei20200106.model
 */
public class ModelDate implements ICallBack.IModel {
    @Override
    public void getBean(ImodeCallBack imodeCallBack) {
        NetUtil.getInstance().getApi().getBean()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        imodeCallBack.onBean(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodeCallBack.OnBeanError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getBeanRight(String name, ImodeCallBack imodeCallBack) {
            NetUtil.getInstance().getApi().getBeanRight(name)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<BeanRight>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(BeanRight beanRight) {
                            imodeCallBack.onBeanRight(beanRight);
                        }

                        @Override
                        public void onError(Throwable e) {
                            imodeCallBack.OnBeanRightError(e);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });

    }
}
