package entityclasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(nullable = false)
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teachers teacher;

}
