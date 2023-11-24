package com.example.myapplication.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SubRepository @Inject constructor(
    private val subDao: SubscriptionDao,
    private val subDetailsDao: SubscriptionDetailsDao
) {
    fun getSubs(): List<SubscriptionEntity> = subDao.getSubs()
    fun getSubById(id: Long): SubscriptionEntity = subDao.getSubById(id)
    suspend fun insertSub(sub: SubscriptionEntity) = subDao.insertSub(sub)
    fun loadSubsNumber(): Flow<Int> = subDao.loadSubsNumber()

    suspend fun insertSubDetails(subDetails: SubscriptionDetailsEntity) = subDetailsDao.insertSubDetails(subDetails)

    fun getLatestSubDetailsBySubId(subId: Long): Long? = subDetailsDao.getLatestDetailsBySubId(subId)

    fun loadLatestDetailsBySubId(subId: Long): Flow<Long?> = subDetailsDao.loadLatestDetailsBySubId(subId)

    fun loadPurchasedSubsBySubId(subId: Long): Flow<Int?> = subDetailsDao.loadPurchasedSubsBySubId(subId)
}