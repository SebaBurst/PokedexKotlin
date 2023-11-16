package fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pokedex.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class PokeWatchFragment : Fragment() {
    private lateinit var pokeWatchView: TextView //TextView que muestra el tiempo
    private var PokeHandler: Handler? = null


    //DFuncion que ejecuta el hilo ccada un segundo
    private val RunnableThread = object : Runnable {
        override fun run() {
            updateTime()
            PokeHandler?.postDelayed(this, 1000)
        }
    }


    private fun startClock() {
        // Crea el hilo para actualizar el reloj
        PokeHandler = Handler(Looper.getMainLooper())
        PokeHandler?.post(RunnableThread)
    }

    //funcion que actualiza constantemente el timpo, obteniendo el tiempo local.
    private fun updateTime() {
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val formattedDate: String = dateFormat.format(currentDate)
        pokeWatchView.text = formattedDate // Actualiza el TextView con la hora actual
    }

    override fun onDestroyView() {
        super.onDestroyView()
        PokeHandler?.removeCallbacks(RunnableThread)
        PokeHandler = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_poke_watch, container, false)
        pokeWatchView = view.findViewById(R.id.pokeReloj)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startClock()
    }
}