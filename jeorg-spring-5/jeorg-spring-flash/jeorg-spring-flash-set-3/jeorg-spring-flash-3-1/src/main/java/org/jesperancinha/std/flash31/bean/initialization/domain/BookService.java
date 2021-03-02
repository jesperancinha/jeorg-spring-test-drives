package org.jesperancinha.std.flash31.bean.initialization.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.RED;

public class BookService implements DisposableBean, InitializingBean {

    private Book book;

    @Override
    public void destroy() {
        RED.printGenericLn("This instance %s is going to be removed", this);
    }

    @Override
    public void afterPropertiesSet() {
        ORANGE.printGenericLn("Properties have been set! We only have one, and it is this book -> %s", book);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookService{" +
                "book=" + book +
                '}';
    }
}
