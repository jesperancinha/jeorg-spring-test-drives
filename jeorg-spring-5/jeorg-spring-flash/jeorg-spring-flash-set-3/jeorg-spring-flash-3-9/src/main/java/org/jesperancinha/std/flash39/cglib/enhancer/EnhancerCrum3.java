package org.jesperancinha.std.flash39.cglib.enhancer;

import org.jesperancinha.console.consolerizer.console.Consolerizer;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.CYAN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs.printUnicornsLn;

public class EnhancerCrum3 {
    public static void main(String[] args) {

        Consolerizer.maxLineCharsGlobal = 200;
        final var bean = new Bean();
        bean.setMessage("I'm a bean!");

        CYAN.printGenericLn("Our bean is -> %s", bean);
        CYAN.printGenericLn("If we check the bean now, we do not have a proxy -> %s", bean.beanState());
        CYAN.printGenericLn("If we make another soup now, we do not have a proxy -> %s", bean.makeProtectedBeanSoup());


        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Bean.class);
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                if (method.getReturnType() == String.class && method.getName().equals("beanState")) {
                    return "This is a plant and no soup is made";
                }
                if (method.getName().equals("makeBeanSoup")) {
                    RED.printThrowableAndExit(new RuntimeException("A private method never gets intercepted"));
                    return "Soup would be made here, but this is never called";
                }
                if (method.getReturnType() == String.class && method.getName().equals("makeProtectedBeanSoup")) {
                    return "With the protected method we can still make a soup";
                } else {
                    return method.invoke(bean);
                }
            }
        });
        final var proxy = (Bean) enhancer.create();

        printUnicornsLn(100);
        CYAN.printGenericLn("Our bean is -> %s", proxy);
        CYAN.printGenericLn("If we check the bean now, we do have a proxy -> %s", proxy.beanState());
        CYAN.printGenericLn("If we pirate into the makeSoup we can confirm that it has never changed -> %s", proxy.makeBeanSoupPirate());
        CYAN.printGenericLn("If we make another soup now, we do have a proxy -> %s", proxy.makeProtectedBeanSoup());

    }
}
