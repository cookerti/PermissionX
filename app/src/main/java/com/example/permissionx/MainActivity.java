package com.example.permissionx;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.jdblib.InvisibleFragment;
import com.example.jdblib.PermissionX;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toMakeCall(View view) {
        PermissionX.request(this, new String[]{Manifest.permission.CALL_PHONE}, new InvisibleFragment.CallBack() {
            @Override
            public void afterRequest(boolean allGranted, List<String> deniedList) {
                if(allGranted){
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:10086"));
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getBaseContext(),"尚有权限未申请"+deniedList.get(0),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}