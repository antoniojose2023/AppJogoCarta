package br.com.antoniojoseuchoa.appjogocarta.presenter.ui

import android.net.Uri.Builder
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.antoniojoseuchoa.appjogocarta.R
import br.com.antoniojoseuchoa.appjogocarta.data.model.Card
import br.com.antoniojoseuchoa.appjogocarta.databinding.ActivityDetalhesCardBinding
import com.squareup.picasso.Picasso

class DetalhesCardActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetalhesCardBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bundle = intent.extras

        val card = if(VERSION.SDK_INT >= VERSION_CODES.TIRAMISU){
             bundle?.getSerializable("carta", Card::class.java) as Card
        }else{
            bundle?.getSerializable("carta") as Card
        }

        if(card != null)
           popularTelaDetalhe(card)

    }

    fun popularTelaDetalhe(card: Card){
        binding.tvNomeCartaDetalhe.text = card.name
        binding.tvDescricaoLongaDetalhe.text = card.flavor
        binding.tvDescricaoCurtaDetalhe.text = card.text
        binding.tvAtaqueDetalhe.text = card.playerClass
        binding.tvCustoDetalhe.text = card.artist
        binding.tvConjuntoPertecenteDetalhe.text = card.cardSet
        binding.tvFaccaoDetalhe.text = card.spellSchool
        binding.tvHearthDetalhe.text = card.artist
        binding.tvRaridadeDetalhe.text = card.rarity
        binding.tvTipoDetalhe.text = card.type

        Picasso.get().load(card.img).into(binding.ivCartaDetalhe)

    }
}