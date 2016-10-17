package com.shazeys.yinyuan.dagger;

import com.shazeys.yinyuan.entity.Man;
import com.shazeys.yinyuan.entity.People;
import com.shazeys.yinyuan.entity.Woman;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ShuaiZhang on 2016/9/29.
 */
@Module
public class PeopleModule {
    @Provides
    Woman getWoman(){
        return new Woman(8);//自由指定
    }

    @Provides
    Man getMan(){
        return new Man(8);//自由指定
    }

    @Provides @Named("nv")// 存在同样的两个People，就需要@Named来区分
    People getNv(){
        return new Woman();
    }

    @Provides @Named("nan")//同上
    People getNan(){
        return new Man();
    }
}
