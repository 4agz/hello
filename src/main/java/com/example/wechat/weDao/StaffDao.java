package com.example.wechat.weDao;

import com.example.wechat.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StaffDao extends JpaRepository<Staff,Integer>, JpaSpecificationExecutor<StaffDao> {
}
