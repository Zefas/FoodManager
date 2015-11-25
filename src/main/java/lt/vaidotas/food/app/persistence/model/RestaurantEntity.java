package lt.vaidotas.food.app.persistence.model;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "restaurant")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<MenuItemEntity> menuItems;

    public RestaurantEntity() {
    }

    public RestaurantEntity(Integer id, String name, Set<MenuItemEntity> menuItems) {
        this.id = id;
        this.name = name;
        this.menuItems = menuItems;
    }

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

    public Set<MenuItemEntity> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Set<MenuItemEntity> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .toString();
    }
}
