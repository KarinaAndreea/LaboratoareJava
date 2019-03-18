package cofg;

public class Graph {
    private String name;
    private String description;
    private String definition;//tgf
    private String image;//svg

    public Graph(String name, String description, String definition, String image) {
        this.name = name;
        this.description = description;
        this.definition = definition;
        this.image = image;
    }

    public Graph(String name, String definition, String image) {
        this.name = name;
        this.definition = definition;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDefinition() {
        return definition;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "name='" + name + '\'' +
                ", definition='" + definition + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
