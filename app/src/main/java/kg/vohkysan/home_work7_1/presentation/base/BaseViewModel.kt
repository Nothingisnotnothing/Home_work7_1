package kg.vohkysan.home_work7_1.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.vohkysan.home_work7_1.domain.utils.Resource
import kg.vohkysan.home_work7_1.presentation.utils.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T> Flow<kg.vohkysan.home_work7_1.domain.utils.Resource<T>>.collectData(
        _state: MutableStateFlow<UiState<T>>
    ) {
        viewModelScope.launch {
            this@collectData.collect() { resource ->
                when (resource) {
                    is kg.vohkysan.home_work7_1.domain.utils.Resource.Loading -> {
                        _state.value = UiState.Loading()
                    }

                    is kg.vohkysan.home_work7_1.domain.utils.Resource.Success -> {
                        if (resource.data != null) {
                            _state.value = UiState.Success(resource.data)
                        }
                    }

                    is kg.vohkysan.home_work7_1.domain.utils.Resource.Error -> {
                        _state.value = UiState.Error(resource.message ?: "Error")
                    }
                }
            }
        }
    }
}