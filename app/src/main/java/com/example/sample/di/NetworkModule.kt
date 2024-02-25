package com.example.sample.di

import com.example.mvvmexample.util.network.CustomCallAdapterFactory
import com.example.sample.BuildConfig
import com.example.sample.data.api.MovieApiService
import com.example.sample.data.api.WordApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor, headerInterceptor: Interceptor
    ) = run {
        OkHttpClient.Builder().addInterceptor(loggingInterceptor).addInterceptor(headerInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor() = kotlin.run {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        loggingInterceptor
    }

    @Singleton
    @Provides
    fun provideHeaderInterceptor(): Interceptor = Interceptor { chain ->
        chain.run {
            proceed(
                request().newBuilder()
                    .addHeader("Authorization", "Bearer ${BuildConfig.TMDB_API_KEY}").build()
            )
        }
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) = run {
        Retrofit.Builder().client(okHttpClient).baseUrl(BuildConfig.TMDB_BASE_URL)
            .addCallAdapterFactory(CustomCallAdapterFactory()).addConverterFactory(
                Json {
                    isLenient = true
                    ignoreUnknownKeys = true // 지정되지 않은 key 값은 무시
                    coerceInputValues = true // default 값 설정
                    explicitNulls = false // 없는 필드는 null로 설정
                }.asConverterFactory("application/json".toMediaType())
            ).build()
    }

    @Provides
    @Singleton
    fun provideApiService(): WordApiService = WordApiService()


    @Provides
    @Singleton
    fun provideMovieApiService(retrofit: Retrofit): MovieApiService = retrofit.create(MovieApiService::class.java)

}