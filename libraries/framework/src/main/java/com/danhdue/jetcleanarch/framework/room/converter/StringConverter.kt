package com.danhdue.jetcleanarch.framework.room.converter

import androidx.room.TypeConverter
import com.danhdue.jetcleanarch.framework.extension.fromJson
import com.danhdue.jetcleanarch.framework.extension.toJson

class StringConverter {
    @TypeConverter
    fun toListOfStrings(stringValue: String): List<String>? {
        return stringValue.fromJson()
    }

    @TypeConverter
    fun fromListOfStrings(listOfString: List<String>?): String {
        return listOfString.toJson()
    }
}
