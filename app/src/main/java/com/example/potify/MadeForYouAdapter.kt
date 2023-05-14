package com.example.potify

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.potify.databinding.MadeForYouItemBinding

class MadeForYouAdapter: RecyclerView.Adapter<MadeForYouAdapter.ViewHolder>() {

    var mades: List<MadeForYouItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MadeForYouItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = mades.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val made = mades[position]
        holder.bind(made)
    }

    inner class ViewHolder(private val binding: MadeForYouItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(made: MadeForYouItem) {
            binding.madeImage.setImageBitmap(BitmapFactory.decodeFile(made.imageSrc))
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