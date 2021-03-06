package org.jesperancinha.std.flash45.context;

import org.jesperancinha.console.consolerizer.html.HtmlComposer;
import org.jesperancinha.console.consolerizer.html.HtmlPWriter;
import org.jesperancinha.console.consolerizer.html.HtmlizerLinks;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
public class EnjoyTheSilenceController {

    @GetMapping(value = "/")
    public void home(final HttpServletResponse httpServletResponse) throws IOException {
        final PrintWriter writer = httpServletResponse.getWriter();
        final HtmlPWriter htmlPWriter = new HtmlPWriter(writer);
        HtmlComposer.out(" ").green("Enjoy The Silence").writeToHtml(htmlPWriter);
        htmlPWriter.printRawPrivateText(HtmlizerLinks.getYouTubeFrame("aGSKrC7dGcY"));
        HtmlComposer.out(" ")
                .magenta("WebApplicationInitializer won't work be cause it has been disabled as described in")
                .yellow("\nhttps://github.com/spring-projects/spring-boot/issues/522")
                .magenta(".")
                .green("This is the reason why we switch to ServletContextInitializer in this example.")
                .writeToHtml(htmlPWriter);
    }
}