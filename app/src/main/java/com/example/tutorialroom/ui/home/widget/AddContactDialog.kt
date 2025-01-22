package com.example.tutorialroom.ui.home.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tutorialroom.data.local.entity.Contact

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactDialog(
    modifier: Modifier = Modifier,
    contact: Contact = Contact(),
    onDismiss: () -> Unit,
    onSave: (Contact) -> Unit,
) {
    var contactName by remember { mutableStateOf(contact.name ?: "") }
    var phoneNumber by remember { mutableStateOf(contact.number ?: "") }

    BasicAlertDialog(
        modifier = modifier,
        onDismissRequest = onDismiss,
        content = {
            Surface(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.large,
                tonalElevation = AlertDialogDefaults.TonalElevation
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "Add/Edit contact")
                    TextField(
                        value = contactName,
                        onValueChange = {
                            contactName = it
                        },
                        placeholder = {
                            Text(text = "Name")
                        }
                    )
                    TextField(
                        value = phoneNumber,
                        onValueChange = {
                            phoneNumber = it
                        },
                        placeholder = {
                            Text(text = "Phone number")
                        }
                    )

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Button(onClick = {
                            onSave(
                                contact.copy(
                                    name = contactName,
                                    number = phoneNumber
                                )
                            )
                            onDismiss()
                        }) {
                            Text(text = "Save")
                        }

                    }
                }
            }
        }
    )
}