package com.example.myapplication.data;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\'\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\'J\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/example/myapplication/data/SubscriptionDetailsDao;", "", "getLatestDetailsBySubId", "", "subId", "(J)Ljava/lang/Long;", "insertSubDetails", "subDetails", "Lcom/example/myapplication/data/SubscriptionDetailsEntity;", "(Lcom/example/myapplication/data/SubscriptionDetailsEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLatestDetailsBySubId", "Lkotlinx/coroutines/flow/Flow;", "loadPurchasedSubsBySubId", "", "app_debug"})
public abstract interface SubscriptionDetailsDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insertSubDetails(@org.jetbrains.annotations.NotNull
    com.example.myapplication.data.SubscriptionDetailsEntity subDetails, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT expiration_date FROM subscriptions_details WHERE subId = :subId ORDER BY id DESC LIMIT 1")
    public abstract java.lang.Long getLatestDetailsBySubId(long subId);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT expiration_date FROM subscriptions_details WHERE subId = :subId ORDER BY id DESC LIMIT 1")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Long> loadLatestDetailsBySubId(long subId);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT COUNT(*) FROM subscriptions_details WHERE subId = :subId")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> loadPurchasedSubsBySubId(long subId);
}