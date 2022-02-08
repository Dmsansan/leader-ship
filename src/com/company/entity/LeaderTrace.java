package com.company.entity;

import java.util.Date;

/**
 * @author: sansan.si
 * @vesion 1.0
 * @date: 2022-02-08 19:53
 * @description: 移动轨迹实体类
 **/
public class LeaderTrace {
    private int id;
    /**
     * 领导id
     */
    private int leaderId;
    /**
     * 目的地
     */
    private String destPlace;
    /**
     * 到达时间
     */
    private Date arriveTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }

    public String getDestPlace() {
        return destPlace;
    }

    public void setDestPlace(String destPlace) {
        this.destPlace = destPlace;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    @Override
    public String toString() {
        return "LeaderTrace{" +
                "id=" + id +
                ", leaderId=" + leaderId +
                ", destPlace='" + destPlace + '\'' +
                ", arriveTime=" + arriveTime +
                '}';
    }
}
