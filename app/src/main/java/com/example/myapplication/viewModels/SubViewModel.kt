package com.example.myapplication.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.SubscriptionEntity
import com.example.myapplication.data.SubRepository
import com.example.myapplication.data.SubscriptionDetailsEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class SubViewModel @Inject constructor(
    private val repository: SubRepository
): ViewModel() {
    fun insertSub(
        subName: String,
        subValidity: Long
    ) {
        viewModelScope.launch {
            val subId = repository.insertSub(SubscriptionEntity(name = subName))
            if (subValidity > 0) {
                repository.insertSubDetails(
                    SubscriptionDetailsEntity(
                        expirationDate = (System.currentTimeMillis() + TimeUnit.DAYS.toMillis(30 * subValidity)),
                        subId = subId
                    )
                )
            }
        }
    }

    fun insertSubDetails(
        subId: Long,
        subValidity: Long
    ) {
        viewModelScope.launch {
            repository.insertSubDetails(
                SubscriptionDetailsEntity(
                    expirationDate = (System.currentTimeMillis() + TimeUnit.DAYS.toMillis(30 * subValidity)),
                    subId = subId
                )
            )
        }
    }

    fun getSubs(): List<SubscriptionEntity> = repository.getSubs()

    fun getSubById(id: Long) = repository.getSubById(id)

    fun getLatestDetailsBySubId(subId: Long): Long? = repository.getLatestSubDetailsBySubId(subId)

    val subsNumberStateFlow: StateFlow<Int> = repository.loadSubsNumber().stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000L), 0
    )

    fun loadPurchasedSubsBySubId(subId: Long): StateFlow<Int?> = repository.loadPurchasedSubsBySubId(subId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), 0)

    fun loadLatestDetailsBySubId(subId: Long): StateFlow<Long?> = repository.loadLatestDetailsBySubId(subId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), 0)
}