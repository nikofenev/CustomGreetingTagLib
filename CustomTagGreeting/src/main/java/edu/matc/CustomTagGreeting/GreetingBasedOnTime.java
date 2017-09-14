package edu.matc.CustomTagGreeting;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GreetingBasedOnTime extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        JspWriter out = getJspContext().getOut();

        GregorianCalendar time = new GregorianCalendar();
        int hour = time.get(Calendar.HOUR_OF_DAY);
        int min = time.get(Calendar.MINUTE);
        int day = time.get(Calendar.DAY_OF_MONTH);
        int month = time.get(Calendar.MONTH) + 1;
        int year = time.get(Calendar.YEAR);

        out.println("The current time is \t" + hour + ":" + min);
        out.println("Today's date is \t" + month + "/" + day + "/"
                + year);

        if (hour < 12)
            out.println("- Good Morning");
        else if (hour < 17 && !(hour == 12))
            out.println("- Good Afternoon");
        else if (hour == 12)
            out.println("- Good Noon");
        else
            out.println("- Good Evening");

        if (month == 10 && day == 31) {
            out.println(" and Happy Halloween!");
        }
    }

}
