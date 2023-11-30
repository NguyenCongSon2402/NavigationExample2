package com.example.navigationexample.network.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("_id") var Id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("origin_name") var originName: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("thumb_url") var thumbUrl: String? = null,
    @SerializedName("sub_docquyen") var subDocquyen: Boolean? = null,
    @SerializedName("time") var time: String? = null,
    @SerializedName("episode_current") var episodeCurrent: String? = null,
    @SerializedName("quality") var quality: String? = null,
    @SerializedName("lang") var lang: String? = null,
    @SerializedName("year") var year: Int? = null,
    @SerializedName("category") var category: ArrayList<Category> = arrayListOf(),
    @SerializedName("country") var country: ArrayList<Country> = arrayListOf()
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        arrayListOf<Category>().apply {
            parcel.readList(this, Category::class.java.classLoader)
        },
        arrayListOf<Country>().apply {
            parcel.readList(this, Country::class.java.classLoader)
        }
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Id)
        parcel.writeString(name)
        parcel.writeString(slug)
        parcel.writeString(originName)
        parcel.writeString(type)
        parcel.writeString(thumbUrl)
        parcel.writeValue(subDocquyen)
        parcel.writeString(time)
        parcel.writeString(episodeCurrent)
        parcel.writeString(quality)
        parcel.writeString(lang)
        parcel.writeValue(year)
        parcel.writeList(category)
        parcel.writeList(country)
    }

    companion object CREATOR : Parcelable.Creator<Items> {
        override fun createFromParcel(parcel: Parcel): Items {
            return Items(parcel)
        }

        override fun newArray(size: Int): Array<Items?> {
            return arrayOfNulls(size)
        }
    }
}
