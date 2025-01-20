package org.jesperancinha.sftd.flash18.aop.afterthrowing.service.impl;

import org.springframework.stereotype.Service;

/**
 * Service used as a source for the tested {@link org.aspectj.lang.annotation.Aspect} of this module.
 */
@Service
public class LyricsServiceImpl implements LyricsService {

    @Override
    public void enumerateLyric1() {
        throw new RuntimeException("One, don't pick up the phone");
    }

    @Override
    public void resultLyric1() {
        throw new RuntimeException("You know he's only calling 'cause he's drunk and alone");

    }

    @Override
    public void enumerateLyric2() {
        throw new RuntimeException("Two, don't let him in");

    }

    @Override
    public void resultLyric2() {
        throw new RuntimeException("You'll have to kick him out again");

    }

    @Override
    public void enumerateLyric3() {
        throw new RuntimeException("Three, don't be his friend");

    }

    @Override
    public void resultLyric3() {
        throw new RuntimeException("You know you're gonna wake up in his bed in the morning");

    }

    @Override
    public void resultLyric4() {
        throw new RuntimeException("And if you're under him, you ain't getting over him");
    }
}
