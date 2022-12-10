package com.davidson.compose15.data.models

import androidx.compose.ui.graphics.Color
import com.davidson.compose15.ui.theme.HighPriorityColor
import com.davidson.compose15.ui.theme.LowPriorityColor
import com.davidson.compose15.ui.theme.MediumPriorityColor
import com.davidson.compose15.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}