package com.example.myapplication.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/example/myapplication/di/AppModule;", "", "()V", "provideMyDatabase", "Lcom/example/myapplication/data/MyDatabase;", "context", "Landroid/content/Context;", "provideSubscriptionDao", "Lcom/example/myapplication/data/SubscriptionDao;", "db", "provideSubscriptionDetailsDao", "Lcom/example/myapplication/data/SubscriptionDetailsDao;", "providesNavigator", "Lcom/example/myapplication/navigation/Navigator;", "providesSubRepository", "Lcom/example/myapplication/data/SubRepository;", "subscriptionDao", "subscriptionDetailsDao", "app_debug"})
@dagger.Module
public final class AppModule {
    @org.jetbrains.annotations.NotNull
    public static final com.example.myapplication.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.example.myapplication.data.SubRepository providesSubRepository(@org.jetbrains.annotations.NotNull
    com.example.myapplication.data.SubscriptionDao subscriptionDao, @org.jetbrains.annotations.NotNull
    com.example.myapplication.data.SubscriptionDetailsDao subscriptionDetailsDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.example.myapplication.data.MyDatabase provideMyDatabase(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.example.myapplication.data.SubscriptionDao provideSubscriptionDao(@org.jetbrains.annotations.NotNull
    com.example.myapplication.data.MyDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.example.myapplication.data.SubscriptionDetailsDao provideSubscriptionDetailsDao(@org.jetbrains.annotations.NotNull
    com.example.myapplication.data.MyDatabase db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.example.myapplication.navigation.Navigator providesNavigator() {
        return null;
    }
}