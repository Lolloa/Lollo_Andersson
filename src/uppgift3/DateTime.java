package uppgift3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
	private String date;
	private String time;
	
	public DateTime(String dateTime) {
		this.time = dateTime;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	

}
