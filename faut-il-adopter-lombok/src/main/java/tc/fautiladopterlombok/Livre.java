package tc.fautiladopterlombok;

import java.util.Objects;

public class Livre {

    private String name;

    public Livre(String name) {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    @Override
    public String toString()
    {
        return "Livre(name="+this.name+")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livre livre = (Livre) o;
        return name.equals(livre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
