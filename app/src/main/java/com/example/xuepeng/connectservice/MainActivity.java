package com.example.xuepeng.connectservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

     private EditText etData;
     private MyService.Binder binder=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        etData = findViewById(R.id.etData);
        findViewById(R.id.btnStartService).setOnClickListener(this);
        findViewById(R.id.btnStopService).setOnClickListener(this);
        findViewById(R.id.btnBindService).setOnClickListener(this);
        findViewById(R.id.btnUnbindService).setOnClickListener(this);
        findViewById(R.id.btnSyrcData).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnStartService:
                Intent i =new Intent(this,MyService.class);
                i.putExtra("data",etData.getText().toString());
                startService(i);
                break;
            case R.id.btnStopService:
                stopService(new Intent(this,MyService.class));
                break;
            case R.id.btnBindService:
                bindService(new Intent(this,MyService.class),this,Context.BIND_AUTO_CREATE);
                break;
            case R.id.btnUnbindService:
                unbindService(this);
                break;
            case R.id.btnSyrcData:
                if(binder!=null){
                    binder.setData(etData.getText().toString());
                }


        }


    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        binder= (MyService.Binder) iBinder;

    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }
}
