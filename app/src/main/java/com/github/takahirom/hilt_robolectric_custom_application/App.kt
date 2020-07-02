package com.github.takahirom.hilt_robolectric_custom_application

import android.app.Application
import dagger.Subcomponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ApplicationComponent


@Subcomponent
interface MySubcomponent {
    @Subcomponent.Factory
    interface DaggerFactory {
        fun create(): MySubcomponent
    }
}

@HiltAndroidApp
class App : BaseApp()

open class BaseApp : Application() {
    @InstallIn(ApplicationComponent::class)
    @EntryPoint
    interface AppEntryPoint {
        fun appComponentFactory(): MySubcomponent.DaggerFactory
    }
    lateinit var mySubcomponent :MySubcomponent

    override fun onCreate() {
        super.onCreate()
        val entryPoint = EntryPointAccessors.fromApplication(applicationContext,
            AppEntryPoint::class.java)
        mySubcomponent = entryPoint.appComponentFactory().create()
    }
}
