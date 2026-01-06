package com.journey.heroDad.data.repository

import com.journey.heroDad.domain.model.todo.TodoData
import com.journey.heroDad.domain.repository.LoginRepository
import com.journey.heroDad.domain.service.LoginService


class LoginRepositoryImpl(private val loginService: LoginService) : LoginRepository {

    override fun login() {
        TODO("Not yet implemented")
    }

    override suspend fun getTodos() : TodoData {
        return loginService.getTodos().let {
            it.body() as TodoData
        }
    }
}