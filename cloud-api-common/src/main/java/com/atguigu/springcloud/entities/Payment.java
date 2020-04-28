package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年04月28日
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Payment implements Serializable {

    private static final long serialVersionUID = -6831755378087556480L;

    private Long id;//支付信息ID

    private String serial;//支付流水号

}
