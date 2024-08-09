package ma.entraide.handicap.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    public UserInfo(Integer id, String name, @Email String email, String roles, @Size(min = 6) String password,
			Province province) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.roles = roles;
		this.password = password;
		this.province = province;
	}

	public UserInfo(String name, @Email String email, String roles, @Size(min = 6) String password) {
		super();
		this.name = name;
		this.email = email;
		this.roles = roles;
		this.password = password;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@Column(nullable = false)
    private String name;

    @Column(unique=true)
    @Email
    private String email;

    @Column(nullable = false)
    private String roles;

    @Column(nullable = false)
    @Size(min = 6)
    private String password;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "province_id")
    private Province province;

	public UserInfo() {
		super();
	}




}
