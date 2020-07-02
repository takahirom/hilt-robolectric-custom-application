package com.github.takahirom.hilt_robolectric_custom_application

import dagger.hilt.android.testing.CustomTestApplication
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@CustomTestApplication(BaseApp::class)
interface HiltTestApplication

@HiltAndroidTest
@RunWith(RobolectricTestRunner::class)
@Config(
    application = HiltTestApplication_Application::class,
    manifest = "src/main/AndroidManifest.xml"
)
class ExampleUnitTest {
    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}