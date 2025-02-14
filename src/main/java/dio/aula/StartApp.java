package dio.aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component; // Adicione essa importação

import dio.aula.model.User;
import dio.aula.repository.UserRepository;

@Component // Isso faz com que o Spring reconheça essa classe automaticamente
public class StartApp implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        
        User user = new User();
        user.setName("Gabriel");
        user.setUsername("GabrielRosa");
        user.setPassword("senhaforte123");

        repository.save(user);

        for (User u : repository.findAll()) {
            System.out.println(u);
        }
    }
}