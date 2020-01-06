package com.bawei.dingjianfei20200106.pager;

import com.bawei.dingjianfei20200106.Icmetart.ICallBack;
import com.bawei.dingjianfei20200106.base.BasePresenter;
import com.bawei.dingjianfei20200106.model.ModelDate;
import com.bawei.dingjianfei20200106.model.bean.Bean;
import com.bawei.dingjianfei20200106.model.bean.BeanRight;

/**
 * 作者：丁建飞
 * 时间：2020/1/6  9:25
 * 类名：com.bawei.dingjianfei20200106.pager
 */
public class Presenter extends BasePresenter<ICallBack.IView> implements ICallBack.IPresenter {

    private ModelDate modelDate;

    @Override
    public void getBean() {
        modelDate.getBean(new ICallBack.IModel.ImodeCallBack() {
            @Override
            public void onBean(Bean bean) {
                view.onBean(bean);
            }

            @Override
            public void OnBeanError(Throwable throwable) {
view.OnBeanError(throwable);
            }

            @Override
            public void onBeanRight(BeanRight beanRight) {
view.onBeanRight(beanRight);
            }

            @Override
            public void OnBeanRightError(Throwable throwable) {
view.OnBeanRightError(throwable);
            }
        });
    }

    @Override
    public void getBeanRight(String name) {
            modelDate.getBeanRight(name, new ICallBack.IModel.ImodeCallBack() {
                @Override
                public void onBean(Bean bean) {
                    view.onBean(bean);
                }

                @Override
                public void OnBeanError(Throwable throwable) {
                    view.OnBeanError(throwable);
                }

                @Override
                public void onBeanRight(BeanRight beanRight) {
                    view.onBeanRight(beanRight);
                }

                @Override
                public void OnBeanRightError(Throwable throwable) {
                    view.OnBeanRightError(throwable);
                }
            });
    }

    @Override
    protected void initModel() {
        modelDate = new ModelDate();
    }
}
