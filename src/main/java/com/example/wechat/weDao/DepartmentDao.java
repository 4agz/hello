package com.example.wechat.weDao;

import com.example.wechat.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DepartmentDao extends JpaRepository<Department,Integer>, JpaSpecificationExecutor<Department> {

}
