package com.trio.assignment.apiTest.impl;

import com.qapitol.sauron.common.configuration.Config;
import com.trio.assignment.apiTest.TrioDEVAPI;
import com.trio.assignment.apiTest.pojos.LoginRequest;
import com.trio.assignment.apiTest.pojos.LoginResponse;
import com.qapitol.sauron.api.providers.LoginService;
import com.qapitol.sauron.logging.SauronLogger;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;

import java.util.Map;

public class LoginServiceImpl implements LoginService {

    public static final String Email = "email";

    public static final String Password = "password";

    @Override
    public Map<String, String> login() {
        JAXRSClientFactoryBean bean = getJaxRsClientFactoryBean();
        bean.setResourceClass(TrioDEVAPI.class);
        TrioDEVAPI loginApi = bean.create(TrioDEVAPI.class);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(Config.getConfigProperty(Email));
        loginRequest.setPassword(Config.getConfigProperty(Password));
        LoginResponse loginResponse = loginApi.login(loginRequest);
        SauronLogger.getLogger().info("Login called");
        return Map.of("Authorization","Bearer " + loginResponse.getAccessToken() );
    }
}
