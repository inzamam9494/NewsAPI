package com.example.newsapi.data

// step 6
import com.example.newsapi.data.AppContains.BASE_URL
import com.example.newsapi.data.api.ApiService
import com.example.newsapi.data.dataResources.NewsDataResources
import com.example.newsapi.data.dataResources.NewsDataResourcesImp
import com.example.newsapi.ui.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

object AppContains {
    const val BASE_URL = "https://saurav.tech/NewsAPI/"
    const val COUNTRY_CODE = "in"
    const val CATEGORY = "health"
}

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun retrofitProvider(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
   fun provideApiService(retrofit: Retrofit): ApiService{
       return retrofit.create(ApiService::class.java)
   }

    @Provides
    @Singleton
    fun provideNewsResourceData(apiService: ApiService) : NewsDataResources{
        return NewsDataResourcesImp(apiService)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsDataResources: NewsDataResources) : NewsRepository{
        return NewsRepository(newsDataResources)
    }

}