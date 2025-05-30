package kr.co.study.webtest.util.crypto;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

public class JasyptDecryptTest {

    public static void main(String[] args) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();

        config.setPassword("비밀번호");
        config.setAlgorithm("PBEWithHMACSHA512AndAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setConfig(config);

        String decryptedUsername = encryptor.decrypt("EZ0YI3gjy+xozEx/MciBsfOt9GzgnA6tw7Wm5FB9FnOgj/8hSpGG0aSjpWJVry/l");
        String decryptedPassword = encryptor.decrypt("lD26XU0bDVXOJHiwYNQwT06GUWY5yHy1zw5YpeCNViDRRh65ZNvfgg4WSaYuKc/o");

        System.out.println("✅ username: " + decryptedUsername);
        System.out.println("✅ password: " + decryptedPassword);
    }

}
