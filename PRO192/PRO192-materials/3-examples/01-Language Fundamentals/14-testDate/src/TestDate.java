
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

public Date ymdToDate(int xYear, int xMonth, int xDate) {
    Date x = new Date(xYear-1900, xMonth-1, xDate);
    return(x);
 }

public String dateToDmyString(Date x) {
    SimpleDateFormat t = new SimpleDateFormat("dd/MM/yyyy");
    String y = t.format(x);
    return(y);
 }
    
}
