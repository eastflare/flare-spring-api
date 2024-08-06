package com.flare.rap.common.util;

import java.util.List;

import jakarta.mail.internet.InternetAddress;
import lombok.experimental.UtilityClass;
@UtilityClass
public class MailUtil {
    public static InternetAddress[] listToArray(List<String> addresses, String charset) throws Exception {

        if (addresses == null){return new InternetAddress[0];}

        InternetAddress[] internetAddresses = new InternetAddress[addresses.size()];
        int i = 0;
        for (String address : addresses) {
            internetAddresses[i] = new InternetAddress(address);
            internetAddresses[i].setPersonal(internetAddresses[i].getPersonal(), charset);
            i++;
        }
        return internetAddresses;

    }
}