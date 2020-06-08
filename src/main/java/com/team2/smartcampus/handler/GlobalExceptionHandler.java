package com.team2.smartcampus.handler;


import com.team2.smartcampus.common.ResponseResult;
import com.team2.smartcampus.common.ResultCode;
import com.team2.smartcampus.execption.BuildingException;
import com.team2.smartcampus.execption.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/6/1 4:00 下午
 * @Version 1.0
 **/
@RestControllerAdvice(annotations = {RestController.class, Controller.class})
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 自定义异常的处理，统一在这里捕获返回JSON格式的友好提示
     *
     * @param exception
     * @return ResponseResult
     */
//    @ExceptionHandler(value = {JwtException.class})
//    @ResponseBody
//    public ResponseResult sendError(JwtException exception) {
//        log.error(exception.getMessage());
//        return ResponseResult.failure(exception.getResultCode());
//    }

    /**
     * 自定义异常的处理，统一在这里捕获返回JSON格式的友好提示
     *
     * @param exception
     * @return ResponseResult
     */
//    @ExceptionHandler(value = {CustomException.class})
//    @ResponseBody
//    public ResponseResult sendError(CustomException exception) {
//        log.error(exception.getMessage());
//        return ResponseResult.failure(exception.getResultCode());
//    }

    /**
     * InvalidClaimException异常的处理
     *
     * @param exception
     * @return ResponseResult
     */
//    @ExceptionHandler(value = {InvalidClaimException.class})
//    @ResponseBody
//    public ResponseResult sendError(InvalidClaimException exception) {
//        log.error(exception.getMessage());
//        return ResponseResult.failure(ResultCode.USER_TOKEN_EXPIRES);
//    }


    /**
     * NPE异常的处理
     *
     * @param exception
     * @return ResponseResult
     */
//    @ExceptionHandler(value = {NullPointerException.class})
//    @ResponseBody
//    public ResponseResult sendError(NullPointerException exception) {
//        log.error(exception.getMessage());
//        return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
//    }

    /**
     * IO异常的处理
     *
     * @param exception
     * @return ResponseResult
     */
//    @ExceptionHandler(value = {IOException.class})
//    @ResponseBody
//    public ResponseResult sendError(IOException exception) {
//        log.error(exception.getMessage());
//        return ResponseResult.failure(ResultCode.CAPTCHA_ERROR);
//    }

    /**
     * 参数认证处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String filedName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(filedName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }


    //    @ExceptionHandler(NullPointerException.class)
//    ResponseEntity<String> handleConstraintViolationException(NullPointerException e) {
//        System.out.println("===============================>>>>>>>>>>");
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//    }
    @ExceptionHandler(value = {BuildingException.class})
    @ResponseBody
    public ResponseResult sendError(BuildingException exception) {
        return ResponseResult.failure(ResultCode.SYSTEM_INNER_ERROR, exception.getMessage());
    }

    @ExceptionHandler(value = {ServiceException.class})
    @ResponseBody
    public ResponseResult sendError(ServiceException exception) {
        return ResponseResult.failure(ResultCode.SYSTEM_INNER_ERROR, exception.getMessage());
    }
}