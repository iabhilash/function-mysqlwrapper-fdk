package com.test.fn;

import com.fnproject.fn.testing.*;
import org.junit.*;

public class MySqlFunctionTest {

    //Enter your client authentication details
    String user = "TestFunction";
    String password = "TestPassword";
    String ipAddress = "localhost";
    int port = 3306;

    @Rule
    public final FnTestingRule testingClientVersion = FnTestingRule.createDefault();

    @Test
    public void shouldReturnClientVersion() {
        String connectionString = String.format("{\"user\":\"%s\", \"pass\":\"%s\", \"ipAddress\":\"%s\", \"port\":%d, \"functionName\":\"%s\"}", user, password, ipAddress, port, "getClientVersion");
        testingClientVersion.givenEvent().withBody(connectionString).enqueue();
        testingClientVersion.thenRun(MySqlFunction.class, "handleRequest");

        FnResult result = testingClientVersion.getOnlyResult();
        System.out.println("Version:" + result.getBodyAsString());

    }

}