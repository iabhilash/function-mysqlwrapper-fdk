package com.test.fn;

import java.util.Arrays;


public class MySqlFunction {

    public static class Input {
        public String user;
        public String pass;
        public String ipAddress;
        public int port;
        public String functionName;
    }

    public enum MySqlWrapperOptions {

        GETCLIENTVERSION("getClientVersion");
        final String value;

        public String getValue() {
            return value;
        }

        MySqlWrapperOptions(String value) {
            this.value = value;
        }

        static MySqlWrapperOptions getByValue(String value) {
            return Arrays.stream(MySqlWrapperOptions.values()).filter(x -> x.value.equals(value)).findFirst().orElse(null);
        }
    }

    public String handleRequest(Input input) {
        String result = null;
        String invalidInput = "No valid input";
        try {
            MySqlWrapper mySqlWrapper = new MySqlWrapper(input.user, input.pass, input.ipAddress, input.port);
            if (input.functionName == null) {
                return invalidInput;
            }
            MySqlWrapperOptions wrapperOptions = MySqlWrapperOptions.getByValue(input.functionName);
            mySqlWrapper.connect();
            if (wrapperOptions == MySqlWrapperOptions.GETCLIENTVERSION) {
                result = mySqlWrapper.getClientVersion();
            } else {
                System.out.print(invalidInput);
            }
        } catch (Exception ex) {
            result = ex.getMessage();
        }
        return result;
    }
}

