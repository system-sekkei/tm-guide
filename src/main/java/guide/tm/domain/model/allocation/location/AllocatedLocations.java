package guide.tm.domain.model.allocation.location;

import guide.tm.domain.model.primitive.Quantity;

import java.util.ArrayList;
import java.util.List;

/**
 * 引当場所のリスト
 */
public class AllocatedLocations {

    List<AllocatedLocation> list;

    public AllocatedLocations() {
        this(new ArrayList<>());
    }

    public AllocatedLocations(List<AllocatedLocation> list) {
        this.list = list;
    }

    public Quantity allocatedQuantity() {
        return list.stream()
                .map(AllocatedLocation::allocatedQuantity)
                .reduce(Quantity::add)
                .orElse(new Quantity(0));
    }

    public List<AllocatedLocation> list() {
        return list;
    }
}
