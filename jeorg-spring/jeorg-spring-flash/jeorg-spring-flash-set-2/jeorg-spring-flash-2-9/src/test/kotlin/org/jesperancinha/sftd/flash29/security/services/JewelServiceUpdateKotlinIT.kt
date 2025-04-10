package org.jesperancinha.sftd.flash29.security.services

import com.ninjasquad.springmockk.MockkBean
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.slot
import io.mockk.verify
import org.jesperancinha.sftd.flash29.security.domain.Jewel
import org.jesperancinha.sftd.flash29.security.dto.JewelDto
import org.jesperancinha.sftd.flash29.security.repository.JewelRepository
import org.jesperancinha.sftd.flash29.security.services.JewelType.OPAL
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException
import org.springframework.security.test.context.support.WithMockUser

@SpringBootTest(webEnvironment = RANDOM_PORT)
internal class JewelServiceUpdateKotlinIT @Autowired constructor(
    @Autowired
    private val jewelService: JewelService
) {
    @MockkBean(relaxed = true)
    lateinit var jewelRepository: JewelRepository

    @BeforeEach
    fun setup(){
        every { jewelRepository.save(any()) } returns Jewel
            .builder()
            .jewelType(OPAL)
            .guardian("MegaKitten")
            .build()
    }
    @Test
    fun testUpdateJewel_whenNoAuthentication_thenFail() {
        val jewel = JewelDto
            .builder()
            .jewelType(OPAL)
            .guardian("Kitten")
            .build()
        shouldThrow<AuthenticationCredentialsNotFoundException> { jewelService.updateJewel(jewel) }
    }

    @Test
    @WithMockUser(username = "MegaKitten")
    fun testUpdateJewel_whenAuthenticationNoRoles_thenFail() {
        val jewel = JewelDto
            .builder()
            .jewelType(OPAL)
            .guardian("Kitten")
            .build()
        shouldThrow<AccessDeniedException> { jewelService.updateJewel(jewel) }
    }

    @Test
    @WithMockUser(username = "MegaKitten", roles = ["ADMIN"])
    fun testUpdateJewel_whenAuthenticationRolesGuardianUnMatch_thenFail() {
        val jewel = JewelDto
            .builder()
            .jewelType(OPAL)
            .guardian("Kitten")
            .build()
        shouldThrow<AccessDeniedException> { jewelService.updateJewel(jewel) }
    }

    @Test
    @WithMockUser(username = "MegaKitten", roles = ["ADMIN"])
    fun testUpdateJewel_whenAuthenticationRolesGuardiaMatch_thenOk() {
        val jewel = JewelDto
            .builder()
            .jewelType(OPAL)
            .guardian("MegaKitten")
            .build()
        val jewelResult = jewelService.updateJewel(jewel)
        jewelResult.jewelType shouldBe OPAL
        jewelResult.guardian shouldBe "MegaKitten"
        val slotJewel = slot<Jewel>()
        verify { jewelRepository.save(capture(slotJewel)) }
        slotJewel.captured
            .shouldNotBeNull()
            .apply {
                guardian shouldBe jewel.guardian
                jewelType shouldBe jewel.jewelType
            }
    }
}