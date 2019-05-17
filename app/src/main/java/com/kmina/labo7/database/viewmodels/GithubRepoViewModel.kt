package com.kmina.labo7.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.kmina.labo7.database.RoomDB
import com.kmina.labo7.database.entities.GithubRepo
import com.kmina.labo7.database.repositories.GithubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app:Application):AndroidViewModel(app){

    private val repository : GithubRepoRepository

    init {          // Primer código al inicio despues de llamar al constructor y settear las variables
        val repoDao = RoomDB.getInstance(app).repoDAO()
        repository = GithubRepoRepository(repoDao)
    }

    fun getAll() : LiveData<List<GithubRepo>> = repository.getAll()

    fun insert(repo : GithubRepo) = viewModelScope.launch(Dispatchers.IO){      //launch -> iniciar corutina;  dispatchers -> dan el hilo especifico para trabajar

    }
}