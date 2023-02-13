package com.example.pojo;

import java.util.Date;

public class Compang{
    private Integer id;

    private String short_name;

    private String full_name;//公司全称
    private Integer is_famous;//是否名企: 0.不是1. 是
    private Integer state;//状态: 0. 启用

    private String remark;// 备注
    private Date create_date;

    public Compang(Integer id, String short_name, String full_name, Integer is_famous, Integer state, String remark, Date create_date) {
        this.id = id;
        this.short_name = short_name;
        this.full_name = full_name;
        this.is_famous = is_famous;
        this.state = state;
        this.remark = remark;
        this.create_date = create_date;
    }

    public Compang() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Integer getIs_famous() {
        return is_famous;
    }

    public void setIs_famous(Integer is_famous) {
        this.is_famous = is_famous;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "Compang{" +
                "id=" + id +
                ", short_name='" + short_name + '\'' +
                ", full_name='" + full_name + '\'' +
                ", is_famous=" + is_famous +
                ", state=" + state +
                ", remark='" + remark + '\'' +
                ", create_date=" + create_date +
                '}';
    }
}
