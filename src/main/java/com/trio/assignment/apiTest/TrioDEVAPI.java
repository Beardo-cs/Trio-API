package com.trio.assignment.apiTest;

import com.trio.assignment.apiTest.pojos.*;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public interface TrioDEVAPI {

    @POST
    @Path("auth/login")
    LoginResponse login(LoginRequest loginRequest);

    @POST
    @Path("device/enrollment-android")
    EnrollResponse enrollAndroid(EnrollRequest enrollRequest);

    @POST
    @Path("agent/auth/login")
    AgentResponse agentLogin(AgentRequest AgentRequest);


}
