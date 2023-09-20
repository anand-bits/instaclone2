package com.scaler.libimgur.apis

import com.example.libimgur.models.TagsResponse
import com.example.libimgur.apis.ImgurAPIv3
import junit.framework.TestCase.assertNotNull
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ImgurAPIv3Tests {
    private val client = OkHttpClient.Builder()
        .addInterceptor(Interceptor { chain ->
            val request: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Client-ID b75932ca4bebc95")
                .build()
            chain.proceed(request)
        })
        .build()

    private val retrofit = Retrofit.Builder().client(client)
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://api.imgur.com/3/")
        .build()

    private val api = retrofit.create(ImgurAPIv3::class.java)

    @Test
    fun getTagsWorking() {
        // Replace "YOUR_ACCESS_TOKEN" with your actual Imgur API access token
        val response = api.getTags().execute()

        // You can add further assertions or tests based on the response
       // assertNotNull(response.body())
       println(response.raw().toString())
       assertNotNull(response.body())

    }
}
