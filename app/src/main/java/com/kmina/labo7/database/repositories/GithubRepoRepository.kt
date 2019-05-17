package com.kmina.labo7.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.kmina.labo7.database.daos.GithubRepoDAO
import com.kmina.labo7.database.entities.GithubRepo

class GithubRepoRepository(private val repoDAO : GithubRepoDAO) {

    fun getAll():LiveData<List<GithubRepo>> = repoDAO.getAll()

    fun nuke() = repoDAO.nukeTable()

    @WorkerThread
    // Una suspend fun da error si no la llama otra suspend fun o co-rutina
    suspend fun insert(repo : GithubRepo) = repoDAO.insert(repo)

}