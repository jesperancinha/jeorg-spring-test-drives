package org.jesperancinha.std.flash5.persistence.domain;

import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.optional.shouldBePresent
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.transaction.annotation.Transactional

@DataJpaTest
@MockkBean(PotatoService::class)
@Transactional
class PotatoRepositoryMKTest(
    @Autowired
    val potatoRepository: PotatoRepository
) : WordSpec() {

    init {
        "testing Potatoes" should {
            "return new potato when making one"{
                val potato = Potato()
                val potatoSave = potatoRepository.save(potato)

                potatoSave.shouldNotBeNull()

                potatoSave.id.shouldNotBeNull()
                val id = potatoSave.id
                val optato2 = potatoRepository.findById(id)

                optato2.shouldBePresent()
                optato2.get().id shouldBe id
            }
        }
    }

}