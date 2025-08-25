package org.mohanned.fursati.presentation.viewmodels

// ViewModel Implementation using Compose Multiplatform ViewModel

import Company
import FAQ
import Job
import Terms
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.mohanned.fursati.data.repository.FursatiRepository
import org.mohanned.fursati.domain.model.UiState


class FursatiViewModel(
    private val repository: FursatiRepository = FursatiRepository()
) : ViewModel() {

    // Companies State
    private val _companiesState = MutableStateFlow<UiState<List<Company>>>(UiState.Loading)
    val companiesState: StateFlow<UiState<List<Company>>> = _companiesState.asStateFlow()

    // FAQs State
    private val _faqsState = MutableStateFlow<UiState<List<FAQ>>>(UiState.Loading)
    val faqsState: StateFlow<UiState<List<FAQ>>> = _faqsState.asStateFlow()

    // Terms State
    private val _termsState = MutableStateFlow<UiState<Terms>>(UiState.Loading)
    val termsState: StateFlow<UiState<Terms>> = _termsState.asStateFlow()

    // Jobs State
    private val _jobsState = MutableStateFlow<UiState<List<Job>>>(UiState.Loading)
    val jobsState: StateFlow<UiState<List<Job>>> = _jobsState.asStateFlow()

    // Job Details State
    private val _jobDetailsState = MutableStateFlow<UiState<Job>>(UiState.Loading)
    val jobDetailsState: StateFlow<UiState<Job>> = _jobDetailsState.asStateFlow()


    init {
        loadAllJobs()
        loadTerms()
        loadFaqs()
    }
    fun loadCompaniesForFilter() {
        viewModelScope.launch {
            _companiesState.value = UiState.Loading
            repository.getCompaniesForFilter()
                .onSuccess { companies ->
                    _companiesState.value = UiState.Success(companies)
                }
                .onFailure { exception ->
                    _companiesState.value = UiState.Error(
                        exception.message ?: "Failed to load companies"
                    )
                }
        }
    }

    fun loadFaqs() {
        viewModelScope.launch {
            _faqsState.value = UiState.Loading
            repository.getFaqs()
                .onSuccess { faqs ->
                    _faqsState.value = UiState.Success(faqs)
                }
                .onFailure { exception ->
                    _faqsState.value = UiState.Error(
                        exception.message ?: "Failed to load FAQs"
                    )
                }
        }
    }

    fun loadTerms() {
        viewModelScope.launch {
            _termsState.value = UiState.Loading
            repository.getTerms()
                .onSuccess { terms ->
                    _termsState.value = UiState.Success(terms)
                }
                .onFailure { exception ->
                    _termsState.value = UiState.Error(
                        exception.message ?: "Failed to load terms"
                    )
                }
        }
    }

    fun loadAllJobs() {
        viewModelScope.launch {
            _jobsState.value = UiState.Loading
            repository.getAllJobs()
                .onSuccess { jobs ->
                    _jobsState.value = UiState.Success(jobs)
                }
                .onFailure { exception ->
                    _jobsState.value = UiState.Error(
                        exception.message ?: "Failed to load jobs"
                    )
                }
        }
    }

    fun loadJobDetails(jobId: Int) {
        viewModelScope.launch {
            _jobDetailsState.value = UiState.Loading
            repository.getJobDetails(jobId)
                .onSuccess { job ->
                    _jobDetailsState.value = UiState.Success(job)
                }
                .onFailure { exception ->
                    _jobDetailsState.value = UiState.Error(
                        "exception.message ${exception.message}" ?: "Failed to load job details"
                    )
                }
        }
    }

    fun refreshJobs() {
        loadAllJobs()
    }

    fun refreshCompanies() {
        loadCompaniesForFilter()
    }
}