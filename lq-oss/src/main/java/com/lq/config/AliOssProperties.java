package com.lq.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("aliyun.oss")
public class AliOssProperties implements InitializingBean {
//    region-id:
//    ak: LTAI5t6zQ3TSfNW6DgmNVH9L
//    sk: OJjkCekjNg5a1iniwnjkQGllVUL5oj
//    sign-name:
//    template-code:

    /**
     * 区域id
     */
    private String regionId;
    /**
     * AccessKey ID
     */
    private String ak;
    /**
     * AccessKey Secret
     */
    private String sk;
    /**
     * 访问域名
     */
    private String endpoint;
    /**
     * oss桶
     */
    private String bucketName;


    /**
     * 区域id
     */
    public static String REGION_ID;
    /**
     * AccessKey ID
     */
    public static String AK;
    /**
     * AccessKey Secret
     */
    public static String SK;
    /**
     *访问域名
     */
    public static String ENDPOINT;
    /**
     * oss桶
     */
    public static String BUCKET_NAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        REGION_ID = regionId;
        AK = ak;
        SK = sk;
        ENDPOINT =endpoint;
        BUCKET_NAME = bucketName;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }


    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
