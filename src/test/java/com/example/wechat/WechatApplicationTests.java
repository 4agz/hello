package com.example.wechat;

import com.example.wechat.entity.Department;
import com.example.wechat.entity.Staff;
import com.example.wechat.weDao.DepartmentDao;
import com.example.wechat.weDao.StaffDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatApplicationTests {


    @Test
    public void contextLoads() {
    }

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private StaffDao staffDao;

    @Test
    @Transactional
    @Rollback(false)
    public void test1(){
        //创建对象
        Department d1=new Department();
        d1.setName("部门3");
        Staff s1=new Staff();
        s1.setName("员工3");

        //建立连接关系
        d1.getStaff().add(s1);
        s1.getDepartments().add(d1);
        departmentDao.save(d1);
        staffDao.save(s1);
    }
}
