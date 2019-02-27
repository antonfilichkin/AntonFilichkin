package hw7.sections;

import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.complex.DataList;

public class LogSidebar {
    @Css(".logs")
    DataList logs;

    @Css(".results")
    DataList results;

    public void checkLog(String... expectedLog) {
        System.out.println();
    }

    public void checkResults(){
        System.out.println("f");
    }
}
