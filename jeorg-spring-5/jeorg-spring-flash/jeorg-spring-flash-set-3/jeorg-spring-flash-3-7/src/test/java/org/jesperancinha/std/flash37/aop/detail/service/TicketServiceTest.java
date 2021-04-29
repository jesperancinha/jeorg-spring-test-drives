package org.jesperancinha.std.flash37.aop.detail.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.jesperancinha.std.flash37.aop.detail.aspects.TicketAspectAfter;
import org.jesperancinha.std.flash37.aop.detail.aspects.TicketAspectAround;
import org.jesperancinha.std.flash37.aop.detail.aspects.TicketAspectBefore;
import org.jesperancinha.std.flash37.aop.detail.beans.TicketAfterBean;
import org.jesperancinha.std.flash37.aop.detail.beans.TicketAroundBean;
import org.jesperancinha.std.flash37.aop.detail.beans.TicketBeforeBean;
import org.jesperancinha.std.flash37.aop.detail.configuration.TicketConfiguration;
import org.jesperancinha.std.flash37.aop.detail.dto.TicketDto;
import org.jesperancinha.std.flash37.aop.detail.model.Ticket;
import org.jesperancinha.std.flash37.aop.detail.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        TicketConfiguration.class, TicketService.class,
        TicketAspectAfter.class, TicketAspectAround.class, TicketAspectBefore.class,
})
public class TicketServiceTest {

    @Autowired
    private TicketService ticketService;

    @MockBean
    private TicketRepository ticketRepository;

    @MockBean
    private TicketAfterBean ticketAfterBean;

    @MockBean
    private TicketAroundBean ticketAroundBean;

    @MockBean
    private TicketBeforeBean ticketBeforeBean;

    @Captor
    private ArgumentCaptor<JoinPoint> joinPointArgumentCaptor;

    @Captor
    private ArgumentCaptor<ProceedingJoinPoint> proceedingJoinPointArgumentCaptor;

    /**
     * In this unit test, only the around and after advices are executed by the aspect at the respective cutpoints.
     * None of the before's get executed.
     */
    @Test
    public void testCreateTicket() {
        when(ticketRepository.save(any(Ticket.class))).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        final var ticketDto = TicketDto
                .builder()
                .id(1L)
                .artist("Placebo")
                .show("Bearded Theory's Spring Gathering 2022")
                .uuid(UUID.randomUUID())
                .build();
        ticketService.createTicket(ticketDto);

        verify(ticketBeforeBean, never()).logBeforeTicket(joinPointArgumentCaptor.capture());
        verify(ticketBeforeBean, never()).logBeforeTicketNoAround(joinPointArgumentCaptor.capture());
        assertThat(joinPointArgumentCaptor.getAllValues()).hasSize(0);
        verify(ticketAroundBean, times(1)).aroundTicket(proceedingJoinPointArgumentCaptor.capture());
        assertThat(proceedingJoinPointArgumentCaptor.getAllValues()).hasSize(1);
        final var proceedingJoinPointArgumentCaptorValue = proceedingJoinPointArgumentCaptor.getValue();
        assertThat(proceedingJoinPointArgumentCaptorValue.getArgs()[0]).isSameAs(ticketDto);
        verify(ticketAfterBean, times(1)).logBeforeTicket(joinPointArgumentCaptor.capture());
        assertThat(joinPointArgumentCaptor.getAllValues()).hasSize(1);
        final var joinPointArgumentCaptorValue = joinPointArgumentCaptor.getValue();
        assertThat(joinPointArgumentCaptorValue.getArgs()[0]).isSameAs(ticketDto);
        verify(ticketAfterBean, never()).logBeforeTicketNoAround(joinPointArgumentCaptor.capture());
    }

    @Test
    public void testCreateTicketNoAround() {
    }
}