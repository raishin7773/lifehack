package com.raishin.lifehack.repository

import com.raishin.lifehack.domain.Lifehack
import com.raishin.lifehack.domain.LifehackExample
import com.raishin.lifehack.form.SearchForm
import com.raishin.lifehack.mapper.CustomLifehackMapper
import com.raishin.lifehack.mapper.LifehackMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class LifehackRepositoryImpl : LifehackRepository {

    @Autowired
    private lateinit var lifehackMapper: LifehackMapper

    @Autowired
    private lateinit var customlifehackMapper: CustomLifehackMapper

    override fun selectAll(): List<Lifehack> {
        val example = LifehackExample().apply {
            createCriteria()
        }
        return lifehackMapper.selectByExample(example)
    }

    override fun select(form: SearchForm): List<Lifehack> {
        val example = LifehackExample().apply {
            createCriteria().apply {
                if (form.title.isNotEmpty()) andTitleLike("%" + form.title + "%")
                if (form.category.isNotEmpty()) andCategoryEqualTo("%" + form.category + "%")
                if (form.description.isNotEmpty()) andDescriptionLike("%" + form.description + "%")
            }
        }
        return lifehackMapper.selectByExample(example)
    }

    /**
     * 件数を限定して条件なしでselect
     */
    override fun selectAllLimit(): List<Lifehack> {
        return customlifehackMapper.selectAllLimit()
    }
}