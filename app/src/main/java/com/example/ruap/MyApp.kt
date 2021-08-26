package com.example.ruap

import android.app.Application
//import com.example.ruap.di.appModules
//import com.example.ruap.di.networkModule
//import com.example.ruap.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
//        startKoin(){
//            androidContext(this@MyApp)
//            modules(viewModelModules, appModules, networkModule)
//        }
    }

    companion object{
        lateinit var context : MyApp
            private set
    }
}