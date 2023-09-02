package br.com.antoniojoseuchoa.appjogocarta.data.repository

import android.util.Log
import br.com.antoniojoseuchoa.appjogocarta.data.api.HeathStoneApi
import br.com.antoniojoseuchoa.appjogocarta.data.model.Card
import retrofit2.Response
import javax.inject.Inject


class RespositoryCardImpl @Inject constructor(private val heathStoneApi: HeathStoneApi): RepositoryCard{
    override suspend fun getCards(): List<Card> {
        var response: Response<List<Card>>? = null

        try{
            response = heathStoneApi.getAllCard("hall of fame")

            if(response.isSuccessful){
                var card = response.body()
                card?.let {  cards ->
                    return cards
                }
            }

        }catch (ex: Exception){
            Log.i("erro api", "getCards: "+ex.message)
        }

        return emptyList()
    }

}