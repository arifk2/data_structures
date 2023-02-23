package com.rf.khan.api;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class LastMonthStartDate {
  public static void main(String[] args) {
    LastMonthStartDate l = new LastMonthStartDate();
    System.out.println(l.getLastMonthStartDate(1));
    System.out.println(l.getLastMonthEndDate());
  }

  public Date getLastMonthStartDate(int lastMonth) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MONTH, -lastMonth);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    Date lastMonthStartDate = calendar.getTime();
    return lastMonthStartDate;

  }

  public Date getLastMonthEndDate() {
    LocalDate currentDate = LocalDate.now();
    LocalDate lastMonthEnd = currentDate.minusMonths(1).withDayOfMonth(currentDate.minusMonths(1).lengthOfMonth());
    Date date = Date.from(lastMonthEnd.atStartOfDay(ZoneId.systemDefault()).toInstant());
    return date;
  }
}