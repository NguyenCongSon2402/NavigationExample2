package com.example.navigationexample

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigationexample.adapter.MovieAdapter1
import com.example.navigationexample.databinding.FragmentHomeBinding
import com.example.navigationexample.network.ResultData
import com.example.navigationexample.network.model.Items
import com.example.navigationexample.ui.HomeViewModel
import com.example.navigationexample.ui.base.BaseFragment
import com.example.navigationexample.ui.base.BaseListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :
    BaseFragment<FragmentHomeBinding>(bindingInflater = FragmentHomeBinding::inflate) {
    private lateinit var movieAdapter: MovieAdapter1
    private val homeViewModel: HomeViewModel by viewModels()

    override fun initView() {
        getData()
        initObserve()
        movieAdapter = MovieAdapter1()
        val layoutManager = LinearLayoutManager(requireActivity())
        binding.rcv.layoutManager = layoutManager
        binding.rcv.adapter = movieAdapter
        movieAdapter.listener = object : BaseListAdapter.Action<Items> {
            override fun click(position: Int, data: Items, code: Int) {
                handleMediaClick(position,data)
            }
        }



    }

     private fun getData() {
        homeViewModel.getAllMovie()
    }

    private fun handleMediaClick(position:Int, items: Items) {
        val detailMovie = items
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(detailMovie)
        findNavController().navigate(action)
    }

     private fun initObserve() {
        homeViewModel.stateListMovie.observe(viewLifecycleOwner) {
            when (it.status) {
                ResultData.Status.LOADING -> {
                    binding.loading.visibility=View.VISIBLE
                }

                ResultData.Status.FAILED -> {
                    Toast.makeText(requireActivity(), "Error:${it.message}", Toast.LENGTH_SHORT)
                        .show()
                    binding.loading.visibility=View.GONE

                }

                ResultData.Status.SUCCESS -> {
                    binding.loading.visibility=View.GONE
                    val listMovie = it.data!!.data // ArrayList<Character>
                    movieAdapter.submitList(listMovie?.items)
                    Log.e("log", "...SUCCESS... ${listMovie.toString()}")
                }
            }
        }
    }

}