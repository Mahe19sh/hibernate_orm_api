package entityclasses;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

import lombok.Data;

@Data
@Entity
@Table(name = "teachers")
public class Teachers {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String subject;

    @OneToMany(mappedBy = "teacher")
    private List<Students> students = new ArrayList<>();

    @OneToMany(mappedBy = "teacher")
    private List<Courses> courses = new ArrayList<>();

}
