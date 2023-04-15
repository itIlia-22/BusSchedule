package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Абстрактный класс как Держатель для БД
@Database(entities = [BusSchedule::class], version = 1)
abstract class BusScheduleDatabase() : RoomDatabase() {

    abstract fun busSchedule(): BusScheduleDao

    /**
     * [Volatile]: означает, что записи в это поле немедленно становятся видимыми для других потоков.
     */
    companion object {
        @Volatile
        private var INSTANCE: BusScheduleDatabase? = null

        fun getBusSchedule(context: Context): BusScheduleDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    BusScheduleDatabase::class.java,
                    name = "app_database"
                )
                    .createFromAsset("database/bus_schedule.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}