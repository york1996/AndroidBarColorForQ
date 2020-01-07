# Android 沉浸式状态栏

> 本篇文档已在 Android Q 原生机型下验证，各项目在已有的代码中增加未适配部分即可快速完成适配。目前 Flyme 大多数内部应用缺失导航栏图标颜色变色逻辑，检查并补充该块逻辑即可。

## 状态栏

### 设置状态栏颜色

```java
getWindow().setStatusBarColor(mColor);
```

### 设置状态栏图标颜色（API 23）

```java
//light为true即设置图标为黑色，因为状态栏为light则只有黑色的icon才能看清，下同
private void setLightStatusBarIconColor(boolean light) {
    int vis = getWindow().getDecorView().getSystemUiVisibility();
    if (light) {
        vis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;// 黑色
    } else {
        vis &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;//白色
    }
    getWindow().getDecorView().setSystemUiVisibility(vis);
}
```



## 导航栏

### 设置导航栏颜色

```java
getWindow().setNavigationBarColor(mColor);
```

### 设置导航栏图标颜色（API 26）

```java
private void setLightNavigationBarIconColor(boolean light) {
    int vis = getWindow().getDecorView().getSystemUiVisibility();
    if (light) {
        vis |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;//黑色
    } else {
        vis &= ~View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;//白色
    }
    getWindow().getDecorView().setSystemUiVisibility(vis);
}
```



关于控制状态栏与导航栏的显示与隐藏，请参考：https://developer.android.com/training/system-ui