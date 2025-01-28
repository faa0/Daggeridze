package com.fara.daggeridze.data.repository

import android.app.Application
import com.fara.daggeridze.R

class TestRepositoryImpl(
    private val app: Application
) : TestRepository {

    override fun getTestString(): String {
        return app.getString(R.string.app_name)
    }
}