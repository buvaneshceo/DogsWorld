package com.example.dogsworld

import android.os.Parcel
import android.os.Parcelable

data class Dogs(val image:Int , val name:String,val desc:String , val detailImage:Int):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeString(desc)
        parcel.writeInt(detailImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dogs> {
        override fun createFromParcel(parcel: Parcel): Dogs {
            return Dogs(parcel)
        }

        override fun newArray(size: Int): Array<Dogs?> {
            return arrayOfNulls(size)
        }
    }
}
