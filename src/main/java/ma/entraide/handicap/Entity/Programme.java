package ma.entraide.handicap.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Programme {
    public Long getId() {
		return id;
	}

	public Programme(Long id, String programmeName) {
		super();
		this.id = id;
		this.programmeName = programmeName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProgrammeName() {
		return programmeName;
	}

	public void setProgrammeName(String programmeName) {
		this.programmeName = programmeName;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "programme_id")
    private Long id;

    public Programme() {
		super();
	}

	private String programmeName;
}
