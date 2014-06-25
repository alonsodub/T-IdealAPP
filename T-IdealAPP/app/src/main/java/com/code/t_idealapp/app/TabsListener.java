package com.code.t_idealapp.app;

import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBar.Tab;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

public class TabsListener <T extends Fragment> implements TabListener{
    private Fragment mFragment;
    private final Activity mActivity;
    private final String mTag;
    private final Class<T> mClass;

    public TabsListener(Activity activity,String tag,Class<T>cls) {
        this.mTag=tag;
        this.mActivity = activity;
        this.mClass = cls;
    }

    @Override
    public void onTabSelected(Tab tab,FragmentTransaction fragmentTransaction) {
        if(mFragment == null) {
            mFragment = Fragment.instantiate(mActivity, mClass.getName());
            fragmentTransaction.add(android.R.id.content, mFragment, mTag);
        }else { fragmentTransaction.attach(mFragment);}
        }
    @Override
    public void onTabUnselected(Tab tab,FragmentTransaction fragmentTransaction) {
        if(mFragment !=null)
            fragmentTransaction.detach(mFragment);
    }
    @Override
    public void onTabReselected(Tab tab,FragmentTransaction fragmentTransaction) {

    }
}
