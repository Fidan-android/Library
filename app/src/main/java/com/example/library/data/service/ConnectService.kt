package com.example.library.data.service

import android.content.Context
import android.util.Log
import java.io.File
import java.io.FileOutputStream

class ConnectService {

    companion object {
        fun getJsonFromAssets(applicationContext: Context, fileName: String): String {
            val jsonString: String
            try {
                jsonString = applicationContext.assets
                    .open(fileName).bufferedReader().use {
                        it.readText()
                    }
            } catch (ex: Exception) {
                ex.printStackTrace()
                return ex.message!!
            }

            return jsonString
        }

        fun getJsonFromInternalStorage(applicationContext: Context, fileName: String): String {
            val files = applicationContext.filesDir.listFiles()
            files.forEach {
                Log.d("FILES", it.name)
            }


            files.map {
                Log.d("DATA", it.readText())
            }

            return if (files!!.isEmpty()) {
                ""
            } else {
                val temps = files.filter {
                    it.name == fileName
                }
                files[0].readText()
            }
        }

        fun saveJsonToInternalStorage(applicationContext: Context, dataString: String, fileName: String) {
            try {
                val file: File = File(applicationContext.filesDir.path + "/" + fileName)
                file.createNewFile()
                val writer = FileOutputStream(file, false)
                writer.write(dataString.toByteArray())
                writer.close()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }
}