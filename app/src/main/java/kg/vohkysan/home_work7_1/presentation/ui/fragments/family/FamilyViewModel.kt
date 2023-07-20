package kg.vohkysan.home_work7_1.presentation.ui.fragments.family

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.vohkysan.home_work7_1.domain.models.Family
import kg.vohkysan.home_work7_1.domain.usecases.AddFamilyUseCase
import kg.vohkysan.home_work7_1.domain.usecases.GetFamilyUseCase
import kg.vohkysan.home_work7_1.domain.utils.Resource
import kg.vohkysan.home_work7_1.presentation.base.BaseViewModel
import kg.vohkysan.home_work7_1.presentation.utils.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FamilyViewModel @Inject constructor(
    private val getFamilyUseCase: kg.vohkysan.home_work7_1.domain.usecases.GetFamilyUseCase,
    private val addFamilyUseCase: kg.vohkysan.home_work7_1.domain.usecases.AddFamilyUseCase,
) : BaseViewModel() {

    private val _getAllFamilyStates = MutableStateFlow<UiState<List<kg.vohkysan.home_work7_1.domain.models.Family>>>(UiState.EmptyState())
    val getAllFamilyStates = _getAllFamilyStates.asStateFlow()

    fun addFamily(family: kg.vohkysan.home_work7_1.domain.models.Family){
        viewModelScope.launch(Dispatchers.IO) {
            addFamilyUseCase.execute(family = family)
        }
    }

    fun family() {
        getFamilyUseCase.execute().collectData(_getAllFamilyStates)
    }
}