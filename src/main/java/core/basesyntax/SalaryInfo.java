package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryInfo {

    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        StringBuilder builder;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateFromLocal;
        LocalDate dateToLocal;
        LocalDate dateActualLocal;
        String[] split = new String[4];
        int salary;
        int zero = 0;
        int one = 1;
        int two = 2;
        int three = 3;

        dateFromLocal = LocalDate.parse(dateFrom, formatter);
        dateToLocal = LocalDate.parse(dateTo, formatter);
        builder = new StringBuilder();
        if (dateFromLocal.isAfter(dateToLocal)) {
            return null;
        }
        builder.append("Report for period ")
                .append(dateFrom)
                .append(" - ")
                .append(dateTo);
        for (String name : names) {

            builder.append(System.lineSeparator())
                    .append(name);
            salary = zero;
            for (String dates : data) {
                split = dates.split(" ");
                dateActualLocal = LocalDate.parse(split[zero], formatter);
                if (((dateFromLocal.isBefore(dateActualLocal)
                        && dateActualLocal.isBefore(dateToLocal))
                        || dateFromLocal.isEqual(dateActualLocal)
                        || dateActualLocal.isEqual(dateToLocal))
                        && name.equals(split[one])) {
                    salary += Integer.parseInt(split[two]) * Integer.parseInt(split[three]);
                }

            }
            builder.append(" - ")
                    .append(salary);

        }
        return builder.toString();
    }

}
