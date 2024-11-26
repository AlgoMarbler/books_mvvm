import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mvvm_flow.R

class ScreenViewModel : ViewModel() {
    private var _screenViewState : ScreenViewState by mutableStateOf(
        ScreenViewState.State1ViewState(
            title = "state 1",
            button1Text = "move to state2",
            button2Text = "move to state3",
            onClick1 = ::moveToState2,
            onClick2 = ::moveToState3,
            dialogState = ScreenViewState.DialogState(
                isDisplayDialog = false,
                displayDialog = ::displayDialog,
                cancelDialog = ::cancelDialog,
                dialogText = "display dialog",
                cancelText = "cancel"
            )
        )

    )

    //Shadow
    val screenViewState: ScreenViewState
        get() = _screenViewState



    private fun moveToState2() {
        _screenViewState = ScreenViewState.State2ViewState(
            title = "state 2",
            buttonText = "move to state1",
            onClick = ::moveToState1,
            imageID = R.drawable.legendary,
            description = null,
        )
    }

    private fun moveToState3() {
        _screenViewState = ScreenViewState.State3ViewState(
            title = "purple book",
            subtitle = "very shiny",
            description = "it is also very heavy",
            buttonText = "move to state1",
            onClick = ::moveToState1,
            imageID = R.drawable.epic,
            imageDescription = "another book",
        )
    }

    private fun moveToState1() {
        _screenViewState = ScreenViewState.State1ViewState(
            title = "state 1",
            button1Text = "move to state2",
            button2Text = "move to state3",
            onClick1 = ::moveToState2,
            onClick2 = ::moveToState3,
            dialogState = ScreenViewState.DialogState(
                isDisplayDialog = false,
                displayDialog = ::displayDialog,
                cancelDialog = ::cancelDialog,
                dialogText = "display dialog",
                cancelText = "cancel"
            )
        )
    }

    private fun displayDialog() {
        val currentState = _screenViewState as ScreenViewState.State1ViewState
        _screenViewState = currentState.copy(
            dialogState = currentState.dialogState.copy(
                isDisplayDialog = true
            )
        )
    }

    private fun cancelDialog() {
        val currentState = _screenViewState as ScreenViewState.State1ViewState
        _screenViewState = currentState.copy(
            dialogState = currentState.dialogState.copy(
                isDisplayDialog = false
            )
        )
    }

}