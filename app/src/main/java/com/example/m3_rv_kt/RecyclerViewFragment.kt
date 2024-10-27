package com.example.m3_rv_kt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.m3_rv_kt.databinding.FragmentRecyclerViewBinding

class RecyclerViewFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerViewBinding
    private lateinit var adapter: CarAdapter
    private var carList = arrayListOf<Car>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecyclerViewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        initAdapter()
    }

    private fun initAdapter(){
        adapter = CarAdapter(carList) { position ->
            val bundle = Bundle().apply {
                putSerializable("car", carList[position])
            }
           // val detailFragment = DetailFragment()
          //  detailFragment.arguments = bundle
            //requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view_main, detailFragment).addToBackStack(null).commit()
           // val action = RecyclerViewFragmentDirections.actionRecyclerViewFragmentToDetailFragment(carList[position])
            findNavController().navigate(R.id.action_recyclerViewFragment_to_detailFragment,bundle)
        }
        binding.recyclerViewCars.adapter = adapter
    }

    private fun loadData(){
        if (carList.isEmpty()){
            carList.add(Car("Toyota Supra, 1998",
                "Toyota",
                "40000",
                "https://s.drom.ru/1/reviews/photos/toyota/supra/big_9189_0.jpeg",
                "1111111"))
            carList.add(Car("Subaru Impreza, 2002",
                "Subaru", "20000",
                "https://subaru555.kz/wp-content/uploads/2020/04/subaru-impreza-1.jpg",
                "2222222"))
            carList.add(Car("Mazda RX-7, 1998",
                "Mazda", "60000",
                "https://www.jm-imports.co.uk/wp-content/uploads/2023/05/P1190648-r50.jpg",
                "3333333"))
            carList.add(Car("Nissa Skyline R34 GT-R V-Spec II, 2000",
                "Nissan",
                "30000",
                "https://www.carscoops.com/wp-content/uploads/2023/04/Nissan-Skyline-GT-R-V-Spec-II-5-a.jpg",
                "4444444"))
        }

    }
}