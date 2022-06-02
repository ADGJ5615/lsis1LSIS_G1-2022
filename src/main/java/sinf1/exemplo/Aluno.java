package sinf1.exemplo;

/**
 *
 * @author Misterio
 */

public class Aluno {

    public Aluno(){nome="X"; email="Y"; numero=0;}
    public Aluno(String nome, String email, int numero) {
        this.nome = nome;
        this.email = email;
        this.numero = numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    String nome, email;
    int numero;

// necessário ser public para enviar como JSON
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "{" + "\"nome\":\"" + nome + "\", \"email\":\"" + email + "\", \"numero\":\"" + numero + "\"}";
    }

    
    
}

