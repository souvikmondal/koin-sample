package com.example.koinsample.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.koinsample.databinding.FragmentFirstBinding
import com.example.koinsample.vm.Fetch
import com.example.koinsample.vm.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstFragment : Fragment()/*, AndroidScopeComponent*/ {

//    override val scope: Scope by fragmentScope()

    private val mainViewModel: MainViewModel by viewModel()

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

//    val logger: Logger = get()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fetchBtn.setOnClickListener { mainViewModel.post(Fetch) }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                mainViewModel.dataFlow.collectLatest {
//                    logger.d("Text got from repo is $it")
                    binding.textViewFirst.text = it
                }
            }
        }
    }
}