package com.example.moneysaver.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moneysaver.data.db.entities.ClientModelClass
import com.example.moneysaver.data.db.entities.ExpenseModelClass

@Database(entities = [ClientModelClass::class, ExpenseModelClass::class], version = 2)
abstract class MoneySaverDatabase : RoomDatabase() {

    abstract fun clientDao(): ClientDao
    abstract fun expensesDao(): ExpensesDao

    //abstract  fun
    companion object {
        @Volatile

        private var instance: MoneySaverDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { it }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MoneySaverDatabase::class.java,
            " Money Saver Database"
        ).fallbackToDestructiveMigration().build()

    }


}

