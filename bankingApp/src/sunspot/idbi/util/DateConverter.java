package sunspot.idbi.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

	public static String getDate() {
		
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(new Date());
	}	
}
