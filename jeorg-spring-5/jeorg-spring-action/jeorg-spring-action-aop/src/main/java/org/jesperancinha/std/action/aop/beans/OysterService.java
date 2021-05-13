package org.jesperancinha.std.action.aop.beans;

import org.aspectj.lang.JoinPoint;
import org.jesperancinha.std.action.aop.model.Oyster;
import org.springframework.stereotype.Service;

@Service
public class OysterService {
    public void oysterProcessing(JoinPoint joinPoint, Oyster oyster) {

    }

    public void oysterQualityProcessing(JoinPoint joinPoint) {

    }
}
