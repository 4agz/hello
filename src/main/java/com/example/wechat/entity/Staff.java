package com.example.wechat.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = "staff")
public class Staff{
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name = "userid")
    private Integer userid;

    @Column(name = "name")
    private String name;

    @Column(name = "telephone")
    private String telephone;
    @Column(name = "up_id")
    private Integer up_id;

    @Column(name = "wechat")
    private String wechat;
    @Column(name = "job")
    private String job;

    //多对多关系映射	@ManyToMany	@JoinTable(name="user_role_rel",//中间表的名称
    // 中间表user_role_rel字段关联sys_role表的主键字段role_id
    //
    // joinColumns={@JoinColumn(name="role_id",referencedColumnName="role_id")},
    // 中间表user_role_rel的字段关联sys_user表的主键user_id
    // inverseJoinColumns={@JoinColumn(name="user_id",referencedColumnName="user_id")}	)

    //多对多映射关系
   /* @ManyToMany(targetEntity = Department.class)
    @JoinTable(name = "dept_stf",
            // joinColumns ,当前对象在中间表的外键
            joinColumns={@JoinColumn(name = "staff_userid",referencedColumnName = "userid")},
            //inverseJoinColumns对方对象在中间表的外键名称
            inverseJoinColumns={@JoinColumn(name = "dept_id",referencedColumnName = "id")}
    )*/
   @ManyToMany(mappedBy="staff")
    private Set<Department> departments=new HashSet<Department>();

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getUp_id() {
        return up_id;
    }

    public void setUp_id(Integer up_id) {
        this.up_id = up_id;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", up_id=" + up_id +
                ", wechat='" + wechat + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
