package Universidade.Model;



import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Alunos")
public class Alunos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "Endereco")
    private String endereco;
    @Column(name = "Cep")
    private String cep;
    @Column(name = "Email")
    private String email;
    @Column(name = "Telefone")
    private String numeroDeTelefone;
    @Column(name = "Data_De_CadastroA")
    private Date dataDeCadastroA;
    @Column(name = "Senha_De_Cadastro")
    private String codigoDoAluno;


    @ManyToOne
    @JoinColumn (name = "Curso")
    private Cursos Id_Curso;

    public Alunos() {
    }


    public Alunos(Integer id, String nome, String cpf, String endereco, String cep, String email, String numeroDeTelefone, Date dataDeCadastroA, String codigoDoAluno, Cursos id_Curso) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cep = cep;
        this.email = email;
        this.numeroDeTelefone = numeroDeTelefone;
        this.dataDeCadastroA = dataDeCadastroA;
        this.codigoDoAluno = codigoDoAluno;
        Id_Curso = id_Curso;
    }

    public String getCodigoDoAluno() {
        return codigoDoAluno;
    }

    public void setCodigoDoAluno(String codigoDoAluno) {
        this.codigoDoAluno = codigoDoAluno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroDeTelefone() {
        return numeroDeTelefone;
    }

    public void setNumeroDeTelefone(String numeroDeTelefone) {
        this.numeroDeTelefone = numeroDeTelefone;
    }

    public Date getDataDeCadastroA() {
        return dataDeCadastroA;
    }

    public void setDataDeCadastroA(Date dataDeCadastroA) {
        this.dataDeCadastroA = dataDeCadastroA;
    }

    public Cursos getId_Curso() {
        return Id_Curso;
    }

    public void setId_Curso(Cursos id_Curso) {
        Id_Curso = id_Curso;
    }
}
