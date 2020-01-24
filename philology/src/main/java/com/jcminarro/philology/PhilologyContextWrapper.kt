package com.jcminarro.philology

import android.annotation.SuppressLint
import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.widget.VectorEnabledTintResources

@SuppressWarnings("RestrictedApi")
@SuppressLint("RestrictedApi")
internal class PhilologyContextWrapper(base: Context, overrideConf: Configuration? = null) : ContextWrapper(base) {
    private val res: Resources by lazy {
        val baseResources = super.getResources()
        if (VectorEnabledTintResources.shouldBeUsed()) {
            PhilologyVectorEnabledTintResources(this, baseResources)
        } else {
            PhilologyResources(baseResources, overrideConf)
        }
    }

    override fun getResources(): Resources = res
}