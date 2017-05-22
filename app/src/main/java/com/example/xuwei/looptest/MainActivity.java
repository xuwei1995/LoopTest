package com.example.xuwei.looptest;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class MainActivity extends BaseActivity {
    public static Handler mHandler   = new Handler(){
        @Override
        public void handleMessage(Message mesg) {
            super.handleMessage(mesg);
            throw new RuntimeException();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestParams params=new RequestParams("https://www.baidu.com");

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                Message m = mHandler.obtainMessage();
                mHandler.sendMessage(m);
            }
        });
     try {Looper.loop();}catch (Exception e) {

     }
        Toast.makeText(this,"1111",Toast.LENGTH_SHORT).show();
    }

}
