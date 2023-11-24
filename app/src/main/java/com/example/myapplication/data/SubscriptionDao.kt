package com.example.myapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SubscriptionDao {
    @Insert
    fun insertAll(vararg subs: SubscriptionEntity)

    @Query("SELECT * FROM subscriptions")
    fun getSubs(): List<SubscriptionEntity>

    @Query("SELECT * FROM subscriptions WHERE id = :id")
    fun getSubById(id: Long): SubscriptionEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSub(sub: SubscriptionEntity): Long

    @Query("SELECT COUNT(*) FROM subscriptions")
    fun loadSubsNumber(): Flow<Int>
}