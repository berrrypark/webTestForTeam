package kr.co.study.webtest.util.crypto;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

public class JasyptEncryptorTest {

    public static void main(String[] args) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();

        config.setPassword("비밀번호"); // jasypt.yml
        config.setAlgorithm("PBEWithHMACSHA512AndAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setConfig(config);

        String decryptedUsername = encryptor.encrypt("bep");
        String decryptedPassword = encryptor.encrypt("bep1!");

        System.out.println("✅ username: " + decryptedUsername);
        System.out.println("✅ password: " + decryptedPassword);
    }

}
