package com.company.entity;

/**
 * @author: sansan.si
 * @vesion 1.0
 * @date: 2022-02-08 20:36
 * @description: 目的枚举类
 **/
public enum DestPlaceEnum {
    CESUO("厕所", "cesuo"),
    TENFLOOR("10楼门口", "tenfloor"),
    TEAWATER("茶水间", "teawater"),
    FOURMEET("第四会议室", "fourmeet"),
    ZHICHAN("知产部", "zhichan"),
    SHENCHAN("生产车间", "shenchan"),
    CAIGOU("采购部", "caigou"),
    CHANPIN("产品部", "chanpin"),
    RUANJIAN("软件研发部", "ruanjian"),
    AI("AI雷达研究部", "ai");

    // 成员变量
    private String destName;
    private String destCode;

    // 构造方法
    private DestPlaceEnum(String destName, String destCode) {
        this.destName = destName;
        this.destCode = destCode;
    }

    // 普通方法
    public static String getName(String destCode) {
        for (DestPlaceEnum d : DestPlaceEnum.values()) {
            if (destCode.equals(d.getDestCode())) {
                return d.destName;
            }
        }
        return null;
    }

    // get set 方法

    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName = destName;
    }

    public String getDestCode() {
        return destCode;
    }

    public void setDestCode(String destCode) {
        this.destCode = destCode;
    }
}
