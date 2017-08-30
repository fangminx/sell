package com.fangminx.vo;

import lombok.Data;

/**
 * http请求返回的最外层对象
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;
}
