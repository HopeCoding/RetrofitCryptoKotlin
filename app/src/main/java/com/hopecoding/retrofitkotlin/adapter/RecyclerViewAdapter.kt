package com.hopecoding.retrofitkotlin.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hopecoding.retrofitkotlin.databinding.ItemRowBinding
import com.hopecoding.retrofitkotlin.model.CryptoModel

class RecyclerViewAdapter(
    private val cryptoList: ArrayList<CryptoModel>,
    private val listener: Listener,
) :
    RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {


    interface Listener {
        fun onItemClick(cryptoModel: CryptoModel)
    }


    class RowHolder(private val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(cryptoModel: CryptoModel, position: Int, listener: Listener) {
            binding.textCryptoId.setOnClickListener {
                listener.onItemClick(cryptoModel)
            }
            binding.textCryptoId.text = cryptoModel.asset_id
            binding.textCryptoName.text = "Name:" + cryptoModel.name + " / /"
            binding.textCryptoPrice.text = "Crypto Price(USD):" + cryptoModel.price_usd + " / /"
            binding.textCryptoVolume1h.text =
                "Crypto Volume(1Hour):" + cryptoModel.volume_1hrs_usd + " / /"
            binding.textCryptoVolume1d.text =
                "Crypto Volume(1Day):" + cryptoModel.volume_1day_usd + " / /"
            binding.textCryptoVolume1m.text =
                "Crypto Volume(1Month):" + cryptoModel.volume_1mth_usd + " / /"
            if(cryptoModel.type_is_crypto == "1"){
                binding.textCryptoType.text = "Kripto"
            }else binding.textCryptoType.text = "Kripto Değil"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RowHolder(binding)
    }

    override fun getItemCount(): Int {
        return cryptoList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position], position, listener)

    }
}