package com.example.m3_rv_kt

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.m3_rv_kt.databinding.FragmentDetailBinding

@Suppress( "DEPRECATION")
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            Glide.with(buttonWa).load("https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/WhatsApp.svg/2044px-WhatsApp.svg.png").into(buttonWa)
            val car = requireArguments().getSerializable("car") as Car
            textViewDesc.text = car.desc
            textViewBrand.text = car.brand
            textViewCost.text = car.cost
            textViewNumber.text = car.phoneNumber
            Glide.with(imageViewCar).load(car.image).into(imageViewCar)


            buttonCall.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${car.phoneNumber}" ))
                startActivity(intent)
            }

            buttonWa.setOnClickListener {
                val url = "https://api.whatsapp.com/send?phone=${car.phoneNumber}"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
        }
    }
}