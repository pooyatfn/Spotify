package com.example.potify

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.potify.databinding.GoodAfternoonItemBinding

class GoodAfternoonAdapter: RecyclerView.Adapter<GoodAfternoonAdapter.ViewHolder>() {

    var goods: List<GoodAfternoonItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GoodAfternoonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = goods.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val good = goods[position]
        holder.bind(good)
    }

    inner class ViewHolder(private val binding: GoodAfternoonItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(good: GoodAfternoonItem) {
            binding.goodImage.setImageBitmap(BitmapFactory.decodeFile(good.imageSrc))
            binding.goodText.text = good.title
//          binding.goodImage.apply {
//              setImageBitmap(BitmapFactory.decodeFile(good.image))
//                text = todo.todo
//                setOnCheckedChangeListener(null)
//                isChecked = todo.isChecked
//                setOnCheckedChangeListener { _, isChecked ->
//                    onUpdate.invoke(todo.copy(isChecked = isChecked))
//                }
//          }
//            binding.delete.setOnClickListener {
//                onDelete.invoke(todo)
//            }
        }
    }
}