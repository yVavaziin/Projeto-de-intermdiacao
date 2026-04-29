package com.vagner.meuprojetoapi;

import com.vagner.meuprojetoapi.models.TipoUsuario;
import com.vagner.meuprojetoapi.models.Usuario;
import com.vagner.meuprojetoapi.repositories.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MeuProjetoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeuProjetoApiApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository repository) {
        return args -> {
            // Agora verifica pelo novo e-mail que você escolheu
            if (repository.findByEmail("admin123@admin.com") == null) {
                Usuario admin = new Usuario();
                admin.setNome("Administrador");
                admin.setEmail("admin123@admin.com"); // Ajustado aqui
                admin.setSenha("admin123");           // Ajustado aqui
                admin.setTipo(TipoUsuario.ADMIN);

                repository.save(admin);
                System.out.println("✅ Usuário ADMIN criado: admin123@admin.com / admin123");
            }
        };
    }
}