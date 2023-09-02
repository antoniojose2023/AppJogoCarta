package br.com.antoniojoseuchoa.appjogocarta.presenter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.antoniojoseuchoa.appjogocarta.data.model.Card
import br.com.antoniojoseuchoa.appjogocarta.databinding.ItemCartaBinding
import com.squareup.picasso.Picasso

class AdapterCards(): RecyclerView.Adapter<AdapterCards.ViewHolderCard>() {

    var listCard = mutableListOf<Card>()
    var onclickItemCard : (Card) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCard {
        val layoutInflater = LayoutInflater.from( parent.context )
        val binding = ItemCartaBinding.inflate(layoutInflater, parent, false)
        return ViewHolderCard( binding )
    }

    override fun getItemCount() = listCard.size

    override fun onBindViewHolder(holder: ViewHolderCard, position: Int) {
        val item = listCard[position]
        //holder.bind( item )
        with(holder.binding){
            tvNomeCarta.text = item.name
            Picasso.get().load( item.img ).into( ivCartao )

            itemCard.setOnClickListener {
                onclickItemCard(item)
            }
        }

    }

    class ViewHolderCard(val binding: ItemCartaBinding): RecyclerView.ViewHolder(binding.root){

      //  val context = binding.root.context

//        fun bind(item: Card){
//            with(binding){
//                 tvNomeCarta.text = item.name
//                 Picasso.get().load( item.img ).into( ivCartao )
//
//                 itemCard.setOnClickListener {
//
//                 }
//            }
//        }
    }

}