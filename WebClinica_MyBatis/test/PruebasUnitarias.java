
import com.java.dao.DoctorDao;
import com.java.dao.EspecialidadDao;
import com.java.dao.HoraDao;
import com.java.dao.HorarioAtencionDrDao;
import com.java.pojos.Doctor;
import com.java.pojos.Especialidad;
import com.java.pojos.Hora;
import com.java.pojos.HorarioAtencionDr;
import java.sql.Time;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JuanVillanueva
 */
public class PruebasUnitarias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
//        EspecialidadDao dao = new EspecialidadDao();
//        Especialidad especialidad = new Especialidad();
//        especialidad.setId(5000000);
//        especialidad.setNombre("Medicina");
//        dao.update(especialidad);

//        DoctorDao dao = new DoctorDao();
//        Doctor doctor = new Doctor();
//        doctor.setId(Integer.parseInt("-1"));
//        doctor.setNombre("Juan");
//        doctor.setAp_paterno("Villanueva");
//        doctor.setAp_materno("Aguinaga");
//        doctor.setId_especialidad(Integer.parseInt("5000000"));
//        dao.create(doctor);
//        
        EspecialidadDao espDao = new EspecialidadDao();
        List<Especialidad> especialidades = espDao.list();
        for (Especialidad e : especialidades) {
            System.out.println(e.getId() + " " + e.getNombre());
        }
//        System.out.println("");
//        System.out.println(getEspecialidadById(especialidades, 5000002));
        System.out.println("333");
        
//                DoctorDao dao = new DoctorDao();
//        Doctor doctor = new Doctor();
//        doctor.setId(-1);
//        doctor.setNombre("zaa");
//        doctor.setAp_paterno("zaa");
//        doctor.setAp_materno("zaa");
//        doctor.setEspecialidad(new Especialidad());
//        doctor.getEspecialidad().setId(Integer.parseInt("5000002"));
//        dao.create(doctor);
//        

        
//        HoraDao espDao = new HoraDao();
//        Hora hora = new Hora();
//        hora.setId(-1);
//        hora.setHora(Time.valueOf("23:30:50"));
//        espDao.create(hora);
//        
//        List<Hora> horas = espDao.list();
//        for (Hora h : horas) {
//            System.out.println(h.getId() + " - " + h.getHora());
//        }
//        
//        HorarioAtencionDrDao hadDao = new HorarioAtencionDrDao();
//        HorarioAtencionDr horaAD = new HorarioAtencionDr();
//        horaAD.setId(-1);
//        horaAD.setIdDoctor(5000000);
//        horaAD.setDia(1);
//        horaAD.setHoraInicio(Time.valueOf("23:30:50"));
//        horaAD.setHoraFin(Time.valueOf("23:30:50"));
//        horaAD.setNumeroConsultorio(123);
//        hadDao.create(horaAD);
//        
//        List<HorarioAtencionDr> horas = hadDao.list();
//        for (HorarioAtencionDr h : horas) {
//            System.out.println(h.getId() + " - " + h.getIdDoctor() + " - " + h.getDia() + " - " + h.getHoraInicio() + " - " + h.getHoraInicio()+ " - " + h.getNumeroConsultorio());
//        }
//        
    }

}
