package com.example.myapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface SubscriptionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubscription(sub: SubscriptionEntity): Long

    @Query("SELECT expiration_date FROM subscriptions WHERE userId = :userId ORDER BY id DESC LIMIT 1")
    fun getLatestSubByUserId(userId: Long): Long?

    @Query("SELECT expiration_date FROM subscriptions WHERE userId = :userId ORDER BY id DESC LIMIT 1")
    fun loadLatestSubByUserId(userId: Long): Flow<Long?>

    @Query("SELECT COUNT(*) FROM subscriptions WHERE userId = :userId")
    fun loadSubscriptionByUserId(userId: Long): Flow<Int?>
}