package com.dicoding.picodiploma.gamescatalogue.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.picodiploma.gamescatalogue.R
import com.dicoding.picodiploma.core.ui.GamesAdapter
import com.dicoding.picodiploma.gamescatalogue.databinding.FragmentHomeBinding
import com.dicoding.picodiploma.gamescatalogue.detail.DetailGameActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val gamesAdapter = GamesAdapter()
            gamesAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailGameActivity::class.java)
                intent.putExtra(DetailGameActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.games.observe(viewLifecycleOwner, { games ->
                if (games != null) {
                    when (games) {
                        is com.dicoding.picodiploma.core.data.Resource.Loading -> binding?.progressBar?.visibility = View.VISIBLE
                        is com.dicoding.picodiploma.core.data.Resource.Success -> {
                            binding?.progressBar?.visibility = View.GONE
                            gamesAdapter.setData(games.data)
                        }
                        is com.dicoding.picodiploma.core.data.Resource.Error -> {
                            binding?.progressBar?.visibility = View.GONE
                            binding?.viewError?.root?.visibility = View.VISIBLE
                            binding?.viewError?.tvError?.text = games.message ?: getString(R.string.wrong)
                        }
                    }
                }
            })

            with(binding?.rvTourism) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = gamesAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}