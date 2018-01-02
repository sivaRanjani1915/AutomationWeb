package com.tcs.utilityhelpers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

//import org.apache.poi.xssf.usermodel.XSSFCell;

public class Trial {

    //public static XSSFCell cell;
    /*public static void main(String[] args) throws ParseException {
		String pickupTimedisplay = "Available as soon as Today at 06:00 PM ET";
		String trimvalue1 = pickupTimedisplay.substring(30);
		System.out.println("My Trim value is =======>>> :" + trimvalue1);
		//Sunday, October 30, 2016
		String Pickupdate = "2016-10-30";		
		DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = (Date)originalFormat.parse(Pickupdate); 
		//int timezone = startDate.getTimezoneOffset();
//		SimpleDateFormat formatter = new SimpleDateFormat("z");
		SimpleDateFormat formatter = new SimpleDateFormat("EEEEE, MMMMM dd, yyyy");
	 	String text = formatter.format(startDate);
	 	//String timezoneSF=text.replace("D", "");
		//System.out.println("time Zone is "+ timezoneSF);
	 	System.out.println("Formatted date is: "+ text);
		//String trimvalue = pickupTimedisplay.replaceAll("[^0-9:]", "");
		//System.out.println("My Trim value is =======>>> :" + trimvalue);
	
		}
		*/

	
	/*public static void main(String[] args) throws ParseException {
        //System.out.println(System.currentTimeMillis());
		//String timeStamp = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		Date date = new Date();
		//System.out.println(timeStamp);
		System.out.println(date);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48

	}*/

    public static void main(String[] args) throws InterruptedException, ParseException {

        String timeone = "11:00 AM";

        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");
        dateTimeFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        Date date = new Date(); // 13:05
        String estDate = dateTimeFormat.format(date);
        System.out.println(estDate);
        // this print EST

        DateFormat formatter;
        Date date1;
        formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");
        date1 = formatter.parse(estDate);

        System.out.println(date1);

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        java.util.Date d1 = null;
        d1 = format.parse(timeone);

        System.out.println("Value of d1 is ===> " + d1);

        long diff = date1.getTime() - d1.getTime();
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;

        System.out.println(diff + "Days, ");
        System.out.print(diffHours + " hours, ");
        System.out.print(diffMinutes + " minutes, ");

        if (diffHours == 3 & diffMinutes >= 30)
            System.out.print("The time interval between current time and first PickUpTimeSlot is greater than 3.5hrs");
        else if (diffHours > 3)
            System.out.print("The time interval between current time and first PickUpTimeSlot is greater than 3.5hrs");

    }


    //Setting Geo-Location

	/*chromeDriver.executeScript("window.navigator.geolocation.getCurrentPosition = 
            function(success){
		         var position = {"coords" : {
		                                       "latitude": "555", 
		                                       "longitude": "999"
		                                     }
		                         }; 
		         success(position);}");
*/


}
