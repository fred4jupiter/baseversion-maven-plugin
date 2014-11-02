package org.fred4jupiter.baseversion;

import org.apache.commons.lang3.CharSetUtils;

/**
 * Created by michael on 02.11.2014.
 */
public class BaseVersionCreator {

    public String createBaseVersionFrom(String versionNumber, int numberOfDigits) {
        String baseVersion = removeSnapshotString(versionNumber);
        int numberOfDots = getNumberOfDots(baseVersion);
        int existentDigits = numberOfDots + 1;

        if (existentDigits == numberOfDigits) {
            return baseVersion;
        }

        if (existentDigits < numberOfDigits) {
            int digitsToAdd = numberOfDigits - existentDigits;
            for (int i = 0; i < digitsToAdd; i++) {
                baseVersion = baseVersion + ".0";
            }
            return baseVersion;
        } else {
            return getVersionWithMaxDots(baseVersion, numberOfDigits - 1);
        }
    }

    private String removeSnapshotString(String versionNumber) {
        if (!versionNumber.contains("-SNAPSHOT")) {
            return versionNumber;
        }

        int indexBeginningSnapshot = versionNumber.indexOf("-SNAPSHOT");
        return versionNumber.substring(0, indexBeginningSnapshot);
    }

    private String getVersionWithMaxDots(String baseVersion, int dots) {
        int countDots = 0;
        for (int i = 0; i < baseVersion.length(); i++) {
            char ch = baseVersion.charAt(i);
            if (ch == '.') {
                countDots++;
            }
            if (countDots == dots) {
                return baseVersion.substring(0, (i + 2));
            }
        }

        return "";
    }

    private int getNumberOfDots(String baseVersion) {
        return CharSetUtils.count(baseVersion, ".");
    }
}
