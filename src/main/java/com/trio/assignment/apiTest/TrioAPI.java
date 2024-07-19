package com.trio.assignment.apiTest;

import com.qapitol.sauron.api.client.ApiClientFactory;
import com.qapitol.sauron.common.configuration.Config;
import com.qapitol.sauron.report.core.annotations.ReportTestStep;
import com.trio.assignment.apiTest.pojos.*;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TrioAPI {
  public static final String Email = "email";

  public static final String Password = "password";

  public static String mttqPassword = "";

  public static String hardwareID = "";


  @ReportTestStep("Trio Login API Test and Validate the Access Token")
  public void LoginAPI() {
    TrioDEVAPI trioDEVAPI = ApiClientFactory.create(TrioDEVAPI.class);
    LoginRequest loginRequest = new LoginRequest();
    loginRequest.setEmail(Config.getConfigProperty(Email));
    loginRequest.setPassword(Config.getConfigProperty(Password));
    LoginResponse loginResponse = trioDEVAPI.login(loginRequest);
    Assert.assertNotNull(loginResponse.getAccessToken());
  }

  @ReportTestStep("Trio Enroll Android Test and Fetch the Password")
  public void enrollAndroidAPI() {
    Random random = new Random();
    int randomHardwareID = 10000 + random.nextInt(90000);
    TrioDEVAPI trioDEVAPI = ApiClientFactory.create(TrioDEVAPI.class);
    EnrollRequest enrollRequest = getEnrollRequest(randomHardwareID);
    EnrollResponse enrollResponse = trioDEVAPI.enrollAndroid(enrollRequest);
    AgentRequest agentRequest = new AgentRequest();
    agentRequest.setHardwareId(enrollResponse.getHardwareId());
    agentRequest.setMqttPassword(enrollResponse.getHardwareId());
    mttqPassword = enrollResponse.getAuth().getMqttPassword();
    hardwareID = enrollResponse.getHardwareId();
    Assert.assertNotNull(enrollResponse.getAuth().getMqttPassword());
    Assert.assertNotNull(enrollResponse.getHardwareId());


  }

  private EnrollRequest getEnrollRequest(int randomHardwareID) {
    EnrollRequest enrollRequest = new EnrollRequest();
    Device device = new Device();
    device.setHardwareId(String.valueOf(randomHardwareID));
    device.setIsRooted(true);
    device.setBrand("TestBrand");
    device.setAndroidApiLevel("34");
    device.setInternalStorage(64);
    device.setModel("TestModel");
    device.setCpuArchitecture("x86");
    List<String> sizes = Arrays.asList("33", "33");
    device.setDisplaySizes(sizes);
    enrollRequest.setEnrollmentCode("719972");
    enrollRequest.setDevice(device);
    return enrollRequest;
  }

  @ReportTestStep("Agent Login API and Fetch Access & Refresh Token")
  public void agentLoginAPI() {
    TrioDEVAPI trioDEVAPI = ApiClientFactory.create(TrioDEVAPI.class);
    AgentRequest agentRequest = new AgentRequest();
    agentRequest.setMqttPassword(mttqPassword);
    agentRequest.setHardwareId(hardwareID);
    AgentResponse agentResponse = trioDEVAPI.agentLogin(agentRequest);
   Assert.assertNotNull( agentResponse.getAccessToken());


  }


}
