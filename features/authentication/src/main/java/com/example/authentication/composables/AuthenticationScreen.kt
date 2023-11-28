package com.example.authentication.composables

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.authentication.viewmodel.AuthenticationViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AuthenticationScreen(
   authenticationVM: AuthenticationViewModel = viewModel(LocalContext.current as ComponentActivity)
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current
    val focusRequester = remember { FocusRequester() }

    var emailInput by rememberSaveable { mutableStateOf("") }
    var passwordInput by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    ConstraintLayout(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(12.dp)
    ) {
        val (title, email, password, authBtn, registerBtn) = createRefs()
        createVerticalChain(title, email, password, authBtn, registerBtn, chainStyle = ChainStyle.Packed)

        Text(
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(parent.top)
                    bottom.linkTo(email.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
                .padding(bottom = 12.dp),
            text = "Authenticate to continue",
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )
        TextField(
            modifier = Modifier
                .constrainAs(email) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(title.bottom)
                    bottom.linkTo(password.top)
                    width = Dimension.fillToConstraints
                }
                .padding(bottom = 12.dp),
            value = emailInput,
            onValueChange = { input -> emailInput = input },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { focusRequester.requestFocus() }
            ),
            label = {
                Text(
                    text = "Email",
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp
                )
            }
        )
        TextField(
            modifier = Modifier
                .focusRequester(focusRequester)
                .constrainAs(password) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(email.bottom)
                    bottom.linkTo(authBtn.top)
                    width = Dimension.fillToConstraints
                }
                .padding(bottom = 12.dp),
            value = passwordInput,
            onValueChange = { passwordInput = it },
            label = {
                Text(
                    text = "Password",
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp
                )
            },
            singleLine = true,
            placeholder = {
                Text(
                    text = "Password",
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp
                )
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None
            else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { keyboardController?.hide() }
            ),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                IconButton(
                    onClick = { passwordVisible = !passwordVisible }
                ) {
                    Icon(
                        imageVector  = image,
                        contentDescription = null
                    )
                }
            }
        )
        Button(
            modifier = Modifier
                .constrainAs(authBtn) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(password.bottom)
                    bottom.linkTo(registerBtn.top)
                    width = Dimension.fillToConstraints
                }
                .padding(bottom = 12.dp),
            onClick = {
                val showToast = !authenticationVM.startAuthentication(emailInput, passwordInput)
                if (showToast)
                    Toast.makeText(context, "Credentials invalid", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Continue")
        }
        Button(
            modifier = Modifier
                .constrainAs(registerBtn) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(authBtn.bottom)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                },
            onClick = authenticationVM::navigateToRegistration
        ) {
            Text(text = "Register")
        }
    }
}