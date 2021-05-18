package org.jesperancinha.std.old.model;

import org.jesperancinha.std.old.webapp.service.DetailLayer2Service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DetailControllerTest {

    @InjectMocks
    DetailLayer2Service detailController;

    @Test
    public void findDetailById() {
    }

}
