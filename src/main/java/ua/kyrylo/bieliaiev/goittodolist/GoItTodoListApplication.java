package ua.kyrylo.bieliaiev.goittodolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.kyrylo.bieliaiev.goittodolist.model.Note;
import ua.kyrylo.bieliaiev.goittodolist.model.User;
import ua.kyrylo.bieliaiev.goittodolist.repository.UserRepository;
import ua.kyrylo.bieliaiev.goittodolist.service.NoteService;

@SpringBootApplication
public class GoItTodoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoItTodoListApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(NoteService noteService,
                                               UserRepository userRepository,
                                               PasswordEncoder passwordEncoder) {
        return args -> {
            noteService.add(new Note("Note 1", "Important note 1"));
            noteService.add(new Note("Note 2", "Not important note 2"));
            userRepository.save(new User("kyrylo", passwordEncoder.encode("jdbcDefault")));
        };
    }
}
