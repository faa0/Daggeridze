package com.fara.daggeridze.di.components

import android.app.Application
import com.fara.daggeridze.App
import com.fara.daggeridze.di.modules.ActivityModule
import com.fara.daggeridze.di.modules.RepositoryModule
import com.fara.daggeridze.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        RepositoryModule::class,
        ActivityModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        // provide Application instance into DI
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
}