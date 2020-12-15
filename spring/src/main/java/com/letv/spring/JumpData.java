package com.letv.spring;

import java.io.Serializable;

/**
 * 数据基类
 */
public class JumpData<T, E> {

    /**
     *
     */
    private static final long serialVersionUID = 8804619215619988910L;

    /**
     * 跳转类型
     */
    private Integer type;

    /**
     * 跳转信息体
     */
    private T Value;

    /**
     * 扩展对象，承接action
     */
    private E extend;

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public T getValue() {
        return this.Value;
    }

    public void setValue(T value) {
        this.Value = value;
    }

    public E getExtend() {
        return extend;
    }

    public void setExtend(E extend) {
        this.extend = extend;
    }
}
