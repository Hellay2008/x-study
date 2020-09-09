package com.example.dp.prototype;

import java.io.Serializable;

public class Department implements Serializable {
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
