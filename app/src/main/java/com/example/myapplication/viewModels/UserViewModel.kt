package com.example.myapplication.viewModels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.SubscriptionEntity
import com.example.myapplication.data.UserEntity
import com.example.myapplication.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
): ViewModel() {

    fun insertUser(
        userName: String,
        subValidity: Long
    ) {
        viewModelScope.launch {
            val userId = repository.insertUser(UserEntity(name = userName))
            if (subValidity > 0) {
                repository.insertSubscription(
                    SubscriptionEntity(
                        expirationDate = (System.currentTimeMillis() + TimeUnit.DAYS.toMillis(30 * subValidity)),
                        userId = userId
                    )
                )
            }
        }
    }

    fun insertSubscription(
        userId: Long,
        subValidity: Long
    ) {
        viewModelScope.launch {
            repository.insertSubscription(
                SubscriptionEntity(
                    expirationDate = (System.currentTimeMillis() + TimeUnit.DAYS.toMillis(30 * subValidity)),
                    userId = userId
                )
            )
        }
    }

    fun getUsers(): List<UserEntity> = repository.getUsers()

    fun getUserById(id: Long) = repository.getUserById(id)

    fun getLatestSubByUserId(userId: Long): Long? = repository.getLatestSubByUserId(userId)

    val usersNumberStateFlow: StateFlow<Int> = repository.loadUsersNumber().stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000L), 0
    )

    fun loadSubscriptionByUserId(userId: Long): StateFlow<Int?> = repository.loadSubscriptionByUserId(userId).stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000L), 0
    )

    fun loadLatestSubByUserId(userId: Long): StateFlow<Long?> = repository.loadLatestSubByUserId(userId).stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000L), 0
    )
}