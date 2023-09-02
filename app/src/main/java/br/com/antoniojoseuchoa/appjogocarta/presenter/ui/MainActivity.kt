package br.com.antoniojoseuchoa.appjogocarta.presenter.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.antoniojoseuchoa.appjogocarta.data.model.Card
import br.com.antoniojoseuchoa.appjogocarta.databinding.ActivityMainBinding
import br.com.antoniojoseuchoa.appjogocarta.presenter.AdapterCards
import br.com.antoniojoseuchoa.appjogocarta.presenter.viewmodel.ViewModelCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModelCard by viewModels<ViewModelCard>()
    private val adapterCard by lazy { AdapterCards() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapterCard.onclickItemCard = { card ->
            val intent = Intent(this, DetalhesCardActivity::class.java)
            intent.putExtra("carta", card)
            startActivity(intent)
        }

    }

    override fun onStart() {
         super.onStart()
         exibirCartas()
    }

    fun exibirCartas(){
        viewModelCard.cards.observe(this){ cards ->
            var novaLista = mutableListOf<Card>()

            cards.forEach {
                if(it.img != null){
                     novaLista.add(it)
                }
            }

            if(novaLista.isNotEmpty()){
                adapterCard.listCard = novaLista
            }

            binding.rvCartas.adapter = adapterCard
        }
    }
}