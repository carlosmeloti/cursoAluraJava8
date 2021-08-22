package classes;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;


class Curso{
    
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAlunos() {
        return alunos;
    }

    public void setAlunos(int alunos) {
        this.alunos = alunos;
    }
    
    
}
public class ExemploCurso {
	
	
public static void main(String[] args) {
        
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 155));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));
        
        int sum = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .sum();
        
        OptionalDouble media = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .average();
        
        
        System.out.println(sum);
        System.out.println(media.getAsDouble());
        
        System.out.println("----===----");
        
        Optional<Curso> optionalCurso = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .findAny();
        
        /*Curso curso = optionalCurso.orElse(null);
        System.out.println(curso.getNome());*/
        
        optionalCurso.ifPresent(c -> System.out.println(c.getNome()));
        
        cursos = cursos.stream()
        		.filter(c -> c.getAlunos() >= 100)
        		.collect(Collectors.toList());
        
        System.out.println("-------");
        for(Curso c : cursos) {
        	System.out.println(c.getNome());
        }
        
        System.out.println("--------");
        
        cursos.stream()
        	.filter(c -> c.getAlunos() >= 100)
        	.collect(Collectors.toMap(
        			c -> c.getNome(), 
        			c -> c.getAlunos()))
        	.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
        

}
  
        
    }
    


