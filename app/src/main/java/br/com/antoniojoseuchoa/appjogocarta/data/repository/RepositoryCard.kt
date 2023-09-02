package br.com.antoniojoseuchoa.appjogocarta.data.repository

import br.com.antoniojoseuchoa.appjogocarta.data.model.Card


interface RepositoryCard {
    suspend fun getCards(): List<Card>
}