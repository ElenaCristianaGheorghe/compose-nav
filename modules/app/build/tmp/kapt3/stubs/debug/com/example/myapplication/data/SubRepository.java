package com.example.myapplication.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fJ\u0019\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00182\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00182\u0006\u0010\t\u001a\u00020\bJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/example/myapplication/data/SubRepository;", "", "subDao", "Lcom/example/myapplication/data/SubscriptionDao;", "subDetailsDao", "Lcom/example/myapplication/data/SubscriptionDetailsDao;", "(Lcom/example/myapplication/data/SubscriptionDao;Lcom/example/myapplication/data/SubscriptionDetailsDao;)V", "getLatestSubDetailsBySubId", "", "subId", "(J)Ljava/lang/Long;", "getSubById", "Lcom/example/myapplication/data/SubscriptionEntity;", "id", "getSubs", "", "insertSub", "sub", "(Lcom/example/myapplication/data/SubscriptionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSubDetails", "subDetails", "Lcom/example/myapplication/data/SubscriptionDetailsEntity;", "(Lcom/example/myapplication/data/SubscriptionDetailsEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLatestDetailsBySubId", "Lkotlinx/coroutines/flow/Flow;", "loadPurchasedSubsBySubId", "", "loadSubsNumber", "app_debug"})
@javax.inject.Singleton
public final class SubRepository {
    private final com.example.myapplication.data.SubscriptionDao subDao = null;
    private final com.example.myapplication.data.SubscriptionDetailsDao subDetailsDao = null;
    
    @javax.inject.Inject
    public SubRepository(@org.jetbrains.annotations.NotNull
    com.example.myapplication.data.SubscriptionDao subDao, @org.jetbrains.annotations.NotNull
    com.example.myapplication.data.SubscriptionDetailsDao subDetailsDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.myapplication.data.SubscriptionEntity> getSubs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.myapplication.data.SubscriptionEntity getSubById(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertSub(@org.jetbrains.annotations.NotNull
    com.example.myapplication.data.SubscriptionEntity sub, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> loadSubsNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertSubDetails(@org.jetbrains.annotations.NotNull
    com.example.myapplication.data.SubscriptionDetailsEntity subDetails, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getLatestSubDetailsBySubId(long subId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Long> loadLatestDetailsBySubId(long subId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> loadPurchasedSubsBySubId(long subId) {
        return null;
    }
}