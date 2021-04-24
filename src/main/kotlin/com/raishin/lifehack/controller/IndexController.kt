package com.raishin.lifehack.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.raishin.lifehack.form.SearchForm
import com.raishin.lifehack.service.LifeHackService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.*
import java.lang.reflect.Method

@RestController
class IndexController {
    @Autowired
    private lateinit var lifeHackService: LifeHackService

    @GetMapping("/")
    fun index(): String {
        return "hello"
    }

    @GetMapping("/getAll")
    fun getAll(): String {
        val mapper = jacksonObjectMapper()
        // オブジェクトをJsonに変換する
        return mapper.writeValueAsString(lifeHackService.selectAllLimit())
    }

    // todo 条件でフィルタリングして結果を返す
    @PostMapping("/select")
    fun select(@RequestBody form: SearchForm): String {
        val mapper = jacksonObjectMapper()
        // オブジェクトをJsonに変換する
        return mapper.writeValueAsString(lifeHackService.select(form))
    }
}