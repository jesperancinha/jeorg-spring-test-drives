package org.jesperancinha.std.app2.scrap.service;

import org.jesperancinha.std.app2.scrap.dto.ScrapbookDto;

import java.util.List;

public interface ScrapbookReadService {

    ScrapbookDto getBookById(final Long id);

    List<ScrapbookDto> getAllScrapBooks();

    List<ScrapbookDto> getScrapbooksByName(String name);
}