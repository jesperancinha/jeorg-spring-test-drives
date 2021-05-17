package org.jesperancinha.std.action.mvc2.view;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

public class TextView extends AbstractView {

    public TextView() {
        super.setContentType(TEXT_HTML_VALUE);
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        final var writer = httpServletResponse.getWriter();
        writer.println(map.get("wow"));
    }

}
