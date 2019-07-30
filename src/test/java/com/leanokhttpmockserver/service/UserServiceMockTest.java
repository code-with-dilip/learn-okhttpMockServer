package com.leanokhttpmockserver.service;

import com.leanokhttpmockserver.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceMockTest {

    private WebClient.Builder webClientBuilder = mock(WebClient.Builder.class);
    private WebClient webClient = mock(WebClient.class);

    UserService userService;
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec = mock(WebClient.RequestHeadersUriSpec.class);
    private WebClient.RequestHeadersSpec requestHeadersSpec = mock(WebClient.RequestHeadersSpec.class);
    private WebClient.ResponseSpec responseSpec = mock(WebClient.ResponseSpec.class);


    @Before
    public void setUp(){

        userService = new UserService(webClient);
    }

    @Test
    public void getUserByName(){

        //given
        String name = "Adam";
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(User.class)).thenReturn(Mono.just(new User(100, "Adam", 32,"Sdafdf")));

        //when
        User user = userService.getUserByName(name);

        //then
        assertEquals(32, user.getAge().intValue());

    }

}
