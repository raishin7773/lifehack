package com.raishin.lifehack.repository

import com.raishin.lifehack.domain.Lifehack
import com.raishin.lifehack.form.SearchForm

interface LifehackRepository {
    fun select(form: SearchForm): List<Lifehack>
    fun selectAll(): List<Lifehack>
    fun selectAllLimit(): List<Lifehack>
}