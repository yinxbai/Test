import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private int age;
    private String email;
}