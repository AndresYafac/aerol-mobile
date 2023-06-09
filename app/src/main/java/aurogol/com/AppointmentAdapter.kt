package aurogol.com

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import aurogol.com.model.Appointment
import kotlinx.android.synthetic.main.item_appointment.view.*

class AppointmentAdapter(private val appointments: ArrayList<Appointment>)
    : RecyclerView.Adapter<AppointmentAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(appointment: Appointment) =  with(itemView){
                tvAppointmentId.text = itemView.context.getString(R.string.item_appointment_id, appointment.id)
                tvCanchaName.text = appointment.canchaName
                tvScheduleDate.text = itemView.context.getString(R.string.item_appointment_date,appointment.scheduleDate)
                tvScheduleTime.text = itemView.context.getString(R.string.item_appointment_time,appointment.scheduleTime)
        }
    }

    //Inflates XML items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_appointment,parent,false)
        )
    }

    //Binds data
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val appointment = appointments[position]

        holder.bind(appointment)
    }

    //Number of element
    override fun getItemCount() = appointments.size


}