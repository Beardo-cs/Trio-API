package com.trio.assignment.apiTest;

import com.qapitol.sauron.core.pages.DiService;
import com.qapitol.sauron.report.core.annotations.ReportTest;
import org.testng.annotations.Test;

import com.qapitol.sauron.common.annotations.SauronTest;


public class ApiTest {

  final TrioAPI trioAPI = DiService.get(TrioAPI.class);

  @SauronTest
  @Test(priority = 0)
  @ReportTest("Login and Retrieve Bearer Token")
  public void LoginAPITest() {
  trioAPI.LoginAPI();
  }

  @SauronTest
  @Test(priority = 1)
  @ReportTest("Enroll Android Device and Connect to MQTT Broker")
  public void EnrollAndroidAPITest() {
    trioAPI.enrollAndroidAPI();

  }

  @SauronTest
  @Test(priority = 2)
  @ReportTest("Retrieve Access and Refresh Tokens")
  public void AgentLoginAPITest() {
    trioAPI.agentLoginAPI();

  }
}
