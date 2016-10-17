package com.shazeys.yinyuan.entity;

/**
 * Created by ShuaiZhang on 2016/9/29.
 */

public class People {
    private int ratio;//计算比例

    public People(int ratio) {
        this.ratio = ratio;
    }

    //字符串对应的哈希值计算个人得分
    public int getScore(String name){
        return name.hashCode()*ratio/10;
    }
}
