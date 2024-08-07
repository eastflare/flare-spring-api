//
// 이 파일은 JAXB의 Eclipse 구현에 의해 생성되었습니다 4.0.2 버전을 통해 생성되었습니다.
// https://eclipse-ee4j.github.io/jaxb-ri를 참조하십시오.
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다.
//


package com.flare.project.webService.server.processApproval;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type에 대한 Java 클래스입니다.
 *
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 *
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="API_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="SYSTEM_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="APPKEY01" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="APPKEY02" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="APPKEY03" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="APPKEY04" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="APPKEY05" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="APPROVER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="COMMENT_UTF8" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="COMMENT_EUCKR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="RESULT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="APPR_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="NEXT_APPR_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="NEXT_APPROVER_ORDER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="NEXT_APPROVER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="READ_USER" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "apitype",
    "systemid",
    "appkey01",
    "appkey02",
    "appkey03",
    "appkey04",
    "appkey05",
    "approver",
    "commentutf8",
    "commenteuckr",
    "result",
    "apprdate",
    "nextapprtype",
    "nextapproverorder",
    "nextapprover",
    "readuser"
})
@XmlRootElement(name = "getProcessApprovalResponse")
public class GetProcessApprovalResponse {

    @XmlElement(name = "API_TYPE", required = true)
    protected String apitype;
    @XmlElement(name = "SYSTEM_ID", required = true)
    protected String systemid;
    @XmlElement(name = "APPKEY01", required = true)
    protected String appkey01;
    @XmlElement(name = "APPKEY02", required = true)
    protected String appkey02;
    @XmlElement(name = "APPKEY03", required = true)
    protected String appkey03;
    @XmlElement(name = "APPKEY04", required = true)
    protected String appkey04;
    @XmlElement(name = "APPKEY05", required = true)
    protected String appkey05;
    @XmlElement(name = "APPROVER", required = true)
    protected String approver;
    @XmlElement(name = "COMMENT_UTF8", required = true)
    protected String commentutf8;
    @XmlElement(name = "COMMENT_EUCKR", required = true)
    protected String commenteuckr;
    @XmlElement(name = "RESULT", required = true)
    protected String result;
    @XmlElement(name = "APPR_DATE", required = true)
    protected String apprdate;
    @XmlElement(name = "NEXT_APPR_TYPE", required = true)
    protected String nextapprtype;
    @XmlElement(name = "NEXT_APPROVER_ORDER", required = true)
    protected String nextapproverorder;
    @XmlElement(name = "NEXT_APPROVER", required = true)
    protected String nextapprover;
    @XmlElement(name = "READ_USER", required = true)
    protected String readuser;

    /**
     * apitype 속성의 값을 가져옵니다.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAPITYPE() {
        return apitype;
    }

    /**
     * apitype 속성의 값을 설정합니다.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAPITYPE(String value) {
        this.apitype = value;
    }

    /**
     * systemid 속성의 값을 가져옵니다.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSYSTEMID() {
        return systemid;
    }

    /**
     * systemid 속성의 값을 설정합니다.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSYSTEMID(String value) {
        this.systemid = value;
    }

    /**
     * appkey01 속성의 값을 가져옵니다.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAPPKEY01() {
        return appkey01;
    }

    /**
     * appkey01 속성의 값을 설정합니다.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAPPKEY01(String value) {
        this.appkey01 = value;
    }

    /**
     * appkey02 속성의 값을 가져옵니다.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAPPKEY02() {
        return appkey02;
    }

    /**
     * appkey02 속성의 값을 설정합니다.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAPPKEY02(String value) {
        this.appkey02 = value;
    }

    /**
     * appkey03 속성의 값을 가져옵니다.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAPPKEY03() {
        return appkey03;
    }

    /**
     * appkey03 속성의 값을 설정합니다.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAPPKEY03(String value) {
        this.appkey03 = value;
    }

    /**
     * appkey04 속성의 값을 가져옵니다.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAPPKEY04() {
        return appkey04;
    }

    /**
     * appkey04 속성의 값을 설정합니다.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAPPKEY04(String value) {
        this.appkey04 = value;
    }

    /**
     * appkey05 속성의 값을 가져옵니다.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAPPKEY05() {
        return appkey05;
    }

    /**
     * appkey05 속성의 값을 설정합니다.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAPPKEY05(String value) {
        this.appkey05 = value;
    }

    /**
     * approver 속성의 값을 가져옵니다.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAPPROVER() {
        return approver;
    }

    /**
     * approver 속성의 값을 설정합니다.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAPPROVER(String value) {
        this.approver = value;
    }

    /**
     * commentutf8 속성의 값을 가져옵니다.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCOMMENTUTF8() {
        return commentutf8;
    }

    /**
     * commentutf8 속성의 값을 설정합니다.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCOMMENTUTF8(String value) {
        this.commentutf8 = value;
    }

    /**
     * commenteuckr 속성의 값을 가져옵니다.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCOMMENTEUCKR() {
        return commenteuckr;
    }

    /**
     * commenteuckr 속성의 값을 설정합니다.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCOMMENTEUCKR(String value) {
        this.commenteuckr = value;
    }

    /**
     * result 속성의 값을 가져옵니다.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRESULT() {
        return result;
    }

    /**
     * result 속성의 값을 설정합니다.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRESULT(String value) {
        this.result = value;
    }

    /**
     * apprdate 속성의 값을 가져옵니다.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAPPRDATE() {
        return apprdate;
    }

    /**
     * apprdate 속성의 값을 설정합니다.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAPPRDATE(String value) {
        this.apprdate = value;
    }

    /**
     * nextapprtype 속성의 값을 가져옵니다.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNEXTAPPRTYPE() {
        return nextapprtype;
    }

    /**
     * nextapprtype 속성의 값을 설정합니다.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNEXTAPPRTYPE(String value) {
        this.nextapprtype = value;
    }

    /**
     * nextapproverorder 속성의 값을 가져옵니다.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNEXTAPPROVERORDER() {
        return nextapproverorder;
    }

    /**
     * nextapproverorder 속성의 값을 설정합니다.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNEXTAPPROVERORDER(String value) {
        this.nextapproverorder = value;
    }

    /**
     * nextapprover 속성의 값을 가져옵니다.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNEXTAPPROVER() {
        return nextapprover;
    }

    /**
     * nextapprover 속성의 값을 설정합니다.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNEXTAPPROVER(String value) {
        this.nextapprover = value;
    }

    /**
     * readuser 속성의 값을 가져옵니다.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getREADUSER() {
        return readuser;
    }

    /**
     * readuser 속성의 값을 설정합니다.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setREADUSER(String value) {
        this.readuser = value;
    }

    public static GetProcessApprovalResponse of(GetProcessApprovalRequest request, String systemId){
        GetProcessApprovalResponse response = new GetProcessApprovalResponse();
        response.setAPITYPE(request.getAPITYPE());
        response.setSYSTEMID(systemId);
        response.setAPPKEY01(request.getAPPKEY01());
        response.setAPPKEY02(request.getAPPKEY02());
        response.setAPPKEY03(request.getAPPKEY03());
        response.setAPPKEY04(request.getAPPKEY04());
        response.setAPPKEY05(request.getAPPKEY05());
        response.setAPPROVER(request.getAPPROVER());
        response.setCOMMENTUTF8(request.getCOMMENTUTF8());
        response.setCOMMENTEUCKR(request.getCOMMENTEUCKR());
        response.setRESULT(request.getRESULT());
        response.setAPPRDATE(request.getAPPRDATE());

        return response;
    }
}