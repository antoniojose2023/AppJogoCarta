package br.com.antoniojoseuchoa.appjogocarta.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.antoniojoseuchoa.appjogocarta.data.model.Card
import br.com.antoniojoseuchoa.appjogocarta.data.repository.RepositoryCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelCard @Inject constructor(private val repositoryCard: RepositoryCard): ViewModel() {
    private var _cards = MutableLiveData<List<Card>>()
    val cards: LiveData<List<Card>> = _cards

    init {
        getAllCards()
    }

    private fun getAllCards(){
          viewModelScope.launch {
              _cards.postValue(repositoryCard.getCards())
          }
    }

}