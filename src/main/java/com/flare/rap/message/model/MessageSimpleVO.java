package com.flare.rap.message.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class MessageSimpleVO implements java.io.Serializable {

    private String msgCtn;

    private String langCd;

    private String msgTxtCtn;
    @Override
    public String toString() {
        return "MessageSimpleVO{" +
                "msgCtn='" + msgCtn + '\'' +
                ", langCd='" + langCd + '\'' +
                ", msgTxtCtn='" + msgTxtCtn + '\'' +
                '}';
    }
}