package guide.tm.domain.model.customer;

public class CustomerName {
    Name name;
    Name nameKana;

    public CustomerName() {
        this(new Name(""), new Name(""));
    }

    public CustomerName(Name name, Name nameKana) {
        this.name = name;
        this.nameKana = nameKana;
    }

    public Name name() {
        return name;
    }

    public Name nameKana() {
        return nameKana;
    }
}
