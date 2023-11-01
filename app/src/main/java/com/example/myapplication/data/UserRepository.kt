package com.example.myapplication.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userDao: UserDao,
    private val subscriptionDao: SubscriptionDao
) {
    fun getUsers(): List<UserEntity> = userDao.getUsers()
    fun getUserById(id: Long): UserEntity = userDao.getUserById(id)
    suspend fun insertUser(user: UserEntity) = userDao.insertUser(user)
    fun loadUsersNumber(): Flow<Int> = userDao.loadUsersNumber()

    suspend fun insertSubscription(sub: SubscriptionEntity) = subscriptionDao.insertSubscription(sub)

    fun getLatestSubByUserId(userId: Long): Long? = subscriptionDao.getLatestSubByUserId(userId)

    fun loadLatestSubByUserId(userId: Long): Flow<Long?> = subscriptionDao.loadLatestSubByUserId(userId)

    fun loadSubscriptionByUserId(userId: Long): Flow<Int?> = subscriptionDao.loadSubscriptionByUserId(userId)
}