package com.example.remoteandroidclient;

import android.app.Application;
import android.content.res.Configuration;

import androidx.annotation.NonNull;
public class MyApplication extends Application {
//    在Application创建的时候调用，一般用于初始化一些东西，如全局的对象，环境的配置等。
    @Override
    public void onCreate() {
        super.onCreate();
    }
//    写此方法可以监听APP-些配置信息的改变事件(如屏幕旋转等)，当配置信息改变
//    的时候会调用这个方法。在Manifest文件 下的Activity标签(注意是Activity) 里配置
//    android:configChanges属性相应的配置属性，会使Activity在配置改变时候不会重启，只
//    会执行onConfigurationChanged(方法。如:android:configChanges=' "keyboardHiddenlorientation|screenSize'
//    属性可以使Activity旋转时不重启。
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

//    重写此方法可以监听Android系统整体内存较低时候的事件。按我的理解就是，当APP处
//    于前台时，但是所有后台程序都被kill光了，但是还是内存不足时，系统就会调用这个方
//    法告诉APP，兄弟轮到你了。我们可以在这个方法里面释放一些不重要的资源，来保证
//    到时候内存足够而让APP进程不被系统杀掉，或者提醒用户清一下垃圾， 让内存清一点
//    空位出来，我的手机老是这样提示我，不知道是不是这个方法惹的祸。
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
//    这个方法在程序结束的时候会调用。但是这个方法只用于Android仿真机测试的时候，
//    在Android产品机是不会调用的。所以这个方法并没什么用。
    @Override
    public void onTerminate() {
        super.onTerminate();
    }
//    这两个方法用于注册或者注销对APP内所有Activity的生命周期监听，
//    当APP内Activity的生命周期发生变化的时候就会调用ActivityLifecycleCallbacks里面的方法
    @Override
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.registerActivityLifecycleCallbacks(callback);
    }

    @Override
    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.unregisterActivityLifecycleCallbacks(callback);
    }
}
