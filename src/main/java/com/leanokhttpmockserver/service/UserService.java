package com.leanokhttpmockserver.service;

import com.leanokhttpmockserver.domain.User;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import static com.leanokhttpmockserver.constants.OkHttpMockWebServerConstants.*;


public class UserService {
    private String url = "http://some/uri";
    private WebClient webClient;

    public UserService(String _url, WebClient _webClient) {
        this.url = _url;
        this.webClient = _webClient;
    }

    public UserService(WebClient _webClient) {
        this.webClient = _webClient;
    }


    public User getUserByName(String name) {

        String uri = UriComponentsBuilder.fromUriString(url+USER_URL)
                .queryParam("name",name)
                .buildAndExpand()
                .toUri().toString();
        System.out.println("uri : " + uri);
        WebClient.RequestHeadersUriSpec requestHeadersUriSpec = webClient.get();
        User user = requestHeadersUriSpec.uri(uri)
                .retrieve()
                .bodyToMono(User.class)
                .block();

        return webClient.get().uri(uri)
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }
}
