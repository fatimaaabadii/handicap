package ma.entraide.handicap.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceOffert {
    public ServiceOffert(Long id, String serviceName) {
		super();
		this.id = id;
		this.serviceName = serviceName;
	}

	public Long getId() {
		return id;
	}

	public ServiceOffert() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long id;

    private String serviceName;
}
