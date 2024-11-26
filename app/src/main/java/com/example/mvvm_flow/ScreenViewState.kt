sealed class ScreenViewState{

    data class DialogState(
        val isDisplayDialog: Boolean,
        val displayDialog: () -> Unit,
        val cancelDialog: () -> Unit,
        val dialogText: String,
        val cancelText: String
    )

    data class State1ViewState(
        val title: String,
        val button1Text: String,
        val button2Text: String,
        val onClick1: () -> Unit,
        val onClick2: () -> Unit,
        val dialogState: DialogState
    ) : ScreenViewState()


    data class State2ViewState(
        val title: String,
        val buttonText: String,
        val onClick: () -> Unit,
        val imageID: Int,
        val description: String?,
    ) : ScreenViewState()

    data class State3ViewState(
        val title: String,
        val subtitle: String,
        val description: String,
        val imageID: Int,
        val imageDescription: String,

        val onClick: () -> Unit,

        val buttonText: String,
    ) : ScreenViewState()
}