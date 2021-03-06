package com.example.moneysaver.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moneysaver.data.db.entities.ClientModelClass
import com.example.moneysaver.data.db.entities.ExpenseModelClass

@Dao
interface ClientDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ClientModelClass)
    @Delete
    suspend fun delete(item: ClientModelClass)
    @Query("SELECT * FROM CLIENT where username like :username and password like:password ")
            fun  checkClient(username:String, password:String):LiveData<ClientModelClass>
    @Query("Select * from Client where id=:userId")
           fun   getCurrentUserData(userId:Int):LiveData<ClientModelClass>
   @Query("select salary from client where  id=:userId")
          fun getSalary(userId: Int):LiveData<Double>
   @Query("SELECT expenseLimit FROM client WHERE ID=:userId")
          fun getExpenseLimit(userId: Int):LiveData<Double>

}