package com.bawei.dingjianfei20200106;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.dingjianfei20200106.Icmetart.ICallBack;
import com.bawei.dingjianfei20200106.base.BaseAPPivity;
import com.bawei.dingjianfei20200106.database.Dao1Dao;
import com.bawei.dingjianfei20200106.database.Dao2Dao;
import com.bawei.dingjianfei20200106.database.DaoMaster;
import com.bawei.dingjianfei20200106.database.DaoSession;
import com.bawei.dingjianfei20200106.model.bean.Bean;
import com.bawei.dingjianfei20200106.model.bean.BeanRight;
import com.bawei.dingjianfei20200106.model.dao.Dao1;
import com.bawei.dingjianfei20200106.model.dao.Dao2;
import com.bawei.dingjianfei20200106.netutil.NetUtil;
import com.bawei.dingjianfei20200106.pager.Presenter;
import com.bawei.dingjianfei20200106.view.adapter.AdapterBean;
import com.bawei.dingjianfei20200106.view.adapter.AdapterBeanRight;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseAPPivity<Presenter> implements ICallBack.IView {


    @BindView(R.id.view1)
    RecyclerView view1;
    @BindView(R.id.view2)
    RecyclerView view2;
    private Dao1Dao dao1Dao;
    private Dao2Dao dao2Dao;

    @Override
    protected void initDAte() {
        DaoSession daoSession = DaoMaster.newDevSession(this, "add.db");

        dao1Dao = daoSession.getDao1Dao();
        dao2Dao = daoSession.getDao2Dao();


        if (NetUtil.getInstance().wWang(this)){
            mPresenter.getBean();
        }else {
            Dao1 unique = dao1Dao.queryBuilder().unique();
            if (unique != null) {
                String a = unique.getA();
                Bean bean = new Gson().fromJson(a, Bean.class);
                List<String> category = bean.getCategory();

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);


                view1.setLayoutManager(linearLayoutManager);

                AdapterBean adapterBean = new AdapterBean(category);

                view1.setAdapter(adapterBean);
                adapterBean.setOnclick(new AdapterBean.Onclick() {
                    @Override
                    public void onclick(int p) {
                        String s = category.get(p);
                        EventBus.getDefault().post(s);
                    }
                });
                String s = category.get(0);
                mPresenter.getBeanRight(s);
            }


            Dao2 unique1 = dao2Dao.queryBuilder().unique();
            if (unique1 != null) {
                String b = unique1.getB();
                BeanRight beanRight = new Gson().fromJson(b, BeanRight.class);
                List<BeanRight.DataBean> data = beanRight.getData();
                view2.setLayoutManager(new GridLayoutManager(this,2));
                AdapterBeanRight adapterBeanRight = new AdapterBeanRight(data);
                view2.setAdapter(adapterBeanRight);

            }


        }

    }

    @Override
    protected void initView() {

    }

    @Override
    protected Presenter priPresenter() {
        return new Presenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onBean(Bean bean) {
        List<String> category = bean.getCategory();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);


        view1.setLayoutManager(linearLayoutManager);

        AdapterBean adapterBean = new AdapterBean(category);

        view1.setAdapter(adapterBean);
        adapterBean.setOnclick(new AdapterBean.Onclick() {
            @Override
            public void onclick(int p) {
                String s = category.get(p);
                EventBus.getDefault().post(s);
            }
        });


        dao1Dao.deleteAll();
        String s1 = new Gson().toJson(Bean.class);
        Dao1 dao1 = new Dao1(s1);
        dao1Dao.insert(dao1);

        String s = category.get(0);
        mPresenter.getBeanRight(s);

    }

    @Override
    public void OnBeanError(Throwable throwable) {

    }

    @Override
    public void onBeanRight(BeanRight beanRight) {

        List<BeanRight.DataBean> data = beanRight.getData();
        view2.setLayoutManager(new GridLayoutManager(this,2));
        AdapterBeanRight adapterBeanRight = new AdapterBeanRight(data);
        view2.setAdapter(adapterBeanRight);

        dao2Dao.deleteAll();
        String s = new Gson().toJson(BeanRight.class);
        Dao2 dao2 = new Dao2(s);
        dao2Dao.insert(dao2);
    }

    @Override
    public void OnBeanRightError(Throwable throwable) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void ss(String name){
        mPresenter.getBeanRight(name);
    }

}
