package ma.entraide.handicap.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Etablissement {
    public Long getId() {
		return id;
	}

	public Etablissement(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Etablissement() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "etablissement_id")
    private Long id;

    private String name;
}
