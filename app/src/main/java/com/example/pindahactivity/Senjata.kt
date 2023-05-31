package com.example.pindahactivity

import android.os.Parcel
import android.os.Parcelable

data class Senjata (val imageSource:Int, val imageTitle: String, val imageDecs: String):
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageSource)
        parcel.writeString(imageTitle)
        parcel.writeString(imageDecs)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Senjata> {
        override fun createFromParcel(parcel: Parcel): Senjata {
            return Senjata(parcel)
        }

        override fun newArray(size: Int): Array<Senjata?> {
            return arrayOfNulls(size)
        }
    }
}