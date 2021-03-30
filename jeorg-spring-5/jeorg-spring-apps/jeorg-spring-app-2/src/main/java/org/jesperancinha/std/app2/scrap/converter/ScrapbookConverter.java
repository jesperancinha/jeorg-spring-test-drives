package org.jesperancinha.std.app2.scrap.converter;

import org.jesperancinha.std.app2.scrap.dto.ScrapbookDto;
import org.jesperancinha.std.app2.scrap.model.Scrapbook;

import java.util.Objects;

public class ScrapbookConverter {

    public static ScrapbookDto toScrapBookDto(final Scrapbook scrapBook) {
        if (Objects.isNull(scrapBook)) {
            return null;
        }
        final ScrapbookDto scrapBookDto = new ScrapbookDto();
        scrapBookDto.setId(scrapBook.getId());
        scrapBookDto.setName(scrapBook.getName());
        scrapBookDto.setScrapbookType(scrapBook.getScrapbookType());
        scrapBookDto.setPages(scrapBook.getPages());
        return scrapBookDto;
    }

    public static Scrapbook toScrapbook(final ScrapbookDto scrapBookDto) {
        final Scrapbook scrapbook = new Scrapbook();
        scrapbook.setId(scrapBookDto.getId());
        scrapbook.setName(scrapBookDto.getName());
        scrapbook.setScrapbookType(scrapBookDto.getScrapbookType());
        scrapbook.setPages(scrapBookDto.getPages());
        return scrapbook;
    }
}
