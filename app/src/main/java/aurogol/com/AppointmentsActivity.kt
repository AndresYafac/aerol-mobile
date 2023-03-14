package aurogol.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import aurogol.com.model.Appointment
import kotlinx.android.synthetic.main.activity_appointments.*

class AppointmentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointments)

        val appointments = ArrayList<Appointment>()
        appointments.add(
            Appointment(1,"Cancha Fúltbol","12/12/23","3:00 PM")
        )
        appointments.add(
            Appointment(2,"Cancha Voley","15/12/23","4:00 PM")
        )
        appointments.add(
            Appointment(3,"Cancha Basquet","17/12/23","5:00 PM")
        )

        rvAppointments.layoutManager = LinearLayoutManager(this)
        rvAppointments.adapter =  AppointmentAdapter(appointments)
    }
}