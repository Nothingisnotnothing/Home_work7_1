package kg.vohkysan.home_work7_1.presentation.ui.fragments.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.vohkysan.home_work7_1.domain.models.Family
import kg.vohkysan.home_work7_1.domain.usecases.DeleteFamilyUseCase
import kg.vohkysan.home_work7_1.domain.usecases.UpdateFamilyUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val updateFamilyUseCase: UpdateFamilyUseCase,
    private val deleteFamilyUseCase: DeleteFamilyUseCase
) : ViewModel() {

    suspend fun updateFamily(family: Family) {
        viewModelScope.launch(Dispatchers.IO) {
            updateFamilyUseCase.execute(family = family)
        }
    }

    suspend fun deleteFamily(family: Family) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteFamilyUseCase.execute(family = family)
        }
    }
}