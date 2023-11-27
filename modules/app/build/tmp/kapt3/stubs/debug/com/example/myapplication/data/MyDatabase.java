package com.example.myapplication.data;

import java.lang.System;

@androidx.room.Database(entities = {com.example.myapplication.data.SubscriptionEntity.class, com.example.myapplication.data.SubscriptionDetailsEntity.class}, version = 1)
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/myapplication/data/MyDatabase;", "Landroidx/room/RoomDatabase;", "()V", "subscriptionDao", "Lcom/example/myapplication/data/SubscriptionDao;", "subscriptionDetailsDao", "Lcom/example/myapplication/data/SubscriptionDetailsDao;", "app_debug"})
public abstract class MyDatabase extends androidx.room.RoomDatabase {
    
    public MyDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.myapplication.data.SubscriptionDao subscriptionDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.myapplication.data.SubscriptionDetailsDao subscriptionDetailsDao();
}