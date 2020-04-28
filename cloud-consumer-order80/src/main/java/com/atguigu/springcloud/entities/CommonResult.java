package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * todo 这个统一返回前端数据模型的类，应该放在一个公共的模块，因为微服务架构里面服务相关的模块都会使用到这个类
 *
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年04月28日
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }

}
