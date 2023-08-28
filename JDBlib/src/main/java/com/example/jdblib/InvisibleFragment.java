package com.example.jdblib;

import android.content.pm.PackageManager;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class InvisibleFragment extends Fragment {
    private CallBack callBack;
    public void requestNow(String [] Permissions,CallBack cb){
        callBack = cb;
        requestPermissions(Permissions,1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1){
            List<String> deniedList = new ArrayList<>();
            for(int i = 0;i < grantResults.length;++i){
                if(PackageManager.PERMISSION_GRANTED != grantResults[i]){
                    deniedList.add(permissions[i]);
                }
            }

            boolean allGranted = deniedList.isEmpty();
            callBack.afterRequest(allGranted,deniedList);
        }
    }

    public interface CallBack {
        public void afterRequest(boolean allGranted, List<String> deniedList);
    }
}
