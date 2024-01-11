package com.example.myapplication.secondactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.BlankFragmentBinding

class BlankFragment : Fragment() {
    private var _binding: BlankFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BlankFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

}