package com.tw;

import org.junit.jupiter.api.Test;

public class MultiplicationTable {
    public String create(int start, int end) {
        if (isValid(start, end)) {
            return generateTable(start, end);
        }
        return null;
    }

    public Boolean isValid(int start, int end) {
        return isInRange(start)&&isInRange(end)&&isStartNotBiggerThanEnd(start, end);
    }

    public Boolean isInRange(int number) {
        return !(number < 1 || number > 1000);
    }

    public Boolean isStartNotBiggerThanEnd(int start, int end) {
        return start <= end;
    }

    public String generateTable(int start, int end) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = start; i <= end; i++) {
            String line = generateLine(start, i);
            stringBuilder.append(line);
            if (i!=end) stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    public String generateLine(int start, int row) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = start; i <=row; i++) {
            stringBuilder.append(generateSingleExpression(i, row));
            if (i != row) {
                stringBuilder.append("  ");
            }
        }
        return stringBuilder.toString();
    }

    public String generateSingleExpression(int multiplicand, int multiplier) {
        return multiplicand + "*" + multiplier + "=" + (multiplicand * multiplier);
    }
}
