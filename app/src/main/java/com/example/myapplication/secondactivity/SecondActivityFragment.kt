package com.example.myapplication.secondactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.SecondActivityFragmentBinding

class SecondActivityFragment : Fragment() {

    private var _binding: SecondActivityFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SecondActivityFragmentBinding.inflate(inflater, container, false)
        binding.dummyButton.setOnClickListener {
            findNavController().navigate(SecondActivityFragmentDirections.navigateToBlankFragment())
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}