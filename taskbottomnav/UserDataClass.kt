package com.example.taskbottomnav

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")

data class UserDataClass(

    @get:Bindable
    @ColumnInfo (name ="userName") var userName: String,

    @get:Bindable
    var password: String,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
): BaseObservable()

// BaseObservable - A class provided by the Android Data Binding Library that allows objects to be observed for changes in their properties.
// Serialization - the process of converting data used by an app to format that can be transferred over a network or stored in a database or file
// parcelable - parsing custom data structure between different components in app.
// parcel - A Parcel in Android is a container for a message for parcelable. It's essentially a lightweight way to package data for transfer.

/*, Parcelable { //

    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(userName)
        parcel.writeString(password)
        parcel.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserDataClass> {
        override fun createFromParcel(parcel: Parcel): UserDataClass {
            return UserDataClass(parcel)
        }

        override fun newArray(size: Int): Array<UserDataClass?> {
            return arrayOfNulls(size)
        }
    }
}*/