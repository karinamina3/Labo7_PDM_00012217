package com.kmina.labo7.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kmina.labo7.database.entities.GithubRepo


@Dao
interface GithubRepoDAO{

    @Query("SELECT * FROM repos")
    fun getAll() : LiveData<List<GithubRepo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)   // Si ocurre un problema
    suspend fun insert(repo : GithubRepo)              // suspend -> Indica que solo se puede ejecutar en una co-rutina, sacarla del loop(hilo) principal

    @Query("DELETE FROM repos")
    fun nukeTable()

 }