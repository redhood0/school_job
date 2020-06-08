package com.team2.smartcampus.execption;

/**
 * @PackgeName: com.team2.smartcampus.execption
 * @ClassName: ServiceException
 * @Author: redhood
 * Date: 2020/6/4 17:35
 * project name: smart-campus
 * @Version:
 * @Description:
 */
public class ServiceException extends RuntimeException{
    public ServiceException(String message) {
        super(message);
    }
}
