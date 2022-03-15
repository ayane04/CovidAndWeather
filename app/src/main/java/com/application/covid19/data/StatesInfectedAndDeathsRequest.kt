package com.application.covid19.data

import com.google.gson.Gson
import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import java.lang.Exception

import java.net.URL

class StatesInfectedAndDeathsRequest {
    /**
     * companion objects can be thought of as attributes, in this case we want an attribute that reflects the URL for our API request
     */
    companion object {
        private const val URL = "https://api.covid19api.com/live/country/united-states"
    }

    /**
     * Fetches [URL] and returns a [StatesInfectedAndDeathsResult]
     */
    fun getResult(): StatesInfectedAndDeathsResult? {

        try{
            val data = URL(URL).readText()
            return Gson().fromJson(data, StatesInfectedAndDeathsResult::class.java)
        }catch (exception: Exception){
            println(exception)
        }
        return null

    }

}


//package com.application.covid19.data
//
//import com.google.gson.Gson
//import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
//import java.lang.Exception
//
//import java.net.URL
//
//class StatesInfectedAndDeathsRequest {
//
//
//    fun getResult(): StatesInfectedAndDeathsResult? {
//
//
//        try{
//            var result : StatesInfectedAndDeathsResult =
//                ArrayList<StatesInfectedAndDeathsItem>() as StatesInfectedAndDeathsResult;
//            csvReader().open("src/main/res/raw/statesdata.csv") {
//                readAllAsSequence().forEach { row ->
//                    var temp : StatesInfectedAndDeathsItem = StatesInfectedAndDeathsItem(
//                        Integer.valueOf(row[1]),
//                        Integer.valueOf(row[2]),
//                        row[3],
//                        row[0])
//                    result.add(temp)
//                }
//            }
//            return result
//        }catch (exception: Exception){
//            println(exception)
//        }
//        return null
//    }
//
//}

