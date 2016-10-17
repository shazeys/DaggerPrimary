package com.shazeys.yinyuan.dagger;

import com.shazeys.yinyuan.MainActivity;

import dagger.Component;

/**
 * Created by ShuaiZhang on 2016/9/29.
 */
@Component(modules = PeopleModule.class)//没错，我就是打包
public interface PeopleComponent {
    void inject(MainActivity m);
}
