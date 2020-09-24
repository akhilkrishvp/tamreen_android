package com.q8.flowers.app.Network

/**
 * Created by diyaa on 10/2/17.
 */

import android.content.Context
import com.tamreen.core.Utilities.AppSettings
import com.tamreen.core.Utilities.Environment
import com.tamreen.network.ApiVersion
import okhttp3.MediaType

class ApiConfig(internal var context: Context) {
    private fun getBsaeUrl(apiVersion: ApiVersion = ApiVersion.V1): String {
        var finalUrl = "https://"
        if (AppSettings.environment == Environment.Live) {
            var env = when (apiVersion) {
                ApiVersion.V1 -> "sandbox.emaogroup.com"
                ApiVersion.V2 -> "sandbox.emaogroup.com"
            }
            finalUrl += env
        } else {
            var env = when (apiVersion) {
                ApiVersion.V1 -> "sandbox.emaogroup.com"
                ApiVersion.V2 -> "sandbox.emaogroup.com"
            }
            finalUrl += env
        }
        return finalUrl

    }


    fun getFullApi(apiVersion: ApiVersion = ApiVersion.V1): String {
        return getBsaeUrl(apiVersion) + getApiPath(apiVersion)
    }

    fun getApiPath(apiVersion: ApiVersion = ApiVersion.V1): String {
        var result = when (apiVersion) {
            ApiVersion.V1 -> ""
            ApiVersion.V2 -> ""
            else -> ""
        }
        return result
    }

    fun getApiURL(apiVersion: ApiVersion = ApiVersion.V1): String {
        return getFullApi(apiVersion) + "/"
    }


    companion object {
        val JSON = MediaType.parse("application/json; charset=utf-8")
    }


}

