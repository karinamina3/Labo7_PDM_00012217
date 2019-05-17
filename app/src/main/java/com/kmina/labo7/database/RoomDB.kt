package com.kmina.labo7.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kmina.labo7.database.daos.GithubRepoDAO
import com.kmina.labo7.database.entities.GithubRepo

@Database (entities = [GithubRepo::class], version = 1, exportSchema = false)       // Corchete -> entidades
public abstract class RoomDB : RoomDatabase() {

    abstract fun repoDAO() : GithubRepoDAO

    companion object {     //Singleton BASE
         @Volatile      // Para que todos los hilos se enteren del cambio
        private var INSTANCE:RoomDB?=null

        fun getInstance(
            context:Context
        ):RoomDB {
            val tempInstance = INSTANCE
            if (tempInstance!=null) {
                return tempInstance
            }

            synchronized(this){
                val instance = Room
                    .databaseBuilder(context, RoomDB::class.java, "Repo_DB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}

// La base es la misma siempre, se crea un dao, entity y repositorio por cada tabla de la base de datos