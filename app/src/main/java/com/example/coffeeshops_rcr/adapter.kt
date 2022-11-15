package com.example.coffeeshops_rcr


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class adapter(var items: ArrayList<Item>, var context: Context) :
    RecyclerView.Adapter<adapter.TarjViewHolder>() {
    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.image)
        var puntuacion: TextView = itemView.findViewById(R.id.editTextRatingBar)
        var tienda: TextView = itemView.findViewById(R.id.editText)
        var lugar: TextView = itemView.findViewById(R.id.editTextPlace)
        val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.cards, parent, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TarjViewHolder, position: Int) {
        val item = items.get(position)
        holder.image.setImageResource(item.int)
        holder.image.scaleType = ImageView.ScaleType.FIT_XY
        holder.tienda.setText(item.tienda)
        holder.lugar.setText(item.lugar)
        holder.ratingBar.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
                item.puntuacion = rating
                this.notifyDataSetChanged()
            }
        holder.puntuacion.text = holder.ratingBar.rating.toString()

        holder.itemView.findViewById<MaterialButton>(R.id.boton).setOnClickListener {
            Toast.makeText(
                context,
                "Puntuacion de: " + item.tienda + " es de: " + item.puntuacion,
                Toast.LENGTH_LONG
            ).show()
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = items.size

}