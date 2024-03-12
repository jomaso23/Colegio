package ar.org.centro8.colegio.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.org.centro8.colegio.entities.Alumno;
import ar.org.centro8.colegio.entities.Curso;
import ar.org.centro8.colegio.repositories.AlumnoRepository;
import ar.org.centro8.colegio.repositories.CursoRepository;

@Controller
public class ControllerWeb {

    @Autowired
    private CursoRepository cr;

    @Autowired
    private AlumnoRepository ar;

    private String mensajeCurso = "Ingrese un nuevo curso!";

    private String mensajeAlumno = "Ingrese un nuevo alumno!";

    @GetMapping("/")
    public String getIndex(Model model) {

        return "inicio";
    }

    @GetMapping("/cursos")
    public String cursos(
            @RequestParam(name = "buscar", defaultValue = "", required = false) String buscar,
            Model model) {
        model.addAttribute("mensajeCurso", mensajeCurso);
        model.addAttribute("curso", new Curso());
        model.addAttribute("listacursos", ((List<Curso>) cr.findAll())
                .stream()
                .filter(c -> c.getTitulo().toLowerCase().contains(buscar.toLowerCase())));
        return "cursos";
    }

    @GetMapping("/alumnos")
    public String alumnos(
        @RequestParam(name="buscar", defaultValue = "", required = false) String buscar,
        Model model){
        model.addAttribute("mensajeAlumno", mensajeAlumno);
        model.addAttribute("alumno", new Alumno());
        model.addAttribute("listaAlumnos", ((List<Alumno>)ar.findAll())
                  .stream()
                  .filter(a->a.getNombre().toLowerCase().contains(buscar.toLowerCase())
                          || a.getApellido().toLowerCase().contains(buscar.toLowerCase()))
        );
        model.addAttribute("curso", new Curso());
        model.addAttribute("listacursos", cr.findAll());

        Map<Integer, Curso> mapaCurso=new LinkedHashMap();
        cr
            .findAll()
            .forEach(c->mapaCurso.put(c.getId(), c));
        model.addAttribute("mapaCurso", mapaCurso);
        Map<Integer, Alumno> mapaAlumno=new LinkedHashMap();
        ar
            .findAll()
            .forEach(a->mapaAlumno.put(a.getId(), a));
        model.addAttribute("mapaAlumno", mapaAlumno);   
           
        return "alumnos";
    }

    @PostMapping("/savecurso")
    public String save(@ModelAttribute Curso curso) {

        cr.save(curso);
        if (curso.getId() > 0) {
            mensajeCurso = "Se guardo el curso con id: " + curso.getId() + "!";
        } else {
            mensajeCurso = "No se pudo guardar el curso";
        }
        return "redirect:/cursos";
    }

    @PostMapping("/savealumno")
    public String save(
            @RequestParam(name = "curso", defaultValue = "", required = false) String curso,
            @ModelAttribute Alumno alumno) {

        alumno.setIdCurso(Integer.parseInt(curso));
        ar.save(alumno);

        if (alumno.getId() > 0) {
            mensajeAlumno = "Se guardo el alumno con id: " + alumno.getId() + "!";
        } else {
            mensajeAlumno = "No se pudo guardar el alumno";
        }

        return "redirect:/alumnos";
    }

}
