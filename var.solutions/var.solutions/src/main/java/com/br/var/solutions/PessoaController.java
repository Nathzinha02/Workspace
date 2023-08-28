package com.br.var.solutions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "*")
@Slf4j
public class PessoaController {
//          1        /        2        /       3         /     4
    //public/privado //tipo de retorno // nome do método //parãmetros

    //Endpoint

    @GetMapping
    public ResponseEntity<Object> get() {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Nathalia");
        pessoa1.setSobrenome("Barrochello");
        pessoa1.setEndereco("Rua Wenwe Goldberg, 157");
        pessoa1.setIdade(17);

        return ResponseEntity.ok(pessoa1);
    }

    @GetMapping("/resumo")
    public ResponseEntity<Object> getPessoa(@RequestBody Pessoa pessoinha) {
        String imc = null;
        int anoNascimento = 0;
        String impostoRenda = null;
        String validaMundial = null;
        if (!pessoinha.getNome().isEmpty()) {

            log.info("Iniciando o proccesso de resumo da pessoa: ", pessoinha);

            if (Objects.nonNull(pessoinha.getPeso()) && Objects.nonNull(pessoinha.getAltura()));{
                log.info("iniciando o calculo IMC");
                imc = calculaImc(pessoinha.getPeso(), pessoinha.getAltura());

            }

            if (Objects.nonNull(pessoinha.getIdade())) {
                log.info("Iniciando o calculo do ano de nascimento");
                anoNascimento = calculaAnoNascimento(pessoinha.getIdade());

            }

            if (Objects.nonNull(pessoinha.getSalario())) {

                log.info("Iniciando o calculo do impostode renda");
                impostoRenda = calculandoFaixaImpostoRenda(pessoinha.getSalario());
            }
            if (Objects.nonNull(pessoinha.getTime())) {

                log.info("Validando se o time de coração tem Mundial");
                String validaMundial = calculaMundial(pessoinha.getTime());
            }

            if (Objects.nonNull(pessoinha.getIdade())) {

                log.info("Montar objeto de retorno para o front ");
                Object resumo = montarRespostaFrontEnd(imc, anoNascimento, impostoRenda, validaMundial);

                return ResponseEntity.ok(resumo);
            }
        }

            return ResponseEntity.noContent().build();
        }
        private Object montarRespostaFrontEnd(String imc, int anoNascimento, String impostoRenda, String validaMundial) {

    }

    private String calculaMundial(String time) {

    }

    private String calculandoFaixaImpostoRenda(double salario) {

    }

    private int calculaAnoNascimento(int idade) {

    }

    private String calculaImc(float peso, float altura) {


    }

    
}

