package com.example.weather.model

import android.os.Parcel
import android.os.Parcelable

@Suppress("DEPRECATION")
data class CurrentWeatherModel(
    val main: DataCurrent,
    val wind: Wind,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(DataCurrent::class.java.classLoader)!!,
        parcel.readParcelable(Wind::class.java.classLoader)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(main, flags)
        parcel.writeParcelable(wind, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CurrentWeatherModel> {
        override fun createFromParcel(parcel: Parcel): CurrentWeatherModel {
            return CurrentWeatherModel(parcel)
        }

        override fun newArray(size: Int): Array<CurrentWeatherModel?> {
            return arrayOfNulls(size)
        }
    }
}


data class Wind(
    val speed: Double
):Parcelable {
    constructor(parcel: Parcel) : this(parcel.readDouble())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(speed)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Wind> {
        override fun createFromParcel(parcel: Parcel): Wind {
            return Wind(parcel)
        }

        override fun newArray(size: Int): Array<Wind?> {
            return arrayOfNulls(size)
        }
    }
}


data class DataCurrent(
    val temp: Double,
    val pressure: Int,
    val humidity: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(temp)
        parcel.writeInt(pressure)
        parcel.writeInt(humidity)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataCurrent> {
        override fun createFromParcel(parcel: Parcel): DataCurrent {
            return DataCurrent(parcel)
        }

        override fun newArray(size: Int): Array<DataCurrent?> {
            return arrayOfNulls(size)
        }
    }
}

