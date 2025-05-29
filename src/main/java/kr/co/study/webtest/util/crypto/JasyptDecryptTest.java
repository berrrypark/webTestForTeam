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

        String decryptedUsername = encryptor.decrypt("PTWUVC6hclgWtJok4DF9mig56I70vMb+IxEPtXoyFu13SXoyLEdeXFZTrTG5kwXj");
        String decryptedPassword = encryptor.decrypt("hpeauV9iyT+mtlneLPkmZipCRF9NExGDoxEGuNIPUXrB+sdqw9Y6WrHvooUKw/ju");

        System.out.println("✅ username: " + decryptedUsername);
        System.out.println("✅ password: " + decryptedPassword);
    }

}
