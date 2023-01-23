package org.jesperancinha.std.flash37.aop.detail.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class TicketConfiguration {
}
