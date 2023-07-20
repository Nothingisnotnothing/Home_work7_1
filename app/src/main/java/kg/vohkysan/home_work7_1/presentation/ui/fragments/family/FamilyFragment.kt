package kg.vohkysan.home_work7_1.presentation.ui.fragments.family

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kg.vohkysan.home_work7_1.R
import kg.vohkysan.home_work7_1.databinding.FragmentFamilyBinding
import kg.vohkysan.home_work7_1.domain.models.Family
import kg.vohkysan.home_work7_1.presentation.ui.base.BaseFragment
import kg.vohkysan.home_work7_1.presentation.ui.fragments.family.adapter.FamilyAdapter
import kg.vohkysan.home_work7_1.presentation.utils.UiState
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FamilyFragment : BaseFragment() {
    private lateinit var binding: FragmentFamilyBinding
    private val viewModel by viewModels<FamilyViewModel>()
    private val adapter = FamilyAdapter(onClick = ::onClick)

    private fun onClick(family: kg.vohkysan.home_work7_1.domain.models.Family) {
        findNavController().navigate(
            R.id.navigation_detail,
            bundleOf(KEY_FAMILY to family)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFamilyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initOnClickListeners()
        viewModelListener()
    }

    private fun initOnClickListeners() {
        with(binding) {
            btnSave.setOnClickListener {
                viewModel.addFamily(
                    kg.vohkysan.home_work7_1.domain.models.Family(
                        id = (0..9999).random(),
                        name = etName.text.toString(),
                        mother = etMother.text.toString(),
                        father = etFather.text.toString()
                    )
                )
            }
        }
    }

    private fun viewModelListener() {
        viewModel.family()
        viewModel.getAllFamilyStates.collectState(
            loadingState = {
                binding.progressbar.isVisible = true
            },
            successState = {
                binding.progressbar.isVisible = false
                binding.rvFamily.adapter = adapter
                if (it != null) {
                    adapter.addFamily(it)
                }
            })
    }

    companion object {
        const val KEY_FAMILY = "keyFamilyId"
    }
}