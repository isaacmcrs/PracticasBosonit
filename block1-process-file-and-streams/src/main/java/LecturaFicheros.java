
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LecturaFicheros {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java FileProcessor <file_path>");
            return;
        }
        String filePath = args[0];
        try {
            List<Person> people = LeerCsv(filePath);
            System.out.println("Todas las personas:");
            people.forEach(System.out::println);
            int filterAge = 25; // Cambiar a la edad correspondiente por la que queremos filtrar, si acaso cambiar el mayor igual del metodo
            List<Person> filteredPeople = filterPeopleByAge(people, filterAge);
            System.out.println("\nPersonas con edad " + filterAge + ":");
            filteredPeople.forEach(System.out::println);
            Optional<Person> primeraPersonaDeMadridMenorDe25 = LecturaFicheros.obtenerPrimeraPersonaDeMadridMenorDe25(people);
            if (primeraPersonaDeMadridMenorDe25.isPresent()) {
                System.out.println("Primera persona de Madrid menor de 25 años: " + primeraPersonaDeMadridMenorDe25.get());
            } else {
                System.out.println("No se encontró ninguna persona de Madrid menor de 25 años.");
            }
            Optional<Person> primeraPersonaDeBarcelonaMenorDe25 = LecturaFicheros.obtenerPrimeraPersonaDeBarcelonaMenorDe25(people);
            if (primeraPersonaDeBarcelonaMenorDe25.isPresent()) {
                System.out.println("Primera persona de Barcelona menor de 25 años: " + primeraPersonaDeBarcelonaMenorDe25.get());
            } else {
                System.out.println("No se encontró ninguna persona de Barcelona menor de 25 años.");
            }
            List<Person> PersonasconlaA = filtrarPersonasConA(people);
            System.out.println("\nPersonas con A en su nombre :");
            PersonasconlaA.forEach(System.out::println);

        } catch (Error e) {
            e.printStackTrace();
        }
    }

    public static List<Person> LeerCsv(String file) throws Error {
        List<Person> personas = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(file));
            for (String line : lines) {
                Person Person = parseLine(line);
                personas.add(Person);
            }
        } catch (Error e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return personas;
    }
    public static List<Person> filterPeopleByAge(List<Person> personas, int age) {
        return personas.stream()
                .filter(Person -> Person.getAge() <= age)
                .collect(Collectors.toList());
    }
    private static Person parseLine(String line) throws Error {
        String[] parts = line.split(":");
        if (parts.length != 3) {
            throw new Error("Formato de linea incorrecto en la linea: " + line, null);
        }
        String name = parts[0];
        String town = parts.length >= 2 ? parts[1] : "";
        int age = parts.length >= 3 ? Integer.parseInt(parts[2]) : 0;
        if (age == 0) {
            // Age unknown
            throw new Error("Edad desconocida en la linea: " + line, null);
        }
        return new Person(name, town, age);
    }
    public static Optional<Person> obtenerPrimeraPersonaDeMadridMenorDe25(List<Person> personas) {
        return personas.stream()
                .filter(person -> person.getAge() < 25 && person.getTown().equalsIgnoreCase("Madrid"))
                .findFirst();
    }
    public static Optional<Person> obtenerPrimeraPersonaDeBarcelonaMenorDe25(List<Person> personas) {
        return personas.stream()
                .filter(person -> person.getAge() < 25 && person.getTown().equalsIgnoreCase("Barcelona"))
                .findFirst();
    }
    private static List<Person> filtrarPersonasConA(List<Person> listaPersonas) {
        List<Person> personas;
        Pattern pattern = Pattern.compile("^[aAáÁ].*");
        return listaPersonas.stream().filter(persona -> !pattern.matcher(persona.getName()).find()).collect(Collectors.toList());
    }
}





