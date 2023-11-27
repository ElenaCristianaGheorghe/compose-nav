package com.example.myapplication.data;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\'J!\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u000b\"\u00020\u0003H\'\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/example/myapplication/data/SubscriptionDao;", "", "getSubById", "Lcom/example/myapplication/data/SubscriptionEntity;", "id", "", "getSubs", "", "insertAll", "", "subs", "", "([Lcom/example/myapplication/data/SubscriptionEntity;)V", "insertSub", "sub", "(Lcom/example/myapplication/data/SubscriptionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadSubsNumber", "Lkotlinx/coroutines/flow/Flow;", "", "app_debug"})
public abstract interface SubscriptionDao {
    
    @androidx.room.Insert
    public abstract void insertAll(@org.jetbrains.annotations.NotNull
    com.example.myapplication.data.SubscriptionEntity... subs);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM subscriptions")
    public abstract java.util.List<com.example.myapplication.data.SubscriptionEntity> getSubs();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM subscriptions WHERE id = :id")
    public abstract com.example.myapplication.data.SubscriptionEntity getSubById(long id);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insertSub(@org.jetbrains.annotations.NotNull
    com.example.myapplication.data.SubscriptionEntity sub, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT COUNT(*) FROM subscriptions")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> loadSubsNumber();
}