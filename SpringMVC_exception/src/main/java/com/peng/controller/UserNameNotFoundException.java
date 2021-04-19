package com.peng.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 16370
 * @create 2021-04-07 下午 11:07
 */
@ResponseStatus(reason = "用户名错误",value = HttpStatus.NOT_ACCEPTABLE)
public class UserNameNotFoundException extends RuntimeException{



}
