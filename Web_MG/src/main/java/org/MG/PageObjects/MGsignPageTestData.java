package org.MG.PageObjects;

import org.MG.Enums.MGenum;
import org.MG.constants.FrameworkPathConstants;

import static org.MG.ConfigLoaders.JsonUtils.getValue;

public class MGsignPageTestData {
    public static final String signintestdata = getValue(MGenum.SIGN_IN, FrameworkPathConstants.TEST_DATA_FILE_PATH);
    public static final String phone1testdata = getValue(MGenum.PHONE_1, FrameworkPathConstants.TEST_DATA_FILE_PATH);

}
