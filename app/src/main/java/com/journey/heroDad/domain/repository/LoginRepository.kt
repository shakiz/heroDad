package com.journey.heroDad.domain.repository

import com.journey.heroDad.domain.model.todo.TodoData

interface LoginRepository {
    fun login()
    suspend fun getTodos() : TodoData
}