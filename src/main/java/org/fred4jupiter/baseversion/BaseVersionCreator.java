package org.fred4jupiter.baseversion;

import org.apache.commons.lang3.CharSetUtils;

/**
 * Created by michael on 02.11.2014.
 */
public class BaseVersionCreator {

    public String createBaseVersionFrom(String versionNumber, int numberOfDigitsInResult) {
        String baseVersion = removeSnapshotString(versionNumber);
        int numberOfDots = getNumberOfDots(baseVersion);
        int existentDigits = numberOfDots + 1;

        if (existentDigits == numberOfDigitsInResult) {
            return baseVersion;
        }

        if (existentDigits < numberOfDigitsInResult) {
            int digitsToAdd = numberOfDigitsInResult - existentDigits;
            for (int i = 0; i < digitsToAdd; i++) {
                baseVersion = baseVersion + ".0";
            }
            return baseVersion;
        } else {
            int dotsInResult = numberOfDigitsInResult - 1;
            return getVersionWithMaxDots(baseVersion, dotsInResult);
        }
    }

    private String removeSnapshotString(String versionNumber) {
        if (!versionNumber.contains("-SNAPSHOT")) {
            return versionNumber;
        }

        int indexBeginningSnapshot = versionNumber.indexOf("-SNAPSHOT");
        return versionNumber.substring(0, indexBeginningSnapshot);
    }

    private String getVersionWithMaxDots(String baseVersion, int dotsInResult) {
        if (dotsInResult == 0) {
            int indexOfFirstDot = baseVersion.indexOf('.');
            return baseVersion.substring(0, indexOfFirstDot);
        }

        int countDots = 0;
        for (int i = 0; i < baseVersion.length(); i++) {
            char ch = baseVersion.charAt(i);
            if (ch == '.') {
                countDots++;
            }
            if (countDots == dotsInResult) {
                return baseVersion.substring(0, (i + 2));
            }
        }

        return "";
    }

    private int getNumberOfDots(String baseVersion) {
        return CharSetUtils.count(baseVersion, ".");
    }
}
