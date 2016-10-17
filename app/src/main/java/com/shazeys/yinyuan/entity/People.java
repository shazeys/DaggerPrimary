package com.shazeys.yinyuan.entity;

/**
 * Created by ShuaiZhang on 2016/9/29.
 */

public class People {
    private int ratio;//计算比例

    public People(int ratio) {
        this.ratio = ratio;
    }

    public int getScore(String name){
        return name.hashCode()*ratio/10;
    }
}
