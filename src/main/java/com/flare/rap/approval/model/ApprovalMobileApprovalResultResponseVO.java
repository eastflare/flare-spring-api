package com.flare.rap.approval.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Data
@XmlRootElement
@JacksonXmlRootElement(localName = "apprResult")
public class ApprovalMobileApprovalResultResponseVO {
    @Schema(description = "성공/실패 설명", name="성공/실패 설명")
    @JacksonXmlProperty
    private String returnDesc;

    @Schema(description = "성공/실패 코드", name="성공/실패 코드")
    @JacksonXmlProperty
    private int returnCode;

}