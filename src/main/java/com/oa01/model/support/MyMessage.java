package com.oa01.model.support;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//封装返回的内容
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyMessage {
    private Integer code=200;//http状态码
    private String msg="返回的消息";//
    private Boolean success=false;//是否操作成功
    private Object obj=null;//返回的对象


}
