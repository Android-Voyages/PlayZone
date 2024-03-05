
import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.odyssey.StoredViewModel


@Composable
fun AdminEvents(){
	StoredViewModel({AdminEventsViewModel()}){viewModel->
	}
}