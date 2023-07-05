package kg.vohkysan.home_work7_1.presentation.ui.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kg.vohkysan.home_work7_1.databinding.FragmentDetailBinding
import kg.vohkysan.home_work7_1.domain.models.Family
import kg.vohkysan.home_work7_1.presentation.ui.fragments.family.FamilyFragment.Companion.KEY_FAMILY
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getFamily()
        initClickListeners()
    }

    private fun getFamily() {
        with(binding){
            val family = (arguments?.getSerializable(KEY_FAMILY)) as Family
            etName.setText(family.name)
            etMother.setText(family.mother)
            etFather.setText(family.father)
        }
    }

    private fun initClickListeners() {
        with(binding) {
            val family = (arguments?.getSerializable(KEY_FAMILY)) as Family
            btnUpdate.setOnClickListener {
                viewModel.viewModelScope.launch {
                    viewModel.updateFamily(
                        Family(
                            id = family.id,
                            name = binding.etName.text.toString(),
                            mother = binding.etMother.text.toString(),
                            father = binding.etFather.text.toString()
                        )
                    )
                }
                findNavController().navigateUp()
            }
            btnDelete.setOnClickListener {
                viewModel.viewModelScope.launch {
                    viewModel.deleteFamily(family)
                }
                findNavController().navigateUp()
            }
        }
    }
}