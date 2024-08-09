package ma.entraide.handicap.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TypeHandicap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "handicap_id")
    private Long id;

    public TypeHandicap() {
		super();
	}

	public TypeHandicap(Long id, String handicap) {
		super();
		this.id = id;
		this.handicap = handicap;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHandicap() {
		return handicap;
	}

	public void setHandicap(String handicap) {
		this.handicap = handicap;
	}

	private String handicap;
}
