package org.swe_group.ice_tracker.inventory_management;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Getter
@Setter
public class Product {
    @NotNull(message = "Product flavor cannot be null")
    private String flavor;

    @NotNull(message = "Package size cannot be null")
    private String packageSize;

    // Override equals and hashCode for use in collections
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return flavor.equals(product.flavor) && packageSize.equals(product.packageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flavor, packageSize);
    }
}
