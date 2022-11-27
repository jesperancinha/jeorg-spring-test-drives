package org.jesperancinha.std.action.mvc2.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.view.AbstractView;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_PDF_VALUE;

public class PdfView extends AbstractView {

    public PdfView(){
        setContentType(APPLICATION_PDF_VALUE);
    }
    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        final var writer = httpServletResponse.getWriter();
        writer.println(map.get("wow"));
    }
}
