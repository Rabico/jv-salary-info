package core.basesyntax;

import java.time.format.DateTimeFormatter;

public class SalaryInfo {
    private StringBuilder builder;
    private DateTimeFormatter formatter;
    private String[] split = new String[4];
    private int salary;

    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {

        builder = new StringBuilder();
        if (checkDates(dateTo, dateFrom) && !dateTo.equals(dateFrom)) {
            return null;
        }
        builder.append("Report for period ")
                .append(dateFrom)
                .append(" - ")
                .append(dateTo);
        for (String name : names) {

            builder.append("\n")
                    .append(name);
            salary = 0;
            for (String dates : data) {
                split = dates.split(" ");
                if (checkDates(dateFrom, split[0]) && checkDates(split[0], dateTo)
                        && name.equals(split[1])) {
                    salary += Integer.parseInt(split[2]) * Integer.parseInt(split[3]);
                }

            }
            builder.append(" - ")
                    .append(salary);

        }
        return builder.toString();
    }

    public Boolean checkDates(String firstDate, String secondDate) {
        String[] firstNumbers = new String[3];
        String[] secondNumbers = new String[3];
        firstNumbers = firstDate.split("\\.");
        secondNumbers = secondDate.split("\\.");

        if (Integer.parseInt(firstNumbers[2]) < Integer.parseInt(secondNumbers[2])) {
            return true;
        } else if (Integer.parseInt(firstNumbers[2]) == Integer.parseInt(secondNumbers[2])) {
            if (Integer.parseInt(firstNumbers[1]) < Integer.parseInt(secondNumbers[1])) {
                return true;
            } else if (Integer.parseInt(firstNumbers[1]) == Integer.parseInt(secondNumbers[1])) {
                if (Integer.parseInt(firstNumbers[0]) <= Integer.parseInt(secondNumbers[0])) {
                    return true;
                }
            }
        }
        return false;

    }
}
