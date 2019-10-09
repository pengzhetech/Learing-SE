package com.javaman.function;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pengzhe
 * @date 2019-05-06 10:11
 */
public class Test {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();


        TypeEnum alg = TypeEnum.ALG;
        System.out.println(alg.type);

    }

    enum TypeEnum {

        OPRETOR("1"),
        ALG("2");

        TypeEnum(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        private String type;

    }

    private static String getOnlineTemplateVersion() {
        LocalDate localDate = getLocalDate();
        return localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
    }

    private static String getPreTemplateVersion() {
        StringBuilder builder = new StringBuilder();
        LocalDate localDate = getLocalDate();
        int value = localDate.getMonth().getValue();
        String localDateString = getOnlineTemplateVersion();
        String substring = localDateString.substring(6);
        return builder.append(value).append(substring).toString();
    }

    private static LocalDate getLocalDate() {
        ZoneId zoneId = ZoneId.systemDefault();
        Instant now = Instant.now();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, zoneId);
        return localDateTime.toLocalDate();
    }

    private static void removeRepetition(List<String> retainList, List<String> removeList) {
        removeList.forEach(item -> retainList.removeIf(retainItem -> retainItem.equalsIgnoreCase(item)));
    }
}
