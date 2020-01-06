package com.bawei.dingjianfei20200106.Icmetart;

import com.bawei.dingjianfei20200106.model.bean.Bean;
import com.bawei.dingjianfei20200106.model.bean.BeanRight;

/**
 * 作者：丁建飞
 * 时间：2020/1/6  9:20
 * 类名：com.bawei.dingjianfei20200106.Icmetart
 */
public interface ICallBack {
    interface  IView{
        void onBean(Bean bean);
        void  OnBeanError(Throwable throwable);

        void onBeanRight(BeanRight beanRight);
        void  OnBeanRightError(Throwable throwable);
    }

    interface  IPresenter{
        void getBean();
        void  getBeanRight(String name);
    }
    interface  IModel{
        void getBean(ImodeCallBack imodeCallBack);
        void  getBeanRight(String name,ImodeCallBack imodeCallBack);

        interface  ImodeCallBack{
            void onBean(Bean bean);
            void  OnBeanError(Throwable throwable);

            void onBeanRight(BeanRight beanRight);
            void  OnBeanRightError(Throwable throwable);
        }
    }

}
