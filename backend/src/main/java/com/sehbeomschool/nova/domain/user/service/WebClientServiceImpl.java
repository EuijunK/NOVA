package com.sehbeomschool.nova.domain.user.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebClientServiceImpl implements WebClientService {

    @Value("${kakao.client_id}")
    private String clientId;

    @Value("${kakao.url.token}")
    private String tokenUrl;

    @Value("${kakao.redirect}")
    private String redirectUrl;


    @Override
    public Map<String, Object> getKakaoUserInfo(String code) {
        WebClient webClient =
            WebClient
                .builder()
                .build();

        Map result = webClient
            .get()
            .uri(uriBuilder ->
                uriBuilder
                    .path(tokenUrl)
                    .queryParam("code", code)
                    .queryParam("grant_type", "authorization_code")
                    .queryParam("client_id", clientId)
                    .build())
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
            .retrieve()
            .bodyToMono(Map.class)
            .block();

        return result;
    }
}
