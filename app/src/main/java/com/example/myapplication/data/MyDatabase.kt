package com.example.myapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SubscriptionEntity::class, SubscriptionDetailsEntity::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun subscriptionDao(): SubscriptionDao
    abstract fun subscriptionDetailsDao(): SubscriptionDetailsDao
}