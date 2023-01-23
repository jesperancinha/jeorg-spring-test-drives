package org.jesperancinha.std.action.aop.pickers;

public interface Picker<T> {

    T pickup(T t);

    T pickWithQuality(T t);
}
