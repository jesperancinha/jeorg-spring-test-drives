package org.jesperancinha.std.old.webapp.service

import org.jesperancinha.std.old.webapp.model.DetailEntity
import org.jesperancinha.std.old.webapp.repository.DetailRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class DetailLayer2ServiceKotlinTest(
    @Autowired
    private val detailController: DetailLayer2Service,
    @Autowired
    private val detailRepository: DetailRepository,
) {
    @BeforeEach
    fun setUp() {
        detailRepository.deleteAll()
        addOneElement()
    }

    private fun addOneElement() {
        val detailEntity = DetailEntity.builder().id(1).name(NAME_1).city(CITY_1).build()
        detailRepository.save(detailEntity)
    }

    @Test
    fun `should ged details by id`() {
//        detailController.findDetailById(Integer.valueOf(1))
//            .shouldNotBeNull()
//            .apply {
//                name shouldBe NAME_1
//                city.shouldBeNull()
//            }
//        detailRepository.deleteAll()
//        detailRepository.findByIdOrNull(1)
//            .shouldBeNull()
//        detailController.findDetailById(1)
//            .shouldNotBeNull()
//            .apply {
//                name shouldBe NAME_1
//                city.shouldBeNull()
//            }
//        addOneElement()
//        detailRepository.findByIdOrNull(1)
//            .shouldNotBeNull()
//            .apply {
//                name shouldBe NAME_1
//                city.shouldBeNull()
//            }
//         detailRepository.findByIdOrNull(1)
//             .shouldNotBeNull()
//             .apply {
//                 name shouldBe NAME_1
//                 city.shouldBeNull()
//             }
    }

    companion object {
        private const val NAME_1 = "Name1"
        private const val CITY_1 = "City1"
    }
}