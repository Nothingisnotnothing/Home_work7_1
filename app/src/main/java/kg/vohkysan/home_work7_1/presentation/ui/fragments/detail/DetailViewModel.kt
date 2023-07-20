package kg.vohkysan.home_work7_1.presentation.ui.fragments.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.vohkysan.home_work7_1.domain.models.Family
import kg.vohkysan.home_work7_1.domain.usecases.DeleteFamilyUseCase
import kg.vohkysan.home_work7_1.domain.usecases.UpdateFamilyUseCase
import kg.vohkysan.home_work7_1.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val updateFamilyUseCase: kg.vohkysan.home_work7_1.domain.usecases.UpdateFamilyUseCase,
    private val deleteFamilyUseCase: kg.vohkysan.home_work7_1.domain.usecases.DeleteFamilyUseCase
) : BaseViewModel() {

    suspend fun updateFamily(family: kg.vohkysan.home_work7_1.domain.models.Family) {
        viewModelScope.launch(Dispatchers.IO) {
            updateFamilyUseCase.execute(family = family)
        }
    }

    suspend fun deleteFamily(family: kg.vohkysan.home_work7_1.domain.models.Family) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteFamilyUseCase.execute(family = family)
        }
    }
}