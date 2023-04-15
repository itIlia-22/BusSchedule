package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {

    /**
     * Методы для запросов из БД(Таблицы)
     * [getBusSchedule] получчаем название остановки при нажатии на остановку и время
     * [getAllBusSchedule] получаем список все остановок
     */
    @Query("SELECT * FROM schedule WHERE stop_Name = :stopName  ORDER BY arrival_time ASC")
    fun getBusSchedule(stopName: String): Flow<List<BusSchedule>>

    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC ")
    fun getAllBusSchedule(): Flow<List<BusSchedule>>
}