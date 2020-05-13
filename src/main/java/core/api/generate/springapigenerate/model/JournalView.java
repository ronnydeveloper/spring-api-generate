package core.api.generate.springapigenerate.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "JOURNAL_VIEW")
public class JournalView { 

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String name;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() { 
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() { 
        return name;
    }

    @Override
    public String toString() {
        return "JournalView{" + 
                  "id=" + id + 
                  ", name='" + name+ "\'" + 
                 '}';
    }
} 