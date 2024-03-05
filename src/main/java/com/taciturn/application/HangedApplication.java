package com.taciturn.application;

import com.taciturn.services.HangedService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication(scanBasePackages = "com.taciturn")
public class HangedApplication {
    public static void main(String[] args){
        SpringApplication.run(HangedApplication.class, args);
    }

    @Bean
    public CommandLineRunner hangedManLineRunner(HangedService hangedService){
        return args -> {
            hangedService.startHanged();
            Scanner scanner = new Scanner(System.in);
            while (!hangedService.isFinished()){
                System.out.println("Palabra: " + new String(hangedService.getHangedState().getProgress()));
                System.out.println("Intentos restantes: " + hangedService.getHangedState().getRemainingAttempts());
                System.out.print("Introduce una letra, por favor: ");
                String line = scanner.nextLine();

                if (!line.isEmpty()) {
                    hangedService.processTry(line.charAt(0));
                }
            }

            if (hangedService.isWon()) {
                System.out.println("¡Congratulaciones! La palabra era: " + hangedService.getHangedState().getAnswer());
            }
        };
    }
}
