package org.vrlab.chemistrydatabase.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Result<T> implements Serializable {
    private static final Result EMPTY_SUCCESS_RESULT = Result.success();
    private boolean success;
    private int status;
    private String message;
    private T data;

    public static <T> Result<T> success() {
        return EMPTY_SUCCESS_RESULT;
    }

    public static <T> Result<T> success(T object, String message) {
        ResultBuilder<T> resultBuilder = new ResultBuilder<T>();
        return resultBuilder
                .data(object)
                .status(200)
                .message(message)
                .success(true).build();
    }

    public static Result failure(ResultStatus resultStatus) {
        return Result.builder()
                .success(false)
                .status(resultStatus.getCode())
                .message(resultStatus.getMessage()).build();
    }
}
