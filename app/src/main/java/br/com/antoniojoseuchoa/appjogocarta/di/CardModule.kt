package br.com.antoniojoseuchoa.appjogocarta.di

import br.com.antoniojoseuchoa.appjogocarta.data.api.HeathStoneApi
import br.com.antoniojoseuchoa.appjogocarta.data.api.InterceptorCard
import br.com.antoniojoseuchoa.appjogocarta.data.repository.RepositoryCard
import br.com.antoniojoseuchoa.appjogocarta.data.repository.RespositoryCardImpl
import br.com.antoniojoseuchoa.appjogocarta.helper.Constantes
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import okhttp3.OkHttpClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit

@Module
@InstallIn(ViewModelComponent::class)
object CardModule {

     @Provides
     fun providerRetrofit(okHttpClient: OkHttpClient): Retrofit{
              return Retrofit.Builder()
                     .baseUrl(Constantes.BASE_URL)
                     .client(okHttpClient)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build()
     }

     @Provides
     fun proverOkHttpClient(): OkHttpClient{
          return OkHttpClient().newBuilder()
               .writeTimeout(5, TimeUnit.SECONDS)
               .readTimeout(5, TimeUnit.SECONDS)
               .connectTimeout(10, TimeUnit.SECONDS)
               .addInterceptor( InterceptorCard() )
               .build()
     }

    @Provides
    fun proverHeathStonesApi(retrofit: Retrofit): HeathStoneApi{
        return retrofit.create( HeathStoneApi::class.java )
    }

    @Provides
    fun proverRepositoryCard(heathStoneApi: HeathStoneApi): RepositoryCard{
        return RespositoryCardImpl(heathStoneApi)
    }
}