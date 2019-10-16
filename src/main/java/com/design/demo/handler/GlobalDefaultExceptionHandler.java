package com.design.demo.handler;


import com.design.demo.bean.ResponseCode;
import com.design.demo.exception.Result;
import lombok.extern.log4j.Log4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 *
 */
@ControllerAdvice(basePackages = {"com.design.demo"})
@Log4j
public class GlobalDefaultExceptionHandler {

    //也可以自定义一个异常类,然后写在这里

    /**
     * DataIntegrityViolationException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    @ResponseBody
    public Result requestExceptionHandler(DataIntegrityViolationException e) {
        return new Result().error(ResponseCode.FAIL.code, "数据格式操作异常");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        String s = "参数验证失败";
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            s = errors.get(0).getDefaultMessage();
        }
        return new Result().error(ResponseCode.FAIL.code, s);
    }

    /**
     * 全局exception
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result requestExceptionHandler(Exception e) {
        e.printStackTrace();
        return new Result().error(ResponseCode.FAIL.code, "服务器飘了，管理员去拿刀修理了~");
    }


}
