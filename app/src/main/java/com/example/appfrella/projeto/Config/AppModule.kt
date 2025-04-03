package com.example.appfrella.projeto.Config

import com.example.appfrella.projeto.Modulos.Cadastro.CadastroRepository
import com.example.appfrella.projeto.Modulos.Cadastro.CadastroServices
import com.example.appfrella.projeto.Modulos.Cadastro.SincronoCadastro
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): SincronoCadastro {
        return RetrofitConfig().createService(SincronoCadastro::class.java)
    }

    @Provides
    @Singleton
    fun provideCadastroRepository(retrofit: SincronoCadastro): CadastroRepository {
        return CadastroRepository(retrofit)
    }

    @Provides
    @Singleton
    fun provideCadastroServices(cadastroRepository: CadastroRepository): CadastroServices {
        return CadastroServices(cadastroRepository)
    }
}