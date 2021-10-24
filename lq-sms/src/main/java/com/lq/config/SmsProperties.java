package com.lq.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("aliyun.sms")
public class SmsProperties implements InitializingBean {
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
     * 短信签名
     */
    private String signName;
    /**
     * 短信模板code
     */
    private String templateCode;


    /**
     * 区域id
     */
    private static String REGION_ID;
    /**
     * AccessKey ID
     */
    private static String AK;
    /**
     * AccessKey Secret
     */
    private static String SK;
    /**
     * 短信签名
     */
    private static String SIGN_NAME;
    /**
     * 短信模板code
     */
    private static String TEMPLATE_CODE;

    @Override
    public void afterPropertiesSet() throws Exception {
        REGION_ID = regionId;
        AK = ak;
        SK = sk;
        SIGN_NAME = signName;
        TEMPLATE_CODE = templateCode;
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

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }


}
