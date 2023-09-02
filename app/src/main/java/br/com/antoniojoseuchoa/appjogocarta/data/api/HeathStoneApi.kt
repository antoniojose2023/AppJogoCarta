package br.com.antoniojoseuchoa.appjogocarta.data.api

import br.com.antoniojoseuchoa.appjogocarta.data.model.Card
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Path

interface HeathStoneApi {
    @GET("cards/sets/{set}")
    suspend fun getAllCard(@Path("set") set: String ): Response<List<Card>>
}