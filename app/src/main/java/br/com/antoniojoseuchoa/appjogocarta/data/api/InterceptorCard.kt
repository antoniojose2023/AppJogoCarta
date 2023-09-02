package br.com.antoniojoseuchoa.appjogocarta.data.api

import okhttp3.Interceptor
import okhttp3.Response

class InterceptorCard: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
         val novaRequicao = chain.request().newBuilder()

         novaRequicao.addHeader(
             "X-RapidAPI-Key", "a69084a6c4msh914f0c7eb799d9ap151fbcjsn7ed18a76d69e"
         )

        novaRequicao.addHeader(
            "X-RapidAPI-Host", "omgvamp-hearthstone-v1.p.rapidapi.com"
        )

         return chain.proceed( novaRequicao.build())
    }
}