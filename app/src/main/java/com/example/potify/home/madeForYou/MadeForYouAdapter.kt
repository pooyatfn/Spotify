package com.example.potify.home.madeForYou

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.potify.databinding.MadeForYouItemBinding
import com.example.potify.entities.Album

class MadeForYouAdapter: RecyclerView.Adapter<MadeForYouAdapter.ViewHolder>() {

    var albums: List<Album> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MadeForYouItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = albums.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val made = albums[position]
        holder.bind(made)
    }

    inner class ViewHolder(private val binding: MadeForYouItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(album: Album) {
            Glide.with(binding.root)
                .load(album.imageSrc)
                .into(binding.madeImage)
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