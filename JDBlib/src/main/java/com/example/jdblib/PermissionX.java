package com.example.jdblib;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class PermissionX {
    public final static String TAG = "InvisibleFragment";

    public static void request(FragmentActivity activity, String []Permissions, InvisibleFragment.CallBack callBack){
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        InvisibleFragment invisibleFragment = null;
        Fragment existedFragment = fragmentManager.findFragmentByTag(TAG);
        if(existedFragment != null){
            invisibleFragment = (InvisibleFragment)existedFragment;
        }
        else{
            invisibleFragment = new InvisibleFragment();
            //使用commitNow,使其立刻加入,使得后一句能够正常使用
            fragmentManager.beginTransaction().add(invisibleFragment,TAG).commitNow();
        }
        invisibleFragment.requestNow(Permissions,callBack);
    }
}
