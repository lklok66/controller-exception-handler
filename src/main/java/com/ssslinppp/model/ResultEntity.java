package com.ssslinppp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description：<br/>
 * User: liulin <br/>
 * Date: 2017/9/27 <br/>
 * Time: 17:59 <br/>
 * Email: liulin@cmss.chinamobile.com <br/>
 * To change this template use File | Settings | File Templates.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultEntity<T> {
    private boolean success = true;
    private String message;
    private T entity;

    public static <T> ResultEntity success(T entity) {
        return new ResultEntity(true, null, entity);
    }

    public static <T> ResultEntity fail(String message, T entity) {
        return new ResultEntity(false, message, entity);
    }

    public static <T> ResultEntity fail(String message) {
        return fail(message, null);
    }
}
