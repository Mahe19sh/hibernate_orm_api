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
@Table(name = "students")
public class Students {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = true)
    private Teachers teacher;

}
