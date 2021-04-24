package com.raishin.lifehack.resolver

import com.raishin.lifehack.domain.Lifehack
import com.raishin.lifehack.form.SearchForm
import com.raishin.lifehack.repository.LifehackRepository
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Transactional
@Component
class LifehackQueryResolver : GraphQLQueryResolver {

    @Autowired
    private lateinit var lifehackRepository: LifehackRepository

    /**
     * 行数を100件までに限定してテーブルを全検索
     */
    fun getLifehackAllLimit(): List<Lifehack> {
        return lifehackRepository.selectAllLimit()
    }

    fun select(searchForm: SearchForm): List<Lifehack> {
        return lifehackRepository.select(searchForm)
    }
}