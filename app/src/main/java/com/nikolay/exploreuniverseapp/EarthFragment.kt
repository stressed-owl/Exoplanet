package com.nikolay.exploreuniverseapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.nikolay.exploreuniverseapp.databinding.FragmentEarthBinding
import com.nikolay.exploreuniverseapp.viewmodels.EarthViewModel

class EarthFragment : Fragment() {

    private var _binding: FragmentEarthBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: EarthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEarthBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this)[EarthViewModel::class.java]
        binding.earthViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.isNavigateToMercury.observe(viewLifecycleOwner) { value ->
            if (value)
                view.findNavController()
                    .navigate(R.id.action_earthFragment_to_mercuryFragment)
        }

        viewModel.isNavigateToVenus.observe(viewLifecycleOwner) { value ->
            if (value)
                view.findNavController()
                    .navigate(R.id.action_earthFragment_to_venusFragment)
        }

        binding.composeViewEarth.apply {
            setContent {
                EarthFragmentUI()
            }
        }

        return view
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EarthFragmentUI() {
    Column(
        Modifier
            .background(Color(0xFF212542))
            .fillMaxSize()
    ) {
        EarthCard()
    }
}

@Composable
fun EarthCard(modifier: Modifier = Modifier) {
    Card(modifier = modifier
        .fillMaxWidth()
        .height(270.dp),
        backgroundColor = Color(0xFF282C47),
        shape = RoundedCornerShape(
            bottomEnd = 30.dp,
            bottomStart = 30.dp
        )
    ) {
        Planet(modifier, R.drawable.earth)
    }
}