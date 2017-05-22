package com.example.xuwei.looptest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;

import org.xutils.x;

/**
 * Created by xuwei on 17/5/22.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    //region 按钮点击事件

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_F2:
                if (action == KeyEvent.ACTION_DOWN) {
                    InputMethodManager m=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    m.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                }
                return true;
            //F1控制系统音量+，禁掉
            case KeyEvent.KEYCODE_VOLUME_UP:
                return true;
            //F3控制系统音量-，禁掉
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                return true;
            case KeyEvent.KEYCODE_CALL:
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }
}
