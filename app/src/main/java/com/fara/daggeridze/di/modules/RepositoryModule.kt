package com.fara.daggeridze.di.modules

import android.app.Application
import com.fara.daggeridze.data.repository.TestRepository
import com.fara.daggeridze.data.repository.TestRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
internal class RepositoryModule {

    @Provides
    fun provideTestRepository(app: Application): TestRepository {
        return TestRepositoryImpl(app)
    }
}