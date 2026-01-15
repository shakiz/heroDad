package com.journey.heroDad.ui.features.quiz.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import com.journey.heroDad.ui.features.quiz.viewmodel.QuizViewModel
import com.journey.heroDad.ui.features.quiz.widget.QuizCategoryListItem
import com.journey.heroDad.utils.components.network.ResultWrapper
import org.koin.androidx.compose.koinViewModel

@Composable
fun QuizScreen(quizViewModel: QuizViewModel = koinViewModel()) {
    val uiState by quizViewModel.uiState.collectAsState()
    LaunchedEffect(Lifecycle.State.CREATED) {
        quizViewModel.getQuizCategories()
    }

    Scaffold {
        when (val result = uiState.quizCategories) {
            is ResultWrapper.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is ResultWrapper.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                ) {
                    item {
                        Column {
                            Text(
                                "Knowledge Base",
                                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W900)
                            )
                            Text(
                                "Take a quick quiz to prepare for the big arrival! ",
                                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant)
                            )
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    item {
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = MaterialTheme.colorScheme.tertiary,
                            border = BorderStroke(1.dp, Color(0xFF223347)),
                            tonalElevation = 1.dp
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        "Overall Progress",
                                        style = MaterialTheme.typography.bodyLarge.copy(
                                            fontWeight = FontWeight.W700,
                                            color = MaterialTheme.colorScheme.onPrimary,
                                        )
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Surface(
                                        shape = RoundedCornerShape(20.dp),
                                        color = MaterialTheme.colorScheme.secondary.copy(alpha = .1f),
                                        border = BorderStroke(1.dp, Color(0xFF223347)),
                                        tonalElevation = 0.dp,
                                    ) {
                                        Text(
                                            "Level 3",
                                            style = MaterialTheme.typography.titleMedium.copy(
                                                fontWeight = FontWeight.W700,
                                                color = MaterialTheme.colorScheme.primary,
                                                fontSize = 12.sp
                                            ),
                                            modifier = Modifier.padding(horizontal = 16.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                                LinearProgressIndicator(
                                    progress = { .4f },
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .fillMaxWidth()
                                        .height(8.dp),
                                    color = MaterialTheme.colorScheme.primary,
                                    trackColor = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        "3/10 Completed",
                                        style = MaterialTheme.typography.bodyLarge.copy(
                                            fontWeight = FontWeight.W400,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        )
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        "Keep going",
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.W700,
                                            color = MaterialTheme.colorScheme.primary,
                                            fontSize = 12.sp
                                        ),
                                        modifier = Modifier.padding(horizontal = 16.dp)
                                    )
                                }
                            }
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                    item {
                        Text(
                            "Quiz Categories",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.W700,
                                color = MaterialTheme.colorScheme.onSurface,
                            ),
                        )
                    }

                    items(result.getOrNull().orEmpty().size) { pos ->
                        QuizCategoryListItem(quizCategory = result.getOrNull().orEmpty().get(pos))
                    }

                }
            }

            is ResultWrapper.Failure -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Error: ${result.message}",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}