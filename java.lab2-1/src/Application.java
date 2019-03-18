import java.time.LocalDate;
public class Application extends Project {
    public enum Language{//colectie de constante
        JAVA,PYTHON,RUBY,C,GO;
    }

    private Language language;


    public Application(String name, LocalDate deadline, Language language) {
        super(name, deadline);
        this.language = language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Language getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "Application{" +
                "language=" + language +
                ", name='" + name + '\'' +
                ", deadline=" + deadline +
                '}';
    }

}
