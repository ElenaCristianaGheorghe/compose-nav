package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.MyDatabase
import com.example.myapplication.data.SubscriptionDao
import com.example.myapplication.data.UserDao
import com.example.myapplication.data.UserRepository
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
    fun providesUserRepository(userDao: UserDao, subscriptionDao: SubscriptionDao): UserRepository {
        return UserRepository(userDao, subscriptionDao)
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
    fun provideUserDao(db: MyDatabase) = db.userDao()

    @Provides
    @Singleton
    fun provideSubscriptionDao(db: MyDatabase) = db.subscriptionDao()
}