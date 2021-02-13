package com.amgadFarag.cpn.services;

import org.springframework.stereotype.Service;

/***
 * A Validation service, acting as a source of phone, country & countryCode validity
 * */
@Service
public class PhoneValidatorService {


    public String[] getCountryAndCode(String phone) {
//        String prefixRegex = "\\(\\+[\\d]+\\)";
        String country = "";
        String code = "";

        String cameroonRegex = "\\(237\\) ?[2368]\\d{7,8}$";
        String ethiopiaRegex = "\\(251\\) ?[1-59]\\d{8}$";
        String moroccoRegex = "\\(212\\) ?[5-9]\\d{8}$";
        String mozambiqueRegex = "\\(258\\) ?[28]\\d{7,8}$";
        String ugandaRegex = "\\(256\\) ?\\d{9}$";

        if (phone.matches(cameroonRegex) ) {
            country = "Cameroon";
            code = "+237";
        } else if (phone.matches(ethiopiaRegex) ) {
            country = "Ethiopia";
            code = "+251";
        } else if (phone.matches(moroccoRegex) ) {
            country = "Morocco";
            code = "+212";
        } else if (phone.matches(mozambiqueRegex) ) {
            country = "Mozambique";
            code = "+258";
        } else if (phone.matches(ugandaRegex) ) {
            country = "Uganda";
            code = "+256";
        }
        return new String[]{country, code};
    }

    public boolean isCorrectCountry(String country, String targetCountry) throws Exception {
        return notNull(country) && country.equalsIgnoreCase(targetCountry);
    }

    public boolean isValidPhone(String phone) {
//        String prefixRegex = "\\(\\d{3}\\)";

        String cameroonRegex = "\\(237\\) ?[2368]\\d{7,8}$";
        String ethiopiaRegex = "\\(251\\) ?[1-59]\\d{8}$";
        String moroccoRegex = "\\(212\\) ?[5-9]\\d{8}$";
        String mozambiqueRegex = "\\(258\\) ?[28]\\d{7,8}$";
        String ugandaRegex = "\\(256\\) ?\\d{9}$";

        return notNull(phone) &&
                (phone.matches(cameroonRegex) || phone.matches(ethiopiaRegex) ||
                phone.matches(moroccoRegex) || phone.matches(mozambiqueRegex) || phone.matches(ugandaRegex));
    }

    public boolean isCorrectCountryCode(String countryCode, String targetCountryCode) throws Exception {
        return notNull(countryCode) && countryCode.equalsIgnoreCase(targetCountryCode);
    }

    public boolean isCorrectNumber(String phone, String number) throws Exception {
        return notNull(phone) && phone.contains(number);
    }

    private boolean notNull(String check) {
        return check != null && !check.equalsIgnoreCase("") && !check.equalsIgnoreCase("null");
    }
}
