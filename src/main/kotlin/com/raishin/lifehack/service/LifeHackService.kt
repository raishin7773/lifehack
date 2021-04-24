package com.raishin.lifehack.service

import com.raishin.lifehack.domain.Lifehack
import com.raishin.lifehack.form.SearchForm
import com.raishin.lifehack.mapper.LifehackMapper
import com.raishin.lifehack.repository.LifehackRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class LifeHackService {
    @Autowired
    private lateinit var lifehackRepository: LifehackRepository

    fun selectAll(): List<Lifehack> {
        return lifehackRepository.selectAll()
    }

    fun select(form:SearchForm): List<Lifehack> {
        return lifehackRepository.select(form)
    }

    /**
     * 行数を100件までに限定してテーブルを全検索
     */
    fun selectAllLimit(): List<Lifehack> {
        return lifehackRepository.selectAllLimit()
    }
}