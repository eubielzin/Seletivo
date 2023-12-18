package Universidade.dto.request;


import java.util.Date;

public class CursoRegistro {
    private Integer idC;

    private  String nomeDoCurso;

    private String cargaHoraria;
    private Date dataDeCadastroC;
    private String codigoDoCurso;


    public String getNomeDoCurso() {
        return nomeDoCurso;
    }

    public void setNomeDoCurso(String nomeDoCurso) {
        this.nomeDoCurso = nomeDoCurso;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Date getDataDeCadastroC() {
        return dataDeCadastroC;
    }

    public void setDataDeCadastroC(Date dataDeCadastroC) {
        this.dataDeCadastroC = dataDeCadastroC;
    }

    public String getCodigoDoCurso() {
        return codigoDoCurso;
    }

    public void setCodigoDoCurso(String codigoDoCurso) {
        this.codigoDoCurso = codigoDoCurso;
    }
}
