import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todoapp.model.TodoState
import kotlinx.parcelize.Parcelize

@Entity(tableName = "task_data_table")
@Parcelize
data class TodoModel(
    @ColumnInfo(name = "task_data_title")
    val title: String,
    @ColumnInfo(name = "task_data_description")
    val description: String,
    @ColumnInfo(name = "task_data_date")
    val createdDate: String,
    @ColumnInfo(name = "task_data_status")
    val status: TodoState,
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
): Parcelable