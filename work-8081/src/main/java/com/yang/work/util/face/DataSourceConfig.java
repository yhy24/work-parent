package com.yang.work.util.face;

import com.alibaba.druid.pool.DruidDataSource;

public class DataSourceConfig extends DruidDataSource {
    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public void setUsername(String username) {
        String s123 =  username + "123";
        super.setUsername(s123);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }
}
