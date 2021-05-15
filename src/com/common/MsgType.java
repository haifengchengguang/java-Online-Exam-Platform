package com.common;

/**
 * 定义通信涉及到的全部消息类型
 */
public enum MsgType {
    LOGIN_SUCCEED,//登录成功
    LOGIN_FAILED,//登录失败
    REGISTER_SUCCEED,//注册成功
    REGISTER_FAILED,//注册失败
    ALREADY_REGIST,
    ALREADY_LOGIN,//已登录
    UNLOAD_LOGIN,//退出登录
    NOT_ONLINE,//不在线
    SERVER_CLOSE,//服务器关闭
    COMMON_MESSAGE,//普通信息
    ADD_TEST,//修改题目
    FIND_TEST,//找题
    TEST_SERVERTOCLIENT,
    DEL_TEST,
    UPDATE_TEST,
    GET_EXAMPAPER
}
