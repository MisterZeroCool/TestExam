package com.example.testexam

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testexam.databinding.CarItemBinding

class CarAdapter: RecyclerView.Adapter<CarAdapter.CarHolder>() {
    val carList = ArrayList<Car>()
    class CarHolder(item: View): RecyclerView.ViewHolder(item){
        private val binding = CarItemBinding.bind(item)
        fun bind(car: Car) = with(binding){
            imageCar.setImageResource(car.id)
            titleView.text = car.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_item, parent, false)
        return CarHolder(view)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: CarHolder, position: Int) {
        holder.bind(carList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addCar(car: Car){
        carList.add(car)
        notifyDataSetChanged()
    }
}