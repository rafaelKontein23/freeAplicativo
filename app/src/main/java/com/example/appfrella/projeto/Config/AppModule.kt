package com.example.appfrella.projeto.Config

import com.example.appfrella.projeto.Modulos.Cadastro.CadastroRepository
import com.example.appfrella.projeto.Modulos.Cadastro.CadastroServices
import com.example.appfrella.projeto.Modulos.Cadastro.SincronoCadastro
import com.example.appfrella.projeto.Utils.Constantes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constantes.urlApi)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideSincronoCadastro(retrofit: Retrofit): SincronoCadastro {
        return retrofit.create(SincronoCadastro::class.java)
    }

    @Provides
    @Singleton
    fun provideCadastroRepository(api: SincronoCadastro): CadastroRepository {
        return CadastroRepository(api)
    }

    // 🚨 ESSA PARTE AQUI É FUNDAMENTAL
    @Provides
    @Singleton
    fun provideCadastroServices(repository: CadastroRepository): CadastroServices {
        return CadastroServices(repository)
    }
}
