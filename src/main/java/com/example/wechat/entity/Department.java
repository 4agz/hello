package com.example.wechat.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = "dept")
public class Department{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "parentid")
    private Integer parentid;
    @Column(name = "order_s")
    private String order_s;

    //多对多映射
    @ManyToMany(targetEntity = Staff.class)
    @JoinTable(name = "dept_stf",
           // joinColumns ,当前对象在中间表的外键
            joinColumns={@JoinColumn(name = "dept_id",referencedColumnName = "id")},
            //inverseJoinColumns对方对象在中间表的外键你
            inverseJoinColumns={@JoinColumn(name = "staff_userid",referencedColumnName = "userid")}
    )
    private Set<Staff> staff=new HashSet<Staff>();

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentid=" + parentid +
                ", order='" + order_s + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getOrder() {
        return order_s;
    }

    public void setOrder(String order) {
        this.order_s = order;
    }

    public Set<Staff> getStaff() {
        return staff;
    }

    public void setStaff(Set<Staff> staff) {
        this.staff = staff;
    }
}
