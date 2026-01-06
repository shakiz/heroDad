package com.journey.heroDad.domain.model.recipes

import android.os.Parcelable
import com.journey.heroDad.domain.model.user.User
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeUser(val recipe: Recipe, val user: User) : Parcelable