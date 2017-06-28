package hellmonky.testPackage.ssl;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClientConfig;
import org.asynchttpclient.Response;
import org.asynchttpclient.netty.ssl.JsseSslEngineFactory;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;

/**
 * Created by yuanlai.xwt on 2017/6/21.
 */
public class testSSL {

    private String httpsAddress;
    private String caPath;
    private String certPaht;
    private String enckeyPath;
    private String keyPath;

    public testSSL(){
        // 访问 https://www.baidu.com 检查是否正常返回
        this.httpsAddress = "https://www.baidu.com";
        // 双向验证的证书路径
        this.caPath = "C:\\Users\\yuanlai.xwt\\Desktop\\astest\\ca.pem";
        this.certPaht = "C:\\Users\\yuanlai.xwt\\Desktop\\astest\\cert.pem";
        this.enckeyPath = "C:\\Users\\yuanlai.xwt\\Desktop\\astest\\key.pem";
        this.keyPath = "C:\\Users\\yuanlai.xwt\\Desktop\\astest\\key.der";
    }

    public void sslConnectionTest(){
        AsyncHttpClient client = new DefaultAsyncHttpClient();
        try{
            Response response = client.prepareGet(this.httpsAddress).execute().get();
            System.out.println(response.toString());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public JsseSslEngineFactory getSSLContext() {
        Path enckey = Paths.get(this.enckeyPath);
        Path cert = Paths.get(this.certPaht);
        Path ca = Paths.get(this.caPath);
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            Certificate caCert = cf.generateCertificate(Files.newInputStream(ca));
            Certificate clientCert = cf.generateCertificate(Files.newInputStream(cert));

            /* 解密后的key输入
            File keyfile = new File(this.keyPath);
            byte[] encodedKey = new byte[(int)keyfile.length()];
            FileInputStream fis = new FileInputStream(keyfile);
            fis.read(encodedKey);
            fis.close();
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encodedKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privatekey = keyFactory.generatePrivate(privateKeySpec);
            //*/

            ///* 原始key输入
            final PEMKeyPair clientKeyPair = (PEMKeyPair) new PEMParser(
                Files.newBufferedReader(enckey,
                    Charset.defaultCharset()))
                .readObject();
            final PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(
                clientKeyPair.getPrivateKeyInfo().getEncoded());
            final KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            final PrivateKey privatekey = keyFactory.generatePrivate(spec);
            //*/

            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("client", clientCert);
            keyStore.setKeyEntry("key", privatekey, "".toCharArray(), new Certificate[]{clientCert});

            char[] certificatePassword = "".toCharArray();
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(keyStore, certificatePassword);

            //设置信任证书
            final KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);
            trustStore.setEntry("ca", new KeyStore.TrustedCertificateEntry(caCert), null);
            TrustManagerFactory trustManager = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManager.init(trustStore);

            KeyManager[] keyManagers = kmf.getKeyManagers();
            TrustManager[] trustManagers = trustManager.getTrustManagers();
            SecureRandom secureRandom = new SecureRandom();

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagers, trustManagers, secureRandom);
            JsseSslEngineFactory sslEngineFactory = new JsseSslEngineFactory(sslContext);
            return sslEngineFactory;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        testSSL ts = new testSSL();
        DefaultAsyncHttpClientConfig.Builder builderFastClient = new DefaultAsyncHttpClientConfig.Builder();
        builderFastClient.setSslEngineFactory(ts.getSSLContext());
        builderFastClient.setConnectTimeout(3000);
        builderFastClient.setReadTimeout(2000);
        builderFastClient.setMaxConnections(1000);
        String desAddress = "https://master2g7.cs-cn-hangzhou.aliyun.com:23141/projects/";
        AsyncHttpClient client2 = new DefaultAsyncHttpClient(builderFastClient.build());
        try {
            Response response = client2.prepareGet(desAddress).execute().get();
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
