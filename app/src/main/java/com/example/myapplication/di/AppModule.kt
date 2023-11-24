package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.MyDatabase
import com.example.myapplication.data.SubscriptionDao
import com.example.myapplication.data.SubscriptionDetailsDao
import com.example.myapplication.data.SubRepository
import com.example.myapplication.navigation.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesSubRepository(subscriptionDao: SubscriptionDao, subscriptionDetailsDao: SubscriptionDetailsDao): SubRepository {
        return SubRepository(subscriptionDao, subscriptionDetailsDao)
    }

    @Provides
    @Singleton
    fun provideMyDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, MyDatabase::class.java, "MyDatabase")
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideSubscriptionDao(db: MyDatabase) = db.subscriptionDao()

    @Provides
    @Singleton
    fun provideSubscriptionDetailsDao(db: MyDatabase) = db.subscriptionDetailsDao()


    @Singleton
    @Provides
    fun providesNavigator() = Navigator()
}