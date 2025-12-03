package com.smproject.sm_chat.dto;

import lombok.Builder;
import org.json.JSONArray;
import org.json.JSONObject;

@Builder
public record AuthDTO(
    String name,
    String username,
    String department,
    String email,
    int year,
    int semester
) {

  public static AuthDTO from(JSONArray json) {
    return from(json.getJSONObject(0));
  }

  public static AuthDTO from(JSONObject obj) {
    return AuthDTO.builder()
        .name(obj.getString("NM_KOR"))
        .username(obj.getString("STDNO"))
        .department(getDepartment(obj.getString("TMP_DEPT_MJR_NM")))
        .email(obj.getString("EMAIL"))
        .year(obj.getInt("SHYR"))
        .semester(obj.getInt("CMP_SMT"))
        .build();
  }

  public static String getDepartment(String dept) {
    String[] depts = dept.split(" ");
    return depts[depts.length - 1];
  }
}
