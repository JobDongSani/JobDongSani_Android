package kr.hs.dgsw.jobdongsani_android

import android.app.Application
import android.content.Context

class JobDongSaniApp: Application() {

    companion object {
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}