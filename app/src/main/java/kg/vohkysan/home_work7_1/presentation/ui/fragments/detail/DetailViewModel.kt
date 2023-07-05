package kg.vohkysan.home_work7_1.presentation.ui.fragments.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.vohkysan.home_work7_1.domain.models.Family
import kg.vohkysan.home_work7_1.domain.usecases.DeleteFamilyUseCase
import kg.vohkysan.home_work7_1.domain.usecases.UpdateFamilyUseCase
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val updateFamilyUseCase: UpdateFamilyUseCase,
    private val deleteFamilyUseCase: DeleteFamilyUseCase
) : ViewModel() {

    fun updateFamily(family: Family) {
        updateFamilyUseCase.execute(family = family)
    }

    fun deleteFamily(family: Family){
        deleteFamilyUseCase.execute(family = family)
    }
}