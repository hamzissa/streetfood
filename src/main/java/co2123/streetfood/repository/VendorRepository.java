package co2123.streetfood.repository;

import co2123.streetfood.model.Vendor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VendorRepository extends CrudRepository<Vendor, Integer> {
    Vendor findByName(String name);
    List<Vendor> findByNameContainingIgnoreCase(String namePart);
    List<Vendor> findByDishesNameContainingIgnoreCase(String dishNamePart);
}
