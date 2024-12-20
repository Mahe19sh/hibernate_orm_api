package controller;

import java.util.List;

import entityclasses.Students;
import entityclasses.Teachers;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.Servicestudent;

@Path("/students")
public class Controller {
    private Servicestudent studentService;

    public Controller(Servicestudent studentService) {
        this.studentService = studentService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllStudentsByAge(@QueryParam("age") int age) {
        List<Students> students = studentService.getAllStudentsByAge(age);
        return Response.ok(students).build();
    }

    @GET
    @Path("/{id}/teacher")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeacherByStudentId(@PathParam("id") int studentId) {
        Teachers teacher = studentService.getTeacherByStudentId(studentId);
        return teacher != null ? Response.ok(teacher).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveOrUpdateStudent(Students student) {
        studentService.saveOrUpdateStudent(student);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") int studentId) {
        studentService.deleteStudentById(studentId);
        return Response.noContent().build();
    }
}
