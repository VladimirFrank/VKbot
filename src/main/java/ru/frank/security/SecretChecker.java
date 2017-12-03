package ru.frank.security;

public class SecretChecker {

    private final static String secretCode = "empty1String5Not2Supported8";

    private static SecretChecker secretCheckerInstanse;

    private SecretChecker(){}

    public static SecretChecker getSecretCheckerInstanse(){
        if(secretCheckerInstanse == null){
            secretCheckerInstanse = new SecretChecker();
        }
        return secretCheckerInstanse;
    }

    public static String getSecretCode() {
        return secretCode;
    }
}
