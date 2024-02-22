package com.example.sample.di

import com.example.sample.data.repository.WordRepository
import com.example.sample.data.repository.WordRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindWordRepository(wordRepositoryImpl: WordRepositoryImpl): WordRepository

}