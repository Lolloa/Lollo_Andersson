package uppgift5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
	
private String date;
	
	public DateTime() {
		setDate();
	}

	public String getDate() {
		return date;
	}

	public void setDate() {
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String newDate = sd.format(date);
		this.date = newDate;
	}

}
