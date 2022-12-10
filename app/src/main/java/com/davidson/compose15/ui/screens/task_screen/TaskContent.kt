package com.davidson.compose15.ui.screens.task_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.davidson.compose15.R
import com.davidson.compose15.components.PriorityDropDown
import com.davidson.compose15.data.models.Priority
import com.davidson.compose15.ui.theme.Compose15DailyPlannerTheme
import com.davidson.compose15.ui.theme.LARGE_PADDING
import com.davidson.compose15.ui.theme.MEDIUM_PADDING

@Composable
fun TaskContent(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(all = LARGE_PADDING)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = { onTitleChange(it) },
            label = { Text(text = stringResource(id = R.string.title)) },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colors.secondary,
                focusedLabelColor = MaterialTheme.colors.onPrimary,
                cursorColor = MaterialTheme.colors.onPrimary,
                trailingIconColor = MaterialTheme.colors.onPrimary,
                leadingIconColor = MaterialTheme.colors.onPrimary,
            )
        )
        Divider(
            modifier = Modifier.height(MEDIUM_PADDING),
            color = MaterialTheme.colors.background
        )
        PriorityDropDown(
            priority = priority,
            onPrioritySelected = onPrioritySelected
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = description,
            onValueChange = { onDescriptionChange(it) },
            label = { Text(text = stringResource(id = R.string.description)) },
            textStyle = MaterialTheme.typography.body1,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colors.secondary,
                focusedLabelColor = MaterialTheme.colors.onPrimary,
                cursorColor = MaterialTheme.colors.onPrimary,
                trailingIconColor = MaterialTheme.colors.onPrimary,
                leadingIconColor = MaterialTheme.colors.onPrimary,
            )
        )
    }
}


@Composable
@Preview
private fun TaskContentPreview() {
    Compose15DailyPlannerTheme {
        TaskContent(
            title = "",
            onTitleChange = {},
            description = "",
            onDescriptionChange = {},
            priority = Priority.LOW,
            onPrioritySelected = {}
        )
    }

}