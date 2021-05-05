package org.jesperancinha.std.flash213.testing.repositories;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.flash213.testing.model.Cake;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
// if @DataJpaTest is commented you get:
//org.springframework.beans.factory.UnsatisfiedDependencyException:
// Error creating bean with name 'org.jesperancinha.std.flash213.testing.repository.CakeRepositoryTest':
// Unsatisfied dependency expressed through field 'cakeRepository';
// nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException:
// No qualifying bean of type 'org.jesperancinha.std.flash213.testing.repository.CakeRepository' available:
// expected at least 1 bean which qualifies as autowire candidate. Dependency annotations:
// {@org.springframework.beans.factory.annotation.Autowired(required=true)}
public class CakeRepositoryTest {

    @Autowired
    private CakeRepository cakeRepository;


    @Before
    public void setUp() {
        final var cake = new Cake();
        cake.setLocale(new Locale("pt-PT", "PTR"));
        cake.setName("Bolo de Chila");
        cakeRepository.save(cake);
    }

    @Test
    public void testGetCake_whenGoodId_thenGetCake() {
        final Optional<Cake> optionalCake = cakeRepository.findById(1L);

        assertThat(optionalCake.isPresent()).isTrue();

        ConsolerizerComposer.outSpace()
                .magenta("We run a %s test", DataJpaTest.class.getCanonicalName())
                .magenta("This is probably the easiest way to test that our JPA repositories work correctly")
                .blue("In our case we get:")
                .jsonPrettyPrint(optionalCake)
                .jsonPrettyPrint(optionalCake.get())
                .green("From the database")
                .reset();

        final Cake actual = optionalCake.get();
        assertThat(actual.getId()).isEqualTo(1L);
        assertThat(actual.getName()).isEqualTo("Bolo de Chila");
        assertThat(actual.getLocale()).isEqualTo(new Locale("pt-PT", "PTR"));
    }
}