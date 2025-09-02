package util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils {

    public String getUsername = System.getProperty("username");
    public String getPassword = System.getProperty("password");
}
