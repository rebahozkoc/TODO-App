import android.os.Parcelable
import com.example.todoapp.model.TodoState
import kotlinx.parcelize.Parcelize
@Parcelize
data class TodoModel(
    val title: String,
    val description: String,
    val createdDate: String,
    val status: TodoState
): Parcelable