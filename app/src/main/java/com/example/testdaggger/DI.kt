package com.example.testdaggger

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.*
import javax.inject.Singleton


@Module
abstract class MYModule {
    @Binds
    abstract fun bindViewModelFactory(factory: MyViewModelFactory): ViewModelProvider.Factory
}

@Component(modules = [MYModule::class])
interface MYComponent {
    fun inject(activity: MainActivity)
}

@Module
class AppModule {

}

@Component(modules = [AppModule::class])
interface AppComponent {

    //fun inject(app: App)


}
/*
lateinit var applicationComponent: MYComponent

    class App:Application(){
        override fun onCreate() {
            super.onCreate()
      //  applicationComponent=DaggerMYComponent.factory().create(this)
        }
    }
*/