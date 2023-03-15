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
import com.nikolay.exploreuniverseapp.databinding.FragmentVenusBinding
import com.nikolay.exploreuniverseapp.viewmodels.VenusViewModel

class VenusFragment : Fragment() {

    private var _binding: FragmentVenusBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: VenusViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVenusBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this)[VenusViewModel::class.java]
        binding.venusViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.isNavigateToMercury.observe(viewLifecycleOwner) { value ->
            if (value)
                view.findNavController()
                    .navigate(R.id.action_venusFragment_to_mercuryFragment)
        }

        viewModel.isNavigateToEarth.observe(viewLifecycleOwner) { value ->
            if (value)
                view.findNavController()
                    .navigate(R.id.action_venusFragment_to_earthFragment)
        }

        binding.composeViewVenus.apply {
            setContent {
                VenusFragmentUI()
            }
        }

        return view
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VenusFragmentUI() {
    Column(
        Modifier
            .background(Color(0xFF212542))
            .fillMaxSize()
    ) {
        VenusCard()
    }
}


@Composable
fun VenusCard(modifier: Modifier = Modifier) {
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
        Planet(modifier, R.drawable.venus)
    }
}