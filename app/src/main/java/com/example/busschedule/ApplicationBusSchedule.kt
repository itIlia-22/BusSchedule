package com.example.busschedule

import android.app.Application
import com.example.busschedule.data.BusScheduleDatabase

class ApplicationBusSchedule : Application() {
    val dataBase: BusScheduleDatabase by lazy { BusScheduleDatabase.getBusSchedule(this) }
}