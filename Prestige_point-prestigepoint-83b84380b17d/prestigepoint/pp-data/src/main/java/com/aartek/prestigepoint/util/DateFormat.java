package com.aartek.prestigepoint.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateFormat {
	
	private static final Logger log = Logger.getLogger(DateFormat.class);
    public static String getYYYYMMDDDate(String date1) {
    SimpleDateFormat userDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat dateFormatNeeded = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;
    try {
      date = userDateFormat.parse(date1);
    } catch (ParseException e) {
    	log.error("Parse Exception",e);
    }
    String convertedDate = dateFormatNeeded.format(date);
    return convertedDate;
  }

  public static String getMMDDYYYYDate(String date1) {
    SimpleDateFormat userDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat dateFormatNeeded = new SimpleDateFormat("dd-MM-yyyy");
    Date date = null;
    try {
      date = userDateFormat.parse(date1);
    } catch (ParseException e) {
    	log.error("Parse Exception",e);
    }
    String convertedDate = dateFormatNeeded.format(date);
    return convertedDate;
  }

  public static String getMMDDYYYYDateFormat(String datereleaseAartek) {
    String formattedDate = null;
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
      Date tempDate = simpleDateFormat.parse(datereleaseAartek);
      SimpleDateFormat outputDateFormat = new SimpleDateFormat("MM-dd-YYYY");
      formattedDate = outputDateFormat.format(tempDate);
     log.info("Output date is = " + outputDateFormat.format(tempDate));
    } catch (ParseException ex) {
    	log.error("Parse Exception",ex);
    }
    return formattedDate;
  }
  
}
