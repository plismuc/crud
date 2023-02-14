package com.example.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="t_company")
public class Company {
    @Id
    private Integer id;//
    private String short_name;//公司名称

    //@Column()   默认情况 实体类和数据库是一致的,如果不一致 就用
    private String full_name;//公司全称

    @Column(name = "is_famous")
    private Integer isfamous;//是否名企：0.不是  1.是
    private Integer state;//状态：  0.启用      1.禁用
    private String remark;// 备注
    @Column(name = "create_date")
    private Date createdate;//

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Company(){}
    public Company(Integer id, String short_name, String full_name, Integer is_famous, Integer state, String remark, Date createdate) {
        this.id = id;
        this.short_name = short_name;
        this.full_name = full_name;
        this.isfamous = is_famous;
        this.state = state;
        this.remark = remark;
        this.createdate = createdate;
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
        return isfamous;
    }

    public void setIs_famous(Integer is_famous) {
        this.isfamous = is_famous;
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


    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", short_name='" + short_name + '\'' +
                ", full_name='" + full_name + '\'' +
                ", is_famous=" + isfamous +
                ", state=" + state +
                ", remark='" + remark + '\'' +
                ", create_date=" + createdate +
                '}';
    }
}
