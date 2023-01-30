package org.jesperancinha.std.flash219.beans.configuration

import com.ninjasquad.springmockk.MockkBean
import io.mockk.verify
import jakarta.annotation.PreDestroy
import org.jesperancinha.console.consolerizer.common.ConsolerizerColor.*
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.jesperancinha.std.flash219.beans.domain.Nut
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [NutsConfiguration::class, NutsMethodsConfigurationKotlinTest.NutsTestConfiguration::class])
internal class NutsMethodsConfigurationKotlinTest(
    @Autowired
    var almond: Nut,
    @Autowired
    var applicationContext: ApplicationContext
) {

    @MockkBean(relaxed = true)
    lateinit var nutExtended: NutExtended

    @Test
    fun almond() {
        ConsolerizerComposer.outSpace()
            .orange(almond)
            .orange(nutExtended)
            .reset()
        verify { nutExtended.initiate() }
    }

    @Configuration
    class NutsTestConfiguration @Autowired constructor(
        @Autowired
        val nutExtended: NutExtended
    ) {

        @Bean
        @Primary
        @Qualifier("nut")
        fun nut(): NutExtended {
            return NutExtended()
        }

        @PreDestroy
        fun check() {
            verify { nutExtended.goToCake() }
        }
    }

    @Configuration
    class NutExtended : Nut() {
        fun goToCake() {
            BROWN.printGenericLn("Going to cake...")
        }

        fun initiate() {
            ORANGE.printGenericLn("Creating %s", toString())
        }
    }
}