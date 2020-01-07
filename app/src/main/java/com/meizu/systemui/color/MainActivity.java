package com.meizu.systemui.color;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private boolean mCurrentStatusBarLight;
    private boolean mCurrentStatusBarIconLight;
    private boolean mCurrentNavigationBarLight;
    private boolean mCurrentNavigationBarIconLight;

    private Window mWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWindow = getWindow();
        mWindow.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        mWindow.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        mWindow.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        mWindow.setStatusBarColor(mCurrentStatusBarLight ? Color.WHITE : Color.BLACK);
        mWindow.setNavigationBarColor(mCurrentNavigationBarLight ? Color.WHITE : Color.BLACK);
    }

    public void clickChangeStatusBarColor(View view) {
        mCurrentStatusBarLight = !mCurrentStatusBarLight;
        mWindow.setStatusBarColor(mCurrentStatusBarLight ? Color.WHITE : Color.BLACK);
    }

    public void clickChangeStatusBarIconColor(View view) {
        mCurrentStatusBarIconLight = !mCurrentStatusBarIconLight;
        setLightStatusBar(mCurrentStatusBarIconLight);
    }

    public void clickChangeNavigationBarColor(View view) {
        mCurrentNavigationBarLight = !mCurrentNavigationBarLight;
        mWindow.setNavigationBarColor(mCurrentNavigationBarLight ? Color.WHITE : Color.BLACK);
    }

    public void clickChangeNavigationBarIconColor(View view) {
        mCurrentNavigationBarIconLight = !mCurrentNavigationBarIconLight;
        setLightNavigationBar(mCurrentNavigationBarIconLight);
    }

    /**
     * 修改NavigationBar按键颜色 两色可选【黑，白】
     */
    private void setLightNavigationBar(boolean light) {
        int vis = getWindow().getDecorView().getSystemUiVisibility();
        if (light) {
            vis |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;//黑色
        } else {
            vis &= ~View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;//白色
        }
        getWindow().getDecorView().setSystemUiVisibility(vis);
    }

    /**
     * 修改StatusBar按键颜色 两色可选【黑，白】
     */
    private void setLightStatusBar(boolean light) {
        int vis = getWindow().getDecorView().getSystemUiVisibility();
        if (light) {
            vis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;// 黑色
        } else {
            vis &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;//白色
        }
        getWindow().getDecorView().setSystemUiVisibility(vis);
    }
}
