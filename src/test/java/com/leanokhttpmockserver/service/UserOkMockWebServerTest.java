package com.leanokhttpmockserver.service;

import com.leanokhttpmockserver.domain.User;
import com.leanokhttpmockserver.domain.User;
import com.leanokhttpmockserver.helper.TestHelper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class UserOkMockWebServerTest {

    @Rule
    public final MockWebServer server = new MockWebServer();
    private UserService userService;
    WebClient webClient;

    @Before
    public void setUp() {

        final String baseUrl = String.format("http://localhost:%s", server.getPort());
        webClient = WebClient.create();
        userService = new UserService(baseUrl, webClient);
    }

    @Test
    public void getUsers() throws IOException {

        //given
        server.enqueue(new MockResponse().setBody(TestHelper.readFromPath("user_response.json"))
        .addHeader("Content-Type", "application/json"));

        //when
        String name="dilip";
        User user = userService.getUserByName(name);

        String expectedName="dilip";
        //then
        assertEquals(name, user.getName());
        assertEquals(32, user.getAge().intValue());

    }

}
