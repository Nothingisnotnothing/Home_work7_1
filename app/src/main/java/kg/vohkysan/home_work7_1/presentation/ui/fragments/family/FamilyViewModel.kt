package kg.vohkysan.home_work7_1.presentation.ui.fragments.family

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.vohkysan.home_work7_1.domain.models.Family
import kg.vohkysan.home_work7_1.domain.usecases.AddFamilyUseCase
import kg.vohkysan.home_work7_1.domain.usecases.GetFamilyUseCase
import kg.vohkysan.home_work7_1.domain.utils.Resource
import kg.vohkysan.home_work7_1.presentation.utils.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FamilyViewModel @Inject constructor(
    private val getFamilyUseCase: GetFamilyUseCase,
    private val addFamilyUseCase: AddFamilyUseCase,
) : ViewModel() {

    private val _getAllFamilyStates = MutableStateFlow<UiState<List<Family>>>(UiState.EmptyState())
    val getAllFamilyStates = _getAllFamilyStates.asStateFlow()

    fun addFamily(family: Family){
        viewModelScope.launch(Dispatchers.IO) {
            addFamilyUseCase.execute(family = family)
        }
    }

    fun getAllFamily() {
        viewModelScope.launch {
            getFamilyUseCase.execute().collect {
                when (it) {
                    is Resource.Loading -> {
                        _getAllFamilyStates.value = UiState.Loading()
                    }

                    is Resource.Success -> {
                        _getAllFamilyStates.value = UiState.Success(it.data as List<Family>)
                    }

                    is Resource.Error -> {
                        _getAllFamilyStates.value = UiState.Error(it.message ?: "")
                    }
                }
            }
        }
    }
}