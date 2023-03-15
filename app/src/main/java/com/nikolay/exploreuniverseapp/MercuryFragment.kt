package com.nikolay.exploreuniverseapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.nikolay.exploreuniverseapp.databinding.FragmentMercuryBinding
import com.nikolay.exploreuniverseapp.viewmodels.MercuryViewModel

class MercuryFragment : Fragment() {

    private var _binding: FragmentMercuryBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MercuryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMercuryBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this)[MercuryViewModel::class.java]
        binding.mercuryViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.isNavigateToVenus.observe(viewLifecycleOwner) { value ->
            if (value)
                view.findNavController().navigate(R.id.action_mercuryFragment_to_venusFragment)
        }

        viewModel.isNavigateToEarth.observe(viewLifecycleOwner) { value ->
            if (value)
                view.findNavController().navigate(R.id.action_mercuryFragment_to_earthFragment)
        }

        binding.composeView.apply {
            setContent {
                MercuryFragmentUI()
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MercuryFragmentUI() {
    Column(
        Modifier
            .background(Color(0xFF212542))
            .fillMaxSize()
    ) {
        PlanetCard()
    }
}

@Composable
fun Planet(modifier: Modifier = Modifier, image: Int) {
    Image(
        painter = painterResource(image),
        contentDescription = null,
        modifier = modifier.padding(10.dp)
    )
}

@Composable
fun PlanetCard(modifier: Modifier = Modifier) {
    Card (
        shape = RoundedCornerShape(
            bottomEnd = 30.dp,
            bottomStart = 30.dp
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(270.dp),
        backgroundColor = Color(0xFF282C47)
    ) {
        Planet(modifier, R.drawable.mercury)
    }
}