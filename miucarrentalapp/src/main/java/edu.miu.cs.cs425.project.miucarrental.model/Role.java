    package edu.miu.cs.cs425.project.miucarrental.model;

    import javax.persistence.*;
    import javax.validation.constraints.NotBlank;
    import java.util.List;
    @Entity
    @Table(name = "roles")
    public class Role {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Integer roleId;

            @Column(nullable=false, unique=true)
            @NotBlank
            private String name;


            @Column(nullable = true)
            @ManyToMany(mappedBy="roles")
            private List<User> users;

            public Role() {
            }

            public Role(Integer roleId, String name) {
                this.roleId = roleId;
                this.name = name;
            }

            public Role(String name) {

            this.name = name;
              }

            public Integer getRoleId() {
                return roleId;
            }

            public void setRoleId(Integer roleId) {
                this.roleId = roleId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<User> getUsers() {
                return users;
            }

            public void setUsers(List<User> users) {
                this.users = users;
            }

    }
