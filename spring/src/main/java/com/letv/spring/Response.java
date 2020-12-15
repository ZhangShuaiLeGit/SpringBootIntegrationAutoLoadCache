package com.letv.spring;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

/**
 * 单数据响应类
 * @param <T>
 */
//@XmlRootElement
public class Response<T> {

    /**
     * 数据
     */
    private T data;

    /**
     * 补充数据
     */
    private Map<String, Object> plus;

    public Response() {
    }

    public Response(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<String, Object> getPlus() {
        return plus;
    }

    public void setPlus(Map<String, Object> plus) {
        this.plus = plus;
    }
}
