import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog


@Composable
fun Screen(viewState: ScreenViewState) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        when (viewState) {
            is ScreenViewState.State1ViewState -> State1(viewState)
            is ScreenViewState.State2ViewState -> State2(viewState)
            is ScreenViewState.State3ViewState -> State3(viewState)
            else -> {}
        }
    }
}

@Composable
fun DisplayDialog(dialogState: ScreenViewState.DialogState) {
    if (dialogState.isDisplayDialog) {
        Dialog(onDismissRequest = {}) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.LightGray)
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = dialogState.dialogText,
                )
                Button(
                    onClick = dialogState.cancelDialog
                ) {
                    Text(text = dialogState.cancelText)
                }
            }
        }
    }
}


@Composable
fun State1(viewState1: ScreenViewState.State1ViewState) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = viewState1.title)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = viewState1.onClick1) {
            Text(text = viewState1.button1Text)
        }
        Button(onClick = viewState1.onClick2) {
            Text(text = viewState1.button2Text)
        }
        Button(onClick = viewState1.dialogState.displayDialog) {
            Text(text = viewState1.dialogState.dialogText)
        }
        if (viewState1.dialogState.isDisplayDialog) {
            DisplayDialog(viewState1.dialogState)
        }
    }
}

@Composable
fun State2(viewState2: ScreenViewState.State2ViewState) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = viewState2.title)
        Image(painter = painterResource(viewState2.imageID), contentDescription = null)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = viewState2.onClick) {
            Text(text = viewState2.buttonText)
        }
    }
}

@Composable
fun State3(viewState3: ScreenViewState.State3ViewState){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ComplexCard(viewState3)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = viewState3.onClick){
            Text(text = viewState3.buttonText)
        }
    }
}

@Composable
fun ComplexCard(viewState3: ScreenViewState.State3ViewState) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = androidx.compose.material3.CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = viewState3.imageID),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = viewState3.title,
                fontSize = 20.sp,
                color = Color.Black
            )
            Text(
                text = viewState3.subtitle,
                fontSize = 16.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = viewState3.description,
                fontSize = 14.sp,
                color = Color.DarkGray
            )
        }
    }
}

