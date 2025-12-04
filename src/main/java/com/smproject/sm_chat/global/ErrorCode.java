package com.smproject.sm_chat.global;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  // 가장 일반적인 응답
  SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "SERVER_ERROR", "서버에서 에러가 발생하였습니다. 나중에 다시 시도해주세요."),
  LOGIN_FAILED(HttpStatus.UNAUTHORIZED, "LOGIN_FAILED", "학번 및 비밀번호가 일치하지 않습니다.");

  private final HttpStatus httpStatus;
  private final String errorCode;
  private final String errorMessage;


}
