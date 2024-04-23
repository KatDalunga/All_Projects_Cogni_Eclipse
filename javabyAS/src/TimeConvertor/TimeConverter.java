package TimeConvertor;

public class TimeConverter {
	
 	private int hours;
 	private int minutes;
 	private int seconds;
 	private String meridiem;
 	
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	public String getMeridiem() {
		return meridiem;
	}
	public void setMeridiem(String meridiem) {
		this.meridiem = meridiem;
	}
	public TimeConverter(int hours, int minutes, int seconds,String meridiem) {
		super();
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		this.meridiem = meridiem;
	}

	public TimeConverter() {
		super();
	}
	public String convertToGMT(){
		
	    //fill the code here
// 		return null;
        
        if(hours>0 && minutes>=0 && seconds>=0 && (meridiem.equalsIgnoreCase("AM") || meridiem.equalsIgnoreCase("PM")))
	    {
	      String gmt=null, gmH=null, gmM=null, ampm=getMeridiem();
		int gmtHour = (getHours() - 5) % 24; // IST is 5 hours ahead of GMT
        int gmtMinute = getMinutes()-30;// IST is 30 Minutes ahead of GMT
        

        // Adjust for negative values
        if (gmtHour < 0) {
            gmtHour += 24;
       }
       if(gmtMinute<0)
        {
        	gmtMinute+=60;
        	gmtHour-=1;
        	ampm="AM";
        }

        gmtHour = (gmtHour % 12 == 0) ? 12 : gmtHour % 12;
		if(gmtHour>=1 && gmtHour<=9) {
			gmH=String.valueOf("0"+gmtHour);
		}
		else {
			gmH=String.valueOf(gmtHour);
	}
		if(gmtMinute>=0 && gmtMinute<=9) {
			gmM=String.valueOf("0"+gmtMinute);
		}else
		{
			gmM=String.valueOf(gmtMinute);
		}
		
		
		gmt=gmH+":"+gmM+":"+String.valueOf(getSeconds())+":"+ampm;
		return gmt;
	      
	    }
	    else{
	        return "Error";
	    }
	
	}

}

