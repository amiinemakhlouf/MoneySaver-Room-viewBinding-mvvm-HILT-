package com.example.moneysaver.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moneysaver.data.db.entities.ClientModelClass
@Dao
interface ClientDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ClientModelClass)
    @Delete
    suspend fun delete(item: ClientModelClass)
    @Query("SELECT * FROM CLIENT where username like :username and password like:password ")
            fun  clientExists(username:String, password:String):LiveData<ClientModelClass>

}