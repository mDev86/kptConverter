package converter.kpt.utils;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;

public class Utils {

    public static String XmlGCToStr(XMLGregorianCalendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
        return sdf.format(calendar.toGregorianCalendar().getTime());
    }
}
