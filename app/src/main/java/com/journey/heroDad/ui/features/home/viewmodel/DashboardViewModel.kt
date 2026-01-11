package com.journey.heroDad.ui.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.journey.heroDad.domain.model.kick.Kick
import com.journey.heroDad.domain.repository.DashboardRepository
import com.journey.heroDad.utils.components.network.ResultWrapper
import com.journey.heroDad.utils.components.widget.ChartPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

// Note - Here we are passing the repo instance through constructor,
// because we wanted to explore this way of DI too.
// So you can wither access the repo by inject() from KoinComponent
// or declare the viewModelModule separately to provide the dependencies.

data class DashboardUiState(
    val kicks: ResultWrapper<List<Kick>> = ResultWrapper.Loading,
    val weeklyKicks: ResultWrapper<List<ChartPoint>> = ResultWrapper.Loading
)

class DashboardViewModel(private val dashboardRepository: DashboardRepository) : ViewModel(),
    KoinComponent {
    private val _kicks = MutableStateFlow<ResultWrapper<List<Kick>>>(ResultWrapper.Loading)
    val kicks: StateFlow<ResultWrapper<List<Kick>>> = _kicks

    private val _weeklyKicks =
        MutableStateFlow<ResultWrapper<List<ChartPoint>>>(ResultWrapper.Loading)
    val weeklyKicks: StateFlow<ResultWrapper<List<ChartPoint>>> = _weeklyKicks

    val uiState: StateFlow<DashboardUiState> = combine(kicks, weeklyKicks){
        kickResult, weeklyKickResult ->
        DashboardUiState(
            kicks = kickResult,
            weeklyKicks = weeklyKickResult
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = DashboardUiState()
    )

    fun getKicks() {
        viewModelScope.launch {
            val localKickData = listOf(
                Kick(
                    id = 1,
                    noOfKicks = 10,
                    recordDate = "Today, 8:45 PM",
                    totalDuration = 840000,
                    kickType = "Normal activity pattern"
                ),
                Kick(
                    id = 2,
                    noOfKicks = 19,
                    recordDate = "Yesterday, 9:30 PM",
                    totalDuration = 810000,
                    kickType = "Active evening"
                ),
                Kick(
                    id = 3,
                    noOfKicks = 9,
                    recordDate = "Mon, Oct 26",
                    totalDuration = 1200000,
                    kickType = "Slower movement"
                )
            )
            _kicks.value = ResultWrapper.Success(localKickData)
        }
    }

    fun getWeeklyKickData() {
        val weeklyData = listOf(
            ChartPoint("Mon", 20f),
            ChartPoint("Tue", 65f),
            ChartPoint("Wed", 40f),
            ChartPoint("Thu", 15f),
            ChartPoint("Fri", 90f),
            ChartPoint("Sat", 5f),
            ChartPoint("Sun", 80f)
        )
        _weeklyKicks.value = ResultWrapper.Success(weeklyData)
    }
}
