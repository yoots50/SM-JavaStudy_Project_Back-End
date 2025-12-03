package com.smproject.sm_chat.service;

import com.smproject.sm_chat.dto.UserDTO;
import com.smproject.sm_chat.global.CustomException;
import com.smproject.sm_chat.global.ErrorCode;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class UserService {
    private final String LOGIN_URL = "https://smsso.smu.ac.kr/Login.do";
    private final String BASE_URL = "https://smul.smu.ac.kr";

    public Map<String, String> login(UserDTO request) {
        Map<String, String> map = new HashMap<>();
        try {
            Connection.Response response = Jsoup.connect(LOGIN_URL)
                .data("user_id", request.getId())
                .data("user_password", request.getPw())
                .method(Connection.Method.POST)
                .execute();
            if (response.url().toString().equals(LOGIN_URL)) {
                throw new CustomException(ErrorCode.LOGIN_FAILED);
            }
            return Jsoup.connect(BASE_URL.concat("/index.do"))
                .method(Connection.Method.GET)
                .cookies(response.cookies())
                .execute()
                .cookies();
        } catch (IOException e) {
            throw new CustomException(ErrorCode.SERVER_ERROR);
        }
    }

    public JSONObject getData(UserDTO request, String url) {
        Map<String, String> session = login(request);
        try {
            URL apiUrl = new URL(BASE_URL.concat(url));
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("POST");
            for (Map.Entry<String, String> cookie : session.entrySet())
                connection.addRequestProperty("Cookie", cookie.getKey() + "=" + cookie.getValue());
            String requestData = "@d#=@d1#&@d1#tp=dm&_AUTH_MENU_KEY=usrCPsnlInfoUpd-STD&@d1#strStdNo=".concat(request.getId());
            connection.setDoOutput(true);
            connection.getOutputStream().write(requestData.getBytes());

            StringBuilder response = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null)
                    response.append(line);
            }
            return new JSONObject(response.toString());
        } catch (IOException e) {
            throw new CustomException(ErrorCode.SERVER_ERROR);
        }
    }
}
