package com.lq.common.core.domain;


import com.lq.common.constant.HttpStatus;

import java.util.HashMap;

/**
 * 操作消息提醒
 * 
 * @author ruoyi
 */
public class ResponseEntity extends HashMap<String, Object>
{
    private static final long serialVersionUID = 1L;

    /** 状态码 */
    public static final String CODE_TAG = "code";

    /** 返回内容 */
    public static final String MSG_TAG = "msg";

    /** 数据对象 */
    public static final String DATA_TAG = "data";

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public ResponseEntity()
    {
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg 返回内容
     */
    public ResponseEntity(int code, String msg)
    {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg 返回内容
     * @param data 数据对象
     */
    public ResponseEntity(int code, String msg, Object data)
    {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
//        if (StringUtils.isNotNull(data))
        if (data!=null)
        {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     * 
     * @return 成功消息
     */
    public static ResponseEntity success()
    {
        return ResponseEntity.success("操作成功");
    }

    /**
     * 返回成功数据
     * 
     * @return 成功消息
     */
    public static ResponseEntity success(Object data)
    {
        return ResponseEntity.success("操作成功", data);
    }

    /**
     * 返回成功消息
     * 
     * @param msg 返回内容
     * @return 成功消息
     */
    public static ResponseEntity success(String msg)
    {
        return ResponseEntity.success(msg, null);
    }

    /**
     * 返回成功消息
     * 
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static ResponseEntity success(String msg, Object data)
    {
        return new ResponseEntity(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 返回错误消息
     * 
     * @return
     */
    public static ResponseEntity error()
    {
        return ResponseEntity.error("操作失败");
    }

    /**
     * 返回错误消息
     * 
     * @param msg 返回内容
     * @return 警告消息
     */
    public static ResponseEntity error(String msg)
    {
        return ResponseEntity.error(msg, null);
    }

    /**
     * 返回错误消息
     * 
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static ResponseEntity error(String msg, Object data)
    {
        return new ResponseEntity(HttpStatus.ERROR, msg, data);
    }

    /**
     * 返回错误消息
     * 
     * @param code 状态码
     * @param msg 返回内容
     * @return 警告消息
     */
    public static ResponseEntity error(int code, String msg)
    {
        return new ResponseEntity(code, msg, null);
    }
}
