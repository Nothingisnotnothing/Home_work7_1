package kg.vohkysan.home_work7_1.presentation.ui.fragments.family

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kg.vohkysan.home_work7_1.R
import kg.vohkysan.home_work7_1.databinding.FragmentFamilyBinding
import kg.vohkysan.home_work7_1.domain.models.Family
import kg.vohkysan.home_work7_1.presentation.ui.fragments.family.adapter.FamilyAdapter
import kg.vohkysan.home_work7_1.presentation.utils.UiState
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FamilyFragment : Fragment() {
    private lateinit var binding: FragmentFamilyBinding
    private val viewModel by viewModels<FamilyViewModel>()
    private val adapter = FamilyAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFamilyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
        viewModelListener()
    }

    private fun setOnClickListeners() {
        with(binding) {
            btnSave.setOnClickListener {
                viewModel.addFamily(
                    Family(
                        id = (0..9999).random(),
                        name = etName.text.toString(),
                        mother = etMother.text.toString(),
                        father = etFather.text.toString()
                    )
                )
                Toast.makeText(requireContext(), "item is add ${Family(
                    id = (0..9999).random(),
                    name = etName.text.toString(),
                    mother = etMother.text.toString(),
                    father = etFather.text.toString()
                )}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun viewModelListener() {
        viewModel.getAllFamily()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getAllFamilyStates.collect {
                when (it) {
                    is UiState.EmptyState -> {
                        Toast.makeText(requireContext(), "Empty state", Toast.LENGTH_SHORT).show()
                    }

                    is UiState.Error -> {
                        binding.progressbar.isVisible = false
                        Toast.makeText(requireContext(), "Error ${it.message}", Toast.LENGTH_SHORT)
                            .show()
                    }

                    is UiState.Loading -> {
                        binding.progressbar.isVisible = true
                    }

                    is UiState.Success -> {
                        binding.progressbar.isVisible = false
                        binding.rvFamily.adapter = adapter
                        adapter.addTasks(it.data)
                        Toast.makeText(requireContext(), "Error ${it.data}", Toast.LENGTH_SHORT)
                    }
                }
            }
        }
    }
}