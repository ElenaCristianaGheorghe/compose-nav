package com.example.myapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SubscriptionDetailsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubDetails(subDetails: SubscriptionDetailsEntity): Long

    @Query("SELECT expiration_date FROM subscriptions_details WHERE subId = :subId ORDER BY id DESC LIMIT 1")
    fun getLatestDetailsBySubId(subId: Long): Long?

    @Query("SELECT expiration_date FROM subscriptions_details WHERE subId = :subId ORDER BY id DESC LIMIT 1")
    fun loadLatestDetailsBySubId(subId: Long): Flow<Long?>

    @Query("SELECT COUNT(*) FROM subscriptions_details WHERE subId = :subId")
    fun loadPurchasedSubsBySubId(subId: Long): Flow<Int?>
}