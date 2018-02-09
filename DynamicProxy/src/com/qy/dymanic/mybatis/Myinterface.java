package com.qy.dymanic.mybatis;

import java.util.List;

/**
 * 被代理接口
 */
public interface Myinterface {
    public List<Object> queryList();
    public String getName();
}
