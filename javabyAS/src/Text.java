import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Text {
	public static void main(String[] args) {
		LocalDate nextDate= LocalDate.now().plusDays(1);
		String formatedDate=nextDate.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
		String date=formatedDate.substring(0, 2);
		System.out.print(date);
		
	}
	
}
