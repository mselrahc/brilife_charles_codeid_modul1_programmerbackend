package com.brilife.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.LocalDateTime;

public class ResponseMessage<T> {
  private Integer code;
  private String message;
  private T data;

  @JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss.SSS")
  private LocalDateTime timestamp;

  public ResponseMessage(Integer code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
    this.timestamp = LocalDateTime.now();
  }

  public Integer getCode() {
    return this.code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return this.data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public static <T> ResponseMessage<T> ok(T data) {
    return new ResponseMessage<>(0, null, data);
  }

  public static <T> ResponseMessage<T> error(Integer code, String message) {
    return error(code, message, null);
  }

  public static <T> ResponseMessage<T> error(
    Integer code,
    String message,
    T data
  ) {
    return new ResponseMessage<>(code, message, data);
  }
}
